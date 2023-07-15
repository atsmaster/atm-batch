package com.han.atm.batch.step.symbol;

import com.han.atm.batch.comm.AbstractDAO;
import com.han.atm.batch.domain.entity.BatterOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DecideSymbolDao extends AbstractDAO {

    public List findSymbolTradingAndUsdt(){
        return selectList("batch.step.decidesymbol.findSymbolTradingAndUsdt");
    }

}
