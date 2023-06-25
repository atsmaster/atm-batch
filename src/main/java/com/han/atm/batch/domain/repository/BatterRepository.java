package com.han.atm.batch.domain.repository;

import com.han.atm.batch.domain.entity.Batter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatterRepository extends JpaRepository<Batter, Integer> {

    public List<Batter> findByBatterGroupId(Integer batterGroupId);
}
