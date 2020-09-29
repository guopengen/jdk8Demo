package util.base;

import java.util.regex.Pattern;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/7/7 18:37
 */
public class PhoneoOperator {
    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173,199
     **/
    private static final String  CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[012789]|7[28]|8[23478]|9[578])\\d{8}$)";

    /**
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
     **/
    private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[56]|5[56]|6[6]|7[0156]|8[56]|9[6])\\d{8}$)";

    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
     **/
    private static final String CHINA_TELECOM_PATTERN = "(^1(3[3]|4[19]|5[3]|7[3479]|8[019]|9[0139])\\d{8}$)";

    public static String isChinaMobilePhoneNum(String tel) {
        boolean b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_MOBILE_PATTERN, tel);
        if (b1) {
            return "yd";
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_UNICOM_PATTERN, tel);
        if (b1) {
            return "lt";
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_TELECOM_PATTERN, tel);
        if (b1) {
            return "dx";
        }
        return "error";
    }

    private static boolean match(String regex, String tel) {
        return Pattern.matches(regex, tel);
    }

    public static void main(String[] args) {
        String phone = "18310121964";
        System.out.println(isChinaMobilePhoneNum(phone));
        System.out.println(phone);
    }
}
