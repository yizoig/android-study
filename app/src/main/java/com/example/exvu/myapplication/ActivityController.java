package com.example.exvu.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    private static List<Activity> list = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {

        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void finallyAll() {
        for (Activity activity : list) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
