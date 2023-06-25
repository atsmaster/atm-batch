package com.han.atm.batch.domain.repository;

import com.han.atm.batch.domain.entity.BatterExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterExecutionRepository extends JpaRepository<BatterExecution, Integer> {
}
