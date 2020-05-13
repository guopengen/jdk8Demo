package com.overload;

/**
 * @author wangpengfei101022
 * @Description: 返回类型不同也可以区分
 * @date 2019/12/18 22:15
 */
public class OverloadLambda3 {
    interface Runable {
        void run();
    }

    interface Runable2 {
        String run();
    }

    interface Runable3 {
        int run();
    }

    void methodA(Runable runable) {
        runable.run();
    }

    String methodA(Runable2 runable2) {
        return runable2.run();
    }

    int methodA(Runable3 runable3){
        return runable3.run();
    }

    public static void main(String[] args) {
        OverloadLambda3 overloadLambda = new OverloadLambda3();

        overloadLambda.methodA(() -> System.out.println("methodA"));

        System.out.println(overloadLambda.methodA(() -> "methodA return string"));

        if(overloadLambda.methodA(()-> 1)>0){
            System.out.println("调用了Runable3接口");
        }
    }

}
