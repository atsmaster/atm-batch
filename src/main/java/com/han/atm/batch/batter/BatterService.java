package com.han.atm.batch.batter;

import com.han.atm.batch.batter.domain.BatterExecution;
import com.han.atm.batch.batter.repository.BatterExecutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatterService {

    private final BatterExecutionRepository batterExecutionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BatterExecution createBatter(BatterExecution batterExecution){
        return batterExecutionRepository.save(batterExecution);
    }
}
