
# Stock Management and Prediction System

## Project Overview
This project implements a **Stock Management System** that helps users organize and analyze stocks based on their daily percentage change in value. It provides functionality for stock initialization, sorting, analysis, and basic portfolio management, aiming to offer insights into stock market trends.

---

## Features
1. **Stock Initialization**  
   - Create a queue of stocks, each with:
     - `name`: The company's name.
     - `symbol`: The stock ticker symbol.
     - `price`: The current price of the stock.
     - `changePercent`: The stock's daily percentage change.
   
2. **Sorting by Percentage Change**  
   - Sort stocks in ascending order of their percentage change, helping users assess performance effectively.

3. **Portfolio Management**  
   - Sign up and log in as a user.
   - View portfolio details, including owned stocks, quantity, and cash balance.
   - Buy and sell stocks dynamically.

4. **Moving Average Analysis**  
   - Calculate Simple Moving Averages (SMA) for different periods.
   - Identify bullish or bearish trends using crossover strategies.

5. **Dynamic User Interface**  
   - Intuitive text-based menus for login, stock analysis, and portfolio management.

---

## Technologies Used
- **Programming Language**: Java  
- **Data Structures**:  
  - Queue (for managing stock data).
  - ArrayList and HashMap (for user portfolio and historical stock prices).

---

## System Requirements
- **Java Version**: JDK 8 or above.
- **Development Environment**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE.

---

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Open the project in your Java IDE.
3. Compile and run the `StockManagement` class.

---

## How to Use
### Login Menu
1. **Sign Up**  
   - Enter your name, a 4-digit account number, a unique user ID, and password.  
   - Provide an initial cash balance.

2. **Login**  
   - Use your user ID and password to log in.

3. **Exit**  
   - Quit the application.

### User Menu
1. **View Stock Data**  
   - Displays all available stocks with their details.
   
2. **Buy Stock**  
   - Purchase stocks by specifying their name and quantity.

3. **Sell Stock**  
   - Sell owned stocks by providing their name and the number of shares.

4. **View Portfolio**  
   - Check your portfolio details, including cash balance, total invested amount, and stock holdings.

5. **View Moving Averages**  
   - Calculate and analyze short-term and long-term SMAs for any stock.

6. **Sort by Percent Change**  
   - Display stocks sorted by daily percentage change
