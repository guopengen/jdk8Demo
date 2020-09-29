package com.streamTest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.extra.pinyin.engine.pinyin4j.Pinyin4jEngine;
import filter.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/9/2 21:38
 */
public class Test {
    public static void main(String[] args) {


        String templateIdStr = "13";
        String[] templateIdArray = templateIdStr.split(",");
        List<String> templateIdList = new ArrayList<String>(Arrays.asList(templateIdArray));
        Long templateId = 13L;
        System.out.println(templateIdList.contains(String.valueOf(templateId)));
        User user = new User();
        user.setEmail("wsdf");

        User user1 = new User();
        user1.setAa(user.getInteger());
        System.out.println(user);
            /*String pinyin1 = PinyinUtil.getPinyin("", " ");
            System.out.println(pinyin1);

        System.out.println(Validator.isMobile("182"));
        System.out.println(Validator.isMobile("01234567890"));
        System.out.println(Validator.isMobile("14310121964"));
        System.out.println(Validator.isMobile(null));
        System.out.println(Validator.isMobile(""));*/

        /*ConcurrencyTester tester = ThreadUtil.concurrencyTest(10, () -> {
            // 测试的逻辑内容
            String pinyin = PinyinUtil.getPinyin("张长章", "");
            Console.log("{} test finished, delay: {}", Thread.currentThread().getName(), pinyin);
        });*/

        // 获取总的执行时间，单位毫秒
        /*Console.log(tester.getInterval());*/

        /*String result = PinyinUtil.getFirstLetter("张*", "");
        System.out.println(result);*/

        /*Pinyin4jEngine engine = new Pinyin4jEngine();
        String pinyin1 = engine.getPinyin("张*", "");
        System.out.println(pinyin1);*/
    }
}
