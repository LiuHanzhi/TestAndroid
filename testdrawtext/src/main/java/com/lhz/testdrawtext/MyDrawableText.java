package com.lhz.testdrawtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by liuhanzhi on 16/3/8.
 */
public class MyDrawableText extends View {
    public MyDrawableText(Context context, AttributeSet attrs) {
        super(context, attrs);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("画文本", 0, 0, paint);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Log.d("lhz","MyDrawableText.onKeyPreIme");
        return true;
    }
}
