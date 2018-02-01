package com.jetictors.futures.common.utils.rx;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.jetictors.futures.common.net.NetError;
import com.jetictors.futures.common.net.SubscriberListener;

import org.json.JSONException;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * 描述    :  请求统一处理
 * author  :  Jetictors
 * time    :  2018/2/1 10:39
 * version : v1.0.1
 */
public abstract class BaseSubscriberListener<T> extends SubscriberListener<T> {

    // 对应HTTP的状态码
    private static final int ERROR = 400;
    private static final int UNAUTHORIZED = 401; // 没有权限
    private static final int FORBIDDEN = 403; // 没有权限
    private static final int NOT_FOUND = 404; //
    private static final int INTERNAL_SERVER_ERROR = 500; // 服务器错误
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;


    @Override
    public void onFail(NetError errorMsg) {

    }

    @Override
    public void onError(Throwable e) {
        NetError error = null;
        if (e != null) {
            if (!(e instanceof NetError)) {
                if (e instanceof UnknownHostException) {
                    error = new NetError(e, NetError.NoConnectError);
                } else if (e instanceof JSONException
                        || e instanceof JsonParseException
                        || e instanceof JsonSyntaxException) {
                    error = new NetError(e, NetError.ParseError);
                } else if (e instanceof SocketException
                        || e instanceof SocketTimeoutException) {
                    error = new NetError(e, NetError.SocketError);
                } else if (e instanceof HttpException) {
                    HttpException httpException = (HttpException) e;
//                    if (httpException.code() == UNAUTHORIZED) {//去认证
//                        checkReLogin("401", AppContext.get().getString(R.string.auth_failure));
//                    }
                    error = new NetError(e, NetError.NetError);
                } else {
                    error = new NetError(e, NetError.OtherError);
                }
            } else {
                error = (NetError) e;
            }
            onFail(error);
        }

    }

    @Override
    public void checkReLogin(String errorCode, String errorMsg) {
//        AccountManager.INSTANCE.logout();
//        RxBus.getDefault().post(new Events<String>(GO_LOGIN, AppContext.get().getString(R.string.GO_LOGIN)));
    }
}
