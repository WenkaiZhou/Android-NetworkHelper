package com.kevin.networkhelper;

import java.io.IOException;

/**
 * Created by zhouwenkai on 2017/2/7.
 */

public interface Callback<T> {
    /**
     * 网络访问失败的监听回调
     * @param call
     * @param e
     */
    void onFailure(okhttp3.Call call, IOException e);

    /**
     * 网络访问成功的监听回调
     * @param call
     * @param response
     * @throws IOException
     */
    void onResponse(okhttp3.Call call, Response<T> response);
}
