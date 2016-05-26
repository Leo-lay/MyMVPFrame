package com.scleo.mymvp.iview;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 视图基类
 * Created by Scleo on 16/5/25.
 */
public interface IView {

    void showLoading();

    void hideLoading();

    int getOptionMenuId();

    void create(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState);

    Toolbar getToolbar();

    View getContainerView();

    void initWidget();

}
