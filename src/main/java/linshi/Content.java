package linshi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/4/9 20:18
 */
public class Content {
    public static void main(String[] args) {
        String str = "{\n" + "\"isSuccess\": 1,\n" + "\"errResult\": \"ok\",\n" + "\"result\": [\n" + "{\n" + "\"question\": \"\",\n" + "\"answer\": \"#1.0#您好，我是{京东白条}的客服,请问是{曾祥运}吗？\",\n" + "\"createTime\": \"2020-02-18 11:10:34\"\n" + "},\n" + "{\n" + "\"question\": \"是的 [self-5157](置信:true,0.999)\",\n" + "\"answer\": \"\",\n" + "\"createTime\": \"2020-02-18 11:10:40\",\n" + "\"rank\": \"本人接听，未承诺还款\",\n" + "\"nodeId\": \"5157\",\n" + "\"intent\": \"self\"\n" + "},\n" + "{\n" + "\"question\": \"\",\n" + "\"answer\": \"#2.0#您的{京东白条}借款{6399.06元}元已经逾期{8}天了，需要您今天还款。\",\n" + "\"createTime\": \"2020-02-18 11:10:40\"\n" + "},\n" + "{\n" + "\"question\": \"嗯 我 我现在出不去 隔离 [unknown-5158](置信:true,0.861)\",\n" + "\"answer\": \"\",\n" + "\"createTime\": \"2020-02-18 11:10:51\",\n" + "\"rank\": \"疫情\",\n" + "\"nodeId\": \"5158\",\n" + "\"intent\": \"unknown\"\n" + "},\n" + "{\n" + "\"question\": \"\",\n" + "\"answer\": \"特殊时期还请您及家人做好防护措施，保重身体。您在我们平台的欠款还请您尽快处理，如果有问题可以拨打客服热线95118沟通，再见。\",\n" + "\"createTime\": \"2020-02-18 11:10:51\"\n" + "},\n" + "{\n" + "\"question\": \"挂机\",\n" + "\"answer\": \"\",\n" + "\"createTime\": \"2020-02-18 11:11:05\",\n" + "\"intent\": \"识别内容ASR:audioCount:null#nlpAction:#nlpNeedResult:\"\n" + "}\n" + "],\n" + "\"resultType\": \"a,effective,\",\n" + "\"stat\": \"a,effective,\",\n" + "\"callId\": \"0d22fa6a-cc9f-1238-b7b8-f8bc1235feb0\"\n" + "}";
        String str1 = "";
        System.out.println(parseHtContent(str1));
    }
    private static  String parseHtContent(String content){
        String result = "";
        try{
            StringBuilder resultStr = new StringBuilder();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            HtContnt htContnt = gson.fromJson(content,HtContnt.class);
            List<HtResult> htResultList = htContnt.getResult();
            resultStr.append(" rank-nodeId-intent:");
            for (HtResult htResult : htResultList) {
                resultStr.append(htResult.getRank()).append("-").append(htResult.getNodeId()).append("-").append(htResult.getIntent()).append("|");
            }
            result = resultStr.toString();
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    @Data
    public class HtContnt{
        private String isSuccess;
        private String errResult;
        private String resultType;
        private String stat;
        private String callId;
        private List<HtResult> result;
    }

    @Data
    public  class HtResult{
        private String question;
        private String answer;
        private String createTime;
        private String rank;
        private String nodeId;
        private String intent;
        private String asrScore;
        private String nlpScore;
    }

}
