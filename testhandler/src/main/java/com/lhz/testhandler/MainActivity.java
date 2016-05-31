package com.lhz.testhandler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button initHandler;
    Button startHandler;
    Button startHandlerThread;
    TextView textView;
    Handler handler;

    MyHandlerThread myHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandler = (Button) findViewById(R.id.button);
        startHandler = (Button) findViewById(R.id.button1);
        startHandlerThread = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.text);
        initHandler.setOnClickListener(this);
        startHandler.setOnClickListener(this);
        startHandlerThread.setOnClickListener(this);

    }

    private int index;

    @Override
    public void onClick(View v) {
        if (v == initHandler) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    handler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            super.handleMessage(msg);
                            Log.d("lhz", index++ + "....");
                            textView.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(index++ + "....");
                                }
                            });

                        }
                    };
                    Looper.loop();
                }
            }).start();
        } else if (v == startHandler) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            Log.d("lhz", "send message");
                            handler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else if (v == startHandlerThread) {
            if (null == myHandlerThread) {
                myHandlerThread = new MyHandlerThread("myHandlerThread");
                myHandlerThread.start();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            Log.d("lhz", "send message");
                            if (null != myHandlerThread.getHandler()) {
                                myHandlerThread.getHandler().sendEmptyMessage(0);
                            } else {
                                Log.d("lhz", "hander not init");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
