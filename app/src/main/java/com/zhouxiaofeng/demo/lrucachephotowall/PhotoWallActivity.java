package com.zhouxiaofeng.demo.lrucachephotowall;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.GridView;

import com.zhouxiaofeng.demo.R;
import com.zhouxiaofeng.demo.base.BaseActivity;

/**
 * Created by xiaof on 2018/2/6.
 */

public class PhotoWallActivity extends BaseActivity{

    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photowall);
        mPhotoWall = (GridView) findViewById(R.id.photo_wall);
        adapter = new PhotoWallAdapter(this, 0, Images.imageThumbUrls, mPhotoWall);
        mPhotoWall.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        adapter.cancelAllTasks();
    }

}
