package fuwenben;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/13 15:49
 */
public class FileTest {
    final static  String FILE_IN = "D:/d.txt";
    @SneakyThrows
    public static void main(String[] args) {
        File file=new File(FILE_IN);
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader read =new BufferedReader(isr);
            String s=null;
            StringBuilder stringBuilder = new StringBuilder();
            while((s=read.readLine())!=null)
            {
                if(s.trim().length()>1){
                    //System.out.println(s.trim());
                    stringBuilder.append(s.trim());
                }
            }
            System.out.println(stringBuilder.toString());
            //System.out.println(list);
            /*StringBuilder stringBuilder = new StringBuilder();
            for (String str : list) {

            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*String str="";
        File file=new File(FILE_IN);
        try {
            FileInputStream in=new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            str=new String(buffer,"GB2312");
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }


    public void fileToInputStream() {

    }

}
