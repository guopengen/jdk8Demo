package linshi;

import cn.miludeer.jsoncode.JsonCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/30 22:06
 */
public class JsonCodeTest {
    public static void main(String[] args) {
        String str = "{\n" + "    \"json\": {\n" + "        \"a\": {\n" + "            \"aa\": \"aa\",\n" + "            \"bb\": [\"1\", \"2\"]\n" + "        },\n" + "        \"b\": {\n" + "            \"cc\": \"c22\",\n" + "            \"dd\": [\"2\", \"3\"]\n" + "        }\n" + "    }\n" + "}";
        JSONObject ob = JSON.parseObject(str).getJSONObject("json").getJSONObject("b");
        String str1 = ob.getString("c22");
        System.out.println(str1);

        String str2 = JsonCode.getValue(str, "$.json.b.c22");
        System.out.println(str2);
    }
}
