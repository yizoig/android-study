package com.example.exvu.myapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private Button btnone;
    private Button btntwo;
    private Button btnthree;
    private Button btnfour;

    public MyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_my, container, false);
        this.btnfour = (Button) view.findViewById(R.id.btn_four);
        this.btnthree = (Button) view.findViewById(R.id.btn_three);
        this.btntwo = (Button) view.findViewById(R.id.btn_two);
        this.btnone = (Button) view.findViewById(R.id.btn_one);

        this.btnone.setOnClickListener(this);
        this.btntwo.setOnClickListener(this);
        this.btnthree.setOnClickListener(this);
        this.btnfour.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_one:
                TextView tab_menu_channel_num = (TextView) getActivity().findViewById(R.id.tab_menu_channel_num);
                tab_menu_channel_num.setText("11");
                tab_menu_channel_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_two:
                TextView tab_menu_better_num = (TextView) getActivity().findViewById(R.id.tab_menu_better_num);
                tab_menu_better_num.setText("20");
                tab_menu_better_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_three:
                TextView tab_menu_message_num = (TextView) getActivity().findViewById(R.id.tab_menu_message_num);
                tab_menu_message_num.setText("99+");
                tab_menu_message_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_four:
                ImageView tab_menu_ny = (ImageView) getActivity().findViewById(R.id.tab_menu_ny);
                tab_menu_ny.setVisibility(View.VISIBLE);
                break;

        }
    }
}

