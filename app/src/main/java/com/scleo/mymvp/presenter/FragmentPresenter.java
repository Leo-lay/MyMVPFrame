package com.scleo.mymvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scleo.mymvp.iview.IView;

/**
 * 基于Fragment的视图代理基类
 * Created by Scleo on 16/5/25.
 */
public abstract class FragmentPresenter<T extends IView> extends Fragment{

    private T viewDelegate;

    //获取到代理类
    protected abstract Class<T> getDeleteClasss();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewDelegate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDelegate.create(inflater,container,savedInstanceState);
        return viewDelegate.getContainerView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDelegate.initWidget();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        initViewDelegate();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(viewDelegate.getOptionMenuId()!=0){
            inflater.inflate(viewDelegate.getOptionMenuId(),menu);
        }
    }

    //初始化视图代理
    private void initViewDelegate() {
        try {
            viewDelegate = getDeleteClasss().newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(" create ViewDelegate error");
        } catch (java.lang.InstantiationException e) {
            throw new RuntimeException(" create ViewDelegate error");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewDelegate = null;//回收视图代理
    }
}
