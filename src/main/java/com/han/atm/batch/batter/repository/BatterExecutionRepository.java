package com.han.atm.batch.batter.repository;

import com.han.atm.batch.batter.domain.BatterExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterExecutionRepository extends JpaRepository<BatterExecution, String> {
}
