package util.encryptAndDecrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * css_core
 *
 * @author: zyh
 * @date: 2019/06/18
 **/
public class AESUtil {

    public static final String CHARSET_NAME = "utf-8";
    public static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    public static final String AES = "AES";

    /**
     * 提供密钥和向量进行加密
     *
     * @param sSrc
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    private static String encrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);// "算法/模式/补码方式"
        IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(CHARSET_NAME));
        return Base64.encodeBase64String(encrypted);
    }

    /**
     * 提供密钥和向量进行解密
     *
     * @param sSrc
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    private static String decrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
        IvParameterSpec _iv = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = Base64.decodeBase64(sSrc);
        byte[] original = cipher.doFinal(encrypted);
        return new String(original, CHARSET_NAME);
    }

    /**
     * 使用密钥进行加密
     *
     * @param sSrc
     * @param keyStr
     * @return
     * @throws Exception
     */
    public static String encrypt(String sSrc, String keyStr, String iv) throws Exception {
        return encrypt(sSrc, keyStr.getBytes(CHARSET_NAME), iv.getBytes(CHARSET_NAME));
    }

    /**
     * 使用密钥进行解密
     *
     * @param sSrc
     * @param keyStr
     * @return
     * @throws Exception
     */
    public static String decrypt(String sSrc, String keyStr, String iv) throws Exception {
        return decrypt(sSrc, keyStr.getBytes(CHARSET_NAME), iv.getBytes(CHARSET_NAME));
    }


    public static void main(String[] args) {
        try {
            String encryptStr = AESUtil.encrypt("18310121964", "abc123abc1234567", "abc123abc1234567");
            System.out.println(encryptStr);
            String decryptStr = AESUtil.decrypt(encryptStr, "abc123abc1234567", "abc123abc1234567");
            System.out.println(decryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
