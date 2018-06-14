package com.videotracking.app;

import android.app.Activity;
import android.app.Application;
import android.databinding.DataBindingUtil;

import com.videotracking.BuildConfig;
import com.videotracking.di.Injector;
import com.videotracking.platform.binding.component.BindingComponentBuilder;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class App extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;
    @Inject
    BindingComponentBuilder mBindingComponentBuilder;


    @Override
    public void onCreate() {
        super.onCreate();

        initLogging();
        initDependencyInjection();
        initDataBinding();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidInjector;
    }


    private void initDependencyInjection() {
        Injector.init(this);
        Injector.getApplicationComponent().inject(this);
    }

    private void initDataBinding() {
        DataBindingUtil.setDefaultComponent(mBindingComponentBuilder.build());
    }

    private void initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
