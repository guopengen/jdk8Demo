package designPattern.chainPattern.impur;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/14 10:46
 */
public class ImpurMain {
    public static void main(String[] args) {
        AbstractMethodResultHandler valueAHandler = new ValueAHandler();
        AbstractMethodResultHandler valueBHandler = new ValueBHandler();
        AbstractMethodResultHandler valueCHandler = new ValueCHandler();
        valueAHandler.setNextHandler(valueBHandler);
        valueBHandler.setNextHandler(valueCHandler);

        DealPerson dealPerson = new DealPerson();
        dealPerson.setName("xiaoming");
        dealPerson.setAge(14);
        dealPerson.setGender("man");
        valueAHandler.handle(dealPerson);
    }
}
