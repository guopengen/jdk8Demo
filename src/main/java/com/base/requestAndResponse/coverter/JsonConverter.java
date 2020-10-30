package com.base.requestAndResponse.coverter;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.base.requestAndResponse.request.BaseRequest;
import com.base.requestAndResponse.response.BaseResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 17:59
 */
public class JsonConverter implements Converter{

    @Override
    public <A extends BaseRequest<?>> String bean2String(A request) {
        return JSON.toJSONString(request);
    }

    @Override
    public <B extends BaseResponse> B string2Bean(String responStr, Class<B> clazz) {
        return JSON.parseObject(responStr, clazz);
    }
}
