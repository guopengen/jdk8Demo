package com.streamTest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description stream流的各种使用
 * @Author wangpengfei101022
 * @Date 2020/4/9 22:38
 */
public class groupByTest {
    public static void main(String[] args) {
        String groupStr = "1:2:3";
        String[] groupArray = groupStr.split(":");
        System.out.println(groupArray);



        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(",");
        String[] stringBuilderArray = stringBuilder.toString().split(",");
        String flashContent = "";
        if (stringBuilderArray.length > 0) {
            flashContent = stringBuilderArray[0];
        }

        Date date1 = new Date();
        System.out.println(date1.before(date1));
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        // 分组
        Map<String, List<String>> result1 = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity()
                )
        );
        System.out.println(result1);

        //分组 计数
        Map<String, Long> result2 = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
        System.out.println(result2);


        Map<String, Long> finalMap = new LinkedHashMap<>();
        result2.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);


        List<Student> students = new ArrayList<>();
        Student student1 = new Student("xiaowang","普通班","一年级",13,"河北","邯郸",1);
        Student student2 = new Student("zhangsan","实验班","一年级",14,"湖北","黄石",2);
        Student student3 = new Student("lisi","普通班","一年级",11,"河北","唐山",0);
        Student student4 = new Student("wangwu","实验班","三年级",15,"河北","唐山",3);
        Student student5 = new Student("zhaoliu","疯狂班","一年级",13,"河北","秦皇岛",5);
        Student student6 = new Student("maqi","实验班","二年级",16,"河北","邯郸",3);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        System.out.println(students);
        students = students.stream().filter(student -> student.getAge() > 100).collect(Collectors.toList());
        System.out.println(students);
        //年龄筛选
        List<Student> studentAge = students.stream().filter(student -> student.getAge() > 100).collect(Collectors.toList());

        //映射关系
        Map<String,Student> studentMapYing1 = students.stream().collect(Collectors.toMap(Student::getName, Function.identity(),
                (v1, v2) -> {
                    return v1;
                }));
        Map<String,Student> studentMapYing2 = students.stream().collect(Collectors.toMap(Student::getClassName, Function.identity(),
                (v1, v2) -> {
                    return v1;
                }));

        students.get(0);
        //按照年龄排序
        List<Student> sorted1 = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        List<Student> sorted2 = students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());

        //单个属性分组
        //班级名分组
        Map<String, List<Student>> studentMap1 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getClassName
                )
        );
        System.out.println(studentMap1);

        //分组计数
        Map<String, Long> studentMap2 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getClassName,Collectors.counting()
                )
        );
        System.out.println(studentMap2);

        Map<String, Long> studentMap3 = new LinkedHashMap<>();
        //分组、计数、排序
        studentMap2.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> studentMap3.put(e.getKey(), e.getValue()));
        System.out.println(studentMap3);



        /*//复合字段
        //年龄和平果分组
        Map<String, List<Student>> studentMap1 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getClassName
                )
        );
        System.out.println(studentMap1);

        //分组计数
        Map<String, Long> studentMap2 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getClassName,Collectors.counting()
                )
        );
        System.out.println(studentMap2);

        Map<String, Long> studentMap3 = new LinkedHashMap<>();
        //分组、计数、排序
        studentMap2.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> studentMap3.put(e.getKey(), e.getValue()));
        System.out.println(studentMap3);*/
    }

    private static int fetchGroupKey(Student student){
        return student.getAge()+student.getAppleNum();
    }

    @Data
    @AllArgsConstructor
    public static class Student{
        private String name;
        private String className;//班级名
        private String grade;//年级
        private int age;
        private String province;
        private String city;
        private int appleNum;
    }
}
