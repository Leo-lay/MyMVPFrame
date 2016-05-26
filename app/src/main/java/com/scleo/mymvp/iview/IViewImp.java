package com.scleo.mymvp.iview;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scleo.mymvp.R;

/**
 * 视图实现类
 * Created by Scleo on 16/5/25.
 */
public abstract class IViewImp implements IView{

    private final SparseArray<View> mViewContainer = new SparseArray<View>();

    private View mView;

    public abstract int getLayoutId();

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        mView = inflater.inflate(getLayoutId(),container,false);
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public View getContainerView() {
        return mView;
    }

    @Override
    public void initWidget() {

    }

    /**
     * 绑定控件
     * @param id
     * @return
     */
    public View  bindView(int id){
        View view = mViewContainer.get(id);
        if(view ==null){
            view = mView.findViewById(id);
            mViewContainer.put(id,view);
        }
        return view;
    }

    /**
     * 获取控件
     * @param id
     * @return
     */
    public View get(int id){
        return  bindView(id);
    }

    /**
     * 设置点击事件
     * @param onClickListener
     * @param ids
     */
    public void setOnClickListener(View.OnClickListener onClickListener,int... ids){
        if(ids==null){
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(onClickListener);
        }
    }


    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
