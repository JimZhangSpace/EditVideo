package com.zj.editvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

import VideoHandle.EpDraw;
import VideoHandle.EpEditor;
import VideoHandle.EpText;
import VideoHandle.EpVideo;
import VideoHandle.OnEditorListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = "/data/data/com.zj.editvideo/video/VID_20180804_092814.mp4";

        File file = new File(path);
        if (file.exists()) {

            editVideo(path, "我要测试视频编辑功能！");

        } else {

            Log.i("MainActivity", "File doesn't exist!");

        }

    }

    private void editVideo(String url, String text) {

        EpVideo epVideo = new EpVideo(url);
        epVideo.addText(new EpText(100, 200, 45, EpText.Color.Red, "/data/data/com.zj.editvideo/video/msyh.ttf", text, new EpText.Time(3, 5)));

        EpDraw epDraw = new EpDraw("/data/data/com.zj.editvideo/video/Screenshot_2018-06-25-17-10-18.png",10,10,50,50,false);
        epVideo.addDraw(epDraw);


        EpEditor.OutputOption outputOption = new EpEditor.OutputOption("/data/data/com.zj.editvideo/video/test.mp4");
        outputOption.setWidth(480);//输出视频宽，如果不设置则为原始视频宽高
        outputOption.setHeight(360);//输出视频高度
        outputOption.frameRate = 30;//输出视频帧率,默认30
        outputOption.bitRate = 10;//输出视频码率,默认10
        EpEditor.exec(epVideo, outputOption, new OnEditorListener() {

            @Override
            public void onSuccess() {
                Log.i("editVideo","onSuccess");
            }

            @Override
            public void onFailure() {
                Log.i("editVideo","onFailure");
            }

            @Override
            public void onProgress(float progress) {
                //这里获取处理进度
                Log.i("editVideo","onProgress");
            }

        });
    }
}
