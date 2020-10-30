package com.base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 10:41
 */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<Student2> students = new ArrayList<>();
        students.add(new Student2("大铭", 19, 89,1));
        students.add(new Student2("来福", 26, 90,3));
        students.add(new Student2("仓颉", 23, 70,2));
        students.add(new Student2("王磊", 18, 80,9));

        System.out.println("排序前:");
        for (Student2 student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }

        List<Student2> sortUser = students.stream().sorted((u1, u2) -> u1.getGrade().compareTo(u2.getGrade())).collect(Collectors.toList());


        System.out.println("排序后:");
        for (Student2 student : sortUser) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score+" 年级："+student.grade);
        }
    }
}
