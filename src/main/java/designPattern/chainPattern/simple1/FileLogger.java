package designPattern.chainPattern.simple1;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/13 21:03
 */
public class FileLogger extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
