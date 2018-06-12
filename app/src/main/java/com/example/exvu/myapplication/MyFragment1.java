package com.example.exvu.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyFragment1 extends Fragment implements ListView.OnItemClickListener {

    private FragmentManager fManager;

    private String title;
    private ArrayList<Data> datas = null;
    private ListView list_news;

    public MyFragment1(FragmentManager fManager) {
        this.fManager = fManager;
        datas = new ArrayList<Data>();
        for (int i = 1; i <= 20; i++) {
            Data data = new Data("新闻标题" + i, i + "~新闻内容~~~~~~~~");
            datas.add(data);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_newlist, container, false);
        list_news = (ListView) view.findViewById(R.id.list_views);
        MyAdapter myAdapter = new MyAdapter(datas, getActivity());
        list_news.setAdapter(myAdapter);
        list_news.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        NewContentFragment newContentFragment = new NewContentFragment();
        newContentFragment.setTitle("标题1");
        Bundle  bundle = new Bundle();
        bundle.putString("content",datas.get(position).getNew_content());
        newContentFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.ly_content, newContentFragment);
        //调用addToBackStack将Fragment添加到栈中
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

