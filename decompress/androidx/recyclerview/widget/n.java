// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.view.View;
import android.content.Context;
import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;

public class n extends y
{
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;
    protected PointF mTargetVector;
    
    public n(final Context context) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }
    
    private int clampApplyScroll(final int n, int n2) {
        n2 = n - n2;
        if (n * n2 <= 0) {
            return 0;
        }
        return n2;
    }
    
    private float getSpeedPerPixel() {
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = this.calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return this.mMillisPerPixel;
    }
    
    public int calculateDtToFit(int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == -1) {
            return n3 - n;
        }
        if (n5 != 0) {
            if (n5 == 1) {
                return n4 - n2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        else {
            n = n3 - n;
            if (n > 0) {
                return n;
            }
            n = n4 - n2;
            if (n < 0) {
                return n;
            }
            return 0;
        }
    }
    
    public int calculateDxToMakeVisible(final View view, final int n) {
        final o layoutManager = ((RecyclerView.y)this).getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            final p p2 = (p)view.getLayoutParams();
            return this.calculateDtToFit(layoutManager.getDecoratedLeft(view) - p2.leftMargin, layoutManager.getDecoratedRight(view) + p2.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), n);
        }
        return 0;
    }
    
    public int calculateDyToMakeVisible(final View view, final int n) {
        final o layoutManager = ((RecyclerView.y)this).getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            final p p2 = (p)view.getLayoutParams();
            return this.calculateDtToFit(layoutManager.getDecoratedTop(view) - p2.topMargin, layoutManager.getDecoratedBottom(view) + p2.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), n);
        }
        return 0;
    }
    
    protected float calculateSpeedPerPixel(final DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }
    
    protected int calculateTimeForDeceleration(final int n) {
        return (int)Math.ceil(this.calculateTimeForScrolling(n) / 0.3356);
    }
    
    protected int calculateTimeForScrolling(final int n) {
        return (int)Math.ceil(Math.abs(n) * this.getSpeedPerPixel());
    }
    
    protected int getHorizontalSnapPreference() {
        final PointF mTargetVector = this.mTargetVector;
        if (mTargetVector != null) {
            final float x = mTargetVector.x;
            if (x != 0.0f) {
                if (x > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }
    
    protected int getVerticalSnapPreference() {
        final PointF mTargetVector = this.mTargetVector;
        if (mTargetVector != null) {
            final float y = mTargetVector.y;
            if (y != 0.0f) {
                if (y > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }
    
    @Override
    protected void onSeekTargetStep(int clampApplyScroll, final int n, final z z, final a a) {
        if (((RecyclerView.y)this).getChildCount() == 0) {
            ((RecyclerView.y)this).stop();
            return;
        }
        this.mInterimTargetDx = this.clampApplyScroll(this.mInterimTargetDx, clampApplyScroll);
        clampApplyScroll = this.clampApplyScroll(this.mInterimTargetDy, n);
        this.mInterimTargetDy = clampApplyScroll;
        if (this.mInterimTargetDx == 0 && clampApplyScroll == 0) {
            this.updateActionForInterimTarget(a);
        }
    }
    
    @Override
    protected void onStart() {
    }
    
    @Override
    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }
    
    @Override
    protected void onTargetFound(final View view, final z z, final a a) {
        final int calculateDxToMakeVisible = this.calculateDxToMakeVisible(view, this.getHorizontalSnapPreference());
        final int calculateDyToMakeVisible = this.calculateDyToMakeVisible(view, this.getVerticalSnapPreference());
        final int calculateTimeForDeceleration = this.calculateTimeForDeceleration((int)Math.sqrt(calculateDxToMakeVisible * calculateDxToMakeVisible + calculateDyToMakeVisible * calculateDyToMakeVisible));
        if (calculateTimeForDeceleration > 0) {
            a.d(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, (Interpolator)this.mDecelerateInterpolator);
        }
    }
    
    protected void updateActionForInterimTarget(final a a) {
        final PointF computeScrollVectorForPosition = ((RecyclerView.y)this).computeScrollVectorForPosition(((RecyclerView.y)this).getTargetPosition());
        if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
            ((RecyclerView.y)this).normalize(computeScrollVectorForPosition);
            this.mTargetVector = computeScrollVectorForPosition;
            this.mInterimTargetDx = (int)(computeScrollVectorForPosition.x * 10000.0f);
            this.mInterimTargetDy = (int)(computeScrollVectorForPosition.y * 10000.0f);
            a.d((int)(this.mInterimTargetDx * 1.2f), (int)(this.mInterimTargetDy * 1.2f), (int)(this.calculateTimeForScrolling(10000) * 1.2f), (Interpolator)this.mLinearInterpolator);
            return;
        }
        a.b(((RecyclerView.y)this).getTargetPosition());
        ((RecyclerView.y)this).stop();
    }
}
