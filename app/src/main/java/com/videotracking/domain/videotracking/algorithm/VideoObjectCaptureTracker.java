package com.videotracking.domain.videotracking.algorithm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.videotracking.domain.utils.ArrayUtils;
import com.videotracking.models.videotracking.domain.ObjectCapture;
import com.videotracking.models.videotracking.domain.ObjectCaptureSegment;
import com.videotracking.models.videotracking.domain.VideoTrackingMarkup;

import java.util.Arrays;

import javax.inject.Inject;

/**
 * Class, that processes video markup and searches for objects captures at specified video position.
 *
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class VideoObjectCaptureTracker {
    private static final int NO_CAPTURE = -1;

    private VideoTrackingMarkup mVideoMarkup;

    private float[] mSegmentBounds;
    private ObjectCapture[] mCaptures;

    private int mPrevSegmentIndex = NO_CAPTURE;

    private boolean mIsInitialised = false;


    @Inject
    public VideoObjectCaptureTracker() {}


    public void init(@NonNull VideoTrackingMarkup videoMarkup) {
        mVideoMarkup = videoMarkup;

        ObjectCaptureSegment[] segments = videoMarkup.getCaptureSegments();

        if (segments == null) {
            mSegmentBounds = new float[0];
            mCaptures = new ObjectCapture[0];
        } else {
            mSegmentBounds = new float[segments.length + 1];
            mCaptures = new ObjectCapture[segments.length];

            int segmentIndex = 0;
            mSegmentBounds[segmentIndex++] = 0.f;
            for (ObjectCaptureSegment segment : segments) {
                float highBound = Math.max(0.f, Math.min(1.f, segment.high));
                mCaptures[segmentIndex - 1] = segment.capture;
                mSegmentBounds[segmentIndex++] = highBound;
            }
        }

        mIsInitialised = true;
    }

    public void release() {
        mVideoMarkup = null;
        mSegmentBounds = null;
        mCaptures = null;

        mPrevSegmentIndex = NO_CAPTURE;

        mIsInitialised = false;
    }


    /**
     * Finds object capture at specified video position.
     *
     * @param position Normalised video position [0,1].
     * @return Object capture or null if there is no object at specified position.
     */
    @Nullable
    public ObjectCapture findCaptureAtPosition(float position) {
        ensureInitialised();

        int segmentIndex;
        boolean usePrevCapture = false;

        // Check if position is still in the same segment, hence capture is the same too
        if (mPrevSegmentIndex != NO_CAPTURE) {
            if (ArrayUtils.containsIndex(mSegmentBounds, mPrevSegmentIndex) &&
                    ArrayUtils.containsIndex(mSegmentBounds, mPrevSegmentIndex + 1)) {
                float prevSegmentLow = mSegmentBounds[mPrevSegmentIndex];
                float prevSegmentHigh = mSegmentBounds[mPrevSegmentIndex + 1];

                if (prevSegmentLow <= position && position < prevSegmentHigh) {
                    usePrevCapture = true;
                }
            }
        }

        if (!usePrevCapture) {
            // Can't use previous capture, need to search
            segmentIndex = Arrays.binarySearch(mSegmentBounds, position);
            if (segmentIndex >= 0) {
                // Positive index, hence element was found among array items (position is at the edge of some segment)
                if (segmentIndex == mSegmentBounds.length - 1) {
                    segmentIndex--;
                }
            } else {
                // Negative index, hence element wasn't found among array items (position within some segment)
                segmentIndex = -segmentIndex - 2;
            }

            mPrevSegmentIndex = segmentIndex;
        } else {
            segmentIndex = mPrevSegmentIndex;
        }

        // Ensure found index belongs to captures range
        ObjectCapture result = null;
        if (ArrayUtils.containsIndex(mCaptures, segmentIndex)) {
            result = mCaptures[segmentIndex];
        }

        return result;
    }


    private void ensureInitialised() throws IllegalStateException {
        if (!mIsInitialised) {
            throw new IllegalStateException("Initialise tracker with video markup before usage.");
        }
    }
}
