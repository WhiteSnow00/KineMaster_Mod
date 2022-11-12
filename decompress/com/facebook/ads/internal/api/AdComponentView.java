// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import androidx.annotation.Keep;

@Keep
public interface AdComponentView
{
    void addView(final View p0);
    
    void addView(final View p0, final int p1);
    
    void addView(final View p0, final int p1, final int p2);
    
    void addView(final View p0, final int p1, final ViewGroup$LayoutParams p2);
    
    void addView(final View p0, final ViewGroup$LayoutParams p1);
    
    void onWindowFocusChanged(final boolean p0);
    
    void setLayoutParams(final ViewGroup$LayoutParams p0);
}
