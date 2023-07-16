package com.han.atm.batch.domain.entity;

import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.code.DecidePriceWaitCd;
import com.han.atm.batch.domain.code.StopRequestCd;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "TB_BATTER_EXECUTION")
public class BatterExecution extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_EXECUTION_ID")
    private Integer batterExecutionId;
    
    @Column(name = "BATTER_GROUP_EXECUTION_ID")
    private Integer batterGroupExecutionId;
    
    @Column(name = "BATTER_ID")
    private Integer batterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "BATTER_STATUS_CD")
    private BatterStatusCd batterStatusCd;
    
    @Column(name = "BATTING_SYMBOL")
    private String battingSymbol;
    
    @Column(name = "BATTING_AMOUNT")
    private BigDecimal battingAmount;
    
    @Column(name = "TOTAL_PROFIT_AMOUNT")
    private BigDecimal totalProfitAmount;
    
    @Column(name = "EXCEPT_LOSS_AMOUNT")
    private BigDecimal exceptLossAmount;
    
    @Column(name = "TOTAL_PROFIT_COUNT")
    private Integer totalProfitCount;
    
    @Column(name = "TOTAL_LOSS_COUNT")
    private Integer totalLossCount;
    
    @Column(name = "LOSS_COUNT")
    private Integer lossCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "STOP_REQUEST_CD")
    private StopRequestCd stopRequestCd;

    @Enumerated(EnumType.STRING)
    @Column(name = "DECIDE_PRICE_WAIT_CD")
    private DecidePriceWaitCd decidePriceWaitCd;


    public BatterExecution(){}

    public BatterExecution(Batter batter, int batterGroupExecutionId){
        this.batterGroupExecutionId = batterGroupExecutionId;
        this.batterId = batter.getBatterId();
        this.batterStatusCd = BatterStatusCd.START;
        this.stopRequestCd = StopRequestCd.NONE;
        this.decidePriceWaitCd = DecidePriceWaitCd.NONE;
    }

    public void setBattingSymbol(String symbol){
        this.battingSymbol = symbol;
    }
}
