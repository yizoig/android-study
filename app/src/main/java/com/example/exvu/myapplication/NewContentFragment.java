package com.example.exvu.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewContentFragment extends Fragment {

    private String title;

    public NewContentFragment() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        TextView textView = (TextView)view.findViewById(R.id.text_content);
        TextView txtTopbar = (TextView)view.findViewById(R.id.txt_topbar);
        txtTopbar.setText(title);
        textView.setText("NewContentFragment");
        Log.e("测试","NewContentFragment");
        return view;
    }
}

