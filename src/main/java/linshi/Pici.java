package linshi;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/20 18:04
 */
public class Pici {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("wangpf",12);
        for (int i=0;i<32300;i++){
            personList.add(person);
        }

        int countPerBatch = 1000;
        int i = 0;
        int start = 0;
        int end = countPerBatch < personList.size() ? countPerBatch : personList.size();
        while (true) {
            if (start == end) {
                break;
            }
            i = i+1;
            System.out.println("====="+i);

            start = end;
            end = (end + countPerBatch) < personList.size() ? (end + countPerBatch) : personList.size();
        }
    }
}
