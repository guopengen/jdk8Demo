package fuwenben;

import java.io.*;
import java.net.URLDecoder;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/13 16:49
 */
public class InputStreamTest {
    public static void main(String[] args)
    {
        InputStreamTest app = new InputStreamTest();
        app.fileToInputStream();
        app.inputStreamToFile();
    }


    public void fileToInputStream()
    {
        InputStream inputStream = null;
        BufferedReader br = null;
        try
        {
            String path = System.getProperty("user.dir") + "/bin/file.txt";
            inputStream = new FileInputStream(URLDecoder.decode(path, "utf-8"));
            br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
            {
                sb.append(line);
            }
            System.out.println(sb.toString());
            System.out.println("\nDone!");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    public void inputStreamToFile()
    {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try
        {
            String userDir = System.getProperty("user.dir");

            String path = userDir + "/bin/file.txt";
            inputStream = new FileInputStream(path);

            String newPath = userDir + "/bin/file-new.txt";
            File file = new File(newPath);
            outputStream = new FileOutputStream(file);

            int bytesWritten = 0;
            int byteCount = 0;

            byte[] bytes = new byte[1024];

            while ((byteCount = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes, bytesWritten, byteCount);
                bytesWritten += byteCount;
            }

            System.out.println("Done!");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (outputStream != null)
            {
                try
                {
                    outputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }
}
