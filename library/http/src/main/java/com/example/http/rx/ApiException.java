package com.example.http.rx;

/**
 * @author Li
 * @data 2017年12月4日
 * @Email 364797468@qq.com
 * @describe 自定义异常处理类
 */

public class ApiException extends RuntimeException {
    public String errorMsg;
    public int returnCode;
    public ApiException(String errorMessage) {
        super(errorMessage);
        errorMsg = errorMessage;
    }
    public ApiException(int returnCode,String errorMessage) {
        super(errorMessage);
        errorMsg = errorMessage;
        this.returnCode=returnCode;
    }
}
