package com.han.atm.batch.domain.code;

public enum BatterStatusCd {
    START("실행"),
    STOPPING_REQUEST_CHECK("종료요청확인중"),
    DECIDE_SYMBOL("종목결정중"),
    DECIDE_PRICE("가격결정중"),
    BUYING("매수중"),
    SELLING("매도중"),
    SETTLING("정산중"),
    STOP("종료");
    private String name;
    private BatterStatusCd(String name) {
        this.name = name;
    }
}
