package designPattern.chainPattern.simple1;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/13 21:02
 */
public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger: " + message);
    }
}
