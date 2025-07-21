package minidsaproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.JSONObject;

class Stock {
    private String symbol;
    private Map<String, Double> dailyPrices;

    public Stock(String symbol) {
        this.symbol = symbol;
        this.dailyPrices = new LinkedHashMap<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public Map<String, Double> getDailyPrices() {
        return dailyPrices;
    }

    public void setDailyPrices(Map<String, Double> dailyPrices) {
        this.dailyPrices = dailyPrices;
    }

    public void displayPrices() {
        System.out.println("\n📊 Stock Prices for " + symbol + ":\n");
        for (Map.Entry<String, Double> entry : dailyPrices.entrySet()) {
            System.out.println("Date: " + entry.getKey() + ", Close Price: $" + entry.getValue());
        }
    }

    // SMA using Sliding Window
    public List<Double> calculateSimpleMovingAverage(int period) {
        List<Double> prices = new ArrayList<>(dailyPrices.values());
        List<Double> smaList = new ArrayList<>();

        if (prices.size() < period) {
            System.out.println("Not enough data to calculate SMA for period " + period);
            return smaList;
        }

        double sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
            if (i >= period) sum -= prices.get(i - period);
            if (i >= period - 1) smaList.add(sum / period);
        }

        return smaList;
    }

    //  Max Heap for Top K prices
    public List<Double> getTopKClosingPrices(int k) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(dailyPrices.values());

        List<Double> topPrices = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topPrices.add(maxHeap.poll());
        }
        return topPrices;
    }

    // Greedy Algorithm for Best Buy/Sell
    public void bestDayToBuyAndSell() {
        List<String> dates = new ArrayList<>(dailyPrices.keySet());
        List<Double> prices = new ArrayList<>(dailyPrices.values());

        if (prices.size() < 2) {
            System.out.println("Not enough data to determine buy/sell days.");
            return;
        }

        double minPrice = prices.get(0);
        int minDay = 0;
        double maxProfit = 0;
        int buyDay = 0, sellDay = 0;

        for (int i = 1; i < prices.size(); i++) {
            double profit = prices.get(i) - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
                buyDay = minDay;
                sellDay = i;
            }

            if (prices.get(i) < minPrice) {
                minPrice = prices.get(i);
                minDay = i;
            }
        }

        if (maxProfit <= 0) {
            System.out.println("No profit opportunity. Prices are decreasing.");
        } else {
            System.out.println("\n💰 Best Buy/Sell Strategy (Greedy Approach):");
            System.out.println("Buy on " + dates.get(buyDay) + " at $" + prices.get(buyDay));
            System.out.println("Sell on " + dates.get(sellDay) + " at $" + prices.get(sellDay));
            System.out.printf("Max Profit = $%.2f\n", maxProfit);
        }
    }
}


class StockManagement {
    private static final String API_KEY = "R4IKWVAOVDEPDGBQ";

    public static Map<String, Double> fetchDailyPrices(String symbol) {
        Map<String, Double> dateToPrice = new TreeMap<>(Collections.reverseOrder());

        try {
            String urlStr = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                    + symbol.trim() + "&apikey=" + API_KEY ;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
            in.close();

            JSONObject json = new JSONObject(response.toString());

            if (!json.has("Time Series (Daily)")) {
                System.out.println("API limit reached or invalid symbol.");
                return null;
            }

            JSONObject timeSeries = json.getJSONObject("Time Series (Daily)");
            for (String date : timeSeries.keySet()) {
                JSONObject dayData = timeSeries.getJSONObject(date);
                double closePrice = Double.parseDouble(dayData.getString("4. close"));
                dateToPrice.put(date, closePrice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateToPrice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stock symbol (e.g., AAPL): ");
        String symbol = sc.nextLine().toUpperCase();

        Stock stock = new Stock(symbol);
        Map<String, Double> prices = fetchDailyPrices(symbol);

        if (prices == null) {
            System.out.println("Could not fetch prices.");
            return;
        }

        stock.setDailyPrices(prices);

        while (true) {
            System.out.println("\n📌 MENU");
            System.out.println("1. Display All Prices");
            System.out.println("2. Calculate Simple Moving Average");
            System.out.println("3. Get Top K Closing Prices");
            System.out.println("4. Get Price on a Specific Date");
            System.out.println("5. Analyze Best Buy/Sell Strategy (Greedy)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stock.displayPrices();
                    break;

                case 2:
                    System.out.print("Enter SMA period: ");
                    int period = sc.nextInt();
                    List<Double> sma = stock.calculateSimpleMovingAverage(period);
                    for (int i = 0; i < sma.size(); i++) {
                        System.out.printf("SMA #%d: %.2f\n", i + 1, sma.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter value of K: ");
                    int k = sc.nextInt();
                    List<Double> topPrices = stock.getTopKClosingPrices(k);
                    System.out.println("Top " + k + " Closing Prices:");
                    for (double p : topPrices) System.out.println("$" + p);
                    break;

                case 4:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    sc.nextLine(); // clear newline
                    String date = sc.nextLine();
                    if (prices.containsKey(date)) {
                        System.out.println("Price on " + date + " = $" + prices.get(date));
                    } else {
                        System.out.println("No data for that date.");
                    }
                    break;

                case 5:
                    stock.bestDayToBuyAndSell();
                    break;

                case 6:
                    System.out.println("Exiting... goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
