package com.zj.view_customized;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AnnulusView extends View {

    public AnnulusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(30.0f);

        RectF rectF = new RectF();
        rectF.bottom = 800;
        rectF.left = 200;
        rectF.top = 200;
        rectF.right = 800;

        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.RED);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(30);
        arcPaint.setAntiAlias(true);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawCircle(500,500,300,paint);
        canvas.drawArc(rectF,270,60,false,arcPaint);

        arcPaint.setColor(Color.parseColor("#F08080"));
        canvas.drawArc(rectF,330,40,false,arcPaint);
        canvas.drawText("1453 calories burned",500,500,textPaint);
    }
}