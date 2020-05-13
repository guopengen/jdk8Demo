package com.excel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 成绩计算报表
 *
 * @author 
 */
@Data
public class AchievementReport {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "催收企业id")
    private Long receiveAppId;

    @ApiModelProperty(value = "催收企业名称")
    private String receiveAppName;

    @ApiModelProperty(value = "产品类型")
    private String productType;

    @ApiModelProperty(value = "产品类型名称")
    private String productTypeName;

    @ApiModelProperty(value = "案件类型大类A/B")
    private String caseTypeHead;

    @ApiModelProperty(value = "案件类型")
    private String caseType;

    @ApiModelProperty(value = "组别")
    private String groupName;

    @ApiModelProperty(value = "目标化解率")
    private BigDecimal targetSettlementRate;

    @ApiModelProperty(value = "目标回收率")
    private BigDecimal targetRecoveryRate;

    @ApiModelProperty(value = "当前化解率")
    private BigDecimal currentSettlementRate;

    @ApiModelProperty(value = "当前回收率")
    private BigDecimal currentRecoveryRate;

    @ApiModelProperty(value = "批次达成率")
    private BigDecimal batchReachRate;

    @ApiModelProperty(value = "目标达成率")
    private BigDecimal targetReachRate;

    @ApiModelProperty(value = "有效 0没配置 1配置")
    private Integer configStatus;

    @ApiModelProperty(value = "有效 0无效 1有效")
    private Integer validStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    @ApiModelProperty(value = "更新时间")
    private Date modifiedDate;

    private List<String> groupNameList;
}
