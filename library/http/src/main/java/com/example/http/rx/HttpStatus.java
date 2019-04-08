package com.example.http.rx;

import com.google.gson.annotations.SerializedName;

/**
 * @author Li
 * @data 2017年12月16
 * @Email 364797468@qq.com
 * @describe 只获取 code/和msg字段 当code!=成功code的时候做处理
 * <p>
 * code=5 帐号密码过期重新登陆
 */

public class HttpStatus {

    @SerializedName("returnCode")
    private int returnCode;
    @SerializedName("returnMsg")
    private String returnMsg;

    public int getCode() {
        return returnCode;
    }

    public String getMessage() {
        return returnMsg;
    }

    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     */
    public boolean isCodeInvalid() {
        return returnCode != 0;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
