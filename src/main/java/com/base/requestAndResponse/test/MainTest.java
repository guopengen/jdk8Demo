package com.base.requestAndResponse.test;

import com.base.requestAndResponse.coverter.JsonConverter;
import com.base.requestAndResponse.request.QueryRequest;
import com.base.requestAndResponse.response.QueryResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 16:13
 */
public class MainTest {
    public static void main(String[] args) {
        QueryRequest request = new QueryRequest();
        JsonConverter jsonConverter = new JsonConverter();
        QueryResponse response = new CallClient().execute(request, jsonConverter);

    }
}
