package com.videotracking.presentation.view.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.videotracking.di.app.qualifiers.ComponentRetainedInstance;

import javax.inject.Inject;

import by.mvvmwrapper.activity.BaseAppCompatActivity;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public abstract class BaseActivity<M extends BaseViewModel, B extends ViewDataBinding>
        extends BaseAppCompatActivity<M, B>
        implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    @ComponentRetainedInstance
    Lazy<M> mViewModelProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }


    @NonNull
    protected M initViewModel() {
        return mViewModelProvider.get();
    }
}

