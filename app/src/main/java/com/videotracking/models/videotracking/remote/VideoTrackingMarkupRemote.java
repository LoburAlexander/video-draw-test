package com.videotracking.models.videotracking.remote;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class VideoTrackingMarkupRemote {
    @Nullable
    public List<ObjectCaptureSegmentRemote> segments;

    public VideoTrackingMarkupRemote(@Nullable List<ObjectCaptureSegmentRemote> segments) {
        this.segments = segments;
    }
}
