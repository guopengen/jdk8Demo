package designPattern.StrategyPattern.simple;

/**
 * @Description 具体策略类
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:29
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
