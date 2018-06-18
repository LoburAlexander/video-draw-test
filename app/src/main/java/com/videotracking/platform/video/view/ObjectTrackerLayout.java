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
    private FrameLayout.LayoutParams mTrackerAreaLayoutParams = new LayoutParams(0, 0);
    @NonNull
    private TrackerAreaInfo mTrackerAreaInfo = new TrackerAreaInfo();

    private boolean mMeasureTrackerArea = false;

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

        if (mMeasureTrackerArea) {
            final int baseWidth = mBaseView.getMeasuredWidth();
            final int baseHeight = mBaseView.getMeasuredHeight();

            final int trackerWidth = (int) Math.floor(baseWidth * mTrackerAreaInfo.width);
            final int trackerHeight = (int) Math.floor(baseHeight * mTrackerAreaInfo.height);

            final int trackerX = (int) Math.floor(baseWidth * mTrackerAreaInfo.x);
            final int trackerY = (int) Math.floor(baseHeight * mTrackerAreaInfo.y);

            mTrackerAreaLayoutParams.width = trackerWidth;
            mTrackerAreaLayoutParams.height = trackerHeight;
            mTrackerAreaLayoutParams.leftMargin = trackerX;
            mTrackerAreaLayoutParams.topMargin = trackerY;

            mMeasureTrackerArea = false;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (mBaseView == null || mBaseView.getVisibility() == GONE) {
            hideTrackerArea();
        }

        if (mTrackerAreaView.getVisibility() != GONE) {
            // TODO: 6/18/18 Use view.layout() call instead of setLayoutParams
            mTrackerAreaView.setLayoutParams(mTrackerAreaLayoutParams);
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


    /**
     * Shows tracker area at specified position with specified size. All parameters must be normalised.
     */
    public void showTrackerArea(float x, float y, float width, float height) {
        mTrackerAreaInfo.init(x, y, width, height);
        mMeasureTrackerArea = true;
        showTrackerArea();
        requestLayout();
    }

    /**
     * Shows tracker area at previously set position.
     */
    public void showTrackerArea() {
        if (mBaseView != null && mBaseView.getVisibility() != GONE) {
            mTrackerAreaView.setVisibility(VISIBLE);
        }
    }

    /**
     * Hides tracker area.
     */
    public void hideTrackerArea() {
        mTrackerAreaView.setVisibility(GONE);
    }


    private final class TrackerAreaInfo {
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
    }


    public interface OnTrackerAreaClickListener {
        void onTrackerAreaClick(@NonNull View trackerArea);
    }
}
