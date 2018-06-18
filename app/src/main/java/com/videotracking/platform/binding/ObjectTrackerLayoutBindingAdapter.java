package com.videotracking.platform.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.videotracking.platform.video.view.ObjectTrackerLayout;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
@Reusable
public class ObjectTrackerLayoutBindingAdapter {
    @Inject
    public ObjectTrackerLayoutBindingAdapter() {}


    @BindingAdapter({"onTrackerAreaClick"})
    public void bindTrackerAreaClickListener(@NonNull ObjectTrackerLayout layout,
                                             @Nullable ObjectTrackerLayout.OnTrackerAreaClickListener listener) {
        layout.setOnTrackerAreaClickListener(listener);
    }
}
