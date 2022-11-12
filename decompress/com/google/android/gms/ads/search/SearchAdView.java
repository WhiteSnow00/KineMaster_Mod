// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.search;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcfi;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzdu;
import android.view.ViewGroup;

public final class SearchAdView extends ViewGroup
{
    private final zzdu a;
    
    public AdListener getAdListener() {
        return this.a.d();
    }
    
    public AdSize getAdSize() {
        return this.a.e();
    }
    
    public String getAdUnitId() {
        return this.a.m();
    }
    
    protected void onLayout(final boolean b, int n, int n2, final int n3, final int n4) {
        final View child = this.getChildAt(0);
        if (child != null && child.getVisibility() != 8) {
            final int measuredWidth = child.getMeasuredWidth();
            final int measuredHeight = child.getMeasuredHeight();
            n = (n3 - n - measuredWidth) / 2;
            n2 = (n4 - n2 - measuredHeight) / 2;
            child.layout(n, n2, measuredWidth + n, measuredHeight + n2);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3 = 0;
        final View child = this.getChildAt(0);
        int n4;
        if (child != null && child.getVisibility() != 8) {
            this.measureChild(child, n, n2);
            n3 = child.getMeasuredWidth();
            n4 = child.getMeasuredHeight();
        }
        else {
            AdSize adSize;
            try {
                adSize = this.getAdSize();
            }
            catch (final NullPointerException ex) {
                zzcfi.zzh("Unable to retrieve ad size.", (Throwable)ex);
                adSize = null;
            }
            if (adSize != null) {
                final Context context = this.getContext();
                n3 = adSize.d(context);
                n4 = adSize.b(context);
            }
            else {
                n4 = 0;
            }
        }
        this.setMeasuredDimension(View.resolveSize(Math.max(n3, this.getSuggestedMinimumWidth()), n), View.resolveSize(Math.max(n4, this.getSuggestedMinimumHeight()), n2));
    }
    
    public void setAdListener(final AdListener adListener) {
        this.a.t(adListener);
    }
    
    public void setAdSize(final AdSize adSize) {
        this.a.u(adSize);
    }
    
    public void setAdUnitId(final String s) {
        this.a.w(s);
    }
}
