package com.videotracking.app;

import android.app.Activity;
import android.app.Application;

import com.videotracking.BuildConfig;
import com.videotracking.di.Injector;

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
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();

        initLogging();
        initDependencyInjection();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


    private void initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initDependencyInjection() {
        Injector.init(this);
        Injector.getApplicationComponent().inject(this);
    }
}
