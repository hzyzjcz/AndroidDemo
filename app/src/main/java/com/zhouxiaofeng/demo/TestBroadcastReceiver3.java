package com.zhouxiaofeng.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by xiaof on 2017/12/26.
 */

public class TestBroadcastReceiver3 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultData();  //读取初始信息
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        setResultData("这是修改后的数据");
    }
}
