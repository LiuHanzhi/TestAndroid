package com.lhz.testservicestickly;

import android.content.Intent;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lhz", "MainActivity:" + MainActivity.count++);

        startService(new Intent(this, MyService.class));
    }

    public void count(View view) {
        Log.d("lhz", "MainActivity:" + MainActivity.count++);
    }
}
