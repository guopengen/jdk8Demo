package com.overload;

/**
 * @author wangpengfei101022
 * @Description: 与接口中的参数列表有关，当参数列表不一样时就可以知道调用哪个方法，lambda对应哪个接口了
 * @date 2019/12/18 22:15
 */
public class OverloadLambda2 {
    interface Runable {
        void run();
    }

    interface Runable2 {
        void run(int x);
    }

    void methodA(Runable runable) {
        runable.run();
    }

    void methodA(Runable2 runable2) {
        runable2.run(10);
    }

    public static void main(String[] args) {
        new OverloadLambda2().methodA(() -> System.out.println("methodA"));

        new OverloadLambda2().methodA((x) -> System.out.println("methodA"+x));
    }
}
