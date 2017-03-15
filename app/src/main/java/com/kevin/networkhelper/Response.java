package com.kevin.networkhelper;

import okhttp3.Headers;
import okhttp3.ResponseBody;

/**
 * Created by zhouwenkai on 2017/2/7.
 */

public final class Response<T> {

    private final okhttp3.Response rawResponse;
    private final T data;

    public Response(okhttp3.Response response, T data) {
        this.rawResponse = response;
        this.data = data;
    }

    public int code() {
        return rawResponse.code();
    }

    public boolean isSuccessful() {
        return rawResponse.isSuccessful();
    }

    public String message() {
        return rawResponse.message();
    }

    public Headers headers() {
        return rawResponse.headers();
    }

    public ResponseBody body() {
        return rawResponse.body();
    }

    public okhttp3.Response raw() {
        return rawResponse;
    }

    public T data() {
        return data;
    }

}
