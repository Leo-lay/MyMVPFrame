package com.scleo.mymvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.scleo.mymvp.iview.IView;

/**
 *Activity presenter 层实现基类
 *
 * Created by Scleo on 16/5/25.
 */
public abstract class ActivityPresenter<T extends IView> extends AppCompatActivity{

    private T viewDelegate;

    //获取到代理类
    protected abstract Class<T> getDeleteClasss();

    public ActivityPresenter() {
       initViewDelegate();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate.create(getLayoutInflater(),null,savedInstanceState);
        setContentView(viewDelegate.getContainerView());//set contentview
        initToolbar();
        viewDelegate.initWidget();
    }

    //init toolbar
    protected void initToolbar() {
        Toolbar toolbar = viewDelegate.getToolbar();
        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        initViewDelegate();
    }

    //初始化视图代理
    private void initViewDelegate() {
        try {
            viewDelegate = getDeleteClasss().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(" create ViewDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(" create ViewDelegate error");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(viewDelegate.getOptionMenuId()!=0){
            getMenuInflater().inflate(viewDelegate.getOptionMenuId(),menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;//回收视图代理
    }
}

