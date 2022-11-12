// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.util.AttributeSet;
import android.content.Context;

public class Group extends a
{
    public Group(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    @Override
    protected void applyLayoutFeaturesInConstraintSet(final ConstraintLayout constraintLayout) {
        this.applyLayoutFeatures(constraintLayout);
    }
    
    @Override
    protected void init(final AttributeSet set) {
        super.init(set);
        super.mUseViewMeasure = false;
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.applyLayoutFeatures();
    }
    
    public void setElevation(final float elevation) {
        super.setElevation(elevation);
        this.applyLayoutFeatures();
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        this.applyLayoutFeatures();
    }
    
    @Override
    public void updatePostLayout(final ConstraintLayout constraintLayout) {
        final ConstraintLayout.b b = (ConstraintLayout.b)this.getLayoutParams();
        b.v0.h1(0);
        b.v0.I0(0);
    }
}
