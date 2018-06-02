package com.example.exvu.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 *
 */
public class MainActivity extends BaseActivity {


    private android.widget.Button login;
    private android.widget.LinearLayout FrameLayout1;

    private MyBcReceiver myBcReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        try{
            this.FrameLayout1 = (LinearLayout) findViewById(R.id.FrameLayout1);
            this.login = (Button) findViewById(R.id.login);

            localBroadcastManager = LocalBroadcastManager.getInstance(this);

            myBcReceiver = new MyBcReceiver();
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.jay.mybcreceiver.LOGIN_OTHER");
            localBroadcastManager.registerReceiver(myBcReceiver, intentFilter);

            this.login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent("com.jay.mybcreceiver.LOGIN_OTHER");
                    localBroadcastManager.sendBroadcast(intent);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myBcReceiver);
    }
}
