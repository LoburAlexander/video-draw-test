package com.videotracking.presentation.view.videotracking;

import android.os.Bundle;

import com.videotracking.R;
import com.videotracking.databinding.ActivityVideoTrackingBinding;
import com.videotracking.presentation.view.base.BaseActivity;
import com.videotracking.presentation.viewmodel.videotracking.VideoTrackingViewModel;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingActivity extends BaseActivity<VideoTrackingViewModel, ActivityVideoTrackingBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_video_tracking;
    }

}
