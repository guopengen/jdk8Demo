package com.base.sort;

import lombok.Data;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 10:40
 */
@Data
public class Student2 {
    String name;
    int age;
    int score;
    Integer grade;

    public Student2(String name, int age,int score,Integer grade) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.grade = grade;
    }
}
