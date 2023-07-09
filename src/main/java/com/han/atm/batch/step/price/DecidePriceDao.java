package com.han.atm.batch.step.price;

import com.han.atm.batch.comm.AbstractDAO;
import com.han.atm.batch.domain.entity.BatterOrder;
import org.springframework.stereotype.Repository;

@Repository
public class DecidePriceDao extends AbstractDAO {

    public BatterOrder findPrevFilledOrder(int batterExecutionId){
        return (BatterOrder) selectOne("batch.step.decideprice.findPrevFilledOrder");
    }

}
