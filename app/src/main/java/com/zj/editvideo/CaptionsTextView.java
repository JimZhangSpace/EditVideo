package com.zj.editvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;


public class CaptionsTextView extends android.support.v7.widget.AppCompatTextView {

    private int index = 0;

    private float middleY;
    private float mX;

    private Paint[] paints = new Paint[5];
    private List<Sentence> list;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }

    };


    public CaptionsTextView(Context context) {
        super(context);
        init();
    }

    public CaptionsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CaptionsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setFocusable(true);

        if (list == null) {
            list = new ArrayList<Sentence>();
            Sentence sen = new Sentence(0, "暂时没有通知公告");
            list.add(0, sen);
        }

        for (int i = 0; i < 5; i++) {

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize(20 + i * 5);
            paint.setColor(Color.BLACK);
            //水平方向拉伸两倍
            paint.setTextScaleX(1.5f);
            //设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
            paint.setTextSkewX((float) -0.25);
            paint.setTypeface(Typeface.SERIF);
            paint.setTextAlign(Paint.Align.CENTER);
            paints[i] = paint;

        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = list.size();
        if (index == -1 || index == size)
            return;
        float bottomY = middleY + 2 * 40;
        canvas.drawText(list.get(index).getName(), mX, bottomY, paints[4]);
        float tempY = 0;

        for (int i = index - 1; i >= 0; i--) {

            tempY = bottomY - (index - i) * 70;

            if (i % 2 == 0) {
                canvas.rotate(90, 90, 90);
            }

            canvas.drawText(list.get(i).getName(), mX, tempY, paints[4 + i - index]);

            if (i % 2 == 0) {
                canvas.rotate(-90, 90, 90);
            }

            if (index - i == 4) {
                break;
            }
        }


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mX = w * 0.5f;
        middleY = h * 0.5f;
    }

    public void setList(List<Sentence> data) {
        this.list = data;
    }

    public void updateUI() {
        new Thread(new UpdateThread()).start();
    }


    class UpdateThread implements Runnable {

        long time = 1000; // 开始 的时间，不能为零，否则前面几句歌词没有显示出来
        int i = 0;

        @Override
        public void run() {
            while (true) {
                if (index == list.size())
                    return;
                mHandler.sendEmptyMessage(1);
                try {
                    Thread.sleep(time);
                    index++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}