package com;

public class StockTest {
    public static void main(String[] args) {
        Stock stock = new Stock("XOM", "ExxonMobil");
        stock.setCurrentPrice(62.06);
        stock.setPreviousClosingPrice(61.77);

        System.out.println("Stock:");
        System.out.println("Symbol = " + stock.getSymbol() + "\n" + "Name = " + stock.getName() + "\n" +
                           "currentPrice = " + stock.getCurrentPrice() + "\n" + "previousClosingPrice = "
                            + stock.getPreviousClosingPrice() + "\n" + "changePercentage = " + stock.changePercent());

        System.out.println("Stock1:");
        Stock stock1 = new Stock(null,null);
        System.out.println("Symbol = " + stock1.getSymbol() + "\n" + "Name = " + stock1.getName());

        Stock stock2 = new Stock("APPL", "Apple");
        stock2.setPreviousClosingPrice(-321);
        stock2.setCurrentPrice(-234);
        System.out.println("Stock2:");
        System.out.println("previousClosingPrice = " + stock2.getPreviousClosingPrice() + "\n" + "currentPrice = " + stock2.getCurrentPrice());

    }

}
