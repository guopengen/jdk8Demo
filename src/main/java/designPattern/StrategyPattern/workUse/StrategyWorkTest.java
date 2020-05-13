package designPattern.StrategyPattern.workUse;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/29 23:00
 */
public class StrategyWorkTest {
    public static void main(String[] args) {
        getWeekMonthYear();
        System.out.println(getSeqList());
        /*System.out.println(new Date().getDay());
        List<Long>  appIdList = Arrays.asList(11L,12L);
        List<String>  productTypeList = Arrays.asList("8-JDBT","8-JDJT");
        for (Long appId : appIdList) {
            for (String productType : productTypeList) {
                ContextWork contextWorkB0 = new ContextWork(new CalculationB0());
                contextWorkB0.calculation(appId,productType,new Date());

                ContextWork contextWorkB1 = new ContextWork(new CalculationB1());
                contextWorkB1.calculation(appId,productType,new Date());
            }
        }*/
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

    private static List<Integer> getSeqList() {
        List<Integer> seqList = null;
        if (seqList == null) {

                if (seqList == null) {
                    List<Integer> list = new ArrayList<>();
                    String[] seqArray = "1,1-100".split(",");
                    for (int i = 0; i < seqArray.length; i++) {
                        if (seqArray[i].contains("-")) {
                            int start = Integer.parseInt(seqArray[i].split("-")[0]);
                            int end = Integer.parseInt(seqArray[i].split("-")[1]);
                            for (int m = start; m <= end; m++) {
                                list.add(m);
                            }
                        } else {
                            list.add(Integer.parseInt(seqArray[i]));
                        }
                    }
                    seqList = list;
                }

        }
        return seqList;
    }
}
