package com.base.requestAndResponse.coverter;

import com.base.requestAndResponse.request.BaseRequest;
import com.base.requestAndResponse.response.BaseResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 18:03
 */
public class XmlConverter implements Converter{

    @Override
    public <A extends BaseRequest<?>> String bean2String(A request) {
        //XmlUtils 具体实现
        return "";
    }

    @Override
    public <B extends BaseResponse> B string2Bean(String responStr, Class<B> clazz) {
        return null;
    }
}
