package linshi;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2019/12/26 15:28
 */
public class AppMain {
    public static final String CHARSET_NAME = "utf-8";
    public static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    public static final String AES = "AES";
    // 不足16的倍數的時候，补空格
    private static final int BYTE_BLANK = 32;
    private static final int FIEXD_SIZE = 16;
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2.25");
        BigDecimal b = new BigDecimal("2.29");
        BigDecimal d = new BigDecimal("2.29");
        BigDecimal batchReachRateA = new BigDecimal(0);
        batchReachRateA = a.divide(b, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
        d = batchReachRateA.multiply(new BigDecimal(0.5));
        System.out.println(d.setScale(2,BigDecimal.ROUND_HALF_UP));

        String fileName = "D:qw/123/qq.txt";
        String fileType = fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
        System.out.println(fileType);

        String a1 = "a1";
        String a2 = "a2";
        String[] array = ArrayUtils.toArray(a1,a2);
        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }


        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person("zhangsan",12);
        Person p2 = new Person("lisi",13);
        Person p3 = new Person("wangwu",14);
        Person p4 = new Person("zhaoliu",15);
        Person p5 = new Person("zhaoliu",11);

        String str11 = "";
        Gson gson = new Gson();
        List<Person> hh = (List<Person>) gson.fromJson(str11, new TypeToken<List<Person>>() {}.getType());

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        //personList.add(p5);

        for (Person p : personList) {
            p.setAge(10);
        }
        System.out.println(personList);

        Map<String, Person> caseVoMap = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        System.out.println(caseVoMap);

        Map<String, Person> caseMainMap = personList.stream().filter(main -> main != null).collect(
                Collectors.toMap(Person::getName, Function.identity(),
                        (v1, v2) -> {
                            return v1;
                        }
                )
        );
        System.out.println(caseMainMap);

        Map<String, List<Person>> configMap = new HashMap<>();
        for (Person config : personList) {
            String name = config.getName();
            List<Person> list = new ArrayList<>();
            if (configMap.get(name) == null) {
                list = new ArrayList<>();
                list.add(config);
                configMap.put(name, list);
            } else {
                list = configMap.get(name);
                list.add(config);
            }
        }
        System.out.println(configMap);

        /*String phone = "北京大1";
        String adress = "123456";
        System.out.println(phone.substring(0,3)+"****"+phone.substring(phone.length()-4));
        System.out.println(adress.substring(0,6)+"********");

        List<Third> thirds = new ArrayList<Third>();

        Third third1 = new Third();
        First first1 = new First(1);
        Second second1 = new Second("dd");
        third1.setFirst(first1);
        third1.setSecond(second1);

        Third third2 = new Third();
        First first2 = new First(2);
        Second second2 = new Second("ss");
        third2.setFirst(first2);
        third2.setSecond(second2);

        thirds.add(third1);
        thirds.add(third2);
        List<First> firstList = thirds.stream().map(Third::getFirst).collect(Collectors.toList());
        for (First fir : firstList) {
            Integer i = fir.getFirstNum();
            fir.setFirstNum(i+1);
            System.out.println(fir.getFirstNum());
        }
        System.out.println(thirds);*/


        //Calendar
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

        //jodaTime
        DateTime recordCreateTime = new DateTime();
        System.out.println(DateTime.now().getDayOfMonth());
        System.out.println(recordCreateTime.getDayOfMonth());
        System.out.println(recordCreateTime.getYear());


