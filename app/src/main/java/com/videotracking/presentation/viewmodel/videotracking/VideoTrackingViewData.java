package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.Nullable;
import android.view.View;

import com.videotracking.platform.binding.utils.ObservableUtils;
import com.videotracking.platform.video.view.TrackerAreaInfo;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewData extends SimpleViewData {
    public ObservableField<String> videoUrl;
    public ObservableInt trackerVisibility;
    public ObservableField<TrackerAreaInfo> trackerAreaInfo;

    @Inject
    public VideoTrackingViewData() {
        videoUrl = new ObservableField<>((String) null);
        trackerVisibility = new ObservableInt(View.GONE);
        trackerAreaInfo = new ObservableField<>((TrackerAreaInfo) null);
    }


    @Override
    public void destroy() {
        super.destroy();
        setVideoUrlValue(null);
        setTrackerVisibilityValue(View.GONE);
        setTrackerAreaInfoValue(null);
    }


    @Nullable
    public String getVideoUrlValue() {
        return ObservableUtils.getValue(videoUrl);
    }

    public int getTrackerVisibilityValue() {
        return ObservableUtils.getValue(trackerVisibility);
    }

    @Nullable
    public TrackerAreaInfo getTrackerAreaInfoValue() {
        return ObservableUtils.getValue(trackerAreaInfo);
    }


    public void setVideoUrlValue(@Nullable String videoUrl) {
        ObservableUtils.setValue(this.videoUrl, videoUrl);
    }

    public void setTrackerVisibilityValue(int trackerVisibility) {
        ObservableUtils.setValue(this.trackerVisibility, trackerVisibility);
    }

    public void setTrackerAreaInfoValue(@Nullable TrackerAreaInfo trackerAreaInfo) {
        ObservableUtils.setValue(this.trackerAreaInfo, trackerAreaInfo);
    }
}
