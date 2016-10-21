package com.lhz.test.testlaunchmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 结论:
 * Activity A,B,C launchmode分别为standard standard singleInstance
 * 启动方式为A->B->C->A
 * 按back键返回时,显示的界面依次为A->B->A->C
 * 原因:因为C的launchmodel为singleInstanc,故系统会为其分配一个单独的栈,所以就会有两个栈,第一个栈是A->B->A,第二个栈是C
 * 返回时就会依次先pop当前activity所在的栈(即第一个栈),然后再pop第二个栈,所以顺序就是A->B->A->C
 */
public class ActivityA extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        textView.setText("Activity A");
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Intent intent = new Intent(this, ActivityB.class);
            startActivity(intent);
        }
    }
}
