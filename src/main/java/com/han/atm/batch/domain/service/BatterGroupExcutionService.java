package com.han.atm.batch.domain.service;

import com.han.atm.batch.domain.entity.BatterGroupExecution;
import com.han.atm.batch.domain.repository.BatterGroupExecutionRepository;
import com.han.atm.batch.domain.repository.BatterOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatterGroupExcutionService {

    private final BatterGroupExecutionRepository batterGroupExecutionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterGroupExecution createBatterGroupExcution(BatterGroupExecution batterGroupExecution){
        return batterGroupExecutionRepository.save(batterGroupExecution);
    }


}
