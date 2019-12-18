package com.imooc;

/**
 * @author wangpengfei101022
 * @Description: 用户身份认证标记接口
 * @date 2019/12/17 21:30
 */
@FunctionalInterface
public interface IUserCredential {
    /**
     * 通过用户账号，验证用户身份信息的接口
     * @auther: wangpf
     * @param userName
     * @return: 返回身份信息【系统管理员、用户管理员、普通用户】
     */
    String verifyUser(String userName);

    //String hello();

    default String getCredential(String userName){
        if ("admin".equals(userName)) {
            return "admin + 系统管理员用户";
        } else if ("manager".equals("用户管理员")) {
            return "manager + 用户管理员用户";
        } else {
            return "commons + 普通用户";
        }
    }
}
