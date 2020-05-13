package designPattern.strategyPattern.workUse;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:52
 */
@Slf4j
public class CalculationB1 implements StrategyWork{

    @Override
    public void calculation(Long appId,String productType,Date date) {
        System.out.println("appId:"+appId+",productType:"+productType+",caseType:B1");
    }
}
