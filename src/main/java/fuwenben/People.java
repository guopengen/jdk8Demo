package fuwenben;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/7/9 17:40
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class People {
    String name;
    BigDecimal bigDecimal;
}
