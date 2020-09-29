package test;

import linshi.Content;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/7/17 14:46
 */
public class TestHt extends Thread{
    private static int count = 0;

    @Override
    public void run() {

        System.out.println(StringUtils.equals(null,"2"));
        System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        /*try{
            System.out.println(this.getClass().getSimpleName()+"--"+(++count));
            String str = null;
            // 制造空指针NPE
            System.out.println(str.length());
        }catch (Throwable e){
           // e.printStackTrace();
            System.out.println("e===="+e);
        }*/
    }
}

 class FastThrowMain {
    public static void main(String[] args) throws InterruptedException {

        String authStr = "";
        String[] authArray = authStr.split(",");
        List<String> authList = new ArrayList<String>(Arrays.asList(authArray));
        /*TestHt withNPE = new TestHt();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            executorService.execute(withNPE);
            // 稍微sleep一下, 是为了不要让异常抛出太快, 导致控制台输出太快, 把有异常栈信息冲掉, 只留下fast throw方式抛出的异常
            Thread.sleep(2);
        }*/
        System.out.println(StringUtils.equals(null,"2"));
        String url = "http://storage.jd.com/ccs.core/batch.main/202008/20200805222617-%E6%89%B9%E9%87%8F%E5%8F%91%E8%B5%B7%E6%A8%A1%E6%9D%BF_zxj66%E7%9A%84%E5%89%AF%E6%9C%AC.xlsx?Expires=3744121224&AccessKey=OZmd5qfL4yyjee9E&Signature=fzDuEo4KNndOGQgA3gHHYGWzD9o%3D";
        String path = url.substring(url.indexOf("batch.main"), url.indexOf("?"));
        System.out.println(path);

        String path1 = "/test/dynamicConfig.properties";
        String newpath=path1.substring(path1.lastIndexOf("/"));
    }
}
