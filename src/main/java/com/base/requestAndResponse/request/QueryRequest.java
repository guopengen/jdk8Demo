package com.base.requestAndResponse.request;

import com.base.requestAndResponse.response.BaseResponse;
import com.base.requestAndResponse.response.QueryResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 15:46
 */
public class QueryRequest extends BaseRequest<QueryResponse>{

    private String outTradeNo;

    @Override
    public String getType() {
        return "query";
    }

    @Override
    public Class<QueryResponse> getResponseType() {
        return QueryResponse.class;
    }
}
