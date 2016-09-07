package com.example.administrator.titlebar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zhou.titleapplication.R;

public class Main2Activity extends BaseActivity {

    ImageView imgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showStatebar();
        imgBtn=(ImageView) findViewById(R.id.imgbtn);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFullWindow();
            }
        });

    }

    boolean isFullwindow = false;

    void switchFullWindow() {
        if (isFullwindow) {
           showStatebar();
        } else {
           showFullWindow();
        }
        isFullwindow = !isFullwindow;

    }



}
