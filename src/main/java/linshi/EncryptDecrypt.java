package linshi;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/12 17:50
 */
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.alibaba.fastjson.JSONObject;

public class EncryptDecrypt {
    /*private String ALGO = "AES";
    private String ALGO_MODE = "AES/CBC/NoPadding";
    private String akey = "11111111111111111111111111111111";
    private String aiv = "22222222222222222222222222222222";

    public static void main(String[] args) throws Exception {
        EncryptDecrypt aes = new EncryptDecrypt();//创建AES
        JSONObject data = new JSONObject();//创建Json的加密对象
        data.put("haha", "hehe");
        System.out.println("原始数据:"+data.toJSONString());
        String rstData = pkcs7padding(data.toJSONString());//进行PKCS7Padding填充
        String passwordEnc = aes.encrypt(rstData);//进行java的AES/CBC/NoPadding加密

        passwordEnc = "DHLFqTCg8RGq+duLMgBEaQN73qNsN5AJ5W8GRotyMt8BBWMxYkmnPDkrnRioN3m6u3tXdYl+EYXFc3myAuCq9rlBf9qyF/+mpACZwpg9KXRUov63miMOa75VyZUP3uNiATBqgot9LvyhsZsKlP1NQreKb/VhRhhTyfkDlzWiI1+NlUmK+nhpihGJSOpGuw811OLj+xYQkaY1eZvvbTSEBeGQI74sfRIch724LZH0zYo=";
        String passwordDec = aes.decrypt(passwordEnc);//解密
        System.out.println("加密之后的字符串:"+passwordEnc);
        System.out.println("解密后的数据:"+passwordDec);
    }

    public String encrypt(String Data) throws Exception {
        try {
            byte[] iv = toByteArray(aiv);//因为要求IV为16byte，而此处aiv串为32位字符串，所以将32位字符串转为16byte
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = Data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            String EncStr = (new BASE64Encoder()).encode(encrypted);//将cipher加密后的byte数组用base64加密生成字符串
            return EncStr ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String encryptedData) throws Exception {
        try {
            byte[] encrypted1 = (new BASE64Decoder()).decodeBuffer(encryptedData);
            byte[] iv = toByteArray(aiv);
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();//此处添加trim（）是为了去除多余的填充字符，就不用去填充了，具体有什么问题我还没有遇到，有强迫症的同学可以自己写一个PKCS7UnPadding函数
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //此函数是将字符串每两个字符合并生成byte数组
    public static byte[] toByteArray(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        System.out.println(byteArray.length);
        return byteArray;
    }
    //此函数是pkcs7padding填充函数
    public static String pkcs7padding(String data) {
        int bs = 16;
        int padding = bs - (data.length() % bs);
        String padding_text = "";
        for (int i = 0; i < padding; i++) {
            padding_text += (char)padding;
        }
        return data+padding_text;
    }*/
}



