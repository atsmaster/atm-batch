package com.han.atm.batch.step.decideprice;

import com.han.atm.batch.comm.AbstractDAO;
import com.han.atm.batch.domain.entity.BatterOrder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public class DecidePriceDao extends AbstractDAO {

    public BatterOrder findMaxFilledOrder(){
        return (BatterOrder) selectOne("batch.step.decideprice.findMaxFilledOrder");
    }

}
