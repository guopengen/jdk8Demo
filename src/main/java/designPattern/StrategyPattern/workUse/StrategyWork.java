package designPattern.StrategyPattern.workUse;

import java.util.Date;

/**
 * @Description 策略模式抽象接口
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:27
 */
public interface StrategyWork {
    public void calculation(Long appId,String productType,Date date);
}
