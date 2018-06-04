package com.example.exvu.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {


    private android.widget.RelativeLayout lytopbar;
    private TextView txtchannel;
    private TextView txtmessage;
    private TextView txtbetter;
    private android.widget.LinearLayout lytabbar;
    private android.view.View divtabbar;
    private android.widget.FrameLayout lycontent;

    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;
    private TextView txttopbar;
    private TextView txtsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.lycontent = (FrameLayout) findViewById(R.id.ly_content);
        this.divtabbar = (View) findViewById(R.id.div_tab_bar);
        this.lytabbar = (LinearLayout) findViewById(R.id.ly_tab_bar);
        this.txtsetting = (TextView) findViewById(R.id.txt_setting);
        this.txtbetter = (TextView) findViewById(R.id.txt_better);
        this.txtmessage = (TextView) findViewById(R.id.txt_message);
        this.txtchannel = (TextView) findViewById(R.id.txt_channel);
        this.lytopbar = (RelativeLayout) findViewById(R.id.ly_top_bar);
        this.txttopbar = (TextView) findViewById(R.id.txt_topbar);


        fManager = getFragmentManager();
        bindView();
        txtchannel.performClick();

    }

    private void bindView() {
        this.lycontent = (FrameLayout) findViewById(R.id.ly_content);
        this.divtabbar = (View) findViewById(R.id.div_tab_bar);
        this.lytabbar = (LinearLayout) findViewById(R.id.ly_tab_bar);
        this.txtbetter = (TextView) findViewById(R.id.txt_better);
        this.txtmessage = (TextView) findViewById(R.id.txt_message);
        this.txtchannel = (TextView) findViewById(R.id.txt_channel);
        this.lytopbar = (RelativeLayout) findViewById(R.id.ly_top_bar);
        txtchannel.setOnClickListener(this);
        txtmessage.setOnClickListener(this);
        txtbetter.setOnClickListener(this);
        txtsetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {
            FragmentTransaction fragmentTransaction = fManager.beginTransaction();
            hideAllFragment(fragmentTransaction);
            switch (view.getId()) {
                case R.id.txt_channel:
                    setSelected();
                    txtchannel.setSelected(true);
                    if (fg1 == null) {
                        fg1 = new MyFragment("chanel");
                        fragmentTransaction.add(R.id.ly_content, fg1);
                    } else {
                        fragmentTransaction.show(fg1);
                    }
                    break;
                case R.id.txt_better:
                    setSelected();
                    txtbetter.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new MyFragment("better");
                        fragmentTransaction.add(R.id.ly_content, fg2);
                    } else {
                        fragmentTransaction.show(fg2);
                    }
                    break;
                case R.id.txt_message:
                    setSelected();
                    txtmessage.setSelected(true);
                    if (fg3 == null) {
                        fg3 = new MyFragment("message");
                        fragmentTransaction.add(R.id.ly_content, fg3);
                    } else {
                        fragmentTransaction.show(fg3);
                    }
                    break;
                case R.id.txt_setting:
                    setSelected();
                    txtsetting.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new MyFragment("my");
                        fragmentTransaction.add(R.id.ly_content, fg4);
                    } else {
                        fragmentTransaction.show(fg4);
                    }
                    break;
            }
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setSelected() {
        txtsetting.setSelected(false);
        txtmessage.setSelected(false);
        txtbetter.setSelected(false);
        txtchannel.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fTransaction) {
        if (fg1 != null) fTransaction.hide(fg1);
        if (fg2 != null) fTransaction.hide(fg2);
        if (fg3 != null) fTransaction.hide(fg3);
        if (fg4 != null) fTransaction.hide(fg4);
    }
}

