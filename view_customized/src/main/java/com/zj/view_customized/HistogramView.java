package com.zj.view_customized;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class HistogramView extends View {


    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);

        canvas.drawLine(50, 1000, 50, 200, paint); //y axes
        canvas.drawLine(50, 1000, 850, 1000, paint); //x axes

        //y axes arrow
        canvas.drawLine(50, 200, 40, 210, paint);
        canvas.drawLine(50, 200, 60, 210, paint);

        //x axes arrow
        canvas.drawLine(850, 1000, 840, 990, paint);
        canvas.drawLine(850, 1000, 840, 1010, paint);

        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.parseColor("#A2CD5A"));


        Rect[] rects = getRects(70, 996, 70, 20, getData());

        for (Rect rect : rects) {

            canvas.drawRect(rect, rectPaint);

        }


    }


    private int[] getData() {
        return new int[]{0,50, 60, 45, 60, 55, 40};
    }

    private Rect[] getRects(int startX, int startY, int width, int space, int[] datas) {

        Rect[] rects = new Rect[datas.length];

        for (int i = 0; i < datas.length; i++) {

            Rect rect = new Rect();
            rect.bottom = startY;
            rect.left = startX + width * i + space * i;
            rect.right = rect.left + width;
            rect.top = startY - 10 * datas[i];

            rects[i] = rect;
        }
        return rects;
    }

}
