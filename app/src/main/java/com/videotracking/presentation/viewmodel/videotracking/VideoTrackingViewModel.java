package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.afollestad.easyvideoplayer.EasyVideoProgressCallback;
import com.videotracking.databinding.ActivityVideoTrackingBinding;
import com.videotracking.platform.assets.AssetsUtils;
import com.videotracking.platform.video.view.ObjectTrackerLayout;
import com.videotracking.platform.video.callbacks.BaseEasyVideoCallback;
import com.videotracking.presentation.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

import dagger.MembersInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewModel extends BaseViewModel<VideoTrackingViewData> {

    @Nullable
    private ViewCallbacks mViewCallbacks;


    @Inject
    public VideoTrackingViewModel(@NonNull VideoTrackingViewData viewData,
                                  @NonNull MembersInjector<VideoTrackingViewModel> injector) {
        super(viewData, injector);
    }


    // ---------------------------------------------
    //  Overridden methods
    // ---------------------------------------------

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityVideoTrackingBinding binding = (ActivityVideoTrackingBinding) viewDataBinding;

        binding.setData(mViewData);
        binding.setVideoCallback(mVideoPlayerCallback);
        binding.setVideoProgressCallback(mVideoProgressCallback);
        binding.setOnTrackerAreaClick(mOnTrackerAreaClick);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setViewCallbacks(null);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


    // ---------------------------------------------
    //  Init / release methods
    // ---------------------------------------------

    public void init() {
        // Load video from assets
        String videoPath = AssetsUtils.getAssetsUri("sample_video.mp4").toString();
        mViewData.setVideoUrlValue(videoPath);
    }


    // ---------------------------------------------
    //  Public methods
    // ---------------------------------------------

    public void setViewCallbacks(@Nullable ViewCallbacks callbacks) {
        this.mViewCallbacks = callbacks;
    }


    // ---------------------------------------------
    //  Private event methods
    // ---------------------------------------------

    private void onTrackerAreaClick() {
        if (mViewCallbacks != null) {
            mViewCallbacks.showMessage("Object touched");
        }
    }


    // ---------------------------------------------
    //  Private action methods
    // ---------------------------------------------


    // ---------------------------------------------
    //  Video player callbacks
    // ---------------------------------------------

    private EasyVideoProgressCallback mVideoProgressCallback = new EasyVideoProgressCallback() {
        @Override
        public void onVideoProgressUpdate(int position, int duration) {
            float normalisedPosition = ((float) position) / duration;
            float lowBoundary = 1.f / 3;
            float highBoundary = 2.f / 3;

            if (normalisedPosition < lowBoundary || normalisedPosition > highBoundary) {
                mViewData.setTrackerVisibilityValue(View.GONE);
            } else {
                mViewData.setTrackerVisibilityValue(View.VISIBLE);
            }

//            Timber.d("Video progress. Position: " + position + ", duration: " + duration + ", percent: " + normalisedPosition);
        }
    };

    private EasyVideoCallback mVideoPlayerCallback = new BaseEasyVideoCallback() {
        @Override
        public void onError(EasyVideoPlayer player, Exception e) {
            e.printStackTrace();
            if (mViewCallbacks != null) {
                mViewCallbacks.onError(e);
            }
        }
    };


    // ---------------------------------------------
    //  Other callbacks
    // ---------------------------------------------

    private ObjectTrackerLayout.OnTrackerAreaClickListener mOnTrackerAreaClick = trackerView -> {
        onTrackerAreaClick();
    };


    // ---------------------------------------------
    //  View callbacks
    // ---------------------------------------------

    public interface ViewCallbacks {
        void showMessage(@NonNull String message);
        void onError(@NonNull Throwable error);
    }
}
