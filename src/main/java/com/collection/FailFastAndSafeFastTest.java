package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 *  fail-fast
 *  fail-safe
 * @Author wangpengfei101022
 * @Date 2020/5/12 11:48
 */
public class FailFastAndSafeFastTest {
    public static void main(String[] args) {
        //failFastTest();
        safeFastTest();
    }

    private static void failFastTest(){
        HashMap hashMap = new HashMap();
        hashMap.put("不只Java-1", 1);
        hashMap.put("不只Java-2", 2);
        hashMap.put("不只Java-3", 3);

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            hashMap.remove("不只Java-3");
            hashMap.put("不只Java-3", 4);
            System.out.println("此时 hashMap 长度为" + hashMap.size());
        }
    }

    private static void safeFastTest(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("不只Java-1", 1);
        concurrentHashMap.put("不只Java-2", 2);
        concurrentHashMap.put("不只Java-3", 3);

        Set set = concurrentHashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            concurrentHashMap.put("下次循环正常执行", 4);
        }
        System.out.println(concurrentHashMap);
        System.out.println("程序结束");
    }
}
