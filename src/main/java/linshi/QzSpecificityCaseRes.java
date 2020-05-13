package linshi;

import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @author wangpf
 * Date： 2020/02/10
 */
@Data
public class QzSpecificityCaseRes {

    private Integer totalSize;
    private Integer successSize;
    private Integer defeatSize;
    private List<QzSpecificityCaseResInfo> responses;
}
