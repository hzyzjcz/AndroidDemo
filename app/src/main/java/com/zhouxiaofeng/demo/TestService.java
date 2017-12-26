package com.zhouxiaofeng.demo;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TestService extends Service{
    @Nullable

    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "TestService:onCreate", Toast.LENGTH_SHORT).show();
        Log.d("顺序","TestService:onCreate");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Toast.makeText(this, "TestService:onStartCommand", Toast.LENGTH_SHORT).show();
        Log.d("顺序","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "TestService:onBind", Toast.LENGTH_SHORT).show();
        Log.d("顺序","onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "TestService:onUnbind", Toast.LENGTH_SHORT).show();
        Log.d("顺序","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("顺序","onDestroy");
        Toast.makeText(this, "TestService:onDestroy", Toast.LENGTH_SHORT).show();
    }

    class MyBinder extends Binder{
        public void startDownLoad(){
            Toast.makeText(TestService.this, "开始下载", Toast.LENGTH_SHORT).show();
        }
    }

}
