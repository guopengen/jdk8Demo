package designPattern.chainPattern.simple1;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/13 21:04
 */
public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        errorLogger.logMessage(AbstractLogger.INFO, "This is an info information.");
        errorLogger.logMessage(AbstractLogger.DEBUG, "This is a debug  information.");
        errorLogger.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
