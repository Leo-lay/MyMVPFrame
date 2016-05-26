package com.scleo.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scleo.mymvp.presenter.ActivityPresenter;

public class MainActivity extends ActivityPresenter {

    @Override
    protected Class getDeleteClasss() {
        return null;
    }

}
