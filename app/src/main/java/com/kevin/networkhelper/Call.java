package com.kevin.networkhelper;

import java.io.IOException;

import okhttp3.Request;

/**
 * Created by zhouwenkai on 2017/2/7.
 */

public interface Call<T> extends Cloneable {

    Request request();

    Response<T> execute() throws IOException;

    void enqueue(Callback<T> callback);

    void cancel();

    boolean isExecuted();

    boolean isCanceled();

    Call<T> clone();
}
