package bigData;
import java.math.BigDecimal;

import linshi.Person;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/3/23 20:58
 */
public class BigTest {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        for (int i=0;i<300000;i++){
            Person person = new Person();
            person.setName("xiao"+i);
            person.setAge(0);
            person.setBigDecimal(new BigDecimal("0"));
            personList.add(person);
        }
        System.out.println(personList);


    }
}
