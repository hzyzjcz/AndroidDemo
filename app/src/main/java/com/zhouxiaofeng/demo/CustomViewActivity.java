package com.zhouxiaofeng.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhouxiaofeng.demo.base.BaseActivity;

/**
 * Created by Administrator on 2018/1/4.
 */

public class CustomViewActivity extends BaseActivity{
    private CustomView customView;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        customView = (CustomView) findViewById(R.id.view_custom);
        linearLayout = (LinearLayout) findViewById(R.id.line1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomViewActivity.this, "123", Toast.LENGTH_SHORT).show();
            }
        });
        customView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
    
    public void a123(View v){
        Toast.makeText(this, "345", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
