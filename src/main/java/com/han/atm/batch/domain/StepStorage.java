package com.han.atm.batch.domain;

import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StepStorage {
    private Batter batter;
    private BatterExecution batterExecution;
    private BatterOrder batterOrder;
}
