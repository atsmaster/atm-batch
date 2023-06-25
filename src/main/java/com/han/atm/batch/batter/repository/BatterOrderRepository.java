package com.han.atm.batch.batter.repository;

import com.han.atm.batch.batter.domain.BatterOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterOrderRepository extends JpaRepository<BatterOrder, String> {
}
