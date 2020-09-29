package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/8/25 22:54
 */
public class FilterTest {
    public static Boolean isExistFieldName(String fieldName, Object obj) throws NoSuchFieldException {
        if (obj == null || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        //获取这个类的所有属性
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean flag = false;
        //循环遍历所有的fields
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(fieldName)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static Boolean isExistField(String field, Object obj) {
        if (obj == null || StringUtils.isEmpty(field)) {
            return null;
        }
        Object o = JSON.toJSON(obj);
        JSONObject jsonObj = new JSONObject();
        if (o instanceof JSONObject) {
            jsonObj = (JSONObject) o;
        }
        return jsonObj.containsKey(field);
    }

    public static void main(String[] args) throws NoSuchFieldException {
        String field = "email";
        User user = new User();

        System.out.println("【方式一】：" + isExistFieldName(field, user));
        System.out.println("【方式二】：" + isExistField(field, user));
    }
}
