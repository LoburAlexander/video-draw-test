package com.videotracking.presentation.view.videotracking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.videotracking.R;
import com.videotracking.databinding.ActivityVideoTrackingBinding;
import com.videotracking.presentation.view.base.BaseActivity;
import com.videotracking.presentation.viewmodel.videotracking.VideoTrackingViewModel;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingActivity extends BaseActivity<VideoTrackingViewModel, ActivityVideoTrackingBinding> {
    private static final String BUNDLE_IS_FULLSCREEN = "isFullscreen";

    private boolean mIsFullscreen = true;


    // ---------------------------------------------
    //  Overridden methods
    // ---------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreState(savedInstanceState);

        initBinding();
        initVM();

        setFullscreen(mIsFullscreen);
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState(outState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_video_tracking;
    }


    // ---------------------------------------------
    //  Init methods
    // ---------------------------------------------

    private void initBinding() {
        // Disable video player click handling to be able to get click events
        for(int i = 0; i < mBinding.vVideoPlayer.getChildCount(); i++) {
            mBinding.vVideoPlayer.getChildAt(i).setClickable(false);
            mBinding.vVideoPlayer.getChildAt(i).setFocusable(false);
        }

        mBinding.setOnContainerClick(mOnContainerClick);
    }

    private void initVM() {
        mViewModel.setViewCallbacks(mViewCallbacks);
        mViewModel.init();
    }


    // ---------------------------------------------
    //  Instance state methods
    // ---------------------------------------------

    private void saveState(@NonNull Bundle outState) {
        outState.putBoolean(BUNDLE_IS_FULLSCREEN, mIsFullscreen);
    }

    private void restoreState(@Nullable Bundle savedState) {
        mIsFullscreen = savedState == null || savedState.getBoolean(BUNDLE_IS_FULLSCREEN);
    }


    // ---------------------------------------------
    //  Action methods
    // ---------------------------------------------

    private void toggleFullscreen() {
        mIsFullscreen = !mIsFullscreen;
        setFullscreen(mIsFullscreen);
    }

    private void setFullscreen(boolean isFullscreen) {
        if (getSupportActionBar() != null) {
            if (isFullscreen) {
                getSupportActionBar().hide();
            } else {
                getSupportActionBar().show();
            }
        }

        // TODO: 1/12/18 Let the player handle it's state himself
        if(isFullscreen) {
            mBinding.vVideoPlayer.hideControls();
        } else {
            mBinding.vVideoPlayer.showControls();
        }
    }


    // ---------------------------------------------
    //  View callbacks
    // ---------------------------------------------

    private VideoTrackingViewModel.ViewCallbacks mViewCallbacks = new VideoTrackingViewModel.ViewCallbacks() {
        @Override
        public void showMessage(@NonNull String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(@NonNull Throwable error) {
            Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
    };


    // ---------------------------------------------
    //  Other callbacks
    // ---------------------------------------------

    private View.OnClickListener mOnContainerClick = view -> {
        toggleFullscreen();
    };
}
