package designPattern.strategyPattern.simple;

/**
 * @Description 具体策略类
 * @Author wangpengfei101022
 * @Date 2020/4/29 22:28
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
