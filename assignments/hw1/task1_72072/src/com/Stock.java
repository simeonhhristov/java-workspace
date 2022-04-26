package com;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        //set default values for invalid arguments
        if (symbol == null || symbol.length() == 0){
            this.symbol = "default_symbol";
        } else {
            this.symbol = symbol;
        }

        if (name == null || name.length() == 0){
            this.name = "default_name";
        } else {
            this.name = name;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double price) {
        previousClosingPrice = price;
    }

    public void setCurrentPrice(double price) {
        //current price becomes old
        setPreviousClosingPrice(currentPrice);

        //stock prices can never be negative, but can be 0
        if (price < 0){
            currentPrice = 0;
            return;
        }
        currentPrice = price;
    }

    public double changePercent() {
        //get percentage change between old and new price
        return (currentPrice / previousClosingPrice) * 100;
    }
}
