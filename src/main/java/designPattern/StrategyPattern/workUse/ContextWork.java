package designPattern.StrategyPattern.workUse;

import designPattern.StrategyPattern.simple.Strategy;

import java.util.Date;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:58
 */
public class ContextWork {
    private StrategyWork strategyWork;

    public ContextWork(StrategyWork strategyWork){
        this.strategyWork = strategyWork;
    }

    public void calculation(Long appId,String productType,Date date){
        strategyWork.calculation(appId,productType,date);
    }
}
