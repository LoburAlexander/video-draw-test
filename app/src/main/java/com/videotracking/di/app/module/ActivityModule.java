package com.videotracking.di.app.module;

import com.videotracking.di.videotracking.VideoTrackingActivityModule;
import com.videotracking.presentation.view.videotracking.VideoTrackingActivity;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Module
public interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    VideoTrackingActivityModule.class
            })
    VideoTrackingActivity videoTrackingActivityInjector();

}
