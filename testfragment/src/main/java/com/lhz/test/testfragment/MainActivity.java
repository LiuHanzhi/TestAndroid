package com.lhz.test.testfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 结论:在activity中replace一个fragment操作,执行commit后,不会立即调用fragment的生命周期,即该fragment不是立即被添加到activity中来。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyFragment myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    private void addFragment(){
        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);

        myFragment = new MyFragment();
        Log.e("lhz","init------textview is "+ (myFragment.getTextView() == null?"null":"not null"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,myFragment);
        Log.e("lhz","replace------textview is "+ (myFragment.getTextView() == null?"null":"not null"));


//        fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();

        Log.e("lhz","commit----textview is "+ (myFragment.getTextView() == null?"null":"not null"));

        container.post(new Runnable() {
            @Override
            public void run() {
                Log.e("lhz","post----textview is "+ (myFragment.getTextView() == null?"null":"not null"));
            }
        });
    }

    @Override
    public void onClick(View v) {
        addFragment();
    }

    public static class MyFragment extends Fragment {

        public TextView textView;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.e("lhz","onCreate");

        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Log.e("lhz","onAttach");
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.e("lhz","onActivityCreated");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.e("lhz","onStart");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.e("lhz","onResume");
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Log.e("lhz","onCreateView");
            TextView textView = new TextView(getContext());
            textView.setText("this is a fragment!");
            this.textView = textView;
            return textView;
        }

        public TextView getTextView(){
            return textView;
        }


    }
}
