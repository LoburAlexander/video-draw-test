package com.videotracking.platform.binding;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

import com.afollestad.easyvideoplayer.EasyVideoPlayer;

import javax.inject.Inject;

import dagger.Reusable;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/14/18.
 */
@Reusable
public class VideoBindingAdapter {

    @Inject
    public VideoBindingAdapter() {
        Timber.d("CREATE");
    }


    @BindingAdapter({"videoUrl"})
    public void bindVideoUrl(@NonNull VideoView videoView, @Nullable String videoUrl) {
        MediaController mediacontroller = new MediaController(videoView.getContext());
        mediacontroller.setAnchorView(videoView);

        Uri uri = Uri.parse(videoUrl);
        videoView.setMediaController(mediacontroller);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    @BindingAdapter({"videoUrl"})
    public void bindVideoPlayer(@NonNull EasyVideoPlayer videoPlayer,
                                       @Nullable String videoUrl) {
        /*if(callback != null) {
            videoPlayer.setCallback(callback);
        }*/

        if (videoUrl != null) {
            Uri uri = Uri.parse(videoUrl);
            videoPlayer.setSource(uri);
        }
    }

}
