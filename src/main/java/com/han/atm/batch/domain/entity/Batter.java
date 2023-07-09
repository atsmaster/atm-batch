package com.han.atm.batch.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "TB_BATTER")
public class Batter extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_ID")
    private Integer batterId;

    @Column(name = "BATTER_GROUP_ID")
    private Integer batterGroupId;

    @Column(name = "SYMBOL_DECIDER_ ID")
    private Integer symbolDeciderId;

    @Column(name = "BATTER_NAME")
    private String batterName;

    @Column(name = "ORDER_POSITION_CD")
    private String orderPositionCd;
    
    @Column(name = "FIRST_BATTING_PRICE")
    private BigDecimal firstBattingPrice;
    
    @Column(name = "TAKE_PROFIT_RATE")
    private BigDecimal takeProfitRate;
    
    @Column(name = "STOP_LOSS_RATE")
    private BigDecimal stopLossRate;
    
    @Column(name = "RETRY_INCREMENT_PRICE_RATE")
    private BigDecimal retryIncrementPriceRate;

}
