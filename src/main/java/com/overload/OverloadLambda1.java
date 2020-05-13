package com.overload;

/**
 * @author wangpengfei101022
 * @Description: lambda表达式解析的时候，两个接口的方法参数类型和个数都一致，会匹配到两个接口，所以不知道执行哪个了
 * 与接口中的方法名无关，即使不同名，仍会同时匹配到两个接口
 * @date 2019/12/18 21:36
 */
public class OverloadLambda1 {
    interface Runable {
        void run();
    }

    interface Runable2 {
        void run1();
    }

    void methodA(Runable runable) {
        runable.run();
    }

    void methodA(Runable2 runable2) {
        runable2.run1();
    }

    class RunableImpl implements Runable{
        @Override
        public void run() {
            System.out.println("Runable...");
        }
    }

    public static void main(String[] args) {


        /*new OverloadLambda1().methodA(new Runable2() {
            @Override
            public void run1() {
                System.out.println("Runable2...");
            }
        });*/
        //new OverloadLambda().methodA(() -> System.out.println("methodA"));
    }
}
