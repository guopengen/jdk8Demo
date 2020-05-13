package fuwenben;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/14 19:46
 */
public class RemoteGetFile {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            System.out.println(UUID.randomUUID());
            //创建一个URL实例
            URL url = new URL("http://test.storage.jd.com/urge.cloud/offline.repay/141/document/20200314183229-test.html?Expires=3731671343&AccessKey=E6TgVNC5wzI0pXhT&Signature=0u5QuDUdPutLK%2BfUoFpUrT%2FQ954%3D");
            //URL url = new URL("http://211.151.9.211:86/recfile/20200421/2020042114435058810473551153750.wav");
            InputStream is=url.openStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String data = br.readLine();//读取数据
            while (data != null) {//循环读取数据
                sb.append(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
            System.out.println(sb.toString());
        } catch(Exception e) {
            System.out.println("文件读取错误" );
        }
    }
}
