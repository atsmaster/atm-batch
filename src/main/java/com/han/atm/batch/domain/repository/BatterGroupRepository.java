package com.han.atm.batch.domain.repository;

import com.han.atm.batch.domain.entity.BatterGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatterGroupRepository extends JpaRepository<BatterGroup, String> {
}
