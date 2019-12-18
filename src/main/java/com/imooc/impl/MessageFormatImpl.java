package com.imooc.impl;

import com.imooc.IMessageFormat;

/**
 * @author wangpengfei101022
 * @Description: TODO
 * @date 2019/12/17 22:03
 */
public class MessageFormatImpl implements IMessageFormat{
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换");
        return message;
    }
}
