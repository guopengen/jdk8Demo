package com.enumTest;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/8/26 21:40
 */
public class EnumUtil {
    public static <T extends CodeEnum> String getByCode(Integer code, Class<T> t){
        for(T item: t.getEnumConstants()){
            if(item.getCode().equals(code)){
                return item.getMsg();
            }
        }
        return "";
    }
}
