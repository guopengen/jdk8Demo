package fuwenben;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/7/10 22:00
 */
public class Test {
    private static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gsonBuilder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                Expose expose = fieldAttributes.getAnnotation(Expose.class);
                if (expose != null && expose.serialize() == false) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });
        gson = gsonBuilder.create();
    }
    public static void main(String[] args) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date colDate = simpleDateFormat.parse("20200710 21:14:32");
        Date colEndDate = simpleDateFormat.parse("2020-07-10 21:14:53");
    }
}
