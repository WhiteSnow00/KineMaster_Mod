// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class x extends r
{
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final t mScrollListener;
    
    public x() {
        this.mScrollListener = new t() {
            boolean a = false;
            final x b;
            
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, final int n) {
                super.onScrollStateChanged(recyclerView, n);
                if (n == 0 && this.a) {
                    this.a = false;
                    this.b.snapToTargetExistingView();
                }
            }
            
            @Override
            public void onScrolled(final RecyclerView recyclerView, final int n, final int n2) {
                if (n != 0 || n2 != 0) {
                    this.a = true;
                }
            }
        };
    }
    
    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }
    
    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener((RecyclerView.r)this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    
    private boolean snapFromFling(final o o, int targetSnapPosition, final int n) {
        if (!(o instanceof y.b)) {
            return false;
        }
        final y scroller = this.createScroller(o);
        if (scroller == null) {
            return false;
        }
        targetSnapPosition = this.findTargetSnapPosition(o, targetSnapPosition, n);
        if (targetSnapPosition == -1) {
            return false;
        }
        scroller.setTargetPosition(targetSnapPosition);
        o.startSmoothScroll(scroller);
        return true;
    }
    
    public void attachToRecyclerView(final RecyclerView mRecyclerView) throws IllegalStateException {
        final RecyclerView mRecyclerView2 = this.mRecyclerView;
        if (mRecyclerView2 == mRecyclerView) {
            return;
        }
        if (mRecyclerView2 != null) {
            this.destroyCallbacks();
        }
        if ((this.mRecyclerView = mRecyclerView) != null) {
            this.setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), (Interpolator)new DecelerateInterpolator());
            this.snapToTargetExistingView();
        }
    }
    
    public abstract int[] calculateDistanceToFinalSnap(final o p0, final View p1);
    
    public int[] calculateScrollDistance(final int n, final int n2) {
        this.mGravityScroller.fling(0, 0, n, n2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[] { this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY() };
    }
    
    protected y createScroller(final o o) {
        return this.createSnapScroller(o);
    }
    
    @Deprecated
    protected androidx.recyclerview.widget.n createSnapScroller(final o o) {
        if (!(o instanceof y.b)) {
            return null;
        }
        return new androidx.recyclerview.widget.n(this, this.mRecyclerView.getContext()) {
            final x a;
            
            @Override
            protected float calculateSpeedPerPixel(final DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }
            
            @Override
            protected void onTargetFound(final View view, final z z, final a a) {
                final x a2 = this.a;
                final RecyclerView mRecyclerView = a2.mRecyclerView;
                if (mRecyclerView == null) {
                    return;
                }
                final int[] calculateDistanceToFinalSnap = a2.calculateDistanceToFinalSnap(mRecyclerView.getLayoutManager(), view);
                final int n = calculateDistanceToFinalSnap[0];
                final int n2 = calculateDistanceToFinalSnap[1];
                final int calculateTimeForDeceleration = this.calculateTimeForDeceleration(Math.max(Math.abs(n), Math.abs(n2)));
                if (calculateTimeForDeceleration > 0) {
                    a.d(n, n2, calculateTimeForDeceleration, (Interpolator)super.mDecelerateInterpolator);
                }
            }
        };
    }
    
    public abstract View findSnapView(final o p0);
    
    public abstract int findTargetSnapPosition(final o p0, final int p1, final int p2);
    
    @Override
    public boolean onFling(final int n, final int n2) {
        final RecyclerView.o layoutManager = this.mRecyclerView.getLayoutManager();
        final boolean b = false;
        if (layoutManager == null) {
            return false;
        }
        if (this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        final int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(n2) <= minFlingVelocity) {
            final boolean b2 = b;
            if (Math.abs(n) <= minFlingVelocity) {
                return b2;
            }
        }
        boolean b2 = b;
        if (this.snapFromFling(layoutManager, n, n2)) {
            b2 = true;
        }
        return b2;
    }
    
    void snapToTargetExistingView() {
        final RecyclerView mRecyclerView = this.mRecyclerView;
        if (mRecyclerView == null) {
            return;
        }
        final RecyclerView.o layoutManager = mRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        final View snapView = this.findSnapView(layoutManager);
        if (snapView == null) {
            return;
        }
        final int[] calculateDistanceToFinalSnap = this.calculateDistanceToFinalSnap(layoutManager, snapView);
        if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        }
    }
}
