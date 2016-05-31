package com.lhz.testdrawtext;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        //通知view组件重绘
        view.invalidate();
        layout.addView(view);

        TextView textView = (TextView) findViewById(R.id.text);
//        textView.setTextColor(ColorStateList.valueOf(getResources().getColor(R.color.blacklight_redlight_selector)));
        Log.d("lhz", "R.color.blacklight_redlight_selector:" + R.color.blacklight_redlight_selector);
        textView.setTextColor(getResources().getColorStateList(R.color.blacklight_redlight_selector));

    }


}
