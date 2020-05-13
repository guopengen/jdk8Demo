package linshi2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2019/12/26 19:06
 */
@Target(value= ElementType.METHOD)  //意味着注解只能用在方法前面
@Retention(RetentionPolicy.RUNTIME)  //注解在运行时有效，即可以被反射读取
public @interface My {
    //注解内包含的是参数的信息，不是方法，比如定义了一个String类型的name变量
    String  name() default "";  //加默认值,通常为0或空字符串，默认值为-1表示不存在
    int age() default 0;
    int id() default -1;
    //定义一个数组
    String[] s() default {"me","you"};
}
