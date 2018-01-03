package com.zhouxiaofeng.demo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

/**
 * Created by xiaof on 2018/1/3.
 */

public class FrontService extends Service{

    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Toast.makeText(this, "FrontService:onCreate()", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "FrontService:onStartCommand()", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "FrontService:onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        stopForeground(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "FrontService:onBind()", Toast.LENGTH_SHORT).show();
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "FrontService:onUnbind()", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {
        private Notification notification;
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void defaultFront(){
            Notification.Builder builder = new Notification.Builder(FrontService.this.getApplicationContext()); //获取一个Notification构造器
            Intent nfIntent = new Intent(FrontService.this, MainActivity.class);
            builder.setContentIntent(PendingIntent.getActivity(FrontService.this, 0, nfIntent, 0))  //设置PendingIntent
                    .setLargeIcon(BitmapFactory.decodeResource(FrontService.this.getResources(), R.mipmap.block))
                    .setContentTitle("下拉列表中的Title")
                    .setSmallIcon(R.mipmap.time)
                    .setContentText("要显示的内容")
                    .setWhen(System.currentTimeMillis());
            notification = builder.build(); // 获取构建好的Notification
            notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音
            startForeground(10,notification);
        }
        public void customFront(){

        }

        public void stopFront(){
            stopForeground(true);
        }
    }
}
