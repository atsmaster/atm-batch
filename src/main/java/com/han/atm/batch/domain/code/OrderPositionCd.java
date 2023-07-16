package com.han.atm.batch.domain.code;

public enum OrderPositionCd {
    LONG("롱"),
    SHORT("숏");
    private String name;
    private OrderPositionCd(String name) {
        this.name = name;
    }
}
