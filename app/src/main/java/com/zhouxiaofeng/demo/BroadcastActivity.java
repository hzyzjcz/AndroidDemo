package com.zhouxiaofeng.demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by xiaof on 2017/12/26.
 */

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "com.zhouxiaofeng.demo.broadcastreceiver";

    private Button broadBtn;
    private Button orderBroadBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        broadBtn = (Button) findViewById(R.id.btn_send_broadcast);
        orderBroadBtn = (Button) findViewById(R.id.btn_send_order_broadcast);
        broadBtn.setOnClickListener(this);
        orderBroadBtn.setOnClickListener(this);
        //动态注册广播
        TestBroadcastReceiver2 receiver2 = new TestBroadcastReceiver2();
        TestBroadcastReceiver3 receiver3 = new TestBroadcastReceiver3();
        IntentFilter filter2 = new IntentFilter(TAG);
        IntentFilter filter3 = new IntentFilter(TAG);
        filter2.setPriority(9);
        filter3.setPriority(8);
        // 若是项目中静态注册和动态注册的广播优先级相同的话，动态注册广播优先级
        // 大于静态注册广播优先级。静态注册、动态注册广播先注册的广播优先级高
        registerReceiver(receiver2,filter2);
        registerReceiver(receiver3,filter3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send_broadcast:  //发送无序广播
                Intent intent = new Intent();
                intent.setAction(TAG);
                sendBroadcast(intent);
                break;
            case R.id.btn_send_order_broadcast:  //发送有序广播
                Intent intent1 = new Intent();
                intent1.setAction(TAG);
                break;
        }
    }
}
