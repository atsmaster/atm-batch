package com.han.atm.batch.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_BATTER_GROUP")
public class BatterGroup extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_GROUP_ID")
    private Integer batterGroupId;
    
    @Column(name = "BATTER_GROUP_NAME")
    private String batterGroupName;
    
    @Column(name = "BATTER_COUNT")
    private Integer batterCount;
    
    @Column(name = "TOTAL_FUNDS")
    private BigDecimal totalFunds;

}
