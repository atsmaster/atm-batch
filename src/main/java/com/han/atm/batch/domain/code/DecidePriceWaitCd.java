package com.han.atm.batch.domain.code;

public enum DecidePriceWaitCd {
    NONE("없음"),
    RETIRE("회수대기중"),
    LACK("부족대기중");
    private String name;
    private DecidePriceWaitCd(String name) {
        this.name = name;
    }
}
