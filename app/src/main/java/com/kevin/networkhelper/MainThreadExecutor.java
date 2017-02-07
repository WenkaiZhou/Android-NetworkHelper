package com.kevin.networkhelper;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * Created by zhouwenkai on 2017/2/6.
 */

public class MainThreadExecutor implements Executor {

    private Handler handler = new Handler(Looper.getMainLooper());

    private MainThreadExecutor() {
    }

    private static MainThreadExecutor sInstance = null;

    public static MainThreadExecutor getInstance() {
        if (sInstance == null) {
            synchronized (MainThreadExecutor.class) {
                if (sInstance == null)
                    sInstance = new MainThreadExecutor();
            }
        }
        return sInstance;
    }

    @Override
    public void execute(Runnable command) {
        handler.post(command);
    }
}