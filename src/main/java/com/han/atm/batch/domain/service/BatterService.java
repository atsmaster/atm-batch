package com.han.atm.batch.domain.service;

import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.repository.BatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatterService {

    private final BatterRepository batterRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Batter findBatterById(int batterId){
        return batterRepository.findById(batterId).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Batter> findByBatterGroupId(int batterGroupId){
        return batterRepository.findByBatterGroupId(batterGroupId);
    }
}
