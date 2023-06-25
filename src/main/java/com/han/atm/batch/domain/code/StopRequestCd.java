package com.han.atm.batch.domain.code;

public enum StopRequestCd {
    NONE("없음"),
    PROFIT_STOP("이익종료");
    private String name;
    private StopRequestCd(String name) {
        this.name = name;
    }
}
