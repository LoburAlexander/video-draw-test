package com.videotracking.models.videotracking.remote;

import android.support.annotation.Nullable;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class ObjectCaptureSegmentRemote {
    @Nullable
    public ObjectCaptureRemote objectCapture;
    public float low;
    public float high;

    public ObjectCaptureSegmentRemote(ObjectCaptureRemote objectCapture, float low, float high) {
        this.objectCapture = objectCapture;
        this.low = low;
        this.high = high;
    }
}
