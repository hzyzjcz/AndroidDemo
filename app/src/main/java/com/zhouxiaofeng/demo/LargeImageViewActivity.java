package com.zhouxiaofeng.demo;

import android.app.job.JobInfo;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/1/11.
 */

public class LargeImageViewActivity extends AppCompatActivity{

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image_view);
        imageView = (ImageView) findViewById(R.id.image);
        try{
            InputStream inputStream = getAssets().open("qingming.jpg");

            //获取图片的宽和高
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream,null,options);
            int width = options.outWidth;
            int height = options.outHeight;

            BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
