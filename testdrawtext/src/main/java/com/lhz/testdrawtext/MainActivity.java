package com.lhz.testdrawtext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.lhz.testdrawtext.view.NoInvoiceTagView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        NoInvoiceTagView tagView = new NoInvoiceTagView(this);
//        tagView.setText("无发票我就是没有发票");
        tagView.setPadding(30,30,30,30);
//        tagView.setTextSize(100);
        container.addView(tagView);

//        RoundTagView roundTagView = (RoundTagView) findViewById(R.id.round_tagView);
//        roundTagView.setText("测试");
//        init();
//        StampView stampView = (StampView) findViewById(R.id.stampview);
//        stampView.setText("adc");
    }

    private void init() {
//        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
//        final DrawView view = new DrawView(this);
//        view.setMinimumHeight(500);
//        view.setMinimumWidth(300);
//        //通知view组件重绘
//        view.invalidate();
//        layout.addView(view);
//
//        TextView textView = (TextView) findViewById(R.id.text);
////        textView.setTextColor(ColorStateList.valueOf(getResources().getColor(R.color.blacklight_redlight_selector)));
//        Log.d("lhz", "R.color.blacklight_redlight_selector:" + R.color.blacklight_redlight_selector);
//        textView.setTextColor(getResources().getColorStateList(R.color.blacklight_redlight_selector));

    }


}
