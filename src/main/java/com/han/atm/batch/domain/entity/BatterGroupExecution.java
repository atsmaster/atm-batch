package com.han.atm.batch.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "TB_BATTER_GROUP_EXECUTION")
public class BatterGroupExecution {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BATTER_GROUP_EXECUTION_ID")
    private int batterGroupExecutionId;
    
    @Column(name = "BATTER_GROUP_ID")
    private int batterGroupId;
    
    @Column(name = "EXECUTION_YN")
    private String executionYn;
    
    @Column(name = "CREATED_DTTM")
    private Timestamp createdDttm;
    
    @Column(name = "MODIFIED_DTTM")
    private Timestamp modifiedDttm;

    public BatterGroupExecution(int batterGroupId){
        this.batterGroupId = batterGroupId;
        this.executionYn = "N";
    }


    public BatterGroupExecution() {

    }
}
