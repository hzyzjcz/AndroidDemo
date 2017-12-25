package com.zhouxiaofeng.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.text.UnicodeSetSpanner;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhouxiaofeng.remoteservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bindBtn;
    private Button unBindBtn;
    private Button startBtn;
    private Button stopBtn;
    private ServiceConnection connection;
    private IMyAidlInterface binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindBtn = (Button) findViewById(R.id.btn_bind_remote);
        unBindBtn = (Button) findViewById(R.id.btn_unbind_remote_service);
        startBtn = (Button) findViewById(R.id.btn_start_service);
        stopBtn = (Button) findViewById(R.id.btn_close_service);
        bindBtn.setOnClickListener(this);
        unBindBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = IMyAidlInterface.Stub.asInterface(service);
                try {
                    int aa = binder.plus(1,2);
                    Toast.makeText(MainActivity.this, ""+aa, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, binder.toUpper("woshiwo"), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind_remote:
                Intent intent = new Intent();
                intent.setAction("com.zhouxiaofeng.remoteservice");
                intent.setPackage("com.zhouxiaofeng.remoteservice");
                bindService(intent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_remote_service:
                unbindService(connection);
                break;
            case R.id.btn_start_service:
                Intent intent1 = new Intent();
                intent1.setPackage("com.zhouxiaofeng.remoteservice");
                intent1.setAction("com.zhouxiaofeng.remoteservice");
                startService(intent1);
                break;
            case R.id.btn_close_service:
                Intent intent2 = new Intent();
                intent2.setAction("com.zhouxiaofeng.remoteservice");
                intent2.setPackage("com.zhouxiaofeng.remoteservice");
                stopService(intent2);
                break;
        }
    }
}
