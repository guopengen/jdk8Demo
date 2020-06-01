package designPattern.chainPattern.impur;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/14 10:38
 */
public abstract class AbstractMethodResultHandler {
    protected AbstractMethodResultHandler nextHandler;

    public AbstractMethodResultHandler() {
    }

    public AbstractMethodResultHandler(AbstractMethodResultHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(DealPerson dealPerson);

    public void setNextHandler(AbstractMethodResultHandler nextHandler) {
        this.nextHandler = nextHandler;

    }
}