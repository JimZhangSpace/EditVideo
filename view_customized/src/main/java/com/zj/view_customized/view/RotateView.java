package com.zj.view_customized.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RotateView extends View {


    public RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Paint textPaint = new Paint();
        textPaint.setTextSize(30);
        canvas.drawText("Hello World!", 500, 500, textPaint);
        canvas.drawText("Hello HenCoder,Hello Android",500,530,textPaint);

        animate().rotation(-90);

        canvas.restore();

        canvas.drawText("测试字幕生成，动画字幕",500,560,textPaint);

    }

}
