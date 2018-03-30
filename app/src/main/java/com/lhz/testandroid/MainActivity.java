package com.lhz.testandroid;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        printDensity();
//        tttt();
//        String packageList = System.getProperty("java.protocol.handler.pkgs");
//        Log.e("lhz", " " + packageList);

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.e("lhz","------");
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        reportFullyDrawn();
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        };
        handler.sendEmptyMessageDelayed(0, 3000);

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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


    private void tttt() {
        String str = "\n" +
                "{\n" +
                "    \"allow_order\":true,\n" +
                "    \"cash_coupon_money\":\"0.00\",\n" +
                "    \"coupon_margin_money\":\"0.00\",\n" +
                "    \"coupon_money\":\"0.00\",\n" +
                "    \"discount_coupon_money\":\"0.00\",\n" +
                "    \"discount_ratio\":10,\n" +
                "    \"floor_money\":\"0.00\",\n" +
                "    \"money\":\"692.00\",\n" +
                "    \"order_min_money\":\"500\",\n" +
                "    \"origin_money\":\"692.00\",\n" +
                "    \"ticket_coupon_money\":\"1.10\",\n" +
                "    \"invoice_money\":\"692.10\"\n" +
                "}";
        try {
            JSONObject jsonObject = new JSONObject(str);
            int aaa = jsonObject.optInt("invoice_money");
            int bbb = jsonObject.optInt("ticket_coupon_money");
            Log.e("lhz", "aaa:" + aaa + "bbb:" + bbb);


            String s = "61.00";
            int index1 = s.indexOf('.');
            if (index1 > 0) {
                s = s.substring(0, index1);
            }
            Log.e("lhz", "ccc:" + Integer.parseInt(s));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
