package designPattern.strategyPattern.workUse;

import java.util.*;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/29 23:00
 */
public class StrategyWorkTest {
    public static void main(String[] args) {
        List<Long>  appIdList = Arrays.asList(11L,12L);
        List<String>  productTypeList = Arrays.asList("8-JDBT","8-JDJT");
        for (Long appId : appIdList) {
            for (String productType : productTypeList) {
                ContextWork contextWorkB0 = new ContextWork(new CalculationB0());
                contextWorkB0.calculation(appId,productType,new Date());

                ContextWork contextWorkB1 = new ContextWork(new CalculationB1());
                contextWorkB1.calculation(appId,productType,new Date());
            }
        }
    }

}
