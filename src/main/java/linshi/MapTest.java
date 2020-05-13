package linshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/14 16:37
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map1 = new HashMap<>();
        map1.put("1","xiaowang");
        map1.put("2","xiaoming");

        Map<String,String> map2 = new HashMap<>();
        map2.put("1","xiaowang");
        map2.put("2","xiaoming2");
        map2.put("3","xiaoming1");

        map1.clear();
        map1.putAll(map2);
        map2.clear();
        System.out.println(map1);
    }
}
