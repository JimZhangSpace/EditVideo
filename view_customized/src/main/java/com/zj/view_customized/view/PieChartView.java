package com.zj.view_customized.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PieChartView extends View {


    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);

//        canvas.drawCircle(500, 500, 300, paint);

        RectF rectF = new RectF();
        rectF.bottom = 1000;
        rectF.left = 500;
        rectF.right = 1000;
        rectF.top = 500;

        Paint paint1 = new Paint();
        paint1.setColor(Color.BLUE);

        RectF rectF1 = new RectF();
        rectF1.bottom = 1010;
        rectF1.left = 510;
        rectF1.right = 1010;
        rectF1.top = 510;

        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#EEEE00"));

        RectF rectF2 = new RectF();
        rectF2.bottom = 1020;
        rectF2.left = 510;
        rectF2.right = 1010;
        rectF2.top = 520;

        Paint paint3 = new Paint();
        paint3.setColor(Color.parseColor("#F08080"));

        RectF rectF3 = new RectF();
        rectF3.bottom = 1020;
        rectF3.left = 500;
        rectF3.right = 1000;
        rectF3.top = 520;

        Paint paint4 = new Paint();
        paint4.setColor(Color.parseColor("#F4A460"));

        RectF rectF4 = new RectF();
        rectF4.bottom = 1010;
        rectF4.left = 490;
        rectF4.right = 990;
        rectF4.top = 510;


        canvas.drawArc(rectF, 180, 135, true, paint);
        canvas.drawArc(rectF1, 315, 45, true, paint1);
        canvas.drawArc(rectF2, 0, 60, true, paint2);
        canvas.drawArc(rectF3, 60, 75, true, paint3);
        canvas.drawArc(rectF4, 135, 45, true, paint4);


    }

}
