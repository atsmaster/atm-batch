package com.han.atm.batch.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "TB_COIN_ENTRY")
@IdClass(CoinEntryId.class)
public class CoinEntry extends BaseEntity {

    @Id
    @Column(name = "EXCHANGE")
    private String exchange;

    @Id
    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "SYMBOL_STATUS_CD")
    private String symbolStatusCd;

    @Column(name = "BASE_ASSET")
    private String baseAsset;

    @Column(name = "QUOTE_ASSET")
    private String quoteAsset;

    @Column(name = "BASE_ASSET_PRECISION")
    private Integer baseAssetPrecision;

    @Column(name = "QUOTE_ASSET_PRECISION")
    private Integer quoteAssetPrecision;

    @Column(name = "ONBOARD_DTTM")
    private LocalDateTime onboardDttm;

    @Column(name = "CREATED_DTTM")
    private LocalDateTime createdDttm;

    @Column(name = "MODIFIED_DTTM")
    private LocalDateTime modifiedDttm;
}
