package com.lhz.test.testview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lhz.test.testview.view.DrawTextView;

public class MainActivity extends AppCompatActivity {

    private DrawTextView drawTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawTextView = (DrawTextView) findViewById(R.id.draw_textView);
        drawTextView.setText("asdfghjkl");
    }


}
