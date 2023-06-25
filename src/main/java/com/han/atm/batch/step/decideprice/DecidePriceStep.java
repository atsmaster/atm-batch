package com.han.atm.batch.step.decideprice;

import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.code.OrderStatusCd;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DecidePriceStep {

    private final BatterService batterService;
    private final DecidePriceDao decidePriceDao;


    public BatterStatusCd run(int batterExecutionId){
        BatterStatusCd nextBatterStatusCd = null;

        BatterOrder maxFilledOrder = decidePriceDao.findMaxFilledOrder();
        OrderStatusCd orderStatusCd = maxFilledOrder.getOrderStatusCd();





        return null;
    }
}
