package fuwenben;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 催收模式
 *
 * @author: zyh
 * @date: 2019/03/08
 **/
@AllArgsConstructor
@Getter
public enum UrgeModeEnum {
    /**
     * 电话
     */
    PHONE("1", "1"),
    /**
     * 短信
     */
    SMS("1", "2"),
    /**
     * 信件
     */
    MAIL("1", "3"),
    /**
     * 闪信
     */
    FLASH("1", "4"),
    /**
     * 信息修复
     */
    REPAIR("1", "5"),
    /**
     * 主管协办
     */
    MANAGER_HELP("1", "6"),
    /**
     * 外访
     */
    INTERVIEW("1", "7"),
    /**
     * 发起物流协催
     */
    QZ_ASSIST_LAUNCH("1", "8"),
    /**
     * 物流催收反馈
     */
    QZ_ASSIST_RESULT("1", "9"),
    /**
     * 发起物流专催
     */
    QZ_SPECIFICITY_LAUNCH("1", "10"),
    /**
     * 物流专催反馈
     */
    QZ_SPECIFICITY_RESULT("1", "11"),
    /**
     * 信函
     */
    LETTER("1", "12"),
    /**
     * ivr
     */
    IVR("2", "4");
    private String type;
    private String value;
}
