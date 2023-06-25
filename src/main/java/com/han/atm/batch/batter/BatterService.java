package com.han.atm.batch.batter;

import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterGroupExecution;
import com.han.atm.batch.domain.repository.BatterExecutionRepository;
import com.han.atm.batch.domain.repository.BatterGroupExecutionRepository;
import com.han.atm.batch.domain.repository.BatterOrderRepository;
import com.han.atm.batch.domain.repository.BatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatterService {


    private final BatterRepository batterRepository;
    private final BatterExecutionRepository batterExecutionRepository;
    private final BatterGroupExecutionRepository batterGroupExecutionRepository;
    private final BatterOrderRepository batterOrderRepository;

    /** batter */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Batter> findByBatterGroupId(int batterGroupId){
        return batterRepository.findByBatterGroupId(batterGroupId);
    }


    /** batterExecution */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution createBatterExcution(BatterExecution batterExecution){
        return batterExecutionRepository.save(batterExecution);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution findBatterExcution(Integer batterExecutionId){
        return batterExecutionRepository.findById(batterExecutionId).orElseThrow(() -> new NoSuchElementException(""));
    }

    /** batterGroupExcution */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterGroupExecution createBatterGroupExcution(BatterGroupExecution batterGroupExecution){
        return batterGroupExecutionRepository.save(batterGroupExecution);
    }


}
