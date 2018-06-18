package com.videotracking.models.mappers;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.videotracking.models.videotracking.domain.ObjectCapture;
import com.videotracking.models.videotracking.domain.ObjectCaptureSegment;
import com.videotracking.models.videotracking.remote.ObjectCaptureRemote;
import com.videotracking.models.videotracking.remote.ObjectCaptureSegmentRemote;
import com.videotracking.models.videotracking.remote.VideoTrackingMarkupRemote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
@Reusable
public class VideoTrackingMapper {
    // TODO: 6/18/18 Refactor

    @NonNull
    private final Gson mGson;

    @Inject
    public VideoTrackingMapper(@NonNull Gson gson) {
        this.mGson = gson;
    }


    @NonNull
    public List<ObjectCaptureSegment> mapVideoTrackingMarkup(@NonNull String serializedMarkup) {
        List<ObjectCaptureSegment> result = new ArrayList<>();

        VideoTrackingMarkupRemote markupRemote = mGson.fromJson(serializedMarkup, VideoTrackingMarkupRemote.class);

        for (ObjectCaptureSegmentRemote segmentRemote : markupRemote.segments) {
            ObjectCaptureSegment segment = mapObjectCaptureSegment(segmentRemote);
            result.add(segment);
        }

        return result;
    }

    @NonNull
    public ObjectCaptureSegment mapObjectCaptureSegment(@NonNull ObjectCaptureSegmentRemote remote) {
        ObjectCapture capture = mapObjectCapture(remote.objectCapture);
        ObjectCaptureSegment result = new ObjectCaptureSegment(capture, remote.low, remote.high);
        return result;
    }

    @NonNull
    public ObjectCapture mapObjectCapture(@NonNull ObjectCaptureRemote remote) {
        ObjectCapture result = new ObjectCapture(remote.x, remote.y, remote.width, remote.height);
        return result;
    }
}
