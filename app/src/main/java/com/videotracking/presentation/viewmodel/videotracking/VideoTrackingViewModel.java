package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.videotracking.databinding.ActivityVideoTrackingBinding;
import com.videotracking.presentation.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

import dagger.MembersInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewModel extends BaseViewModel<VideoTrackingViewData> {

    @Inject
    public VideoTrackingViewModel(@NonNull VideoTrackingViewData viewData,
                                  @NonNull MembersInjector<VideoTrackingViewModel> injector) {
        super(viewData, injector);
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityVideoTrackingBinding binding = (ActivityVideoTrackingBinding) viewDataBinding;
        binding.setData(mViewData);
    }

}
