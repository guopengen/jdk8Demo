package linshi;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2019/12/26 15:27
 */
public class Person {
    @NotNull
    String name;
    int age;
    BigDecimal bigDecimal;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }
    public String toString(){
        return name+":"+age;
    }
}
