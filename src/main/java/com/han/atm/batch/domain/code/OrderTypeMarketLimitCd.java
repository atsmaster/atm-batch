package com.han.atm.batch.domain.code;

public enum OrderTypeMarketLimitCd {
    LIMIT("지정가주문"),
    MARKET("시장가주문");

    private String name;
    private OrderTypeMarketLimitCd(String name) {
        this.name = name;
    }
}
