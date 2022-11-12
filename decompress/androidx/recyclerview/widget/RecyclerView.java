// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.os.Bundle;
import androidx.core.view.accessibility.d;
import android.graphics.Matrix;
import android.view.ViewGroup$MarginLayoutParams;
import android.database.Observable;
import java.util.Collections;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import android.os.SystemClock;
import android.animation.LayoutTransition;
import androidx.core.view.p;
import android.view.View$MeasureSpec;
import android.view.Display;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.FocusFinder;
import android.widget.OverScroller;
import android.graphics.Canvas;
import android.util.SparseArray;
import androidx.core.widget.i;
import android.util.Log;
import android.view.MotionEvent;
import android.os.Parcelable;
import androidx.core.view.accessibility.b;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import r0.c;
import android.view.View;
import androidx.core.view.b0;
import androidx.core.view.d0;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.RectF;
import android.graphics.Rect;
import androidx.core.view.r;
import java.util.List;
import java.util.ArrayList;
import android.widget.EdgeEffect;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.view.q;
import android.view.ViewGroup;

public class RecyclerView extends ViewGroup implements androidx.core.view.q
{
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.u mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private j mChildDrawingOrderCallback;
    f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private k mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.l mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private s mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    l mItemAnimator;
    private l.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<n> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    o mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final x mObserver;
    private List<q> mOnChildAttachStateListeners;
    private r mOnFlingListener;
    private final ArrayList<s> mOnItemTouchListeners;
    final List<c0> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    androidx.recyclerview.widget.l.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final v mRecycler;
    w mRecyclerListener;
    final List<w> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private t mScrollListener;
    private List<t> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.view.r mScrollingChildHelper;
    final z mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final b0 mViewFlinger;
    private final androidx.recyclerview.widget.a0.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.a0 mViewInfoStore;
    
