package com.zhouxiaofeng.demo.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhouxiaofeng.demo.R;
import com.zhouxiaofeng.demo.base.BaseActivity;

/**
 * Created by xiaof on 2018/2/24.
 */

public class WebViewActivity extends BaseActivity{

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/page.html");
        //webView.loadUrl("https://m.baidu.com/");

        //
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
