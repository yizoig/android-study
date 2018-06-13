package com.example.exvu.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 */
public class MainActivity extends BaseActivity {

    private Socket socket;
    private BufferedReader bufferedReader = null;
    private PrintWriter printWriter;
    private String content = "";
    private StringBuilder stringBuilder;
    private android.widget.TextView title;
    private android.widget.LinearLayout footer;
    private TextView txtshow;
    private android.widget.EditText editor;
    private android.widget.Button send;
    private static final String HOST = "192.168.0.106";
    private static final int PORT = 12345;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (socket != null && socket.isConnected()) {
                        if (!socket.isInputShutdown() && bufferedReader != null) {
                            if ((content = bufferedReader.readLine()) != null) {
                                content += '\n';
                                handler.sendEmptyMessage(0x002);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x001:
                    if (socket != null && socket.isConnected()) {
                        new Thread() {
                            @Override
                            public void run() {
                                String str = editor.getText().toString();
                                try {

                                    printWriter.println(str);


                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        editor.setText("");
                    }

                    break;
                case 0x002:
                    stringBuilder.append(content);
                    txtshow.setText(stringBuilder.toString());
                    break;
            }
        }
    };

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.send = (Button) findViewById(R.id.send);
        this.editor = (EditText) findViewById(R.id.editor);
        this.txtshow = (TextView) findViewById(R.id.txtshow);
        this.footer = (LinearLayout) findViewById(R.id.footer);
        this.title = (TextView) findViewById(R.id.title);


        stringBuilder = new StringBuilder();


        new Thread() {
            @Override
            public void run() {

                try {
                    socket = new Socket(HOST, PORT);
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0x001);

            }
        });
        new Thread(runnable).start();
    }

}

