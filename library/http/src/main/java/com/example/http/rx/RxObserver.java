package com.example.http.rx;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;


import java.io.EOFException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Li
 * @data 2017年12月4日
 * @Email 364797468@qq.com
 * @describe 实例化Observer接口 加入RxManager统一处理
 */

public abstract class RxObserver<T> implements Observer<T> {
    private RxManager mRxManager;
    private int iWhiceRequest;//对于多个接口的同意处理
    private String sKey;//每个订阅的唯一键
    private boolean isShowDialog;
    private Dialog mDialog;
    private Context mContext;

    /**
     * 实例化配置项
     *
     * @param mContext      上下文
     * @param sKey          唯一订阅key
     * @param iWhiceRequest 多个接口请求识别
     * @param isShowDialog  是否显示请求进度 false/否
     */
    public RxObserver(Context mContext, String sKey, int iWhiceRequest, boolean isShowDialog) {
        this.iWhiceRequest = iWhiceRequest;
        this.sKey = sKey;
        this.isShowDialog = isShowDialog;
        this.mContext = mContext;
        if (isShowDialog) {
            mDialog = new ProgressDialog(mContext);
            mDialog.setTitle("加载中...");
        }
        mRxManager = RxManager.getInstance();
    }

    /**
     * 订阅
     *
     * @param d
     */
    @Override
    public void onSubscribe(Disposable d) {
        mRxManager.add(sKey, d);
        if (isShowDialog) {
            mDialog.show();
        }
        onStart(iWhiceRequest);
    }

    /**
     * 请求成功
     *
     * @param value
     */
    @Override
    public void onNext(T value) {
        onSuccess(iWhiceRequest, value);
    }

    /**
     * 请求失败
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        if (e instanceof EOFException ||
                e instanceof ConnectException ||
                e instanceof SocketException ||
                e instanceof BindException ||
                e instanceof SocketTimeoutException ||
                e instanceof UnknownHostException) {
           // String string = mContext.getString(R.string.error_net_work);d
            String string = "网络错误";
            Throwable throwable = new Throwable(string);
            onError(iWhiceRequest, throwable);
//            ToastUtils.showShort(R.string.error_net_work);
        } else if (e instanceof ApiException) {
            int i = ((ApiException) e).returnCode;
            if (i == 5 || i == 10) {
            } else if (((ApiException) e).errorMsg.contains("登录")) {
            }
            onError(iWhiceRequest, e);
        } else {
            String message = e.getMessage();
            onError(iWhiceRequest, e);
            Log.e(">>>>message>>>>>>>", message + "  ");
        }
    }

    /**
     * 完成数据
     */
    @Override
    public void onComplete() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    /**
     * 用于多个接口请求
     *
     * @param whichRequest
     */
    public void onStart(int whichRequest) {

    }

    //成功的回调
    public abstract void onSuccess(int whichRequest, T t);

    //失败的回调
    public abstract void onError(int whichRequest, Throwable e);
}
