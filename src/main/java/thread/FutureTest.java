package thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/5/14 16:50
 */
public class FutureTest {
    public static void main(String[] args) {
        /*//List<FuturePerson> futurePersonList = Arrays.asList(new FuturePerson("xiaowang",12),new FuturePerson("xiaohong",13));
        List<FuturePerson> futurePersonList = new ArrayList<>();
        for (int i=0;i<100;i++) {
            futurePersonList.add(new FuturePerson("xiaoxiao"+i,12));
        }
        int total = futurePersonList.size();
        int start = 0;
        int end = 10 < total ? 10 : total;
        List<Future<Integer>> futureList = new ArrayList<>();
        while (true) {
            if (start == end) {
                break;
            }
            futureList.add(testFuture());
            start = end;
            end = (end + THREAD_CASE_COUNT) < total ? (end + THREAD_CASE_COUNT) : total;
        }
        int executeCount = getExecuteCount(futureList);*/
    }

  /* private Future<Integer> testFuture(){
        return new AsyncResult<>(successCount);
    }*/


}

@Data
@AllArgsConstructor
class FuturePerson{
    String name;
    int age;
}
