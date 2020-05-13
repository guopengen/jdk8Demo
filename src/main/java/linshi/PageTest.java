package linshi;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang3.time.DateUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/15 19:27
 */
public class PageTest {
    public static void main(String[] args) throws Exception{
        Date date1 = new SimpleDateFormat("yyyyMMdd").parse("20200415");
        Date test = getFirstDateOfMonth(date1, 0);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(test));
        Date date2 = new SimpleDateFormat("yyyyMMdd").parse("20200415");
        Date test2 = getFirstDateOfMonth(date2, -1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(test2));



        Date hh0 = getFirstDateOfMonth(new Date(), 0);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(hh0));

        Date hh = getFirstDateOfMonth(new Date(), 1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(hh));

        Date hh1 = getFirstDateOfMonth(new Date(), 2);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(hh1));

        Date hh2 = getFirstDateOfMonth(new Date(), 3);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(hh2));


        Date date = new Date();
        System.out.println(DateUtils.addMinutes(date, -60));

        List<String> list=new ArrayList<String>();
        list.add("111");
        list.add("222");
        /*list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add("999");
        list.add("1010");*/



        /*int count=list.size();
        int a=Integer.valueOf(2);
        int b=count/a;
        int c=count%a;
        if(c!=0)b++;
        for(int j=1;j<=b;j++){
            System.out.println( (j - 1) * a+"---"+a);//mybatis分页查询
            System.out.println(list.subList((j - 1) * a,2));
        }*/
        int page=1;//第几页，1开始
        int rows=10;//每页显示的条数
        List<String> listSort = new ArrayList<>();


        list.add(0,"000");
        int size=list.size();

        int pageStart=page==1?0:(page-1)*rows;//截取的开始位置
        int pageEnd=size<page*rows?size:page*rows;//截取的结束位置

        if(size>pageStart){
        listSort =list.subList(pageStart, pageEnd);
        }
        //总页数
         int totalPage=(list.size()-1)/rows;

        System.out.println(listSort);
        System.out.println(totalPage);


       /* long oldTime = System.currentTimeMillis();
        System.out.println(oldTime);

        Thread.sleep(12430);

        long nowTime = System.currentTimeMillis();
        System.out.println(nowTime);
        long i = nowTime - oldTime;
        System.out.println(nowTime - oldTime);
        System.out.println(i/1000);*/


        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        System.out.println(pattern.matcher("12344e").matches());
    }

    public static String getTime(Integer date) {
        if (date<60) {
            return date+"秒";
        }else if (date>60&&date<3600) {
            int m = date/60;
            int s = date%60;
            return m+"分"+s+"秒";
        }else {
            int h = date/3600;
            int m = (date%3600)/60;
            int s = (date%3600)%60;
            return h+"小时"+m+"分"+s+"秒";
        }
    }

    public static void cal(int i){
        i++;
    }

    public static Date getDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getFirstDateOfMonth(Date date,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
