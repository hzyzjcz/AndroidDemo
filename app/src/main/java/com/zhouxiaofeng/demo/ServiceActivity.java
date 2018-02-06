package com.zhouxiaofeng.demo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.zhouxiaofeng.demo.base.BaseActivity;

/**
 * Created by xiaof on 2017/12/26.
 */

public class ServiceActivity extends BaseActivity implements View.OnClickListener {

    private Button btnStart;
    private Button btnStop;
    private Button btnBind;
    private Button btnUnBind;
    private ServiceConnection connection;
    private TestService.MyBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnStart = (Button) findViewById(R.id.btn_start_s);
        btnStop = (Button) findViewById(R.id.btn_stop_s);
        btnBind = (Button) findViewById(R.id.btn_bind_s);
        btnUnBind = (Button) findViewById(R.id.btn_unbind_s);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (TestService.MyBinder)service;
                binder.startDownLoad();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_s:
                Intent intent = new Intent(this,TestService.class);
                startService(intent);
                break;
            case R.id.btn_stop_s:
                Intent intent1 = new Intent(this,TestService.class);
                stopService(intent1);
                break;
            case R.id.btn_bind_s:
                Intent intent2 = new Intent(this,TestService.class);
                bindService(intent2,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_s:
                unbindService(connection);
                break;
        }
    }

}
