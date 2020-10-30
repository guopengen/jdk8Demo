package com.base.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 10:39
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student1> students = new ArrayList<>();
        students.add(new Student1("大铭", 19, 89));
        students.add(new Student1("来福", 26, 90));
        students.add(new Student1("仓颉", 23, 70));
        students.add(new Student1("王磊", 18, 80));

        System.out.println("排序前:");
        for (Student1 student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }

        // 排序
        Collections.sort(students);

        System.out.println("排序后:");
        for (Student1 student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }
    }
}
