package com.han.atm.batch.domain.repository;

import com.han.atm.batch.domain.entity.BatterOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterOrderRepository extends JpaRepository<BatterOrder, String> {
}
