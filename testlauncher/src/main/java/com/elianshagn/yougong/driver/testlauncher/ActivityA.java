package com.elianshagn.yougong.driver.testlauncher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by liuhanzhi on 16/9/5.
 */
public class ActivityA extends AppCompatActivity {

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
