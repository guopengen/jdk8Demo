package linshi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/26 14:21
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        String yesterDayRepay = "173.31";
        String beforeYesterDayRepay = "153.24";
        System.out.println((new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))));
        System.out.println((new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))).divide(new BigDecimal(yesterDayRepay),4,BigDecimal.ROUND_HALF_UP));
        System.out.println((new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))).divide(new BigDecimal(yesterDayRepay),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));

        BigDecimal str = (new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))).divide(new BigDecimal(yesterDayRepay),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        System.out.println(str);
        System.out.println((new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))).divide(new BigDecimal(yesterDayRepay),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP));

        //System.out.println((new BigDecimal(yesterDayRepay).subtract(new BigDecimal(beforeYesterDayRepay))).divide(new BigDecimal(yesterDayRepay)).multiply(new BigDecimal(100)).toString());
        System.out.println(new BigDecimal("1.24").doubleValue());
        System.out.println(new BigDecimal(1.24).doubleValue());

        BigPerson bigPerson = new BigPerson();
        bigPerson.setName("xiaowang");
        bigPerson.setMoney(new BigDecimal(1.2));

        BigPerson bigPerson1 = new BigPerson();
        bigPerson1.setName("wangwu");
        bigPerson1.setMoney(new BigDecimal(2.2));

        BigPerson bigPerson2 = new BigPerson();
        bigPerson2.setName("zhaoliu");
        bigPerson2.setMoney(new BigDecimal(1.5));

        List<BigPerson> bigPersonList = new ArrayList<>();
        bigPersonList.add(bigPerson);
        bigPersonList.add(bigPerson1);
        bigPersonList.add(bigPerson2);
        bigPersonList.sort((x, y) -> y.getMoney().compareTo(x.getMoney()));
        System.out.println(bigPersonList);

        /*BigDecimal callTime = new BigDecimal("0");
        BigDecimal callTime1 = new BigDecimal("100");
        BigDecimal callTime2 = new BigDecimal("33.3833");

        BigDecimal callTime3= new BigDecimal("3210.5");
        System.out.println(callTime2.divide(callTime1, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(callTime3.multiply(new BigDecimal(100)));*/
    }


}
