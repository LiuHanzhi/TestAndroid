package com.lhz.test.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by liuhanzhi on 16/9/12.
 */
public class DrawTextView extends View {

    private String text = "asdfghijklmn";

    private Paint paint;

    public DrawTextView(Context context) {
        super(context);
        init(null);
    }

    public DrawTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DrawTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        paint = new Paint();
        paint.setTextSize(dipToPx(getContext(), 15));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = getDefaultSize(getMinimumWidth(), widthMeasureSpec);
//        float width = paint.measureText(text) + getPaddingLeft() + getPaddingRight();
//        float height = paint.getFontMetrics().bottom - paint.getFontMetrics().top + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension((int) 300, (int) 100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
//        float baseLine = getPaddingTop() + (paint.getFontMetrics().bottom - paint.getFontMetrics().top) - paint.getFontMetrics().bottom;
        Log.e("lhz", "paint.getFontMetrics().top:" + paint.getFontMetrics().top + "paint.getFontMetrics().bottom:" + paint.getFontMetrics().bottom);
        float textH = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
        float y = (100 - textH) / 2 - paint.getFontMetrics().top;
        canvas.drawText(text, getPaddingLeft(), y, paint);

    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }


    /**
     * dip转px
     */
    public static int dipToPx(Context context, int dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pxValue = (int) (dipValue * scale + 0.5f);

        return pxValue;
    }
}
