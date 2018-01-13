package com.zhouxiaofeng.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button serviceBtn;
    private Button broadcastBtn;
    private Button frontServiceBtn;
    private Button customViewBtn;
    private Button largeImageBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceBtn = (Button) findViewById(R.id.btn_service);
        broadcastBtn = (Button) findViewById(R.id.btn_broadcast);
        frontServiceBtn = (Button) findViewById(R.id.btn_front_service);
        customViewBtn = (Button) findViewById(R.id.btn_custom_view);
        largeImageBtn = (Button) findViewById(R.id.btn_large_image);
        serviceBtn.setOnClickListener(this);
        broadcastBtn.setOnClickListener(this);
        frontServiceBtn.setOnClickListener(this);
        customViewBtn.setOnClickListener(this);
        largeImageBtn.setOnClickListener(this);
        //注册setOnTouchListener返回ture时，不调用onTouchEvent
        customViewBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "爱情手枪", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_service:  //服务
                Intent intent1 = new Intent(this,ServiceActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_broadcast:  //广播
                Intent intent2 = new Intent(this,BroadcastActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_front_service:  //前台服务
                Intent intent3 = new Intent(this,FrontActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_custom_view:  //自定义View
                Intent intent4 = new Intent(this,CustomViewActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_large_image:
                Intent intent5 = new Intent(this,LargeImageViewActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
