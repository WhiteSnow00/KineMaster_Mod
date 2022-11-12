// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.view.View;
import androidx.annotation.Keep;

@Keep
public interface AdComponentViewParentApi extends AdComponentView
{
    void bringChildToFront(final View p0);
    
    void onAttachedToWindow();
    
    void onDetachedFromWindow();
    
    void onMeasure(final int p0, final int p1);
    
    void onVisibilityChanged(final View p0, final int p1);
    
    void setMeasuredDimension(final int p0, final int p1);
}
