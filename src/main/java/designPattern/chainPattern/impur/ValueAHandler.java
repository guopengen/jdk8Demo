package designPattern.chainPattern.impur;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/14 10:43
 */
public class ValueAHandler extends AbstractMethodResultHandler {

    @Override
    public void handle(DealPerson dealPerson) {
        // 设置属性A的值
        //result.setValA("value a");
        if (dealPerson.getName().equals("xiaoming")){
            System.out.println("xiaoming  ---  A");
        }
        // 继续处理
        if (null != nextHandler) {
            nextHandler.handle(dealPerson);
        }
    }
}
