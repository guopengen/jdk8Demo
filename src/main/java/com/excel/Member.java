package com.excel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/28 0:28
 */
@Data
@AllArgsConstructor
public class Member {
    private Integer code;

    private String name;

    private Integer age;

    private Date birth;

    private List<Animal> animals;

}

@Data
@AllArgsConstructor
class Animal{
    private String name;
    private Integer age;
}
