package com.example.http.rx;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author Li
 * @data 2017年12月4日
 * @Email 364797468@qq.com
 * @describe
 */
public class RxFunction<T> implements Function<BaseResultEntity<T>, T> {
    @Override
    public T apply(@NonNull BaseResultEntity<T> resultEntity) throws Exception {
        int code = resultEntity.getReturnCode();
        String msg = resultEntity.getReturnMsg();
        resultEntity.setReturnCode(code);
        resultEntity.setReturnMsg(msg);
        T result = resultEntity.getData();
        return result;
    }
}
