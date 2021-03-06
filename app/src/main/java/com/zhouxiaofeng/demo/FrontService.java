package com.zhouxiaofeng.demo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
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
        // 默认通知栏样式的前台服务
        public void defaultFront(){
            Intent nfIntent = new Intent(FrontService.this, MainActivity.class);
            //为了保证兼容新所以使用了NotificationCompat.Builder
            notification = new NotificationCompat.Builder(FrontService.this.getApplicationContext())
                    .setContentIntent(PendingIntent.getActivity(FrontService.this, 0, nfIntent, 0))  //设置PendingIntent
                    .setLargeIcon(BitmapFactory.decodeResource(FrontService.this.getResources(), R.mipmap.block))
                    .setContentTitle("下拉列表中的Title")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("要显示的内容")  //设置通知栏显示的内容
                    .setWhen(System.currentTimeMillis()) //设置通知栏显示的时间
                    .setDefaults(NotificationCompat.DEFAULT_ALL)  //设置手机默认的声音配置
                    .setAutoCancel(true)  //设置点击通知后自动小时小图标
                    .build();
            startForeground(10,notification);
        }
        // 自定义通知栏的前台服务
        public void customFront(){
            RemoteViews remoteViews = new RemoteViews(FrontService.this.getPackageName(), R.layout.layout_music_controller);// 获取remoteViews（参数一：包名；参数二：布局资源）
            Notification.Builder builder = new Notification.Builder(FrontService.this.getApplicationContext())
                    .setContent(remoteViews);
            builder.setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.ic_launcher);
            notification = builder.getNotification();// 获取构建好的通知--.build()最低要求在
            // API16及以上版本上使用，低版本上可以使用.getNotification()。
            notification.defaults = Notification.DEFAULT_SOUND;//设置为默认的声音
            startForeground(10, notification);// 开始前台服务
        }

        public void stopFront(){
            stopForeground(true);
        }
    }
}
