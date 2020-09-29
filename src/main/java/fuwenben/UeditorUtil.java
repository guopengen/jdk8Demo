package fuwenben;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/13 17:33
 */
public class UeditorUtil {
    private static final Pattern p_html = Pattern.compile("<[a-zA-z]{1,9}((?!>).)*>", Pattern.CASE_INSENSITIVE);

    private static final Pattern t_html = Pattern.compile("</[a-zA-z]{1,9}>", Pattern.CASE_INSENSITIVE);

    public static String getTextByHtml(String html) {

        Matcher m_script = p_html.matcher(html);

        html = m_script.replaceAll("");

        Matcher l_script = t_html.matcher(html);

        return l_script.replaceAll("");
    }

    public static void main(String[] args) {
        /*String htmlText = "<html>sf</html>";
        System.out.println(getTextByHtml(htmlText));*/
        System.out.println(UrgeModeEnum.FLASH);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                int tableIndx = i * 40 + j;
                System.out.println(tableIndx);
            }
        }
    }
}
