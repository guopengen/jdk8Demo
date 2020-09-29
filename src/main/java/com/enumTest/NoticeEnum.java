package com.enumTest;

import lombok.Getter;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/8/26 21:40
 */
@Getter
public enum NoticeEnum implements CodeEnum{
    TEST1(1,"成功"),
    TEST2(2,"失败");


    private int code;
    private String msg;

    NoticeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
