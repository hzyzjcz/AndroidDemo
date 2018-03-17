package com.zhouxiaofeng.demo.webview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhouxiaofeng.demo.R;
import com.zhouxiaofeng.demo.base.BaseActivity;

/**
 * Created by xiaof on 2018/2/24.
 */

public class WebViewActivity extends BaseActivity{

    private WebView webView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webview);
        WebSettings wSet = webView.getSettings();
        wSet.setJavaScriptEnabled(true);
        //加载本地的assets文件夹中的html文件
        webView.loadUrl("file:///android_asset/index.html");

        //webView.loadUrl("https://m.baidu.com/");

        //不调用本地浏览器 使用该webview
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
