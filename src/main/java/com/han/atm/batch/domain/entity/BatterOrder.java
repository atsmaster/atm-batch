package com.han.atm.batch.domain.entity;

import com.han.atm.batch.domain.code.OrderPositionCd;
import com.han.atm.batch.domain.code.OrderSideCd;
import com.han.atm.batch.domain.code.OrderStatusCd;
import com.han.atm.batch.domain.code.OrderTypeCd;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "TB_BATTER_ORDER")
public class BatterOrder extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "EXCHANGE_ORDER_ID")
    private String exchangeOrderId;
    
    @Column(name = "BATTER_EXECUTION_ID")
    private Integer batterExecutionId;

    @Column(name = "ORDER_SYMBOL")
    private String orderSymbol;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_SIDE_CD")
    private OrderSideCd orderSideCd;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_POSITION_CD")
    private OrderPositionCd orderPositionCd;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE_CD")
    private OrderTypeCd orderTypeCd;
    
    @Column(name = "ORDER_DT")
    private LocalDate orderDt;
    
    @Column(name = "ORDER_DTTM")
    private LocalDateTime orderDttm;
    
    @Column(name = "ORDER_PRICE")
    private BigDecimal orderPrice;
    
    @Column(name = "ORDER_QUANTITY")
    private BigDecimal orderQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS_CD")
    private OrderStatusCd orderStatusCd;
    
    @Column(name = "TRANSACTION_DT")
    private LocalDate transactionDt;
    
    @Column(name = "TRANSACTION_DTTM")
    private LocalDateTime transactionDttm;
    
    @Column(name = "TRANSACTION_PRICE")
    private BigDecimal transactionPrice;
    
    @Column(name = "TRANSACTION_QUANTITY")
    private BigDecimal transactionQuantity;
    
    @Column(name = "TRANSACTION_TOTAL_AMOUNT")
    private BigDecimal transactionTotalAmount;
    
    @Column(name = "COMMISSION")
    private BigDecimal commission;

    public void setOrderQuantity(BigDecimal orderQuantity){
        this.orderQuantity = orderQuantity;
    }

    public void setOrderSymbol(String symbol){
        this.orderSymbol = symbol;
    }

    public void initialize(OrderSideCd orderSideCd, OrderPositionCd orderPositionCd, OrderTypeCd orderTypeCd){
        this.orderSideCd = orderSideCd;
        this.orderPositionCd = orderPositionCd;
        this.orderTypeCd = orderTypeCd;
    }

}
