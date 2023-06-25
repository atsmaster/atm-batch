package com.han.atm.batch.domain.code;

public enum BatterStatusCd {
    START("실행"),
    STOPPING_REQUEST_CHECK("종료요청확인중"),
    SETTING_PRICE("가격결정중"),
    WAITTING_RETIRE_FUNDS("자금회수대기중"),
    WAITTING_LACK_FUNDS("자금부족대기중"),
    SELECTING_SYMBOL("종목선택중"),
    BUYING("매수중"),
    SELLING("매도중"),
    SETTLING("정산중"),
    STOP("종료");
    private String name;
    private BatterStatusCd(String name) {
        this.name = name;
    }
}
