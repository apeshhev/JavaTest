package com;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        if(symbol != null) {
            this.symbol = symbol;
        }else {
            this.symbol = "S";
        }

        if(name != null) {
            this.name = name;
        }else {
            this.name = "Sears";
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

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice > 0 ? previousClosingPrice : 1d;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice > 0 ? currentPrice : 1d;
    }

    public double changePercent() {
        return ((currentPrice - previousClosingPrice) /
                previousClosingPrice) * 100;
    }
}
