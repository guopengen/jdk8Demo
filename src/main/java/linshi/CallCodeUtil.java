package linshi;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 录音接口加解密工具
 *
 * @author bozhao
 * @date 2020/1/7
 * * @param null
 */
public class CallCodeUtil {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    private static final String UTF8 = "UTF-8";

    private static final String AES = "AES";

    // 不足16的倍數的時候，补空格
    private static final int BYTE_BLANK = 32;
    private static final int FIEXD_SIZE = 16;


    private static byte[] base64Decode(final String safeBase64Str) {
        byte[] result = null;
        try {
            result = new BASE64Decoder().decodeBuffer(safeBase64Str);
        } catch (Exception e) {
        }
        return result;
    }


    private static String base64Encode(byte[] data) {
        String encodeBase64 = new BASE64Encoder().encode(data);
        return encodeBase64;
    }

    //AES加密
    public static byte[] AES_cbc_encrypt(byte[] srcData, byte[] key, byte[] iv) {
        if (srcData == null || srcData.length == 0) {
            return new byte[0];
        }
        int offset = FIEXD_SIZE - srcData.length % 16;
        if (offset != 0) {
            byte[] temp = new byte[srcData.length + offset];
            System.arraycopy(srcData, 0, temp, 0, srcData.length);
            for (int i = srcData.length; i < temp.length; i++) {
                temp[i] = BYTE_BLANK;
            }
            srcData = temp;
        }
        SecretKeySpec keySpec = new SecretKeySpec(key, AES);
        byte[] encData = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
            encData = cipher.doFinal(srcData);
        } catch (
                Exception e) {
        }
        return encData;
    }

    //AES解密
    public static byte[] AES_cbc_decrypt(byte[] encData, byte[] key, byte[] iv) {
        SecretKeySpec keySpec = new SecretKeySpec(key, AES);
        byte[] decbbdt = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
            decbbdt = cipher.doFinal(encData);
        } catch (
                Exception e) {
        }
        return decbbdt;
    }

    //加密
    public static String encode(String source, String keyStr, String ivStr) {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(keyStr) || StringUtils.isBlank(ivStr)) {
            return null;
        }
        byte[] key = keyStr.getBytes();
        byte[] iv = ivStr.getBytes();
        byte[] sourceByte = null;
        try {
            sourceByte = source.getBytes(UTF8);
        } catch (Exception e) {
        }
        byte[] temp = AES_cbc_encrypt(sourceByte, key, iv);
        String base64Str = base64Encode(temp);
        return base64Str;
    }

    //解密
    public static String decode(String source, String keyStr, String ivStr) {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(keyStr) || StringUtils.isBlank(ivStr)) {
            return null;
        }
        byte[] key = keyStr.getBytes();
        byte[] iv = ivStr.getBytes();
        byte[] base64Decode = base64Decode(source);
        byte[] aesDecode = AES_cbc_decrypt(base64Decode, key, iv);
        String target = null;
        try {
            target = new String(aesDecode, UTF8);
        } catch (Exception e) {
        }
        return StringUtils.isBlank(target) ? null : target.trim();
    }

    /*
     * 加密：AES ---> BASE64
     * 解密：BASE64 ----> AES
     */
    public static void main(String[] args) throws Exception {

        String key = "JDPASS2020000000";
        String iv = "jd2020@1833_0601";
        RecodeParam recodeParam = new RecodeParam();
        recodeParam.setCallid("2019122316594162001380");
        //recodeParam.setComplexrecord("1");
        recodeParam.setDepnum("8002");
        recodeParam.setPageinfo("1_60");
        /*recodeParam.setAgentname("");
        recodeParam.setCaller("");
        recodeParam.setGroupename("");
        recodeParam.setRecordtime("");
        recodeParam.setTalklen("");
        recodeParam.setCalled("");*/
        String str = JSON.toJSONString(recodeParam);
        System.out.println("加密前："+str);
        //String srcStr = "DL1Vn9SLQz3uEgJfr9hCQGeQWNVuVyGPF7SDUEVAAXphpk7Y4ivExa0CCStgYN/Cx8/3/0H96DzdfPYeggbJScRYOFvdhVrRT2xpuKpDNEmVN1TZd0siYDX9ykEoY5cZ1nXjdU39dtyaAQY+4197SDsXjwWuHw1AwJosxpFLGeTsAMJPwIq/gpVr2r3D8MBzrvAT+ea7d83eUKPvOoaVKgZuswF4q1WGfUlA50IbArdGgb5ljQQhiXYZWJjbmcBMallA3R9WSUtvbWFGq0Tplof5UB14VRTcuzLWFHm7TAHeR45bhmWAd6UE+t52jadAcXPufxaAeEe6AmpJkRwXiqZiVMOPXVnUG3EUwBdMCv1h9L1Gt9cxc0DpG/xrgfCxopntRg+0TK7WnesBuROjYQ1VChzG+Yep0ZrMXMQB7nDbJw6kOmR0AeLfTZygnVNTZmD3bM1gzbcknGgUvxEWHJ42R046GTtyHYCK+sGXOFZIitsXAkQLfc34VqFikcMtqloT2ubJApE58X+IF8ub7YbAcbjJftRk7Hd9aVnMk8Y=";
        byte[] encbt = AES_cbc_encrypt(str.getBytes(), key.getBytes(), iv.getBytes());
        String encStr = new String(base64Encode(encbt));
        System.out.println(encStr);
//        byte[] debase64 = base64Decode(encStr);
//        byte[] decbt = AES_cbc_decrypt(debase64, key, iv);
//        String decStr = new String(decbt);
//        System.out.println(decStr);
//        if (srcStr.equals(decStr)) {
//            System.out.println("TEST PASS");
//        } else {
//            System.out.println("TEST NO PASS");
//        }
//        String enStr = encode(srcStr, key, iv);
//        System.out.println(enStr);
        //String deStr = decode(srcStr, key, iv);
        //System.out.println(deStr);
    }
}
