package com.han.atm.batch.binance.vo;

public class MarketBuyOrder {
    private String symbol;
    private String side;
    private String type;
    private String quantity;

    public MarketBuyOrder(){
        this.side = "BUY";
        this.type = "MARKET";
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
