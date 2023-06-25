package com.han.atm.batch.domain.code;

public enum OrderStatusCd {
    CANCELED("취소"),
    EXPIRED("만료"),
    FILLED("체결"),
    NEW("신규"),
    PARTIALLY_FILLED("부분체결"),
    REJECTED("거절");
    private String name;
    private OrderStatusCd(String name) {
        this.name = name;
    }
}
