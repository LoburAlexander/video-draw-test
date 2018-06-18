package com.videotracking.models.videotracking.domain;

import android.support.annotation.Nullable;

import com.videotracking.models.utils.EntityUtils;

/**
 * Class, representing video segment with a captured object. There can be no objects within a segment.
 *
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class ObjectCaptureSegment {
    @Nullable
    public final ObjectCapture capture;
    public final float low;
    public final float high;


    public ObjectCaptureSegment(@Nullable ObjectCapture capture, float low, float high) {
        this.capture = capture;
        this.low = low;
        this.high = high;
    }


    @Override
    public int hashCode() {
        int hash = 13;
        int prime = 31;

        hash = prime * hash + EntityUtils.hashCode(capture);
        hash = prime * hash + EntityUtils.hashCode(low);
        hash = prime * hash + EntityUtils.hashCode(high);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || (obj.getClass() != this.getClass()))
            return false;

        ObjectCaptureSegment other = (ObjectCaptureSegment) obj;
        if (!EntityUtils.areEqual(capture, other.capture))
            return false;
        if (!EntityUtils.areEqual(low, other.low))
            return false;
        if (!EntityUtils.areEqual(high, other.high))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "{" +
                EntityUtils.toStringField("capture", capture, false) +
                EntityUtils.toStringField("low", low, false) +
                EntityUtils.toStringField("high", high, true) +
                "}";
    }
}
