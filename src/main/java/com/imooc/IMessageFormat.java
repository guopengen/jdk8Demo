package com.imooc;

/**
 * @author wangpengfei101022
 * @Description: 消息传输格式化接口
 * @date 2019/12/17 21:35
 */
@FunctionalInterface
public interface IMessageFormat {
    /**
     * @description: 消息转换方法
     * @auther: wangpf
     * @param
     * message  要转换的消息
     * format   xml/json
     * @return: 返回转换后的数据
     */
    String format(String message,String format);
    /**
     * @description: 消息合法性验证
     * @auther: wangpf
     * @param msg
     * @return: boolean
     */
    static boolean verifyMessage(String msg) {
        if (msg != null) {
            return true;
        }
        return false;
    }
}
