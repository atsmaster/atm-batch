package com.han.atm.batch.domain.code;

public enum OrderTypeCd {
    LIMIT("지정가주문"),
    MARKET("시장가주문"),
    STOP("손절지정가주문"),
    STOP_MARKET("손절시장가주문"),
    TAKE_PROFIT("이익지정가주문"),
    TAKE_PROFIT_MARKET("이익시장가주문"),
    TRAILING_STOP_MARKET("후행거래");

    private String name;
    private OrderTypeCd(String name) {
        this.name = name;
    }
}
