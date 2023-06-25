package com.han.atm.batch.domain.entity;

import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.code.DecidePriceWaitCd;
import com.han.atm.batch.domain.code.StopRequestCd;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "TB_BATTER_EXECUTION")
public class BatterExecution {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_EXECUTION_ID")
    private int batterExecutionId;
    
    @Column(name = "BATTER_GROUP_EXECUTION_ID")
    private int batterGroupExecutionId;
    
    @Column(name = "BATTER_ID")
    private int batterId;

    @Enumerated
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

    @Enumerated
    @Column(name = "STOP_REQUEST_CD")
    private StopRequestCd stopRequestCd;

    @Enumerated
    @Column(name = "DECIDE_PRICE_WAIT_CD")
    private DecidePriceWaitCd decidePriceWaitCd;

    
    @Column(name = "CREATED_DTTM")
    private Timestamp createdDttm;
    
    @Column(name = "MODIFIED_DTTM")
    private Timestamp modifiedDttm;

    public BatterExecution(){}

    public BatterExecution(Batter batter, int batterGroupExecutionId){
        this.batterGroupExecutionId = batterGroupExecutionId;
        this.batterId = batter.getBatterId();
        this.batterStatusCd = BatterStatusCd.START;
        this.stopRequestCd = StopRequestCd.NONE;
        this.decidePriceWaitCd = DecidePriceWaitCd.NONE;
    }

}