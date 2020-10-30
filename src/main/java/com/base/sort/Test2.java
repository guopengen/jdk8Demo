package com.base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 10:41
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<Student2> students = new ArrayList<>();
        students.add(new Student2("大铭", 19, 89,1));
        students.add(new Student2("来福", 26, 90,1));
        students.add(new Student2("仓颉", 23, 70,2));
        students.add(new Student2("王磊", 18, 80,3));

        System.out.println("排序前:");
        for (Student2 student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }

        Collections.sort(students,new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.age-o2.age;
            }
        });

        System.out.println("排序后:");
        for (Student2 student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }
    }
}
