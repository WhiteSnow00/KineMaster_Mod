// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewParent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.g;

public abstract class k extends a
{
    private boolean a;
    private boolean b;
    
    @Override
    protected void applyLayoutFeaturesInConstraintSet(final ConstraintLayout constraintLayout) {
        this.applyLayoutFeatures(constraintLayout);
    }
    
    public void e(final g g, final int n, final int n2) {
    }
    
    @Override
    protected void init(final AttributeSet set) {
        super.init(set);
        if (set != null) {
            final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, h.n1);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.p1) {
                    this.a = true;
                }
                else if (index == h.u1) {
                    this.b = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a || this.b) {
            final ViewParent parent = this.getParent();
            if (parent instanceof ConstraintLayout) {
                final ConstraintLayout constraintLayout = (ConstraintLayout)parent;
                final int visibility = this.getVisibility();
                final float elevation = this.getElevation();
                for (int i = 0; i < super.mCount; ++i) {
                    final View viewById = constraintLayout.getViewById(super.mIds[i]);
                    if (viewById != null) {
                        if (this.a) {
                            viewById.setVisibility(visibility);
                        }
                        if (this.b && elevation > 0.0f) {
                            viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }
    
    public void setElevation(final float elevation) {
        super.setElevation(elevation);
        this.applyLayoutFeatures();
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        this.applyLayoutFeatures();
    }
}
