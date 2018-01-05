package com.zhouxiaofeng.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xiaof on 2017/12/26.
 */

public class TestBroadcastReceiver1 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultData();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        abortBroadcast();  //禁止向下传递广播
    }
}
