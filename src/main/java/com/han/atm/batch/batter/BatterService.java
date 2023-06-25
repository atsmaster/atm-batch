package com.han.atm.batch.batter;

import com.han.atm.batch.batter.domain.Batter;
import com.han.atm.batch.batter.domain.BatterExecution;
import com.han.atm.batch.batter.domain.BatterGroup;
import com.han.atm.batch.batter.domain.BatterGroupExecution;
import com.han.atm.batch.batter.repository.BatterExecutionRepository;
import com.han.atm.batch.batter.repository.BatterGroupExecutionRepository;
import com.han.atm.batch.batter.repository.BatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatterService {


    private final BatterRepository batterRepository;
    private final BatterExecutionRepository batterExecutionRepository;
    private final BatterGroupExecutionRepository batterGroupExecutionRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Batter> findByBatterGroupId(int batterGroupId){
        return batterRepository.findByBatterGroupId(batterGroupId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterGroupExecution createBatterGroupExcution(BatterGroupExecution batterGroupExecution){
        return batterGroupExecutionRepository.save(batterGroupExecution);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution createBatterExcution(BatterExecution batterExecution){
        return batterExecutionRepository.save(batterExecution);
    }


}
