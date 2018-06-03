package com.example.exvu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class SmsAdapter extends BaseAdapter {

    private LinkedList<Sms> mData;
    private Context context;

    public SmsAdapter(LinkedList<Sms> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.message_list, viewGroup, false);

        TextView send = (TextView) view.findViewById(R.id.send);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView body = (TextView) view.findViewById(R.id.body);

        send.setText(mData.get(i).getSend());
        date.setText(mData.get(i).getDate());
        body.setText(mData.get(i).getBody());
        return view;
    }
}
