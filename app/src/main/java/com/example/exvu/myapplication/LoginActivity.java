package com.example.exvu.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private android.widget.EditText account;
    private android.widget.EditText password;
    private android.widget.Button submit;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.submit = (Button) findViewById(R.id.submit);
        this.password = (EditText) findViewById(R.id.password);
        this.account = (EditText) findViewById(R.id.account);
        submit.setOnClickListener(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!sharedPreferences.getString("accoount", "").equals("")) {
            this.account.setText(sharedPreferences.getString("account", ""));
            this.password.setText(sharedPreferences.getString("password", ""));
        }
    }

    @Override
    public void onClick(View view) {

        String account = this.account.getText().toString();
        String password = this.password.getText().toString();

        if (account.equals("admin") && password.equals("123456")) {
            editor = sharedPreferences.edit();

            editor.putString("account", account);
            editor.putString("password", password);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "哟，竟然蒙对了~", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "这么简单都输出，脑子呢？", Toast.LENGTH_SHORT).show();

        }
    }
}
