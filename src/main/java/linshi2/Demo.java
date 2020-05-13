package linshi2;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2019/12/26 20:16
 */
public class Demo {
    @My(age=19,name="me",id=10,s= {"it","that"})  //显示指定相应的值，可通过反射读取
    public static void test()
    {
    }
    //注解只有一个参数时
    @My2(value="aaa")//或者 @My2("ada")
    public static void test2()
    {

    }

    public static void main(String[] args) {
        test();
        test2();
    }
}
