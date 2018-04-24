package com.example.ccruzado.formulario.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by ccruzado on 14/03/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setupToolbar();
        ButterKnife.bind(this);
        init();

    }

    public void setupToolbar() {
/*        getActionBar().hide();
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }*/
    }


    @Nullable public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract int getLayoutId();

    protected abstract void init();


}