package linshi;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/15 21:29
 */
public class Test {
    public static void main(String[] args) {
        String url = "http://storage.jd.com/urge.cloud/offline.repay/7/document/20200317082149-%E8%BF%98%E6%AC%BE%E5%AF%BC%E5%85%A5%E6%A8%A1%E6%9D%BF.xlsx?Expires=3731888156&AccessKey=OZmd5qfL4yyjee9E&Signature=T53%2Bx9%2FMuARijzCwBV%2B1Sm2GPAE%3D";
        System.out.println(url.substring(url.indexOf("offline.repay"), url.indexOf("?")));
        String fileName = "file.txt";
        System.out.println(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()));
    }
}
