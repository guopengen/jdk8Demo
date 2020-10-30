package com.base;

/**
 * @Description: https://blog.csdn.net/android_cai_niao/article/details/106027313
 *  i++ 即后加加，原理是：先自增，然后返回自增之前的值
    ++i 即前加加，原理是：先自增，然后返回自增后的值
    一个变量也是表达式，多个表达式的加减法运算都是从左到右进行的

    讨论区的小知识：
    只是i++,那么i等于1   而i = i++,i等于0的。
 * @Author wangpengfei101022
 * @Date 2020/9/29 21:57
 */
public class SelfAdd {
    public static void main(String[] args) {
        //第一个
//        int i = 0;
//        i++;
//        System.out.println(i);//1
//
//        int j = 0;
//        ++j;
//        System.out.println(j);//1

        //第二个
//        int i = 0;
//        i = i++;
//        System.out.println(i);//0

        //第三个
//        int a = 2;
//        int b = (3*a++)+a;
//        System.out.println(b);//9

        //第四个
//        int a = 2;
//        int b = a + (3*a++);
//        System.out.println(b);//8

        //第五个
//        int m = 1;
//        int n = 1;
//        int k = m++ + ++m + ++n + n++;
//        System.out.println(k);// 1+3+2+2=8

        //第六个
//        int a = 0;
//        int b = 0;
//        a = a++;
//        b = a++;
//        System.out.println(a);//1
//        System.out.println(b);//0

    }
}
