package com;

public class StockTest {
    public static void main(String[] args) {
        //initialize a new entity of class Stock...
        Stock test1 = new Stock("testSymbol", "testName");

        //setCurrentPrice calls out setPreviousClosingPrice so no need to call that out...
        test1.setCurrentPrice(100.00);
        test1.setCurrentPrice(2000.50);

        System.out.printf("Stock name: %s\n", test1.getName());
        System.out.printf("Stock symbol: %s\n", test1.getSymbol());
        System.out.printf("Previous stock closing price: %.2f\n", test1.getPreviousClosingPrice());
        System.out.printf("Current stock price: %.2f\n", test1.getCurrentPrice());

        //change currentPrice...
        //setCurrentPrice calls out setPreviousClosingPrice so no need to call that out...
        System.out.println("\nChanging stock price to test method functionality.");
        test1.setCurrentPrice(1500.72);

        //check changes...
        System.out.printf("Current stock price: %.2f\n", test1.getCurrentPrice());
        System.out.printf("Previous stock closing price: %.2f\n", test1.getPreviousClosingPrice());
    }
}
