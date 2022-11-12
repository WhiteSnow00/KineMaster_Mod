// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.widgets.g;
import android.util.SparseIntArray;
import android.content.res.TypedArray;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$MeasureSpec;
import java.util.Iterator;
import android.util.Log;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import android.content.res.Resources$NotFoundException;
import android.util.AttributeSet;
import android.content.Context;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.HashMap;
import java.util.ArrayList;
import android.view.View;
import android.util.SparseArray;
import android.view.ViewGroup;

public class ConstraintLayout extends ViewGroup
{
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static i sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<a> mConstraintHelpers;
    protected androidx.constraintlayout.widget.b mConstraintLayoutSpec;
    private androidx.constraintlayout.widget.c mConstraintSet;
    private int mConstraintSetId;
    private e mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected d mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private n.a mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;
    
    public ConstraintLayout(final Context context) {
        super(context);
        this.mChildrenByIds = (SparseArray<View>)new SparseArray();
        this.mConstraintHelpers = new ArrayList<a>(4);
        this.mLayoutWidget = new d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<String, Integer>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = (SparseArray<ConstraintWidget>)new SparseArray();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.init(null, this.mOnMeasureHeightMeasureSpec = 0, 0);
    }
    
    public ConstraintLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.mChildrenByIds = (SparseArray<View>)new SparseArray();
        this.mConstraintHelpers = new ArrayList<a>(4);
        this.mLayoutWidget = new d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<String, Integer>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = (SparseArray<ConstraintWidget>)new SparseArray();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.init(set, this.mOnMeasureHeightMeasureSpec = 0, 0);
    }
    
    public ConstraintLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mChildrenByIds = (SparseArray<View>)new SparseArray();
        this.mConstraintHelpers = new ArrayList<a>(4);
        this.mLayoutWidget = new d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<String, Integer>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = (SparseArray<ConstraintWidget>)new SparseArray();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.init(set, n, this.mOnMeasureHeightMeasureSpec = 0);
    }
    
    public ConstraintLayout(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.mChildrenByIds = (SparseArray<View>)new SparseArray();
        this.mConstraintHelpers = new ArrayList<a>(4);
        this.mLayoutWidget = new d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<String, Integer>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = (SparseArray<ConstraintWidget>)new SparseArray();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(set, n, n2);
    }
    
    static int access$000(final ConstraintLayout constraintLayout) {
        return constraintLayout.mOptimizationLevel;
    }
    
    static ArrayList access$100(final ConstraintLayout constraintLayout) {
        return constraintLayout.mConstraintHelpers;
    }
    
    private int getPaddingWidth() {
        int n = Math.max(0, this.getPaddingLeft()) + Math.max(0, this.getPaddingRight());
        final int n2 = Math.max(0, this.getPaddingStart()) + Math.max(0, this.getPaddingEnd());
        if (n2 > 0) {
            n = n2;
        }
        return n;
    }
    
    public static i getSharedValues() {
        if (ConstraintLayout.sSharedValues == null) {
            ConstraintLayout.sSharedValues = new i();
        }
        return ConstraintLayout.sSharedValues;
    }
    
    private final ConstraintWidget getTargetWidget(final int n) {
        if (n == 0) {
            return this.mLayoutWidget;
        }
        View view;
        if ((view = (View)this.mChildrenByIds.get(n)) == null) {
            final View viewById = this.findViewById(n);
            if ((view = viewById) != null && (view = viewById) != this) {
                view = viewById;
                if (viewById.getParent() == this) {
                    this.onViewAdded(viewById);
                    view = viewById;
                }
            }
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        ConstraintWidget v0;
        if (view == null) {
            v0 = null;
        }
        else {
            v0 = ((b)view.getLayoutParams()).v0;
        }
        return v0;
    }
    
    private void init(AttributeSet obtainStyledAttributes, int i, int indexCount) {
        this.mLayoutWidget.y0(this);
        this.mLayoutWidget.S1(this.mMeasurer);
        this.mChildrenByIds.put(this.getId(), (Object)this);
        this.mConstraintSet = null;
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes = (AttributeSet)this.getContext().obtainStyledAttributes(obtainStyledAttributes, h.n1, i, indexCount);
            int index;
            int resourceId;
            int resourceId2;
            for (indexCount = ((TypedArray)obtainStyledAttributes).getIndexCount(), i = 0; i < indexCount; ++i) {
                index = ((TypedArray)obtainStyledAttributes).getIndex(i);
                if (index == h.s1) {
                    this.mMinWidth = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.mMinWidth);
                }
                else if (index == h.t1) {
                    this.mMinHeight = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.mMinHeight);
                }
                else if (index == h.q1) {
                    this.mMaxWidth = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.mMaxWidth);
                }
                else if (index == h.r1) {
                    this.mMaxHeight = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.mMaxHeight);
                }
                else if (index == h.H2) {
                    this.mOptimizationLevel = ((TypedArray)obtainStyledAttributes).getInt(index, this.mOptimizationLevel);
                }
                else if (index == h.C1) {
                    resourceId = ((TypedArray)obtainStyledAttributes).getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.parseLayoutDescription(resourceId);
                        }
                        catch (final Resources$NotFoundException ex) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                }
                else if (index == h.y1) {
                    resourceId2 = ((TypedArray)obtainStyledAttributes).getResourceId(index, 0);
                    try {
                        (this.mConstraintSet = new androidx.constraintlayout.widget.c()).x(this.getContext(), resourceId2);
                    }
                    catch (final Resources$NotFoundException ex2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            ((TypedArray)obtainStyledAttributes).recycle();
        }
        this.mLayoutWidget.T1(this.mOptimizationLevel);
    }
    
    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }
    
    private void setChildrenConstraints() {
        final boolean inEditMode = this.isInEditMode();
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final ConstraintWidget viewWidget = this.getViewWidget(this.getChildAt(i));
            if (viewWidget != null) {
                viewWidget.r0();
            }
        }
        Label_0143: {
            if (!inEditMode) {
                break Label_0143;
            }
            int i = 0;
        Label_0137_Outer:
            while (true) {
                if (i >= childCount) {
                    break Label_0143;
                }
                final View child = this.getChildAt(i);
                String resourceName;
                int index;
                String substring;
                View child2;
                View child3;
                View child4;
                b b;
                ConstraintWidget viewWidget2;
                int size;
                View child5;
                androidx.constraintlayout.widget.c mConstraintSet;
                Label_0383_Outer:Block_12_Outer:
                while (true) {
                    try {
                        resourceName = this.getResources().getResourceName(child.getId());
                        this.setDesignInformation(0, resourceName, child.getId());
                        index = resourceName.indexOf(47);
                        substring = resourceName;
                        if (index != -1) {
                            substring = resourceName.substring(index + 1);
                        }
                        this.getTargetWidget(child.getId()).z0(substring);
                        ++i;
                        continue Label_0137_Outer;
                        while (true) {
                            while (true) {
                                Block_14_Outer:Label_0242_Outer:
                                while (true) {
                                Label_0242:
                                    while (true) {
                                        Block_13: {
                                            while (true) {
                                                while (true) {
                                                    Block_18:Block_17_Outer:Label_0341_Outer:Label_0153_Outer:
                                                    while (true) {
                                                    Label_0341:
                                                        while (true) {
                                                            while (true) {
                                                                while (true) {
                                                                    ++i;
                                                                    break Block_14_Outer;
                                                                    Label_0268: {
                                                                        i = 0;
                                                                    }
                                                                    break Block_14_Outer;
                                                                    iftrue(Label_0452:)(i >= childCount);
                                                                    break Block_18;
                                                                    child2 = this.getChildAt(i);
                                                                    this.mTempMapIdToWidget.put(child2.getId(), (Object)this.getViewWidget(child2));
                                                                    ++i;
                                                                    break Label_0341;
                                                                    child3 = this.getChildAt(i);
                                                                    iftrue(Label_0299:)(!(child3 instanceof f));
                                                                    ((f)child3).b(this);
                                                                    continue Label_0383_Outer;
                                                                }
                                                                iftrue(Label_0381:)(i >= childCount);
                                                                continue Label_0341_Outer;
                                                            }
                                                            Label_0305: {
                                                                this.mTempMapIdToWidget.clear();
                                                            }
                                                            this.mTempMapIdToWidget.put(0, (Object)this.mLayoutWidget);
                                                            this.mTempMapIdToWidget.put(this.getId(), (Object)this.mLayoutWidget);
                                                            i = 0;
                                                            continue Label_0341;
                                                        }
                                                        Label_0411: {
                                                            b = (b)child4.getLayoutParams();
                                                        }
                                                        this.mLayoutWidget.a(viewWidget2);
                                                        this.applyConstraintsFromLayoutParams(inEditMode, child4, viewWidget2, b, this.mTempMapIdToWidget);
                                                        Label_0446: {
                                                            break Label_0446;
                                                            while (true) {
                                                                Block_11: {
                                                                Label_0153:
                                                                    while (true) {
                                                                        while (true) {
                                                                            i = 0;
                                                                            break Label_0153;
                                                                            iftrue(Label_0203:)(this.mConstraintSetId == -1);
                                                                            continue Label_0153_Outer;
                                                                        }
                                                                        this.mLayoutWidget.r1();
                                                                        size = this.mConstraintHelpers.size();
                                                                        iftrue(Label_0268:)(size <= 0);
                                                                        break Block_13;
                                                                        break Label_0446;
                                                                        while (true) {
                                                                            child5 = this.getChildAt(i);
                                                                            iftrue(Label_0197:)(child5.getId() != this.mConstraintSetId || !(child5 instanceof androidx.constraintlayout.widget.d));
                                                                            break Block_11;
                                                                            this.mConstraintHelpers.get(i).updatePreLayout(this);
                                                                            ++i;
                                                                            break Label_0242;
                                                                            iftrue(Label_0203:)(i >= childCount);
                                                                            continue Block_14_Outer;
                                                                        }
                                                                        ++i;
                                                                        continue Label_0153;
                                                                    }
                                                                    Label_0381:
                                                                    i = 0;
                                                                    continue Block_17_Outer;
                                                                }
                                                                this.mConstraintSet = ((androidx.constraintlayout.widget.d)child5).getConstraintSet();
                                                                continue Block_12_Outer;
                                                            }
                                                        }
                                                        ++i;
                                                        continue Block_17_Outer;
                                                    }
                                                    child4 = this.getChildAt(i);
                                                    viewWidget2 = this.getViewWidget(child4);
                                                    iftrue(Label_0411:)(viewWidget2 != null);
                                                    continue Block_14_Outer;
                                                }
                                                iftrue(Label_0268:)(i >= size);
                                                continue Label_0242_Outer;
                                            }
                                        }
                                        i = 0;
                                        continue Label_0242;
                                    }
                                    mConstraintSet.j(this, true);
                                    continue Label_0242_Outer;
                                }
                                iftrue(Label_0305:)(i >= childCount);
                                continue Block_12_Outer;
                            }
                            Label_0452: {
                                return;
                            }
                            Label_0203:
                            mConstraintSet = this.mConstraintSet;
                            iftrue(Label_0221:)(mConstraintSet == null);
                            continue;
                        }
                    }
                    catch (final Resources$NotFoundException ex) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    private void setWidgetBaseline(final ConstraintWidget constraintWidget, final b b, final SparseArray<ConstraintWidget> sparseArray, final int n, final ConstraintAnchor.Type type) {
        final View view = (View)this.mChildrenByIds.get(n);
        final ConstraintWidget constraintWidget2 = (ConstraintWidget)sparseArray.get(n);
        if (constraintWidget2 != null && view != null && view.getLayoutParams() instanceof b) {
            b.g0 = true;
            final ConstraintAnchor.Type baseline = ConstraintAnchor.Type.BASELINE;
            if (type == baseline) {
                final b b2 = (b)view.getLayoutParams();
                b2.g0 = true;
                b2.v0.H0(true);
            }
            constraintWidget.m(baseline).a(constraintWidget2.m(type), b.D, b.C, true);
            constraintWidget.H0(true);
            constraintWidget.m(ConstraintAnchor.Type.TOP).p();
            constraintWidget.m(ConstraintAnchor.Type.BOTTOM).p();
        }
    }
    
    private boolean updateHierarchy() {
        final int childCount = this.getChildCount();
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= childCount) {
                break;
            }
            if (this.getChildAt(n).isLayoutRequested()) {
                b2 = true;
                break;
            }
            ++n;
        }
        if (b2) {
            this.setChildrenConstraints();
        }
        return b2;
    }
    
    protected void applyConstraintsFromLayoutParams(final boolean b, final View view, final ConstraintWidget constraintWidget, final b b2, final SparseArray<ConstraintWidget> sparseArray) {
        b2.b();
        b2.w0 = false;
        constraintWidget.g1(view.getVisibility());
        if (b2.j0) {
            constraintWidget.Q0(true);
            constraintWidget.g1(8);
        }
        constraintWidget.y0(view);
        if (view instanceof a) {
            ((a)view).resolveRtl(constraintWidget, this.mLayoutWidget.M1());
        }
        if (b2.h0) {
            final androidx.constraintlayout.core.widgets.e e = (androidx.constraintlayout.core.widgets.e)constraintWidget;
            final int s0 = b2.s0;
            final int t0 = b2.t0;
            final float u0 = b2.u0;
            if (u0 != -1.0f) {
                e.w1(u0);
            }
            else if (s0 != -1) {
                e.u1(s0);
            }
            else if (t0 != -1) {
                e.v1(t0);
            }
        }
        else {
            final int l0 = b2.l0;
            final int m0 = b2.m0;
            final int n0 = b2.n0;
            final int o0 = b2.o0;
            final int p5 = b2.p0;
            final int q0 = b2.q0;
            final float r0 = b2.r0;
            final int p6 = b2.p;
            if (p6 != -1) {
                final ConstraintWidget constraintWidget2 = (ConstraintWidget)sparseArray.get(p6);
                if (constraintWidget2 != null) {
                    constraintWidget.j(constraintWidget2, b2.r, b2.q);
                }
            }
            else {
                if (l0 != -1) {
                    final ConstraintWidget constraintWidget3 = (ConstraintWidget)sparseArray.get(l0);
                    if (constraintWidget3 != null) {
                        final ConstraintAnchor.Type left = ConstraintAnchor.Type.LEFT;
                        constraintWidget.c0(left, constraintWidget3, left, b2.leftMargin, p5);
                    }
                }
                else if (m0 != -1) {
                    final ConstraintWidget constraintWidget4 = (ConstraintWidget)sparseArray.get(m0);
                    if (constraintWidget4 != null) {
                        constraintWidget.c0(ConstraintAnchor.Type.LEFT, constraintWidget4, ConstraintAnchor.Type.RIGHT, b2.leftMargin, p5);
                    }
                }
                if (n0 != -1) {
                    final ConstraintWidget constraintWidget5 = (ConstraintWidget)sparseArray.get(n0);
                    if (constraintWidget5 != null) {
                        constraintWidget.c0(ConstraintAnchor.Type.RIGHT, constraintWidget5, ConstraintAnchor.Type.LEFT, b2.rightMargin, q0);
                    }
                }
                else if (o0 != -1) {
                    final ConstraintWidget constraintWidget6 = (ConstraintWidget)sparseArray.get(o0);
                    if (constraintWidget6 != null) {
                        final ConstraintAnchor.Type right = ConstraintAnchor.Type.RIGHT;
                        constraintWidget.c0(right, constraintWidget6, right, b2.rightMargin, q0);
                    }
                }
                final int i = b2.i;
                if (i != -1) {
                    final ConstraintWidget constraintWidget7 = (ConstraintWidget)sparseArray.get(i);
                    if (constraintWidget7 != null) {
                        final ConstraintAnchor.Type top = ConstraintAnchor.Type.TOP;
                        constraintWidget.c0(top, constraintWidget7, top, b2.topMargin, b2.x);
                    }
                }
                else {
                    final int j = b2.j;
                    if (j != -1) {
                        final ConstraintWidget constraintWidget8 = (ConstraintWidget)sparseArray.get(j);
                        if (constraintWidget8 != null) {
                            constraintWidget.c0(ConstraintAnchor.Type.TOP, constraintWidget8, ConstraintAnchor.Type.BOTTOM, b2.topMargin, b2.x);
                        }
                    }
                }
                final int k = b2.k;
                if (k != -1) {
                    final ConstraintWidget constraintWidget9 = (ConstraintWidget)sparseArray.get(k);
                    if (constraintWidget9 != null) {
                        constraintWidget.c0(ConstraintAnchor.Type.BOTTOM, constraintWidget9, ConstraintAnchor.Type.TOP, b2.bottomMargin, b2.z);
                    }
                }
                else {
                    final int l2 = b2.l;
                    if (l2 != -1) {
                        final ConstraintWidget constraintWidget10 = (ConstraintWidget)sparseArray.get(l2);
                        if (constraintWidget10 != null) {
                            final ConstraintAnchor.Type bottom = ConstraintAnchor.Type.BOTTOM;
                            constraintWidget.c0(bottom, constraintWidget10, bottom, b2.bottomMargin, b2.z);
                        }
                    }
                }
                final int m2 = b2.m;
                if (m2 != -1) {
                    this.setWidgetBaseline(constraintWidget, b2, sparseArray, m2, ConstraintAnchor.Type.BASELINE);
                }
                else {
                    final int n2 = b2.n;
                    if (n2 != -1) {
                        this.setWidgetBaseline(constraintWidget, b2, sparseArray, n2, ConstraintAnchor.Type.TOP);
                    }
                    else {
                        final int o2 = b2.o;
                        if (o2 != -1) {
                            this.setWidgetBaseline(constraintWidget, b2, sparseArray, o2, ConstraintAnchor.Type.BOTTOM);
                        }
                    }
                }
                if (r0 >= 0.0f) {
                    constraintWidget.J0(r0);
                }
                final float h = b2.H;
                if (h >= 0.0f) {
                    constraintWidget.a1(h);
                }
            }
            if (b) {
                final int x = b2.X;
                if (x != -1 || b2.Y != -1) {
                    constraintWidget.Y0(x, b2.Y);
                }
            }
            if (!b2.e0) {
                if (b2.width == -1) {
                    if (b2.a0) {
                        constraintWidget.M0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    }
                    else {
                        constraintWidget.M0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.m(ConstraintAnchor.Type.LEFT).g = b2.leftMargin;
                    constraintWidget.m(ConstraintAnchor.Type.RIGHT).g = b2.rightMargin;
                }
                else {
                    constraintWidget.M0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.h1(0);
                }
            }
            else {
                constraintWidget.M0(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.h1(b2.width);
                if (b2.width == -2) {
                    constraintWidget.M0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            if (!b2.f0) {
                if (b2.height == -1) {
                    if (b2.b0) {
                        constraintWidget.d1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    }
                    else {
                        constraintWidget.d1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.m(ConstraintAnchor.Type.TOP).g = b2.topMargin;
                    constraintWidget.m(ConstraintAnchor.Type.BOTTOM).g = b2.bottomMargin;
                }
                else {
                    constraintWidget.d1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.I0(0);
                }
            }
            else {
                constraintWidget.d1(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.I0(b2.height);
                if (b2.height == -2) {
                    constraintWidget.d1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            constraintWidget.A0(b2.I);
            constraintWidget.O0(b2.L);
            constraintWidget.f1(b2.M);
            constraintWidget.K0(b2.N);
            constraintWidget.b1(b2.O);
            constraintWidget.i1(b2.d0);
            constraintWidget.N0(b2.P, b2.R, b2.T, b2.V);
            constraintWidget.e1(b2.Q, b2.S, b2.U, b2.W);
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof b;
    }
    
    protected void dispatchDraw(final Canvas canvas) {
        final ArrayList<a> mConstraintHelpers = this.mConstraintHelpers;
        if (mConstraintHelpers != null) {
            final int size = mConstraintHelpers.size();
            if (size > 0) {
                for (int i = 0; i < size; ++i) {
                    this.mConstraintHelpers.get(i).updatePreDraw(this);
                }
            }
        }
        super.dispatchDraw(canvas);
        if (this.isInEditMode()) {
            final float n = (float)this.getWidth();
            final float n2 = (float)this.getHeight();
            for (int childCount = this.getChildCount(), j = 0; j < childCount; ++j) {
                final View child = this.getChildAt(j);
                if (child.getVisibility() != 8) {
                    final Object tag = child.getTag();
                    if (tag != null && tag instanceof String) {
                        final String[] split = ((String)tag).split(",");
                        if (split.length == 4) {
                            final int int1 = Integer.parseInt(split[0]);
                            final int int2 = Integer.parseInt(split[1]);
                            final int int3 = Integer.parseInt(split[2]);
                            final int int4 = Integer.parseInt(split[3]);
                            final int n3 = (int)(int1 / 1080.0f * n);
                            final int n4 = (int)(int2 / 1920.0f * n2);
                            final int n5 = (int)(int3 / 1080.0f * n);
                            final int n6 = (int)(int4 / 1920.0f * n2);
                            final Paint paint = new Paint();
                            paint.setColor(-65536);
                            final float n7 = (float)n3;
                            final float n8 = (float)n4;
                            final float n9 = (float)(n3 + n5);
                            canvas.drawLine(n7, n8, n9, n8, paint);
                            final float n10 = (float)(n4 + n6);
                            canvas.drawLine(n9, n8, n9, n10, paint);
                            canvas.drawLine(n9, n10, n7, n10, paint);
                            canvas.drawLine(n7, n10, n7, n8, paint);
                            paint.setColor(-16711936);
                            canvas.drawLine(n7, n8, n9, n10, paint);
                            canvas.drawLine(n7, n10, n9, n8, paint);
                        }
                    }
                }
            }
        }
    }
    
    public void fillMetrics(final n.a a) {
        this.mLayoutWidget.F1(a);
    }
    
    public void forceLayout() {
        this.markHierarchyDirty();
        super.forceLayout();
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    protected b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new b(viewGroup$LayoutParams);
    }
    
    public b generateLayoutParams(final AttributeSet set) {
        return new b(this.getContext(), set);
    }
    
    public Object getDesignInformation(final int n, final Object o) {
        if (n == 0 && o instanceof String) {
            final String s = (String)o;
            final HashMap<String, Integer> mDesignIds = this.mDesignIds;
            if (mDesignIds != null && mDesignIds.containsKey(s)) {
                return this.mDesignIds.get(s);
            }
        }
        return null;
    }
    
    public int getMaxHeight() {
        return this.mMaxHeight;
    }
    
    public int getMaxWidth() {
        return this.mMaxWidth;
    }
    
    public int getMinHeight() {
        return this.mMinHeight;
    }
    
    public int getMinWidth() {
        return this.mMinWidth;
    }
    
    public int getOptimizationLevel() {
        return this.mLayoutWidget.H1();
    }
    
    public String getSceneString() {
        final StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.o == null) {
            final int id = this.getId();
            if (id != -1) {
                this.mLayoutWidget.o = this.getContext().getResources().getResourceEntryName(id);
            }
            else {
                this.mLayoutWidget.o = "parent";
            }
        }
        if (this.mLayoutWidget.r() == null) {
            final d mLayoutWidget = this.mLayoutWidget;
            mLayoutWidget.z0(mLayoutWidget.o);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" setDebugName ");
            sb2.append(this.mLayoutWidget.r());
            Log.v("ConstraintLayout", sb2.toString());
        }
        for (final ConstraintWidget constraintWidget : this.mLayoutWidget.o1()) {
            final View view = (View)constraintWidget.q();
            if (view != null) {
                if (constraintWidget.o == null) {
                    final int id2 = view.getId();
                    if (id2 != -1) {
                        constraintWidget.o = this.getContext().getResources().getResourceEntryName(id2);
                    }
                }
                if (constraintWidget.r() != null) {
                    continue;
                }
                constraintWidget.z0(constraintWidget.o);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(" setDebugName ");
                sb3.append(constraintWidget.r());
                Log.v("ConstraintLayout", sb3.toString());
            }
        }
        this.mLayoutWidget.M(sb);
        return sb.toString();
    }
    
    public View getViewById(final int n) {
        return (View)this.mChildrenByIds.get(n);
    }
    
    public final ConstraintWidget getViewWidget(final View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof b) {
                return ((b)view.getLayoutParams()).v0;
            }
            view.setLayoutParams(this.generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof b) {
                return ((b)view.getLayoutParams()).v0;
            }
        }
        return null;
    }
    
    protected boolean isRtl() {
        final int flags = this.getContext().getApplicationInfo().flags;
        final boolean b = false;
        final boolean b2 = (flags & 0x400000) != 0x0;
        boolean b3 = b;
        if (b2) {
            b3 = b;
            if (1 == this.getLayoutDirection()) {
                b3 = true;
            }
        }
        return b3;
    }
    
    public void loadLayoutDescription(final int n) {
        if (n != 0) {
            try {
                this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(this.getContext(), this, n);
            }
            catch (final Resources$NotFoundException ex) {
                this.mConstraintLayoutSpec = null;
            }
        }
        else {
            this.mConstraintLayoutSpec = null;
        }
    }
    
    protected void onLayout(final boolean b, int i, int n, int n2, int w) {
        n2 = this.getChildCount();
        final boolean inEditMode = this.isInEditMode();
        n = 0;
        View child;
        b b2;
        ConstraintWidget v0;
        int v2;
        int n3;
        int n4;
        View content;
        for (i = 0; i < n2; ++i) {
            child = this.getChildAt(i);
            b2 = (b)child.getLayoutParams();
            v0 = b2.v0;
            if (child.getVisibility() != 8 || b2.h0 || b2.i0 || b2.k0 || inEditMode) {
                if (!b2.j0) {
                    v2 = v0.V();
                    w = v0.W();
                    n3 = v0.U() + v2;
                    n4 = v0.v() + w;
                    child.layout(v2, w, n3, n4);
                    if (child instanceof f) {
                        content = ((f)child).getContent();
                        if (content != null) {
                            content.setVisibility(0);
                            content.layout(v2, w, n3, n4);
                        }
                    }
                }
            }
        }
        n2 = this.mConstraintHelpers.size();
        if (n2 > 0) {
            for (i = n; i < n2; ++i) {
                this.mConstraintHelpers.get(i).updatePostLayout(this);
            }
        }
    }
    
    protected void onMeasure(final int mOnMeasureWidthMeasureSpec, final int mOnMeasureHeightMeasureSpec) {
        if (this.mOnMeasureWidthMeasureSpec == mOnMeasureWidthMeasureSpec) {
            final int mOnMeasureHeightMeasureSpec2 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                if (this.getChildAt(i).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
            }
        }
        final boolean mDirtyHierarchy = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = mOnMeasureWidthMeasureSpec;
        this.mOnMeasureHeightMeasureSpec = mOnMeasureHeightMeasureSpec;
        this.mLayoutWidget.V1(this.isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (this.updateHierarchy()) {
                this.mLayoutWidget.X1();
            }
        }
        this.resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, mOnMeasureWidthMeasureSpec, mOnMeasureHeightMeasureSpec);
        this.resolveMeasuredDimension(mOnMeasureWidthMeasureSpec, mOnMeasureHeightMeasureSpec, this.mLayoutWidget.U(), this.mLayoutWidget.v(), this.mLayoutWidget.N1(), this.mLayoutWidget.L1());
    }
    
    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        final ConstraintWidget viewWidget = this.getViewWidget(view);
        if (view instanceof Guideline && !(viewWidget instanceof androidx.constraintlayout.core.widgets.e)) {
            final b b = (b)view.getLayoutParams();
            final androidx.constraintlayout.core.widgets.e v0 = new androidx.constraintlayout.core.widgets.e();
            b.v0 = v0;
            b.h0 = true;
            v0.x1(b.Z);
        }
        if (view instanceof a) {
            final a a = (a)view;
            a.validateParams();
            ((b)view.getLayoutParams()).i0 = true;
            if (!this.mConstraintHelpers.contains(a)) {
                this.mConstraintHelpers.add(a);
            }
        }
        this.mChildrenByIds.put(view.getId(), (Object)view);
        this.mDirtyHierarchy = true;
    }
    
    public void onViewRemoved(final View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.q1(this.getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }
    
    protected void parseLayoutDescription(final int n) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(this.getContext(), this, n);
    }
    
    public void requestLayout() {
        this.markHierarchyDirty();
        super.requestLayout();
    }
    
    protected void resolveMeasuredDimension(int resolveSizeAndState, int min, int n, final int n2, final boolean b, final boolean b2) {
        final c mMeasurer = this.mMeasurer;
        final int e = mMeasurer.e;
        resolveSizeAndState = ViewGroup.resolveSizeAndState(n + mMeasurer.d, resolveSizeAndState, 0);
        n = ViewGroup.resolveSizeAndState(n2 + e, min, 0);
        min = Math.min(this.mMaxWidth, resolveSizeAndState & 0xFFFFFF);
        n = Math.min(this.mMaxHeight, n & 0xFFFFFF);
        resolveSizeAndState = min;
        if (b) {
            resolveSizeAndState = (min | 0x1000000);
        }
        min = n;
        if (b2) {
            min = (n | 0x1000000);
        }
        this.setMeasuredDimension(resolveSizeAndState, min);
        this.mLastMeasureWidth = resolveSizeAndState;
        this.mLastMeasureHeight = min;
    }
    
    protected void resolveSystem(final d d, final int n, int n2, int max) {
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n2);
        final int mode2 = View$MeasureSpec.getMode(max);
        final int size2 = View$MeasureSpec.getSize(max);
        final int max2 = Math.max(0, this.getPaddingTop());
        final int max3 = Math.max(0, this.getPaddingBottom());
        final int n3 = max2 + max3;
        final int paddingWidth = this.getPaddingWidth();
        this.mMeasurer.c(n2, max, max2, max3, paddingWidth, n3);
        max = Math.max(0, this.getPaddingStart());
        n2 = Math.max(0, this.getPaddingEnd());
        if (max <= 0 && n2 <= 0) {
            n2 = Math.max(0, this.getPaddingLeft());
        }
        else if (!this.isRtl()) {
            n2 = max;
        }
        max = size - paddingWidth;
        final int n4 = size2 - n3;
        this.setSelfDimensionBehaviour(d, mode, max, mode2, n4);
        d.O1(n, mode, max, mode2, n4, this.mLastMeasureWidth, this.mLastMeasureHeight, n2, max2);
    }
    
    public void setConstraintSet(final androidx.constraintlayout.widget.c mConstraintSet) {
        this.mConstraintSet = mConstraintSet;
    }
    
    public void setDesignInformation(int n, final Object o, final Object o2) {
        if (n == 0 && o instanceof String && o2 instanceof Integer) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<String, Integer>();
            }
            final String s = (String)o;
            n = s.indexOf("/");
            String substring = s;
            if (n != -1) {
                substring = s.substring(n + 1);
            }
            n = (int)o2;
            this.mDesignIds.put(substring, n);
        }
    }
    
    public void setId(final int id) {
        this.mChildrenByIds.remove(this.getId());
        super.setId(id);
        this.mChildrenByIds.put(this.getId(), (Object)this);
    }
    
    public void setMaxHeight(final int mMaxHeight) {
        if (mMaxHeight == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = mMaxHeight;
        this.requestLayout();
    }
    
    public void setMaxWidth(final int mMaxWidth) {
        if (mMaxWidth == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = mMaxWidth;
        this.requestLayout();
    }
    
    public void setMinHeight(final int mMinHeight) {
        if (mMinHeight == this.mMinHeight) {
            return;
        }
        this.mMinHeight = mMinHeight;
        this.requestLayout();
    }
    
    public void setMinWidth(final int mMinWidth) {
        if (mMinWidth == this.mMinWidth) {
            return;
        }
        this.mMinWidth = mMinWidth;
        this.requestLayout();
    }
    
    public void setOnConstraintsChanged(final e e) {
        final androidx.constraintlayout.widget.b mConstraintLayoutSpec = this.mConstraintLayoutSpec;
        if (mConstraintLayoutSpec != null) {
            mConstraintLayoutSpec.c(e);
        }
    }
    
    public void setOptimizationLevel(final int mOptimizationLevel) {
        this.mOptimizationLevel = mOptimizationLevel;
        this.mLayoutWidget.T1(mOptimizationLevel);
    }
    
    protected void setSelfDimensionBehaviour(final d d, final int n, int n2, final int n3, int n4) {
        final c mMeasurer = this.mMeasurer;
        final int e = mMeasurer.e;
        final int d2 = mMeasurer.d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        final int childCount = this.getChildCount();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = null;
        Label_0134: {
            if (n != Integer.MIN_VALUE) {
                if (n != 0) {
                    if (n == 1073741824) {
                        n2 = Math.min(this.mMaxWidth - d2, n2);
                        dimensionBehaviour2 = dimensionBehaviour;
                        break Label_0134;
                    }
                    dimensionBehaviour2 = dimensionBehaviour;
                }
                else {
                    final ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (childCount == 0) {
                        n2 = Math.max(0, this.mMinWidth);
                        dimensionBehaviour2 = dimensionBehaviour3;
                        break Label_0134;
                    }
                }
                n2 = 0;
            }
            else {
                final ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    n2 = Math.max(0, this.mMinWidth);
                    dimensionBehaviour2 = dimensionBehaviour4;
                }
            }
        }
        Label_0237: {
            if (n3 != Integer.MIN_VALUE) {
                if (n3 != 0) {
                    if (n3 == 1073741824) {
                        n4 = Math.min(this.mMaxHeight - e, n4);
                        break Label_0237;
                    }
                }
                else {
                    final ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (childCount == 0) {
                        n4 = Math.max(0, this.mMinHeight);
                        dimensionBehaviour = dimensionBehaviour5;
                        break Label_0237;
                    }
                }
                n4 = 0;
            }
            else {
                final ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    n4 = Math.max(0, this.mMinHeight);
                    dimensionBehaviour = dimensionBehaviour6;
                }
            }
        }
        if (n2 != d.U() || n4 != d.v()) {
            d.K1();
        }
        d.j1(0);
        d.k1(0);
        d.U0(this.mMaxWidth - d2);
        d.T0(this.mMaxHeight - e);
        d.X0(0);
        d.W0(0);
        d.M0(dimensionBehaviour2);
        d.h1(n2);
        d.d1(dimensionBehaviour);
        d.I0(n4);
        d.X0(this.mMinWidth - d2);
        d.W0(this.mMinHeight - e);
    }
    
    public void setState(final int n, final int n2, final int n3) {
        final androidx.constraintlayout.widget.b mConstraintLayoutSpec = this.mConstraintLayoutSpec;
        if (mConstraintLayoutSpec != null) {
            mConstraintLayoutSpec.d(n, (float)n2, (float)n3);
        }
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    public static class b extends ViewGroup$MarginLayoutParams
    {
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;
        float J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;
        public int a;
        public boolean a0;
        public int b;
        public boolean b0;
        public float c;
        public String c0;
        public boolean d;
        public int d0;
        public int e;
        boolean e0;
        public int f;
        boolean f0;
        public int g;
        boolean g0;
        public int h;
        boolean h0;
        public int i;
        boolean i0;
        public int j;
        boolean j0;
        public int k;
        boolean k0;
        public int l;
        int l0;
        public int m;
        int m0;
        public int n;
        int n0;
        public int o;
        int o0;
        public int p;
        int p0;
        public int q;
        int q0;
        public float r;
        float r0;
        public int s;
        int s0;
        public int t;
        int t0;
        public int u;
        float u0;
        public int v;
        ConstraintWidget v0;
        public int w;
        public boolean w0;
        public int x;
        public int y;
        public int z;
        
        public b(final int n, final int n2) {
            super(n, n2);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.a0 = false;
            this.b0 = false;
            this.c0 = null;
            this.d0 = 0;
            this.e0 = true;
            this.f0 = true;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = false;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = -1;
            this.p0 = Integer.MIN_VALUE;
            this.q0 = Integer.MIN_VALUE;
            this.r0 = 0.5f;
            this.v0 = new ConstraintWidget();
            this.w0 = false;
        }
        
        public b(Context obtainStyledAttributes, final AttributeSet set) {
            super(obtainStyledAttributes, set);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.a0 = false;
            this.b0 = false;
            this.c0 = null;
            this.d0 = 0;
            this.e0 = true;
            this.f0 = true;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = false;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = -1;
            this.p0 = Integer.MIN_VALUE;
            this.q0 = Integer.MIN_VALUE;
            this.r0 = 0.5f;
            this.v0 = new ConstraintWidget();
            this.w0 = false;
            obtainStyledAttributes = (Context)obtainStyledAttributes.obtainStyledAttributes(set, h.n1);
            for (int indexCount = ((TypedArray)obtainStyledAttributes).getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = ((TypedArray)obtainStyledAttributes).getIndex(i);
                final int value = a.a.get(index);
                switch (value) {
                    default: {
                        switch (value) {
                            default: {
                                switch (value) {
                                    default: {
                                        continue;
                                    }
                                    case 67: {
                                        this.d = ((TypedArray)obtainStyledAttributes).getBoolean(index, this.d);
                                        continue;
                                    }
                                    case 66: {
                                        this.d0 = ((TypedArray)obtainStyledAttributes).getInt(index, this.d0);
                                        continue;
                                    }
                                    case 65: {
                                        androidx.constraintlayout.widget.c.A(this, (TypedArray)obtainStyledAttributes, index, 1);
                                        this.F = true;
                                        continue;
                                    }
                                    case 64: {
                                        androidx.constraintlayout.widget.c.A(this, (TypedArray)obtainStyledAttributes, index, 0);
                                        this.E = true;
                                        continue;
                                    }
                                }
                                break;
                            }
                            case 55: {
                                this.C = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.C);
                                continue;
                            }
                            case 54: {
                                this.D = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.D);
                                continue;
                            }
                            case 53: {
                                final int resourceId = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.o);
                                this.o = resourceId;
                                if (resourceId == -1) {
                                    this.o = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                                    continue;
                                }
                                continue;
                            }
                            case 52: {
                                final int resourceId2 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.n);
                                this.n = resourceId2;
                                if (resourceId2 == -1) {
                                    this.n = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                                    continue;
                                }
                                continue;
                            }
                            case 51: {
                                this.c0 = ((TypedArray)obtainStyledAttributes).getString(index);
                                continue;
                            }
                            case 50: {
                                this.Y = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.Y);
                                continue;
                            }
                            case 49: {
                                this.X = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.X);
                                continue;
                            }
                            case 48: {
                                this.O = ((TypedArray)obtainStyledAttributes).getInt(index, 0);
                                continue;
                            }
                            case 47: {
                                this.N = ((TypedArray)obtainStyledAttributes).getInt(index, 0);
                                continue;
                            }
                            case 46: {
                                this.M = ((TypedArray)obtainStyledAttributes).getFloat(index, this.M);
                                continue;
                            }
                            case 45: {
                                this.L = ((TypedArray)obtainStyledAttributes).getFloat(index, this.L);
                                continue;
                            }
                            case 44: {
                                androidx.constraintlayout.widget.c.C(this, ((TypedArray)obtainStyledAttributes).getString(index));
                                continue;
                            }
                        }
                        break;
                    }
                    case 38: {
                        this.W = Math.max(0.0f, ((TypedArray)obtainStyledAttributes).getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    }
                    case 37: {
                        try {
                            this.U = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.U);
                        }
                        catch (final Exception ex) {
                            if (((TypedArray)obtainStyledAttributes).getInt(index, this.U) == -2) {
                                this.U = -2;
                            }
                        }
                        break;
                    }
                    case 36: {
                        try {
                            this.S = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.S);
                        }
                        catch (final Exception ex2) {
                            if (((TypedArray)obtainStyledAttributes).getInt(index, this.S) == -2) {
                                this.S = -2;
                            }
                        }
                        break;
                    }
                    case 35: {
                        this.V = Math.max(0.0f, ((TypedArray)obtainStyledAttributes).getFloat(index, this.V));
                        this.P = 2;
                        break;
                    }
                    case 34: {
                        try {
                            this.T = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.T);
                        }
                        catch (final Exception ex3) {
                            if (((TypedArray)obtainStyledAttributes).getInt(index, this.T) == -2) {
                                this.T = -2;
                            }
                        }
                        break;
                    }
                    case 33: {
                        try {
                            this.R = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.R);
                        }
                        catch (final Exception ex4) {
                            if (((TypedArray)obtainStyledAttributes).getInt(index, this.R) == -2) {
                                this.R = -2;
                            }
                        }
                        break;
                    }
                    case 32: {
                        final int int1 = ((TypedArray)obtainStyledAttributes).getInt(index, 0);
                        this.Q = int1;
                        if (int1 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                        break;
                    }
                    case 31: {
                        final int int2 = ((TypedArray)obtainStyledAttributes).getInt(index, 0);
                        this.P = int2;
                        if (int2 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                        break;
                    }
                    case 30: {
                        this.H = ((TypedArray)obtainStyledAttributes).getFloat(index, this.H);
                        break;
                    }
                    case 29: {
                        this.G = ((TypedArray)obtainStyledAttributes).getFloat(index, this.G);
                        break;
                    }
                    case 28: {
                        this.b0 = ((TypedArray)obtainStyledAttributes).getBoolean(index, this.b0);
                        break;
                    }
                    case 27: {
                        this.a0 = ((TypedArray)obtainStyledAttributes).getBoolean(index, this.a0);
                        break;
                    }
                    case 26: {
                        this.B = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.B);
                        break;
                    }
                    case 25: {
                        this.A = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.A);
                        break;
                    }
                    case 24: {
                        this.z = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.z);
                        break;
                    }
                    case 23: {
                        this.y = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.y);
                        break;
                    }
                    case 22: {
                        this.x = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.x);
                        break;
                    }
                    case 21: {
                        this.w = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.w);
                        break;
                    }
                    case 20: {
                        final int resourceId3 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.v);
                        this.v = resourceId3;
                        if (resourceId3 == -1) {
                            this.v = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 19: {
                        final int resourceId4 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.u);
                        this.u = resourceId4;
                        if (resourceId4 == -1) {
                            this.u = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 18: {
                        final int resourceId5 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.t);
                        this.t = resourceId5;
                        if (resourceId5 == -1) {
                            this.t = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 17: {
                        final int resourceId6 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.s);
                        this.s = resourceId6;
                        if (resourceId6 == -1) {
                            this.s = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 16: {
                        final int resourceId7 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.m);
                        this.m = resourceId7;
                        if (resourceId7 == -1) {
                            this.m = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 15: {
                        final int resourceId8 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.l);
                        this.l = resourceId8;
                        if (resourceId8 == -1) {
                            this.l = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 14: {
                        final int resourceId9 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 13: {
                        final int resourceId10 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.j);
                        this.j = resourceId10;
                        if (resourceId10 == -1) {
                            this.j = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 12: {
                        final int resourceId11 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.i);
                        this.i = resourceId11;
                        if (resourceId11 == -1) {
                            this.i = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 11: {
                        final int resourceId12 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.h);
                        this.h = resourceId12;
                        if (resourceId12 == -1) {
                            this.h = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 10: {
                        final int resourceId13 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.g);
                        this.g = resourceId13;
                        if (resourceId13 == -1) {
                            this.g = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 9: {
                        final int resourceId14 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.f);
                        this.f = resourceId14;
                        if (resourceId14 == -1) {
                            this.f = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 8: {
                        final int resourceId15 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.e);
                        this.e = resourceId15;
                        if (resourceId15 == -1) {
                            this.e = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 7: {
                        this.c = ((TypedArray)obtainStyledAttributes).getFloat(index, this.c);
                        break;
                    }
                    case 6: {
                        this.b = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.b);
                        break;
                    }
                    case 5: {
                        this.a = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(index, this.a);
                        break;
                    }
                    case 4: {
                        final float r = ((TypedArray)obtainStyledAttributes).getFloat(index, this.r) % 360.0f;
                        this.r = r;
                        if (r < 0.0f) {
                            this.r = (360.0f - r) % 360.0f;
                            break;
                        }
                        break;
                    }
                    case 3: {
                        this.q = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(index, this.q);
                        break;
                    }
                    case 2: {
                        final int resourceId16 = ((TypedArray)obtainStyledAttributes).getResourceId(index, this.p);
                        this.p = resourceId16;
                        if (resourceId16 == -1) {
                            this.p = ((TypedArray)obtainStyledAttributes).getInt(index, -1);
                            break;
                        }
                        break;
                    }
                    case 1: {
                        this.Z = ((TypedArray)obtainStyledAttributes).getInt(index, this.Z);
                        break;
                    }
                }
            }
            ((TypedArray)obtainStyledAttributes).recycle();
            this.b();
        }
        
        public b(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.a0 = false;
            this.b0 = false;
            this.c0 = null;
            this.d0 = 0;
            this.e0 = true;
            this.f0 = true;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = false;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = -1;
            this.p0 = Integer.MIN_VALUE;
            this.q0 = Integer.MIN_VALUE;
            this.r0 = 0.5f;
            this.v0 = new ConstraintWidget();
            this.w0 = false;
        }
        
        public String a() {
            return this.c0;
        }
        
        public void b() {
            this.h0 = false;
            this.e0 = true;
            this.f0 = true;
            final int width = super.width;
            if (width == -2 && this.a0) {
                this.e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            final int height = super.height;
            if (height == -2 && this.b0) {
                this.f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (width == 0 || width == -1) {
                this.e0 = false;
                if (width == 0 && this.P == 1) {
                    super.width = -2;
                    this.a0 = true;
                }
            }
            if (height == 0 || height == -1) {
                this.f0 = false;
                if (height == 0 && this.Q == 1) {
                    super.height = -2;
                    this.b0 = true;
                }
            }
            if (this.c != -1.0f || this.a != -1 || this.b != -1) {
                this.h0 = true;
                this.e0 = true;
                this.f0 = true;
                if (!(this.v0 instanceof androidx.constraintlayout.core.widgets.e)) {
                    this.v0 = new androidx.constraintlayout.core.widgets.e();
                }
                ((androidx.constraintlayout.core.widgets.e)this.v0).x1(this.Z);
            }
        }
        
        public void resolveLayoutDirection(int m0) {
            final int leftMargin = super.leftMargin;
            final int rightMargin = super.rightMargin;
            super.resolveLayoutDirection(m0);
            m0 = this.getLayoutDirection();
            final int n = 0;
            if (1 == m0) {
                m0 = 1;
            }
            else {
                m0 = 0;
            }
            this.n0 = -1;
            this.o0 = -1;
            this.l0 = -1;
            this.m0 = -1;
            this.p0 = this.w;
            this.q0 = this.y;
            final float g = this.G;
            this.r0 = g;
            final int a = this.a;
            this.s0 = a;
            final int b = this.b;
            this.t0 = b;
            final float c = this.c;
            this.u0 = c;
            if (m0 != 0) {
                m0 = this.s;
                Label_0165: {
                    if (m0 != -1) {
                        this.n0 = m0;
                    }
                    else {
                        final int t = this.t;
                        m0 = n;
                        if (t == -1) {
                            break Label_0165;
                        }
                        this.o0 = t;
                    }
                    m0 = 1;
                }
                final int u = this.u;
                if (u != -1) {
                    this.m0 = u;
                    m0 = 1;
                }
                final int v = this.v;
                if (v != -1) {
                    this.l0 = v;
                    m0 = 1;
                }
                final int a2 = this.A;
                if (a2 != Integer.MIN_VALUE) {
                    this.q0 = a2;
                }
                final int b2 = this.B;
                if (b2 != Integer.MIN_VALUE) {
                    this.p0 = b2;
                }
                if (m0 != 0) {
                    this.r0 = 1.0f - g;
                }
                if (this.h0 && this.Z == 1 && this.d) {
                    if (c != -1.0f) {
                        this.u0 = 1.0f - c;
                        this.s0 = -1;
                        this.t0 = -1;
                    }
                    else if (a != -1) {
                        this.t0 = a;
                        this.s0 = -1;
                        this.u0 = -1.0f;
                    }
                    else if (b != -1) {
                        this.s0 = b;
                        this.t0 = -1;
                        this.u0 = -1.0f;
                    }
                }
            }
            else {
                m0 = this.s;
                if (m0 != -1) {
                    this.m0 = m0;
                }
                m0 = this.t;
                if (m0 != -1) {
                    this.l0 = m0;
                }
                m0 = this.u;
                if (m0 != -1) {
                    this.n0 = m0;
                }
                m0 = this.v;
                if (m0 != -1) {
                    this.o0 = m0;
                }
                m0 = this.A;
                if (m0 != Integer.MIN_VALUE) {
                    this.p0 = m0;
                }
                m0 = this.B;
                if (m0 != Integer.MIN_VALUE) {
                    this.q0 = m0;
                }
            }
            if (this.u == -1 && this.v == -1 && this.t == -1 && this.s == -1) {
                m0 = this.g;
                if (m0 != -1) {
                    this.n0 = m0;
                    if (super.rightMargin <= 0 && rightMargin > 0) {
                        super.rightMargin = rightMargin;
                    }
                }
                else {
                    m0 = this.h;
                    if (m0 != -1) {
                        this.o0 = m0;
                        if (super.rightMargin <= 0 && rightMargin > 0) {
                            super.rightMargin = rightMargin;
                        }
                    }
                }
                m0 = this.e;
                if (m0 != -1) {
                    this.l0 = m0;
                    if (super.leftMargin <= 0 && leftMargin > 0) {
                        super.leftMargin = leftMargin;
                    }
                }
                else {
                    m0 = this.f;
                    if (m0 != -1) {
                        this.m0 = m0;
                        if (super.leftMargin <= 0 && leftMargin > 0) {
                            super.leftMargin = leftMargin;
                        }
                    }
                }
            }
        }
        
        private static class a
        {
            public static final SparseIntArray a;
            
            static {
                final SparseIntArray a2 = new SparseIntArray();
                (a = a2).append(h.s2, 64);
                a2.append(h.V1, 65);
                a2.append(h.e2, 8);
                a2.append(h.f2, 9);
                a2.append(h.h2, 10);
                a2.append(h.i2, 11);
                a2.append(h.o2, 12);
                a2.append(h.n2, 13);
                a2.append(h.L1, 14);
                a2.append(h.K1, 15);
                a2.append(h.G1, 16);
                a2.append(h.I1, 52);
                a2.append(h.H1, 53);
                a2.append(h.M1, 2);
                a2.append(h.O1, 3);
                a2.append(h.N1, 4);
                a2.append(h.x2, 49);
                a2.append(h.y2, 50);
                a2.append(h.S1, 5);
                a2.append(h.T1, 6);
                a2.append(h.U1, 7);
                a2.append(h.B1, 67);
                a2.append(h.o1, 1);
                a2.append(h.j2, 17);
                a2.append(h.k2, 18);
                a2.append(h.R1, 19);
                a2.append(h.Q1, 20);
                a2.append(h.C2, 21);
                a2.append(h.F2, 22);
                a2.append(h.D2, 23);
                a2.append(h.A2, 24);
                a2.append(h.E2, 25);
                a2.append(h.B2, 26);
                a2.append(h.z2, 55);
                a2.append(h.G2, 54);
                a2.append(h.a2, 29);
                a2.append(h.p2, 30);
                a2.append(h.P1, 44);
                a2.append(h.c2, 45);
                a2.append(h.r2, 46);
                a2.append(h.b2, 47);
                a2.append(h.q2, 48);
                a2.append(h.E1, 27);
                a2.append(h.D1, 28);
                a2.append(h.t2, 31);
                a2.append(h.W1, 32);
                a2.append(h.v2, 33);
                a2.append(h.u2, 34);
                a2.append(h.w2, 35);
                a2.append(h.Y1, 36);
                a2.append(h.X1, 37);
                a2.append(h.Z1, 38);
                a2.append(h.d2, 39);
                a2.append(h.m2, 40);
                a2.append(h.g2, 41);
                a2.append(h.J1, 42);
                a2.append(h.F1, 43);
                a2.append(h.l2, 51);
                a2.append(h.I2, 66);
            }
        }
    }
    
    class c implements b.b
    {
        ConstraintLayout a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        final ConstraintLayout h;
        
        public c(final ConstraintLayout h, final ConstraintLayout a) {
            this.h = h;
            this.a = a;
        }
        
        private boolean d(int mode, int size, final int n) {
            if (mode == size) {
                return true;
            }
            final int mode2 = View$MeasureSpec.getMode(mode);
            View$MeasureSpec.getSize(mode);
            mode = View$MeasureSpec.getMode(size);
            size = View$MeasureSpec.getSize(size);
            return mode == 1073741824 && (mode2 == Integer.MIN_VALUE || mode2 == 0) && n == size;
        }
        
        @Override
        public final void a() {
            final int childCount = this.a.getChildCount();
            final int n = 0;
            for (int i = 0; i < childCount; ++i) {
                final View child = this.a.getChildAt(i);
                if (child instanceof f) {
                    ((f)child).a(this.a);
                }
            }
            final int size = ConstraintLayout.access$100(this.a).size();
            if (size > 0) {
                for (int j = n; j < size; ++j) {
                    ((androidx.constraintlayout.widget.a)ConstraintLayout.access$100(this.a).get(j)).updatePostMeasure(this.a);
                }
            }
        }
        
        @Override
        public final void b(final ConstraintWidget constraintWidget, final a a) {
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.T() == 8 && !constraintWidget.h0()) {
                a.e = 0;
                a.f = 0;
                a.g = 0;
                return;
            }
            if (constraintWidget.I() == null) {
                return;
            }
            final ConstraintWidget.DimensionBehaviour a2 = a.a;
            final ConstraintWidget.DimensionBehaviour b = a.b;
            final int c = a.c;
            final int d = a.d;
            final int n = this.b + this.c;
            final int d2 = this.d;
            final View view = (View)constraintWidget.q();
            final int[] a3 = ConstraintLayout$a.a;
            final int n2 = a3[a2.ordinal()];
            int n3 = 0;
            Label_0337: {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                n3 = 0;
                            }
                            else {
                                final int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, d2, -2);
                                final boolean b2 = constraintWidget.w == 1;
                                final int j = a.j;
                                if (j != androidx.constraintlayout.core.widgets.analyzer.b.a.l) {
                                    n3 = childMeasureSpec;
                                    if (j != androidx.constraintlayout.core.widgets.analyzer.b.a.m) {
                                        break Label_0337;
                                    }
                                }
                                final boolean b3 = view.getMeasuredHeight() == constraintWidget.v();
                                final boolean b4 = a.j == androidx.constraintlayout.core.widgets.analyzer.b.a.m || !b2 || (b2 && b3) || view instanceof f || constraintWidget.l0();
                                n3 = childMeasureSpec;
                                if (b4) {
                                    n3 = View$MeasureSpec.makeMeasureSpec(constraintWidget.U(), 1073741824);
                                }
                            }
                        }
                        else {
                            n3 = ViewGroup.getChildMeasureSpec(this.f, d2 + constraintWidget.z(), -1);
                        }
                    }
                    else {
                        n3 = ViewGroup.getChildMeasureSpec(this.f, d2, -2);
                    }
                }
                else {
                    n3 = View$MeasureSpec.makeMeasureSpec(c, 1073741824);
                }
            }
            final int n4 = a3[b.ordinal()];
            int n5 = 0;
            Label_0574: {
                if (n4 != 1) {
                    if (n4 != 2) {
                        if (n4 != 3) {
                            if (n4 != 4) {
                                n5 = 0;
                            }
                            else {
                                final int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, n, -2);
                                final boolean b5 = constraintWidget.x == 1;
                                final int i = a.j;
                                if (i != androidx.constraintlayout.core.widgets.analyzer.b.a.l) {
                                    n5 = childMeasureSpec2;
                                    if (i != androidx.constraintlayout.core.widgets.analyzer.b.a.m) {
                                        break Label_0574;
                                    }
                                }
                                final boolean b6 = view.getMeasuredWidth() == constraintWidget.U();
                                final boolean b7 = a.j == androidx.constraintlayout.core.widgets.analyzer.b.a.m || !b5 || (b5 && b6) || view instanceof f || constraintWidget.m0();
                                n5 = childMeasureSpec2;
                                if (b7) {
                                    n5 = View$MeasureSpec.makeMeasureSpec(constraintWidget.v(), 1073741824);
                                }
                            }
                        }
                        else {
                            n5 = ViewGroup.getChildMeasureSpec(this.g, n + constraintWidget.S(), -1);
                        }
                    }
                    else {
                        n5 = ViewGroup.getChildMeasureSpec(this.g, n, -2);
                    }
                }
                else {
                    n5 = View$MeasureSpec.makeMeasureSpec(d, 1073741824);
                }
            }
            final d d3 = (d)constraintWidget.I();
            if (d3 != null && androidx.constraintlayout.core.widgets.f.b(ConstraintLayout.access$000(this.h), 256) && view.getMeasuredWidth() == constraintWidget.U() && view.getMeasuredWidth() < d3.U() && view.getMeasuredHeight() == constraintWidget.v() && view.getMeasuredHeight() < d3.v() && view.getBaseline() == constraintWidget.n() && !constraintWidget.k0() && (this.d(constraintWidget.A(), n3, constraintWidget.U()) && this.d(constraintWidget.B(), n5, constraintWidget.v()))) {
                a.e = constraintWidget.U();
                a.f = constraintWidget.v();
                a.g = constraintWidget.n();
                return;
            }
            final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            final boolean b8 = a2 == match_CONSTRAINT;
            final boolean b9 = b == match_CONSTRAINT;
            final ConstraintWidget.DimensionBehaviour match_PARENT = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            final boolean b10 = b == match_PARENT || b == ConstraintWidget.DimensionBehaviour.FIXED;
            final boolean b11 = a2 == match_PARENT || a2 == ConstraintWidget.DimensionBehaviour.FIXED;
            final boolean b12 = b8 && constraintWidget.d0 > 0.0f;
            final boolean b13 = b9 && constraintWidget.d0 > 0.0f;
            if (view == null) {
                return;
            }
            final ConstraintLayout.b b14 = (ConstraintLayout.b)view.getLayoutParams();
            final int k = a.j;
            int measuredHeight = 0;
            int baseline = 0;
            int measuredWidth = 0;
            Label_1352: {
                if (k != androidx.constraintlayout.core.widgets.analyzer.b.a.l && k != androidx.constraintlayout.core.widgets.analyzer.b.a.m && b8 && constraintWidget.w == 0 && b9 && constraintWidget.x == 0) {
                    measuredHeight = 0;
                    baseline = 0;
                    measuredWidth = 0;
                }
                else {
                    if (view instanceof k && constraintWidget instanceof g) {
                        ((k)view).e((g)constraintWidget, n3, n5);
                    }
                    else {
                        view.measure(n3, n5);
                    }
                    constraintWidget.S0(n3, n5);
                    final int measuredWidth2 = view.getMeasuredWidth();
                    final int measuredHeight2 = view.getMeasuredHeight();
                    final int baseline2 = view.getBaseline();
                    final int z = constraintWidget.z;
                    int max;
                    if (z > 0) {
                        max = Math.max(z, measuredWidth2);
                    }
                    else {
                        max = measuredWidth2;
                    }
                    final int a4 = constraintWidget.A;
                    int min = max;
                    if (a4 > 0) {
                        min = Math.min(a4, max);
                    }
                    final int c2 = constraintWidget.C;
                    int max2;
                    if (c2 > 0) {
                        max2 = Math.max(c2, measuredHeight2);
                    }
                    else {
                        max2 = measuredHeight2;
                    }
                    final int d4 = constraintWidget.D;
                    int min2 = max2;
                    if (d4 > 0) {
                        min2 = Math.min(d4, max2);
                    }
                    int n6 = min2;
                    int n7 = min;
                    if (!androidx.constraintlayout.core.widgets.f.b(ConstraintLayout.access$000(this.h), 1)) {
                        if (b12 && b10) {
                            n7 = (int)(min2 * constraintWidget.d0 + 0.5f);
                            n6 = min2;
                        }
                        else {
                            n6 = min2;
                            n7 = min;
                            if (b13) {
                                n6 = min2;
                                n7 = min;
                                if (b11) {
                                    n6 = (int)(min / constraintWidget.d0 + 0.5f);
                                    n7 = min;
                                }
                            }
                        }
                    }
                    Label_1276: {
                        if (measuredWidth2 != n7) {
                            break Label_1276;
                        }
                        measuredHeight = n6;
                        baseline = baseline2;
                        measuredWidth = n7;
                        if (measuredHeight2 != n6) {
                            break Label_1276;
                        }
                        break Label_1352;
                    }
                    if (measuredWidth2 != n7) {
                        n3 = View$MeasureSpec.makeMeasureSpec(n7, 1073741824);
                    }
                    if (measuredHeight2 != n6) {
                        n5 = View$MeasureSpec.makeMeasureSpec(n6, 1073741824);
                    }
                    view.measure(n3, n5);
                    constraintWidget.S0(n3, n5);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
            }
            boolean h = baseline != -1;
            a.i = (measuredWidth != a.c || measuredHeight != a.d);
            if (b14.g0) {
                h = true;
            }
            if (h && baseline != -1 && constraintWidget.n() != baseline) {
                a.i = true;
            }
            a.e = measuredWidth;
            a.f = measuredHeight;
            a.h = h;
            a.g = baseline;
        }
        
        public void c(final int f, final int g, final int b, final int c, final int d, final int e) {
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
    }
}
