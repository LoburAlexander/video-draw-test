package com.videotracking.platform.video.view;

import android.support.annotation.NonNull;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class TrackerAreaInfo {
    public float x;
    public float y;
    public float width;
    public float height;

    public TrackerAreaInfo() {}

    public TrackerAreaInfo(float x, float y, float width, float height) {
        init(x, y, width, height);
    }

    public void init(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void init(@NonNull TrackerAreaInfo info) {
        init(info.x, info.y, info.width, info.height);
    }
}
