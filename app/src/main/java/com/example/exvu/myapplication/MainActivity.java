package com.example.exvu.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {


    private RelativeLayout a;
    private TextView txttopbar;
    private RelativeLayout lytopbar;
    private TextView txtchannel;
    private android.widget.LinearLayout lytabmenuchannel;
    private TextView txtbetter;
    private android.widget.LinearLayout lytabmenubetter;
    private TextView txtmessage;
    private android.widget.LinearLayout lytabmenumessage;
    private TextView txtmy;
    private android.widget.LinearLayout lytabmenumy;
    private android.widget.LinearLayout lytabmenu;
    private View divtabbar;
    private FrameLayout lycontent;
    private MyFragment fg1;
    private FragmentManager fManager;
    private FragmentTransaction fTransaction;
    private TextView tabmenuchannelnum;
    private TextView tabmenubetternum;
    private TextView tabmenumessagenum;
    private android.widget.ImageView tabmenuny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.lycontent = (FrameLayout) findViewById(R.id.ly_content);
        this.divtabbar = (View) findViewById(R.id.div_tab_bar);
        this.lytabmenu = (LinearLayout) findViewById(R.id.ly_tab_menu);
        this.tabmenuny = (ImageView) findViewById(R.id.tab_menu_ny);
        this.tabmenumessagenum = (TextView) findViewById(R.id.tab_menu_message_num);
        this.tabmenubetternum = (TextView) findViewById(R.id.tab_menu_better_num);
        this.tabmenuchannelnum = (TextView) findViewById(R.id.tab_menu_channel_num);
        this.lytopbar = (RelativeLayout) findViewById(R.id.ly_top_bar);
        this.txttopbar = (TextView) findViewById(R.id.txt_topbar);

        this.lytabmenumy = (LinearLayout) findViewById(R.id.ly_tab_menu_my);
        this.txtmy = (TextView) findViewById(R.id.txt_my);

        this.lytabmenumessage = (LinearLayout) findViewById(R.id.ly_tab_menu_message);
        this.txtmessage = (TextView) findViewById(R.id.txt_message);

        this.lytabmenubetter = (LinearLayout) findViewById(R.id.ly_tab_menu_better);
        this.txtbetter = (TextView) findViewById(R.id.txt_better);

        this.lytabmenuchannel = (LinearLayout) findViewById(R.id.ly_tab_menu_channel);
        this.txtchannel = (TextView) findViewById(R.id.txt_channel);

        lytabmenubetter.setOnClickListener(this);
        lytabmenuchannel.setOnClickListener(this);
        lytabmenumessage.setOnClickListener(this);
        lytabmenumy.setOnClickListener(this);

        fg1 = new MyFragment();

        fManager = getFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.add(R.id.ly_content, fg1).commit();

    }

    //重置所有文本的选中状态
    private void setSelected() {
        txtchannel.setSelected(false);
        txtmessage.setSelected(false);
        txtbetter.setSelected(false);
        txtmy.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        try {

            switch (v.getId()) {
                case R.id.ly_tab_menu_channel:
                    Log.e("click", "ly_tab_menu_channel");
                    setSelected();
                    txtchannel.setSelected(true);
                    tabmenuchannelnum.setVisibility(View.INVISIBLE);
                    break;
                case R.id.ly_tab_menu_better:
                    Log.e("click", "ly_tab_menu_better");
                    setSelected();
                    txtbetter.setSelected(true);
                    tabmenubetternum.setVisibility(View.INVISIBLE);

                    break;
                case R.id.ly_tab_menu_message:
                    Log.e("click", "ly_tab_menu_message");
                    setSelected();
                    txtmessage.setSelected(true);
                    tabmenumessagenum.setVisibility(View.INVISIBLE);
                    break;
                case R.id.ly_tab_menu_my:
                    Log.e("click", "ly_tab_menu_my");
                    setSelected();
                    txtmy.setSelected(true);
                    tabmenuny.setVisibility(View.INVISIBLE);

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

