package com.han.atm.batch.domain.service;

import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.repository.BatterExecutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BatterExecutionService {

    private final BatterExecutionRepository batterExecutionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution createBatterExcution(BatterExecution batterExecution){
        return batterExecutionRepository.save(batterExecution);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution findById(Integer batterExecutionId){
        return batterExecutionRepository.findById(batterExecutionId).orElseThrow(() -> new NoSuchElementException(""));
    }

}
