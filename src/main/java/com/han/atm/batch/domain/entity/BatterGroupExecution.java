package com.han.atm.batch.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "TB_BATTER_GROUP_EXECUTION")
public class BatterGroupExecution extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_GROUP_EXECUTION_ID")
    private Integer batterGroupExecutionId;
    
    @Column(name = "BATTER_GROUP_ID")
    private Integer batterGroupId;
    
    @Column(name = "EXECUTION_YN")
    private String executionYn;

    public BatterGroupExecution(int batterGroupId){
        this.batterGroupId = batterGroupId;
        this.executionYn = "N";
    }


    public BatterGroupExecution() {

    }
}
