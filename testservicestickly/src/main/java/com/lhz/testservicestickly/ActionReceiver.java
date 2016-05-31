package com.lhz.testservicestickly;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liuhanzhi on 16/3/3.
 */
public class ActionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("lhz", "onReceive:" + intent.getAction());
        Log.d("lhz", "ActionReceiver:" + MainActivity.count++);
    }
}
