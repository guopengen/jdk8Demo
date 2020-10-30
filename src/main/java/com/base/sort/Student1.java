package com.base.sort;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 10:36
 */
public class Student1 implements Comparable<Student1>{
    String name;
    int age;
    int score;

    public Student1(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student1 o) {
        return this.age - o.age;
    }
}
