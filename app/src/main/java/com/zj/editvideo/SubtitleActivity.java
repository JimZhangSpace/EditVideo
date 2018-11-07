package com.zj.editvideo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SubtitleActivity extends AppCompatActivity {


    RotateTextView captionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subtitle);

        captionsTextView = (RotateTextView) findViewById(R.id.captions_view);
        List lst=new ArrayList<Sentence>();

        for(int i=0;i<3;i++){
            if(i%2==0){
                Sentence sen=new Sentence(i,i+"、金球奖三甲揭晓 C罗梅西哈维入围 ");
                lst.add(i, sen);
            }else{
                Sentence sen=new Sentence(i,i+"、公牛欲用三大主力换魔兽？？？？");
                lst.add(i, sen);
            }
        }

        //给View传递数据
        captionsTextView.setList(lst);
        //更新View
        captionsTextView.updateUI();
    }

}
