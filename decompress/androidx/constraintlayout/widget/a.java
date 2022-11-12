// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.widgets.d;
import android.graphics.Canvas;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import android.util.SparseArray;
import r.b;
import android.content.res.TypedArray;
import android.view.ViewParent;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import java.util.Arrays;
import android.util.Log;
import android.util.AttributeSet;
import android.content.Context;
import java.util.HashMap;
import android.view.View;

public abstract class a extends View
{
    protected int mCount;
    protected r.a mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;
    
    public a(final Context myContext) {
        super(myContext);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<Integer, String>();
        this.myContext = myContext;
        this.init(null);
    }
    
    public a(final Context myContext, final AttributeSet set) {
        super(myContext, set);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<Integer, String>();
        this.myContext = myContext;
        this.init(set);
    }
    
    public a(final Context myContext, final AttributeSet set, final int n) {
        super(myContext, set, n);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<Integer, String>();
        this.myContext = myContext;
        this.init(set);
    }
    
    private void addID(String trim) {
        if (trim != null) {
            if (trim.length() != 0) {
                if (this.myContext == null) {
                    return;
                }
                trim = trim.trim();
                if (this.getParent() instanceof ConstraintLayout) {
                    final ConstraintLayout constraintLayout = (ConstraintLayout)this.getParent();
                }
                final int id = this.findId(trim);
                if (id != 0) {
                    this.mMap.put(id, trim);
                    this.addRscID(id);
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Could not find id of \"");
                    sb.append(trim);
                    sb.append("\"");
                    Log.w("ConstraintHelper", sb.toString());
                }
            }
        }
    }
    
    private void addRscID(final int n) {
        if (n == this.getId()) {
            return;
        }
        final int mCount = this.mCount;
        final int[] mIds = this.mIds;
        if (mCount + 1 > mIds.length) {
            this.mIds = Arrays.copyOf(mIds, mIds.length * 2);
        }
        final int[] mIds2 = this.mIds;
        final int mCount2 = this.mCount;
        mIds2[mCount2] = n;
        this.mCount = mCount2 + 1;
    }
    
    private void addTag(final String s) {
        if (s != null) {
            if (s.length() != 0) {
                if (this.myContext == null) {
                    return;
                }
                final String trim = s.trim();
                ViewGroup viewGroup = null;
                if (this.getParent() instanceof ConstraintLayout) {
                    viewGroup = (ConstraintLayout)this.getParent();
                }
                if (viewGroup == null) {
                    Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                    return;
                }
                for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = viewGroup.getChildAt(i);
                    final ViewGroup$LayoutParams layoutParams = child.getLayoutParams();
                    if (layoutParams instanceof ConstraintLayout.b && trim.equals(((ConstraintLayout.b)layoutParams).c0)) {
                        if (child.getId() == -1) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("to use ConstraintTag view ");
                            sb.append(child.getClass().getSimpleName());
                            sb.append(" must have an ID");
                            Log.w("ConstraintHelper", sb.toString());
                        }
                        else {
                            this.addRscID(child.getId());
                        }
                    }
                }
            }
        }
    }
    
    private int[] convertReferenceString(final View view, final String s) {
        final String[] split = s.split(",");
        view.getContext();
        final int[] array = new int[split.length];
        int i = 0;
        int n = 0;
        while (i < split.length) {
            final int id = this.findId(split[i].trim());
            int n2 = n;
            if (id != 0) {
                array[n] = id;
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
        int[] copy = array;
        if (n != split.length) {
            copy = Arrays.copyOf(array, n);
        }
        return copy;
    }
    
    private int findId(final ConstraintLayout constraintLayout, final String s) {
        if (s == null) {
            return 0;
        }
        if (constraintLayout == null) {
            return 0;
        }
        final Resources resources = this.myContext.getResources();
        if (resources == null) {
            return 0;
        }
        final int childCount = constraintLayout.getChildCount();
        int n = 0;
    Label_0076_Outer:
        while (true) {
            if (n >= childCount) {
                return 0;
            }
            final View child = constraintLayout.getChildAt(n);
            Label_0091: {
                if (child.getId() == -1) {
                    break Label_0091;
                }
                Object resourceEntryName = null;
                while (true) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(child.getId());
                        if (s.equals(resourceEntryName)) {
                            return child.getId();
                        }
                        ++n;
                        continue Label_0076_Outer;
                    }
                    catch (final Resources$NotFoundException ex) {
                        continue;
                    }
                    break;
                }
            }
            break;
        }
    }
    
    private int findId(final String s) {
        ConstraintLayout constraintLayout;
        if (this.getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout)this.getParent();
        }
        else {
            constraintLayout = null;
        }
        final boolean inEditMode = this.isInEditMode();
        int intValue;
        final int n = intValue = 0;
        if (inEditMode) {
            intValue = n;
            if (constraintLayout != null) {
                final Object designInformation = constraintLayout.getDesignInformation(0, s);
                intValue = n;
                if (designInformation instanceof Integer) {
                    intValue = (int)designInformation;
                }
            }
        }
        int n2;
        if ((n2 = intValue) == 0) {
            n2 = intValue;
            if (constraintLayout != null) {
                n2 = this.findId(constraintLayout, s);
            }
        }
        while (true) {
            int int1;
            if ((int1 = n2) != 0) {
                break Label_0113;
            }
            try {
                int1 = g.class.getField(s).getInt(null);
                if ((n2 = int1) == 0) {
                    n2 = this.myContext.getResources().getIdentifier(s, "id", this.myContext.getPackageName());
                }
                return n2;
            }
            catch (final Exception ex) {
                int1 = n2;
                continue;
            }
            break;
        }
    }
    
    public void addView(final View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
            return;
        }
        if (view.getParent() == null) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
            return;
        }
        this.mReferenceIds = null;
        this.addRscID(view.getId());
        this.requestLayout();
    }
    
    protected void applyLayoutFeatures() {
        final ViewParent parent = this.getParent();
        if (parent != null && parent instanceof ConstraintLayout) {
            this.applyLayoutFeatures((ConstraintLayout)parent);
        }
    }
    
    protected void applyLayoutFeatures(final ConstraintLayout constraintLayout) {
        final int visibility = this.getVisibility();
        final float elevation = this.getElevation();
        for (int i = 0; i < this.mCount; ++i) {
            final View viewById = constraintLayout.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }
    
    protected void applyLayoutFeaturesInConstraintSet(final ConstraintLayout constraintLayout) {
    }
    
    public boolean containsId(final int n) {
        final int[] mIds = this.mIds;
        final int length = mIds.length;
        final boolean b = false;
        int n2 = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n2 >= length) {
                break;
            }
            if (mIds[n2] == n) {
                b2 = true;
                break;
            }
            ++n2;
        }
        return b2;
    }
    
    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }
    
    protected View[] getViews(final ConstraintLayout constraintLayout) {
        final View[] mViews = this.mViews;
        if (mViews == null || mViews.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; ++i) {
            this.mViews[i] = constraintLayout.getViewById(this.mIds[i]);
        }
        return this.mViews;
    }
    
    public int indexFromId(final int n) {
        final int[] mIds = this.mIds;
        final int length = mIds.length;
        int n2 = -1;
        for (final int n3 : mIds) {
            ++n2;
            if (n3 == n) {
                return n2;
            }
        }
        return n2;
    }
    
    protected void init(final AttributeSet set) {
        if (set != null) {
            final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, h.n1);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.z1) {
                    this.setIds(this.mReferenceIds = obtainStyledAttributes.getString(index));
                }
                else if (index == h.A1) {
                    this.setReferenceTags(this.mReferenceTags = obtainStyledAttributes.getString(index));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public void loadParameters(final c.a a, final b b, final ConstraintLayout.b b2, final SparseArray<ConstraintWidget> sparseArray) {
        final c.b e = a.e;
        final int[] k0 = e.k0;
        if (k0 != null) {
            this.setReferencedIds(k0);
        }
        else {
            final String l0 = e.l0;
            if (l0 != null) {
                if (l0.length() > 0) {
                    final c.b e2 = a.e;
                    e2.k0 = this.convertReferenceString(this, e2.l0);
                }
                else {
                    a.e.k0 = null;
                }
            }
        }
        if (b != null) {
            b.b();
            if (a.e.k0 != null) {
                int n = 0;
                while (true) {
                    final int[] k2 = a.e.k0;
                    if (n >= k2.length) {
                        break;
                    }
                    final ConstraintWidget constraintWidget = (ConstraintWidget)sparseArray.get(k2[n]);
                    if (constraintWidget != null) {
                        b.a(constraintWidget);
                    }
                    ++n;
                }
            }
        }
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final String mReferenceIds = this.mReferenceIds;
        if (mReferenceIds != null) {
            this.setIds(mReferenceIds);
        }
        final String mReferenceTags = this.mReferenceTags;
        if (mReferenceTags != null) {
            this.setReferenceTags(mReferenceTags);
        }
    }
    
    public void onDraw(final Canvas canvas) {
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(n, n2);
        }
        else {
            this.setMeasuredDimension(0, 0);
        }
    }
    
    public int removeView(final View view) {
        final int id = view.getId();
        final int n = -1;
        if (id == -1) {
            return -1;
        }
        this.mReferenceIds = null;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= this.mCount) {
                break;
            }
            if (this.mIds[n2] == id) {
                int n4 = n2;
                int mCount;
                while (true) {
                    mCount = this.mCount;
                    if (n4 >= mCount - 1) {
                        break;
                    }
                    final int[] mIds = this.mIds;
                    final int n5 = n4 + 1;
                    mIds[n4] = mIds[n5];
                    n4 = n5;
                }
                this.mIds[mCount - 1] = 0;
                this.mCount = mCount - 1;
                n3 = n2;
                break;
            }
            ++n2;
        }
        this.requestLayout();
        return n3;
    }
    
    public void resolveRtl(final ConstraintWidget constraintWidget, final boolean b) {
    }
    
    protected void setIds(final String mReferenceIds) {
        this.mReferenceIds = mReferenceIds;
        if (mReferenceIds == null) {
            return;
        }
        int n = 0;
        this.mCount = 0;
        while (true) {
            final int index = mReferenceIds.indexOf(44, n);
            if (index == -1) {
                break;
            }
            this.addID(mReferenceIds.substring(n, index));
            n = index + 1;
        }
        this.addID(mReferenceIds.substring(n));
    }
    
    protected void setReferenceTags(final String mReferenceTags) {
        this.mReferenceTags = mReferenceTags;
        if (mReferenceTags == null) {
            return;
        }
        int n = 0;
        this.mCount = 0;
        while (true) {
            final int index = mReferenceTags.indexOf(44, n);
            if (index == -1) {
                break;
            }
            this.addTag(mReferenceTags.substring(n, index));
            n = index + 1;
        }
        this.addTag(mReferenceTags.substring(n));
    }
    
    public void setReferencedIds(final int[] array) {
        this.mReferenceIds = null;
        int i = 0;
        this.mCount = 0;
        while (i < array.length) {
            this.addRscID(array[i]);
            ++i;
        }
    }
    
    public void setTag(final int n, final Object o) {
        super.setTag(n, o);
        if (o == null && this.mReferenceIds == null) {
            this.addRscID(n);
        }
    }
    
    public void updatePostConstraints(final ConstraintLayout constraintLayout) {
    }
    
    public void updatePostLayout(final ConstraintLayout constraintLayout) {
    }
    
    public void updatePostMeasure(final ConstraintLayout constraintLayout) {
    }
    
    public void updatePreDraw(final ConstraintLayout constraintLayout) {
    }
    
    public void updatePreLayout(final d d, final r.a a, final SparseArray<ConstraintWidget> sparseArray) {
        a.b();
        for (int i = 0; i < this.mCount; ++i) {
            a.a((ConstraintWidget)sparseArray.get(this.mIds[i]));
        }
    }
    
    public void updatePreLayout(final ConstraintLayout constraintLayout) {
        if (this.isInEditMode()) {
            this.setIds(this.mReferenceIds);
        }
        final r.a mHelperWidget = this.mHelperWidget;
        if (mHelperWidget == null) {
            return;
        }
        mHelperWidget.b();
        for (int i = 0; i < this.mCount; ++i) {
            final int n = this.mIds[i];
            final View viewById = constraintLayout.getViewById(n);
            View viewById2;
            if ((viewById2 = viewById) == null) {
                final String s = this.mMap.get(n);
                final int id = this.findId(constraintLayout, s);
                viewById2 = viewById;
                if (id != 0) {
                    this.mIds[i] = id;
                    this.mMap.put(id, s);
                    viewById2 = constraintLayout.getViewById(id);
                }
            }
            if (viewById2 != null) {
                this.mHelperWidget.a(constraintLayout.getViewWidget(viewById2));
            }
        }
        this.mHelperWidget.c(constraintLayout.mLayoutWidget);
    }
    
    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b)layoutParams).v0 = (ConstraintWidget)this.mHelperWidget;
        }
    }
}
