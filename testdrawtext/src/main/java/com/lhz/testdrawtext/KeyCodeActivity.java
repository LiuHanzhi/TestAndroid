package com.lhz.testdrawtext;

import android.app.Activity;
import android.os.Bundle;

import com.lhz.testdrawtext.view.CustomEditText;

/**
 * Created by liuhanzhi on 16/4/22.
 */
public class KeyCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_key_code);

        CustomEditText editText = (CustomEditText) findViewById(R.id.custom_edit);
    }
}
