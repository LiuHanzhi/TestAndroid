package com.lhz.testdrawtext.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class StampView extends View {

    private Paint textPaint;

    private String text;

    private float textSize;

    private float roundSize;

    private int backColor;

    private Paint.FontMetrics textFontMetrics;

    public StampView(Context context) {
        super(context);
        init();
    }

    public StampView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StampView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StampView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        textSize = 60;
        roundSize = 7f;

        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);
        textPaint.setColor(0xfff45341);

        backColor = 0xfff45341;

        textFontMetrics = textPaint.getFontMetrics();

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, backColor);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(0x00000000);
        gradientDrawable.setCornerRadii(new float[]{roundSize, roundSize, roundSize, roundSize, roundSize, roundSize, roundSize, roundSize});
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(gradientDrawable);
        } else {
            this.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void setText(String text) {
        if (!TextUtils.equals(this.text, text)) {
            this.text = text;
            requestLayout();
            invalidate();
        }
    }

    public void setStampColor(int color) {

        if (color == 0) {
            color = 0xffff8347;
        }

        if (backColor != color) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(1, color);
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable.setColor(0x00000000);
            gradientDrawable.setCornerRadii(new float[]{roundSize, roundSize, roundSize, roundSize, roundSize, roundSize, roundSize, roundSize});
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                this.setBackground(gradientDrawable);
            } else {
                this.setBackgroundDrawable(gradientDrawable);
            }

            backColor = color;
            textPaint.setColor(color);
            invalidate();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        RectF rectF = calculateText(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        drawText(canvas, text, textPaint, rectF);
    }

    public void drawText(Canvas canvas, String text, Paint paint, RectF rectF) {
        RectF textR = new RectF(rectF.left + getPaddingLeft(), rectF.top + getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        float baseLine = (textR.bottom + textR.top - textFontMetrics.bottom - textFontMetrics.top) / 2;

        canvas.drawText(text, textR.centerX(), baseLine, paint);
    }

    public RectF calculateText(String text, Paint paint, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        float textWidth = paint.measureText(text);
        float textHeight = textFontMetrics.descent - textFontMetrics.ascent;

        RectF rectF = new RectF();
        rectF.set(1, 1, textWidth + paddingLeft + paddingRight + 1, textHeight + paddingTop + paddingBottom + 1);

        return rectF;
    }

    public void calculateView(String text, Paint paint, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        float textHeight = textFontMetrics.descent - textFontMetrics.ascent;
        float textWidth = paint.measureText(text);

        float viewHeight = textHeight + paddingTop + paddingBottom + 2 + 0.5f;
        float viewWidth = textWidth + paddingLeft + paddingRight + 2 + 0.5f;
        setMeasuredDimension((int) viewWidth, (int) viewHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        calculateView(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
}
