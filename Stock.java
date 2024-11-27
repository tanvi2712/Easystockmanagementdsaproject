package minidsaproject;

import java.util.*;
class Stock {
String name;
String symbol;
double price;
double changePercent;
List<Double> priceHistory = new ArrayList<>(); // To store historical prices
// Constructor to initialize stock
Stock(String name, String symbol, double price, 
double changePercent) {
this.name = name;
this.symbol = symbol;
this.price = price;
this.changePercent = changePercent;
}
// Add price to history
void addPriceToHistory(double price) {
priceHistory.add(price);
}
// Calculate Simple Moving Average for the given period
double calculateSMA(int period) {
int size = priceHistory.size();
if (size < period) return 0; // Not enough data to calculate SMA
double sum = 0;
for (int i = size - period; i < size; i++) {
sum += priceHistory.get(i);
}
return sum / period;
}
}
class User {
String name;
String accountNo;
String userId;
String password;
double cashBalance;
Map<String, Integer> portfolio = new HashMap<>();
double totalInvested = 0.0;
// Constructor to initialize the user
User(String name, String accountNo, String userId, 
String password, double cashBalance) {
this.name = name;
this.accountNo = accountNo;
this.userId = userId;
this.password = password;
this.cashBalance = cashBalance;
}
}
class StockManagment {
static Queue<Stock> stockQueue = new LinkedList<>();
static List<User> users = new ArrayList<>();
static Scanner sc = new Scanner(System.in);
static User loggedInUser = null;
public static void main(String[] args) {
initializeStocks();
while (true) {
if (loggedInUser == null) {
loginMenu();
} else {
userMenu();
}
}
}
static void initializeStocks() {
// Initializing 10 companies with stock data
stockQueue.offer(new Stock("Apple", "AAPL", 160.0, 
5.0));
stockQueue.offer(new Stock("Microsoft", "MSFT", 
300.0, 2.5));
stockQueue.offer(new Stock("Google", "GOOGL", 2800.0, 
3.5));
stockQueue.offer(new Stock("Amazon", "AMZN", 3300.0, 
2.0));
stockQueue.offer(new Stock("Facebook", "FB", 270.0, 
1.5));
stockQueue.offer(new Stock("Tesla", "TSLA", 800.0, 
4.8));
// Adding historical prices for stocks
stockQueue.forEach(stock -> {
if (stock.symbol.equalsIgnoreCase("AAPL")) {
stock.addPriceToHistory(150.0);
stock.addPriceToHistory(151.0);
stock.addPriceToHistory(152.0);
stock.addPriceToHistory(149.0);
stock.addPriceToHistory(153.0);
stock.addPriceToHistory(154.0);
stock.addPriceToHistory(155.0);
stock.addPriceToHistory(156.0);
stock.addPriceToHistory(157.0);
stock.addPriceToHistory(158.0);
stock.addPriceToHistory(159.0);
stock.addPriceToHistory(160.0);
stock.addPriceToHistory(158.0);
stock.addPriceToHistory(157.0);
stock.addPriceToHistory(156.0);
stock.addPriceToHistory(155.0);
stock.addPriceToHistory(154.0);
stock.addPriceToHistory(153.0);
stock.addPriceToHistory(152.0);
stock.addPriceToHistory(151.0);
stock.addPriceToHistory(150.0);
stock.addPriceToHistory(149.0);
stock.addPriceToHistory(151.0);
stock.addPriceToHistory(152.0);
stock.addPriceToHistory(154.0);
stock.addPriceToHistory(156.0);
stock.addPriceToHistory(158.0);
stock.addPriceToHistory(160.0);
stock.addPriceToHistory(159.0);
stock.addPriceToHistory(161.0);
}
else if (stock.symbol.equalsIgnoreCase("MSFT")) {
stock.addPriceToHistory(302.0);
stock.addPriceToHistory(305.0);
stock.addPriceToHistory(308.0);
stock.addPriceToHistory(310.0);
stock.addPriceToHistory(312.0);
stock.addPriceToHistory(315.0);
stock.addPriceToHistory(317.0);
stock.addPriceToHistory(318.0);
stock.addPriceToHistory(319.0);
stock.addPriceToHistory(320.0);
stock.addPriceToHistory(318.0);
stock.addPriceToHistory(316.0);
stock.addPriceToHistory(314.0);
stock.addPriceToHistory(312.0);
stock.addPriceToHistory(310.0);
stock.addPriceToHistory(308.0);
stock.addPriceToHistory(306.0);
stock.addPriceToHistory(307.0);
stock.addPriceToHistory(309.0);
stock.addPriceToHistory(311.0);
stock.addPriceToHistory(314.0);
stock.addPriceToHistory(316.0);
stock.addPriceToHistory(318.0);
stock.addPriceToHistory(319.0);
stock.addPriceToHistory(321.0);
stock.addPriceToHistory(322.0);
stock.addPriceToHistory(324.0);
stock.addPriceToHistory(323.0);
stock.addPriceToHistory(325.0);
stock.addPriceToHistory(327.0);
}
else if (stock.symbol.equalsIgnoreCase("GOOGL")) {
stock.addPriceToHistory(2780.0);
stock.addPriceToHistory(2790.0);
stock.addPriceToHistory(2800.0);
stock.addPriceToHistory(2815.0);
stock.addPriceToHistory(2830.0);
stock.addPriceToHistory(2845.0);
stock.addPriceToHistory(2860.0);
stock.addPriceToHistory(2855.0);
stock.addPriceToHistory(2840.0);
stock.addPriceToHistory(2825.0);
stock.addPriceToHistory(2810.0);
stock.addPriceToHistory(2805.0);
stock.addPriceToHistory(2795.0);
stock.addPriceToHistory(2785.0);
stock.addPriceToHistory(2770.0);
stock.addPriceToHistory(2780.0);
stock.addPriceToHistory(2790.0);
stock.addPriceToHistory(2800.0);
stock.addPriceToHistory(2810.0);
stock.addPriceToHistory(2820.0);
stock.addPriceToHistory(2835.0);
stock.addPriceToHistory(2845.0);
stock.addPriceToHistory(2850.0);
stock.addPriceToHistory(2865.0);
stock.addPriceToHistory(2870.0);
stock.addPriceToHistory(2855.0);
stock.addPriceToHistory(2840.0);
stock.addPriceToHistory(2830.0);
stock.addPriceToHistory(2820.0);
stock.addPriceToHistory(2800.0);
}
else if (stock.symbol.equalsIgnoreCase("AMZN"))
{
stock.addPriceToHistory(3250.0);
stock.addPriceToHistory(3260.0);
stock.addPriceToHistory(3275.0);
stock.addPriceToHistory(3290.0);
stock.addPriceToHistory(3305.0);
stock.addPriceToHistory(3320.0);
stock.addPriceToHistory(3315.0);
stock.addPriceToHistory(3300.0);
stock.addPriceToHistory(3285.0);
stock.addPriceToHistory(3270.0);
stock.addPriceToHistory(3255.0);
stock.addPriceToHistory(3240.0);
stock.addPriceToHistory(3235.0);
stock.addPriceToHistory(3225.0);
stock.addPriceToHistory(3215.0);
stock.addPriceToHistory(3225.0);
stock.addPriceToHistory(3235.0);
stock.addPriceToHistory(3245.0);
stock.addPriceToHistory(3255.0);
stock.addPriceToHistory(3265.0);
stock.addPriceToHistory(3280.0);
stock.addPriceToHistory(3290.0);
stock.addPriceToHistory(3305.0);
stock.addPriceToHistory(3315.0);
stock.addPriceToHistory(3325.0);
stock.addPriceToHistory(3310.0);
stock.addPriceToHistory(3300.0);
stock.addPriceToHistory(3285.0);
stock.addPriceToHistory(3275.0);
stock.addPriceToHistory(3260.0);
}
else if (stock.symbol.equalsIgnoreCase("FB")) {
stock.addPriceToHistory(265.0);
stock.addPriceToHistory(267.0);
stock.addPriceToHistory(269.0);
stock.addPriceToHistory(271.0);
stock.addPriceToHistory(273.0);
stock.addPriceToHistory(275.0);
stock.addPriceToHistory(278.0);
stock.addPriceToHistory(280.0);
stock.addPriceToHistory(282.0);
stock.addPriceToHistory(284.0);
stock.addPriceToHistory(283.0);
stock.addPriceToHistory(281.0);
stock.addPriceToHistory(279.0);
stock.addPriceToHistory(277.0);
stock.addPriceToHistory(275.0);
stock.addPriceToHistory(273.0);
stock.addPriceToHistory(272.0);
stock.addPriceToHistory(270.0);
stock.addPriceToHistory(269.0);
stock.addPriceToHistory(268.0);
stock.addPriceToHistory(267.0);
stock.addPriceToHistory(266.0);
stock.addPriceToHistory(268.0);
stock.addPriceToHistory(270.0);
stock.addPriceToHistory(272.0);
stock.addPriceToHistory(274.0);
stock.addPriceToHistory(276.0);
stock.addPriceToHistory(278.0);
stock.addPriceToHistory(280.0);
stock.addPriceToHistory(279.0);
}
else if (stock.symbol.equalsIgnoreCase("TSLA"))
{
stock.addPriceToHistory(785.0);
stock.addPriceToHistory(790.0);
stock.addPriceToHistory(795.0);
stock.addPriceToHistory(800.0);
stock.addPriceToHistory(805.0);
stock.addPriceToHistory(810.0);
stock.addPriceToHistory(812.0);
stock.addPriceToHistory(815.0);
stock.addPriceToHistory(817.0);
stock.addPriceToHistory(820.0);
stock.addPriceToHistory(818.0);
stock.addPriceToHistory(816.0);
stock.addPriceToHistory(814.0);
stock.addPriceToHistory(812.0);
stock.addPriceToHistory(810.0);
stock.addPriceToHistory(808.0);
stock.addPriceToHistory(807.0);
stock.addPriceToHistory(809.0);
stock.addPriceToHistory(812.0);
stock.addPriceToHistory(815.0);
stock.addPriceToHistory(818.0);
stock.addPriceToHistory(820.0);
stock.addPriceToHistory(822.0);
stock.addPriceToHistory(825.0);
stock.addPriceToHistory(828.0);
stock.addPriceToHistory(830.0);
stock.addPriceToHistory(832.0);
stock.addPriceToHistory(835.0);
stock.addPriceToHistory(837.0);
stock.addPriceToHistory(840.0);
}
});
}
static void loginMenu() {
System.out.println("\nLogin Menu:");
System.out.println("1. Sign Up");
System.out.println("2. Login");
System.out.println("3. Exit");
System.out.print("Enter choice: ");
int choice = sc.nextInt();
sc.nextLine(); // Consume newline
switch (choice) {
case 1:
signUp();
break;
case 2:
login();
break;
case 3:
System.out.println("Exiting...");
System.exit(0);
break;
default:
System.out.println("Invalid choice! Try again.");
break;
}
}
static void signUp() {
System.out.print("Enter your name: ");
String name = sc.nextLine();
if (!name.matches("[a-zA-Z ]+")) {
System.out.println("Error: Name should contain only letters and spaces (no digits or special characters allowed). Please try again.");
return;
}
System.out.print("Enter 4 digit account number: ");
String accountNo = sc.nextLine();
if (!accountNo.matches("\\d{4}")) {
System.out.println("Error: Account number must be a 4-digit numeric code. Please try again.");
return;
}
System.out.print("Create User ID: ");
String userId = sc.nextLine();
System.out.print("Create Password: ");
String password = sc.nextLine();
System.out.print("Enter initial cash balance: ");
double cashBalance = sc.nextDouble();
User newUser = new User(name, accountNo, userId, 
password, cashBalance);
users.add(newUser);
System.out.println("Account created successfully! Please log in.");
}
static void login() {
System.out.print("Enter User ID: ");
String userId = sc.nextLine();
System.out.print("Enter Password: ");
String password = sc.nextLine();
for (User user : users) {
if (user.userId.equals(userId) && 
user.password.equals(password)) {
loggedInUser = user;
System.out.println("Login successful!");
return;
}
}
System.out.println("Invalid credentials! Please try again.");
}
static void userMenu() {
System.out.println("\n-----------------------User Menu-----------------------");
System.out.println("1. View Stock Data");
System.out.println("2. Buy Stock");
System.out.println("3. Sell Stock");
System.out.println("4. View Portfolio");
System.out.println("5. View Stock Moving Averages (Crossover Strategy)");
System.out.println("6. Sort by percent change");
System.out.println("7. Log Out");
System.out.print("Enter choice: ");
int choice = sc.nextInt();
sc.nextLine(); // Consume newline
switch (choice) {
case 1:
displayAllStocks();
break;
case 2:
buyStock();
break;
case 3:
sellStock();
break;
case 4:
displayPortfolio();
break;
case 5:
viewStockMovingAverages();
break;
case 7:
loggedInUser = null;
System.out.println("Logged out successfully!");
break;
case 6:
sortStocksByChangePercent();
break;
default:
System.out.println("Invalid choice! Try again.");
break;
}
}
static void displayAllStocks() {
System.out.printf("%-10s %-10s %-10s %-10s%n", 
"Name", "Symbol", "Price", "Change %");
for (Stock stock : stockQueue) {
System.out.printf("%-10s %-10s %-10.2f %-10.2f%n", 
stock.name, stock.symbol, stock.price, 
stock.changePercent);
}
}
static void sortStocksByChangePercent() {
List<Stock> stockList = new ArrayList<>(stockQueue);
stockList.sort(Comparator.comparingDouble(stock -> stock.changePercent));
stockQueue = new LinkedList<>(stockList);
System.out.println("The sorted list of stocks in ascending order by change percent");
for (Stock stock : stockQueue) {
System.out.println(stock.name + " (" + stock.symbol + 
") - Price: ₹" + stock.price + ", Change: " + 
stock.changePercent + "%");
}
}
static void buyStock() {
System.out.print("Enter stock name to buy: ");
String stockName = sc.nextLine();
Stock stock = findStockByName(stockName);
if (stock != null) {
System.out.printf("Current Price: ₹%.2f%n", 
stock.price);
System.out.print("Do you want to buy this stock? (yes/no): ");
String confirmation = sc.nextLine().toLowerCase();
if (confirmation.equals("yes")) {
int quantity = 0;
boolean validQuantity = false;
// Keep asking for quantity until valid input is provided
while (!validQuantity) {
System.out.print("Enter quantity: ");
try {
quantity = sc.nextInt();
if (quantity <= 0) {
System.out.println("Quantity must be a positive number.");
} else {
validQuantity = true;
}
} catch (InputMismatchException e) {
System.out.println("Invalid input! Please enter a valid integer for quantity.");
sc.nextLine(); // Clear the buffer
}
}
double totalCost = quantity * stock.price;
if (totalCost <= loggedInUser.cashBalance) {
loggedInUser.cashBalance -= totalCost;
loggedInUser.totalInvested += totalCost;
loggedInUser.portfolio.put(stock.symbol, 
loggedInUser.portfolio.getOrDefault(stock.symbol, 0) 
+ quantity);
System.out.printf("Bought %d shares of %s for ₹%.2f%n", quantity, stock.name, totalCost);
} else {
System.out.println("Insufficient balance.");
}
} else {
System.out.println("Purchase cancelled.");
}
} else {
System.out.println("Stock not found.");
}
}
static Stock findStockByName(String name) {
for (Stock stock : stockQueue) {
if (stock.name.equalsIgnoreCase(name)) {
return stock;
}
}
return null;
}
// Method to display the portfolio of the logged-in user
static void displayPortfolio() {
// Ensure loggedInUser is not null
if (loggedInUser == null) {
System.out.println("No user logged in.");
return;
}
System.out.printf("Cash Balance: ₹%.2f%n", 
loggedInUser.cashBalance);
System.out.printf("Total Invested: ₹%.2f%n", 
loggedInUser.totalInvested); // Ensure totalInvested is properly tracked
System.out.println("Portfolio:");
System.out.printf("%-10s %-10s %-10s%n", "Name", 
"Quantity", "Value");
// Loop through the portfolio and print each stock's details
for (Map.Entry<String, Integer> entry : 
loggedInUser.portfolio.entrySet()) {
String stockSymbol = entry.getKey();
int quantity = entry.getValue();
Stock stock = findStockBySymbol(stockSymbol); // Find stock by symbol
if (stock != null) {
double value = quantity * stock.price; // Calculate the total value of the stock owned
System.out.printf("%-10s %-10d %-10.2f%n", stock.name, quantity, value);
}
}
}
static Stock findStockBySymbol(String symbol) {
for (Stock stock : stockQueue) {
if (stock.symbol.equalsIgnoreCase(symbol)) {
return stock;
}
}
return null;
}
static void sellStock() {
System.out.print("Enter stock name to sell: ");
String stockName = sc.nextLine();
Stock stock = findStockByName(stockName);
if (stock != null) {
if
(!loggedInUser.portfolio.containsKey(stock.symbol)) {
System.out.println("You do not own any shares of " + stock.name);
return;
}
int quantityOwned = 
loggedInUser.portfolio.get(stock.symbol);
System.out.printf("You own %d shares of %s.%n", quantityOwned, stock.name);
int quantityToSell = 0;
boolean validQuantity = false;
// Keep asking for quantity until valid input is provided
while (!validQuantity) {
System.out.print("Enter quantity to sell: ");
try {
quantityToSell = sc.nextInt();
sc.nextLine(); // Consume newline
if (quantityToSell <= 0) {
System.out.println("Quantity must be a positive number.");
} else if (quantityToSell > quantityOwned) {
System.out.println("You don't have enough shares to sell.");
} else {
validQuantity = true; // Valid quantity entered
}
} catch (InputMismatchException e) {
System.out.println("Invalid input! Please enter a valid integer for quantity.");
sc.nextLine(); // Clear the buffer
}
}
// Proceed with selling the stock after valid input
double earnings = quantityToSell * stock.price;
loggedInUser.cashBalance += earnings;
loggedInUser.totalInvested -= earnings;
loggedInUser.portfolio.put(stock.symbol, 
quantityOwned - quantityToSell);
if (loggedInUser.portfolio.get(stock.symbol) == 0) {
loggedInUser.portfolio.remove(stock.symbol);
}
System.out.printf("Sold %d shares of %s for ₹%.2f%n", 
quantityToSell, stock.name, earnings);
} else {
System.out.println("Stock not found.");
}
}
// Method to view moving averages for each stock
static void viewStockMovingAverages() 
{
System.out.print("Enter stock name to view moving averages: ");
String stockName = sc.nextLine();
Stock stock = findStockByName(stockName);
if (stock != null) {
System.out.print("Enter the short-term period (e.g., 5): ");
int shortTerm = sc.nextInt();
System.out.print("Enter the long-term period (e.g., 10): ");
int longTerm = sc.nextInt();
sc.nextLine(); // Consume newline
double shortTermSMA = stock.calculateSMA(shortTerm);
double longTermSMA = stock.calculateSMA(longTerm);
System.out.printf("Short-term SMA (%d-day): ₹%.2f%n", 
shortTerm, shortTermSMA);
System.out.printf("Long-term SMA (%d-day): ₹%.2f%n", 
longTerm, longTermSMA);
// Example crossover strategy indication
if (shortTermSMA > longTermSMA) {
System.out.println("The recent average price is higher than the long-term average - a bullish indicator.");
System.out.println("It is a good sign for the stock’s growth.So buy the stocks.");
} else {
System.out.println("The average stock price over a short period is lower than the average over a longer period- a bearish indicator.");
System.out.println("It often suggests the stock might go down.Sell the stocks");
}
} else {
System.out.println("Stock not found.");
}
}
}