# Stock Management System (Mini DSA Project)

This is a Java-based command-line application to manage and analyze stock data using core Data Structures & Algorithms concepts such as arrays, sorting, greedy strategy, and the Simple Moving Average (SMA). It is intended to demonstrate practical DSA usage in a real-world scenario.

## Features

- Fetch historical stock prices using the Alpha Vantage API  
- Display all closing prices  
- Retrieve the stock price on a specific date  
- Calculate the Simple Moving Average (SMA) over n days  
- Find the Top K Closing Prices  
- Analyze the best buy/sell days using a greedy approach to maximize profit based on historical data  

## Algorithms and DSA Concepts Used

- **Greedy Algorithm** for maximum profit buy/sell analysis  
- **Sorting** for identifying Top K prices  
- **Sliding Window Technique** for SMA calculation  
- **Array Traversal** and date handling using Java collections and string manipulation  

## How to Run

1. Clone this repository  
2. Obtain a free API key from [Alpha Vantage](https://www.alphavantage.co/support/#api-key)  
3. Compile and run the Java program:

```bash
javac StockManagement.java
java StockManagement
```

4. Enter the stock symbol when prompted (e.g., AAPL, GOOG, TCS.BSE)

## Sample Output

```
Enter stock symbol (e.g., AAPL): AAPL

Historical Closing Prices:
2024-01-10: 142.88
2024-01-11: 145.76
...

Simple Moving Average (SMA) over 5 days: 150.62

Top 3 Closing Prices:
1. 157.23
2. 154.80
3. 151.34

Best Buy/Sell Analysis (Historical Data Only):
Buy on 2024-01-10 at $142.88
Sell on 2024-01-23 at $157.23
Max Profit: $14.35
Note: This analysis is based on past data and does not predict future performance.
```

## What is SMA?

The Simple Moving Average (SMA) is the average of the last 'n' closing prices. It helps smooth out short-term fluctuations and observe long-term trends in the stock's behavior.

For example, SMA(3) = (Price1 + Price2 + Price3) / 3


## Future Improvements

- Add basic price prediction using regression or ML  
- Export results to CSV  
- Add a user-friendly GUI using JavaFX or Swing  

## Credits

Developed using Java and Alpha Vantage API for historical stock data.


