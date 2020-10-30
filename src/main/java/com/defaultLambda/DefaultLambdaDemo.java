package com.defaultLambda;

import java.util.UUID;
import java.util.function.*;

/**
 * @author wangpengfei101022
 * @Description: java8的特性函数
 * @date 2019/12/19 15:57
 */
public class DefaultLambdaDemo {
    public static void main(String[] args) {
        //1、Predicate  需要对某个类型做处理，而且要返回布尔类型
        Predicate<String> predicate = (String userName)-> "admin".equals(userName)?true:false;
        Predicate<String> predicate1 = (userName)-> "admin".equals(userName)?true:false;
        System.out.println("Predicate:"+predicate.test("admin"));

        //2、Consumer  需要对某个类型做处理，而且不会返回该类型
        Consumer<String> consumer =  (String userName) -> {
            boolean aa = "admin".equals(userName)?true:false;
            System.out.println("Consumer"+aa);
        };
        consumer.accept("admin");

        //3、Function
        Function<String,Integer> function = (String gender)->{
            return "male".equals(gender)?1:0;
        };
        System.out.println("Function:"+function.apply("male"));

        //4、Supplier  参数为空，返回一个指定的类型数据，通过get获取到。
        Supplier<String> supplier = ()-> {
          return UUID.randomUUID().toString();
        };
        System.out.println("Supplier:"+supplier.get());


        //5、UnaryOperator 是一个特殊的Function
        UnaryOperator<String> unaryOperator = (String img) -> {
            img = img+":hhhh";
            return img;
        };
        unaryOperator.apply("message");

        //6、BinaryOperator  是一个特殊的BiFunction  两个对象pk，返回胜出的对象
        BinaryOperator<Integer> binaryOperator = (Integer i1,Integer i2)-> {
            return i1>i2?i1:i2;
        };
        System.out.println(binaryOperator.apply(2,3));
    }
}
