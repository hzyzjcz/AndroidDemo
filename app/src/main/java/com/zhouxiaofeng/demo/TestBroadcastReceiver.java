package com.zhouxiaofeng.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xiaof on 2017/12/26.
 */

public class TestBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到了广播", Toast.LENGTH_SHORT).show();
    }
}