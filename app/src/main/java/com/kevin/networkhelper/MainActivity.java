package com.kevin.networkhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) this.findViewById(R.id.main_act_tv);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 1. 获取OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 2. 创建Request对象
        Request request = new Request.Builder()
                .url("http://123.57.31.11/androidnet/joke?id=7")
                .get()
                .build();
        // 3. 创建Call对象
        Call call = client.newCall(request);
        // 4. 使用OkHttpCall对Call进行包装
        OkHttpCall okhttpCall = new OkHttpCall(call);
        // 5. 调用OkHttpCall对象的enqueue(异步)发送请求
        okhttpCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 6. 获得Response对象当中的数据
                String responseStr = response.body().string();
                Log.d(TAG, "responseStr: " + responseStr);
                textView.setText(responseStr);
            }
        });
    }
}
