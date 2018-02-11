package com.zhouxiaofeng.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.zhouxiaofeng.demo.base.BaseActivity;

import java.io.InputStream;

/**
 * Created by Administrator on 2018/1/11.
 */

public class LargeImageViewActivity extends BaseActivity{

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
            BitmapFactory.Options options1 = new BitmapFactory.Options();
            options1.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect(width / 2 - 100, height / 2 - 100, width / 2 + 100, height / 2 + 100), options);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
