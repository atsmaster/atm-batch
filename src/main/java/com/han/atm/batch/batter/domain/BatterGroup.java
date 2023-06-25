package com.han.atm.batch.batter.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "TB_BATTER_GROUP")
public class BatterGroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_GROUP_ID")
    private int batterGroupId;
    
    @Column(name = "BATTER_GROUP_NAME")
    private String batterGroupName;
    
    @Column(name = "BATTER_COUNT")
    private Integer batterCount;
    
    @Column(name = "TOTAL_FUNDS")
    private BigDecimal totalFunds;
    
    @Column(name = "CREATED_DTTM")
    private Timestamp createdDttm;
    
    @Column(name = "MODIFIED_DTTM")
    private Timestamp modifiedDttm;


}
