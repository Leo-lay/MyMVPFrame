package com.scleo.mymvp.biz;


import android.os.Handler;

/**
 * Created by Scleo on 16/5/25.
 */
public class RequestBizImp implements RequestBiz{

    @Override
    public void requestData(final int flag,final OnRequestListener onRequestListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(flag==1){
                    onRequestListener.onSuccess("{'msg':'1234567'}");
                }else{
                    onRequestListener.onFaild();
                }
            }
        },2000);
    }
}
