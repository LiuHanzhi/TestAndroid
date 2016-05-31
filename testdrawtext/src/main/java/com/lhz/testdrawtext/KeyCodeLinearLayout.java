package com.lhz.testdrawtext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class KeyCodeLinearLayout extends LinearLayout {

    private PreKeyCodeListener preKeyCodeListener;

    public KeyCodeLinearLayout(Context context) {
        super(context);
    }

    public KeyCodeLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyCodeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KeyCodeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        Log.d("lhz","dispatchKeyEventPreIme------");
        if (preKeyCodeListener == null) {
            return super.dispatchKeyEventPreIme(event);
        }
        return preKeyCodeListener.preKeyEventPreIme(event);
    }

    public PreKeyCodeListener getPreKeyCodeListener() {
        return preKeyCodeListener;
    }

    public void setPreKeyCodeListener(PreKeyCodeListener preKeyCodeListener) {
        this.preKeyCodeListener = preKeyCodeListener;
    }

    public interface PreKeyCodeListener {

        public boolean preKeyEventPreIme(KeyEvent event);
    }
}
