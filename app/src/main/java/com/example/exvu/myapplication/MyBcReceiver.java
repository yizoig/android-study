package com.example.exvu.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MyBcReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(final Context context, Intent intent) {

        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(context)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("警告");
                builder.setMessage("您的账号在别处登录，请重新登陆~");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityController.finallyAll();
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
                alertDialog.show();
            } else {
//没有悬浮窗权限m,去开启悬浮窗权限
                try {
                    Intent intent1 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    intent1.setData(Uri.parse("package:" + context.getPackageName()));
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else {

        }
    }
}
