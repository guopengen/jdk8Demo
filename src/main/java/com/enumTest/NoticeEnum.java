package com.enumTest;

import lombok.Getter;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/8/26 21:40
 */
@Getter
public enum NoticeEnum implements CodeEnum{
    UP_PRODUCT(0,"已上架"),
    DOWN_PRODUCT(1,"已下架");

    private Integer code;
    private String msg;

    NoticeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
