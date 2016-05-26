package com.scleo.mymvp.iview;

import android.support.v7.widget.Toolbar;

import com.scleo.mymvp.R;

/**
 * Created by Scleo on 16/5/25.
 */
public class MainDelegate extends IViewImp{


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getOptionMenuId() {
        return R.menu.main;
    }
}
