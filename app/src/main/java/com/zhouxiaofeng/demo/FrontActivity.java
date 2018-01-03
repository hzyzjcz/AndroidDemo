package com.zhouxiaofeng.demo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by xiaof on 2018/1/3.
 */

public class FrontActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn;
    private Button stopBtn;
    private Button bindBtn;
    private Button unbindBtn;
    private Button defaultFrontBtn;
    private Button customFrontBtn;
    private Button stopFrontBtn;
    private ServiceConnection connection;
    private FrontService.MyBinder binder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);
        bindBtn = (Button) findViewById(R.id.btn_bind);
        unbindBtn = (Button) findViewById(R.id.btn_unbind);
        defaultFrontBtn = (Button) findViewById(R.id.btn_start_front_default);
        customFrontBtn = (Button) findViewById(R.id.btn_start_front_custom);
        stopFrontBtn = (Button) findViewById(R.id.btn_stop_front);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
        defaultFrontBtn.setOnClickListener(this);
        customFrontBtn.setOnClickListener(this);
        stopFrontBtn.setOnClickListener(this);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                binder = (FrontService.MyBinder)iBinder;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Toast.makeText(FrontActivity.this, "解绑了服务", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:  //开启服务
                Intent intent = new Intent(this,FrontService.class);
                startService(intent);
                break;
            case R.id.btn_stop:  //停止服务
                Intent intent1 = new Intent(this,FrontService.class);
                stopService(intent1);
                break;
            case R.id.btn_bind:  //绑定服务
                Intent intent2 = new Intent(this,FrontService.class);
                bindService(intent2,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:  //解绑服务
                unbindService(connection);
                break;
            case R.id.btn_start_front_default:  //开启默认样式前台服务
                if (null == bindBtn){
                    Toast.makeText(this, "请先绑定服务", Toast.LENGTH_SHORT).show();
                    return;
                }
                binder.defaultFront();
                break;
            case R.id.btn_start_front_custom:  //开启自定义样式前台服务
                if (null == bindBtn){
                    Toast.makeText(this, "请先绑定服务", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.btn_stop_front:  //结束前台服务
                if (null == bindBtn){
                    Toast.makeText(this, "请先绑定服务", Toast.LENGTH_SHORT).show();
                    return;
                }
                binder.stopFront();
                break;
        }
    }
}
