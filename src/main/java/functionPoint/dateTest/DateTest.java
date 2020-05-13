package functionPoint.dateTest;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/13 19:50
 */
public class DateTest {
    public static void main(String[] args) {
        getWeekMonthYear();
    }

    public static void getWeekMonthYear(){
        Map<String, Integer> mapInt = new LinkedHashMap<String, Integer>();
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        calendar.setTime(today);// 此处可换为具体某一时间
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        int yearDay = calendar.get(Calendar.DAY_OF_YEAR);
        if (weekDay == 1) {
            weekDay = 7;
        } else {
            weekDay = weekDay - 1;
        }
        mapInt.put("周", weekDay);
        mapInt.put("月", monthDay);
        mapInt.put("年", yearDay);
        for (Map.Entry<String, Integer> entry : mapInt.entrySet()) {
            System.out.println("今天是本" + entry.getKey() + "的第" + entry.getValue() + "天");
        }
    }
}
