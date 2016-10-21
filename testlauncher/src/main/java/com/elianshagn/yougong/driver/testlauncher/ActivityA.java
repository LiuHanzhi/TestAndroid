package com.elianshagn.yougong.driver.testlauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by liuhanzhion 16/9/5.
 */
public class ActivityA extends Activity {

    public static void launch(Fragment fragment) {
        Intent intent = new Intent(fragment.getContext(), ActivityA.class);
        fragment.startActivityForResult(intent, 11);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
