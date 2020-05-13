package linshi;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/18 22:54
 */
public class DayOfMonth {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM");
        String achievementMonth = formatter.format(new Date());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String firstday, lastday;
        // 获取前月的第一天
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND,0);
        cale.set(Calendar.MILLISECOND, 0);
        firstday = format.format(cale.getTime());
        System.out.println(firstday);

        /*Map<String, String> dataMap = new HashMap<>();
        dataMap.put("userIdList", GsonUtils.toJson(subUserIdList));
        dataMap.put("productType", GsonUtils.toJson(productType));
*/
        /*long time = System.currentTimeMillis();
        String returnTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
        System.out.println(returnTime);*/
        /*Date startDate = getDayStart(new Date());
        Date endDate = getDayStart(new Date(), 1);
        System.out.println(startDate);
        System.out.println(endDate);*/
       /* String calculateDateStr = "20200211";

        Date calculateDate = new SimpleDateFormat("yyyyMMdd").parse(calculateDateStr);
        System.out.println(getDayListOfMonth1(new Date()));
        System.out.println(getDayListOfMonth1(calculateDate));*/
    }

    public static List<String> getDayListOfMonth() {
        List<String> list = new ArrayList<String>();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate = String.valueOf(year)+"-"+month+"-"+i;
            list.add(aDate);
        }
        return list;
    }

    public static List<String> getDayListOfMonth1(Date date) {
        List<String> list = new ArrayList<String>();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(date);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);

        for (int i = 1; i <= day; i++) {
            String strMonth = "";
            String strI = "";
            if(month < 10){
                strMonth = "0"+month;
            } else{
                strMonth = ""+month;
            }
            if(i < 10){
                strI = "0"+i;
            } else{
                strI = ""+i;
            }
            String aDate = String.valueOf(year)+"-"+strMonth+"-"+strI;
            list.add(aDate);
        }
        return list;
    }

    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDayStart(Date date, int next) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, next);
        return calendar.getTime();
    }

    public static long getSencondsToNextDay() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date tomorrow = calendar.getTime();
        long sen = (tomorrow.getTime() - now.getTime()) / 1000;
        return sen;
    }


}
