package com.lhz.testdrawtext.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lhz.testdrawtext.tool.UITool;


public class NoInvoiceTagView extends View {

    private Paint textPaint;

    private Paint backPaint;

    private String text;

    private Paint.FontMetrics textFontMetrics;

    private float textSize;

    private float topLeftRadius;//左上圆角半径

    private float topRightRadius;//右上圆角半径

    private float bottomLeftRadius;//左下圆角半径

    private float bottomRightRadius;//右下圆角半径

    private int quadDistance;//贝塞尔曲线--起点终点距离

    private int quadToRound;//贝塞尔曲线--锚点偏移量


    public NoInvoiceTagView(Context context) {
        super(context);
        init();
    }

    public NoInvoiceTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoInvoiceTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NoInvoiceTagView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        topLeftRadius = UITool.dipToPx(getContext(), 2);
        topRightRadius = UITool.dipToPx(getContext(), 2);
        bottomLeftRadius = UITool.dipToPx(getContext(), 2);
        bottomRightRadius = UITool.dipToPx(getContext(), 2);
        quadDistance = UITool.dipToPx(getContext(), 3);
        quadToRound = UITool.dipToPx(getContext(), 8);

        textSize = UITool.dipToPxFloat(getContext(), 11);

        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);
        textPaint.setColor(0xffffffff);

        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(0xff4a93f3);
        backPaint.setAntiAlias(true);

        textFontMetrics = textPaint.getFontMetrics();

        setText("无发票");
    }

    public void setText(String text) {
        if (!TextUtils.equals(this.text, text)) {
            this.text = text;
            requestLayout();
            invalidate();
        }
    }

    public void setTextSize(float textSize) {
        if (this.textSize != textSize) {
            this.textSize = textSize;
            textPaint.setTextSize(textSize);
            textFontMetrics = textPaint.getFontMetrics();
            requestLayout();
            invalidate();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        RectF rectF = calculateText(text, textPaint, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());

        float width = rectF.right - rectF.left;
        float height = rectF.bottom - rectF.top;


        Path path = new Path();
        path.moveTo(rectF.left, topLeftRadius);
        path.arcTo(new RectF(rectF.left, rectF.top, topLeftRadius * 2, topLeftRadius * 2), -180, 90);
        path.lineTo(width - topRightRadius, rectF.top);
        path.arcTo(new RectF(width - 2 * topRightRadius, rectF.top, width, topRightRadius * 2), -90, 90);


        path.lineTo(width, height / 2 - quadDistance);
        path.quadTo(width - quadToRound, rectF.bottom / 2, width, height / 2 + quadDistance);
        path.lineTo(width, height - bottomRightRadius);
        path.arcTo(new RectF(width - 2 * bottomRightRadius, height - 2 * bottomRightRadius, width, height), 0, 90);
        path.lineTo(bottomLeftRadius, height);
        path.arcTo(new RectF(rectF.left, height - 2 * bottomLeftRadius, bottomLeftRadius * 2, height), 90, 90);
        path.lineTo(rectF.left, height / 2 + quadDistance);
        path.quadTo(quadToRound, height / 2, rectF.left, height / 2 - quadDistance);
        path.lineTo(rectF.left, topLeftRadius);
        path.close();
        canvas.drawPath(path, backPaint);

        drawText(canvas, text, textPaint, rectF);
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
        Log.e("lhz","textHeight:"+textHeight);
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
