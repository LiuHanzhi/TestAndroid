package com.lhz.testandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printDensity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lhz", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lhz", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lhz", "onDestroy");
    }

    private void printDensity() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        Log.e("lhz", "width:" + width + ",height:" + height + ",density:" + density + ",densityDpi:" + densityDpi);
    }
}
