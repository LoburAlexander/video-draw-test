package com.videotracking.platform.video.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.videotracking.R;

/**
 * <br/><br/>
 * Created by alex.lobur on 6/18/18.
 */
public class ObjectTrackerLayout extends FrameLayout {

    private View mBaseView;
    private View mTrackerAreaView;

    @NonNull
    FrameLayout.LayoutParams trackerAreaLayoutParams = new LayoutParams(0, 0);

    @Nullable
    private OnTrackerAreaClickListener mOnTrackerAreaClickListener;


    public ObjectTrackerLayout(@NonNull Context context) {
        super(context);
    }

    public ObjectTrackerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ObjectTrackerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        final LayoutInflater inflater = LayoutInflater.from(getContext());

        if (getChildCount() > 0) {
            mBaseView = getChildAt(0);
        }

        mTrackerAreaView = inflater.inflate(R.layout.layout_tracker_area, this, false);
        mTrackerAreaView.setVisibility(GONE);
        mTrackerAreaView.setOnClickListener(view -> {
            if (mOnTrackerAreaClickListener != null) {
                mOnTrackerAreaClickListener.onTrackerAreaClick(mTrackerAreaView);
            }
        });
        addView(mTrackerAreaView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int baseWidth = mBaseView.getMeasuredWidth();
        final int baseHeight = mBaseView.getMeasuredHeight();

        final int trackerWidth = baseWidth / 3;
        final int trackerHeight = baseHeight / 2;

        final int trackerX = (baseWidth - trackerWidth) / 2;
        final int trackerY = (baseHeight - trackerHeight) / 2;

        trackerAreaLayoutParams.width = trackerWidth;
        trackerAreaLayoutParams.height = trackerHeight;
        trackerAreaLayoutParams.leftMargin = trackerX;
        trackerAreaLayoutParams.topMargin = trackerY;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (mBaseView != null && mBaseView.getVisibility() != GONE) {
            // TODO: 6/18/18 Use view.layout() call instead of setLayoutParams
            mTrackerAreaView.setLayoutParams(trackerAreaLayoutParams);
            mTrackerAreaView.setVisibility(VISIBLE);
        } else {
            mTrackerAreaView.setVisibility(GONE);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mBaseView = null;

        mTrackerAreaView.setOnClickListener(null);
        mTrackerAreaView = null;
    }


    public void setOnTrackerAreaClickListener(@Nullable OnTrackerAreaClickListener listener) {
        this.mOnTrackerAreaClickListener = listener;
    }


    public interface OnTrackerAreaClickListener {
        void onTrackerAreaClick(@NonNull View trackerArea);
    }
}
