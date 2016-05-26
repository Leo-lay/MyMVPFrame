package com.scleo.mymvp.biz;

/**
 * Created by Scleo on 16/5/25.
 */
public interface OnRequestListener<T> {

    void onSuccess(String json);

    void onFaild();
}
