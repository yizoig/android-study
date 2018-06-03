package com.example.exvu.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class MainActivity extends BaseActivity {

    private List<Sms> mData;
    private SmsAdapter smsAdapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.list = (ListView) findViewById(R.id.list);

    }

    private void getMessages() {

        Uri uri = Uri.parse("content://sms/");

        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(uri, new String[]{"address", "date", "body"}, null, null, null);

        mData = new LinkedList<Sms>();
        while (cursor.moveToNext()) {

            Sms sms = new Sms();
            sms.setSend(cursor.getString(0));
            sms.setDate(cursor.getString(1));
            sms.setBody(cursor.getString(2));
            mData.add(sms);
        }
        cursor.close();
        smsAdapter = new SmsAdapter((LinkedList<Sms>) mData, MainActivity.this);
        list.setAdapter(smsAdapter);
    }
}
