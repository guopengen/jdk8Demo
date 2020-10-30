package com.base.requestAndResponse.test;

import com.alibaba.fastjson.JSON;
import com.base.requestAndResponse.coverter.Converter;
import com.base.requestAndResponse.request.BaseRequest;
import com.base.requestAndResponse.response.BaseResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 16:01
 */
public class CallClient {
    public <T extends BaseResponse> T execute(BaseRequest<T> request){
        String response = "假设这是三方系统返回内容";
        T responseBean = JSON.parseObject(response, request.getResponseType());
        return responseBean;
    }

    public <T extends BaseResponse> T execute(BaseRequest<T> request, Converter converter){
        String requestStr = converter.bean2String(request);
        String response = "假设这是三方系统返回内容";
        T responseBean = converter.string2Bean(response,request.getResponseType());
        return responseBean;
    }
}
