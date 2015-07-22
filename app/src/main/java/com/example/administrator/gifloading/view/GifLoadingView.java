package com.example.administrator.gifloading.view;


import android.content.Context;
import android.os.Handler;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by Administrator on 15-7-22.
 */
public class GifLoadingView{
    private LinearLayout loadingView;
    private TextView loadingText;
    private ImageView loadingImageView;
    private int[] loadingImage;
    private int imagePosition;
    private int delayMillis = 50;
    private Handler handler;
    private boolean isShow = false;
    public  GifLoadingView(ViewGroup rootView,Context context,int[] loadingImage){
        this.loadingImage = loadingImage;
        loadingView = new LinearLayout(context);
        loadingView.setVisibility(View.GONE);
        loadingView.setOrientation(LinearLayout.VERTICAL);
        loadingView.setGravity(Gravity.CENTER);
        loadingView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.addView(loadingView);
        loadingText = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingText.setLayoutParams(layoutParams);
        loadingText.setText("正在为您加载....");
        loadingImageView = new ImageView(context);
        loadingImageView.setLayoutParams(layoutParams);
        if(this.loadingImage!=null&&loadingImage.length>0){
            imagePosition = 0;
            loadingImageView.setImageResource(loadingImage[imagePosition]);
        }
        loadingView.addView(loadingImageView);
        loadingView.addView(loadingText);
        handler = new Handler();
    }
    public void show(){
        isShow = true;
        loadingView.setVisibility(View.VISIBLE);
        handler.post(new Runnable() {
            @Override
            public void run() {
                imagePosition = imagePosition +1;
                if(imagePosition==loadingImage.length-1){
                    imagePosition = 0;
                }
                loadingImageView.setImageResource(loadingImage[imagePosition]);
                if(isShow){
                    handler.postDelayed(this,delayMillis);
                }
            }
        });
    }
    public void dismiss(){
        isShow = false;
        loadingView.setVisibility(View.GONE);
    }
    public boolean isShowIng(){
        return isShow;
    }
    public void setLoadingText(String text){
        loadingText.setText(text);
    }
    public void setDelayMillis(int delayMillis){
        this.delayMillis = delayMillis;
    }
    public void setCanceledOnTouchOutside(boolean isCancel){
        if(isCancel){
            loadingView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

}
