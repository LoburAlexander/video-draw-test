package com.videotracking.presentation.view.videotracking;

import android.net.Uri;
import android.os.Bundle;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
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
        mViewModel.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.vVideoPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.vVideoPlayer.pause();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_video_tracking;
    }

}