    static {
        NESTED_SCROLLING_ATTRS = new int[] { 16843830 };
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        final Class<Integer> type = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, type, type };
        sQuinticInterpolator = (Interpolator)new Interpolator() {
            public float getInterpolation(float n) {
                --n;
                return n * n * n * n * n + 1.0f;
            }
        };
    }
    
    public RecyclerView(final Context context) {
        this(context, null);
    }
    
    public RecyclerView(final Context context, final AttributeSet set) {
        this(context, set, r0.a.a);
    }
    
    public RecyclerView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new androidx.recyclerview.widget.a0();
        this.mUpdateChildViewsRunnable = new Runnable() {
            final RecyclerView a;
            
            @Override
            public void run() {
                final RecyclerView a = this.a;
                if (a.mFirstLayoutComplete) {
                    if (!a.isLayoutRequested()) {
                        final RecyclerView a2 = this.a;
                        if (!a2.mIsAttached) {
                            a2.requestLayout();
                            return;
                        }
                        if (a2.mLayoutSuppressed) {
                            a2.mLayoutWasDefered = true;
                            return;
                        }
                        a2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList<w>();
        this.mItemDecorations = new ArrayList<n>();
        this.mOnItemTouchListeners = new ArrayList<s>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = (l)new androidx.recyclerview.widget.h();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new b0();
        androidx.recyclerview.widget.l.b mPrefetchRegistry;
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            mPrefetchRegistry = new androidx.recyclerview.widget.l.b();
        }
        else {
            mPrefetchRegistry = null;
        }
        this.mPrefetchRegistry = mPrefetchRegistry;
        this.mState = new z();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = (l.b)new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList<c0>();
        this.mItemAnimatorRunner = new Runnable() {
            final RecyclerView a;
            
            @Override
            public void run() {
                final l mItemAnimator = this.a.mItemAnimator;
                if (mItemAnimator != null) {
                    mItemAnimator.u();
                }
                this.a.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new androidx.recyclerview.widget.a0.b() {
            final RecyclerView a;
            
            @Override
            public void a(final c0 c0, final l.c c2, final l.c c3) {
                this.a.animateAppearance(c0, c2, c3);
            }
            
            @Override
            public void b(final c0 c0) {
                final RecyclerView a = this.a;
                a.mLayout.removeAndRecycleView(c0.itemView, a.mRecycler);
            }
            
            @Override
            public void c(final c0 c0, final l.c c2, final l.c c3) {
                this.a.mRecycler.J(c0);
                this.a.animateDisappearance(c0, c2, c3);
            }
            
            @Override
            public void d(final c0 c0, final l.c c2, final l.c c3) {
                c0.setIsRecyclable(false);
                final RecyclerView a = this.a;
                if (a.mDataSetHasChangedAfterLayout) {
                    if (a.mItemAnimator.b(c0, c0, c2, c3)) {
                        this.a.postAnimationRunner();
                    }
                }
                else if (a.mItemAnimator.d(c0, c2, c3)) {
                    this.a.postAnimationRunner();
                }
            }
        };
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        final ViewConfiguration value = ViewConfiguration.get(context);
        this.mTouchSlop = value.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = d0.a(value, context);
        this.mScaledVerticalScrollFactor = d0.b(value, context);
        this.mMinFlingVelocity = value.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = value.getScaledMaximumFlingVelocity();
        this.setWillNotDraw(this.getOverScrollMode() == 2);
        this.mItemAnimator.v(this.mItemAnimatorListener);
        this.initAdapterManager();
        this.initChildrenHelper();
        this.initAutofill();
        if (androidx.core.view.b0.z((View)this) == 0) {
            androidx.core.view.b0.A0((View)this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new androidx.recyclerview.widget.u(this));
        final int[] f = c.f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, f, n, 0);
        androidx.core.view.b0.n0((View)this, context, f, set, obtainStyledAttributes, n, 0);
        final String string = obtainStyledAttributes.getString(c.o);
        if (obtainStyledAttributes.getInt(c.i, -1) == -1) {
            this.setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(c.h, true);
        final boolean boolean1 = obtainStyledAttributes.getBoolean(c.j, false);
        this.mEnableFastScroller = boolean1;
        if (boolean1) {
            this.initFastScroller((StateListDrawable)obtainStyledAttributes.getDrawable(c.m), obtainStyledAttributes.getDrawable(c.n), (StateListDrawable)obtainStyledAttributes.getDrawable(c.k), obtainStyledAttributes.getDrawable(c.l));
        }
        obtainStyledAttributes.recycle();
        this.createLayoutManager(context, string, set, n, 0);
        final int[] nested_SCROLLING_ATTRS = RecyclerView.NESTED_SCROLLING_ATTRS;
        final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(set, nested_SCROLLING_ATTRS, n, 0);
        androidx.core.view.b0.n0((View)this, context, nested_SCROLLING_ATTRS, set, obtainStyledAttributes2, n, 0);
        final boolean boolean2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        this.setNestedScrollingEnabled(boolean2);
    }
    
    static void access$000(final RecyclerView recyclerView, final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        recyclerView.attachViewToParent(view, n, viewGroup$LayoutParams);
    }
    
    static void access$100(final RecyclerView recyclerView, final int n) {
        recyclerView.detachViewFromParent(n);
    }
    
    static boolean access$200(final RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }
    
    static void access$300(final RecyclerView recyclerView, final int n, final int n2) {
        recyclerView.setMeasuredDimension(n, n2);
    }
    
    private void addAnimatingView(final c0 c0) {
        final View itemView = c0.itemView;
        final boolean b = itemView.getParent() == this;
        this.mRecycler.J(this.getChildViewHolder(itemView));
        if (c0.isTmpDetached()) {
            this.mChildHelper.c(itemView, -1, itemView.getLayoutParams(), true);
        }
        else if (!b) {
            this.mChildHelper.b(itemView, true);
        }
        else {
            this.mChildHelper.k(itemView);
        }
    }
    
    private void animateChange(final c0 mShadowingHolder, final c0 mShadowedHolder, final l.c c, final l.c c2, final boolean b, final boolean b2) {
        mShadowingHolder.setIsRecyclable(false);
        if (b) {
            this.addAnimatingView(mShadowingHolder);
        }
        if (mShadowingHolder != mShadowedHolder) {
            if (b2) {
                this.addAnimatingView(mShadowedHolder);
            }
            mShadowingHolder.mShadowedHolder = mShadowedHolder;
            this.addAnimatingView(mShadowingHolder);
            this.mRecycler.J(mShadowingHolder);
            mShadowedHolder.setIsRecyclable(false);
            mShadowedHolder.mShadowingHolder = mShadowingHolder;
        }
        if (this.mItemAnimator.b(mShadowingHolder, mShadowedHolder, c, c2)) {
            this.postAnimationRunner();
        }
    }
    
    private void cancelScroll() {
        this.resetScroll();
        this.setScrollState(0);
    }
    
    static void clearNestedRecyclerViewIfNotNested(final c0 c0) {
        final WeakReference<RecyclerView> mNestedRecyclerView = c0.mNestedRecyclerView;
        if (mNestedRecyclerView != null) {
            View view = mNestedRecyclerView.get();
            while (view != null) {
                if (view == c0.itemView) {
                    return;
                }
                final ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View)parent;
                }
                else {
                    view = null;
                }
            }
            c0.mNestedRecyclerView = null;
        }
    }
    
    private void createLayoutManager(Context ex, String trim, final AttributeSet set, final int n, final int n2) {
        if (trim != null) {
            trim = trim.trim();
            if (!trim.isEmpty()) {
                final String fullClassName = this.getFullClassName((Context)ex, trim);
                try {
                    ClassLoader classLoader;
                    if (this.isInEditMode()) {
                        classLoader = this.getClass().getClassLoader();
                    }
                    else {
                        classLoader = ((Context)ex).getClassLoader();
                    }
                    final Class<? extends o> subclass = Class.forName(fullClassName, false, classLoader).asSubclass(o.class);
                    final NoSuchMethodException ex2 = null;
                    try {
                        final Constructor<? extends o> constructor = subclass.getConstructor(RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        ex = (NoSuchMethodException)new Object[] { ex, set, n, n2 };
                    }
                    catch (final NoSuchMethodException ex) {
                        try {
                            final Constructor<? extends o> constructor = subclass.getConstructor((Class<?>[])new Class[0]);
                            ex = ex2;
                            constructor.setAccessible(true);
                            this.setLayoutManager((o)constructor.newInstance((Object[])(Object)ex));
                        }
                        catch (final NoSuchMethodException ex3) {
                            ex3.initCause(ex);
                            final StringBuilder sb = new StringBuilder();
                            sb.append(set.getPositionDescription());
                            sb.append(": Error creating LayoutManager ");
                            sb.append(fullClassName);
                            throw new IllegalStateException(sb.toString(), ex3);
                        }
                    }
                }
                catch (final ClassCastException ex4) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(set.getPositionDescription());
                    sb2.append(": Class is not a LayoutManager ");
                    sb2.append(fullClassName);
                    throw new IllegalStateException(sb2.toString(), ex4);
                }
                catch (final IllegalAccessException ex5) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(set.getPositionDescription());
                    sb3.append(": Cannot access non-public constructor ");
                    sb3.append(fullClassName);
                    throw new IllegalStateException(sb3.toString(), ex5);
                }
                catch (final InstantiationException ex6) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append(set.getPositionDescription());
                    sb4.append(": Could not instantiate the LayoutManager: ");
                    sb4.append(fullClassName);
                    throw new IllegalStateException(sb4.toString(), ex6);
                }
                catch (final InvocationTargetException ex7) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append(set.getPositionDescription());
                    sb5.append(": Could not instantiate the LayoutManager: ");
                    sb5.append(fullClassName);
                    throw new IllegalStateException(sb5.toString(), ex7);
                }
                catch (final ClassNotFoundException ex8) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append(set.getPositionDescription());
                    sb6.append(": Unable to find LayoutManager ");
                    sb6.append(fullClassName);
                    throw new IllegalStateException(sb6.toString(), ex8);
                }
            }
        }
    }
    
    private boolean didChildRangeChange(final int n, final int n2) {
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        final int[] mMinMaxLayoutPositions = this.mMinMaxLayoutPositions;
        boolean b = false;
        if (mMinMaxLayoutPositions[0] != n || mMinMaxLayoutPositions[1] != n2) {
            b = true;
        }
        return b;
    }
    
    private void dispatchContentChangedIfNecessary() {
        final int mEatenAccessibilityChangeFlags = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (mEatenAccessibilityChangeFlags != 0 && this.isAccessibilityEnabled()) {
            final AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            b.b(obtain, mEatenAccessibilityChangeFlags);
            this.sendAccessibilityEventUnchecked(obtain);
        }
    }
    
    private void dispatchLayoutStep1() {
        final z mState = this.mState;
        boolean i = true;
        mState.a(1);
        this.fillRemainingScrollValues(this.mState);
        this.mState.j = false;
        this.startInterceptRequestLayout();
        this.mViewInfoStore.f();
        this.onEnterLayoutOrScroll();
        this.processAdapterUpdatesAndSetAnimationFlags();
        this.saveFocusInfo();
        final z mState2 = this.mState;
        if (!mState2.k || !this.mItemsChanged) {
            i = false;
        }
        mState2.i = i;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        mState2.h = mState2.l;
        mState2.f = this.mAdapter.getItemCount();
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.k) {
            for (int g = this.mChildHelper.g(), j = 0; j < g; ++j) {
                final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(j));
                if (!childViewHolderInt.shouldIgnore()) {
                    if (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds()) {
                        this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.t(this.mState, childViewHolderInt, l.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                        if (this.mState.i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                            this.mViewInfoStore.c(this.getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                        }
                    }
                }
            }
        }
        if (this.mState.l) {
            this.saveOldPositions();
            final z mState3 = this.mState;
            final boolean g2 = mState3.g;
            mState3.g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, mState3);
            this.mState.g = g2;
            for (int k = 0; k < this.mChildHelper.g(); ++k) {
                final c0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(k));
                if (!childViewHolderInt2.shouldIgnore()) {
                    if (!this.mViewInfoStore.i(childViewHolderInt2)) {
                        final int e = l.e(childViewHolderInt2);
                        final boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        int n = e;
                        if (!hasAnyOfTheFlags) {
                            n = (e | 0x1000);
                        }
                        final l.c t = this.mItemAnimator.t(this.mState, childViewHolderInt2, n, childViewHolderInt2.getUnmodifiedPayloads());
                        if (hasAnyOfTheFlags) {
                            this.recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, t);
                        }
                        else {
                            this.mViewInfoStore.a(childViewHolderInt2, t);
                        }
                    }
                }
            }
            this.clearOldPositions();
        }
        else {
            this.clearOldPositions();
        }
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mState.e = 2;
    }
    
    private void dispatchLayoutStep2() {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f = this.mAdapter.getItemCount();
        this.mState.d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            final Parcelable c = this.mPendingSavedState.c;
            if (c != null) {
                this.mLayout.onRestoreInstanceState(c);
            }
            this.mPendingSavedState = null;
        }
        final z mState = this.mState;
        mState.h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, mState);
        final z mState2 = this.mState;
        mState2.g = false;
        mState2.k = (mState2.k && this.mItemAnimator != null);
        mState2.e = 4;
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
    }
    
    private void dispatchLayoutStep3() {
        this.mState.a(4);
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        final z mState = this.mState;
        mState.e = 1;
        if (mState.k) {
            for (int i = this.mChildHelper.g() - 1; i >= 0; --i) {
                final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i));
                if (!childViewHolderInt.shouldIgnore()) {
                    final long changedHolderKey = this.getChangedHolderKey(childViewHolderInt);
                    final l.c s = this.mItemAnimator.s(this.mState, childViewHolderInt);
                    final c0 g = this.mViewInfoStore.g(changedHolderKey);
                    if (g != null && !g.shouldIgnore()) {
                        final boolean h = this.mViewInfoStore.h(g);
                        final boolean h2 = this.mViewInfoStore.h(childViewHolderInt);
                        if (h && g == childViewHolderInt) {
                            this.mViewInfoStore.d(childViewHolderInt, s);
                        }
                        else {
                            final l.c n = this.mViewInfoStore.n(g);
                            this.mViewInfoStore.d(childViewHolderInt, s);
                            final l.c m = this.mViewInfoStore.m(childViewHolderInt);
                            if (n == null) {
                                this.handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g);
                            }
                            else {
                                this.animateChange(g, childViewHolderInt, n, m, h, h2);
                            }
                        }
                    }
                    else {
                        this.mViewInfoStore.d(childViewHolderInt, s);
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        final z mState2 = this.mState;
        mState2.c = mState2.f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        mState2.k = false;
        mState2.l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        final ArrayList<c0> b = this.mRecycler.b;
        if (b != null) {
            b.clear();
        }
        final o mLayout = this.mLayout;
        if (mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            mLayout.mPrefetchMaxCountObserved = 0;
            mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.K();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        final int[] mMinMaxLayoutPositions = this.mMinMaxLayoutPositions;
        if (this.didChildRangeChange(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1])) {
            this.dispatchOnScrolled(0, 0);
        }
        this.recoverFocusFromState();
        this.resetFocusInfo();
    }
    
    private boolean dispatchToOnItemTouchListeners(final MotionEvent motionEvent) {
        final s mInterceptingOnItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (mInterceptingOnItemTouchListener == null) {
            return motionEvent.getAction() != 0 && this.findInterceptingOnItemTouchListener(motionEvent);
        }
        mInterceptingOnItemTouchListener.a(this, motionEvent);
        final int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }
    
    private boolean findInterceptingOnItemTouchListener(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        for (int size = this.mOnItemTouchListeners.size(), i = 0; i < size; ++i) {
            final s mInterceptingOnItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (mInterceptingOnItemTouchListener.b(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = mInterceptingOnItemTouchListener;
                return true;
            }
        }
        return false;
    }
    
    private void findMinMaxChildLayoutPositions(final int[] array) {
        final int g = this.mChildHelper.g();
        if (g == 0) {
            array[1] = (array[0] = -1);
            return;
        }
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3;
        for (int i = 0; i < g; ++i, n2 = n3) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i));
            if (childViewHolderInt.shouldIgnore()) {
                n3 = n2;
            }
            else {
                final int layoutPosition = childViewHolderInt.getLayoutPosition();
                int n4;
                if (layoutPosition < (n4 = n)) {
                    n4 = layoutPosition;
                }
                n = n4;
                if (layoutPosition > (n3 = n2)) {
                    n3 = layoutPosition;
                    n = n4;
                }
            }
        }
        array[0] = n;
        array[1] = n2;
    }
    
    static RecyclerView findNestedRecyclerView(final View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView)view;
        }
        final ViewGroup viewGroup = (ViewGroup)view;
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            final RecyclerView nestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (nestedRecyclerView != null) {
                return nestedRecyclerView;
            }
        }
        return null;
    }
    
    private View findNextViewToFocus() {
        final z mState = this.mState;
        int m = mState.m;
        if (m == -1) {
            m = 0;
        }
        final int b = mState.b();
        for (int i = m; i < b; ++i) {
            final c0 viewHolderForAdapterPosition = this.findViewHolderForAdapterPosition(i);
            if (viewHolderForAdapterPosition == null) {
                break;
            }
            if (viewHolderForAdapterPosition.itemView.hasFocusable()) {
                return viewHolderForAdapterPosition.itemView;
            }
        }
        for (int j = Math.min(b, m) - 1; j >= 0; --j) {
            final c0 viewHolderForAdapterPosition2 = this.findViewHolderForAdapterPosition(j);
            if (viewHolderForAdapterPosition2 == null) {
                return null;
            }
            if (viewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return viewHolderForAdapterPosition2.itemView;
            }
        }
        return null;
    }
    
    static c0 getChildViewHolderInt(final View view) {
        if (view == null) {
            return null;
        }
        return ((p)view.getLayoutParams()).a;
    }
    
    static void getDecoratedBoundsWithMarginsInt(final View view, final Rect rect) {
        final p p2 = (p)view.getLayoutParams();
        final Rect b = p2.b;
        rect.set(view.getLeft() - b.left - p2.leftMargin, view.getTop() - b.top - p2.topMargin, view.getRight() + b.right + p2.rightMargin, view.getBottom() + b.bottom + p2.bottomMargin);
    }
    
    private int getDeepestFocusedViewWithId(View focusedChild) {
        int n = focusedChild.getId();
        while (!focusedChild.isFocused() && focusedChild instanceof ViewGroup && focusedChild.hasFocus()) {
            final View view = focusedChild = ((ViewGroup)focusedChild).getFocusedChild();
            if (view.getId() != -1) {
                n = view.getId();
                focusedChild = view;
            }
        }
        return n;
    }
    
    private String getFullClassName(final Context context, final String s) {
        if (s.charAt(0) == '.') {
            final StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(s);
            return sb.toString();
        }
        if (s.contains(".")) {
            return s;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(RecyclerView.class.getPackage().getName());
        sb2.append('.');
        sb2.append(s);
        return sb2.toString();
    }
    
    private androidx.core.view.r getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.view.r((View)this);
        }
        return this.mScrollingChildHelper;
    }
    
    private void handleMissingPreInfoForChangeError(final long n, final c0 c0, final c0 c2) {
        for (int g = this.mChildHelper.g(), i = 0; i < g; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i));
            if (childViewHolderInt != c0) {
                if (this.getChangedHolderKey(childViewHolderInt) == n) {
                    final Adapter mAdapter = this.mAdapter;
                    if (mAdapter != null && mAdapter.hasStableIds()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                        sb.append(childViewHolderInt);
                        sb.append(" \n View Holder 2:");
                        sb.append(c0);
                        sb.append(this.exceptionLabel());
                        throw new IllegalStateException(sb.toString());
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb2.append(childViewHolderInt);
                    sb2.append(" \n View Holder 2:");
                    sb2.append(c0);
                    sb2.append(this.exceptionLabel());
                    throw new IllegalStateException(sb2.toString());
                }
            }
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb3.append(c2);
        sb3.append(" cannot be found but it is necessary for ");
        sb3.append(c0);
        sb3.append(this.exceptionLabel());
        Log.e("RecyclerView", sb3.toString());
    }
    
    private boolean hasUpdatedView() {
        for (int g = this.mChildHelper.g(), i = 0; i < g; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i));
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.shouldIgnore()) {
                    if (childViewHolderInt.isUpdated()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void initAutofill() {
        if (androidx.core.view.b0.A((View)this) == 0) {
            androidx.core.view.b0.B0((View)this, 8);
        }
    }
    
    private void initChildrenHelper() {
        this.mChildHelper = new f((f.b)new f.b(this) {
            final RecyclerView a;
            
            @Override
            public void addView(final View view, final int n) {
                this.a.addView(view, n);
                this.a.dispatchChildAttached(view);
            }
            
            @Override
            public int j() {
                return this.a.getChildCount();
            }
            
            @Override
            public View k(final int n) {
                return this.a.getChildAt(n);
            }
            
            @Override
            public void l(final View view) {
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(this.a);
                }
            }
            
            @Override
            public c0 m(final View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }
            
            @Override
            public void n(final int n) {
                final View k = this.k(n);
                if (k != null) {
                    final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(k);
                    if (childViewHolderInt != null) {
                        if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("called detach on an already detached child ");
                            sb.append(childViewHolderInt);
                            sb.append(this.a.exceptionLabel());
                            throw new IllegalArgumentException(sb.toString());
                        }
                        childViewHolderInt.addFlags(256);
                    }
                }
                RecyclerView.access$100(this.a, n);
            }
            
            @Override
            public void o() {
                for (int j = this.j(), i = 0; i < j; ++i) {
                    final View k = this.k(i);
                    this.a.dispatchChildDetached(k);
                    k.clearAnimation();
                }
                this.a.removeAllViews();
            }
            
            @Override
            public int p(final View view) {
                return this.a.indexOfChild(view);
            }
            
            @Override
            public void q(final View view) {
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(this.a);
                }
            }
            
            @Override
            public void r(final int n) {
                final View child = this.a.getChildAt(n);
                if (child != null) {
                    this.a.dispatchChildDetached(child);
                    child.clearAnimation();
                }
                this.a.removeViewAt(n);
            }
            
            @Override
            public void s(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Called attach on a child which is not detached: ");
                        sb.append(childViewHolderInt);
                        sb.append(this.a.exceptionLabel());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.access$000(this.a, view, n, viewGroup$LayoutParams);
            }
        });
    }
    
    private boolean isPreferredNextFocus(final View view, final View view2, final int n) {
        final boolean b = false;
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        final boolean b5 = false;
        final boolean b6 = false;
        boolean b7 = b5;
        if (view2 != null) {
            b7 = b5;
            if (view2 != this) {
                if (view2 == view) {
                    b7 = b5;
                }
                else {
                    if (this.findContainingItemView(view2) == null) {
                        return false;
                    }
                    if (view == null) {
                        return true;
                    }
                    if (this.findContainingItemView(view) == null) {
                        return true;
                    }
                    this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                    this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
                    this.offsetDescendantRectToMyCoords(view, this.mTempRect);
                    this.offsetDescendantRectToMyCoords(view2, this.mTempRect2);
                    final int layoutDirection = this.mLayout.getLayoutDirection();
                    int n2 = -1;
                    int n3;
                    if (layoutDirection == 1) {
                        n3 = -1;
                    }
                    else {
                        n3 = 1;
                    }
                    final Rect mTempRect = this.mTempRect;
                    final int left = mTempRect.left;
                    final Rect mTempRect2 = this.mTempRect2;
                    final int left2 = mTempRect2.left;
                    int n4;
                    if ((left < left2 || mTempRect.right <= left2) && mTempRect.right < mTempRect2.right) {
                        n4 = 1;
                    }
                    else {
                        final int right = mTempRect.right;
                        final int right2 = mTempRect2.right;
                        if ((right > right2 || left >= right2) && left > left2) {
                            n4 = -1;
                        }
                        else {
                            n4 = 0;
                        }
                    }
                    final int top = mTempRect.top;
                    final int top2 = mTempRect2.top;
                    if ((top < top2 || mTempRect.bottom <= top2) && mTempRect.bottom < mTempRect2.bottom) {
                        n2 = 1;
                    }
                    else {
                        final int bottom = mTempRect.bottom;
                        final int bottom2 = mTempRect2.bottom;
                        if ((bottom <= bottom2 && top < bottom2) || top <= top2) {
                            n2 = 0;
                        }
                    }
                    if (n != 1) {
                        if (n == 2) {
                            if (n2 <= 0) {
                                boolean b8 = b4;
                                if (n2 != 0) {
                                    return b8;
                                }
                                b8 = b4;
                                if (n4 * n3 <= 0) {
                                    return b8;
                                }
                            }
                            return true;
                        }
                        if (n == 17) {
                            boolean b9 = b3;
                            if (n4 < 0) {
                                b9 = true;
                            }
                            return b9;
                        }
                        if (n == 33) {
                            boolean b10 = b2;
                            if (n2 < 0) {
                                b10 = true;
                            }
                            return b10;
                        }
                        if (n == 66) {
                            boolean b11 = b;
                            if (n4 > 0) {
                                b11 = true;
                            }
                            return b11;
                        }
                        if (n == 130) {
                            boolean b12 = b6;
                            if (n2 > 0) {
                                b12 = true;
                            }
                            return b12;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid direction: ");
                        sb.append(n);
                        sb.append(this.exceptionLabel());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    else {
                        if (n2 >= 0) {
                            b7 = b5;
                            if (n2 != 0) {
                                return b7;
                            }
                            b7 = b5;
                            if (n4 * n3 >= 0) {
                                return b7;
                            }
                        }
                        b7 = true;
                    }
                }
            }
        }
        return b7;
    }
    
    private void nestedScrollByInternal(int n, int n2, final MotionEvent motionEvent, final int n3) {
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        final int[] mReusableIntPair = this.mReusableIntPair;
        final int n4 = 0;
        mReusableIntPair[1] = (mReusableIntPair[0] = 0);
        final int canScrollHorizontally = mLayout.canScrollHorizontally() ? 1 : 0;
        final boolean canScrollVertically = this.mLayout.canScrollVertically();
        int n5;
        if (canScrollVertically) {
            n5 = (canScrollHorizontally | 0x2);
        }
        else {
            n5 = canScrollHorizontally;
        }
        this.startNestedScroll(n5, n3);
        int n6;
        if (canScrollHorizontally != 0) {
            n6 = n;
        }
        else {
            n6 = 0;
        }
        int n7;
        if (canScrollVertically) {
            n7 = n2;
        }
        else {
            n7 = 0;
        }
        int n8 = n;
        int n9 = n2;
        if (this.dispatchNestedPreScroll(n6, n7, this.mReusableIntPair, this.mScrollOffset, n3)) {
            final int[] mReusableIntPair2 = this.mReusableIntPair;
            n8 = n - mReusableIntPair2[0];
            n9 = n2 - mReusableIntPair2[1];
        }
        if (canScrollHorizontally != 0) {
            n = n8;
        }
        else {
            n = 0;
        }
        n2 = n4;
        if (canScrollVertically) {
            n2 = n9;
        }
        this.scrollByInternal(n, n2, motionEvent, n3);
        final androidx.recyclerview.widget.l mGapWorker = this.mGapWorker;
        if (mGapWorker != null && (n8 != 0 || n9 != 0)) {
            mGapWorker.f(this, n8, n9);
        }
        this.stopNestedScroll(n3);
    }
    
    private void onPointerUp(final MotionEvent motionEvent) {
        final int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(n);
            final int n2 = (int)(motionEvent.getX(n) + 0.5f);
            this.mLastTouchX = n2;
            this.mInitialTouchX = n2;
            final int n3 = (int)(motionEvent.getY(n) + 0.5f);
            this.mLastTouchY = n3;
            this.mInitialTouchY = n3;
        }
    }
    
    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }
    
    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        }
        else {
            this.mAdapterHelper.j();
        }
        final boolean mItemsAddedOrRemoved = this.mItemsAddedOrRemoved;
        final boolean b = false;
        final boolean b2 = mItemsAddedOrRemoved || this.mItemsChanged;
        final z mState = this.mState;
        boolean k = false;
        Label_0145: {
            if (this.mFirstLayoutComplete && this.mItemAnimator != null) {
                final boolean mDataSetHasChangedAfterLayout = this.mDataSetHasChangedAfterLayout;
                if ((mDataSetHasChangedAfterLayout || b2 || this.mLayout.mRequestedSimpleAnimations) && (!mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds())) {
                    k = true;
                    break Label_0145;
                }
            }
            k = false;
        }
        mState.k = k;
        final z mState2 = this.mState;
        boolean l = b;
        if (mState2.k) {
            l = b;
            if (b2) {
                l = b;
                if (!this.mDataSetHasChangedAfterLayout) {
                    l = b;
                    if (this.predictiveItemAnimationsEnabled()) {
                        l = true;
                    }
                }
            }
        }
        mState2.l = l;
    }
    
    private void pullGlows(final float n, final float n2, final float n3, final float n4) {
        final int n5 = 1;
        int n6 = 0;
        Label_0080: {
            if (n2 < 0.0f) {
                this.ensureLeftGlow();
                androidx.core.widget.i.c(this.mLeftGlow, -n2 / this.getWidth(), 1.0f - n3 / this.getHeight());
            }
            else {
                if (n2 <= 0.0f) {
                    n6 = 0;
                    break Label_0080;
                }
                this.ensureRightGlow();
                androidx.core.widget.i.c(this.mRightGlow, n2 / this.getWidth(), n3 / this.getHeight());
            }
            n6 = 1;
        }
        if (n4 < 0.0f) {
            this.ensureTopGlow();
            androidx.core.widget.i.c(this.mTopGlow, -n4 / this.getHeight(), n / this.getWidth());
            n6 = n5;
        }
        else if (n4 > 0.0f) {
            this.ensureBottomGlow();
            androidx.core.widget.i.c(this.mBottomGlow, n4 / this.getHeight(), 1.0f - n / this.getWidth());
            n6 = n5;
        }
        if (n6 != 0 || n2 != 0.0f || n4 != 0.0f) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && this.hasFocus() && this.getDescendantFocusability() != 393216) {
            if (this.getDescendantFocusability() != 131072 || !this.isFocused()) {
                if (!this.isFocused()) {
                    final View focusedChild = this.getFocusedChild();
                    if (RecyclerView.IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.g() == 0) {
                            this.requestFocus();
                            return;
                        }
                    }
                    else if (!this.mChildHelper.n(focusedChild)) {
                        return;
                    }
                }
                final long n = this.mState.n;
                final View view = null;
                c0 viewHolderForItemId;
                if (n != -1L && this.mAdapter.hasStableIds()) {
                    viewHolderForItemId = this.findViewHolderForItemId(this.mState.n);
                }
                else {
                    viewHolderForItemId = null;
                }
                View view2;
                if (viewHolderForItemId != null && !this.mChildHelper.n(viewHolderForItemId.itemView) && viewHolderForItemId.itemView.hasFocusable()) {
                    view2 = viewHolderForItemId.itemView;
                }
                else {
                    view2 = view;
                    if (this.mChildHelper.g() > 0) {
                        view2 = this.findNextViewToFocus();
                    }
                }
                if (view2 != null) {
                    final int o = this.mState.o;
                    View view3 = view2;
                    if (o != -1L) {
                        final View viewById = view2.findViewById(o);
                        view3 = view2;
                        if (viewById != null) {
                            view3 = view2;
                            if (viewById.isFocusable()) {
                                view3 = viewById;
                            }
                        }
                    }
                    view3.requestFocus();
                }
            }
        }
    }
    
    private void releaseGlows() {
        final EdgeEffect mLeftGlow = this.mLeftGlow;
        int finished;
        if (mLeftGlow != null) {
            mLeftGlow.onRelease();
            finished = (this.mLeftGlow.isFinished() ? 1 : 0);
        }
        else {
            finished = 0;
        }
        final EdgeEffect mTopGlow = this.mTopGlow;
        int n = finished;
        if (mTopGlow != null) {
            mTopGlow.onRelease();
            n = (finished | (this.mTopGlow.isFinished() ? 1 : 0));
        }
        final EdgeEffect mRightGlow = this.mRightGlow;
        int n2 = n;
        if (mRightGlow != null) {
            mRightGlow.onRelease();
            n2 = (n | (this.mRightGlow.isFinished() ? 1 : 0));
        }
        final EdgeEffect mBottomGlow = this.mBottomGlow;
        int n3 = n2;
        if (mBottomGlow != null) {
            mBottomGlow.onRelease();
            n3 = (n2 | (this.mBottomGlow.isFinished() ? 1 : 0));
        }
        if (n3 != 0) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    private void requestChildOnScreen(final View view, final View view2) {
        View view3;
        if (view2 != null) {
            view3 = view2;
        }
        else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        final ViewGroup$LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            final p p2 = (p)layoutParams;
            if (!p2.c) {
                final Rect b = p2.b;
                final Rect mTempRect = this.mTempRect;
                mTempRect.left -= b.left;
                mTempRect.right += b.right;
                mTempRect.top -= b.top;
                mTempRect.bottom += b.bottom;
            }
        }
        if (view2 != null) {
            this.offsetDescendantRectToMyCoords(view2, this.mTempRect);
            this.offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, this.mFirstLayoutComplete ^ true, view2 == null);
    }
    
    private void resetFocusInfo() {
        final z mState = this.mState;
        mState.n = -1L;
        mState.m = -1;
        mState.o = -1;
    }
    
    private void resetScroll() {
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker != null) {
            mVelocityTracker.clear();
        }
        this.stopNestedScroll(0);
        this.releaseGlows();
    }
    
    private void saveFocusInfo() {
        final boolean mPreserveFocusAfterLayout = this.mPreserveFocusAfterLayout;
        final c0 c0 = null;
        View focusedChild;
        if (mPreserveFocusAfterLayout && this.hasFocus() && this.mAdapter != null) {
            focusedChild = this.getFocusedChild();
        }
        else {
            focusedChild = null;
        }
        c0 containingViewHolder;
        if (focusedChild == null) {
            containingViewHolder = c0;
        }
        else {
            containingViewHolder = this.findContainingViewHolder(focusedChild);
        }
        if (containingViewHolder == null) {
            this.resetFocusInfo();
        }
        else {
            final z mState = this.mState;
            long itemId;
            if (this.mAdapter.hasStableIds()) {
                itemId = containingViewHolder.getItemId();
            }
            else {
                itemId = -1L;
            }
            mState.n = itemId;
            final z mState2 = this.mState;
            int m;
            if (this.mDataSetHasChangedAfterLayout) {
                m = -1;
            }
            else if (containingViewHolder.isRemoved()) {
                m = containingViewHolder.mOldPosition;
            }
            else {
                m = containingViewHolder.getAbsoluteAdapterPosition();
            }
            mState2.m = m;
            this.mState.o = this.getDeepestFocusedViewWithId(containingViewHolder.itemView);
        }
    }
    
    private void setAdapterInternal(final Adapter mAdapter, final boolean b, final boolean b2) {
        final Adapter mAdapter2 = this.mAdapter;
        if (mAdapter2 != null) {
            mAdapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!b || b2) {
            this.removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        final Adapter mAdapter3 = this.mAdapter;
        if ((this.mAdapter = mAdapter) != null) {
            mAdapter.registerAdapterDataObserver(this.mObserver);
            mAdapter.onAttachedToRecyclerView(this);
        }
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.onAdapterChanged(mAdapter3, this.mAdapter);
        }
        this.mRecycler.x(mAdapter3, this.mAdapter, b);
        this.mState.g = true;
    }
    
    private void stopScrollersInternal() {
        this.mViewFlinger.f();
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.stopSmoothScroller();
        }
    }
    
    void absorbGlows(final int n, final int n2) {
        if (n < 0) {
            this.ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-n);
            }
        }
        else if (n > 0) {
            this.ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(n);
            }
        }
        if (n2 < 0) {
            this.ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-n2);
            }
        }
        else if (n2 > 0) {
            this.ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(n2);
            }
        }
        if (n != 0 || n2 != 0) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        final o mLayout = this.mLayout;
        if (mLayout == null || !mLayout.onAddFocusables(this, list, n, n2)) {
            super.addFocusables((ArrayList)list, n, n2);
        }
    }
    
    public void addItemDecoration(final n n) {
        this.addItemDecoration(n, -1);
    }
    
    public void addItemDecoration(final n n, final int n2) {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            this.setWillNotDraw(false);
        }
        if (n2 < 0) {
            this.mItemDecorations.add(n);
        }
        else {
            this.mItemDecorations.add(n2, n);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    public void addOnChildAttachStateChangeListener(final q q) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList<q>();
        }
        this.mOnChildAttachStateListeners.add(q);
    }
    
    public void addOnItemTouchListener(final s s) {
        this.mOnItemTouchListeners.add(s);
    }
    
    public void addOnScrollListener(final t t) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList<t>();
        }
        this.mScrollListeners.add(t);
    }
    
    public void addRecyclerListener(final w w) {
        androidx.core.util.h.b(w != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(w);
    }
    
    void animateAppearance(final c0 c0, final l.c c2, final l.c c3) {
        c0.setIsRecyclable(false);
        if (this.mItemAnimator.a(c0, c2, c3)) {
            this.postAnimationRunner();
        }
    }
    
    void animateDisappearance(final c0 c0, final l.c c2, final l.c c3) {
        this.addAnimatingView(c0);
        c0.setIsRecyclable(false);
        if (this.mItemAnimator.c(c0, c2, c3)) {
            this.postAnimationRunner();
        }
    }
    
    void assertInLayoutOrScroll(final String s) {
        if (this.isComputingLayout()) {
            return;
        }
        if (s == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            sb.append(this.exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append(this.exceptionLabel());
        throw new IllegalStateException(sb2.toString());
    }
    
    void assertNotInLayoutOrScroll(final String s) {
        if (!this.isComputingLayout()) {
            if (this.mDispatchScrollCounter > 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(this.exceptionLabel());
                Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", (Throwable)new IllegalStateException(sb.toString()));
            }
            return;
        }
        if (s == null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
            sb2.append(this.exceptionLabel());
            throw new IllegalStateException(sb2.toString());
        }
        throw new IllegalStateException(s);
    }
    
    boolean canReuseUpdatedViewHolder(final c0 c0) {
        final l mItemAnimator = this.mItemAnimator;
        return mItemAnimator == null || mItemAnimator.g(c0, c0.getUnmodifiedPayloads());
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof p && this.mLayout.checkLayoutParams((p)viewGroup$LayoutParams);
    }
    
    void clearOldPositions() {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }
    
    public void clearOnChildAttachStateChangeListeners() {
        final List<q> mOnChildAttachStateListeners = this.mOnChildAttachStateListeners;
        if (mOnChildAttachStateListeners != null) {
            mOnChildAttachStateListeners.clear();
        }
    }
    
    public void clearOnScrollListeners() {
        final List<t> mScrollListeners = this.mScrollListeners;
        if (mScrollListeners != null) {
            mScrollListeners.clear();
        }
    }
    
    public int computeHorizontalScrollExtent() {
        final o mLayout = this.mLayout;
        int computeHorizontalScrollExtent = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollHorizontally()) {
            computeHorizontalScrollExtent = this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return computeHorizontalScrollExtent;
    }
    
    public int computeHorizontalScrollOffset() {
        final o mLayout = this.mLayout;
        int computeHorizontalScrollOffset = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollHorizontally()) {
            computeHorizontalScrollOffset = this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return computeHorizontalScrollOffset;
    }
    
    public int computeHorizontalScrollRange() {
        final o mLayout = this.mLayout;
        int computeHorizontalScrollRange = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollHorizontally()) {
            computeHorizontalScrollRange = this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return computeHorizontalScrollRange;
    }
    
    public int computeVerticalScrollExtent() {
        final o mLayout = this.mLayout;
        int computeVerticalScrollExtent = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollVertically()) {
            computeVerticalScrollExtent = this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return computeVerticalScrollExtent;
    }
    
    public int computeVerticalScrollOffset() {
        final o mLayout = this.mLayout;
        int computeVerticalScrollOffset = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollVertically()) {
            computeVerticalScrollOffset = this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return computeVerticalScrollOffset;
    }
    
    public int computeVerticalScrollRange() {
        final o mLayout = this.mLayout;
        int computeVerticalScrollRange = 0;
        if (mLayout == null) {
            return 0;
        }
        if (mLayout.canScrollVertically()) {
            computeVerticalScrollRange = this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return computeVerticalScrollRange;
    }
    
    void considerReleasingGlowsOnScroll(final int n, final int n2) {
        final EdgeEffect mLeftGlow = this.mLeftGlow;
        int finished;
        if (mLeftGlow != null && !mLeftGlow.isFinished() && n > 0) {
            this.mLeftGlow.onRelease();
            finished = (this.mLeftGlow.isFinished() ? 1 : 0);
        }
        else {
            finished = 0;
        }
        final EdgeEffect mRightGlow = this.mRightGlow;
        int n3 = finished;
        if (mRightGlow != null) {
            n3 = finished;
            if (!mRightGlow.isFinished()) {
                n3 = finished;
                if (n < 0) {
                    this.mRightGlow.onRelease();
                    n3 = (finished | (this.mRightGlow.isFinished() ? 1 : 0));
                }
            }
        }
        final EdgeEffect mTopGlow = this.mTopGlow;
        int n4 = n3;
        if (mTopGlow != null) {
            n4 = n3;
            if (!mTopGlow.isFinished()) {
                n4 = n3;
                if (n2 > 0) {
                    this.mTopGlow.onRelease();
                    n4 = (n3 | (this.mTopGlow.isFinished() ? 1 : 0));
                }
            }
        }
        final EdgeEffect mBottomGlow = this.mBottomGlow;
        int n5 = n4;
        if (mBottomGlow != null) {
            n5 = n4;
            if (!mBottomGlow.isFinished()) {
                n5 = n4;
                if (n2 < 0) {
                    this.mBottomGlow.onRelease();
                    n5 = (n4 | (this.mBottomGlow.isFinished() ? 1 : 0));
                }
            }
        }
        if (n5 != 0) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.l.a("RV FullInvalidate");
            this.dispatchLayout();
            androidx.core.os.l.b();
            return;
        }
        if (!this.mAdapterHelper.p()) {
            return;
        }
        if (this.mAdapterHelper.o(4) && !this.mAdapterHelper.o(11)) {
            androidx.core.os.l.a("RV PartialInvalidate");
            this.startInterceptRequestLayout();
            this.onEnterLayoutOrScroll();
            this.mAdapterHelper.w();
            if (!this.mLayoutWasDefered) {
                if (this.hasUpdatedView()) {
                    this.dispatchLayout();
                }
                else {
                    this.mAdapterHelper.i();
                }
            }
            this.stopInterceptRequestLayout(true);
            this.onExitLayoutOrScroll();
            androidx.core.os.l.b();
        }
        else if (this.mAdapterHelper.p()) {
            androidx.core.os.l.a("RV FullInvalidate");
            this.dispatchLayout();
            androidx.core.os.l.b();
        }
    }
    
    void defaultOnMeasure(final int n, final int n2) {
        this.setMeasuredDimension(o.chooseSize(n, this.getPaddingLeft() + this.getPaddingRight(), androidx.core.view.b0.D((View)this)), o.chooseSize(n2, this.getPaddingTop() + this.getPaddingBottom(), androidx.core.view.b0.C((View)this)));
    }
    
    void dispatchChildAttached(final View view) {
        final c0 childViewHolderInt = getChildViewHolderInt(view);
        this.onChildAttachedToWindow(view);
        final Adapter mAdapter = this.mAdapter;
        if (mAdapter != null && childViewHolderInt != null) {
            mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        final List<q> mOnChildAttachStateListeners = this.mOnChildAttachStateListeners;
        if (mOnChildAttachStateListeners != null) {
            for (int i = mOnChildAttachStateListeners.size() - 1; i >= 0; --i) {
                this.mOnChildAttachStateListeners.get(i).b(view);
            }
        }
    }
    
    void dispatchChildDetached(final View view) {
        final c0 childViewHolderInt = getChildViewHolderInt(view);
        this.onChildDetachedFromWindow(view);
        final Adapter mAdapter = this.mAdapter;
        if (mAdapter != null && childViewHolderInt != null) {
            mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        final List<q> mOnChildAttachStateListeners = this.mOnChildAttachStateListeners;
        if (mOnChildAttachStateListeners != null) {
            for (int i = mOnChildAttachStateListeners.size() - 1; i >= 0; --i) {
                this.mOnChildAttachStateListeners.get(i).a(view);
            }
        }
    }
    
    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.mState.j = false;
        final boolean b = this.mLastAutoMeasureSkippedDueToExact && (this.mLastAutoMeasureNonExactMeasuredWidth != this.getWidth() || this.mLastAutoMeasureNonExactMeasuredHeight != this.getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.e == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        else if (!this.mAdapterHelper.q() && !b && this.mLayout.getWidth() == this.getWidth() && this.mLayout.getHeight() == this.getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        this.dispatchLayoutStep3();
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.getScrollingChildHelper().a(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.getScrollingChildHelper().b(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return this.getScrollingChildHelper().c(n, n2, array, array2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2, final int n3) {
        return this.getScrollingChildHelper().d(n, n2, array, array2, n3);
    }
    
    public final void dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5, final int[] array2) {
        this.getScrollingChildHelper().e(n, n2, n3, n4, array, n5, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.getScrollingChildHelper().f(n, n2, n3, n4, array);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5) {
        return this.getScrollingChildHelper().g(n, n2, n3, n4, array, n5);
    }
    
    void dispatchOnScrollStateChanged(final int n) {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.onScrollStateChanged(n);
        }
        this.onScrollStateChanged(n);
        final t mScrollListener = this.mScrollListener;
        if (mScrollListener != null) {
            mScrollListener.onScrollStateChanged(this, n);
        }
        final List<t> mScrollListeners = this.mScrollListeners;
        if (mScrollListeners != null) {
            for (int i = mScrollListeners.size() - 1; i >= 0; --i) {
                this.mScrollListeners.get(i).onScrollStateChanged(this, n);
            }
        }
    }
    
    void dispatchOnScrolled(final int n, final int n2) {
        ++this.mDispatchScrollCounter;
        final int scrollX = this.getScrollX();
        final int scrollY = this.getScrollY();
        this.onScrollChanged(scrollX, scrollY, scrollX - n, scrollY - n2);
        this.onScrolled(n, n2);
        final t mScrollListener = this.mScrollListener;
        if (mScrollListener != null) {
            mScrollListener.onScrolled(this, n, n2);
        }
        final List<t> mScrollListeners = this.mScrollListeners;
        if (mScrollListeners != null) {
            for (int i = mScrollListeners.size() - 1; i >= 0; --i) {
                this.mScrollListeners.get(i).onScrolled(this, n, n2);
            }
        }
        --this.mDispatchScrollCounter;
    }
    
    void dispatchPendingImportantForAccessibilityChanges() {
        for (int i = this.mPendingAccessibilityImportanceChange.size() - 1; i >= 0; --i) {
            final c0 c0 = this.mPendingAccessibilityImportanceChange.get(i);
            if (c0.itemView.getParent() == this) {
                if (!c0.shouldIgnore()) {
                    final int mPendingAccessibilityState = c0.mPendingAccessibilityState;
                    if (mPendingAccessibilityState != -1) {
                        androidx.core.view.b0.A0(c0.itemView, mPendingAccessibilityState);
                        c0.mPendingAccessibilityState = -1;
                    }
                }
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }
    
    protected void dispatchRestoreInstanceState(final SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly((SparseArray)sparseArray);
    }
    
    protected void dispatchSaveInstanceState(final SparseArray<Parcelable> sparseArray) {
        this.dispatchFreezeSelfOnly((SparseArray)sparseArray);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        final int size = this.mItemDecorations.size();
        final int n = false ? 1 : 0;
        for (int i = 0; i < size; ++i) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        final EdgeEffect mLeftGlow = this.mLeftGlow;
        final int n2 = 1;
        int n3;
        if (mLeftGlow != null && !mLeftGlow.isFinished()) {
            final int save = canvas.save();
            int paddingBottom;
            if (this.mClipToPadding) {
                paddingBottom = this.getPaddingBottom();
            }
            else {
                paddingBottom = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((float)(-this.getHeight() + paddingBottom), 0.0f);
            final EdgeEffect mLeftGlow2 = this.mLeftGlow;
            n3 = ((mLeftGlow2 != null && mLeftGlow2.draw(canvas)) ? 1 : 0);
            canvas.restoreToCount(save);
        }
        else {
            n3 = 0;
        }
        final EdgeEffect mTopGlow = this.mTopGlow;
        boolean b = n3 != 0;
        if (mTopGlow != null) {
            b = (n3 != 0);
            if (!mTopGlow.isFinished()) {
                final int save2 = canvas.save();
                if (this.mClipToPadding) {
                    canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
                }
                final EdgeEffect mTopGlow2 = this.mTopGlow;
                b = ((n3 | ((mTopGlow2 != null && mTopGlow2.draw(canvas)) ? 1 : 0)) != 0x0);
                canvas.restoreToCount(save2);
            }
        }
        final EdgeEffect mRightGlow = this.mRightGlow;
        boolean b2 = b;
        if (mRightGlow != null) {
            b2 = b;
            if (!mRightGlow.isFinished()) {
                final int save3 = canvas.save();
                final int width = this.getWidth();
                int paddingTop;
                if (this.mClipToPadding) {
                    paddingTop = this.getPaddingTop();
                }
                else {
                    paddingTop = 0;
                }
                canvas.rotate(90.0f);
                canvas.translate((float)paddingTop, (float)(-width));
                final EdgeEffect mRightGlow2 = this.mRightGlow;
                b2 = (b | (mRightGlow2 != null && mRightGlow2.draw(canvas)));
                canvas.restoreToCount(save3);
            }
        }
        final EdgeEffect mBottomGlow = this.mBottomGlow;
        int n4 = b2 ? 1 : 0;
        if (mBottomGlow != null) {
            n4 = (b2 ? 1 : 0);
            if (!mBottomGlow.isFinished()) {
                final int save4 = canvas.save();
                canvas.rotate(180.0f);
                if (this.mClipToPadding) {
                    canvas.translate((float)(-this.getWidth() + this.getPaddingRight()), (float)(-this.getHeight() + this.getPaddingBottom()));
                }
                else {
                    canvas.translate((float)(-this.getWidth()), (float)(-this.getHeight()));
                }
                final EdgeEffect mBottomGlow2 = this.mBottomGlow;
                int n5 = n;
                if (mBottomGlow2 != null) {
                    n5 = n;
                    if (mBottomGlow2.draw(canvas)) {
                        n5 = 1;
                    }
                }
                n4 = ((b2 ? 1 : 0) | n5);
                canvas.restoreToCount(save4);
            }
        }
        if (n4 == 0 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.p()) {
            n4 = n2;
        }
        if (n4 != 0) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    public boolean drawChild(final Canvas canvas, final View view, final long n) {
        return super.drawChild(canvas, view, n);
    }
    
    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        final EdgeEffect a = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a;
        if (this.mClipToPadding) {
            a.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
        }
        else {
            a.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }
    
    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        final EdgeEffect a = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a;
        if (this.mClipToPadding) {
            a.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
        }
        else {
            a.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
        }
    }
    
    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        final EdgeEffect a = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a;
        if (this.mClipToPadding) {
            a.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
        }
        else {
            a.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
        }
    }
    
    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        final EdgeEffect a = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a;
        if (this.mClipToPadding) {
            a.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
        }
        else {
            a.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }
    
    String exceptionLabel() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(super.toString());
        sb.append(", adapter:");
        sb.append(this.mAdapter);
        sb.append(", layout:");
        sb.append(this.mLayout);
        sb.append(", context:");
        sb.append(this.getContext());
        return sb.toString();
    }
    
    final void fillRemainingScrollValues(final z z) {
        if (this.getScrollState() == 2) {
            final OverScroller c = this.mViewFlinger.c;
            z.p = c.getFinalX() - c.getCurrX();
            z.q = c.getFinalY() - c.getCurrY();
        }
        else {
            z.p = 0;
            z.q = 0;
        }
    }
    
    public View findChildViewUnder(final float n, final float n2) {
        for (int i = this.mChildHelper.g() - 1; i >= 0; --i) {
            final View f = this.mChildHelper.f(i);
            final float translationX = f.getTranslationX();
            final float translationY = f.getTranslationY();
            if (n >= f.getLeft() + translationX && n <= f.getRight() + translationX && n2 >= f.getTop() + translationY && n2 <= f.getBottom() + translationY) {
                return f;
            }
        }
        return null;
    }
    
    public View findContainingItemView(View view) {
        ViewParent viewParent;
        for (viewParent = view.getParent(); viewParent != null && viewParent != this && viewParent instanceof View; viewParent = view.getParent()) {
            view = (View)viewParent;
        }
        if (viewParent != this) {
            view = null;
        }
        return view;
    }
    
    public c0 findContainingViewHolder(View containingItemView) {
        containingItemView = this.findContainingItemView(containingItemView);
        c0 childViewHolder;
        if (containingItemView == null) {
            childViewHolder = null;
        }
        else {
            childViewHolder = this.getChildViewHolder(containingItemView);
        }
        return childViewHolder;
    }
    
    public c0 findViewHolderForAdapterPosition(final int n) {
        final boolean mDataSetHasChangedAfterLayout = this.mDataSetHasChangedAfterLayout;
        c0 c0 = null;
        if (mDataSetHasChangedAfterLayout) {
            return null;
        }
        c0 c2;
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i, c0 = c2) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            c2 = c0;
            if (childViewHolderInt != null) {
                c2 = c0;
                if (!childViewHolderInt.isRemoved()) {
                    c2 = c0;
                    if (this.getAdapterPositionInRecyclerView(childViewHolderInt) == n) {
                        if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        c2 = childViewHolderInt;
                    }
                }
            }
        }
        return c0;
    }
    
    public c0 findViewHolderForItemId(final long n) {
        final Adapter mAdapter = this.mAdapter;
        final c0 c0 = null;
        c0 c2 = null;
        c0 c3 = c0;
        if (mAdapter != null) {
            if (!mAdapter.hasStableIds()) {
                c3 = c0;
            }
            else {
                final int j = this.mChildHelper.j();
                int n2 = 0;
                while (true) {
                    c3 = c2;
                    if (n2 >= j) {
                        break;
                    }
                    final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(n2));
                    c0 c4 = c2;
                    if (childViewHolderInt != null) {
                        c4 = c2;
                        if (!childViewHolderInt.isRemoved()) {
                            c4 = c2;
                            if (childViewHolderInt.getItemId() == n) {
                                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                                    return childViewHolderInt;
                                }
                                c4 = childViewHolderInt;
                            }
                        }
                    }
                    ++n2;
                    c2 = c4;
                }
            }
        }
        return c3;
    }
    
    public c0 findViewHolderForLayoutPosition(final int n) {
        return this.findViewHolderForPosition(n, false);
    }
    
    @Deprecated
    public c0 findViewHolderForPosition(final int n) {
        return this.findViewHolderForPosition(n, false);
    }
    
    c0 findViewHolderForPosition(final int n, final boolean b) {
        final int j = this.mChildHelper.j();
        c0 c0 = null;
        c0 c2;
        for (int i = 0; i < j; ++i, c0 = c2) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            c2 = c0;
            if (childViewHolderInt != null) {
                c2 = c0;
                if (!childViewHolderInt.isRemoved()) {
                    if (b) {
                        if (childViewHolderInt.mPosition != n) {
                            c2 = c0;
                            continue;
                        }
                    }
                    else if (childViewHolderInt.getLayoutPosition() != n) {
                        c2 = c0;
                        continue;
                    }
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    c2 = childViewHolderInt;
                }
            }
        }
        return c0;
    }
    
    public boolean fling(int max, int n) {
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        final int canScrollHorizontally = mLayout.canScrollHorizontally() ? 1 : 0;
        final boolean canScrollVertically = this.mLayout.canScrollVertically();
        int n2 = 0;
        Label_0069: {
            if (canScrollHorizontally != 0) {
                n2 = max;
                if (Math.abs(max) >= this.mMinFlingVelocity) {
                    break Label_0069;
                }
            }
            n2 = 0;
        }
        Label_0089: {
            if (canScrollVertically) {
                max = n;
                if (Math.abs(n) >= this.mMinFlingVelocity) {
                    break Label_0089;
                }
            }
            max = 0;
        }
        if (n2 == 0 && max == 0) {
            return false;
        }
        final float n3 = (float)n2;
        final float n4 = (float)max;
        if (!this.dispatchNestedPreFling(n3, n4)) {
            final boolean b = canScrollHorizontally != 0 || canScrollVertically;
            this.dispatchNestedFling(n3, n4, b);
            final r mOnFlingListener = this.mOnFlingListener;
            if (mOnFlingListener != null && mOnFlingListener.onFling(n2, max)) {
                return true;
            }
            if (b) {
                n = canScrollHorizontally;
                if (canScrollVertically) {
                    n = (canScrollHorizontally | 0x2);
                }
                this.startNestedScroll(n, 1);
                n = this.mMaxFlingVelocity;
                n = Math.max(-n, Math.min(n2, n));
                final int mMaxFlingVelocity = this.mMaxFlingVelocity;
                max = Math.max(-mMaxFlingVelocity, Math.min(max, mMaxFlingVelocity));
                this.mViewFlinger.b(n, max);
                return true;
            }
        }
        return false;
    }
    
    public View focusSearch(final View view, int n) {
        final View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, n);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        final Adapter mAdapter = this.mAdapter;
        final int n2 = 1;
        final boolean b = mAdapter != null && this.mLayout != null && !this.isComputingLayout() && !this.mLayoutSuppressed;
        final FocusFinder instance = FocusFinder.getInstance();
        View view2;
        if (b && (n == 2 || n == 1)) {
            int n4;
            if (this.mLayout.canScrollVertically()) {
                int n3;
                if (n == 2) {
                    n3 = 130;
                }
                else {
                    n3 = 33;
                }
                final boolean b2 = (n4 = ((instance.findNextFocus((ViewGroup)this, view, n3) == null) ? 1 : 0)) != 0;
                if (RecyclerView.FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    n = n3;
                    n4 = (b2 ? 1 : 0);
                }
            }
            else {
                n4 = 0;
            }
            int n5 = n4;
            int n6 = n;
            if (n4 == 0) {
                n5 = n4;
                n6 = n;
                if (this.mLayout.canScrollHorizontally()) {
                    int n7;
                    if (this.mLayout.getLayoutDirection() == 1 ^ n == 2) {
                        n7 = 66;
                    }
                    else {
                        n7 = 17;
                    }
                    int n8;
                    if (instance.findNextFocus((ViewGroup)this, view, n7) == null) {
                        n8 = n2;
                    }
                    else {
                        n8 = 0;
                    }
                    if (RecyclerView.FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                        n = n7;
                    }
                    n5 = n8;
                    n6 = n;
                }
            }
            if (n5 != 0) {
                this.consumePendingUpdateOperations();
                if (this.findContainingItemView(view) == null) {
                    return null;
                }
                this.startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, n6, this.mRecycler, this.mState);
                this.stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus((ViewGroup)this, view, n6);
            n = n6;
        }
        else {
            view2 = instance.findNextFocus((ViewGroup)this, view, n);
            if (view2 == null && b) {
                this.consumePendingUpdateOperations();
                if (this.findContainingItemView(view) == null) {
                    return null;
                }
                this.startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, n, this.mRecycler, this.mState);
                this.stopInterceptRequestLayout(false);
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            if (!this.isPreferredNextFocus(view, view2, n)) {
                view2 = super.focusSearch(view, n);
            }
            return view2;
        }
        if (this.getFocusedChild() == null) {
            return super.focusSearch(view, n);
        }
        this.requestChildOnScreen(view2, null);
        return view;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            return (ViewGroup$LayoutParams)mLayout.generateDefaultLayoutParams();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(this.exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            return (ViewGroup$LayoutParams)mLayout.generateLayoutParams(this.getContext(), set);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(this.exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            return (ViewGroup$LayoutParams)mLayout.generateLayoutParams(viewGroup$LayoutParams);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(this.exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }
    
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }
    
    public Adapter getAdapter() {
        return this.mAdapter;
    }
    
    int getAdapterPositionInRecyclerView(final c0 c0) {
        if (!c0.hasAnyOfTheFlags(524) && c0.isBound()) {
            return this.mAdapterHelper.e(c0.mPosition);
        }
        return -1;
    }
    
    public int getBaseline() {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            return mLayout.getBaseline();
        }
        return super.getBaseline();
    }
    
    long getChangedHolderKey(final c0 c0) {
        long itemId;
        if (this.mAdapter.hasStableIds()) {
            itemId = c0.getItemId();
        }
        else {
            itemId = c0.mPosition;
        }
        return itemId;
    }
    
    public int getChildAdapterPosition(final View view) {
        final c0 childViewHolderInt = getChildViewHolderInt(view);
        int absoluteAdapterPosition;
        if (childViewHolderInt != null) {
            absoluteAdapterPosition = childViewHolderInt.getAbsoluteAdapterPosition();
        }
        else {
            absoluteAdapterPosition = -1;
        }
        return absoluteAdapterPosition;
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        final j mChildDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (mChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(n, n2);
        }
        return mChildDrawingOrderCallback.a(n, n2);
    }
    
    public long getChildItemId(final View view) {
        final Adapter mAdapter = this.mAdapter;
        long itemId;
        final long n = itemId = -1L;
        if (mAdapter != null) {
            if (!mAdapter.hasStableIds()) {
                itemId = n;
            }
            else {
                final c0 childViewHolderInt = getChildViewHolderInt(view);
                itemId = n;
                if (childViewHolderInt != null) {
                    itemId = childViewHolderInt.getItemId();
                }
            }
        }
        return itemId;
    }
    
    public int getChildLayoutPosition(final View view) {
        final c0 childViewHolderInt = getChildViewHolderInt(view);
        int layoutPosition;
        if (childViewHolderInt != null) {
            layoutPosition = childViewHolderInt.getLayoutPosition();
        }
        else {
            layoutPosition = -1;
        }
        return layoutPosition;
    }
    
    @Deprecated
    public int getChildPosition(final View view) {
        return this.getChildAdapterPosition(view);
    }
    
    public c0 getChildViewHolder(final View view) {
        final ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            final StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a direct child of ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString());
        }
        return getChildViewHolderInt(view);
    }
    
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }
    
    public androidx.recyclerview.widget.u getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }
    
    public void getDecoratedBoundsWithMargins(final View view, final Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }
    
    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }
    
    public l getItemAnimator() {
        return this.mItemAnimator;
    }
    
    Rect getItemDecorInsetsForChild(final View view) {
        final p p = (p)view.getLayoutParams();
        if (!p.c) {
            return p.b;
        }
        if (this.mState.e() && (p.b() || p.d())) {
            return p.b;
        }
        final Rect b = p.b;
        b.set(0, 0, 0, 0);
        for (int size = this.mItemDecorations.size(), i = 0; i < size; ++i) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            final int left = b.left;
            final Rect mTempRect = this.mTempRect;
            b.left = left + mTempRect.left;
            b.top += mTempRect.top;
            b.right += mTempRect.right;
            b.bottom += mTempRect.bottom;
        }
        p.c = false;
        return b;
    }
    
    public n getItemDecorationAt(final int n) {
        final int itemDecorationCount = this.getItemDecorationCount();
        if (n >= 0 && n < itemDecorationCount) {
            return this.mItemDecorations.get(n);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(" is an invalid index for size ");
        sb.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(sb.toString());
    }
    
    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }
    
    public o getLayoutManager() {
        return this.mLayout;
    }
    
    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }
    
    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }
    
    long getNanoTime() {
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }
    
    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }
    
    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }
    
    public u getRecycledViewPool() {
        return this.mRecycler.i();
    }
    
    public int getScrollState() {
        return this.mScrollState;
    }
    
    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }
    
    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().k();
    }
    
    public boolean hasNestedScrollingParent(final int n) {
        return this.getScrollingChildHelper().l(n);
    }
    
    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }
    
    void initAdapterManager() {
        this.mAdapterHelper = new a((a.a)new a.a(this) {
            final RecyclerView a;
            
            @Override
            public void a(final int n, final int n2) {
                this.a.offsetPositionRecordsForMove(n, n2);
                this.a.mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void b(final b b) {
                this.i(b);
            }
            
            @Override
            public void c(final b b) {
                this.i(b);
            }
            
            @Override
            public void d(final int n, final int n2) {
                this.a.offsetPositionRecordsForRemove(n, n2, false);
                this.a.mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void e(final int n, final int n2, final Object o) {
                this.a.viewRangeUpdate(n, n2, o);
                this.a.mItemsChanged = true;
            }
            
            @Override
            public c0 f(final int n) {
                final c0 viewHolderForPosition = this.a.findViewHolderForPosition(n, true);
                if (viewHolderForPosition == null) {
                    return null;
                }
                if (this.a.mChildHelper.n(viewHolderForPosition.itemView)) {
                    return null;
                }
                return viewHolderForPosition;
            }
            
            @Override
            public void g(final int n, final int n2) {
                this.a.offsetPositionRecordsForInsert(n, n2);
                this.a.mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void h(final int n, final int n2) {
                this.a.offsetPositionRecordsForRemove(n, n2, true);
                final RecyclerView a = this.a;
                a.mItemsAddedOrRemoved = true;
                final z mState = a.mState;
                mState.d += n2;
            }
            
            void i(final b b) {
                final int a = b.a;
                if (a != 1) {
                    if (a != 2) {
                        if (a != 4) {
                            if (a == 8) {
                                final RecyclerView a2 = this.a;
                                a2.mLayout.onItemsMoved(a2, b.b, b.d, 1);
                            }
                        }
                        else {
                            final RecyclerView a3 = this.a;
                            a3.mLayout.onItemsUpdated(a3, b.b, b.d, b.c);
                        }
                    }
                    else {
                        final RecyclerView a4 = this.a;
                        a4.mLayout.onItemsRemoved(a4, b.b, b.d);
                    }
                }
                else {
                    final RecyclerView a5 = this.a;
                    a5.mLayout.onItemsAdded(a5, b.b, b.d);
                }
            }
        });
    }
    
    void initFastScroller(final StateListDrawable stateListDrawable, final Drawable drawable, final StateListDrawable stateListDrawable2, final Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            final Resources resources = this.getContext().getResources();
            new androidx.recyclerview.widget.k(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(r0.b.a), resources.getDimensionPixelSize(r0.b.c), resources.getDimensionPixelOffset(r0.b.b));
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Trying to set fast scroller without both required drawables.");
        sb.append(this.exceptionLabel());
        throw new IllegalArgumentException(sb.toString());
    }
    
    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }
    
    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    boolean isAccessibilityEnabled() {
        final AccessibilityManager mAccessibilityManager = this.mAccessibilityManager;
        return mAccessibilityManager != null && mAccessibilityManager.isEnabled();
    }
    
    public boolean isAnimating() {
        final l mItemAnimator = this.mItemAnimator;
        return mItemAnimator != null && mItemAnimator.p();
    }
    
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }
    
    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }
    
    @Deprecated
    public boolean isLayoutFrozen() {
        return this.isLayoutSuppressed();
    }
    
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().m();
    }
    
    void jumpToPositionForSmoothScroller(final int n) {
        if (this.mLayout == null) {
            return;
        }
        this.setScrollState(2);
        this.mLayout.scrollToPosition(n);
        this.awakenScrollBars();
    }
    
    void markItemDecorInsetsDirty() {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            ((p)this.mChildHelper.i(i).getLayoutParams()).c = true;
        }
        this.mRecycler.s();
    }
    
    void markKnownViewsInvalid() {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        this.markItemDecorInsetsDirty();
        this.mRecycler.t();
    }
    
    public void nestedScrollBy(final int n, final int n2) {
        this.nestedScrollByInternal(n, n2, null, 1);
    }
    
    public void offsetChildrenHorizontal(final int n) {
        for (int g = this.mChildHelper.g(), i = 0; i < g; ++i) {
            this.mChildHelper.f(i).offsetLeftAndRight(n);
        }
    }
    
    public void offsetChildrenVertical(final int n) {
        for (int g = this.mChildHelper.g(), i = 0; i < g; ++i) {
            this.mChildHelper.f(i).offsetTopAndBottom(n);
        }
    }
    
    void offsetPositionRecordsForInsert(final int n, final int n2) {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= n) {
                childViewHolderInt.offsetPosition(n2, false);
                this.mState.g = true;
            }
        }
        this.mRecycler.u(n, n2);
        this.requestLayout();
    }
    
    void offsetPositionRecordsForMove(final int n, final int n2) {
        final int j = this.mChildHelper.j();
        int n3;
        int n4;
        int n5;
        if (n < n2) {
            n3 = -1;
            n4 = n;
            n5 = n2;
        }
        else {
            n5 = n;
            n4 = n2;
            n3 = 1;
        }
        for (int i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (childViewHolderInt != null) {
                final int mPosition = childViewHolderInt.mPosition;
                if (mPosition >= n4) {
                    if (mPosition <= n5) {
                        if (mPosition == n) {
                            childViewHolderInt.offsetPosition(n2 - n, false);
                        }
                        else {
                            childViewHolderInt.offsetPosition(n3, false);
                        }
                        this.mState.g = true;
                    }
                }
            }
        }
        this.mRecycler.v(n, n2);
        this.requestLayout();
    }
    
    void offsetPositionRecordsForRemove(final int n, final int n2, final boolean b) {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                final int mPosition = childViewHolderInt.mPosition;
                if (mPosition >= n + n2) {
                    childViewHolderInt.offsetPosition(-n2, b);
                    this.mState.g = true;
                }
                else if (mPosition >= n) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(n - 1, -n2, b);
                    this.mState.g = true;
                }
            }
        }
        this.mRecycler.w(n, n2, b);
        this.requestLayout();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean mFirstLayoutComplete = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || this.isLayoutRequested()) {
            mFirstLayoutComplete = false;
        }
        this.mFirstLayoutComplete = mFirstLayoutComplete;
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            final ThreadLocal<androidx.recyclerview.widget.l> e = androidx.recyclerview.widget.l.e;
            if ((this.mGapWorker = e.get()) == null) {
                this.mGapWorker = new androidx.recyclerview.widget.l();
                final Display v = androidx.core.view.b0.v((View)this);
                float n2;
                final float n = n2 = 60.0f;
                if (!this.isInEditMode()) {
                    n2 = n;
                    if (v != null) {
                        final float refreshRate = v.getRefreshRate();
                        n2 = n;
                        if (refreshRate >= 30.0f) {
                            n2 = refreshRate;
                        }
                    }
                }
                final androidx.recyclerview.widget.l mGapWorker = this.mGapWorker;
                mGapWorker.c = (long)(1.0E9f / n2);
                e.set(mGapWorker);
            }
            this.mGapWorker.a(this);
        }
    }
    
    public void onChildAttachedToWindow(final View view) {
    }
    
    public void onChildDetachedFromWindow(final View view) {
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final l mItemAnimator = this.mItemAnimator;
        if (mItemAnimator != null) {
            mItemAnimator.k();
        }
        this.stopScroll();
        this.mIsAttached = false;
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        this.removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            final androidx.recyclerview.widget.l mGapWorker = this.mGapWorker;
            if (mGapWorker != null) {
                mGapWorker.j(this);
                this.mGapWorker = null;
            }
        }
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        for (int size = this.mItemDecorations.size(), i = 0; i < size; ++i) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }
    
    void onEnterLayoutOrScroll() {
        ++this.mLayoutOrScrollCounter;
    }
    
    void onExitLayoutOrScroll() {
        this.onExitLayoutOrScroll(true);
    }
    
    void onExitLayoutOrScroll(final boolean b) {
        final int mLayoutOrScrollCounter = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = mLayoutOrScrollCounter;
        if (mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (b) {
                this.dispatchContentChangedIfNecessary();
                this.dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        if (this.mLayout == null) {
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        if (motionEvent.getAction() == 8) {
            float n = 0.0f;
            float n3 = 0.0f;
            Label_0145: {
                float n2 = 0.0f;
                Label_0081: {
                    if ((motionEvent.getSource() & 0x2) == 0x0) {
                        if ((motionEvent.getSource() & 0x400000) != 0x0) {
                            n = motionEvent.getAxisValue(26);
                            if (this.mLayout.canScrollVertically()) {
                                n2 = -n;
                                break Label_0081;
                            }
                            if (this.mLayout.canScrollHorizontally()) {
                                n3 = 0.0f;
                                break Label_0145;
                            }
                        }
                        n3 = 0.0f;
                        n = 0.0f;
                        break Label_0145;
                    }
                    if (this.mLayout.canScrollVertically()) {
                        n3 = -motionEvent.getAxisValue(9);
                    }
                    else {
                        n3 = 0.0f;
                    }
                    n2 = n3;
                    if (this.mLayout.canScrollHorizontally()) {
                        n = motionEvent.getAxisValue(10);
                        break Label_0145;
                    }
                }
                final float n4 = 0.0f;
                n3 = n2;
                n = n4;
            }
            if (n3 != 0.0f || n != 0.0f) {
                this.nestedScrollByInternal((int)(n * this.mScaledHorizontalScrollFactor), (int)(n3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
            }
        }
        return false;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final boolean mLayoutSuppressed = this.mLayoutSuppressed;
        boolean b = false;
        if (mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (this.findInterceptingOnItemTouchListener(motionEvent)) {
            this.cancelScroll();
            return true;
        }
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            return false;
        }
        final int canScrollHorizontally = mLayout.canScrollHorizontally() ? 1 : 0;
        final boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        final int actionMasked = motionEvent.getActionMasked();
        final int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                this.onPointerUp(motionEvent);
                            }
                        }
                        else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            final int n = (int)(motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = n;
                            this.mInitialTouchX = n;
                            final int n2 = (int)(motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = n2;
                            this.mInitialTouchY = n2;
                        }
                    }
                    else {
                        this.cancelScroll();
                    }
                }
                else {
                    final int pointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (pointerIndex < 0) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Error processing scroll; pointer index for id ");
                        sb.append(this.mScrollPointerId);
                        sb.append(" not found. Did any MotionEvents get skipped?");
                        Log.e("RecyclerView", sb.toString());
                        return false;
                    }
                    final int mLastTouchX = (int)(motionEvent.getX(pointerIndex) + 0.5f);
                    final int mLastTouchY = (int)(motionEvent.getY(pointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        final int mInitialTouchX = this.mInitialTouchX;
                        final int mInitialTouchY = this.mInitialTouchY;
                        boolean b2;
                        if (canScrollHorizontally != 0 && Math.abs(mLastTouchX - mInitialTouchX) > this.mTouchSlop) {
                            this.mLastTouchX = mLastTouchX;
                            b2 = true;
                        }
                        else {
                            b2 = false;
                        }
                        boolean b3 = b2;
                        if (canScrollVertically) {
                            b3 = b2;
                            if (Math.abs(mLastTouchY - mInitialTouchY) > this.mTouchSlop) {
                                this.mLastTouchY = mLastTouchY;
                                b3 = true;
                            }
                        }
                        if (b3) {
                            this.setScrollState(1);
                        }
                    }
                }
            }
            else {
                this.mVelocityTracker.clear();
                this.stopNestedScroll(0);
            }
        }
        else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            final int n3 = (int)(motionEvent.getX() + 0.5f);
            this.mLastTouchX = n3;
            this.mInitialTouchX = n3;
            final int n4 = (int)(motionEvent.getY() + 0.5f);
            this.mLastTouchY = n4;
            this.mInitialTouchY = n4;
            if (this.mScrollState == 2) {
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.setScrollState(1);
                this.stopNestedScroll(1);
            }
            final int[] mNestedOffsets = this.mNestedOffsets;
            mNestedOffsets[mNestedOffsets[1] = 0] = 0;
            int n5 = canScrollHorizontally;
            if (canScrollVertically) {
                n5 = (canScrollHorizontally | 0x2);
            }
            this.startNestedScroll(n5, 0);
        }
        if (this.mScrollState == 1) {
            b = true;
        }
        return b;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        androidx.core.os.l.a("RV OnLayout");
        this.dispatchLayout();
        androidx.core.os.l.b();
        this.mFirstLayoutComplete = true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            this.defaultOnMeasure(n, n2);
            return;
        }
        final boolean autoMeasureEnabled = mLayout.isAutoMeasureEnabled();
        final boolean b = false;
        if (autoMeasureEnabled) {
            final int mode = View$MeasureSpec.getMode(n);
            final int mode2 = View$MeasureSpec.getMode(n2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
            boolean mLastAutoMeasureSkippedDueToExact = b;
            if (mode == 1073741824) {
                mLastAutoMeasureSkippedDueToExact = b;
                if (mode2 == 1073741824) {
                    mLastAutoMeasureSkippedDueToExact = true;
                }
            }
            if ((this.mLastAutoMeasureSkippedDueToExact = mLastAutoMeasureSkippedDueToExact) || this.mAdapter == null) {
                return;
            }
            if (this.mState.e == 1) {
                this.dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(n, n2);
            this.mState.j = true;
            this.dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(n, n2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824));
                this.mState.j = true;
                this.dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(n, n2);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = this.getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = this.getMeasuredHeight();
        }
        else {
            if (this.mHasFixedSize) {
                this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
                return;
            }
            if (this.mAdapterUpdateDuringMeasure) {
                this.startInterceptRequestLayout();
                this.onEnterLayoutOrScroll();
                this.processAdapterUpdatesAndSetAnimationFlags();
                this.onExitLayoutOrScroll();
                final z mState = this.mState;
                if (mState.l) {
                    mState.h = true;
                }
                else {
                    this.mAdapterHelper.j();
                    this.mState.h = false;
                }
                this.stopInterceptRequestLayout(this.mAdapterUpdateDuringMeasure = false);
            }
            else if (this.mState.l) {
                this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
                return;
            }
            final Adapter mAdapter = this.mAdapter;
            if (mAdapter != null) {
                this.mState.f = mAdapter.getItemCount();
            }
            else {
                this.mState.f = 0;
            }
            this.startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, n, n2);
            this.stopInterceptRequestLayout(false);
            this.mState.h = false;
        }
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        return !this.isComputingLayout() && super.onRequestFocusInDescendants(n, rect);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState mPendingSavedState = (SavedState)parcelable;
        this.mPendingSavedState = mPendingSavedState;
        super.onRestoreInstanceState(mPendingSavedState.a());
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        final SavedState mPendingSavedState = this.mPendingSavedState;
        if (mPendingSavedState != null) {
            savedState.b(mPendingSavedState);
        }
        else {
            final o mLayout = this.mLayout;
            if (mLayout != null) {
                savedState.c = mLayout.onSaveInstanceState();
            }
            else {
                savedState.c = null;
            }
        }
        return (Parcelable)savedState;
    }
    
    public void onScrollStateChanged(final int n) {
    }
    
    public void onScrolled(final int n, final int n2) {
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3 || n2 != n4) {
            this.invalidateGlows();
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final boolean mLayoutSuppressed = this.mLayoutSuppressed;
        final boolean b = false;
        if (mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (this.dispatchToOnItemTouchListeners(motionEvent)) {
            this.cancelScroll();
            return true;
        }
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            return false;
        }
        final int canScrollHorizontally = mLayout.canScrollHorizontally() ? 1 : 0;
        final boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        final int actionMasked = motionEvent.getActionMasked();
        final int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            final int[] mNestedOffsets = this.mNestedOffsets;
            mNestedOffsets[mNestedOffsets[1] = 0] = 0;
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        final int[] mNestedOffsets2 = this.mNestedOffsets;
        obtain.offsetLocation((float)mNestedOffsets2[0], (float)mNestedOffsets2[1]);
        int n = 0;
        Label_1030: {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked != 6) {
                                    n = (b ? 1 : 0);
                                }
                                else {
                                    this.onPointerUp(motionEvent);
                                    n = (b ? 1 : 0);
                                }
                            }
                            else {
                                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                                final int n2 = (int)(motionEvent.getX(actionIndex) + 0.5f);
                                this.mLastTouchX = n2;
                                this.mInitialTouchX = n2;
                                final int n3 = (int)(motionEvent.getY(actionIndex) + 0.5f);
                                this.mLastTouchY = n3;
                                this.mInitialTouchY = n3;
                                n = (b ? 1 : 0);
                            }
                        }
                        else {
                            this.cancelScroll();
                            n = (b ? 1 : 0);
                        }
                    }
                    else {
                        final int pointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                        if (pointerIndex < 0) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Error processing scroll; pointer index for id ");
                            sb.append(this.mScrollPointerId);
                            sb.append(" not found. Did any MotionEvents get skipped?");
                            Log.e("RecyclerView", sb.toString());
                            return false;
                        }
                        final int n4 = (int)(motionEvent.getX(pointerIndex) + 0.5f);
                        final int n5 = (int)(motionEvent.getY(pointerIndex) + 0.5f);
                        final int n6 = this.mLastTouchX - n4;
                        final int n7 = this.mLastTouchY - n5;
                        int n8 = n6;
                        int n9 = n7;
                        if (this.mScrollState != 1) {
                            int n10 = n6;
                            int n11 = 0;
                            boolean b2 = false;
                            Label_0459: {
                                if (canScrollHorizontally != 0) {
                                    if (n6 > 0) {
                                        n11 = Math.max(0, n6 - this.mTouchSlop);
                                    }
                                    else {
                                        n11 = Math.min(0, n6 + this.mTouchSlop);
                                    }
                                    n10 = n11;
                                    if (n11 != 0) {
                                        b2 = true;
                                        break Label_0459;
                                    }
                                }
                                b2 = false;
                                n11 = n10;
                            }
                            int n12 = n7;
                            boolean b3 = b2;
                            if (canScrollVertically) {
                                int n13;
                                if (n7 > 0) {
                                    n13 = Math.max(0, n7 - this.mTouchSlop);
                                }
                                else {
                                    n13 = Math.min(0, n7 + this.mTouchSlop);
                                }
                                n12 = n13;
                                b3 = b2;
                                if (n13 != 0) {
                                    b3 = true;
                                    n12 = n13;
                                }
                            }
                            n8 = n11;
                            n9 = n12;
                            if (b3) {
                                this.setScrollState(1);
                                n9 = n12;
                                n8 = n11;
                            }
                        }
                        final int n14 = n9;
                        n = (b ? 1 : 0);
                        if (this.mScrollState == 1) {
                            final int[] mReusableIntPair = this.mReusableIntPair;
                            mReusableIntPair[1] = (mReusableIntPair[0] = 0);
                            int n15;
                            if (canScrollHorizontally != 0) {
                                n15 = n8;
                            }
                            else {
                                n15 = 0;
                            }
                            int n16;
                            if (canScrollVertically) {
                                n16 = n14;
                            }
                            else {
                                n16 = 0;
                            }
                            int n17 = n8;
                            int n18 = n14;
                            if (this.dispatchNestedPreScroll(n15, n16, mReusableIntPair, this.mScrollOffset, 0)) {
                                final int[] mReusableIntPair2 = this.mReusableIntPair;
                                n17 = n8 - mReusableIntPair2[0];
                                n18 = n14 - mReusableIntPair2[1];
                                final int[] mNestedOffsets3 = this.mNestedOffsets;
                                final int n19 = mNestedOffsets3[0];
                                final int[] mScrollOffset = this.mScrollOffset;
                                mNestedOffsets3[0] = n19 + mScrollOffset[0];
                                mNestedOffsets3[1] += mScrollOffset[1];
                                this.getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            final int[] mScrollOffset2 = this.mScrollOffset;
                            this.mLastTouchX = n4 - mScrollOffset2[0];
                            this.mLastTouchY = n5 - mScrollOffset2[1];
                            int n20;
                            if (canScrollHorizontally != 0) {
                                n20 = n17;
                            }
                            else {
                                n20 = 0;
                            }
                            int n21;
                            if (canScrollVertically) {
                                n21 = n18;
                            }
                            else {
                                n21 = 0;
                            }
                            if (this.scrollByInternal(n20, n21, motionEvent, 0)) {
                                this.getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            final androidx.recyclerview.widget.l mGapWorker = this.mGapWorker;
                            n = (b ? 1 : 0);
                            if (mGapWorker != null) {
                                if (n17 == 0) {
                                    n = (b ? 1 : 0);
                                    if (n18 == 0) {
                                        break Label_1030;
                                    }
                                }
                                mGapWorker.f(this, n17, n18);
                                n = (b ? 1 : 0);
                            }
                        }
                    }
                }
                else {
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaxFlingVelocity);
                    float n22;
                    if (canScrollHorizontally != 0) {
                        n22 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
                    }
                    else {
                        n22 = 0.0f;
                    }
                    float n23;
                    if (canScrollVertically) {
                        n23 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
                    }
                    else {
                        n23 = 0.0f;
                    }
                    if ((n22 == 0.0f && n23 == 0.0f) || !this.fling((int)n22, (int)n23)) {
                        this.setScrollState(0);
                    }
                    this.resetScroll();
                    n = 1;
                }
            }
            else {
                this.mScrollPointerId = motionEvent.getPointerId(0);
                final int n24 = (int)(motionEvent.getX() + 0.5f);
                this.mLastTouchX = n24;
                this.mInitialTouchX = n24;
                final int n25 = (int)(motionEvent.getY() + 0.5f);
                this.mLastTouchY = n25;
                this.mInitialTouchY = n25;
                int n26 = canScrollHorizontally;
                if (canScrollVertically) {
                    n26 = (canScrollHorizontally | 0x2);
                }
                this.startNestedScroll(n26, 0);
                n = (b ? 1 : 0);
            }
        }
        if (n == 0) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }
    
    void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            androidx.core.view.b0.h0((View)this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }
    
    void processDataSetCompletelyChanged(final boolean b) {
        this.mDispatchItemsChangedEvent |= b;
        this.mDataSetHasChangedAfterLayout = true;
        this.markKnownViewsInvalid();
    }
    
    void recordAnimationInfoIfBouncedHiddenView(final c0 c0, final l.c c2) {
        c0.setFlags(0, 8192);
        if (this.mState.i && c0.isUpdated() && !c0.isRemoved() && !c0.shouldIgnore()) {
            this.mViewInfoStore.c(this.getChangedHolderKey(c0), c0);
        }
        this.mViewInfoStore.e(c0, c2);
    }
    
    void removeAndRecycleViews() {
        final l mItemAnimator = this.mItemAnimator;
        if (mItemAnimator != null) {
            mItemAnimator.k();
        }
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.c();
    }
    
    boolean removeAnimatingView(final View view) {
        this.startInterceptRequestLayout();
        final boolean r = this.mChildHelper.r(view);
        if (r) {
            final c0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.J(childViewHolderInt);
            this.mRecycler.C(childViewHolderInt);
        }
        this.stopInterceptRequestLayout(r ^ true);
        return r;
    }
    
    protected void removeDetachedView(final View view, final boolean b) {
        final c0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            }
            else if (!childViewHolderInt.shouldIgnore()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                sb.append(this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        view.clearAnimation();
        this.dispatchChildDetached(view);
        super.removeDetachedView(view, b);
    }
    
    public void removeItemDecoration(final n n) {
        final o mLayout = this.mLayout;
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(n);
        if (this.mItemDecorations.isEmpty()) {
            this.setWillNotDraw(this.getOverScrollMode() == 2);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    public void removeItemDecorationAt(final int n) {
        final int itemDecorationCount = this.getItemDecorationCount();
        if (n >= 0 && n < itemDecorationCount) {
            this.removeItemDecoration(this.getItemDecorationAt(n));
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(" is an invalid index for size ");
        sb.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(sb.toString());
    }
    
    public void removeOnChildAttachStateChangeListener(final q q) {
        final List<q> mOnChildAttachStateListeners = this.mOnChildAttachStateListeners;
        if (mOnChildAttachStateListeners == null) {
            return;
        }
        mOnChildAttachStateListeners.remove(q);
    }
    
    public void removeOnItemTouchListener(final s s) {
        this.mOnItemTouchListeners.remove(s);
        if (this.mInterceptingOnItemTouchListener == s) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }
    
    public void removeOnScrollListener(final t t) {
        final List<t> mScrollListeners = this.mScrollListeners;
        if (mScrollListeners != null) {
            mScrollListeners.remove(t);
        }
    }
    
    public void removeRecyclerListener(final w w) {
        this.mRecyclerListeners.remove(w);
    }
    
    void repositionShadowingViews() {
        for (int g = this.mChildHelper.g(), i = 0; i < g; ++i) {
            final View f = this.mChildHelper.f(i);
            final c0 childViewHolder = this.getChildViewHolder(f);
            if (childViewHolder != null) {
                final c0 mShadowingHolder = childViewHolder.mShadowingHolder;
                if (mShadowingHolder != null) {
                    final View itemView = mShadowingHolder.itemView;
                    final int left = f.getLeft();
                    final int top = f.getTop();
                    if (left != itemView.getLeft() || top != itemView.getTop()) {
                        itemView.layout(left, top, itemView.getWidth() + left, itemView.getHeight() + top);
                    }
                }
            }
        }
    }
    
    public void requestChildFocus(final View view, final View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            this.requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        for (int size = this.mOnItemTouchListeners.size(), i = 0; i < size; ++i) {
            this.mOnItemTouchListeners.get(i).c(b);
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        }
        else {
            this.mLayoutWasDefered = true;
        }
    }
    
    void saveOldPositions() {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }
    
    public void scrollBy(int n, int n2) {
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
        final boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                n = 0;
            }
            if (!canScrollVertically) {
                n2 = 0;
            }
            this.scrollByInternal(n, n2, null, 0);
        }
    }
    
    boolean scrollByInternal(final int n, final int n2, final MotionEvent motionEvent, int n3) {
        this.consumePendingUpdateOperations();
        final Adapter mAdapter = this.mAdapter;
        final boolean b = true;
        int n6;
        int n7;
        int n8;
        int n9;
        if (mAdapter != null) {
            final int[] mReusableIntPair = this.mReusableIntPair;
            mReusableIntPair[1] = (mReusableIntPair[0] = 0);
            this.scrollStep(n, n2, mReusableIntPair);
            final int[] mReusableIntPair2 = this.mReusableIntPair;
            final int n4 = mReusableIntPair2[0];
            final int n5 = n6 = mReusableIntPair2[1];
            n7 = n4;
            n8 = n - n4;
            n9 = n2 - n5;
        }
        else {
            final int n10 = 0;
            n7 = 0;
            n9 = (n8 = n7);
            n6 = n10;
        }
        if (!this.mItemDecorations.isEmpty()) {
            this.invalidate();
        }
        final int[] mReusableIntPair3 = this.mReusableIntPair;
        mReusableIntPair3[1] = (mReusableIntPair3[0] = 0);
        this.dispatchNestedScroll(n7, n6, n8, n9, this.mScrollOffset, n3, mReusableIntPair3);
        final int[] mReusableIntPair4 = this.mReusableIntPair;
        final int n11 = mReusableIntPair4[0];
        final int n12 = mReusableIntPair4[1];
        if (mReusableIntPair4[0] == 0 && mReusableIntPair4[1] == 0) {
            n3 = 0;
        }
        else {
            n3 = 1;
        }
        final int mLastTouchX = this.mLastTouchX;
        final int[] mScrollOffset = this.mScrollOffset;
        this.mLastTouchX = mLastTouchX - mScrollOffset[0];
        this.mLastTouchY -= mScrollOffset[1];
        final int[] mNestedOffsets = this.mNestedOffsets;
        mNestedOffsets[0] += mScrollOffset[0];
        mNestedOffsets[1] += mScrollOffset[1];
        if (this.getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.p.a(motionEvent, 8194)) {
                this.pullGlows(motionEvent.getX(), (float)(n8 - n11), motionEvent.getY(), (float)(n9 - n12));
            }
            this.considerReleasingGlowsOnScroll(n, n2);
        }
        if (n7 != 0 || n6 != 0) {
            this.dispatchOnScrolled(n7, n6);
        }
        if (!this.awakenScrollBars()) {
            this.invalidate();
        }
        boolean b2 = b;
        if (n3 == 0) {
            b2 = b;
            if (n7 == 0) {
                b2 = (n6 != 0 && b);
            }
        }
        return b2;
    }
    
    void scrollStep(int scrollHorizontallyBy, int scrollVerticallyBy, final int[] array) {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        androidx.core.os.l.a("RV Scroll");
        this.fillRemainingScrollValues(this.mState);
        if (scrollHorizontallyBy != 0) {
            scrollHorizontallyBy = this.mLayout.scrollHorizontallyBy(scrollHorizontallyBy, this.mRecycler, this.mState);
        }
        else {
            scrollHorizontallyBy = 0;
        }
        if (scrollVerticallyBy != 0) {
            scrollVerticallyBy = this.mLayout.scrollVerticallyBy(scrollVerticallyBy, this.mRecycler, this.mState);
        }
        else {
            scrollVerticallyBy = 0;
        }
        androidx.core.os.l.b();
        this.repositionShadowingViews();
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        if (array != null) {
            array[0] = scrollHorizontallyBy;
            array[1] = scrollVerticallyBy;
        }
    }
    
    public void scrollTo(final int n, final int n2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }
    
    public void scrollToPosition(final int n) {
        if (this.mLayoutSuppressed) {
            return;
        }
        this.stopScroll();
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        mLayout.scrollToPosition(n);
        this.awakenScrollBars();
    }
    
    public void sendAccessibilityEventUnchecked(final AccessibilityEvent accessibilityEvent) {
        if (this.shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }
    
    public void setAccessibilityDelegateCompat(final androidx.recyclerview.widget.u mAccessibilityDelegate) {
        androidx.core.view.b0.p0((View)this, this.mAccessibilityDelegate = mAccessibilityDelegate);
    }
    
    public void setAdapter(final Adapter adapter) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, false, true);
        this.processDataSetCompletelyChanged(false);
        this.requestLayout();
    }
    
    public void setChildDrawingOrderCallback(final j mChildDrawingOrderCallback) {
        if (mChildDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = mChildDrawingOrderCallback;
        this.setChildrenDrawingOrderEnabled(mChildDrawingOrderCallback != null);
    }
    
    boolean setChildImportantForAccessibilityInternal(final c0 c0, final int mPendingAccessibilityState) {
        if (this.isComputingLayout()) {
            c0.mPendingAccessibilityState = mPendingAccessibilityState;
            this.mPendingAccessibilityImportanceChange.add(c0);
            return false;
        }
        androidx.core.view.b0.A0(c0.itemView, mPendingAccessibilityState);
        return true;
    }
    
    public void setClipToPadding(final boolean mClipToPadding) {
        if (mClipToPadding != this.mClipToPadding) {
            this.invalidateGlows();
        }
        super.setClipToPadding(this.mClipToPadding = mClipToPadding);
        if (this.mFirstLayoutComplete) {
            this.requestLayout();
        }
    }
    
    public void setEdgeEffectFactory(final k mEdgeEffectFactory) {
        androidx.core.util.h.g(mEdgeEffectFactory);
        this.mEdgeEffectFactory = mEdgeEffectFactory;
        this.invalidateGlows();
    }
    
    public void setHasFixedSize(final boolean mHasFixedSize) {
        this.mHasFixedSize = mHasFixedSize;
    }
    
    public void setItemAnimator(final l mItemAnimator) {
        final l mItemAnimator2 = this.mItemAnimator;
        if (mItemAnimator2 != null) {
            mItemAnimator2.k();
            this.mItemAnimator.v(null);
        }
        if ((this.mItemAnimator = mItemAnimator) != null) {
            mItemAnimator.v(this.mItemAnimatorListener);
        }
    }
    
    public void setItemViewCacheSize(final int n) {
        this.mRecycler.G(n);
    }
    
    @Deprecated
    public void setLayoutFrozen(final boolean b) {
        this.suppressLayout(b);
    }
    
    public void setLayoutManager(final o mLayout) {
        if (mLayout == this.mLayout) {
            return;
        }
        this.stopScroll();
        if (this.mLayout != null) {
            final l mItemAnimator = this.mItemAnimator;
            if (mItemAnimator != null) {
                mItemAnimator.k();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        }
        else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = mLayout;
        if (mLayout != null) {
            if (mLayout.mRecyclerView != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("LayoutManager ");
                sb.append(mLayout);
                sb.append(" is already attached to a RecyclerView:");
                sb.append(mLayout.mRecyclerView.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.K();
        this.requestLayout();
    }
    
    @Deprecated
    public void setLayoutTransition(final LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition)null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }
    
    public void setNestedScrollingEnabled(final boolean b) {
        this.getScrollingChildHelper().n(b);
    }
    
    public void setOnFlingListener(final r mOnFlingListener) {
        this.mOnFlingListener = mOnFlingListener;
    }
    
    @Deprecated
    public void setOnScrollListener(final t mScrollListener) {
        this.mScrollListener = mScrollListener;
    }
    
    public void setPreserveFocusAfterLayout(final boolean mPreserveFocusAfterLayout) {
        this.mPreserveFocusAfterLayout = mPreserveFocusAfterLayout;
    }
    
    public void setRecycledViewPool(final u u) {
        this.mRecycler.E(u);
    }
    
    @Deprecated
    public void setRecyclerListener(final w mRecyclerListener) {
        this.mRecyclerListener = mRecyclerListener;
    }
    
    void setScrollState(final int mScrollState) {
        if (mScrollState == this.mScrollState) {
            return;
        }
        if ((this.mScrollState = mScrollState) != 2) {
            this.stopScrollersInternal();
        }
        this.dispatchOnScrollStateChanged(mScrollState);
    }
    
    public void setScrollingTouchSlop(final int n) {
        final ViewConfiguration value = ViewConfiguration.get(this.getContext());
        if (n != 0) {
            if (n == 1) {
                this.mTouchSlop = value.getScaledPagingTouchSlop();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("setScrollingTouchSlop(): bad argument constant ");
            sb.append(n);
            sb.append("; using default value");
            Log.w("RecyclerView", sb.toString());
        }
        this.mTouchSlop = value.getScaledTouchSlop();
    }
    
    public void setViewCacheExtension(final a0 a0) {
        this.mRecycler.F(a0);
    }
    
    boolean shouldDeferAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        final boolean computingLayout = this.isComputingLayout();
        final int n = 0;
        if (computingLayout) {
            int a;
            if (accessibilityEvent != null) {
                a = b.a(accessibilityEvent);
            }
            else {
                a = 0;
            }
            if (a == 0) {
                a = n;
            }
            this.mEatenAccessibilityChangeFlags |= a;
            return true;
        }
        return false;
    }
    
    public void smoothScrollBy(final int n, final int n2) {
        this.smoothScrollBy(n, n2, null);
    }
    
    public void smoothScrollBy(final int n, final int n2, final Interpolator interpolator) {
        this.smoothScrollBy(n, n2, interpolator, Integer.MIN_VALUE);
    }
    
    public void smoothScrollBy(final int n, final int n2, final Interpolator interpolator, final int n3) {
        this.smoothScrollBy(n, n2, interpolator, n3, false);
    }
    
    void smoothScrollBy(int n, int n2, final Interpolator interpolator, final int n3, final boolean b) {
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
        final int n4 = 0;
        int n5 = n;
        if (!canScrollHorizontally) {
            n5 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            n2 = 0;
        }
        if (n5 != 0 || n2 != 0) {
            if (n3 != Integer.MIN_VALUE && n3 <= 0) {
                n = 0;
            }
            else {
                n = 1;
            }
            if (n != 0) {
                if (b) {
                    n = n4;
                    if (n5 != 0) {
                        n = 1;
                    }
                    int n6 = n;
                    if (n2 != 0) {
                        n6 = (n | 0x2);
                    }
                    this.startNestedScroll(n6, 1);
                }
                this.mViewFlinger.e(n5, n2, n3, interpolator);
            }
            else {
                this.scrollBy(n5, n2);
            }
        }
    }
    
    public void smoothScrollToPosition(final int n) {
        if (this.mLayoutSuppressed) {
            return;
        }
        final o mLayout = this.mLayout;
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        mLayout.smoothScrollToPosition(this, this.mState, n);
    }
    
    void startInterceptRequestLayout() {
        final int mInterceptRequestLayoutDepth = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = mInterceptRequestLayoutDepth;
        if (mInterceptRequestLayoutDepth == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }
    
    public boolean startNestedScroll(final int n) {
        return this.getScrollingChildHelper().p(n);
    }
    
    public boolean startNestedScroll(final int n, final int n2) {
        return this.getScrollingChildHelper().q(n, n2);
    }
    
    void stopInterceptRequestLayout(final boolean b) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!b && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (b && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                this.dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        --this.mInterceptRequestLayoutDepth;
    }
    
    public void stopNestedScroll() {
        this.getScrollingChildHelper().r();
    }
    
    public void stopNestedScroll(final int n) {
        this.getScrollingChildHelper().s(n);
    }
    
    public void stopScroll() {
        this.setScrollState(0);
        this.stopScrollersInternal();
    }
    
    public final void suppressLayout(final boolean b) {
        if (b != this.mLayoutSuppressed) {
            this.assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!b) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    this.requestLayout();
                }
                this.mLayoutWasDefered = false;
            }
            else {
                final long uptimeMillis = SystemClock.uptimeMillis();
                this.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                this.stopScroll();
            }
        }
    }
    
    public void swapAdapter(final Adapter adapter, final boolean b) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, true, b);
        this.processDataSetCompletelyChanged(true);
        this.requestLayout();
    }
    
    void viewRangeUpdate(final int n, final int n2, final Object o) {
        for (int j = this.mChildHelper.j(), i = 0; i < j; ++i) {
            final View k = this.mChildHelper.i(i);
            final c0 childViewHolderInt = getChildViewHolderInt(k);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.shouldIgnore()) {
                    final int mPosition = childViewHolderInt.mPosition;
                    if (mPosition >= n && mPosition < n + n2) {
                        childViewHolderInt.addFlags(2);
                        childViewHolderInt.addChangePayload(o);
                        ((p)k.getLayoutParams()).c = true;
                    }
                }
            }
        }
        this.mRecycler.M(n, n2);
    }
    
    public abstract static class Adapter<VH extends c0>
    {
        private boolean mHasStableIds;
        private final h mObservable;
        private StateRestorationPolicy mStateRestorationPolicy;
        
        public Adapter() {
            this.mObservable = new h();
            this.mHasStableIds = false;
            this.mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
        }
        
        public final void bindViewHolder(final VH vh, final int mPosition) {
            final boolean b = vh.mBindingAdapter == null;
            if (b) {
                vh.mPosition = mPosition;
                if (this.hasStableIds()) {
                    vh.mItemId = this.getItemId(mPosition);
                }
                vh.setFlags(1, 519);
                androidx.core.os.l.a("RV OnBindView");
            }
            (vh.mBindingAdapter = (Adapter<? extends c0>)this).onBindViewHolder((c0)vh, mPosition, vh.getUnmodifiedPayloads());
            if (b) {
                vh.clearPayload();
                final ViewGroup$LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof p) {
                    ((p)layoutParams).c = true;
                }
                androidx.core.os.l.b();
            }
        }
        
        boolean canRestoreState() {
            final int n = RecyclerView$g.a[this.mStateRestorationPolicy.ordinal()];
            boolean b = false;
            if (n != 1) {
                if (n != 2) {
                    return true;
                }
                b = b;
                if (this.getItemCount() > 0) {
                    b = true;
                }
            }
            return b;
        }
        
        public final VH createViewHolder(final ViewGroup viewGroup, final int mItemViewType) {
            try {
                androidx.core.os.l.a("RV CreateView");
                final c0 onCreateViewHolder = this.onCreateViewHolder(viewGroup, mItemViewType);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = mItemViewType;
                    return (VH)onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            finally {
                androidx.core.os.l.b();
            }
        }
        
        public int findRelativeAdapterPositionIn(final Adapter<? extends c0> adapter, final c0 c0, final int n) {
            if (adapter == this) {
                return n;
            }
            return -1;
        }
        
        public abstract int getItemCount();
        
        public long getItemId(final int n) {
            return -1L;
        }
        
        public int getItemViewType(final int n) {
            return 0;
        }
        
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }
        
        public final boolean hasObservers() {
            return this.mObservable.a();
        }
        
        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }
        
        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }
        
        public final void notifyItemChanged(final int n) {
            this.mObservable.d(n, 1);
        }
        
        public final void notifyItemChanged(final int n, final Object o) {
            this.mObservable.e(n, 1, o);
        }
        
        public final void notifyItemInserted(final int n) {
            this.mObservable.f(n, 1);
        }
        
        public final void notifyItemMoved(final int n, final int n2) {
            this.mObservable.c(n, n2);
        }
        
        public final void notifyItemRangeChanged(final int n, final int n2) {
            this.mObservable.d(n, n2);
        }
        
        public final void notifyItemRangeChanged(final int n, final int n2, final Object o) {
            this.mObservable.e(n, n2, o);
        }
        
        public final void notifyItemRangeInserted(final int n, final int n2) {
            this.mObservable.f(n, n2);
        }
        
        public final void notifyItemRangeRemoved(final int n, final int n2) {
            this.mObservable.g(n, n2);
        }
        
        public final void notifyItemRemoved(final int n) {
            this.mObservable.g(n, 1);
        }
        
        public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        }
        
        public abstract void onBindViewHolder(final VH p0, final int p1);
        
        public void onBindViewHolder(final VH vh, final int n, final List<Object> list) {
            this.onBindViewHolder(vh, n);
        }
        
        public abstract VH onCreateViewHolder(final ViewGroup p0, final int p1);
        
        public void onDetachedFromRecyclerView(final RecyclerView recyclerView) {
        }
        
        public boolean onFailedToRecycleView(final VH vh) {
            return false;
        }
        
        public void onViewAttachedToWindow(final VH vh) {
        }
        
        public void onViewDetachedFromWindow(final VH vh) {
        }
        
        public void onViewRecycled(final VH vh) {
        }
        
        public void registerAdapterDataObserver(final i i) {
            this.mObservable.registerObserver((Object)i);
        }
        
        public void setHasStableIds(final boolean mHasStableIds) {
            if (!this.hasObservers()) {
                this.mHasStableIds = mHasStableIds;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        
        public void setStateRestorationPolicy(final StateRestorationPolicy mStateRestorationPolicy) {
            this.mStateRestorationPolicy = mStateRestorationPolicy;
            this.mObservable.h();
        }
        
        public void unregisterAdapterDataObserver(final i i) {
            this.mObservable.unregisterObserver((Object)i);
        }
        
        public enum StateRestorationPolicy
        {
            private static final StateRestorationPolicy[] $VALUES;
            
            ALLOW, 
            PREVENT, 
            PREVENT_WHEN_EMPTY;
        }
    }
    
    public static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        Parcelable c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        SavedState(final Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = o.class.getClassLoader();
            }
            this.c = parcel.readParcelable(classLoader);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        void b(final SavedState savedState) {
            this.c = savedState.c;
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeParcelable(this.c, 0);
        }
    }
    
    public abstract static class a0
    {
    }
    
    class b0 implements Runnable
    {
        private int a;
        private int b;
        OverScroller c;
        Interpolator d;
        private boolean e;
        private boolean f;
        final RecyclerView g;
        
        b0(final RecyclerView g) {
            this.g = g;
            final Interpolator sQuinticInterpolator = RecyclerView.sQuinticInterpolator;
            this.d = sQuinticInterpolator;
            this.e = false;
            this.f = false;
            this.c = new OverScroller(g.getContext(), sQuinticInterpolator);
        }
        
        private int a(int n, int n2) {
            final int abs = Math.abs(n);
            final int abs2 = Math.abs(n2);
            if (abs > abs2) {
                n = 1;
            }
            else {
                n = 0;
            }
            final RecyclerView g = this.g;
            if (n != 0) {
                n2 = g.getWidth();
            }
            else {
                n2 = g.getHeight();
            }
            if (n != 0) {
                n = abs;
            }
            else {
                n = abs2;
            }
            return Math.min((int)((n / (float)n2 + 1.0f) * 300.0f), 2000);
        }
        
        private void c() {
            this.g.removeCallbacks((Runnable)this);
            androidx.core.view.b0.h0((View)this.g, this);
        }
        
        public void b(final int n, final int n2) {
            this.g.setScrollState(2);
            this.b = 0;
            this.a = 0;
            final Interpolator d = this.d;
            final Interpolator sQuinticInterpolator = RecyclerView.sQuinticInterpolator;
            if (d != sQuinticInterpolator) {
                this.d = sQuinticInterpolator;
                this.c = new OverScroller(this.g.getContext(), sQuinticInterpolator);
            }
            this.c.fling(0, 0, n, n2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            this.d();
        }
        
        void d() {
            if (this.e) {
                this.f = true;
            }
            else {
                this.c();
            }
        }
        
        public void e(final int n, final int n2, final int n3, final Interpolator interpolator) {
            int a = n3;
            if (n3 == Integer.MIN_VALUE) {
                a = this.a(n, n2);
            }
            Interpolator sQuinticInterpolator;
            if ((sQuinticInterpolator = interpolator) == null) {
                sQuinticInterpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.d != sQuinticInterpolator) {
                this.d = sQuinticInterpolator;
                this.c = new OverScroller(this.g.getContext(), sQuinticInterpolator);
            }
            this.b = 0;
            this.a = 0;
            this.g.setScrollState(2);
            this.c.startScroll(0, 0, n, n2, a);
            this.d();
        }
        
        public void f() {
            this.g.removeCallbacks((Runnable)this);
            this.c.abortAnimation();
        }
        
        @Override
        public void run() {
            final RecyclerView g = this.g;
            if (g.mLayout == null) {
                this.f();
                return;
            }
            this.f = false;
            this.e = true;
            g.consumePendingUpdateOperations();
            final OverScroller c = this.c;
            if (c.computeScrollOffset()) {
                final int currX = c.getCurrX();
                final int currY = c.getCurrY();
                final int n = currX - this.a;
                final int n2 = currY - this.b;
                this.a = currX;
                this.b = currY;
                final RecyclerView g2 = this.g;
                final int[] mReusableIntPair = g2.mReusableIntPair;
                mReusableIntPair[1] = (mReusableIntPair[0] = 0);
                int n3 = n;
                int n4 = n2;
                if (g2.dispatchNestedPreScroll(n, n2, mReusableIntPair, null, 1)) {
                    final int[] mReusableIntPair2 = this.g.mReusableIntPair;
                    n3 = n - mReusableIntPair2[0];
                    n4 = n2 - mReusableIntPair2[1];
                }
                if (this.g.getOverScrollMode() != 2) {
                    this.g.considerReleasingGlowsOnScroll(n3, n4);
                }
                final RecyclerView g3 = this.g;
                int n9;
                int n10;
                int n11;
                if (g3.mAdapter != null) {
                    final int[] mReusableIntPair3 = g3.mReusableIntPair;
                    mReusableIntPair3[1] = (mReusableIntPair3[0] = 0);
                    g3.scrollStep(n3, n4, mReusableIntPair3);
                    final RecyclerView g4 = this.g;
                    final int[] mReusableIntPair4 = g4.mReusableIntPair;
                    final int n5 = mReusableIntPair4[0];
                    final int n6 = mReusableIntPair4[1];
                    final int n7 = n3 - n5;
                    final int n8 = n4 - n6;
                    final y mSmoothScroller = g4.mLayout.mSmoothScroller;
                    n3 = n7;
                    n9 = n6;
                    n10 = n5;
                    n11 = n8;
                    if (mSmoothScroller != null) {
                        n3 = n7;
                        n9 = n6;
                        n10 = n5;
                        n11 = n8;
                        if (!mSmoothScroller.isPendingInitialRun()) {
                            n3 = n7;
                            n9 = n6;
                            n10 = n5;
                            n11 = n8;
                            if (mSmoothScroller.isRunning()) {
                                final int b = this.g.mState.b();
                                if (b == 0) {
                                    mSmoothScroller.stop();
                                    n3 = n7;
                                    n9 = n6;
                                    n10 = n5;
                                    n11 = n8;
                                }
                                else if (mSmoothScroller.getTargetPosition() >= b) {
                                    mSmoothScroller.setTargetPosition(b - 1);
                                    mSmoothScroller.onAnimation(n5, n6);
                                    n3 = n7;
                                    n9 = n6;
                                    n10 = n5;
                                    n11 = n8;
                                }
                                else {
                                    mSmoothScroller.onAnimation(n5, n6);
                                    n3 = n7;
                                    n9 = n6;
                                    n10 = n5;
                                    n11 = n8;
                                }
                            }
                        }
                    }
                }
                else {
                    n9 = 0;
                    final int n12 = 0;
                    n11 = n4;
                    n10 = n12;
                }
                if (!this.g.mItemDecorations.isEmpty()) {
                    this.g.invalidate();
                }
                final RecyclerView g5 = this.g;
                final int[] mReusableIntPair5 = g5.mReusableIntPair;
                mReusableIntPair5[1] = (mReusableIntPair5[0] = 0);
                g5.dispatchNestedScroll(n10, n9, n3, n11, null, 1, mReusableIntPair5);
                final RecyclerView g6 = this.g;
                final int[] mReusableIntPair6 = g6.mReusableIntPair;
                final int n13 = n3 - mReusableIntPair6[0];
                final int n14 = n11 - mReusableIntPair6[1];
                if (n10 != 0 || n9 != 0) {
                    g6.dispatchOnScrolled(n10, n9);
                }
                if (!RecyclerView.access$200(this.g)) {
                    this.g.invalidate();
                }
                final boolean b2 = c.getCurrX() == c.getFinalX();
                final boolean b3 = c.getCurrY() == c.getFinalY();
                boolean b4 = false;
                Label_0631: {
                    Label_0629: {
                        if (!c.isFinished()) {
                            if (b2 || n13 != 0) {
                                if (b3) {
                                    break Label_0629;
                                }
                                if (n14 != 0) {
                                    break Label_0629;
                                }
                            }
                            b4 = false;
                            break Label_0631;
                        }
                    }
                    b4 = true;
                }
                final y mSmoothScroller2 = this.g.mLayout.mSmoothScroller;
                if ((mSmoothScroller2 == null || !mSmoothScroller2.isPendingInitialRun()) && b4) {
                    if (this.g.getOverScrollMode() != 2) {
                        int n15 = (int)c.getCurrVelocity();
                        int n16;
                        if (n13 < 0) {
                            n16 = -n15;
                        }
                        else if (n13 > 0) {
                            n16 = n15;
                        }
                        else {
                            n16 = 0;
                        }
                        if (n14 < 0) {
                            n15 = -n15;
                        }
                        else if (n14 <= 0) {
                            n15 = 0;
                        }
                        this.g.absorbGlows(n16, n15);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        this.g.mPrefetchRegistry.b();
                    }
                }
                else {
                    this.d();
                    final RecyclerView g7 = this.g;
                    final androidx.recyclerview.widget.l mGapWorker = g7.mGapWorker;
                    if (mGapWorker != null) {
                        mGapWorker.f(g7, n10, n9);
                    }
                }
            }
            final y mSmoothScroller3 = this.g.mLayout.mSmoothScroller;
            if (mSmoothScroller3 != null && mSmoothScroller3.isPendingInitialRun()) {
                mSmoothScroller3.onAnimation(0, 0);
            }
            this.e = false;
            if (this.f) {
                this.c();
            }
            else {
                this.g.setScrollState(0);
                this.g.stopNestedScroll(1);
            }
        }
    }
    
    public abstract static class c0
    {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends c0> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        v mScrapContainer;
        c0 mShadowedHolder;
        c0 mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;
        
        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }
        
        public c0(final View itemView) {
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if (itemView != null) {
                this.itemView = itemView;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }
        
        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                final ArrayList mPayloads = new ArrayList();
                this.mPayloads = mPayloads;
                this.mUnmodifiedPayloads = Collections.unmodifiableList((List<?>)mPayloads);
            }
        }
        
        void addChangePayload(final Object o) {
            if (o == null) {
                this.addFlags(1024);
            }
            else if ((0x400 & this.mFlags) == 0x0) {
                this.createPayloadsIfNeeded();
                this.mPayloads.add(o);
            }
        }
        
        void addFlags(final int n) {
            this.mFlags |= n;
        }
        
        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }
        
        void clearPayload() {
            final List<Object> mPayloads = this.mPayloads;
            if (mPayloads != null) {
                mPayloads.clear();
            }
            this.mFlags &= 0xFFFFFBFF;
        }
        
        void clearReturnedFromScrapFlag() {
            this.mFlags &= 0xFFFFFFDF;
        }
        
        void clearTmpDetachFlag() {
            this.mFlags &= 0xFFFFFEFF;
        }
        
        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 0x10) == 0x0 && androidx.core.view.b0.Q(this.itemView);
        }
        
        void flagRemovedAndOffsetPosition(final int mPosition, final int n, final boolean b) {
            this.addFlags(8);
            this.offsetPosition(n, b);
            this.mPosition = mPosition;
        }
        
        public final int getAbsoluteAdapterPosition() {
            final RecyclerView mOwnerRecyclerView = this.mOwnerRecyclerView;
            if (mOwnerRecyclerView == null) {
                return -1;
            }
            return mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
        }
        
        @Deprecated
        public final int getAdapterPosition() {
            return this.getBindingAdapterPosition();
        }
        
        public final Adapter<? extends c0> getBindingAdapter() {
            return this.mBindingAdapter;
        }
        
        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter == null) {
                return -1;
            }
            final RecyclerView mOwnerRecyclerView = this.mOwnerRecyclerView;
            if (mOwnerRecyclerView == null) {
                return -1;
            }
            final Adapter adapter = mOwnerRecyclerView.getAdapter();
            if (adapter == null) {
                return -1;
            }
            final int adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (adapterPositionInRecyclerView == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn((Adapter)this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }
        
        public final long getItemId() {
            return this.mItemId;
        }
        
        public final int getItemViewType() {
            return this.mItemViewType;
        }
        
        public final int getLayoutPosition() {
            int n;
            if ((n = this.mPreLayoutPosition) == -1) {
                n = this.mPosition;
            }
            return n;
        }
        
        public final int getOldPosition() {
            return this.mOldPosition;
        }
        
        @Deprecated
        public final int getPosition() {
            int n;
            if ((n = this.mPreLayoutPosition) == -1) {
                n = this.mPosition;
            }
            return n;
        }
        
        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 0x400) != 0x0) {
                return c0.FULLUPDATE_PAYLOADS;
            }
            final List<Object> mPayloads = this.mPayloads;
            if (mPayloads != null && mPayloads.size()) {
                return this.mUnmodifiedPayloads;
            }
            return c0.FULLUPDATE_PAYLOADS;
        }
        
        boolean hasAnyOfTheFlags(final int n) {
            return (n & this.mFlags) != 0x0;
        }
        
        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 0x200) != 0x0 || this.isInvalid();
        }
        
        boolean isAttachedToTransitionOverlay() {
            return this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView;
        }
        
        boolean isBound() {
            final int mFlags = this.mFlags;
            boolean b = true;
            if ((mFlags & 0x1) == 0x0) {
                b = false;
            }
            return b;
        }
        
        boolean isInvalid() {
            return (this.mFlags & 0x4) != 0x0;
        }
        
        public final boolean isRecyclable() {
            return (this.mFlags & 0x10) == 0x0 && !androidx.core.view.b0.Q(this.itemView);
        }
        
        boolean isRemoved() {
            return (this.mFlags & 0x8) != 0x0;
        }
        
        boolean isScrap() {
            return this.mScrapContainer != null;
        }
        
        boolean isTmpDetached() {
            return (this.mFlags & 0x100) != 0x0;
        }
        
        boolean isUpdated() {
            return (this.mFlags & 0x2) != 0x0;
        }
        
        boolean needsUpdate() {
            return (this.mFlags & 0x2) != 0x0;
        }
        
        void offsetPosition(final int n, final boolean b) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (b) {
                this.mPreLayoutPosition += n;
            }
            this.mPosition += n;
            if (this.itemView.getLayoutParams() != null) {
                ((p)this.itemView.getLayoutParams()).c = true;
            }
        }
        
        void onEnteredHiddenState(final RecyclerView recyclerView) {
            final int mPendingAccessibilityState = this.mPendingAccessibilityState;
            if (mPendingAccessibilityState != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = mPendingAccessibilityState;
            }
            else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.view.b0.z(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }
        
        void onLeftHiddenState(final RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }
        
        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }
        
        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }
        
        void setFlags(final int n, final int n2) {
            this.mFlags = ((n & n2) | (this.mFlags & ~n2));
        }
        
        public final void setIsRecyclable(final boolean b) {
            int mIsRecyclableCount = this.mIsRecyclableCount;
            if (b) {
                --mIsRecyclableCount;
            }
            else {
                ++mIsRecyclableCount;
            }
            this.mIsRecyclableCount = mIsRecyclableCount;
            if (mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = 0;
                final StringBuilder sb = new StringBuilder();
                sb.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb.append(this);
                Log.e("View", sb.toString());
            }
            else if (!b && mIsRecyclableCount == 1) {
                this.mFlags |= 0x10;
            }
            else if (b && mIsRecyclableCount == 0) {
                this.mFlags &= 0xFFFFFFEF;
            }
        }
        
        void setScrapContainer(final v mScrapContainer, final boolean mInChangeScrap) {
            this.mScrapContainer = mScrapContainer;
            this.mInChangeScrap = mInChangeScrap;
        }
        
        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 0x10) != 0x0;
        }
        
        boolean shouldIgnore() {
            return (this.mFlags & 0x80) != 0x0;
        }
        
        void stopIgnoring() {
            this.mFlags &= 0xFFFFFF7F;
        }
        
        @Override
        public String toString() {
            String simpleName;
            if (this.getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            }
            else {
                simpleName = this.getClass().getSimpleName();
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(simpleName);
            sb.append("{");
            sb.append(Integer.toHexString(this.hashCode()));
            sb.append(" position=");
            sb.append(this.mPosition);
            sb.append(" id=");
            sb.append(this.mItemId);
            sb.append(", oldPos=");
            sb.append(this.mOldPosition);
            sb.append(", pLpos:");
            sb.append(this.mPreLayoutPosition);
            final StringBuilder sb2 = new StringBuilder(sb.toString());
            if (this.isScrap()) {
                sb2.append(" scrap ");
                String s;
                if (this.mInChangeScrap) {
                    s = "[changeScrap]";
                }
                else {
                    s = "[attachedScrap]";
                }
                sb2.append(s);
            }
            if (this.isInvalid()) {
                sb2.append(" invalid");
            }
            if (!this.isBound()) {
                sb2.append(" unbound");
            }
            if (this.needsUpdate()) {
                sb2.append(" update");
            }
            if (this.isRemoved()) {
                sb2.append(" removed");
            }
            if (this.shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (this.isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!this.isRecyclable()) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(" not recyclable(");
                sb3.append(this.mIsRecyclableCount);
                sb3.append(")");
                sb2.append(sb3.toString());
            }
            if (this.isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }
        
        void unScrap() {
            this.mScrapContainer.J(this);
        }
        
        boolean wasReturnedFromScrap() {
            return (this.mFlags & 0x20) != 0x0;
        }
    }
    
    static class h extends Observable<i>
    {
        public boolean a() {
            return super.mObservers.isEmpty() ^ true;
        }
        
        public void b() {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onChanged();
            }
        }
        
        public void c(final int n, final int n2) {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onItemRangeMoved(n, n2, 1);
            }
        }
        
        public void d(final int n, final int n2) {
            this.e(n, n2, null);
        }
        
        public void e(final int n, final int n2, final Object o) {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onItemRangeChanged(n, n2, o);
            }
        }
        
        public void f(final int n, final int n2) {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onItemRangeInserted(n, n2);
            }
        }
        
        public void g(final int n, final int n2) {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onItemRangeRemoved(n, n2);
            }
        }
        
        public void h() {
            for (int i = super.mObservers.size() - 1; i >= 0; --i) {
                ((i)super.mObservers.get(i)).onStateRestorationPolicyChanged();
            }
        }
    }
    
    public abstract static class i
    {
        public void onChanged() {
        }
        
        public void onItemRangeChanged(final int n, final int n2) {
        }
        
        public void onItemRangeChanged(final int n, final int n2, final Object o) {
            this.onItemRangeChanged(n, n2);
        }
        
        public void onItemRangeInserted(final int n, final int n2) {
        }
        
        public void onItemRangeMoved(final int n, final int n2, final int n3) {
        }
        
        public void onItemRangeRemoved(final int n, final int n2) {
        }
        
        public void onStateRestorationPolicyChanged() {
        }
    }
    
    public interface j
    {
        int a(final int p0, final int p1);
    }
    
    public static class k
    {
        protected EdgeEffect a(final RecyclerView recyclerView, final int n) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }
    
    public abstract static class l
    {
        private b a;
        private ArrayList<a> b;
        private long c;
        private long d;
        private long e;
        private long f;
        
        public l() {
            this.a = null;
            this.b = new ArrayList<a>();
            this.c = 120L;
            this.d = 120L;
            this.e = 250L;
            this.f = 250L;
        }
        
        static int e(final c0 c0) {
            final int n = c0.mFlags & 0xE;
            if (c0.isInvalid()) {
                return 4;
            }
            int n2 = n;
            if ((n & 0x4) == 0x0) {
                final int oldPosition = c0.getOldPosition();
                final int absoluteAdapterPosition = c0.getAbsoluteAdapterPosition();
                n2 = n;
                if (oldPosition != -1) {
                    n2 = n;
                    if (absoluteAdapterPosition != -1) {
                        n2 = n;
                        if (oldPosition != absoluteAdapterPosition) {
                            n2 = (n | 0x800);
                        }
                    }
                }
            }
            return n2;
        }
        
        public abstract boolean a(final c0 p0, final c p1, final c p2);
        
        public abstract boolean b(final c0 p0, final c0 p1, final c p2, final c p3);
        
        public abstract boolean c(final c0 p0, final c p1, final c p2);
        
        public abstract boolean d(final c0 p0, final c p1, final c p2);
        
        public abstract boolean f(final c0 p0);
        
        public boolean g(final c0 c0, final List<Object> list) {
            return this.f(c0);
        }
        
        public final void h(final c0 c0) {
            this.r(c0);
            final b a = this.a;
            if (a != null) {
                a.a(c0);
            }
        }
        
        public final void i() {
            for (int size = this.b.size(), i = 0; i < size; ++i) {
                this.b.get(i).a();
            }
            this.b.clear();
        }
        
        public abstract void j(final c0 p0);
        
        public abstract void k();
        
        public long l() {
            return this.c;
        }
        
        public long m() {
            return this.f;
        }
        
        public long n() {
            return this.e;
        }
        
        public long o() {
            return this.d;
        }
        
        public abstract boolean p();
        
        public c q() {
            return new c();
        }
        
        public void r(final c0 c0) {
        }
        
        public c s(final z z, final c0 c0) {
            return this.q().a(c0);
        }
        
        public c t(final z z, final c0 c0, final int n, final List<Object> list) {
            return this.q().a(c0);
        }
        
        public abstract void u();
        
        void v(final b a) {
            this.a = a;
        }
        
        public interface a
        {
            void a();
        }
        
        interface b
        {
            void a(final c0 p0);
        }
        
        public static class c
        {
            public int a;
            public int b;
            public int c;
            public int d;
            
            public c a(final c0 c0) {
                return this.b(c0, 0);
            }
            
            public c b(final c0 c0, final int n) {
                final View itemView = c0.itemView;
                this.a = itemView.getLeft();
                this.b = itemView.getTop();
                this.c = itemView.getRight();
                this.d = itemView.getBottom();
                return this;
            }
        }
    }
    
    private class m implements b
    {
        final RecyclerView a;
        
        m(final RecyclerView a) {
            this.a = a;
        }
        
        @Override
        public void a(final c0 c0) {
            c0.setIsRecyclable(true);
            if (c0.mShadowedHolder != null && c0.mShadowingHolder == null) {
                c0.mShadowedHolder = null;
            }
            c0.mShadowingHolder = null;
            if (!c0.shouldBeKeptAsChild() && !this.a.removeAnimatingView(c0.itemView) && c0.isTmpDetached()) {
                this.a.removeDetachedView(c0.itemView, false);
            }
        }
    }
    
    public abstract static class n
    {
        @Deprecated
        public void getItemOffsets(final Rect rect, final int n, final RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }
        
        public void getItemOffsets(final Rect rect, final View view, final RecyclerView recyclerView, final z z) {
            this.getItemOffsets(rect, ((p)view.getLayoutParams()).a(), recyclerView);
        }
        
        @Deprecated
        public void onDraw(final Canvas canvas, final RecyclerView recyclerView) {
        }
        
        public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final z z) {
            this.onDraw(canvas, recyclerView);
        }
        
        @Deprecated
        public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView) {
        }
        
        public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final z z) {
            this.onDrawOver(canvas, recyclerView);
        }
    }
    
    public abstract static class o
    {
        boolean mAutoMeasure;
        f mChildHelper;
        private int mHeight;
        private int mHeightMode;
        androidx.recyclerview.widget.z mHorizontalBoundCheck;
        private final androidx.recyclerview.widget.z.b mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        y mSmoothScroller;
        androidx.recyclerview.widget.z mVerticalBoundCheck;
        private final androidx.recyclerview.widget.z.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;
        
        public o() {
            final androidx.recyclerview.widget.z.b mHorizontalBoundCheckCallback = new androidx.recyclerview.widget.z.b() {
                final o a;
                
                @Override
                public int a(final View view) {
                    return this.a.getDecoratedLeft(view) - ((p)view.getLayoutParams()).leftMargin;
                }
                
                @Override
                public int b() {
                    return this.a.getPaddingLeft();
                }
                
                @Override
                public int c() {
                    return this.a.getWidth() - this.a.getPaddingRight();
                }
                
                @Override
                public int d(final View view) {
                    return this.a.getDecoratedRight(view) + ((p)view.getLayoutParams()).rightMargin;
                }
                
                @Override
                public View k(final int n) {
                    return this.a.getChildAt(n);
                }
            };
            this.mHorizontalBoundCheckCallback = mHorizontalBoundCheckCallback;
            final androidx.recyclerview.widget.z.b mVerticalBoundCheckCallback = new androidx.recyclerview.widget.z.b() {
                final o a;
                
                @Override
                public int a(final View view) {
                    return this.a.getDecoratedTop(view) - ((p)view.getLayoutParams()).topMargin;
                }
                
                @Override
                public int b() {
                    return this.a.getPaddingTop();
                }
                
                @Override
                public int c() {
                    return this.a.getHeight() - this.a.getPaddingBottom();
                }
                
                @Override
                public int d(final View view) {
                    return this.a.getDecoratedBottom(view) + ((p)view.getLayoutParams()).bottomMargin;
                }
                
                @Override
                public View k(final int n) {
                    return this.a.getChildAt(n);
                }
            };
            this.mVerticalBoundCheckCallback = mVerticalBoundCheckCallback;
            this.mHorizontalBoundCheck = new androidx.recyclerview.widget.z((androidx.recyclerview.widget.z.b)mHorizontalBoundCheckCallback);
            this.mVerticalBoundCheck = new androidx.recyclerview.widget.z((androidx.recyclerview.widget.z.b)mVerticalBoundCheckCallback);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }
        
        private void addViewInt(final View view, final int n, final boolean b) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!b && !childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            else {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            }
            final p p3 = (p)view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.mRecyclerView) {
                    final int m = this.mChildHelper.m(view);
                    int g;
                    if ((g = n) == -1) {
                        g = this.mChildHelper.g();
                    }
                    if (m == -1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        sb.append(this.mRecyclerView.indexOfChild(view));
                        sb.append(this.mRecyclerView.exceptionLabel());
                        throw new IllegalStateException(sb.toString());
                    }
                    if (m != g) {
                        this.mRecyclerView.mLayout.moveView(m, g);
                    }
                }
                else {
                    this.mChildHelper.a(view, n, false);
                    p3.c = true;
                    final y mSmoothScroller = this.mSmoothScroller;
                    if (mSmoothScroller != null && mSmoothScroller.isRunning()) {
                        this.mSmoothScroller.onChildAttachedToWindow(view);
                    }
                }
            }
            else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                }
                else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.c(view, n, view.getLayoutParams(), false);
            }
            if (p3.d) {
                childViewHolderInt.itemView.invalidate();
                p3.d = false;
            }
        }
        
        public static int chooseSize(int n, final int n2, final int n3) {
            final int mode = View$MeasureSpec.getMode(n);
            n = View$MeasureSpec.getSize(n);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    n = Math.max(n2, n3);
                }
                return n;
            }
            return Math.min(n, Math.max(n2, n3));
        }
        
        private void detachViewInternal(final int n, final View view) {
            this.mChildHelper.d(n);
        }
        
        public static int getChildMeasureSpec(int max, int n, final int n2, int n3, final boolean b) {
            max = Math.max(0, max - n2);
            Label_0100: {
                Label_0059: {
                    if (b) {
                        if (n3 < 0) {
                            if (n3 != -1) {
                                break Label_0100;
                            }
                            if (n == Integer.MIN_VALUE) {
                                break Label_0059;
                            }
                            if (n == 0) {
                                break Label_0100;
                            }
                            if (n != 1073741824) {
                                break Label_0100;
                            }
                            break Label_0059;
                        }
                    }
                    else if (n3 < 0) {
                        if (n3 == -1) {
                            break Label_0059;
                        }
                        if (n3 != -2) {
                            break Label_0100;
                        }
                        if (n != Integer.MIN_VALUE && n != 1073741824) {
                            n = 0;
                            n3 = max;
                            return View$MeasureSpec.makeMeasureSpec(n3, n);
                        }
                        n = Integer.MIN_VALUE;
                        n3 = max;
                        return View$MeasureSpec.makeMeasureSpec(n3, n);
                    }
                    n = 1073741824;
                    return View$MeasureSpec.makeMeasureSpec(n3, n);
                }
                n3 = max;
                return View$MeasureSpec.makeMeasureSpec(n3, n);
            }
            n = 0;
            n3 = 0;
            return View$MeasureSpec.makeMeasureSpec(n3, n);
        }
        
        @Deprecated
        public static int getChildMeasureSpec(int max, int n, int n2, final boolean b) {
            final int n3 = 0;
            max = Math.max(0, max - n);
            Label_0034: {
                if (b) {
                    if (n2 >= 0) {
                        break Label_0034;
                    }
                }
                else {
                    if (n2 >= 0) {
                        break Label_0034;
                    }
                    if (n2 == -1) {
                        n2 = max;
                        break Label_0034;
                    }
                    if (n2 == -2) {
                        n = Integer.MIN_VALUE;
                        n2 = max;
                        max = n;
                        return View$MeasureSpec.makeMeasureSpec(n2, max);
                    }
                }
                n2 = 0;
                max = n3;
                return View$MeasureSpec.makeMeasureSpec(n2, max);
            }
            max = 1073741824;
            return View$MeasureSpec.makeMeasureSpec(n2, max);
        }
        
        private int[] getChildRectangleOnScreenScrollAmount(final View view, final Rect rect) {
            final int paddingLeft = this.getPaddingLeft();
            final int paddingTop = this.getPaddingTop();
            final int width = this.getWidth();
            final int paddingRight = this.getPaddingRight();
            final int height = this.getHeight();
            final int paddingBottom = this.getPaddingBottom();
            final int n = view.getLeft() + rect.left - view.getScrollX();
            final int n2 = view.getTop() + rect.top - view.getScrollY();
            final int width2 = rect.width();
            final int height2 = rect.height();
            final int n3 = n - paddingLeft;
            int n4 = Math.min(0, n3);
            final int n5 = n2 - paddingTop;
            int n6 = Math.min(0, n5);
            final int n7 = width2 + n - (width - paddingRight);
            final int max = Math.max(0, n7);
            final int max2 = Math.max(0, height2 + n2 - (height - paddingBottom));
            if (this.getLayoutDirection() == 1) {
                if (max != 0) {
                    n4 = max;
                }
                else {
                    n4 = Math.max(n4, n7);
                }
            }
            else if (n4 == 0) {
                n4 = Math.min(n3, max);
            }
            if (n6 == 0) {
                n6 = Math.min(n5, max2);
            }
            return new int[] { n4, n6 };
        }
        
        public static d getProperties(final Context context, final AttributeSet set, final int n, final int n2) {
            final d d = new d();
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, r0.c.f, n, n2);
            d.a = obtainStyledAttributes.getInt(r0.c.g, 1);
            d.b = obtainStyledAttributes.getInt(r0.c.q, 1);
            d.c = obtainStyledAttributes.getBoolean(r0.c.p, false);
            d.d = obtainStyledAttributes.getBoolean(r0.c.r, false);
            obtainStyledAttributes.recycle();
            return d;
        }
        
        private boolean isFocusedChildVisibleAfterScrolling(final RecyclerView recyclerView, final int n, final int n2) {
            final View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            final int paddingLeft = this.getPaddingLeft();
            final int paddingTop = this.getPaddingTop();
            final int width = this.getWidth();
            final int paddingRight = this.getPaddingRight();
            final int height = this.getHeight();
            final int paddingBottom = this.getPaddingBottom();
            final Rect mTempRect = this.mRecyclerView.mTempRect;
            this.getDecoratedBoundsWithMargins(focusedChild, mTempRect);
            return mTempRect.left - n < width - paddingRight && mTempRect.right - n > paddingLeft && mTempRect.top - n2 < height - paddingBottom && mTempRect.bottom - n2 > paddingTop;
        }
        
        private static boolean isMeasurementUpToDate(final int n, int size, final int n2) {
            final int mode = View$MeasureSpec.getMode(size);
            size = View$MeasureSpec.getSize(size);
            boolean b = false;
            final boolean b2 = false;
            if (n2 > 0 && n != n2) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                if (size >= n) {
                    b = true;
                }
                return b;
            }
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824) {
                return false;
            }
            boolean b3 = b2;
            if (size == n) {
                b3 = true;
            }
            return b3;
        }
        
        private void scrapOrRecycleView(final v v, final int n, final View view) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                this.removeViewAt(n);
                v.C(childViewHolderInt);
            }
            else {
                this.detachViewAt(n);
                v.D(view);
                this.mRecyclerView.mViewInfoStore.k(childViewHolderInt);
            }
        }
        
        public void addDisappearingView(final View view) {
            this.addDisappearingView(view, -1);
        }
        
        public void addDisappearingView(final View view, final int n) {
            this.addViewInt(view, n, true);
        }
        
        public void addView(final View view) {
            this.addView(view, -1);
        }
        
        public void addView(final View view, final int n) {
            this.addViewInt(view, n, false);
        }
        
        public void assertInLayoutOrScroll(final String s) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                mRecyclerView.assertInLayoutOrScroll(s);
            }
        }
        
        public void assertNotInLayoutOrScroll(final String s) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                mRecyclerView.assertNotInLayoutOrScroll(s);
            }
        }
        
        public void attachView(final View view) {
            this.attachView(view, -1);
        }
        
        public void attachView(final View view, final int n) {
            this.attachView(view, n, (p)view.getLayoutParams());
        }
        
        public void attachView(final View view, final int n, final p p3) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            }
            else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            this.mChildHelper.c(view, n, (ViewGroup$LayoutParams)p3, childViewHolderInt.isRemoved());
        }
        
        public void calculateItemDecorationsForChild(final View view, final Rect rect) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView == null) {
                rect.set(0, 0, 0, 0);
                return;
            }
            rect.set(mRecyclerView.getItemDecorInsetsForChild(view));
        }
        
        public boolean canScrollHorizontally() {
            return false;
        }
        
        public boolean canScrollVertically() {
            return false;
        }
        
        public boolean checkLayoutParams(final p p) {
            return p != null;
        }
        
        public void collectAdjacentPrefetchPositions(final int n, final int n2, final z z, final c c) {
        }
        
        public void collectInitialPrefetchPositions(final int n, final c c) {
        }
        
        public int computeHorizontalScrollExtent(final z z) {
            return 0;
        }
        
        public int computeHorizontalScrollOffset(final z z) {
            return 0;
        }
        
        public int computeHorizontalScrollRange(final z z) {
            return 0;
        }
        
        public int computeVerticalScrollExtent(final z z) {
            return 0;
        }
        
        public int computeVerticalScrollOffset(final z z) {
            return 0;
        }
        
        public int computeVerticalScrollRange(final z z) {
            return 0;
        }
        
        public void detachAndScrapAttachedViews(final v v) {
            for (int i = this.getChildCount() - 1; i >= 0; --i) {
                this.scrapOrRecycleView(v, i, this.getChildAt(i));
            }
        }
        
        public void detachAndScrapView(final View view, final v v) {
            this.scrapOrRecycleView(v, this.mChildHelper.m(view), view);
        }
        
        public void detachAndScrapViewAt(final int n, final v v) {
            this.scrapOrRecycleView(v, n, this.getChildAt(n));
        }
        
        public void detachView(final View view) {
            final int m = this.mChildHelper.m(view);
            if (m >= 0) {
                this.detachViewInternal(m, view);
            }
        }
        
        public void detachViewAt(final int n) {
            this.detachViewInternal(n, this.getChildAt(n));
        }
        
        void dispatchAttachedToWindow(final RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            this.onAttachedToWindow(recyclerView);
        }
        
        void dispatchDetachedFromWindow(final RecyclerView recyclerView, final v v) {
            this.mIsAttachedToWindow = false;
            this.onDetachedFromWindow(recyclerView, v);
        }
        
        public void endAnimation(final View view) {
            final l mItemAnimator = this.mRecyclerView.mItemAnimator;
            if (mItemAnimator != null) {
                mItemAnimator.j(RecyclerView.getChildViewHolderInt(view));
            }
        }
        
        public View findContainingItemView(View containingItemView) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView == null) {
                return null;
            }
            containingItemView = mRecyclerView.findContainingItemView(containingItemView);
            if (containingItemView == null) {
                return null;
            }
            if (this.mChildHelper.n(containingItemView)) {
                return null;
            }
            return containingItemView;
        }
        
        public View findViewByPosition(final int n) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(child);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.getLayoutPosition() == n && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.e() || !childViewHolderInt.isRemoved())) {
                        return child;
                    }
                }
            }
            return null;
        }
        
        public abstract p generateDefaultLayoutParams();
        
        public p generateLayoutParams(final Context context, final AttributeSet set) {
            return new p(context, set);
        }
        
        public p generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            if (viewGroup$LayoutParams instanceof p) {
                return new p((p)viewGroup$LayoutParams);
            }
            if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
                return new p((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
            }
            return new p(viewGroup$LayoutParams);
        }
        
        public int getBaseline() {
            return -1;
        }
        
        public int getBottomDecorationHeight(final View view) {
            return ((p)view.getLayoutParams()).b.bottom;
        }
        
        public View getChildAt(final int n) {
            final f mChildHelper = this.mChildHelper;
            View f;
            if (mChildHelper != null) {
                f = mChildHelper.f(n);
            }
            else {
                f = null;
            }
            return f;
        }
        
        public int getChildCount() {
            final f mChildHelper = this.mChildHelper;
            int g;
            if (mChildHelper != null) {
                g = mChildHelper.g();
            }
            else {
                g = 0;
            }
            return g;
        }
        
        public boolean getClipToPadding() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return mRecyclerView != null && mRecyclerView.mClipToPadding;
        }
        
        public int getColumnCountForAccessibility(final v v, final z z) {
            return -1;
        }
        
        public int getDecoratedBottom(final View view) {
            return view.getBottom() + this.getBottomDecorationHeight(view);
        }
        
        public void getDecoratedBoundsWithMargins(final View view, final Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }
        
        public int getDecoratedLeft(final View view) {
            return view.getLeft() - this.getLeftDecorationWidth(view);
        }
        
        public int getDecoratedMeasuredHeight(final View view) {
            final Rect b = ((p)view.getLayoutParams()).b;
            return view.getMeasuredHeight() + b.top + b.bottom;
        }
        
        public int getDecoratedMeasuredWidth(final View view) {
            final Rect b = ((p)view.getLayoutParams()).b;
            return view.getMeasuredWidth() + b.left + b.right;
        }
        
        public int getDecoratedRight(final View view) {
            return view.getRight() + this.getRightDecorationWidth(view);
        }
        
        public int getDecoratedTop(final View view) {
            return view.getTop() - this.getTopDecorationHeight(view);
        }
        
        public View getFocusedChild() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView == null) {
                return null;
            }
            final View focusedChild = mRecyclerView.getFocusedChild();
            if (focusedChild != null && !this.mChildHelper.n(focusedChild)) {
                return focusedChild;
            }
            return null;
        }
        
        public int getHeight() {
            return this.mHeight;
        }
        
        public int getHeightMode() {
            return this.mHeightMode;
        }
        
        public int getItemCount() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            Adapter adapter;
            if (mRecyclerView != null) {
                adapter = mRecyclerView.getAdapter();
            }
            else {
                adapter = null;
            }
            int itemCount;
            if (adapter != null) {
                itemCount = adapter.getItemCount();
            }
            else {
                itemCount = 0;
            }
            return itemCount;
        }
        
        public int getItemViewType(final View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }
        
        public int getLayoutDirection() {
            return androidx.core.view.b0.B((View)this.mRecyclerView);
        }
        
        public int getLeftDecorationWidth(final View view) {
            return ((p)view.getLayoutParams()).b.left;
        }
        
        public int getMinimumHeight() {
            return androidx.core.view.b0.C((View)this.mRecyclerView);
        }
        
        public int getMinimumWidth() {
            return androidx.core.view.b0.D((View)this.mRecyclerView);
        }
        
        public int getPaddingBottom() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int paddingBottom;
            if (mRecyclerView != null) {
                paddingBottom = mRecyclerView.getPaddingBottom();
            }
            else {
                paddingBottom = 0;
            }
            return paddingBottom;
        }
        
        public int getPaddingEnd() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int f;
            if (mRecyclerView != null) {
                f = androidx.core.view.b0.F((View)mRecyclerView);
            }
            else {
                f = 0;
            }
            return f;
        }
        
        public int getPaddingLeft() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int paddingLeft;
            if (mRecyclerView != null) {
                paddingLeft = mRecyclerView.getPaddingLeft();
            }
            else {
                paddingLeft = 0;
            }
            return paddingLeft;
        }
        
        public int getPaddingRight() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int paddingRight;
            if (mRecyclerView != null) {
                paddingRight = mRecyclerView.getPaddingRight();
            }
            else {
                paddingRight = 0;
            }
            return paddingRight;
        }
        
        public int getPaddingStart() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int g;
            if (mRecyclerView != null) {
                g = androidx.core.view.b0.G((View)mRecyclerView);
            }
            else {
                g = 0;
            }
            return g;
        }
        
        public int getPaddingTop() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            int paddingTop;
            if (mRecyclerView != null) {
                paddingTop = mRecyclerView.getPaddingTop();
            }
            else {
                paddingTop = 0;
            }
            return paddingTop;
        }
        
        public int getPosition(final View view) {
            return ((p)view.getLayoutParams()).a();
        }
        
        public int getRightDecorationWidth(final View view) {
            return ((p)view.getLayoutParams()).b.right;
        }
        
        public int getRowCountForAccessibility(final v v, final z z) {
            return -1;
        }
        
        public int getSelectionModeForAccessibility(final v v, final z z) {
            return 0;
        }
        
        public int getTopDecorationHeight(final View view) {
            return ((p)view.getLayoutParams()).b.top;
        }
        
        public void getTransformedBoundingBox(final View view, final boolean b, final Rect rect) {
            if (b) {
                final Rect b2 = ((p)view.getLayoutParams()).b;
                rect.set(-b2.left, -b2.top, view.getWidth() + b2.right, view.getHeight() + b2.bottom);
            }
            else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null) {
                final Matrix matrix = view.getMatrix();
                if (matrix != null && !matrix.isIdentity()) {
                    final RectF mTempRectF = this.mRecyclerView.mTempRectF;
                    mTempRectF.set(rect);
                    matrix.mapRect(mTempRectF);
                    rect.set((int)Math.floor(mTempRectF.left), (int)Math.floor(mTempRectF.top), (int)Math.ceil(mTempRectF.right), (int)Math.ceil(mTempRectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }
        
        public int getWidth() {
            return this.mWidth;
        }
        
        public int getWidthMode() {
            return this.mWidthMode;
        }
        
        boolean hasFlexibleChildInBothOrientations() {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final ViewGroup$LayoutParams layoutParams = this.getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
        
        public boolean hasFocus() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return mRecyclerView != null && mRecyclerView.hasFocus();
        }
        
        public void ignoreView(final View view) {
            final ViewParent parent = view.getParent();
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (parent == mRecyclerView && mRecyclerView.indexOfChild(view) != -1) {
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.q(childViewHolderInt);
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("View should be fully attached to be ignored");
            sb.append(this.mRecyclerView.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
        
        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }
        
        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }
        
        public boolean isFocused() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return mRecyclerView != null && mRecyclerView.isFocused();
        }
        
        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }
        
        public boolean isLayoutHierarchical(final v v, final z z) {
            return false;
        }
        
        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }
        
        public boolean isSmoothScrolling() {
            final y mSmoothScroller = this.mSmoothScroller;
            return mSmoothScroller != null && mSmoothScroller.isRunning();
        }
        
        public boolean isViewPartiallyVisible(final View view, final boolean b, final boolean b2) {
            final boolean b3 = this.mHorizontalBoundCheck.b(view, 24579) && this.mVerticalBoundCheck.b(view, 24579);
            if (b) {
                return b3;
            }
            return b3 ^ true;
        }
        
        public void layoutDecorated(final View view, final int n, final int n2, final int n3, final int n4) {
            final Rect b = ((p)view.getLayoutParams()).b;
            view.layout(n + b.left, n2 + b.top, n3 - b.right, n4 - b.bottom);
        }
        
        public void layoutDecoratedWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
            final p p5 = (p)view.getLayoutParams();
            final Rect b = p5.b;
            view.layout(n + b.left + p5.leftMargin, n2 + b.top + p5.topMargin, n3 - b.right - p5.rightMargin, n4 - b.bottom - p5.bottomMargin);
        }
        
        public void measureChild(final View view, int childMeasureSpec, int childMeasureSpec2) {
            final p p3 = (p)view.getLayoutParams();
            final Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            final int left = itemDecorInsetsForChild.left;
            final int right = itemDecorInsetsForChild.right;
            final int top = itemDecorInsetsForChild.top;
            final int bottom = itemDecorInsetsForChild.bottom;
            childMeasureSpec = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + (childMeasureSpec + (left + right)), p3.width, this.canScrollHorizontally());
            childMeasureSpec2 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + (childMeasureSpec2 + (top + bottom)), p3.height, this.canScrollVertically());
            if (this.shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, p3)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
        
        public void measureChildWithMargins(final View view, int childMeasureSpec, int childMeasureSpec2) {
            final p p3 = (p)view.getLayoutParams();
            final Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            final int left = itemDecorInsetsForChild.left;
            final int right = itemDecorInsetsForChild.right;
            final int top = itemDecorInsetsForChild.top;
            final int bottom = itemDecorInsetsForChild.bottom;
            childMeasureSpec = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + p3.leftMargin + p3.rightMargin + (childMeasureSpec + (left + right)), p3.width, this.canScrollHorizontally());
            childMeasureSpec2 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + p3.topMargin + p3.bottomMargin + (childMeasureSpec2 + (top + bottom)), p3.height, this.canScrollVertically());
            if (this.shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, p3)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
        
        public void moveView(final int n, final int n2) {
            final View child = this.getChildAt(n);
            if (child != null) {
                this.detachViewAt(n);
                this.attachView(child, n2);
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot move a child from non-existing index:");
            sb.append(n);
            sb.append(this.mRecyclerView.toString());
            throw new IllegalArgumentException(sb.toString());
        }
        
        public void offsetChildrenHorizontal(final int n) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                mRecyclerView.offsetChildrenHorizontal(n);
            }
        }
        
        public void offsetChildrenVertical(final int n) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                mRecyclerView.offsetChildrenVertical(n);
            }
        }
        
        public void onAdapterChanged(final Adapter adapter, final Adapter adapter2) {
        }
        
        public boolean onAddFocusables(final RecyclerView recyclerView, final ArrayList<View> list, final int n, final int n2) {
            return false;
        }
        
        public void onAttachedToWindow(final RecyclerView recyclerView) {
        }
        
        @Deprecated
        public void onDetachedFromWindow(final RecyclerView recyclerView) {
        }
        
        public void onDetachedFromWindow(final RecyclerView recyclerView, final v v) {
            this.onDetachedFromWindow(recyclerView);
        }
        
        public View onFocusSearchFailed(final View view, final int n, final v v, final z z) {
            return null;
        }
        
        public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            this.onInitializeAccessibilityEvent(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilityEvent);
        }
        
        public void onInitializeAccessibilityEvent(final v v, final z z, final AccessibilityEvent accessibilityEvent) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                if (accessibilityEvent != null) {
                    boolean scrollable;
                    final boolean b = scrollable = true;
                    if (!mRecyclerView.canScrollVertically(1)) {
                        scrollable = b;
                        if (!this.mRecyclerView.canScrollVertically(-1)) {
                            scrollable = b;
                            if (!this.mRecyclerView.canScrollHorizontally(-1)) {
                                scrollable = (this.mRecyclerView.canScrollHorizontally(1) && b);
                            }
                        }
                    }
                    accessibilityEvent.setScrollable(scrollable);
                    final Adapter mAdapter = this.mRecyclerView.mAdapter;
                    if (mAdapter != null) {
                        accessibilityEvent.setItemCount(mAdapter.getItemCount());
                    }
                }
            }
        }
        
        void onInitializeAccessibilityNodeInfo(final androidx.core.view.accessibility.d d) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            this.onInitializeAccessibilityNodeInfo(mRecyclerView.mRecycler, mRecyclerView.mState, d);
        }
        
        public void onInitializeAccessibilityNodeInfo(final v v, final z z, final androidx.core.view.accessibility.d d) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                d.a(8192);
                d.l0(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                d.a(4096);
                d.l0(true);
            }
            d.S(androidx.core.view.accessibility.d.b.a(this.getRowCountForAccessibility(v, z), this.getColumnCountForAccessibility(v, z), this.isLayoutHierarchical(v, z), this.getSelectionModeForAccessibility(v, z)));
        }
        
        void onInitializeAccessibilityNodeInfoForItem(final View view, final androidx.core.view.accessibility.d d) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.n(childViewHolderInt.itemView)) {
                final RecyclerView mRecyclerView = this.mRecyclerView;
                this.onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, d);
            }
        }
        
        public void onInitializeAccessibilityNodeInfoForItem(final v v, final z z, final View view, final androidx.core.view.accessibility.d d) {
        }
        
        public View onInterceptFocusSearch(final View view, final int n) {
            return null;
        }
        
        public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
        }
        
        public void onItemsChanged(final RecyclerView recyclerView) {
        }
        
        public void onItemsMoved(final RecyclerView recyclerView, final int n, final int n2, final int n3) {
        }
        
        public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
        }
        
        public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2) {
        }
        
        public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
            this.onItemsUpdated(recyclerView, n, n2);
        }
        
        public void onLayoutChildren(final v v, final z z) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }
        
        public void onLayoutCompleted(final z z) {
        }
        
        public void onMeasure(final v v, final z z, final int n, final int n2) {
            this.mRecyclerView.defaultOnMeasure(n, n2);
        }
        
        @Deprecated
        public boolean onRequestChildFocus(final RecyclerView recyclerView, final View view, final View view2) {
            return this.isSmoothScrolling() || recyclerView.isComputingLayout();
        }
        
        public boolean onRequestChildFocus(final RecyclerView recyclerView, final z z, final View view, final View view2) {
            return this.onRequestChildFocus(recyclerView, view, view2);
        }
        
        public void onRestoreInstanceState(final Parcelable parcelable) {
        }
        
        public Parcelable onSaveInstanceState() {
            return null;
        }
        
        public void onScrollStateChanged(final int n) {
        }
        
        void onSmoothScrollerStopped(final y y) {
            if (this.mSmoothScroller == y) {
                this.mSmoothScroller = null;
            }
        }
        
        boolean performAccessibilityAction(final int n, final Bundle bundle) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return this.performAccessibilityAction(mRecyclerView.mRecycler, mRecyclerView.mState, n, bundle);
        }
        
        public boolean performAccessibilityAction(final v v, final z z, int n, final Bundle bundle) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView == null) {
                return false;
            }
            int n2 = 0;
            Label_0169: {
                Label_0167: {
                    int n3;
                    if (n != 4096) {
                        if (n != 8192) {
                            n = 0;
                            n2 = 0;
                            break Label_0169;
                        }
                        if (mRecyclerView.canScrollVertically(-1)) {
                            n = -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
                        }
                        else {
                            n = 0;
                        }
                        n2 = n;
                        if (!this.mRecyclerView.canScrollHorizontally(-1)) {
                            break Label_0167;
                        }
                        n3 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
                    }
                    else {
                        if (mRecyclerView.canScrollVertically(1)) {
                            n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                        }
                        else {
                            n = 0;
                        }
                        n2 = n;
                        if (!this.mRecyclerView.canScrollHorizontally(1)) {
                            break Label_0167;
                        }
                        n3 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                    }
                    final int n4 = n;
                    n = n3;
                    n2 = n4;
                    break Label_0169;
                }
                n = 0;
            }
            if (n2 == 0 && n == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(n, n2, null, Integer.MIN_VALUE, true);
            return true;
        }
        
        boolean performAccessibilityActionForItem(final View view, final int n, final Bundle bundle) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return this.performAccessibilityActionForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, n, bundle);
        }
        
        public boolean performAccessibilityActionForItem(final v v, final z z, final View view, final int n, final Bundle bundle) {
            return false;
        }
        
        public void postOnAnimation(final Runnable runnable) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                androidx.core.view.b0.h0((View)mRecyclerView, runnable);
            }
        }
        
        public void removeAllViews() {
            for (int i = this.getChildCount() - 1; i >= 0; --i) {
                this.mChildHelper.q(i);
            }
        }
        
        public void removeAndRecycleAllViews(final v v) {
            for (int i = this.getChildCount() - 1; i >= 0; --i) {
                if (!RecyclerView.getChildViewHolderInt(this.getChildAt(i)).shouldIgnore()) {
                    this.removeAndRecycleViewAt(i, v);
                }
            }
        }
        
        void removeAndRecycleScrapInt(final v v) {
            final int j = v.j();
            for (int i = j - 1; i >= 0; --i) {
                final View n = v.n(i);
                final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(n);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(n, false);
                    }
                    final l mItemAnimator = this.mRecyclerView.mItemAnimator;
                    if (mItemAnimator != null) {
                        mItemAnimator.j(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    v.y(n);
                }
            }
            v.e();
            if (j > 0) {
                this.mRecyclerView.invalidate();
            }
        }
        
        public void removeAndRecycleView(final View view, final v v) {
            this.removeView(view);
            v.B(view);
        }
        
        public void removeAndRecycleViewAt(final int n, final v v) {
            final View child = this.getChildAt(n);
            this.removeViewAt(n);
            v.B(child);
        }
        
        public boolean removeCallbacks(final Runnable runnable) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            return mRecyclerView != null && mRecyclerView.removeCallbacks(runnable);
        }
        
        public void removeDetachedView(final View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }
        
        public void removeView(final View view) {
            this.mChildHelper.p(view);
        }
        
        public void removeViewAt(final int n) {
            if (this.getChildAt(n) != null) {
                this.mChildHelper.q(n);
            }
        }
        
        public boolean requestChildRectangleOnScreen(final RecyclerView recyclerView, final View view, final Rect rect, final boolean b) {
            return this.requestChildRectangleOnScreen(recyclerView, view, rect, b, false);
        }
        
        public boolean requestChildRectangleOnScreen(final RecyclerView recyclerView, final View view, final Rect rect, final boolean b, final boolean b2) {
            final int[] childRectangleOnScreenScrollAmount = this.getChildRectangleOnScreenScrollAmount(view, rect);
            final int n = childRectangleOnScreenScrollAmount[0];
            final int n2 = childRectangleOnScreenScrollAmount[1];
            if ((!b2 || this.isFocusedChildVisibleAfterScrolling(recyclerView, n, n2)) && (n != 0 || n2 != 0)) {
                if (b) {
                    recyclerView.scrollBy(n, n2);
                }
                else {
                    recyclerView.smoothScrollBy(n, n2);
                }
                return true;
            }
            return false;
        }
        
        public void requestLayout() {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (mRecyclerView != null) {
                mRecyclerView.requestLayout();
            }
        }
        
        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }
        
        public int scrollHorizontallyBy(final int n, final v v, final z z) {
            return 0;
        }
        
        public void scrollToPosition(final int n) {
        }
        
        public int scrollVerticallyBy(final int n, final v v, final z z) {
            return 0;
        }
        
        @Deprecated
        public void setAutoMeasureEnabled(final boolean mAutoMeasure) {
            this.mAutoMeasure = mAutoMeasure;
        }
        
        void setExactMeasureSpecsFrom(final RecyclerView recyclerView) {
            this.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
        
        public final void setItemPrefetchEnabled(final boolean mItemPrefetchEnabled) {
            if (mItemPrefetchEnabled != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = mItemPrefetchEnabled;
                this.mPrefetchMaxCountObserved = 0;
                final RecyclerView mRecyclerView = this.mRecyclerView;
                if (mRecyclerView != null) {
                    mRecyclerView.mRecycler.K();
                }
            }
        }
        
        void setMeasureSpecs(int n, final int n2) {
            this.mWidth = View$MeasureSpec.getSize(n);
            n = View$MeasureSpec.getMode(n);
            this.mWidthMode = n;
            if (n == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View$MeasureSpec.getSize(n2);
            n = View$MeasureSpec.getMode(n2);
            if ((this.mHeightMode = n) == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }
        
        public void setMeasuredDimension(final int n, final int n2) {
            RecyclerView.access$300(this.mRecyclerView, n, n2);
        }
        
        public void setMeasuredDimension(final Rect rect, final int n, final int n2) {
            this.setMeasuredDimension(chooseSize(n, rect.width() + this.getPaddingLeft() + this.getPaddingRight(), this.getMinimumWidth()), chooseSize(n2, rect.height() + this.getPaddingTop() + this.getPaddingBottom(), this.getMinimumHeight()));
        }
        
        void setMeasuredDimensionFromChildren(final int n, final int n2) {
            final int childCount = this.getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(n, n2);
                return;
            }
            int i = 0;
            int n3 = Integer.MIN_VALUE;
            int n4 = Integer.MAX_VALUE;
            int n5 = Integer.MAX_VALUE;
            int n6 = Integer.MIN_VALUE;
            while (i < childCount) {
                final View child = this.getChildAt(i);
                final Rect mTempRect = this.mRecyclerView.mTempRect;
                this.getDecoratedBoundsWithMargins(child, mTempRect);
                final int left = mTempRect.left;
                int n7;
                if (left < (n7 = n4)) {
                    n7 = left;
                }
                final int right = mTempRect.right;
                int n8;
                if (right > (n8 = n3)) {
                    n8 = right;
                }
                final int top = mTempRect.top;
                int n9;
                if (top < (n9 = n5)) {
                    n9 = top;
                }
                final int bottom = mTempRect.bottom;
                int n10;
                if (bottom > (n10 = n6)) {
                    n10 = bottom;
                }
                ++i;
                n3 = n8;
                n6 = n10;
                n4 = n7;
                n5 = n9;
            }
            this.mRecyclerView.mTempRect.set(n4, n5, n3, n6);
            this.setMeasuredDimension(this.mRecyclerView.mTempRect, n, n2);
        }
        
        public void setMeasurementCacheEnabled(final boolean mMeasurementCacheEnabled) {
            this.mMeasurementCacheEnabled = mMeasurementCacheEnabled;
        }
        
        void setRecyclerView(final RecyclerView mRecyclerView) {
            if (mRecyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            }
            else {
                this.mRecyclerView = mRecyclerView;
                this.mChildHelper = mRecyclerView.mChildHelper;
                this.mWidth = mRecyclerView.getWidth();
                this.mHeight = mRecyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }
        
        boolean shouldMeasureChild(final View view, final int n, final int n2, final p p4) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), n, p4.width) || !isMeasurementUpToDate(view.getHeight(), n2, p4.height);
        }
        
        boolean shouldMeasureTwice() {
            return false;
        }
        
        boolean shouldReMeasureChild(final View view, final int n, final int n2, final p p4) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), n, p4.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), n2, p4.height);
        }
        
        public void smoothScrollToPosition(final RecyclerView recyclerView, final z z, final int n) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }
        
        public void startSmoothScroll(final y mSmoothScroller) {
            final y mSmoothScroller2 = this.mSmoothScroller;
            if (mSmoothScroller2 != null && mSmoothScroller != mSmoothScroller2 && mSmoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            (this.mSmoothScroller = mSmoothScroller).start(this.mRecyclerView, this);
        }
        
        public void stopIgnoringView(final View view) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }
        
        void stopSmoothScroller() {
            final y mSmoothScroller = this.mSmoothScroller;
            if (mSmoothScroller != null) {
                mSmoothScroller.stop();
            }
        }
        
        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
        
        public interface c
        {
            void a(final int p0, final int p1);
        }
        
        public static class d
        {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }
    }
    
    public static class p extends ViewGroup$MarginLayoutParams
    {
        c0 a;
        final Rect b;
        boolean c;
        boolean d;
        
        public p(final int n, final int n2) {
            super(n, n2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
        
        public p(final Context context, final AttributeSet set) {
            super(context, set);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
        
        public p(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
        
        public p(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
        
        public p(final p p) {
            super((ViewGroup$LayoutParams)p);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
        
        public int a() {
            return this.a.getLayoutPosition();
        }
        
        public boolean b() {
            return this.a.isUpdated();
        }
        
        public boolean c() {
            return this.a.isRemoved();
        }
        
        public boolean d() {
            return this.a.isInvalid();
        }
    }
    
    public interface q
    {
        void a(final View p0);
        
        void b(final View p0);
    }
    
    public abstract static class r
    {
        public abstract boolean onFling(final int p0, final int p1);
    }
    
    public interface s
    {
        void a(final RecyclerView p0, final MotionEvent p1);
        
        boolean b(final RecyclerView p0, final MotionEvent p1);
        
        void c(final boolean p0);
    }
    
    public abstract static class t
    {
        public void onScrollStateChanged(final RecyclerView recyclerView, final int n) {
        }
        
        public void onScrolled(final RecyclerView recyclerView, final int n, final int n2) {
        }
    }
    
    public static class u
    {
        SparseArray<a> a;
        private int b;
        
        public u() {
            this.a = (SparseArray<a>)new SparseArray();
            this.b = 0;
        }
        
        private a g(final int n) {
            a a;
            if ((a = (a)this.a.get(n)) == null) {
                a = new a();
                this.a.put(n, (Object)a);
            }
            return a;
        }
        
        void a() {
            ++this.b;
        }
        
        public void b() {
            for (int i = 0; i < this.a.size(); ++i) {
                ((a)this.a.valueAt(i)).a.clear();
            }
        }
        
        void c() {
            --this.b;
        }
        
        void d(final int n, final long n2) {
            final a g = this.g(n);
            g.d = this.j(g.d, n2);
        }
        
        void e(final int n, final long n2) {
            final a g = this.g(n);
            g.c = this.j(g.c, n2);
        }
        
        public c0 f(int i) {
            final a a = (a)this.a.get(i);
            if (a != null && !a.a.isEmpty()) {
                final ArrayList<c0> a2 = a.a;
                for (i = a2.size() - 1; i >= 0; --i) {
                    if (!((c0)a2.get(i)).isAttachedToTransitionOverlay()) {
                        return (c0)a2.remove(i);
                    }
                }
            }
            return null;
        }
        
        void h(final Adapter adapter, final Adapter adapter2, final boolean b) {
            if (adapter != null) {
                this.c();
            }
            if (!b && this.b == 0) {
                this.b();
            }
            if (adapter2 != null) {
                this.a();
            }
        }
        
        public void i(final c0 c0) {
            final int itemViewType = c0.getItemViewType();
            final ArrayList<c0> a = this.g(itemViewType).a;
            if (((a)this.a.get(itemViewType)).b <= a.size()) {
                return;
            }
            c0.resetInternal();
            a.add(c0);
        }
        
        long j(final long n, final long n2) {
            if (n == 0L) {
                return n2;
            }
            return n / 4L * 3L + n2 / 4L;
        }
        
        boolean k(final int n, final long n2, final long n3) {
            final long d = this.g(n).d;
            return d == 0L || n2 + d < n3;
        }
        
        boolean l(final int n, final long n2, final long n3) {
            final long c = this.g(n).c;
            return c == 0L || n2 + c < n3;
        }
        
        static class a
        {
            final ArrayList<c0> a;
            int b;
            long c;
            long d;
            
            a() {
                this.a = new ArrayList<c0>();
                this.b = 5;
                this.c = 0L;
                this.d = 0L;
            }
        }
    }
    
    public final class v
    {
        final ArrayList<c0> a;
        ArrayList<c0> b;
        final ArrayList<c0> c;
        private final List<c0> d;
        private int e;
        int f;
        u g;
        final RecyclerView h;
        
        public v(final RecyclerView h) {
            this.h = h;
            final ArrayList a = new ArrayList();
            this.a = a;
            this.b = null;
            this.c = new ArrayList<c0>();
            this.d = (List<c0>)Collections.unmodifiableList((List<?>)a);
            this.e = 2;
            this.f = 2;
        }
        
        private boolean H(final c0 c0, final int n, final int mPreLayoutPosition, long nanoTime) {
            c0.mBindingAdapter = null;
            c0.mOwnerRecyclerView = this.h;
            final int itemViewType = c0.getItemViewType();
            final long nanoTime2 = this.h.getNanoTime();
            if (nanoTime != Long.MAX_VALUE && !this.g.k(itemViewType, nanoTime2, nanoTime)) {
                return false;
            }
            this.h.mAdapter.bindViewHolder(c0, n);
            nanoTime = this.h.getNanoTime();
            this.g.d(c0.getItemViewType(), nanoTime - nanoTime2);
            this.b(c0);
            if (this.h.mState.e()) {
                c0.mPreLayoutPosition = mPreLayoutPosition;
            }
            return true;
        }
        
        private void b(final c0 c0) {
            if (this.h.isAccessibilityEnabled()) {
                final View itemView = c0.itemView;
                if (androidx.core.view.b0.z(itemView) == 0) {
                    androidx.core.view.b0.A0(itemView, 1);
                }
                final androidx.recyclerview.widget.u mAccessibilityDelegate = this.h.mAccessibilityDelegate;
                if (mAccessibilityDelegate == null) {
                    return;
                }
                final androidx.core.view.a a = mAccessibilityDelegate.a();
                if (a instanceof androidx.recyclerview.widget.u.a) {
                    ((androidx.recyclerview.widget.u.a)a).b(itemView);
                }
                androidx.core.view.b0.p0(itemView, a);
            }
        }
        
        private void q(final ViewGroup viewGroup, final boolean b) {
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (child instanceof ViewGroup) {
                    this.q((ViewGroup)child, true);
                }
            }
            if (!b) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            }
            else {
                final int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
        
        private void r(final c0 c0) {
            final View itemView = c0.itemView;
            if (itemView instanceof ViewGroup) {
                this.q((ViewGroup)itemView, false);
            }
        }
        
        void A(final int n) {
            this.a(this.c.get(n), true);
            this.c.remove(n);
        }
        
        public void B(final View view) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                this.h.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            }
            else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            this.C(childViewHolderInt);
            if (this.h.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                this.h.mItemAnimator.j(childViewHolderInt);
            }
        }
        
        void C(final c0 c0) {
            final boolean scrap = c0.isScrap();
            boolean b = false;
            final int n = 0;
            final int n2 = 1;
            if (scrap || c0.itemView.getParent() != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c0.isScrap());
                sb.append(" isAttached:");
                if (c0.itemView.getParent() != null) {
                    b = true;
                }
                sb.append(b);
                sb.append(this.h.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c0.isTmpDetached()) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(c0);
                sb2.append(this.h.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (!c0.shouldIgnore()) {
                final boolean doesTransientStatePreventRecycling = c0.doesTransientStatePreventRecycling();
                final Adapter mAdapter = this.h.mAdapter;
                int n4;
                int n5;
                if ((mAdapter == null || !doesTransientStatePreventRecycling || !mAdapter.onFailedToRecycleView(c0)) && !c0.isRecyclable()) {
                    final int n3 = 0;
                    n4 = n;
                    n5 = n3;
                }
                else {
                    if (this.f > 0 && !c0.hasAnyOfTheFlags(526)) {
                        int size;
                        final int n6 = size = this.c.size();
                        if (n6 >= this.f && (size = n6) > 0) {
                            this.A(0);
                            size = n6 - 1;
                        }
                        int n7 = size;
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && (n7 = size) > 0) {
                            n7 = size;
                            if (!this.h.mPrefetchRegistry.d(c0.mPosition)) {
                                --size;
                                while (size >= 0 && this.h.mPrefetchRegistry.d(this.c.get(size).mPosition)) {
                                    --size;
                                }
                                n7 = size + 1;
                            }
                        }
                        this.c.add(n7, c0);
                        n4 = 1;
                    }
                    else {
                        n4 = 0;
                    }
                    if (n4 == 0) {
                        this.a(c0, true);
                        n5 = n2;
                    }
                    else {
                        n5 = 0;
                    }
                }
                this.h.mViewInfoStore.q(c0);
                if (n4 == 0 && n5 == 0 && doesTransientStatePreventRecycling) {
                    c0.mBindingAdapter = null;
                    c0.mOwnerRecyclerView = null;
                }
                return;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            sb3.append(this.h.exceptionLabel());
            throw new IllegalArgumentException(sb3.toString());
        }
        
        void D(final View view) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.h.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.b == null) {
                    this.b = new ArrayList<c0>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.b.add(childViewHolderInt);
            }
            else {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.h.mAdapter.hasStableIds()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                    sb.append(this.h.exceptionLabel());
                    throw new IllegalArgumentException(sb.toString());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.a.add(childViewHolderInt);
            }
        }
        
        void E(final u g) {
            final u g2 = this.g;
            if (g2 != null) {
                g2.c();
            }
            this.g = g;
            if (g != null && this.h.getAdapter() != null) {
                this.g.a();
            }
        }
        
        void F(final a0 a0) {
        }
        
        public void G(final int e) {
            this.e = e;
            this.K();
        }
        
        c0 I(final int mPreLayoutPosition, final boolean b, final long n) {
            if (mPreLayoutPosition >= 0 && mPreLayoutPosition < this.h.mState.b()) {
                final boolean e = this.h.mState.e();
                final boolean b2 = true;
                c0 c0 = null;
                int n2 = 0;
                Label_0070: {
                    if (e) {
                        final c0 h = this.h(mPreLayoutPosition);
                        if ((c0 = h) != null) {
                            n2 = 1;
                            c0 = h;
                            break Label_0070;
                        }
                    }
                    else {
                        c0 = null;
                    }
                    n2 = 0;
                }
                c0 m = c0;
                int n3 = n2;
                if (c0 == null) {
                    final c0 c2 = m = this.m(mPreLayoutPosition, b);
                    n3 = n2;
                    if (c2 != null) {
                        if (!this.L(c2)) {
                            if (!b) {
                                c2.addFlags(4);
                                if (c2.isScrap()) {
                                    this.h.removeDetachedView(c2.itemView, false);
                                    c2.unScrap();
                                }
                                else if (c2.wasReturnedFromScrap()) {
                                    c2.clearReturnedFromScrapFlag();
                                }
                                this.C(c2);
                            }
                            m = null;
                            n3 = n2;
                        }
                        else {
                            n3 = 1;
                            m = c2;
                        }
                    }
                }
                Object viewHolder = m;
                int n4 = n3;
                int n5 = 0;
                Label_0584: {
                    if (m == null) {
                        final int i = this.h.mAdapterHelper.m(mPreLayoutPosition);
                        if (i < 0 || i >= this.h.mAdapter.getItemCount()) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Inconsistency detected. Invalid item position ");
                            sb.append(mPreLayoutPosition);
                            sb.append("(offset:");
                            sb.append(i);
                            sb.append(").state:");
                            sb.append(this.h.mState.b());
                            sb.append(this.h.exceptionLabel());
                            throw new IndexOutOfBoundsException(sb.toString());
                        }
                        final int itemViewType = this.h.mAdapter.getItemViewType(i);
                        c0 l = m;
                        n5 = n3;
                        if (this.h.mAdapter.hasStableIds()) {
                            final c0 c3 = l = this.l(this.h.mAdapter.getItemId(i), itemViewType, b);
                            n5 = n3;
                            if (c3 != null) {
                                c3.mPosition = i;
                                n5 = 1;
                                l = c3;
                            }
                        }
                        c0 f;
                        if ((f = l) == null) {
                            f = this.i().f(itemViewType);
                            if (f != null) {
                                f.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    this.r(f);
                                }
                            }
                        }
                        viewHolder = f;
                        n4 = n5;
                        if (f == null) {
                            final long nanoTime = this.h.getNanoTime();
                            if (n != Long.MAX_VALUE && !this.g.l(itemViewType, nanoTime, n)) {
                                return null;
                            }
                            final RecyclerView h2 = this.h;
                            viewHolder = h2.mAdapter.createViewHolder(h2, itemViewType);
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                                final RecyclerView nestedRecyclerView = RecyclerView.findNestedRecyclerView(((c0)viewHolder).itemView);
                                if (nestedRecyclerView != null) {
                                    ((c0)viewHolder).mNestedRecyclerView = new WeakReference<RecyclerView>(nestedRecyclerView);
                                }
                            }
                            this.g.e(itemViewType, this.h.getNanoTime() - nanoTime);
                            break Label_0584;
                        }
                    }
                    n5 = n4;
                }
                if (n5 != 0 && !this.h.mState.e() && ((c0)viewHolder).hasAnyOfTheFlags(8192)) {
                    ((c0)viewHolder).setFlags(0, 8192);
                    if (this.h.mState.k) {
                        final int e2 = l.e((c0)viewHolder);
                        final RecyclerView h3 = this.h;
                        this.h.recordAnimationInfoIfBouncedHiddenView((c0)viewHolder, h3.mItemAnimator.t(h3.mState, (c0)viewHolder, e2 | 0x1000, ((c0)viewHolder).getUnmodifiedPayloads()));
                    }
                }
                boolean h4 = false;
                Label_0769: {
                    if (this.h.mState.e() && ((c0)viewHolder).isBound()) {
                        ((c0)viewHolder).mPreLayoutPosition = mPreLayoutPosition;
                    }
                    else if (!((c0)viewHolder).isBound() || ((c0)viewHolder).needsUpdate() || ((c0)viewHolder).isInvalid()) {
                        h4 = this.H((c0)viewHolder, this.h.mAdapterHelper.m(mPreLayoutPosition), mPreLayoutPosition, n);
                        break Label_0769;
                    }
                    h4 = false;
                }
                final ViewGroup$LayoutParams layoutParams = ((c0)viewHolder).itemView.getLayoutParams();
                p p3;
                if (layoutParams == null) {
                    p3 = (p)this.h.generateDefaultLayoutParams();
                    ((c0)viewHolder).itemView.setLayoutParams((ViewGroup$LayoutParams)p3);
                }
                else if (!this.h.checkLayoutParams(layoutParams)) {
                    p3 = (p)this.h.generateLayoutParams(layoutParams);
                    ((c0)viewHolder).itemView.setLayoutParams((ViewGroup$LayoutParams)p3);
                }
                else {
                    p3 = (p)layoutParams;
                }
                p3.a = (c0)viewHolder;
                p3.d = (n5 != 0 && h4 && b2);
                return (c0)viewHolder;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid item position ");
            sb2.append(mPreLayoutPosition);
            sb2.append("(");
            sb2.append(mPreLayoutPosition);
            sb2.append("). Item count:");
            sb2.append(this.h.mState.b());
            sb2.append(this.h.exceptionLabel());
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        
        void J(final c0 c0) {
            if (c0.mInChangeScrap) {
                this.b.remove(c0);
            }
            else {
                this.a.remove(c0);
            }
            c0.mScrapContainer = null;
            c0.mInChangeScrap = false;
            c0.clearReturnedFromScrapFlag();
        }
        
        void K() {
            final o mLayout = this.h.mLayout;
            int mPrefetchMaxCountObserved;
            if (mLayout != null) {
                mPrefetchMaxCountObserved = mLayout.mPrefetchMaxCountObserved;
            }
            else {
                mPrefetchMaxCountObserved = 0;
            }
            this.f = this.e + mPrefetchMaxCountObserved;
            for (int n = this.c.size() - 1; n >= 0 && this.c.size() > this.f; --n) {
                this.A(n);
            }
        }
        
        boolean L(final c0 c0) {
            if (c0.isRemoved()) {
                return this.h.mState.e();
            }
            final int mPosition = c0.mPosition;
            if (mPosition < 0 || mPosition >= this.h.mAdapter.getItemCount()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Inconsistency detected. Invalid view holder adapter position");
                sb.append(c0);
                sb.append(this.h.exceptionLabel());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            final boolean e = this.h.mState.e();
            boolean b = false;
            if (!e && this.h.mAdapter.getItemViewType(c0.mPosition) != c0.getItemViewType()) {
                return false;
            }
            if (this.h.mAdapter.hasStableIds()) {
                if (c0.getItemId() == this.h.mAdapter.getItemId(c0.mPosition)) {
                    b = true;
                }
                return b;
            }
            return true;
        }
        
        void M(final int n, final int n2) {
            for (int i = this.c.size() - 1; i >= 0; --i) {
                final c0 c0 = this.c.get(i);
                if (c0 != null) {
                    final int mPosition = c0.mPosition;
                    if (mPosition >= n && mPosition < n2 + n) {
                        c0.addFlags(2);
                        this.A(i);
                    }
                }
            }
        }
        
        void a(final c0 c0, final boolean b) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(c0);
            final View itemView = c0.itemView;
            final androidx.recyclerview.widget.u mAccessibilityDelegate = this.h.mAccessibilityDelegate;
            if (mAccessibilityDelegate != null) {
                final androidx.core.view.a a = mAccessibilityDelegate.a();
                androidx.core.view.a a2;
                if (a instanceof androidx.recyclerview.widget.u.a) {
                    a2 = ((androidx.recyclerview.widget.u.a)a).a(itemView);
                }
                else {
                    a2 = null;
                }
                androidx.core.view.b0.p0(itemView, a2);
            }
            if (b) {
                this.g(c0);
            }
            c0.mBindingAdapter = null;
            c0.mOwnerRecyclerView = null;
            this.i().i(c0);
        }
        
        public void c() {
            this.a.clear();
            this.z();
        }
        
        void d() {
            final int size = this.c.size();
            final int n = 0;
            for (int i = 0; i < size; ++i) {
                this.c.get(i).clearOldPosition();
            }
            for (int size2 = this.a.size(), j = 0; j < size2; ++j) {
                this.a.get(j).clearOldPosition();
            }
            final ArrayList<c0> b = this.b;
            if (b != null) {
                for (int size3 = b.size(), k = n; k < size3; ++k) {
                    this.b.get(k).clearOldPosition();
                }
            }
        }
        
        void e() {
            this.a.clear();
            final ArrayList<c0> b = this.b;
            if (b != null) {
                b.clear();
            }
        }
        
        public int f(final int n) {
            if (n < 0 || n >= this.h.mState.b()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(n);
                sb.append(". State item count is ");
                sb.append(this.h.mState.b());
                sb.append(this.h.exceptionLabel());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            if (!this.h.mState.e()) {
                return n;
            }
            return this.h.mAdapterHelper.m(n);
        }
        
        void g(final c0 c0) {
            final w mRecyclerListener = this.h.mRecyclerListener;
            if (mRecyclerListener != null) {
                mRecyclerListener.a(c0);
            }
            for (int size = this.h.mRecyclerListeners.size(), i = 0; i < size; ++i) {
                ((w)this.h.mRecyclerListeners.get(i)).a(c0);
            }
            final Adapter mAdapter = this.h.mAdapter;
            if (mAdapter != null) {
                mAdapter.onViewRecycled(c0);
            }
            final RecyclerView h = this.h;
            if (h.mState != null) {
                h.mViewInfoStore.q(c0);
            }
        }
        
        c0 h(int i) {
            final ArrayList<c0> b = this.b;
            if (b != null) {
                final int size = b.size();
                if (size != 0) {
                    final int n = 0;
                    for (int j = 0; j < size; ++j) {
                        final c0 c0 = this.b.get(j);
                        if (!c0.wasReturnedFromScrap() && c0.getLayoutPosition() == i) {
                            c0.addFlags(32);
                            return c0;
                        }
                    }
                    if (this.h.mAdapter.hasStableIds()) {
                        i = this.h.mAdapterHelper.m(i);
                        if (i > 0 && i < this.h.mAdapter.getItemCount()) {
                            final long itemId = this.h.mAdapter.getItemId(i);
                            c0 c2;
                            for (i = n; i < size; ++i) {
                                c2 = this.b.get(i);
                                if (!c2.wasReturnedFromScrap() && c2.getItemId() == itemId) {
                                    c2.addFlags(32);
                                    return c2;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
        
        u i() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }
        
        int j() {
            return this.a.size();
        }
        
        public List<c0> k() {
            return this.d;
        }
        
        c0 l(final long n, final int n2, final boolean b) {
            for (int i = this.a.size() - 1; i >= 0; --i) {
                final c0 c0 = this.a.get(i);
                if (c0.getItemId() == n && !c0.wasReturnedFromScrap()) {
                    if (n2 == c0.getItemViewType()) {
                        c0.addFlags(32);
                        if (c0.isRemoved() && !this.h.mState.e()) {
                            c0.setFlags(2, 14);
                        }
                        return c0;
                    }
                    if (!b) {
                        this.a.remove(i);
                        this.h.removeDetachedView(c0.itemView, false);
                        this.y(c0.itemView);
                    }
                }
            }
            for (int j = this.c.size() - 1; j >= 0; --j) {
                final c0 c2 = this.c.get(j);
                if (c2.getItemId() == n && !c2.isAttachedToTransitionOverlay()) {
                    if (n2 == c2.getItemViewType()) {
                        if (!b) {
                            this.c.remove(j);
                        }
                        return c2;
                    }
                    if (!b) {
                        this.A(j);
                        return null;
                    }
                }
            }
            return null;
        }
        
        c0 m(int m, final boolean b) {
            final int size = this.a.size();
            final int n = 0;
            for (int i = 0; i < size; ++i) {
                final c0 c0 = this.a.get(i);
                if (!c0.wasReturnedFromScrap() && c0.getLayoutPosition() == m && !c0.isInvalid() && (this.h.mState.h || !c0.isRemoved())) {
                    c0.addFlags(32);
                    return c0;
                }
            }
            if (!b) {
                final View e = this.h.mChildHelper.e(m);
                if (e != null) {
                    final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                    this.h.mChildHelper.s(e);
                    m = this.h.mChildHelper.m(e);
                    if (m != -1) {
                        this.h.mChildHelper.d(m);
                        this.D(e);
                        childViewHolderInt.addFlags(8224);
                        return childViewHolderInt;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("layout index should not be -1 after unhiding a view:");
                    sb.append(childViewHolderInt);
                    sb.append(this.h.exceptionLabel());
                    throw new IllegalStateException(sb.toString());
                }
            }
            for (int size2 = this.c.size(), j = n; j < size2; ++j) {
                final c0 c2 = this.c.get(j);
                if (!c2.isInvalid() && c2.getLayoutPosition() == m && !c2.isAttachedToTransitionOverlay()) {
                    if (!b) {
                        this.c.remove(j);
                    }
                    return c2;
                }
            }
            return null;
        }
        
        View n(final int n) {
            return this.a.get(n).itemView;
        }
        
        public View o(final int n) {
            return this.p(n, false);
        }
        
        View p(final int n, final boolean b) {
            return this.I(n, b, Long.MAX_VALUE).itemView;
        }
        
        void s() {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final p p = (p)this.c.get(i).itemView.getLayoutParams();
                if (p != null) {
                    p.c = true;
                }
            }
        }
        
        void t() {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final c0 c0 = this.c.get(i);
                if (c0 != null) {
                    c0.addFlags(6);
                    c0.addChangePayload(null);
                }
            }
            final Adapter mAdapter = this.h.mAdapter;
            if (mAdapter == null || !mAdapter.hasStableIds()) {
                this.z();
            }
        }
        
        void u(final int n, final int n2) {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final c0 c0 = this.c.get(i);
                if (c0 != null && c0.mPosition >= n) {
                    c0.offsetPosition(n2, false);
                }
            }
        }
        
        void v(final int n, final int n2) {
            int n3;
            int n4;
            int n5;
            if (n < n2) {
                n3 = -1;
                n4 = n;
                n5 = n2;
            }
            else {
                n3 = 1;
                n5 = n;
                n4 = n2;
            }
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final c0 c0 = this.c.get(i);
                if (c0 != null) {
                    final int mPosition = c0.mPosition;
                    if (mPosition >= n4) {
                        if (mPosition <= n5) {
                            if (mPosition == n) {
                                c0.offsetPosition(n2 - n, false);
                            }
                            else {
                                c0.offsetPosition(n3, false);
                            }
                        }
                    }
                }
            }
        }
        
        void w(final int n, final int n2, final boolean b) {
            for (int i = this.c.size() - 1; i >= 0; --i) {
                final c0 c0 = this.c.get(i);
                if (c0 != null) {
                    final int mPosition = c0.mPosition;
                    if (mPosition >= n + n2) {
                        c0.offsetPosition(-n2, b);
                    }
                    else if (mPosition >= n) {
                        c0.addFlags(8);
                        this.A(i);
                    }
                }
            }
        }
        
        void x(final Adapter adapter, final Adapter adapter2, final boolean b) {
            this.c();
            this.i().h(adapter, adapter2, b);
        }
        
        void y(final View view) {
            final c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            this.C(childViewHolderInt);
        }
        
        void z() {
            for (int i = this.c.size() - 1; i >= 0; --i) {
                this.A(i);
            }
            this.c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                this.h.mPrefetchRegistry.b();
            }
        }
    }
    
    public interface w
    {
        void a(final c0 p0);
    }
    
    private class x extends i
    {
        final RecyclerView a;
        
        x(final RecyclerView a) {
            this.a = a;
        }
        
        void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                final RecyclerView a = this.a;
                if (a.mHasFixedSize && a.mIsAttached) {
                    androidx.core.view.b0.h0((View)a, a.mUpdateChildViewsRunnable);
                    return;
                }
            }
            final RecyclerView a2 = this.a;
            a2.mAdapterUpdateDuringMeasure = true;
            a2.requestLayout();
        }
        
        @Override
        public void onChanged() {
            this.a.assertNotInLayoutOrScroll(null);
            final RecyclerView a = this.a;
            a.processDataSetCompletelyChanged(a.mState.g = true);
            if (!this.a.mAdapterHelper.p()) {
                this.a.requestLayout();
            }
        }
        
        @Override
        public void onItemRangeChanged(final int n, final int n2, final Object o) {
            this.a.assertNotInLayoutOrScroll(null);
            if (this.a.mAdapterHelper.r(n, n2, o)) {
                this.a();
            }
        }
        
        @Override
        public void onItemRangeInserted(final int n, final int n2) {
            this.a.assertNotInLayoutOrScroll(null);
            if (this.a.mAdapterHelper.s(n, n2)) {
                this.a();
            }
        }
        
        @Override
        public void onItemRangeMoved(final int n, final int n2, final int n3) {
            this.a.assertNotInLayoutOrScroll(null);
            if (this.a.mAdapterHelper.t(n, n2, n3)) {
                this.a();
            }
        }
        
        @Override
        public void onItemRangeRemoved(final int n, final int n2) {
            this.a.assertNotInLayoutOrScroll(null);
            if (this.a.mAdapterHelper.u(n, n2)) {
                this.a();
            }
        }
        
        @Override
        public void onStateRestorationPolicyChanged() {
            final RecyclerView a = this.a;
            if (a.mPendingSavedState == null) {
                return;
            }
            final Adapter mAdapter = a.mAdapter;
            if (mAdapter != null && mAdapter.canRestoreState()) {
                this.a.requestLayout();
            }
        }
    }
    
    public abstract static class y
    {
        private o mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final a mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;
        
        public y() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new a(0, 0);
        }
        
        public PointF computeScrollVectorForPosition(final int n) {
            final o layoutManager = this.getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b)layoutManager).computeScrollVectorForPosition(n);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb.append(b.class.getCanonicalName());
            Log.w("RecyclerView", sb.toString());
            return null;
        }
        
        public View findViewByPosition(final int n) {
            return this.mRecyclerView.mLayout.findViewByPosition(n);
        }
        
        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }
        
        public int getChildPosition(final View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }
        
        public o getLayoutManager() {
            return this.mLayoutManager;
        }
        
        public int getTargetPosition() {
            return this.mTargetPosition;
        }
        
        @Deprecated
        public void instantScrollToPosition(final int n) {
            this.mRecyclerView.scrollToPosition(n);
        }
        
        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }
        
        public boolean isRunning() {
            return this.mRunning;
        }
        
        protected void normalize(final PointF pointF) {
            final float x = pointF.x;
            final float y = pointF.y;
            final float n = (float)Math.sqrt(x * x + y * y);
            pointF.x /= n;
            pointF.y /= n;
        }
        
        void onAnimation(final int n, final int n2) {
            final RecyclerView mRecyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || mRecyclerView == null) {
                this.stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null) {
                final PointF computeScrollVectorForPosition = this.computeScrollVectorForPosition(this.mTargetPosition);
                if (computeScrollVectorForPosition != null) {
                    final float x = computeScrollVectorForPosition.x;
                    if (x != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                        mRecyclerView.scrollStep((int)Math.signum(x), (int)Math.signum(computeScrollVectorForPosition.y), null);
                    }
                }
            }
            this.mPendingInitialRun = false;
            final View mTargetView = this.mTargetView;
            if (mTargetView != null) {
                if (this.getChildPosition(mTargetView) == this.mTargetPosition) {
                    this.onTargetFound(this.mTargetView, mRecyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.c(mRecyclerView);
                    this.stop();
                }
                else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                this.onSeekTargetStep(n, n2, mRecyclerView.mState, this.mRecyclingAction);
                final boolean a = this.mRecyclingAction.a();
                this.mRecyclingAction.c(mRecyclerView);
                if (a && this.mRunning) {
                    this.mPendingInitialRun = true;
                    mRecyclerView.mViewFlinger.d();
                }
            }
        }
        
        protected void onChildAttachedToWindow(final View mTargetView) {
            if (this.getChildPosition(mTargetView) == this.getTargetPosition()) {
                this.mTargetView = mTargetView;
            }
        }
        
        protected abstract void onSeekTargetStep(final int p0, final int p1, final z p2, final a p3);
        
        protected abstract void onStart();
        
        protected abstract void onStop();
        
        protected abstract void onTargetFound(final View p0, final z p1, final a p2);
        
        public void setTargetPosition(final int mTargetPosition) {
            this.mTargetPosition = mTargetPosition;
        }
        
        void start(final RecyclerView mRecyclerView, final o mLayoutManager) {
            mRecyclerView.mViewFlinger.f();
            if (this.mStarted) {
                final StringBuilder sb = new StringBuilder();
                sb.append("An instance of ");
                sb.append(this.getClass().getSimpleName());
                sb.append(" was started more than once. Each instance of");
                sb.append(this.getClass().getSimpleName());
                sb.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", sb.toString());
            }
            this.mRecyclerView = mRecyclerView;
            this.mLayoutManager = mLayoutManager;
            final int mTargetPosition = this.mTargetPosition;
            if (mTargetPosition != -1) {
                mRecyclerView.mState.a = mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = this.findViewByPosition(this.getTargetPosition());
                this.onStart();
                this.mRecyclerView.mViewFlinger.d();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }
        
        protected final void stop() {
            if (!this.mRunning) {
                return;
            }
            this.mRunning = false;
            this.onStop();
            this.mRecyclerView.mState.a = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
        
        public static class a
        {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;
            
            public a(final int n, final int n2) {
                this(n, n2, Integer.MIN_VALUE, null);
            }
            
            public a(final int a, final int b, final int c, final Interpolator e) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = a;
                this.b = b;
                this.c = c;
                this.e = e;
            }
            
            private void e() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c >= 1) {
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
            
            boolean a() {
                return this.d >= 0;
            }
            
            public void b(final int d) {
                this.d = d;
            }
            
            void c(final RecyclerView recyclerView) {
                final int d = this.d;
                if (d >= 0) {
                    this.d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(d);
                    this.f = false;
                    return;
                }
                if (this.f) {
                    this.e();
                    recyclerView.mViewFlinger.e(this.a, this.b, this.c, this.e);
                    if (++this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                }
                else {
                    this.g = 0;
                }
            }
            
            public void d(final int a, final int b, final int c, final Interpolator e) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.e = e;
                this.f = true;
            }
        }
        
        public interface b
        {
            PointF computeScrollVectorForPosition(final int p0);
        }
    }
    
    public static class z
    {
        int a;
        private SparseArray<Object> b;
        int c;
        int d;
        int e;
        int f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        int m;
        long n;
        int o;
        int p;
        int q;
        
        public z() {
            this.a = -1;
            this.c = 0;
            this.d = 0;
            this.e = 1;
            this.f = 0;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
        }
        
        void a(final int n) {
            if ((this.e & n) != 0x0) {
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Layout state should be one of ");
            sb.append(Integer.toBinaryString(n));
            sb.append(" but it is ");
            sb.append(Integer.toBinaryString(this.e));
            throw new IllegalStateException(sb.toString());
        }
        
        public int b() {
            int f;
            if (this.h) {
                f = this.c - this.d;
            }
            else {
                f = this.f;
            }
            return f;
        }
        
        public int c() {
            return this.a;
        }
        
        public boolean d() {
            return this.a != -1;
        }
        
        public boolean e() {
            return this.h;
        }
        
        void f(final Adapter adapter) {
            this.e = 1;
            this.f = adapter.getItemCount();
            this.h = false;
            this.i = false;
            this.j = false;
        }
        
        public boolean g() {
            return this.l;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("State{mTargetPosition=");
            sb.append(this.a);
            sb.append(", mData=");
            sb.append(this.b);
            sb.append(", mItemCount=");
            sb.append(this.f);
            sb.append(", mIsMeasuring=");
            sb.append(this.j);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.c);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.d);
            sb.append(", mStructureChanged=");
            sb.append(this.g);
            sb.append(", mInPreLayout=");
            sb.append(this.h);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.k);
            sb.append(", mRunPredictiveAnimations=");
            sb.append(this.l);
            sb.append('}');
            return sb.toString();
        }
    }
}
