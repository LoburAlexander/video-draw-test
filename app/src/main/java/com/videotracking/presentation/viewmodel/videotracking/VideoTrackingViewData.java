package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.videotracking.platform.binding.utils.ObservableUtils;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewData extends SimpleViewData {
    public ObservableField<String> videoUrl;
    public ObservableInt trackerVisibility;

    @Inject
    public VideoTrackingViewData() {
        videoUrl = new ObservableField<>((String) null);
        trackerVisibility = new ObservableInt(View.GONE);
    }


    @Override
    public void destroy() {
        super.destroy();
        videoUrl.set(null);
        trackerVisibility.set(View.GONE);
    }


    public String getVideoUrlValue() {
        return ObservableUtils.getValue(videoUrl);
    }

    public int getTrackerVisibilityValue() {
        return ObservableUtils.getValue(trackerVisibility);
    }


    public void setVideoUrlValue(String videoUrl) {
        ObservableUtils.setValue(this.videoUrl, videoUrl);
    }

    public void setTrackerVisibilityValue(int trackerVisibility) {
        ObservableUtils.setValue(this.trackerVisibility, trackerVisibility);
    }
}
