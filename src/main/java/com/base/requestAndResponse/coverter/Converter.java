package com.base.requestAndResponse.coverter;

import com.base.requestAndResponse.request.BaseRequest;
import com.base.requestAndResponse.response.BaseResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 17:58
 */
public interface Converter {
    <A extends BaseRequest<?>> String bean2String(A request);

    <B extends BaseResponse> B string2Bean(String responStr, Class<B> clazz);
}
