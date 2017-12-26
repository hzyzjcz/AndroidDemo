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
        Log.d("顺序","TestService:onCreate");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.d("顺序","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("顺序","onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("顺序","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("顺序","onDestroy");
    }

    class MyBinder extends Binder{
        public void startDownLoad(){
            Toast.makeText(TestService.this, "开始下载", Toast.LENGTH_SHORT).show();
        }
    }

}
