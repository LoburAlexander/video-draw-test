package com.videotracking.presentation.viewmodel.videotracking;

import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.afollestad.easyvideoplayer.EasyVideoProgressCallback;
import com.videotracking.databinding.ActivityVideoTrackingBinding;
import com.videotracking.presentation.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

import dagger.MembersInjector;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
public class VideoTrackingViewModel extends BaseViewModel<VideoTrackingViewData> {

    @Inject
    public VideoTrackingViewModel(@NonNull VideoTrackingViewData viewData,
                                  @NonNull MembersInjector<VideoTrackingViewModel> injector) {
        super(viewData, injector);
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityVideoTrackingBinding binding = (ActivityVideoTrackingBinding) viewDataBinding;
        binding.setData(mViewData);
        binding.setVideoCallback(mVideoPlayerCallback);
        binding.setVideoProgressCallback(mVideoProgressCallback);
    }


    public void init() {
        mViewData.setVideoUrlValue("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
    }


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

            Timber.d("Video progress. Position: " + position + ", duration: " + duration + ", percent: " + normalisedPosition);
        }
    };

    private EasyVideoCallback mVideoPlayerCallback = new EasyVideoCallback() {
        @Override
        public void onStarted(EasyVideoPlayer player) {

        }

        @Override
        public void onPaused(EasyVideoPlayer player) {

        }

        @Override
        public void onPreparing(EasyVideoPlayer player) {

        }

        @Override
        public void onPrepared(EasyVideoPlayer player) {
        }

        @Override
        public void onBuffering(int percent) {

        }

        @Override
        public void onError(EasyVideoPlayer player, Exception e) {
            e.printStackTrace();
        }

        @Override
        public void onCompletion(EasyVideoPlayer player) {

        }

        @Override
        public void onRetry(EasyVideoPlayer player, Uri source) {

        }

        @Override
        public void onSubmit(EasyVideoPlayer player, Uri source) {

        }
    };
}
