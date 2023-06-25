package com.han.atm.batch.domain.entity;

import com.han.atm.batch.domain.code.OrderStatusCd;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "TB_BATTER_ORDER")
public class BatterOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "EXCHANGE_ORDER_ID")
    private String exchangeOrderId;
    
    @Column(name = "BATTER_EXECUTION_ID")
    private int batterExecutionId;
    
    @Column(name = "ORDER_SYMBOL")
    private String orderSymbol;
    
    @Column(name = "ORDER_POSITION_CD")
    private String orderPositionCd;
    
    @Column(name = "ORDER_TYPE_CD")
    private String orderTypeCd;
    
    @Column(name = "ORDER_DT")
    private String orderDt;
    
    @Column(name = "ORDER_DTTM")
    private Timestamp orderDttm;
    
    @Column(name = "ORDER_PRICE")
    private BigDecimal orderPrice;
    
    @Column(name = "ORDER_QUANTITY")
    private BigDecimal orderQuantity;

    @Enumerated
    @Column(name = "ORDER_STATUS_CD")
    private OrderStatusCd orderStatusCd;
    
    @Column(name = "TRANSACTION_DT")
    private String transactionDt;
    
    @Column(name = "TRANSACTION_DTTM")
    private Timestamp transactionDttm;
    
    @Column(name = "TRANSACTION_PRICE")
    private BigDecimal transactionPrice;
    
    @Column(name = "TRANSACTION_QUANTITY")
    private BigDecimal transactionQuantity;
    
    @Column(name = "TRANSACTION_TOTAL_AMOUNT")
    private BigDecimal transactionTotalAmount;
    
    @Column(name = "COMMISSION")
    private BigDecimal commission;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

}
