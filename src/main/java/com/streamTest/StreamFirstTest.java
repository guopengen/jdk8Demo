package com.streamTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangpengfei101022
 * @Description:
 * Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate operation），或者大批量数据操作 (bulk data operation)
 * Stream的处理流程
 *   数据源
 *   数据转换
 *   获取结果
 *
 * intermediate中间操作（就是业务逻辑处理）    无状态和有状态
 * 操作结果是一个Stream对象，可以有多个中间操作，只记录方式不做具体执行，直到结束操作时候，才做数据的最终执行。
 * 无状态：数据处理，不受前置中间操作影响
 * map（mapToInt, flatMap 等）、filter、peek、parallerl、sequential、unordered
 * 有状态：数据处理，收到前置中间操作影响
 * distinct、 sorted、 limit、 skip
 *
 * terminal终结操作        非短路和短路
 * 一个Stream只能有一个终结操作，一旦发生就会真实处理数据，生成对应的数据。用完了就没有了；再一个就是多个中间操作合并一个函数，多个数据的时候，一个for循环，数据执行这个函数。
 * 非短路操作：必须处理完所有的数据才能得到结果
 * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、iterator
 * 短路操作：一旦满足某个条件就可以得到结果
 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 * @date 2019/12/19 21:46
 */
public class StreamFirstTest {
    public static void main(String[] args) {
        List<String> accounts = new ArrayList<>();
        accounts.add("zhangsan");
        accounts.add("lisi");
        accounts.add("wangwu");
        accounts.add("zhaoliu");
        System.out.println("begin:"+accounts);

        accounts.stream().peek(str->{
            System.out.println(str);
            str = "123";
        }).collect(Collectors.toList());
        System.out.println(accounts);

        //业务要求，字符串长度大于等于5的才算有效账号
        //1.1  for循环遍历
        for (String account : accounts) {
            if (account.length() >= 5) {
                System.out.println(account);
            }
        }
        //1.2 迭代方式
        Iterator<String> it = accounts.iterator();
        while (it.hasNext()) {
            String account = it.next();
            if (account.length() >= 5) {
                System.out.println(account);
            }
        }
        //1.3 Stream结合Lambda表达式
        Predicate<String> predicate = (s)->{
            return s.length()>5;
        };
        List validAccounts = accounts.stream().filter(predicate).collect(Collectors.toList());
        List validAccounts2 = accounts.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(validAccounts);
        System.out.println(validAccounts2);

        System.out.println("end:"+accounts);
    }
}
