package com.base.requestAndResponse.request;

import com.base.requestAndResponse.response.BaseResponse;

/**
 * @Description
 * @Author wangpengfei101022
 * @Date 2020/10/19 15:45
 */
public abstract class BaseRequest<T extends BaseResponse> {
    private String type;
    private String mchId;
    public abstract String getType();
    public abstract Class<T> getResponseType();

    public void setType(String type) {
        this.type = type;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }


}
