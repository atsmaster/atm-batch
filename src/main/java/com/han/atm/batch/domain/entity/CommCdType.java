package com.han.atm.batch.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TB_COMM_CD_TYPE")
public class CommCdType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COMM_CD_TYPE")
    private String commCdType;
    
    @Column(name = "COMM_CD_TYPE_NAME")
    private String commCdTypeName;
    
    @Column(name = "CREATED_DTTM")
    private Timestamp createdDttm;
    
    @Column(name = "MODIFIED_DTTM")
    private Timestamp modifiedDttm;


}
