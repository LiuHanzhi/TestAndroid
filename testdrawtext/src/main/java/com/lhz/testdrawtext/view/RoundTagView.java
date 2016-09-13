package com.lhz.testdrawtext.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class RoundTagView extends View {

    private Paint textPaint;

    private Paint fillPaint;

    private Paint strokePaint;

    private String text;

    private float textSize;

    private Paint.FontMetrics textFontMetrics;

    private float cornerRadius = 20;

    public RoundTagView(Context context) {
        super(context);
        init();
    }

    public RoundTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoundTagView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        textSize = 60;

        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);
        textPaint.setColor(0xffffff00);

        fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(0xffff8347);
        fillPaint.setAntiAlias(true);

        strokePaint = new Paint();
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(1);
        strokePaint.setColor(0xffff0000);
        strokePaint.setAntiAlias(true);

        textFontMetrics = textPaint.getFontMetrics();
    }

    public void set(String text, int fillColor, int strokeColor, int strokeWidth, int cornerRadius) {
        if (fillColor == 0) {
            fillColor = 0xffff8347;
        }

        if (strokeColor == 0) {
            strokeColor = 0xffff8347;
        }
        if (!TextUtils.equals(this.text, text) || fillPaint.getColor() != fillColor || strokePaint.getColor() != strokeColor || strokePaint.getStrokeWidth() != strokeWidth || this.cornerRadius != cornerRadius) {
            this.text = text;
            fillPaint.setColor(fillColor);
            strokePaint.setColor(strokeColor);
            strokePaint.setStrokeWidth(strokeWidth);
            this.cornerRadius = cornerRadius;
            invalidate();
        }
    }

    /**
     * 文字
     *
     * @param text
     */
    public void setText(String text) {
        if (!TextUtils.equals(this.text, text)) {
            this.text = text;
            requestLayout();
            invalidate();
        }
    }

    /**
     * 填充背景色
     *
     * @param color
     */
    public void setFillColor(int color) {

        if (color == 0) {
            color = 0xffff8347;
        }

        if (fillPaint.getColor() != color) {
            fillPaint.setColor(color);
            invalidate();
        }
    }

    /**
     * 边框颜色
     *
     * @param color
     */
    public void setStrokeColor(int color) {
        if (color == 0) {
            color = 0xffff8347;
        }

        if (strokePaint.getColor() != color) {
            strokePaint.setColor(color);
            invalidate();
        }
    }

    /**
     * 圆角弧度
     *
     * @param cornerRadiusPx
     */
    public void setCornerRadius(int cornerRadiusPx) {
        if (this.cornerRadius != cornerRadiusPx) {
            this.cornerRadius = cornerRadiusPx;
            invalidate();
        }
    }

    /**
     * @param strokeWidthPx stroke宽度
     */
    public void setStrokeWidth(int strokeWidthPx) {
        if (this.strokePaint.getStrokeWidth() != strokeWidthPx) {
            strokePaint.setStrokeWidth(strokeWidthPx);
            invalidate();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        RectF rectF = calculateText(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());

//        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, fillPaint);
//        fillPaint.setStyle(Paint.Style.STROKE);
//        fillPaint.setColor(0xffff0000);
//        fillPaint.setStrokeWidth(3);
//        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, fillPaint);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, strokePaint);
        float strokeWidth = strokePaint.getStrokeWidth();
//        canvas.drawRoundRect(new RectF(rectF.left + strokeWidth, rectF.top + strokeWidth, rectF.right - strokeWidth, rectF.bottom - strokeWidth), cornerRadius, cornerRadius, fillPaint);
//
//
        drawText(canvas, text, textPaint, rectF);

        //drawAnother(canvas);
    }

    private void drawAnother(Canvas canvas) {
        RectF rectF = calculateText(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        RectF rectFNew = new RectF(rectF.left, rectF.top + 300, rectF.right, rectF.bottom + 300);
        canvas.drawRoundRect(rectFNew, cornerRadius, cornerRadius, fillPaint);
        drawText(canvas, text, textPaint, rectFNew);
    }

    public void drawText(Canvas canvas, String text, Paint paint, RectF rectF) {
        RectF textR = new RectF(rectF.left + getPaddingLeft(), rectF.top + getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        float baseLine = (textR.bottom + textR.top - textFontMetrics.bottom - textFontMetrics.top) / 2;

        canvas.drawText(text, textR.centerX(), baseLine, paint);
    }

    /**
     * 计算一个单元格的范围
     */
    public RectF calculateText(String text, Paint paint, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        float textWidth = paint.measureText(text);
        float textHeight = textFontMetrics.descent - textFontMetrics.ascent;

        RectF rectF = new RectF();
        rectF.set(0, 0, textWidth + paddingLeft + paddingRight, textHeight + paddingTop + paddingBottom);

        return rectF;
    }

    public void calculateView(String text, Paint paint, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        float textHeight = textFontMetrics.descent - textFontMetrics.ascent;
        float textWidth = paint.measureText(text);
        float viewHeight = textHeight + paddingTop + paddingBottom + 0.5f;
        float viewWidth = textWidth + paddingLeft + paddingRight + viewHeight / 3 + 0.5f;
        setMeasuredDimension((int) viewWidth, (int) viewHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        calculateView(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
}
