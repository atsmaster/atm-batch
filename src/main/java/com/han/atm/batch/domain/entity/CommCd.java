package com.han.atm.batch.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TB_COMM_CD")
@IdClass(CommCdId.class)
public class CommCd {
    @Id
    @Column(name = "COMM_CD_TYPE")
    private String commCdType;

    @Id
    @Column(name = "COMM_CD")
    private String commCd;
    
    @Column(name = "COMM_CD_NAME")
    private String commCdName;
    
    @Column(name = "CREATED_DTTM")
    private Timestamp createdDttm;
    
    @Column(name = "MODIFIED_DTTM")
    private Timestamp modifiedDttm;


}
