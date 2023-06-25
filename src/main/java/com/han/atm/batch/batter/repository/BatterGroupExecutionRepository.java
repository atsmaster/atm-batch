package com.han.atm.batch.batter.repository;

import com.han.atm.batch.batter.domain.BatterGroupExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterGroupExecutionRepository extends JpaRepository<BatterGroupExecution, String> {
}
