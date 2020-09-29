package linshi;

import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/6/22 15:58
 */
public class DeleteTest {
    private  static  final int count = 10;
    public static void main(String[] args) {
        System.out.println("abc"+File.separator+"123");
        List<String> originList = new ArrayList<>();
        List<String> split = new ArrayList<>(Arrays.asList("chengdu".split(",")));
        originList.retainAll(split);
        System.out.println(originList);
        if(!CollectionUtils.isEmpty(originList)) {

        }
    }
}
