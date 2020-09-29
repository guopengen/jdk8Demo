package com.enumTest;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/8/26 21:40
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
