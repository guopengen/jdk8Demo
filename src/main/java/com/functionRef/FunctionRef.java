package com.functionRef;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangpengfei101022
 * @Description:
 * 静态方法引用的使用
 * 类型名称.方法名称    -》    类型名称::方法名称
 * @date 2019/12/19 20:54
 */
public class FunctionRef {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三","男",19));
        personList.add(new Person("李四","男",18));
        personList.add(new Person("王五","男",20));
        personList.add(new Person("赵六","男",21));
        //匿名内部类来实现
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(personList);

        //lambda表达式
        Collections.sort(personList,(Person o1,Person o2) -> o1.getAge()-o2.getAge());
        System.out.println(personList);

        //静态方法引用
        Collections.sort(personList,Person::compareByAge);
        System.out.println(personList);

        //实例方法引用
        Collections.sort(personList,new PersonUtil()::compareByName);
        System.out.println(personList);

        //构造方法引用
        IPerson iPerson = Person::new;
        iPerson.initPerson("老七","男",29);
        System.out.println(iPerson);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private String name;
    private String gender;
    private int age;
    public static int compareByAge(Person p1,Person p2){
        return p1.age - p2.age;
    }
}


class PersonUtil{
    public int compareByName(Person p1,Person p2){
        return p1.getName().hashCode() - p2.getName().hashCode();
    }
}

interface IPerson{
    Person initPerson(String name,String gender,int age);
}
