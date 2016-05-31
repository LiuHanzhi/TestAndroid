package com.lhz.testservicestickly;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liuhanzhi on 16/3/9.
 */
public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("lhz", "MyService.onStartCommand:" + MainActivity.count++);
        startLoop();
        return START_STICKY;
    }

    private void startLoop() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 1;
                while (true) {
                    Log.d("lhz", "start loop: " + n);
                    n++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
