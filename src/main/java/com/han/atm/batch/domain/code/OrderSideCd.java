package com.han.atm.batch.domain.code;

public enum OrderSideCd {
    BUY("매수"),
    SELL("매도");
    private String name;
    private OrderSideCd(String name) {
        this.name = name;
    }
}
