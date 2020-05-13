package linshi;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/28 13:44
 */
public class ListTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("xiaowang1",12);
        Person person2 = new Person("xiaowang1",12);
        Person person3 = new Person("xiaowang2",10);
        Person person4 = new Person("xiaowang2",13);
        Person person5 = new Person("xiaowang3",13);
        //
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        List<Person> resultList = new ArrayList<>();
        Map<String,List<Person>> personMap = new HashMap<>();
        for (Person caseDist : personList){
            if (personMap.containsKey(caseDist.getName())) {
                personMap.get(caseDist.getName()).add(caseDist);
            } else {
                List<Person> personList1 = new ArrayList<>();
                personList1.add(caseDist);
                personMap.put(caseDist.getName(),personList1);
            }
        }
        System.out.println(personMap);

        for (Map.Entry<String, List<Person>> entry : personMap.entrySet()) {
            Person result = null;
            for (Person person : entry.getValue()) {
                if (result == null) {
                    result = person;
                } else {
                    if (result.getAge() > person.getAge()) {
                        result = person;
                    }
                }
            }
            //System.out.println(result+"----------");
            resultList.add(result);
        }

        System.out.println("你想要的结果:"+resultList);




        List<Person> ss = new ArrayList<>();
        Map<Integer,Person> caseDistMap = new HashMap<>();

        for (Map.Entry<Integer, Person> entry : caseDistMap.entrySet()) {
            ss.add(entry.getValue());
        }
        System.out.println(ss);

        /*Map<Integer, Person> map = personList.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
        System.out.println(getcalculateData(personList));*/
        BigDecimal bigDecimal = new BigDecimal(0.82*60);
        System.out.println(bigDecimal.longValue());

    }

    public static  List<Person> getcalculateData(List<Person> personList){
        List<Person> caseDistListResult = new ArrayList<>();
        List<String> caseIdList = personList.stream().map(Person::getName).collect(Collectors.toList());
        List<String> norepetCaseIdList = caseIdList.stream() // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
        if (norepetCaseIdList.size() > 0) {
            Map<String,List<Person>> caseDistMap = new HashMap<>();
            for (Person caseDist : personList) {
                String caseId = caseDist.getName();
                if (norepetCaseIdList.contains(caseId)){
                    if (caseDistMap.containsKey(caseId)) {
                        List<Person> caseDistList1 = caseDistMap.get(caseId);
                        caseDistList1.add(caseDist);
                    } else {
                        List<Person> caseDistList1 = new ArrayList<>();
                        caseDistList1.add(caseDist);
                        caseDistMap.put(caseId,caseDistList1);
                    }
                } else {
                    caseDistListResult.add(caseDist);
                }
            }

            for (Map.Entry<String, List<Person>> entry : caseDistMap.entrySet()) {
                //String caseId = entry.getKey();
                Person caseDist = null;
                List<Person> caseDistList1 = entry.getValue();
                for (Person caseDistFor : caseDistList1){
                    //取出该案件最大的到期日
                    if (caseDist != null) {
                        if (caseDist.getAge() > caseDistFor.getAge()){
                            caseDist = caseDistFor;
                        }
                    } else {
                        caseDist = caseDistFor;
                    }
                }
                caseDistListResult.add(caseDist);
            }
        } else {
            caseDistListResult.addAll(personList) ;
        }

        return caseDistListResult;
    }
}
