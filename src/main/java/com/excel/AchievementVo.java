package com.excel;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/5 16:55
 */
@Data
public class AchievementVo {
    List<AchievementCaseVo> achievementInfoVoList;
    String appName;
}
