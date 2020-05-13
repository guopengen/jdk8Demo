package com.imooc;

import com.imooc.impl.MessageFormatImpl;
import com.imooc.impl.UserCredentialImpl;

/**
 * @author wangpengfei101022
 * @Description: 需求改动
 *  所有的用户验证，可以同时获取用户的验证信息
 * @date 2019/12/17 21:51
 */
public class AppTest {
    public static void main(String[] args) {
        //1、默认方法
        IUserCredential userCredential1 = new UserCredentialImpl();
        System.out.println(userCredential1.verifyUser("admin"));
        System.out.println(userCredential1.getCredential("admin"));

        //2、静态方法
        String message = "hello world";
        if (IMessageFormat.verifyMessage(message)) {
            IMessageFormat iMessageFormat = new MessageFormatImpl();
            iMessageFormat.format(message,"json");
        }

        //3、匿名内部类
        IUserCredential userCredential2 = new IUserCredential(){
            @Override
            public String verifyUser(String userName) {
                return "admin".equals(userName)?"管理员":"会员";
            }
        };
        System.out.println(userCredential2.verifyUser("admin"));

        //4、lambda表达式  方式一
        IUserCredential iUserCredential3 = (String userName) -> {
            return "admin".equals(userName)?"lambda1管理员":"lambda1会员";
        };
        System.out.println(iUserCredential3.verifyUser("admin"));

        //5、lambda表达式   方式二
        IUserCredential iUserCredential4 = (userName)-> "admin".equals(userName)?"lambda2管理员":"lambda2会员";
        System.out.println(iUserCredential4.verifyUser("admin"));

    }
}
