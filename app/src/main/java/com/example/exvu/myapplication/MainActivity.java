package com.example.exvu.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */
public class MainActivity extends BaseActivity {


    private android.widget.TextView menu;
    private android.widget.ImageView img;
    private android.widget.TextView html;
    private WebView webview;
    private android.widget.ScrollView scroll;
    private Bitmap bitmap;
    private String detail = "";
    private boolean flag = false;
    private final static String PIC_URL = "http://ww2.sinaimg.cn/large/7a8aed7bgw1evshgr5z3oj20hs0qo0vq.jpg";
    private final static String HTML_URL = "https://www.baidu.com";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x001:
                    hideAllWidget();
                    img.setVisibility(View.VISIBLE);
                    img.setImageBitmap(bitmap);
                    Toast.makeText(MainActivity.this, "加载图片完成!!", Toast.LENGTH_SHORT).show();
                    break;
                case 0x002:
                    hideAllWidget();
                    scroll.setVisibility(View.VISIBLE);
                    html.setText(detail);
                    Toast.makeText(MainActivity.this, "html加载成功!!", Toast.LENGTH_SHORT).show();
                    break;
                case 0x003:
                    hideAllWidget();
                    webview.setVisibility(View.VISIBLE);
                    webview.loadDataWithBaseURL("",detail,"text/html", "UTF-8", "");
                    Toast.makeText(MainActivity.this, "页面加载成功!!", Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();

    }

    private void setView() {

        this.scroll = (ScrollView) findViewById(R.id.scroll);
        this.webview = (WebView) findViewById(R.id.webview);
        this.html = (TextView) findViewById(R.id.html);
        this.img = (ImageView) findViewById(R.id.img);
        this.menu = (TextView) findViewById(R.id.menu);
        registerForContextMenu(menu);
    }
    // 定义一个隐藏所有控件的方法:
    private void hideAllWidget() {
        img.setVisibility(View.GONE);
        scroll.setVisibility(View.GONE);
        webview.setVisibility(View.GONE);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.requestImage:
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            byte[] data = GetData.getImage(PIC_URL);
                            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0x001);
                    }
                }.start();
                break;
            case R.id.requestHtmlText:
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            detail = GetData.getHtml(HTML_URL);
                            Toast.makeText(MainActivity.this, detail, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0x002);
                    }
                }.start();
                break;
            case R.id.requestHtmlView:
                if (detail.equals("")) {
                    Toast.makeText(this, "先请求数据!!", Toast.LENGTH_SHORT).show();
                } else {
                    handler.sendEmptyMessage(0x003);
                }
                break;

        }
        return true;
    }
}

