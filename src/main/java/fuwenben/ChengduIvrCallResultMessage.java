package fuwenben;

import lombok.Data;

@Data
public class ChengduIvrCallResultMessage {
    private String custId;//
    private String colDate;
    private String productId;
    private String actionCode;
    private String colObject;
    private String mobile;
    private String colConseq;
    private String remark;
    private String callTime;
    private String isAction;
    private String isCall;
    private String passDueAmt;
    private String sessionId;
    private String cpdCode;
    private String cpdDesc;
    private String colEndDate;//呼出电话结束时间
    private String cusId;//透传的id，方便云催查询案件
    private String callId;//录音唯一标识
}
