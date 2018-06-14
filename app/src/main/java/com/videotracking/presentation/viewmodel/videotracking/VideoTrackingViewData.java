package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewData extends SimpleViewData {
    public ObservableField<String> videoUrl;

    @Inject
    public VideoTrackingViewData() {
        videoUrl = new ObservableField<>((String) null);
    }


    @Override
    public void destroy() {
        super.destroy();
        videoUrl.set(null);
    }


    public String getVideoUrlValue() {
        return videoUrl != null ? videoUrl.get() : null;
    }

    public void setVideoUrlValue(String videoUrl) {
        if (this.videoUrl != null) {
            this.videoUrl.set(videoUrl);
        }
    }
}
