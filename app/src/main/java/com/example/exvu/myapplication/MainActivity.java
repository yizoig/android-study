package com.example.exvu.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {


    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    private long exitTime = 0;
    private TextView txttopbar;
    private RelativeLayout lytopbar;
    private TextView txtchannel;
    private TextView tabmenuchannelnum;
    private LinearLayout lytabmenuchannel;
    private TextView txtbetter;
    private TextView tabmenubetternum;
    private LinearLayout lytabmenubetter;
    private TextView txtmessage;
    private TextView tabmenumessagenum;
    private LinearLayout lytabmenumessage;
    private TextView txtmy;
    private ImageView tabmenuny;
    private LinearLayout lytabmenumy;
    private LinearLayout lytabmenu;
    private View divtabbar;
    private ViewPager lycontent;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lycontent = (ViewPager) findViewById(R.id.ly_content);
        this.divtabbar = (View) findViewById(R.id.div_tab_bar);
        this.lytabmenu = (LinearLayout) findViewById(R.id.ly_tab_menu);
        this.lytabmenumy = (LinearLayout) findViewById(R.id.ly_tab_menu_my);
        this.tabmenuny = (ImageView) findViewById(R.id.tab_menu_ny);
        this.txtmy = (TextView) findViewById(R.id.txt_my);
        this.lytabmenumessage = (LinearLayout) findViewById(R.id.ly_tab_menu_message);
        this.tabmenumessagenum = (TextView) findViewById(R.id.tab_menu_message_num);
        this.txtmessage = (TextView) findViewById(R.id.txt_message);
        this.lytabmenubetter = (LinearLayout) findViewById(R.id.ly_tab_menu_better);
        this.tabmenubetternum = (TextView) findViewById(R.id.tab_menu_better_num);
        this.txtbetter = (TextView) findViewById(R.id.txt_better);
        this.lytabmenuchannel = (LinearLayout) findViewById(R.id.ly_tab_menu_channel);
        this.tabmenuchannelnum = (TextView) findViewById(R.id.tab_menu_channel_num);
        this.txtchannel = (TextView) findViewById(R.id.txt_channel);
        this.lytopbar = (RelativeLayout) findViewById(R.id.ly_top_bar);
        this.txttopbar = (TextView) findViewById(R.id.txt_topbar);

        this.lytabmenumy.setOnClickListener(this);
        this.lytabmenumessage.setOnClickListener(this);
        this.lytabmenubetter.setOnClickListener(this);
        this.lytabmenuchannel.setOnClickListener(this);


        lytabmenuchannel.setSelected(true);
        this.fragmentManager =getSupportFragmentManager();
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(fragmentManager);

        this.lycontent = (ViewPager) findViewById(R.id.ly_content);
        this.lycontent.setAdapter(myFragmentPagerAdapter);
        this.lycontent.setCurrentItem(0);
        this.lycontent.addOnPageChangeListener(this);

        MyDBOpenHelper myDBOpenHelper = new MyDBOpenHelper(this,null,null,1);
        myDBOpenHelper.getWritableDatabase();

    }

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    public void clearSelect() {
        this.lytabmenumy.setSelected(false);
        this.lytabmenumessage.setSelected(false);
        this.lytabmenubetter.setSelected(false);
        this.lytabmenuchannel.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_tab_menu_channel:
                clearSelect();
                lytabmenuchannel.setSelected(true);
                lycontent.setCurrentItem(0);
                break;
            case R.id.ly_tab_menu_better:
                clearSelect();
                lytabmenubetter.setSelected(true);
                lycontent.setCurrentItem(1);
                break;
            case R.id.ly_tab_menu_message:
                clearSelect();
                lytabmenumessage.setSelected(true);
                lycontent.setCurrentItem(2);
                break;
            case R.id.ly_tab_menu_my:
                clearSelect();
                lytabmenumy.setSelected(true);
                lycontent.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (lycontent.getCurrentItem()) {
                case PAGE_ONE:
                    clearSelect();
                    lytabmenuchannel.setSelected(true);
                    break;
                case PAGE_TWO:
                    clearSelect();
                    lytabmenubetter.setSelected(true);
                    break;
                case PAGE_THREE:
                    clearSelect();
                    lytabmenumessage.setSelected(true);
                    break;
                case PAGE_FOUR:
                    clearSelect();
                    lytabmenumy.setSelected(true);
                    break;
            }
        }
    }
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fragmentManager.popBackStack();
        }
    }
}

