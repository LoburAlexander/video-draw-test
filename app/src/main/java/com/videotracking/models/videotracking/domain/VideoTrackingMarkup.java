package com.videotracking.models.videotracking.domain;

import android.support.annotation.NonNull;

import com.videotracking.models.utils.EntityUtils;

import java.util.List;

/**
 * Markup for a video, containing object captures for different video segments.
 *
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class VideoTrackingMarkup {
    @NonNull
    private final ObjectCaptureSegment[] mCaptureSegments;


    public VideoTrackingMarkup(@NonNull ObjectCaptureSegment[] captureSegments) {
        this.mCaptureSegments = captureSegments;
    }

    public VideoTrackingMarkup(@NonNull List<ObjectCaptureSegment> captures) {
        this(captures.toArray(new ObjectCaptureSegment[]{}));
    }


    @NonNull
    public ObjectCaptureSegment[] getCaptureSegments() {
        return mCaptureSegments;
    }

    public int getSegmentsCount() {
        return mCaptureSegments.length;
    }


    @Override
    public int hashCode() {
        int hash = 13;
        int prime = 31;

        hash = prime * hash + EntityUtils.hashCode(mCaptureSegments);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || (obj.getClass() != this.getClass()))
            return false;

        VideoTrackingMarkup other = (VideoTrackingMarkup) obj;
        if (!EntityUtils.areEqual(mCaptureSegments, other.mCaptureSegments))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                EntityUtils.toStringField("captureSegments", mCaptureSegments, true) +
                "}";
    }
}
