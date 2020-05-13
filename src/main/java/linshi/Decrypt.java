package linshi;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/2/13 19:41
 */
@Data
public class Decrypt {
    Integer datarow;
    List<HtRecordAddress> data;
}
