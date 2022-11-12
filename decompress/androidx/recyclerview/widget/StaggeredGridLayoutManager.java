// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.List;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.graphics.PointF;
import java.util.Arrays;
import android.view.View$MeasureSpec;
import java.util.ArrayList;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import java.util.BitSet;

public class StaggeredGridLayoutManager extends o implements y.b
{
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final b mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final androidx.recyclerview.widget.m mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private int[] mPrefetchDistances;
    androidx.recyclerview.widget.s mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout;
    androidx.recyclerview.widget.s mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    d[] mSpans;
    private final Rect mTmpRect;
    
    public StaggeredGridLayoutManager(final int spanCount, final int mOrientation) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new b();
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() {
            final StaggeredGridLayoutManager a;
            
            @Override
            public void run() {
                this.a.checkForGaps();
            }
        };
        this.mOrientation = mOrientation;
        this.setSpanCount(spanCount);
        this.mLayoutState = new androidx.recyclerview.widget.m();
        this.createOrientationHelpers();
    }
    
    public StaggeredGridLayoutManager(final Context context, final AttributeSet set, final int n, final int n2) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new b();
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() {
            final StaggeredGridLayoutManager a;
            
            @Override
            public void run() {
                this.a.checkForGaps();
            }
        };
        final o.d properties = RecyclerView.o.getProperties(context, set, n, n2);
        this.setOrientation(properties.a);
        this.setSpanCount(properties.b);
        this.setReverseLayout(properties.c);
        this.mLayoutState = new androidx.recyclerview.widget.m();
        this.createOrientationHelpers();
    }
    
    private void appendViewToAllSpans(final View view) {
        for (int i = this.mSpanCount - 1; i >= 0; --i) {
            this.mSpans[i].a(view);
        }
    }
    
    private void applyPendingSavedState(final b b) {
        final SavedState mPendingSavedState = this.mPendingSavedState;
        final int c = mPendingSavedState.c;
        if (c > 0) {
            if (c == this.mSpanCount) {
                for (int i = 0; i < this.mSpanCount; ++i) {
                    this.mSpans[i].e();
                    final SavedState mPendingSavedState2 = this.mPendingSavedState;
                    final int n = mPendingSavedState2.d[i];
                    int n2;
                    if ((n2 = n) != Integer.MIN_VALUE) {
                        int n3;
                        if (mPendingSavedState2.i) {
                            n3 = this.mPrimaryOrientation.i();
                        }
                        else {
                            n3 = this.mPrimaryOrientation.m();
                        }
                        n2 = n + n3;
                    }
                    this.mSpans[i].A(n2);
                }
            }
            else {
                mPendingSavedState.b();
                final SavedState mPendingSavedState3 = this.mPendingSavedState;
                mPendingSavedState3.a = mPendingSavedState3.b;
            }
        }
        final SavedState mPendingSavedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = mPendingSavedState4.j;
        this.setReverseLayout(mPendingSavedState4.h);
        this.resolveShouldLayoutReverse();
        final SavedState mPendingSavedState5 = this.mPendingSavedState;
        final int a = mPendingSavedState5.a;
        if (a != -1) {
            this.mPendingScrollPosition = a;
            b.c = mPendingSavedState5.i;
        }
        else {
            b.c = this.mShouldReverseLayout;
        }
        if (mPendingSavedState5.e > 1) {
            final LazySpanLookup mLazySpanLookup = this.mLazySpanLookup;
            mLazySpanLookup.a = mPendingSavedState5.f;
            mLazySpanLookup.b = mPendingSavedState5.g;
        }
    }
    
    private void attachViewToSpans(final View view, final c c, final androidx.recyclerview.widget.m m) {
        if (m.e == 1) {
            if (c.f) {
                this.appendViewToAllSpans(view);
            }
            else {
                c.e.a(view);
            }
        }
        else if (c.f) {
            this.prependViewToAllSpans(view);
        }
        else {
            c.e.z(view);
        }
    }
    
    private int calculateScrollDirectionForPosition(final int n) {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int n2 = -1;
        if (childCount == 0) {
            if (this.mShouldReverseLayout) {
                n2 = 1;
            }
            return n2;
        }
        if (n < this.getFirstChildPosition() == this.mShouldReverseLayout) {
            n2 = 1;
        }
        return n2;
    }
    
    private boolean checkSpanForGap(final d d) {
        if (this.mShouldReverseLayout) {
            if (d.p() < this.mPrimaryOrientation.i()) {
                final ArrayList<View> a = d.a;
                return d.s((View)a.get(a.size() - 1)).f ^ true;
            }
        }
        else if (d.t() > this.mPrimaryOrientation.m()) {
            return d.s(d.a.get(0)).f ^ true;
        }
        return false;
    }
    
    private int computeScrollExtent(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.v.a(z, this.mPrimaryOrientation, this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
    }
    
    private int computeScrollOffset(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.v.b(z, this.mPrimaryOrientation, this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }
    
    private int computeScrollRange(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.v.c(z, this.mPrimaryOrientation, this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
    }
    
    private int convertFocusDirectionToLayoutDirection(int n) {
        int n2 = -1;
        final int n3 = 1;
        final int n4 = 1;
        if (n != 1) {
            if (n != 2) {
                if (n == 17) {
                    if (this.mOrientation != 0) {
                        n2 = Integer.MIN_VALUE;
                    }
                    return n2;
                }
                if (n == 33) {
                    if (this.mOrientation != 1) {
                        n2 = Integer.MIN_VALUE;
                    }
                    return n2;
                }
                if (n == 66) {
                    if (this.mOrientation == 0) {
                        n = n3;
                    }
                    else {
                        n = Integer.MIN_VALUE;
                    }
                    return n;
                }
                if (n != 130) {
                    return Integer.MIN_VALUE;
                }
                if (this.mOrientation == 1) {
                    n = n4;
                }
                else {
                    n = Integer.MIN_VALUE;
                }
                return n;
            }
            else {
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (this.isLayoutRTL()) {
                    return -1;
                }
                return 1;
            }
        }
        else {
            if (this.mOrientation == 1) {
                return -1;
            }
            if (this.isLayoutRTL()) {
                return 1;
            }
            return -1;
        }
    }
    
    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(final int n) {
        final LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.mSpanCount];
        for (int i = 0; i < this.mSpanCount; ++i) {
            fullSpanItem.c[i] = n - this.mSpans[i].q(n);
        }
        return fullSpanItem;
    }
    
    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(final int n) {
        final LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.mSpanCount];
        for (int i = 0; i < this.mSpanCount; ++i) {
            fullSpanItem.c[i] = this.mSpans[i].u(n) - n;
        }
        return fullSpanItem;
    }
    
    private void createOrientationHelpers() {
        this.mPrimaryOrientation = androidx.recyclerview.widget.s.b(this, this.mOrientation);
        this.mSecondaryOrientation = androidx.recyclerview.widget.s.b(this, 1 - this.mOrientation);
    }
    
    private int fill(final v v, final androidx.recyclerview.widget.m m, final z z) {
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        int n;
        if (this.mLayoutState.i) {
            if (m.e == 1) {
                n = Integer.MAX_VALUE;
            }
            else {
                n = Integer.MIN_VALUE;
            }
        }
        else if (m.e == 1) {
            n = m.g + m.b;
        }
        else {
            n = m.f - m.b;
        }
        this.updateAllRemainingSpans(m.e, n);
        int n2;
        if (this.mShouldReverseLayout) {
            n2 = this.mPrimaryOrientation.i();
        }
        else {
            n2 = this.mPrimaryOrientation.m();
        }
        boolean b = false;
        while (m.a(z) && (this.mLayoutState.i || !this.mRemainingSpans.isEmpty())) {
            final View b2 = m.b(v);
            final c c = (c)b2.getLayoutParams();
            final int a = ((RecyclerView.p)c).a();
            final int g = this.mLazySpanLookup.g(a);
            final boolean b3 = g == -1;
            d nextSpan;
            if (b3) {
                if (c.f) {
                    nextSpan = this.mSpans[0];
                }
                else {
                    nextSpan = this.getNextSpan(m);
                }
                this.mLazySpanLookup.n(a, nextSpan);
            }
            else {
                nextSpan = this.mSpans[g];
            }
            c.e = nextSpan;
            if (m.e == 1) {
                ((RecyclerView.o)this).addView(b2);
            }
            else {
                ((RecyclerView.o)this).addView(b2, 0);
            }
            this.measureChildWithDecorationsAndMargin(b2, c, false);
            int n4;
            int n5;
            if (m.e == 1) {
                int n3;
                if (c.f) {
                    n3 = this.getMaxEnd(n2);
                }
                else {
                    n3 = nextSpan.q(n2);
                }
                final int e = this.mPrimaryOrientation.e(b2);
                if (b3 && c.f) {
                    final LazySpanLookup.FullSpanItem fullSpanItemFromEnd = this.createFullSpanItemFromEnd(n3);
                    fullSpanItemFromEnd.b = -1;
                    fullSpanItemFromEnd.a = a;
                    this.mLazySpanLookup.a(fullSpanItemFromEnd);
                }
                n4 = e + n3;
                n5 = n3;
            }
            else {
                int n6;
                if (c.f) {
                    n6 = this.getMinStart(n2);
                }
                else {
                    n6 = nextSpan.u(n2);
                }
                n5 = n6 - this.mPrimaryOrientation.e(b2);
                if (b3 && c.f) {
                    final LazySpanLookup.FullSpanItem fullSpanItemFromStart = this.createFullSpanItemFromStart(n6);
                    fullSpanItemFromStart.b = 1;
                    fullSpanItemFromStart.a = a;
                    this.mLazySpanLookup.a(fullSpanItemFromStart);
                }
                n4 = n6;
            }
            if (c.f && m.d == -1) {
                if (b3) {
                    this.mLaidOutInvalidFullSpan = true;
                }
                else {
                    boolean b4;
                    if (m.e == 1) {
                        b4 = this.areAllEndsEqual();
                    }
                    else {
                        b4 = this.areAllStartsEqual();
                    }
                    if (b4 ^ true) {
                        final LazySpanLookup.FullSpanItem f = this.mLazySpanLookup.f(a);
                        if (f != null) {
                            f.d = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            this.attachViewToSpans(b2, c, m);
            int n8;
            int n9;
            if (this.isLayoutRTL() && this.mOrientation == 1) {
                int i;
                if (c.f) {
                    i = this.mSecondaryOrientation.i();
                }
                else {
                    i = this.mSecondaryOrientation.i() - (this.mSpanCount - 1 - nextSpan.e) * this.mSizePerSpan;
                }
                final int e2 = this.mSecondaryOrientation.e(b2);
                final int n7 = i;
                n8 = i - e2;
                n9 = n7;
            }
            else {
                int j;
                if (c.f) {
                    j = this.mSecondaryOrientation.m();
                }
                else {
                    j = nextSpan.e * this.mSizePerSpan + this.mSecondaryOrientation.m();
                }
                final int e3 = this.mSecondaryOrientation.e(b2);
                final int n10 = j;
                n9 = e3 + j;
                n8 = n10;
            }
            if (this.mOrientation == 1) {
                ((RecyclerView.o)this).layoutDecoratedWithMargins(b2, n8, n5, n9, n4);
            }
            else {
                ((RecyclerView.o)this).layoutDecoratedWithMargins(b2, n5, n8, n4, n9);
            }
            if (c.f) {
                this.updateAllRemainingSpans(this.mLayoutState.e, n);
            }
            else {
                this.updateRemainingSpans(nextSpan, this.mLayoutState.e, n);
            }
            this.recycle(v, this.mLayoutState);
            if (this.mLayoutState.h && b2.hasFocusable()) {
                if (c.f) {
                    this.mRemainingSpans.clear();
                }
                else {
                    this.mRemainingSpans.set(nextSpan.e, false);
                }
            }
            b = true;
        }
        if (!b) {
            this.recycle(v, this.mLayoutState);
        }
        int n11;
        if (this.mLayoutState.e == -1) {
            n11 = this.mPrimaryOrientation.m() - this.getMinStart(this.mPrimaryOrientation.m());
        }
        else {
            n11 = this.getMaxEnd(this.mPrimaryOrientation.i()) - this.mPrimaryOrientation.i();
        }
        int min;
        if (n11 > 0) {
            min = Math.min(m.b, n11);
        }
        else {
            min = 0;
        }
        return min;
    }
    
    private int findFirstReferenceChildPosition(final int n) {
        for (int childCount = ((RecyclerView.o)this).getChildCount(), i = 0; i < childCount; ++i) {
            final int position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(i));
            if (position >= 0 && position < n) {
                return position;
            }
        }
        return 0;
    }
    
    private int findLastReferenceChildPosition(final int n) {
        for (int i = ((RecyclerView.o)this).getChildCount() - 1; i >= 0; --i) {
            final int position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(i));
            if (position >= 0 && position < n) {
                return position;
            }
        }
        return 0;
    }
    
    private void fixEndGap(final v v, final z z, final boolean b) {
        final int maxEnd = this.getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd == Integer.MIN_VALUE) {
            return;
        }
        final int n = this.mPrimaryOrientation.i() - maxEnd;
        if (n > 0) {
            final int n2 = n - -this.scrollBy(-n, v, z);
            if (b && n2 > 0) {
                this.mPrimaryOrientation.r(n2);
            }
        }
    }
    
    private void fixStartGap(final v v, final z z, final boolean b) {
        final int minStart = this.getMinStart(Integer.MAX_VALUE);
        if (minStart == Integer.MAX_VALUE) {
            return;
        }
        final int n = minStart - this.mPrimaryOrientation.m();
        if (n > 0) {
            final int n2 = n - this.scrollBy(n, v, z);
            if (b && n2 > 0) {
                this.mPrimaryOrientation.r(-n2);
            }
        }
    }
    
    private int getMaxEnd(final int n) {
        int q = this.mSpans[0].q(n);
        int n2;
        for (int i = 1; i < this.mSpanCount; ++i, q = n2) {
            final int q2 = this.mSpans[i].q(n);
            if (q2 > (n2 = q)) {
                n2 = q2;
            }
        }
        return q;
    }
    
    private int getMaxStart(final int n) {
        int u = this.mSpans[0].u(n);
        int n2;
        for (int i = 1; i < this.mSpanCount; ++i, u = n2) {
            final int u2 = this.mSpans[i].u(n);
            if (u2 > (n2 = u)) {
                n2 = u2;
            }
        }
        return u;
    }
    
    private int getMinEnd(final int n) {
        int q = this.mSpans[0].q(n);
        int n2;
        for (int i = 1; i < this.mSpanCount; ++i, q = n2) {
            final int q2 = this.mSpans[i].q(n);
            if (q2 < (n2 = q)) {
                n2 = q2;
            }
        }
        return q;
    }
    
    private int getMinStart(final int n) {
        int u = this.mSpans[0].u(n);
        int n2;
        for (int i = 1; i < this.mSpanCount; ++i, u = n2) {
            final int u2 = this.mSpans[i].u(n);
            if (u2 < (n2 = u)) {
                n2 = u2;
            }
        }
        return u;
    }
    
    private d getNextSpan(final androidx.recyclerview.widget.m m) {
        final boolean preferLastSpan = this.preferLastSpan(m.e);
        int mSpanCount = -1;
        int i;
        int n;
        if (preferLastSpan) {
            i = this.mSpanCount - 1;
            n = -1;
        }
        else {
            i = 0;
            mSpanCount = this.mSpanCount;
            n = 1;
        }
        final int e = m.e;
        d d = null;
        final d d2 = null;
        if (e == 1) {
            int n2 = Integer.MAX_VALUE;
            final int j = this.mPrimaryOrientation.m();
            d d3 = d2;
            while (i != mSpanCount) {
                final d d4 = this.mSpans[i];
                final int q = d4.q(j);
                int n3;
                if (q < (n3 = n2)) {
                    d3 = d4;
                    n3 = q;
                }
                i += n;
                n2 = n3;
            }
            return d3;
        }
        int n4 = Integer.MIN_VALUE;
        final int k = this.mPrimaryOrientation.i();
        int n5;
        for (int l = i; l != mSpanCount; l += n, n4 = n5) {
            final d d5 = this.mSpans[l];
            final int u = d5.u(k);
            if (u > (n5 = n4)) {
                d = d5;
                n5 = u;
            }
        }
        return d;
    }
    
    private void handleUpdate(int n, final int n2, final int n3) {
        int n4;
        if (this.mShouldReverseLayout) {
            n4 = this.getLastChildPosition();
        }
        else {
            n4 = this.getFirstChildPosition();
        }
        int n5 = 0;
        int n6 = 0;
        Label_0060: {
            if (n3 == 8) {
                if (n >= n2) {
                    n5 = n + 1;
                    n6 = n2;
                    break Label_0060;
                }
                n5 = n2 + 1;
            }
            else {
                n5 = n + n2;
            }
            n6 = n;
        }
        this.mLazySpanLookup.h(n6);
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 == 8) {
                    this.mLazySpanLookup.k(n, 1);
                    this.mLazySpanLookup.j(n2, 1);
                }
            }
            else {
                this.mLazySpanLookup.k(n, n2);
            }
        }
        else {
            this.mLazySpanLookup.j(n, n2);
        }
        if (n5 <= n4) {
            return;
        }
        if (this.mShouldReverseLayout) {
            n = this.getFirstChildPosition();
        }
        else {
            n = this.getLastChildPosition();
        }
        if (n6 <= n) {
            ((RecyclerView.o)this).requestLayout();
        }
    }
    
    private void measureChildWithDecorationsAndMargin(final View view, int updateSpecWithExtra, int updateSpecWithExtra2, final boolean b) {
        ((RecyclerView.o)this).calculateItemDecorationsForChild(view, this.mTmpRect);
        final c c = (c)view.getLayoutParams();
        final int leftMargin = c.leftMargin;
        final Rect mTmpRect = this.mTmpRect;
        updateSpecWithExtra = this.updateSpecWithExtra(updateSpecWithExtra, leftMargin + mTmpRect.left, c.rightMargin + mTmpRect.right);
        final int topMargin = c.topMargin;
        final Rect mTmpRect2 = this.mTmpRect;
        updateSpecWithExtra2 = this.updateSpecWithExtra(updateSpecWithExtra2, topMargin + mTmpRect2.top, c.bottomMargin + mTmpRect2.bottom);
        boolean b2;
        if (b) {
            b2 = ((RecyclerView.o)this).shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, c);
        }
        else {
            b2 = ((RecyclerView.o)this).shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, c);
        }
        if (b2) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }
    
    private void measureChildWithDecorationsAndMargin(final View view, final c c, final boolean b) {
        if (c.f) {
            if (this.mOrientation == 1) {
                this.measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.o.getChildMeasureSpec(((RecyclerView.o)this).getHeight(), ((RecyclerView.o)this).getHeightMode(), ((RecyclerView.o)this).getPaddingTop() + ((RecyclerView.o)this).getPaddingBottom(), c.height, true), b);
            }
            else {
                this.measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(((RecyclerView.o)this).getWidth(), ((RecyclerView.o)this).getWidthMode(), ((RecyclerView.o)this).getPaddingLeft() + ((RecyclerView.o)this).getPaddingRight(), c.width, true), this.mFullSizeSpec, b);
            }
        }
        else if (this.mOrientation == 1) {
            this.measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(this.mSizePerSpan, ((RecyclerView.o)this).getWidthMode(), 0, c.width, false), RecyclerView.o.getChildMeasureSpec(((RecyclerView.o)this).getHeight(), ((RecyclerView.o)this).getHeightMode(), ((RecyclerView.o)this).getPaddingTop() + ((RecyclerView.o)this).getPaddingBottom(), c.height, true), b);
        }
        else {
            this.measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(((RecyclerView.o)this).getWidth(), ((RecyclerView.o)this).getWidthMode(), ((RecyclerView.o)this).getPaddingLeft() + ((RecyclerView.o)this).getPaddingRight(), c.width, true), RecyclerView.o.getChildMeasureSpec(this.mSizePerSpan, ((RecyclerView.o)this).getHeightMode(), 0, c.height, false), b);
        }
    }
    
    private void onLayoutChildren(final v v, final z z, final boolean b) {
        final b mAnchorInfo = this.mAnchorInfo;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && z.b() == 0) {
            ((RecyclerView.o)this).removeAndRecycleAllViews(v);
            mAnchorInfo.c();
            return;
        }
        final boolean e = mAnchorInfo.e;
        final int n = 1;
        final boolean b2 = !e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null;
        if (b2) {
            mAnchorInfo.c();
            if (this.mPendingSavedState != null) {
                this.applyPendingSavedState(mAnchorInfo);
            }
            else {
                this.resolveShouldLayoutReverse();
                mAnchorInfo.c = this.mShouldReverseLayout;
            }
            this.updateAnchorInfoForLayout(z, mAnchorInfo);
            mAnchorInfo.e = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (mAnchorInfo.c != this.mLastLayoutFromEnd || this.isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.b();
            mAnchorInfo.d = true;
        }
        if (((RecyclerView.o)this).getChildCount() > 0) {
            final SavedState mPendingSavedState = this.mPendingSavedState;
            if (mPendingSavedState == null || mPendingSavedState.c < 1) {
                if (mAnchorInfo.d) {
                    for (int i = 0; i < this.mSpanCount; ++i) {
                        this.mSpans[i].e();
                        final int b3 = mAnchorInfo.b;
                        if (b3 != Integer.MIN_VALUE) {
                            this.mSpans[i].A(b3);
                        }
                    }
                }
                else if (!b2 && this.mAnchorInfo.f != null) {
                    for (int j = 0; j < this.mSpanCount; ++j) {
                        final d d = this.mSpans[j];
                        d.e();
                        d.A(this.mAnchorInfo.f[j]);
                    }
                }
                else {
                    for (int k = 0; k < this.mSpanCount; ++k) {
                        this.mSpans[k].b(this.mShouldReverseLayout, mAnchorInfo.b);
                    }
                    this.mAnchorInfo.d(this.mSpans);
                }
            }
        }
        ((RecyclerView.o)this).detachAndScrapAttachedViews(v);
        this.mLayoutState.a = false;
        this.mLaidOutInvalidFullSpan = false;
        this.updateMeasureSpecs(this.mSecondaryOrientation.n());
        this.updateLayoutState(mAnchorInfo.a, z);
        if (mAnchorInfo.c) {
            this.setLayoutStateDirection(-1);
            this.fill(v, this.mLayoutState, z);
            this.setLayoutStateDirection(1);
            final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
            mLayoutState.c = mAnchorInfo.a + mLayoutState.d;
            this.fill(v, mLayoutState, z);
        }
        else {
            this.setLayoutStateDirection(1);
            this.fill(v, this.mLayoutState, z);
            this.setLayoutStateDirection(-1);
            final androidx.recyclerview.widget.m mLayoutState2 = this.mLayoutState;
            mLayoutState2.c = mAnchorInfo.a + mLayoutState2.d;
            this.fill(v, mLayoutState2, z);
        }
        this.repositionToWrapContentIfNecessary();
        if (((RecyclerView.o)this).getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                this.fixEndGap(v, z, true);
                this.fixStartGap(v, z, false);
            }
            else {
                this.fixStartGap(v, z, true);
                this.fixEndGap(v, z, false);
            }
        }
        int n2 = 0;
        Label_0668: {
            if (b && !z.e() && (this.mGapStrategy != 0 && ((RecyclerView.o)this).getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || this.hasGapsToFix() != null))) {
                ((RecyclerView.o)this).removeCallbacks(this.mCheckForGapsRunnable);
                if (this.checkForGaps()) {
                    n2 = n;
                    break Label_0668;
                }
            }
            n2 = 0;
        }
        if (z.e()) {
            this.mAnchorInfo.c();
        }
        this.mLastLayoutFromEnd = mAnchorInfo.c;
        this.mLastLayoutRTL = this.isLayoutRTL();
        if (n2 != 0) {
            this.mAnchorInfo.c();
            this.onLayoutChildren(v, z, false);
        }
    }
    
    private boolean preferLastSpan(final int n) {
        final int mOrientation = this.mOrientation;
        final boolean b = true;
        final boolean b2 = true;
        if (mOrientation == 0) {
            return n == -1 != this.mShouldReverseLayout && b2;
        }
        return n == -1 == this.mShouldReverseLayout == this.isLayoutRTL() && b;
    }
    
    private void prependViewToAllSpans(final View view) {
        for (int i = this.mSpanCount - 1; i >= 0; --i) {
            this.mSpans[i].z(view);
        }
    }
    
    private void recycle(final v v, final androidx.recyclerview.widget.m m) {
        if (m.a) {
            if (!m.i) {
                if (m.b == 0) {
                    if (m.e == -1) {
                        this.recycleFromEnd(v, m.g);
                    }
                    else {
                        this.recycleFromStart(v, m.f);
                    }
                }
                else if (m.e == -1) {
                    final int f = m.f;
                    final int n = f - this.getMaxStart(f);
                    int g;
                    if (n < 0) {
                        g = m.g;
                    }
                    else {
                        g = m.g - Math.min(n, m.b);
                    }
                    this.recycleFromEnd(v, g);
                }
                else {
                    final int n2 = this.getMinEnd(m.g) - m.g;
                    int f2;
                    if (n2 < 0) {
                        f2 = m.f;
                    }
                    else {
                        f2 = Math.min(n2, m.b) + m.f;
                    }
                    this.recycleFromStart(v, f2);
                }
            }
        }
    }
    
    private void recycleFromEnd(final v v, final int n) {
        for (int i = ((RecyclerView.o)this).getChildCount() - 1; i >= 0; --i) {
            final View child = ((RecyclerView.o)this).getChildAt(i);
            if (this.mPrimaryOrientation.g(child) < n || this.mPrimaryOrientation.q(child) < n) {
                break;
            }
            final c c = (c)child.getLayoutParams();
            if (c.f) {
                final int n2 = 0;
                int n3 = 0;
                int j;
                while (true) {
                    j = n2;
                    if (n3 >= this.mSpanCount) {
                        break;
                    }
                    if (this.mSpans[n3].a.size() == 1) {
                        return;
                    }
                    ++n3;
                }
                while (j < this.mSpanCount) {
                    this.mSpans[j].x();
                    ++j;
                }
            }
            else {
                if (c.e.a.size() == 1) {
                    return;
                }
                c.e.x();
            }
            ((RecyclerView.o)this).removeAndRecycleView(child, v);
        }
    }
    
    private void recycleFromStart(final v v, final int n) {
        while (((RecyclerView.o)this).getChildCount() > 0) {
            final int n2 = 0;
            final View child = ((RecyclerView.o)this).getChildAt(0);
            if (this.mPrimaryOrientation.d(child) > n || this.mPrimaryOrientation.p(child) > n) {
                break;
            }
            final c c = (c)child.getLayoutParams();
            if (c.f) {
                int n3 = 0;
                int i;
                while (true) {
                    i = n2;
                    if (n3 >= this.mSpanCount) {
                        break;
                    }
                    if (this.mSpans[n3].a.size() == 1) {
                        return;
                    }
                    ++n3;
                }
                while (i < this.mSpanCount) {
                    this.mSpans[i].y();
                    ++i;
                }
            }
            else {
                if (c.e.a.size() == 1) {
                    return;
                }
                c.e.y();
            }
            ((RecyclerView.o)this).removeAndRecycleView(child, v);
        }
    }
    
    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.k() == 1073741824) {
            return;
        }
        float max = 0.0f;
        final int childCount = ((RecyclerView.o)this).getChildCount();
        final int n = 0;
        for (int i = 0; i < childCount; ++i) {
            final View child = ((RecyclerView.o)this).getChildAt(i);
            final float n2 = (float)this.mSecondaryOrientation.e(child);
            if (n2 >= max) {
                float n3 = n2;
                if (((c)child.getLayoutParams()).f()) {
                    n3 = n2 * 1.0f / this.mSpanCount;
                }
                max = Math.max(max, n3);
            }
        }
        final int mSizePerSpan = this.mSizePerSpan;
        int n4 = Math.round(max * this.mSpanCount);
        if (this.mSecondaryOrientation.k() == Integer.MIN_VALUE) {
            n4 = Math.min(n4, this.mSecondaryOrientation.n());
        }
        this.updateMeasureSpecs(n4);
        int j = n;
        if (this.mSizePerSpan == mSizePerSpan) {
            return;
        }
        while (j < childCount) {
            final View child2 = ((RecyclerView.o)this).getChildAt(j);
            final c c = (c)child2.getLayoutParams();
            if (!c.f) {
                if (this.isLayoutRTL() && this.mOrientation == 1) {
                    final int mSpanCount = this.mSpanCount;
                    final int e = c.e.e;
                    child2.offsetLeftAndRight(-(mSpanCount - 1 - e) * this.mSizePerSpan - -(mSpanCount - 1 - e) * mSizePerSpan);
                }
                else {
                    final int e2 = c.e.e;
                    final int n5 = this.mSizePerSpan * e2;
                    final int n6 = e2 * mSizePerSpan;
                    if (this.mOrientation == 1) {
                        child2.offsetLeftAndRight(n5 - n6);
                    }
                    else {
                        child2.offsetTopAndBottom(n5 - n6);
                    }
                }
            }
            ++j;
        }
    }
    
    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && this.isLayoutRTL()) {
            this.mShouldReverseLayout = (this.mReverseLayout ^ true);
        }
        else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }
    
    private void setLayoutStateDirection(int n) {
        final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
        mLayoutState.e = n;
        final boolean mShouldReverseLayout = this.mShouldReverseLayout;
        final int n2 = 1;
        if (mShouldReverseLayout == (n == -1)) {
            n = n2;
        }
        else {
            n = -1;
        }
        mLayoutState.d = n;
    }
    
    private void updateAllRemainingSpans(final int n, final int n2) {
        for (int i = 0; i < this.mSpanCount; ++i) {
            if (!this.mSpans[i].a.isEmpty()) {
                this.updateRemainingSpans(this.mSpans[i], n, n2);
            }
        }
    }
    
    private boolean updateAnchorFromChildren(final z z, final b b) {
        int a;
        if (this.mLastLayoutFromEnd) {
            a = this.findLastReferenceChildPosition(z.b());
        }
        else {
            a = this.findFirstReferenceChildPosition(z.b());
        }
        b.a = a;
        b.b = Integer.MIN_VALUE;
        return true;
    }
    
    private void updateLayoutState(int n, final z z) {
        final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
        final boolean b = false;
        mLayoutState.b = 0;
        mLayoutState.c = n;
        int n2 = 0;
        Label_0095: {
            if (((RecyclerView.o)this).isSmoothScrolling()) {
                final int c = z.c();
                if (c != -1) {
                    if (this.mShouldReverseLayout == c < n) {
                        n = this.mPrimaryOrientation.n();
                        n2 = 0;
                        break Label_0095;
                    }
                    n2 = this.mPrimaryOrientation.n();
                    n = 0;
                    break Label_0095;
                }
            }
            n = 0;
            n2 = 0;
        }
        if (((RecyclerView.o)this).getClipToPadding()) {
            this.mLayoutState.f = this.mPrimaryOrientation.m() - n2;
            this.mLayoutState.g = this.mPrimaryOrientation.i() + n;
        }
        else {
            this.mLayoutState.g = this.mPrimaryOrientation.h() + n;
            this.mLayoutState.f = -n2;
        }
        final androidx.recyclerview.widget.m mLayoutState2 = this.mLayoutState;
        mLayoutState2.h = false;
        mLayoutState2.a = true;
        boolean i = b;
        if (this.mPrimaryOrientation.k() == 0) {
            i = b;
            if (this.mPrimaryOrientation.h() == 0) {
                i = true;
            }
        }
        mLayoutState2.i = i;
    }
    
    private void updateRemainingSpans(final d d, final int n, final int n2) {
        final int o = d.o();
        if (n == -1) {
            if (d.t() + o <= n2) {
                this.mRemainingSpans.set(d.e, false);
            }
        }
        else if (d.p() - o >= n2) {
            this.mRemainingSpans.set(d.e, false);
        }
    }
    
    private int updateSpecWithExtra(final int n, final int n2, final int n3) {
        if (n2 == 0 && n3 == 0) {
            return n;
        }
        final int mode = View$MeasureSpec.getMode(n);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return n;
        }
        return View$MeasureSpec.makeMeasureSpec(Math.max(0, View$MeasureSpec.getSize(n) - n2 - n3), mode);
    }
    
    boolean areAllEndsEqual() {
        final int q = this.mSpans[0].q(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; ++i) {
            if (this.mSpans[i].q(Integer.MIN_VALUE) != q) {
                return false;
            }
        }
        return true;
    }
    
    boolean areAllStartsEqual() {
        final int u = this.mSpans[0].u(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; ++i) {
            if (this.mSpans[i].u(Integer.MIN_VALUE) != u) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void assertNotInLayoutOrScroll(final String s) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(s);
        }
    }
    
    @Override
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }
    
    @Override
    public boolean canScrollVertically() {
        final int mOrientation = this.mOrientation;
        boolean b = true;
        if (mOrientation != 1) {
            b = false;
        }
        return b;
    }
    
    boolean checkForGaps() {
        if (((RecyclerView.o)this).getChildCount() == 0 || this.mGapStrategy == 0 || !((RecyclerView.o)this).isAttachedToWindow()) {
            return false;
        }
        int n;
        int n2;
        if (this.mShouldReverseLayout) {
            n = this.getLastChildPosition();
            n2 = this.getFirstChildPosition();
        }
        else {
            n = this.getFirstChildPosition();
            n2 = this.getLastChildPosition();
        }
        if (n == 0 && this.hasGapsToFix() != null) {
            this.mLazySpanLookup.b();
            ((RecyclerView.o)this).requestSimpleAnimationsInNextLayout();
            ((RecyclerView.o)this).requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        int n3;
        if (this.mShouldReverseLayout) {
            n3 = -1;
        }
        else {
            n3 = 1;
        }
        final LazySpanLookup mLazySpanLookup = this.mLazySpanLookup;
        ++n2;
        final LazySpanLookup.FullSpanItem e = mLazySpanLookup.e(n, n2, n3, true);
        if (e == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.d(n2);
            return false;
        }
        final LazySpanLookup.FullSpanItem e2 = this.mLazySpanLookup.e(n, e.a, n3 * -1, true);
        if (e2 == null) {
            this.mLazySpanLookup.d(e.a);
        }
        else {
            this.mLazySpanLookup.d(e2.a + 1);
        }
        ((RecyclerView.o)this).requestSimpleAnimationsInNextLayout();
        ((RecyclerView.o)this).requestLayout();
        return true;
    }
    
    @Override
    public boolean checkLayoutParams(final p p) {
        return p instanceof c;
    }
    
    @Override
    public void collectAdjacentPrefetchPositions(int n, int i, final z z, final o.c c) {
        if (this.mOrientation != 0) {
            n = i;
        }
        if (((RecyclerView.o)this).getChildCount() != 0) {
            if (n != 0) {
                this.prepareLayoutStateForDelta(n, z);
                final int[] mPrefetchDistances = this.mPrefetchDistances;
                if (mPrefetchDistances == null || mPrefetchDistances.length < this.mSpanCount) {
                    this.mPrefetchDistances = new int[this.mSpanCount];
                }
                final int n2 = 0;
                i = 0;
                n = 0;
                while (i < this.mSpanCount) {
                    final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
                    int n3;
                    int n4;
                    if (mLayoutState.d == -1) {
                        n3 = mLayoutState.f;
                        n4 = this.mSpans[i].u(n3);
                    }
                    else {
                        n3 = this.mSpans[i].q(mLayoutState.g);
                        n4 = this.mLayoutState.g;
                    }
                    final int n5 = n3 - n4;
                    int n6 = n;
                    if (n5 >= 0) {
                        this.mPrefetchDistances[n] = n5;
                        n6 = n + 1;
                    }
                    ++i;
                    n = n6;
                }
                Arrays.sort(this.mPrefetchDistances, 0, n);
                androidx.recyclerview.widget.m mLayoutState2;
                for (i = n2; i < n && this.mLayoutState.a(z); ++i) {
                    c.a(this.mLayoutState.c, this.mPrefetchDistances[i]);
                    mLayoutState2 = this.mLayoutState;
                    mLayoutState2.c += mLayoutState2.d;
                }
            }
        }
    }
    
    @Override
    public int computeHorizontalScrollExtent(final z z) {
        return this.computeScrollExtent(z);
    }
    
    @Override
    public int computeHorizontalScrollOffset(final z z) {
        return this.computeScrollOffset(z);
    }
    
    @Override
    public int computeHorizontalScrollRange(final z z) {
        return this.computeScrollRange(z);
    }
    
    @Override
    public PointF computeScrollVectorForPosition(int calculateScrollDirectionForPosition) {
        calculateScrollDirectionForPosition = this.calculateScrollDirectionForPosition(calculateScrollDirectionForPosition);
        final PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float)calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        }
        else {
            pointF.x = 0.0f;
            pointF.y = (float)calculateScrollDirectionForPosition;
        }
        return pointF;
    }
    
    @Override
    public int computeVerticalScrollExtent(final z z) {
        return this.computeScrollExtent(z);
    }
    
    @Override
    public int computeVerticalScrollOffset(final z z) {
        return this.computeScrollOffset(z);
    }
    
    @Override
    public int computeVerticalScrollRange(final z z) {
        return this.computeScrollRange(z);
    }
    
    public int[] findFirstCompletelyVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[this.mSpanCount];
        }
        else if (array.length < this.mSpanCount) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            sb.append(this.mSpanCount);
            sb.append(", array size:");
            sb.append(array.length);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < this.mSpanCount; ++i) {
            array[i] = this.mSpans[i].f();
        }
        return array;
    }
    
    View findFirstVisibleItemClosestToEnd(final boolean b) {
        final int m = this.mPrimaryOrientation.m();
        final int i = this.mPrimaryOrientation.i();
        int j = ((RecyclerView.o)this).getChildCount() - 1;
        View view = null;
        while (j >= 0) {
            final View child = ((RecyclerView.o)this).getChildAt(j);
            final int g = this.mPrimaryOrientation.g(child);
            final int d = this.mPrimaryOrientation.d(child);
            View view2 = view;
            if (d > m) {
                if (g >= i) {
                    view2 = view;
                }
                else {
                    if (d <= i || !b) {
                        return child;
                    }
                    if ((view2 = view) == null) {
                        view2 = child;
                    }
                }
            }
            --j;
            view = view2;
        }
        return view;
    }
    
    View findFirstVisibleItemClosestToStart(final boolean b) {
        final int m = this.mPrimaryOrientation.m();
        final int i = this.mPrimaryOrientation.i();
        final int childCount = ((RecyclerView.o)this).getChildCount();
        View view = null;
        View view2;
        for (int j = 0; j < childCount; ++j, view = view2) {
            final View child = ((RecyclerView.o)this).getChildAt(j);
            final int g = this.mPrimaryOrientation.g(child);
            view2 = view;
            if (this.mPrimaryOrientation.d(child) > m) {
                if (g >= i) {
                    view2 = view;
                }
                else {
                    if (g >= m || !b) {
                        return child;
                    }
                    if ((view2 = view) == null) {
                        view2 = child;
                    }
                }
            }
        }
        return view;
    }
    
    int findFirstVisibleItemPositionInt() {
        View view;
        if (this.mShouldReverseLayout) {
            view = this.findFirstVisibleItemClosestToEnd(true);
        }
        else {
            view = this.findFirstVisibleItemClosestToStart(true);
        }
        int position;
        if (view == null) {
            position = -1;
        }
        else {
            position = ((RecyclerView.o)this).getPosition(view);
        }
        return position;
    }
    
    public int[] findFirstVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[this.mSpanCount];
        }
        else if (array.length < this.mSpanCount) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            sb.append(this.mSpanCount);
            sb.append(", array size:");
            sb.append(array.length);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < this.mSpanCount; ++i) {
            array[i] = this.mSpans[i].h();
        }
        return array;
    }
    
    public int[] findLastCompletelyVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[this.mSpanCount];
        }
        else if (array.length < this.mSpanCount) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            sb.append(this.mSpanCount);
            sb.append(", array size:");
            sb.append(array.length);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < this.mSpanCount; ++i) {
            array[i] = this.mSpans[i].i();
        }
        return array;
    }
    
    public int[] findLastVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[this.mSpanCount];
        }
        else if (array.length < this.mSpanCount) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            sb.append(this.mSpanCount);
            sb.append(", array size:");
            sb.append(array.length);
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < this.mSpanCount; ++i) {
            array[i] = this.mSpans[i].k();
        }
        return array;
    }
    
    @Override
    public p generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }
    
    @Override
    public p generateLayoutParams(final Context context, final AttributeSet set) {
        return new c(context, set);
    }
    
    @Override
    public p generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new c((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new c(viewGroup$LayoutParams);
    }
    
    int getFirstChildPosition() {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int position = 0;
        if (childCount != 0) {
            position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(0));
        }
        return position;
    }
    
    public int getGapStrategy() {
        return this.mGapStrategy;
    }
    
    int getLastChildPosition() {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int position;
        if (childCount == 0) {
            position = 0;
        }
        else {
            position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(childCount - 1));
        }
        return position;
    }
    
    public int getOrientation() {
        return this.mOrientation;
    }
    
    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }
    
    public int getSpanCount() {
        return this.mSpanCount;
    }
    
    View hasGapsToFix() {
        int n = ((RecyclerView.o)this).getChildCount() - 1;
        final BitSet set = new BitSet(this.mSpanCount);
        set.set(0, this.mSpanCount, true);
        final int mOrientation = this.mOrientation;
        int n2 = -1;
        int n3;
        if (mOrientation == 1 && this.isLayoutRTL()) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        int n4;
        if (this.mShouldReverseLayout) {
            n4 = -1;
        }
        else {
            n4 = n + 1;
            n = 0;
        }
        int i = n;
        if (n < n4) {
            n2 = 1;
            i = n;
        }
        while (i != n4) {
            final View child = ((RecyclerView.o)this).getChildAt(i);
            final c c = (c)child.getLayoutParams();
            if (set.get(c.e.e)) {
                if (this.checkSpanForGap(c.e)) {
                    return child;
                }
                set.clear(c.e.e);
            }
            if (!c.f) {
                final int n5 = i + n2;
                if (n5 != n4) {
                    final View child2 = ((RecyclerView.o)this).getChildAt(n5);
                    boolean b = false;
                    Label_0276: {
                        Label_0274: {
                            if (this.mShouldReverseLayout) {
                                final int d = this.mPrimaryOrientation.d(child);
                                final int d2 = this.mPrimaryOrientation.d(child2);
                                if (d < d2) {
                                    return child;
                                }
                                if (d != d2) {
                                    break Label_0274;
                                }
                            }
                            else {
                                final int g = this.mPrimaryOrientation.g(child);
                                final int g2 = this.mPrimaryOrientation.g(child2);
                                if (g > g2) {
                                    return child;
                                }
                                if (g != g2) {
                                    break Label_0274;
                                }
                            }
                            b = true;
                            break Label_0276;
                        }
                        b = false;
                    }
                    if (b && c.e.e - ((c)child2.getLayoutParams()).e.e < 0 != n3 < 0) {
                        return child;
                    }
                }
            }
            i += n2;
        }
        return null;
    }
    
    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.b();
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }
    
    boolean isLayoutRTL() {
        final int layoutDirection = ((RecyclerView.o)this).getLayoutDirection();
        boolean b = true;
        if (layoutDirection != 1) {
            b = false;
        }
        return b;
    }
    
    @Override
    public void offsetChildrenHorizontal(final int n) {
        super.offsetChildrenHorizontal(n);
        for (int i = 0; i < this.mSpanCount; ++i) {
            this.mSpans[i].w(n);
        }
    }
    
    @Override
    public void offsetChildrenVertical(final int n) {
        super.offsetChildrenVertical(n);
        for (int i = 0; i < this.mSpanCount; ++i) {
            this.mSpans[i].w(n);
        }
    }
    
    @Override
    public void onAdapterChanged(final Adapter adapter, final Adapter adapter2) {
        this.mLazySpanLookup.b();
        for (int i = 0; i < this.mSpanCount; ++i) {
            this.mSpans[i].e();
        }
    }
    
    @Override
    public void onDetachedFromWindow(final RecyclerView recyclerView, final v v) {
        super.onDetachedFromWindow(recyclerView, v);
        ((RecyclerView.o)this).removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; ++i) {
            this.mSpans[i].e();
        }
        recyclerView.requestLayout();
    }
    
    @Override
    public View onFocusSearchFailed(View containingItemView, int n, final v v, final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return null;
        }
        containingItemView = ((RecyclerView.o)this).findContainingItemView(containingItemView);
        if (containingItemView == null) {
            return null;
        }
        this.resolveShouldLayoutReverse();
        final int convertFocusDirectionToLayoutDirection = this.convertFocusDirectionToLayoutDirection(n);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        final c c = (c)containingItemView.getLayoutParams();
        final boolean f = c.f;
        final d e = c.e;
        if (convertFocusDirectionToLayoutDirection == 1) {
            n = this.getLastChildPosition();
        }
        else {
            n = this.getFirstChildPosition();
        }
        this.updateLayoutState(n, z);
        this.setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
        mLayoutState.c = mLayoutState.d + n;
        mLayoutState.b = (int)(this.mPrimaryOrientation.n() * 0.33333334f);
        final androidx.recyclerview.widget.m mLayoutState2 = this.mLayoutState;
        mLayoutState2.h = true;
        final int n2 = 0;
        mLayoutState2.a = false;
        this.fill(v, mLayoutState2, z);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!f) {
            final View r = e.r(n, convertFocusDirectionToLayoutDirection);
            if (r != null && r != containingItemView) {
                return r;
            }
        }
        if (this.preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i = this.mSpanCount - 1; i >= 0; --i) {
                final View r2 = this.mSpans[i].r(n, convertFocusDirectionToLayoutDirection);
                if (r2 != null && r2 != containingItemView) {
                    return r2;
                }
            }
        }
        else {
            for (int j = 0; j < this.mSpanCount; ++j) {
                final View r3 = this.mSpans[j].r(n, convertFocusDirectionToLayoutDirection);
                if (r3 != null && r3 != containingItemView) {
                    return r3;
                }
            }
        }
        final boolean mReverseLayout = this.mReverseLayout;
        if (convertFocusDirectionToLayoutDirection == -1) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (((mReverseLayout ^ true) ? 1 : 0) == n) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (!f) {
            int n3;
            if (n != 0) {
                n3 = e.g();
            }
            else {
                n3 = e.j();
            }
            final View viewByPosition = ((RecyclerView.o)this).findViewByPosition(n3);
            if (viewByPosition != null && viewByPosition != containingItemView) {
                return viewByPosition;
            }
        }
        int k = n2;
        if (this.preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int l = this.mSpanCount - 1; l >= 0; --l) {
                if (l != e.e) {
                    int n4;
                    if (n != 0) {
                        n4 = this.mSpans[l].g();
                    }
                    else {
                        n4 = this.mSpans[l].j();
                    }
                    final View viewByPosition2 = ((RecyclerView.o)this).findViewByPosition(n4);
                    if (viewByPosition2 != null && viewByPosition2 != containingItemView) {
                        return viewByPosition2;
                    }
                }
            }
        }
        else {
            while (k < this.mSpanCount) {
                int n5;
                if (n != 0) {
                    n5 = this.mSpans[k].g();
                }
                else {
                    n5 = this.mSpans[k].j();
                }
                final View viewByPosition3 = ((RecyclerView.o)this).findViewByPosition(n5);
                if (viewByPosition3 != null && viewByPosition3 != containingItemView) {
                    return viewByPosition3;
                }
                ++k;
            }
        }
        return null;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (((RecyclerView.o)this).getChildCount() > 0) {
            final View firstVisibleItemClosestToStart = this.findFirstVisibleItemClosestToStart(false);
            final View firstVisibleItemClosestToEnd = this.findFirstVisibleItemClosestToEnd(false);
            if (firstVisibleItemClosestToStart != null) {
                if (firstVisibleItemClosestToEnd != null) {
                    final int position = ((RecyclerView.o)this).getPosition(firstVisibleItemClosestToStart);
                    final int position2 = ((RecyclerView.o)this).getPosition(firstVisibleItemClosestToEnd);
                    if (position < position2) {
                        accessibilityEvent.setFromIndex(position);
                        accessibilityEvent.setToIndex(position2);
                    }
                    else {
                        accessibilityEvent.setFromIndex(position2);
                        accessibilityEvent.setToIndex(position);
                    }
                }
            }
        }
    }
    
    @Override
    public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
        this.handleUpdate(n, n2, 1);
    }
    
    @Override
    public void onItemsChanged(final RecyclerView recyclerView) {
        this.mLazySpanLookup.b();
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    public void onItemsMoved(final RecyclerView recyclerView, final int n, final int n2, final int n3) {
        this.handleUpdate(n, n2, 8);
    }
    
    @Override
    public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
        this.handleUpdate(n, n2, 2);
    }
    
    @Override
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
        this.handleUpdate(n, n2, 4);
    }
    
    @Override
    public void onLayoutChildren(final v v, final z z) {
        this.onLayoutChildren(v, z, true);
    }
    
    @Override
    public void onLayoutCompleted(final z z) {
        super.onLayoutCompleted(z);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.c();
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            final SavedState mPendingSavedState = (SavedState)parcelable;
            this.mPendingSavedState = mPendingSavedState;
            if (this.mPendingScrollPosition != -1) {
                mPendingSavedState.a();
                this.mPendingSavedState.b();
            }
            ((RecyclerView.o)this).requestLayout();
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return (Parcelable)new SavedState(this.mPendingSavedState);
        }
        final SavedState savedState = new SavedState();
        savedState.h = this.mReverseLayout;
        savedState.i = this.mLastLayoutFromEnd;
        savedState.j = this.mLastLayoutRTL;
        final LazySpanLookup mLazySpanLookup = this.mLazySpanLookup;
        int i = 0;
        Label_0114: {
            if (mLazySpanLookup != null) {
                final int[] a = mLazySpanLookup.a;
                if (a != null) {
                    savedState.f = a;
                    savedState.e = a.length;
                    savedState.g = mLazySpanLookup.b;
                    break Label_0114;
                }
            }
            savedState.e = 0;
        }
        if (((RecyclerView.o)this).getChildCount() > 0) {
            int a2;
            if (this.mLastLayoutFromEnd) {
                a2 = this.getLastChildPosition();
            }
            else {
                a2 = this.getFirstChildPosition();
            }
            savedState.a = a2;
            savedState.b = this.findFirstVisibleItemPositionInt();
            final int mSpanCount = this.mSpanCount;
            savedState.c = mSpanCount;
            savedState.d = new int[mSpanCount];
            while (i < this.mSpanCount) {
                int n2 = 0;
                Label_0253: {
                    int n;
                    int n3;
                    if (this.mLastLayoutFromEnd) {
                        n = this.mSpans[i].q(Integer.MIN_VALUE);
                        if ((n2 = n) == Integer.MIN_VALUE) {
                            break Label_0253;
                        }
                        n3 = this.mPrimaryOrientation.i();
                    }
                    else {
                        n = this.mSpans[i].u(Integer.MIN_VALUE);
                        if ((n2 = n) == Integer.MIN_VALUE) {
                            break Label_0253;
                        }
                        n3 = this.mPrimaryOrientation.m();
                    }
                    n2 = n - n3;
                }
                savedState.d[i] = n2;
                ++i;
            }
        }
        else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return (Parcelable)savedState;
    }
    
    @Override
    public void onScrollStateChanged(final int n) {
        if (n == 0) {
            this.checkForGaps();
        }
    }
    
    void prepareLayoutStateForDelta(final int n, final z z) {
        int n2;
        int layoutStateDirection;
        if (n > 0) {
            n2 = this.getLastChildPosition();
            layoutStateDirection = 1;
        }
        else {
            n2 = this.getFirstChildPosition();
            layoutStateDirection = -1;
        }
        this.mLayoutState.a = true;
        this.updateLayoutState(n2, z);
        this.setLayoutStateDirection(layoutStateDirection);
        final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
        mLayoutState.c = n2 + mLayoutState.d;
        mLayoutState.b = Math.abs(n);
    }
    
    int scrollBy(int n, final v v, final z z) {
        if (((RecyclerView.o)this).getChildCount() != 0 && n != 0) {
            this.prepareLayoutStateForDelta(n, z);
            final int fill = this.fill(v, this.mLayoutState, z);
            if (this.mLayoutState.b >= fill) {
                if (n < 0) {
                    n = -fill;
                }
                else {
                    n = fill;
                }
            }
            this.mPrimaryOrientation.r(-n);
            this.mLastLayoutFromEnd = this.mShouldReverseLayout;
            final androidx.recyclerview.widget.m mLayoutState = this.mLayoutState;
            mLayoutState.b = 0;
            this.recycle(v, mLayoutState);
            return n;
        }
        return 0;
    }
    
    @Override
    public int scrollHorizontallyBy(final int n, final v v, final z z) {
        return this.scrollBy(n, v, z);
    }
    
    @Override
    public void scrollToPosition(final int mPendingScrollPosition) {
        final SavedState mPendingSavedState = this.mPendingSavedState;
        if (mPendingSavedState != null && mPendingSavedState.a != mPendingScrollPosition) {
            mPendingSavedState.a();
        }
        this.mPendingScrollPosition = mPendingScrollPosition;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        ((RecyclerView.o)this).requestLayout();
    }
    
    public void scrollToPositionWithOffset(final int mPendingScrollPosition, final int mPendingScrollPositionOffset) {
        final SavedState mPendingSavedState = this.mPendingSavedState;
        if (mPendingSavedState != null) {
            mPendingSavedState.a();
        }
        this.mPendingScrollPosition = mPendingScrollPosition;
        this.mPendingScrollPositionOffset = mPendingScrollPositionOffset;
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    public int scrollVerticallyBy(final int n, final v v, final z z) {
        return this.scrollBy(n, v, z);
    }
    
    public void setGapStrategy(final int mGapStrategy) {
        this.assertNotInLayoutOrScroll(null);
        if (mGapStrategy == this.mGapStrategy) {
            return;
        }
        if (mGapStrategy != 0 && mGapStrategy != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = mGapStrategy;
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    public void setMeasuredDimension(final Rect rect, int chooseSize, int chooseSize2) {
        final int n = ((RecyclerView.o)this).getPaddingLeft() + ((RecyclerView.o)this).getPaddingRight();
        final int n2 = ((RecyclerView.o)this).getPaddingTop() + ((RecyclerView.o)this).getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(chooseSize2, rect.height() + n2, ((RecyclerView.o)this).getMinimumHeight());
            final int chooseSize3 = RecyclerView.o.chooseSize(chooseSize, this.mSizePerSpan * this.mSpanCount + n, ((RecyclerView.o)this).getMinimumWidth());
            chooseSize = chooseSize2;
            chooseSize2 = chooseSize3;
        }
        else {
            chooseSize = RecyclerView.o.chooseSize(chooseSize, rect.width() + n, ((RecyclerView.o)this).getMinimumWidth());
            final int chooseSize4 = RecyclerView.o.chooseSize(chooseSize2, this.mSizePerSpan * this.mSpanCount + n2, ((RecyclerView.o)this).getMinimumHeight());
            chooseSize2 = chooseSize;
            chooseSize = chooseSize4;
        }
        ((RecyclerView.o)this).setMeasuredDimension(chooseSize2, chooseSize);
    }
    
    public void setOrientation(final int mOrientation) {
        if (mOrientation != 0 && mOrientation != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        this.assertNotInLayoutOrScroll(null);
        if (mOrientation == this.mOrientation) {
            return;
        }
        this.mOrientation = mOrientation;
        final androidx.recyclerview.widget.s mPrimaryOrientation = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = mPrimaryOrientation;
        ((RecyclerView.o)this).requestLayout();
    }
    
    public void setReverseLayout(final boolean b) {
        this.assertNotInLayoutOrScroll(null);
        final SavedState mPendingSavedState = this.mPendingSavedState;
        if (mPendingSavedState != null && mPendingSavedState.h != b) {
            mPendingSavedState.h = b;
        }
        this.mReverseLayout = b;
        ((RecyclerView.o)this).requestLayout();
    }
    
    public void setSpanCount(int i) {
        this.assertNotInLayoutOrScroll(null);
        if (i != this.mSpanCount) {
            this.invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new d[this.mSpanCount];
            for (i = 0; i < this.mSpanCount; ++i) {
                this.mSpans[i] = new d(i);
            }
            ((RecyclerView.o)this).requestLayout();
        }
    }
    
    @Override
    public void smoothScrollToPosition(final RecyclerView recyclerView, final z z, final int targetPosition) {
        final androidx.recyclerview.widget.n n = new androidx.recyclerview.widget.n(recyclerView.getContext());
        ((RecyclerView.y)n).setTargetPosition(targetPosition);
        ((RecyclerView.o)this).startSmoothScroll(n);
    }
    
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }
    
    boolean updateAnchorFromPendingData(final z z, final b b) {
        final boolean e = z.e();
        boolean c = false;
        if (!e) {
            final int mPendingScrollPosition = this.mPendingScrollPosition;
            if (mPendingScrollPosition != -1) {
                if (mPendingScrollPosition >= 0 && mPendingScrollPosition < z.b()) {
                    final SavedState mPendingSavedState = this.mPendingSavedState;
                    if (mPendingSavedState != null && mPendingSavedState.a != -1 && mPendingSavedState.c >= 1) {
                        b.b = Integer.MIN_VALUE;
                        b.a = this.mPendingScrollPosition;
                    }
                    else {
                        final View viewByPosition = ((RecyclerView.o)this).findViewByPosition(this.mPendingScrollPosition);
                        if (viewByPosition != null) {
                            int a;
                            if (this.mShouldReverseLayout) {
                                a = this.getLastChildPosition();
                            }
                            else {
                                a = this.getFirstChildPosition();
                            }
                            b.a = a;
                            if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                                if (b.c) {
                                    b.b = this.mPrimaryOrientation.i() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.d(viewByPosition);
                                }
                                else {
                                    b.b = this.mPrimaryOrientation.m() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.g(viewByPosition);
                                }
                                return true;
                            }
                            if (this.mPrimaryOrientation.e(viewByPosition) > this.mPrimaryOrientation.n()) {
                                int b2;
                                if (b.c) {
                                    b2 = this.mPrimaryOrientation.i();
                                }
                                else {
                                    b2 = this.mPrimaryOrientation.m();
                                }
                                b.b = b2;
                                return true;
                            }
                            final int n = this.mPrimaryOrientation.g(viewByPosition) - this.mPrimaryOrientation.m();
                            if (n < 0) {
                                b.b = -n;
                                return true;
                            }
                            final int b3 = this.mPrimaryOrientation.i() - this.mPrimaryOrientation.d(viewByPosition);
                            if (b3 < 0) {
                                b.b = b3;
                                return true;
                            }
                            b.b = Integer.MIN_VALUE;
                        }
                        else {
                            final int mPendingScrollPosition2 = this.mPendingScrollPosition;
                            b.a = mPendingScrollPosition2;
                            final int mPendingScrollPositionOffset = this.mPendingScrollPositionOffset;
                            if (mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                                if (this.calculateScrollDirectionForPosition(mPendingScrollPosition2) == 1) {
                                    c = true;
                                }
                                b.c = c;
                                b.a();
                            }
                            else {
                                b.b(mPendingScrollPositionOffset);
                            }
                            b.d = true;
                        }
                    }
                    return true;
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            }
        }
        return false;
    }
    
    void updateAnchorInfoForLayout(final z z, final b b) {
        if (this.updateAnchorFromPendingData(z, b)) {
            return;
        }
        if (this.updateAnchorFromChildren(z, b)) {
            return;
        }
        b.a();
        b.a = 0;
    }
    
    void updateMeasureSpecs(final int n) {
        this.mSizePerSpan = n / this.mSpanCount;
        this.mFullSizeSpec = View$MeasureSpec.makeMeasureSpec(n, this.mSecondaryOrientation.k());
    }
    
    static class LazySpanLookup
    {
        int[] a;
        List<FullSpanItem> b;
        
        private int i(final int n) {
            if (this.b == null) {
                return -1;
            }
            final FullSpanItem f = this.f(n);
            if (f != null) {
                this.b.remove(f);
            }
            final int size = this.b.size();
            int i = 0;
            while (true) {
                while (i < size) {
                    if (this.b.get(i).a >= n) {
                        if (i != -1) {
                            final FullSpanItem fullSpanItem = this.b.get(i);
                            this.b.remove(i);
                            return fullSpanItem.a;
                        }
                        return -1;
                    }
                    else {
                        ++i;
                    }
                }
                i = -1;
                continue;
            }
        }
        
        private void l(final int n, final int n2) {
            final List<FullSpanItem> b = this.b;
            if (b == null) {
                return;
            }
            for (int i = b.size() - 1; i >= 0; --i) {
                final FullSpanItem fullSpanItem = this.b.get(i);
                final int a = fullSpanItem.a;
                if (a >= n) {
                    fullSpanItem.a = a + n2;
                }
            }
        }
        
        private void m(final int n, final int n2) {
            final List<FullSpanItem> b = this.b;
            if (b == null) {
                return;
            }
            for (int i = b.size() - 1; i >= 0; --i) {
                final FullSpanItem fullSpanItem = this.b.get(i);
                final int a = fullSpanItem.a;
                if (a >= n) {
                    if (a < n + n2) {
                        this.b.remove(i);
                    }
                    else {
                        fullSpanItem.a = a - n2;
                    }
                }
            }
        }
        
        public void a(final FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList<FullSpanItem>();
            }
            for (int size = this.b.size(), i = 0; i < size; ++i) {
                final FullSpanItem fullSpanItem2 = this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }
        
        void b() {
            final int[] a = this.a;
            if (a != null) {
                Arrays.fill(a, -1);
            }
            this.b = null;
        }
        
        void c(final int n) {
            final int[] a = this.a;
            if (a == null) {
                Arrays.fill(this.a = new int[Math.max(n, 10) + 1], -1);
            }
            else if (n >= a.length) {
                System.arraycopy(a, 0, this.a = new int[this.o(n)], 0, a.length);
                final int[] a2 = this.a;
                Arrays.fill(a2, a.length, a2.length, -1);
            }
        }
        
        int d(final int n) {
            final List<FullSpanItem> b = this.b;
            if (b != null) {
                for (int i = b.size() - 1; i >= 0; --i) {
                    if (this.b.get(i).a >= n) {
                        this.b.remove(i);
                    }
                }
            }
            return this.h(n);
        }
        
        public FullSpanItem e(final int n, final int n2, final int n3, final boolean b) {
            final List<FullSpanItem> b2 = this.b;
            if (b2 == null) {
                return null;
            }
            for (int size = b2.size(), i = 0; i < size; ++i) {
                final FullSpanItem fullSpanItem = this.b.get(i);
                final int a = fullSpanItem.a;
                if (a >= n2) {
                    return null;
                }
                if (a >= n && (n3 == 0 || fullSpanItem.b == n3 || (b && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
        
        public FullSpanItem f(final int n) {
            final List<FullSpanItem> b = this.b;
            if (b == null) {
                return null;
            }
            for (int i = b.size() - 1; i >= 0; --i) {
                final FullSpanItem fullSpanItem = this.b.get(i);
                if (fullSpanItem.a == n) {
                    return fullSpanItem;
                }
            }
            return null;
        }
        
        int g(final int n) {
            final int[] a = this.a;
            if (a != null && n < a.length) {
                return a[n];
            }
            return -1;
        }
        
        int h(final int n) {
            final int[] a = this.a;
            if (a == null) {
                return -1;
            }
            if (n >= a.length) {
                return -1;
            }
            final int i = this.i(n);
            if (i == -1) {
                final int[] a2 = this.a;
                Arrays.fill(a2, n, a2.length, -1);
                return this.a.length;
            }
            final int min = Math.min(i + 1, this.a.length);
            Arrays.fill(this.a, n, min, -1);
            return min;
        }
        
        void j(final int n, final int n2) {
            final int[] a = this.a;
            if (a != null) {
                if (n < a.length) {
                    final int n3 = n + n2;
                    this.c(n3);
                    final int[] a2 = this.a;
                    System.arraycopy(a2, n, a2, n3, a2.length - n - n2);
                    Arrays.fill(this.a, n, n3, -1);
                    this.l(n, n2);
                }
            }
        }
        
        void k(final int n, final int n2) {
            final int[] a = this.a;
            if (a != null) {
                if (n < a.length) {
                    final int n3 = n + n2;
                    this.c(n3);
                    final int[] a2 = this.a;
                    System.arraycopy(a2, n3, a2, n, a2.length - n - n2);
                    final int[] a3 = this.a;
                    Arrays.fill(a3, a3.length - n2, a3.length, -1);
                    this.m(n, n2);
                }
            }
        }
        
        void n(final int n, final d d) {
            this.c(n);
            this.a[n] = d.e;
        }
        
        int o(final int n) {
            int i;
            for (i = this.a.length; i <= n; i *= 2) {}
            return i;
        }
        
        static class FullSpanItem implements Parcelable
        {
            public static final Parcelable$Creator<FullSpanItem> CREATOR;
            int a;
            int b;
            int[] c;
            boolean d;
            
            static {
                CREATOR = (Parcelable$Creator)new Parcelable$Creator<FullSpanItem>() {
                    public FullSpanItem a(final Parcel parcel) {
                        return new FullSpanItem(parcel);
                    }
                    
                    public FullSpanItem[] b(final int n) {
                        return new FullSpanItem[n];
                    }
                    
                    public /* bridge */ Object createFromParcel(final Parcel parcel) {
                        return this.a(parcel);
                    }
                    
                    public /* bridge */ Object[] newArray(final int n) {
                        return this.b(n);
                    }
                };
            }
            
            FullSpanItem() {
            }
            
            FullSpanItem(final Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                final int int1 = parcel.readInt();
                boolean d = true;
                if (int1 != 1) {
                    d = false;
                }
                this.d = d;
                final int int2 = parcel.readInt();
                if (int2 > 0) {
                    parcel.readIntArray(this.c = new int[int2]);
                }
            }
            
            int a(int n) {
                final int[] c = this.c;
                if (c == null) {
                    n = 0;
                }
                else {
                    n = c[n];
                }
                return n;
            }
            
            public int describeContents() {
                return 0;
            }
            
            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder();
                sb.append("FullSpanItem{mPosition=");
                sb.append(this.a);
                sb.append(", mGapDir=");
                sb.append(this.b);
                sb.append(", mHasUnwantedGapAfter=");
                sb.append(this.d);
                sb.append(", mGapPerSpan=");
                sb.append(Arrays.toString(this.c));
                sb.append('}');
                return sb.toString();
            }
            
            public void writeToParcel(final Parcel parcel, final int n) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt((int)(this.d ? 1 : 0));
                final int[] c = this.c;
                if (c != null && c.length > 0) {
                    parcel.writeInt(c.length);
                    parcel.writeIntArray(this.c);
                }
                else {
                    parcel.writeInt(0);
                }
            }
        }
    }
    
    public static class SavedState implements Parcelable
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        public SavedState() {
        }
        
        SavedState(final Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            final int int1 = parcel.readInt();
            this.c = int1;
            if (int1 > 0) {
                parcel.readIntArray(this.d = new int[int1]);
            }
            final int int2 = parcel.readInt();
            if ((this.e = int2) > 0) {
                parcel.readIntArray(this.f = new int[int2]);
            }
            final int int3 = parcel.readInt();
            final boolean b = false;
            this.h = (int3 == 1);
            this.i = (parcel.readInt() == 1);
            boolean j = b;
            if (parcel.readInt() == 1) {
                j = true;
            }
            this.j = j;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }
        
        public SavedState(final SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }
        
        void a() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }
        
        void b() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt((int)(this.h ? 1 : 0));
            parcel.writeInt((int)(this.i ? 1 : 0));
            parcel.writeInt((int)(this.j ? 1 : 0));
            parcel.writeList((List)this.g);
        }
    }
    
    class b
    {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;
        final StaggeredGridLayoutManager g;
        
        b(final StaggeredGridLayoutManager g) {
            this.g = g;
            this.c();
        }
        
        void a() {
            int b;
            if (this.c) {
                b = this.g.mPrimaryOrientation.i();
            }
            else {
                b = this.g.mPrimaryOrientation.m();
            }
            this.b = b;
        }
        
        void b(final int n) {
            if (this.c) {
                this.b = this.g.mPrimaryOrientation.i() - n;
            }
            else {
                this.b = this.g.mPrimaryOrientation.m() + n;
            }
        }
        
        void c() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            final int[] f = this.f;
            if (f != null) {
                Arrays.fill(f, -1);
            }
        }
        
        void d(final d[] array) {
            final int length = array.length;
            final int[] f = this.f;
            if (f == null || f.length < length) {
                this.f = new int[this.g.mSpans.length];
            }
            for (int i = 0; i < length; ++i) {
                this.f[i] = array[i].u(Integer.MIN_VALUE);
            }
        }
    }
    
    public static class c extends p
    {
        d e;
        boolean f;
        
        public c(final int n, final int n2) {
            super(n, n2);
        }
        
        public c(final Context context, final AttributeSet set) {
            super(context, set);
        }
        
        public c(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
        }
        
        public c(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
        }
        
        public final int e() {
            final d e = this.e;
            if (e == null) {
                return -1;
            }
            return e.e;
        }
        
        public boolean f() {
            return this.f;
        }
        
        public void g(final boolean f) {
            this.f = f;
        }
    }
    
    class d
    {
        ArrayList<View> a;
        int b;
        int c;
        int d;
        final int e;
        final StaggeredGridLayoutManager f;
        
        d(final StaggeredGridLayoutManager f, final int e) {
            this.f = f;
            this.a = new ArrayList<View>();
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.d = 0;
            this.e = e;
        }
        
        void A(final int n) {
            this.b = n;
            this.c = n;
        }
        
        void a(final View view) {
            final c s = this.s(view);
            s.e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (((RecyclerView.p)s).c() || ((RecyclerView.p)s).b()) {
                this.d += this.f.mPrimaryOrientation.e(view);
            }
        }
        
        void b(final boolean b, final int n) {
            int n2;
            if (b) {
                n2 = this.q(Integer.MIN_VALUE);
            }
            else {
                n2 = this.u(Integer.MIN_VALUE);
            }
            this.e();
            if (n2 == Integer.MIN_VALUE) {
                return;
            }
            if ((b && n2 < this.f.mPrimaryOrientation.i()) || (!b && n2 > this.f.mPrimaryOrientation.m())) {
                return;
            }
            int n3 = n2;
            if (n != Integer.MIN_VALUE) {
                n3 = n2 + n;
            }
            this.c = n3;
            this.b = n3;
        }
        
        void c() {
            final ArrayList<View> a = this.a;
            final View view = a.get(a.size() - 1);
            final c s = this.s(view);
            this.c = this.f.mPrimaryOrientation.d(view);
            if (s.f) {
                final LazySpanLookup.FullSpanItem f = this.f.mLazySpanLookup.f(((RecyclerView.p)s).a());
                if (f != null && f.b == 1) {
                    this.c += f.a(this.e);
                }
            }
        }
        
        void d() {
            final View view = this.a.get(0);
            final c s = this.s(view);
            this.b = this.f.mPrimaryOrientation.g(view);
            if (s.f) {
                final LazySpanLookup.FullSpanItem f = this.f.mLazySpanLookup.f(((RecyclerView.p)s).a());
                if (f != null && f.b == -1) {
                    this.b -= f.a(this.e);
                }
            }
        }
        
        void e() {
            this.a.clear();
            this.v();
            this.d = 0;
        }
        
        public int f() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.n(this.a.size() - 1, -1, true);
            }
            else {
                n = this.n(0, this.a.size(), true);
            }
            return n;
        }
        
        public int g() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.m(this.a.size() - 1, -1, true);
            }
            else {
                n = this.m(0, this.a.size(), true);
            }
            return n;
        }
        
        public int h() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.n(this.a.size() - 1, -1, false);
            }
            else {
                n = this.n(0, this.a.size(), false);
            }
            return n;
        }
        
        public int i() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.n(0, this.a.size(), true);
            }
            else {
                n = this.n(this.a.size() - 1, -1, true);
            }
            return n;
        }
        
        public int j() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.m(0, this.a.size(), true);
            }
            else {
                n = this.m(this.a.size() - 1, -1, true);
            }
            return n;
        }
        
        public int k() {
            int n;
            if (this.f.mReverseLayout) {
                n = this.n(0, this.a.size(), false);
            }
            else {
                n = this.n(this.a.size() - 1, -1, false);
            }
            return n;
        }
        
        int l(int i, final int n, final boolean b, final boolean b2, final boolean b3) {
            final int m = this.f.mPrimaryOrientation.m();
            final int j = this.f.mPrimaryOrientation.i();
            int n2;
            if (n > i) {
                n2 = 1;
            }
            else {
                n2 = -1;
            }
            while (i != n) {
                final View view = this.a.get(i);
                final int g = this.f.mPrimaryOrientation.g(view);
                final int d = this.f.mPrimaryOrientation.d(view);
                boolean b4 = false;
                final boolean b5 = b3 ? (g <= j) : (g < j);
                Label_0143: {
                    if (b3) {
                        if (d < m) {
                            break Label_0143;
                        }
                    }
                    else if (d <= m) {
                        break Label_0143;
                    }
                    b4 = true;
                }
                if (b5 && b4) {
                    if (b && b2) {
                        if (g >= m && d <= j) {
                            return ((RecyclerView.o)this.f).getPosition(view);
                        }
                    }
                    else {
                        if (b2) {
                            return ((RecyclerView.o)this.f).getPosition(view);
                        }
                        if (g < m || d > j) {
                            return ((RecyclerView.o)this.f).getPosition(view);
                        }
                    }
                }
                i += n2;
            }
            return -1;
        }
        
        int m(final int n, final int n2, final boolean b) {
            return this.l(n, n2, false, false, b);
        }
        
        int n(final int n, final int n2, final boolean b) {
            return this.l(n, n2, b, true, false);
        }
        
        public int o() {
            return this.d;
        }
        
        int p() {
            final int c = this.c;
            if (c != Integer.MIN_VALUE) {
                return c;
            }
            this.c();
            return this.c;
        }
        
        int q(final int n) {
            final int c = this.c;
            if (c != Integer.MIN_VALUE) {
                return c;
            }
            if (this.a.size() == 0) {
                return n;
            }
            this.c();
            return this.c;
        }
        
        public View r(final int n, int n2) {
            View view = null;
            final View view2 = null;
            View view4;
            if (n2 == -1) {
                final int size = this.a.size();
                n2 = 0;
                View view3 = view2;
                while (true) {
                    view4 = view3;
                    if (n2 >= size) {
                        break;
                    }
                    final View view5 = this.a.get(n2);
                    final StaggeredGridLayoutManager f = this.f;
                    if (f.mReverseLayout) {
                        view4 = view3;
                        if (((RecyclerView.o)f).getPosition(view5) <= n) {
                            break;
                        }
                    }
                    final StaggeredGridLayoutManager f2 = this.f;
                    if (!f2.mReverseLayout && ((RecyclerView.o)f2).getPosition(view5) >= n) {
                        view4 = view3;
                        break;
                    }
                    view4 = view3;
                    if (!view5.hasFocusable()) {
                        break;
                    }
                    ++n2;
                    view3 = view5;
                }
            }
            else {
                n2 = this.a.size() - 1;
                while (true) {
                    view4 = view;
                    if (n2 < 0) {
                        break;
                    }
                    final View view6 = this.a.get(n2);
                    final StaggeredGridLayoutManager f3 = this.f;
                    if (f3.mReverseLayout) {
                        view4 = view;
                        if (((RecyclerView.o)f3).getPosition(view6) >= n) {
                            break;
                        }
                    }
                    final StaggeredGridLayoutManager f4 = this.f;
                    if (!f4.mReverseLayout && ((RecyclerView.o)f4).getPosition(view6) <= n) {
                        view4 = view;
                        break;
                    }
                    view4 = view;
                    if (!view6.hasFocusable()) {
                        break;
                    }
                    --n2;
                    view = view6;
                }
            }
            return view4;
        }
        
        c s(final View view) {
            return (c)view.getLayoutParams();
        }
        
        int t() {
            final int b = this.b;
            if (b != Integer.MIN_VALUE) {
                return b;
            }
            this.d();
            return this.b;
        }
        
        int u(final int n) {
            final int b = this.b;
            if (b != Integer.MIN_VALUE) {
                return b;
            }
            if (this.a.size() == 0) {
                return n;
            }
            this.d();
            return this.b;
        }
        
        void v() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }
        
        void w(final int n) {
            final int b = this.b;
            if (b != Integer.MIN_VALUE) {
                this.b = b + n;
            }
            final int c = this.c;
            if (c != Integer.MIN_VALUE) {
                this.c = c + n;
            }
        }
        
        void x() {
            final int size = this.a.size();
            final View view = this.a.remove(size - 1);
            final c s = this.s(view);
            s.e = null;
            if (((RecyclerView.p)s).c() || ((RecyclerView.p)s).b()) {
                this.d -= this.f.mPrimaryOrientation.e(view);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }
        
        void y() {
            final View view = this.a.remove(0);
            final c s = this.s(view);
            s.e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (((RecyclerView.p)s).c() || ((RecyclerView.p)s).b()) {
                this.d -= this.f.mPrimaryOrientation.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }
        
        void z(final View view) {
            final c s = this.s(view);
            s.e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (((RecyclerView.p)s).c() || ((RecyclerView.p)s).b()) {
                this.d += this.f.mPrimaryOrientation.e(view);
            }
        }
    }
}
