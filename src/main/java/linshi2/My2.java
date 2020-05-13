package linshi2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2019/12/26 20:16
 */
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface My2 {
    //如果注解里只有一个参数，通常定义为value
    String value() default "";
}
