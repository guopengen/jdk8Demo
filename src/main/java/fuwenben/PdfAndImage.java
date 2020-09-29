package fuwenben;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.streamTest.groupByTest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/6/29 20:37
 */
public class PdfAndImage {

    public static void main(String[] args) throws Exception {
        String[] callTimes ="9-18".split(",");
        for (int i=0;i<1000;i++) {
            System.out.println(callTimes[RandomUtils.nextInt(callTimes.length)]);
        }
        /*if(!StringUtils.isBlank("9")){
            System.out.println(callTimes[RandomUtils.nextInt(callTimes.length)]);
        }*/

        /*
        String phone = decrypt("uR6HUUxHsfCBtGaPRTEzRg==","B594YN2OXWFZ3GVP");
        String ss123 = encrypt("v4AMgN39egeZf9JtDGdQsg==", "B594YN2OXWFZ3GVP");

        String[] letterSendTemplateKeyArray = "002,003".split(",");
        if (false && !(Arrays.asList(letterSendTemplateKeyArray).contains("005"))){
            System.out.println("----");
        }

        Map<String,List<People>> achievementReportMap = new HashMap<>();
        People people = new People();
        List<People> people1 = new ArrayList<>();
        people1.add(people);
        achievementReportMap.put("12",people1);
        for(Map.Entry<String, List<People>> entry1 : achievementReportMap.entrySet()){
            People p = entry1.getValue().get(0);
            p.getBigDecimal();
            if (BigDecimal.ZERO.compareTo(entry1.getValue().get(0).getBigDecimal())!=0) {
                System.out.println();
            }
        }


        System.out.println(getCacheKey("QUERY_ORG_ID", "870"));

        // 模板文件路径
        String templatePath = "E:/yuanlai.pdf";
        // 生成的文件路径
        String targetPath = "E:/result.pdf";
        // 图片路径
        String imagePath = "E:/red.png";
        // 读取模板文件
        FileInputStream input = new FileInputStream(new File(templatePath));
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
        Document document = new Document();
        // 通过域名获取所在页和坐标，左下角为起点
        float x = document.getPageSize().getWidth() - 230;
        float y = document.getPageSize().getHeight() - 730;
        // 读图片
        Image image = Image.getInstance(imagePath);
        // 获取操作的页面,使用UnderContent 而不是getOverContent
        PdfContentByte under = stamper.getUnderContent(1);
        // 根据域的大小缩放图片
        image.scaleToFit(document.getPageSize().getWidth() - 500, document.getPageSize().getHeight() - 500);
        // 添加图片
        image.setAbsolutePosition(x, y);
        under.addImage(image);

        stamper.close();
        reader.close();*/
    }


   /* public static String getCacheKey(String... key) {
        key[0]= StringUtils.join("core:base:","app:public:",key[0]);
        return String.join(":", key);
    }

    public static String decrypt(String sSrc, String keyStr) throws Exception {
        return decrypt(sSrc, keyStr.getBytes("utf-8"), keyStr.getBytes("utf-8"));
    }

    public static String encrypt(String sSrc, String keyStr) throws Exception {
        return encrypt(sSrc, keyStr.getBytes("utf-8"), keyStr.getBytes("utf-8"));
    }

    public static String decrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec _iv = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = Base64.decodeBase64(sSrc);
        byte[] original = cipher.doFinal(encrypted);
        return new String(original, "utf-8");
    }

    public static String encrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
        IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return Base64.encodeBase64String(encrypted);
    }*/

}