        try {
            Date statisticDate = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            Date date = DateUtils.addDays(statisticDate, -1);
            System.out.println("==========date:"+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(getCidConsByCidCode("130425198708141015"));
        System.out.println(new DateTime().getYear() - Integer.parseInt("130425198708141015".substring(6,10)));


        Date startDate = getDayStart(new Date());
        Date endDate = getDayStart(new Date(), 0);
        Date endDate1 = getDayStart(new Date(), 1);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(endDate1+"======================");


        Date today1 = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(today);
        calendar.get(Calendar.DAY_OF_YEAR);
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("hour1:"+hour1);

        //json
        Person ps = new Person();
        ps.setAge(14);
        ps.setBigDecimal(new BigDecimal(23));
        System.out.println(JSON.toJSONString(ps));
        String htIvrUrl = "http://www.baidu.com/";
        System.out.println(htIvrUrl + "posttask/?type=1");



        //分批次执行
        List<Person> personList1 = new ArrayList<Person>();
        Person p11 = new Person("zhangsan",12);
        Person p21 = new Person("lisi",13);
        Person p31 = new Person("wangwu",14);
        Person p41 = new Person("zhaoliu",15);
        Person p51 = new Person("zhaoliu",11);

        personList1.add(p11);
        personList1.add(p21);
        personList1.add(p31);
        personList1.add(p41);
        personList1.add(p51);

        List<Person> personList2 = new ArrayList<>();

        int countPerBatch = 3;
        int start = 0;
        int end = countPerBatch < personList1.size() ? countPerBatch : personList1.size();
        while (true) {
            if (start == end) {
                break;
            }
            try {
                personList2 = personList1.subList(start, end);
                //batchTaskMainListResult = urgeRecordService.launchBatchSpecificityCaseRecord(batchTaskMainList, user);
                System.out.println("++++++++++");
                System.out.println(personList2);
                System.out.println("----------");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                start = end;
                end = (end + countPerBatch) < personList1.size() ? (end + countPerBatch) : personList1.size();
            }
        }


        String result1 = "{\"res\":\"{\\\"defeatSize\\\":1,\\\"responses\\\":[{\\\"caseNumber\\\":\\\"daee6f2cdd514d23bfaae929d77066bc23380480\\\",\\\"errCode\\\":2}],\\\"successSize\\\":0,\\\"totalSize\\\":1}\",\"code\":7}";
        String result2 = "{\"res\":\"9\",\"code\":7}";
        QzSpecificityCase importQzSpecificityCase = JSON.parseObject(result1, QzSpecificityCase.class);
        QzSpecificityCaseRes qzSpecificityCaseRes = JSON.parseObject(importQzSpecificityCase.getRes(),QzSpecificityCaseRes.class);
        System.out.println(importQzSpecificityCase);

        /*List<QzSpecificityCaseResInfo> qzSpecificityCaseResInfoList = new ArrayList<>();
        QzSpecificityCaseResInfo qzSpecificityCaseResInfo = new QzSpecificityCaseResInfo();
        qzSpecificityCaseResInfo.setCaseNumber("232dd");
        qzSpecificityCaseResInfo.setErrCode(3);

        QzSpecificityCaseRes qzSpecificityCaseRes = new QzSpecificityCaseRes();
        qzSpecificityCaseRes.setDefeatSize(1);
        qzSpecificityCaseRes.setResponses();*/



        //加密：
        try {
            RecodeParam recodeParam = new RecodeParam();
            recodeParam.setCallid("2020020818221372101006");
            recodeParam.setComplexrecord("1");
            recodeParam.setDepnum("8004");
            recodeParam.setPageinfo("1_60");
            /*recodeParam.setAgentname("");
            recodeParam.setCaller("");
            recodeParam.setGroupename("");
            recodeParam.setRecordtime("");
            recodeParam.setTalklen("");
            recodeParam.setCalled("");*/
            String str = JSON.toJSONString(recodeParam);
            System.out.println("加密前："+str);
            System.out.println("加密后："+encrypt(str, "JDPASS2020000000".getBytes(), "jd2020@1833_0601".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //解密：

        String decryptStr = "eyJjYXNlVHlwZSI6IkExLVdFQUsiLCJjb21wYW55TW9iaWxlIjoiMTAwODYiLCJjb21wYW55U2VsZiI6IuW+ruS/oeWFrOS8l+WPt+i/mOasvjEiLCJjdXN0S2V5IjoiemhhbmdtZW5nXzA0MjEyMyIsImN1c3ROYW1lIjoiTTAwNDIxMjMiLCJlbnRydXN0QXBwTmFtZSI6ImhhbmdnZXJCaXoiLCJnZW5kZXIiOiLlpbMiLCJvdmVyZHVlQW1vdW50IjoyMDAuMDAsIm92ZXJkdWVEYXkiOjEwLCJwcm9kdWN0VHlwZURlc2MiOiLnmb3mnaEiLCJyZXBheVdheSI6IuW+ruS/oeWFrOS8l+WPt+i/mOasviIsInRvdGFsQW1vdW50IjoxMDAwLjAwfQ==";
        System.out.println("解密前："+decryptStr);
        try {
            String str = decrypt(decryptStr, "JDPASS2020000000".getBytes(CHARSET_NAME), "jd2020@1833_0601".getBytes(CHARSET_NAME));
            Decrypt decrypt = JSON.parseObject(str, Decrypt.class);
           // System.out.println(decrypt);
            System.out.println("解密后："+decrypt(decryptStr, "JDPASS2020000000".getBytes(CHARSET_NAME), "jd2020@1833_0601".getBytes(CHARSET_NAME)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Date todayTest = new Date();
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.setTime(todayTest);
        calendarTest.set(Calendar.HOUR_OF_DAY, 0);
        calendarTest.set(Calendar.MINUTE, 0);
        calendarTest.set(Calendar.SECOND, 0);
        calendarTest.set(Calendar.MILLISECOND, 0);
        System.out.println(calendarTest.getTime());
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        };



        String executeDateStr = "20200213";
        Date executeDate = null;
        if (StringUtils.isNotEmpty(executeDateStr)) {
            try {
                System.out.println("1");
                executeDate = new SimpleDateFormat("yyyyMMdd").parse(executeDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (executeDate == null) {
            try {
                System.out.println("2");
                executeDate = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("executeDate:"+executeDate);



    }

    //加密
    public static String encrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);// "算法/模式/补码方式"
        IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(CHARSET_NAME));
        return Base64.encodeBase64String(encrypted);
    }

    //偏移量
    public static byte[] getSrcBytes(byte[] srcData){
        int offset = FIEXD_SIZE - srcData.length % 16;
        if (offset != 0) {
            byte[] temp = new byte[srcData.length + offset];
            System.arraycopy(srcData, 0, temp, 0, srcData.length);
            for (int i = srcData.length; i < temp.length; i++) {
                temp[i] = BYTE_BLANK;
            }
            srcData = temp;
        }
        return srcData;
    }

    //解密
    public static String decrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
        IvParameterSpec _iv = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = Base64.decodeBase64(sSrc);
        byte[] original = cipher.doFinal(encrypted);
        return new String(original, CHARSET_NAME);
    }


    public static String getCidConsByCidCode(String cidCode){
        String result = "";
        if (StringUtils.isNotEmpty(cidCode)){
            int month = Integer.parseInt(cidCode.substring(10, 12));
            int day = Integer.parseInt(cidCode.substring(12, 14));
            if ((month == 1 && day >= 21) || (month == 2 && day <= 19)) {
                result = "水瓶座";
            } else if ((month == 2 && day >= 20) || (month == 3 && day <= 20)) {
                result = "双鱼座";
            } else if ((month == 3 && day >= 21) || (month == 4 && day <= 20)) {
                result = "白羊座";
            } else if ((month == 4 && day >= 21) || (month == 5 && day <= 21)) {
                result = "金牛座";
            } else if ((month == 5 && day >= 22) || (month == 6 && day <= 21)) {
                result = "双子座";
            } else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
                result = "巨蟹座";
            } else if ((month == 7 && day >= 23) || (month == 8 && day <= 23)) {
                result = "狮子座";
            } else if ((month == 8 && day >= 24) || (month == 9 && day <= 23)) {
                result = "处女座";
            } else if ((month == 9 && day >= 24) || (month == 10 && day <= 23)) {
                result = "天秤座";
            } else if ((month == 10 && day >= 24) || (month == 11 && day <= 22)) {
                result = "天蝎座";
            } else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) {
                result = "射手座";
            } else if ((month == 12 && day >= 22) || (month == 1 && day <= 20)) {
                result = "魔羯座";
            }
            return result;
        }
        return result;
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
}
