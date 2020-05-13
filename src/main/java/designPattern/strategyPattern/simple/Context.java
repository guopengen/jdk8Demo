package designPattern.strategyPattern.simple;

/**
 * @Description 环境实现类
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:40
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
