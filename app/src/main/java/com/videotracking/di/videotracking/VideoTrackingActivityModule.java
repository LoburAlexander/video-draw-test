package com.videotracking.di.videotracking;

import android.support.annotation.NonNull;

import com.videotracking.di.app.qualifiers.ComponentRetainedInstance;
import com.videotracking.di.utils.ViewModelDiUtils;
import com.videotracking.presentation.view.videotracking.VideoTrackingActivity;
import com.videotracking.presentation.viewmodel.videotracking.VideoTrackingViewModel;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Module
public abstract class VideoTrackingActivityModule {

    @Provides
    @ActivityScope
    @ComponentRetainedInstance
    static VideoTrackingViewModel provideViewModel(@NonNull VideoTrackingActivity activity,
                                                   @NonNull Provider<VideoTrackingViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, VideoTrackingViewModel.class, viewModelProvider);
    }

}
