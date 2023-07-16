package com.han.atm.batch.domain.repository;

import com.han.atm.batch.domain.entity.CoinEntry;
import com.han.atm.batch.domain.entity.CoinEntryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinEntryRepository extends JpaRepository<CoinEntry, CoinEntryId> {

    public CoinEntry findByExchangeAndSymbol(String exchange, String symbol);
}
