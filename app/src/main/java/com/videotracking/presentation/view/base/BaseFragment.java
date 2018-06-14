package com.videotracking.presentation.view.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.videotracking.di.app.qualifiers.ComponentRetainedInstance;

import javax.inject.Inject;

import by.mvvmwrapper.fragments.BaseFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public abstract class BaseFragment<M extends BaseViewModel, B extends ViewDataBinding>
        extends BaseFragmentSupport<M, B>
        implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;
    @Inject
    @ComponentRetainedInstance
    Lazy<M> mViewModelProvider;


    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }


    @NonNull
    protected M initViewModel() {
        return mViewModelProvider.get();
    }
}