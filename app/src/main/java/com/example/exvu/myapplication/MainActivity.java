package com.example.exvu.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {


    private long exitTime = 0;
    private WebView webview;
    private android.widget.Button back;
    private android.widget.Button refresh;
    private android.widget.Button top;
    private TextView web_title;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.webview = (WebView) findViewById(R.id.webview);
        this.web_title = (TextView) findViewById(R.id.web_title);
        this.top = (Button) findViewById(R.id.top);
        this.refresh = (Button) findViewById(R.id.refresh);
        this.back = (Button) findViewById(R.id.back);

        this.top.setOnClickListener(this);
        this.refresh.setOnClickListener(this);
        this.back.setOnClickListener(this);

        webview.loadUrl("http://www.baidu.com");
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                web_title.setText(title);
            }
        });

        webview.setWebViewClient(new WebViewClient(){
            //在webview里打开新链接
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.refresh:
                webview.reload();
                break;
            case R.id.top:
                webview.setScrollY(0);
                break;
        }
    }
}

