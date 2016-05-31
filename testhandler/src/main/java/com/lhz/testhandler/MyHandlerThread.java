package com.lhz.testhandler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/**
 * Created by liuhanzhi on 16/3/3.
 */
public class MyHandlerThread extends HandlerThread {

    private static Handler handler;

    public MyHandlerThread(String name) {
        super(name);
    }

    public Handler getHandler() {
        if (null == handler) {
            handler = new Handler(getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Log.d("lhz", "handleMessage----------");
                }
            };
        }
        return handler;
    }
}
