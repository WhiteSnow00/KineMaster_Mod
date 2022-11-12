// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.internal.ads.zzcfi;
import android.view.View;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzdu;
import android.view.ViewGroup;

public abstract class BaseAdView extends ViewGroup
{
    protected final zzdu a;
    
    protected BaseAdView(final Context context, final int n) {
        super(context);
        this.a = new zzdu(this, n);
    }
    
    public void a() {
        this.a.n();
    }
    
    public void b(final AdRequest adRequest) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(this.getContext());
        if ((boolean)zzbjm.zze.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zzc(this, adRequest));
            return;
        }
        this.a.p(adRequest.a());
    }
    
    public void c() {
        this.a.q();
    }
    
    public void d() {
        this.a.r();
    }
    
    public AdListener getAdListener() {
        return this.a.d();
    }
    
    public AdSize getAdSize() {
        return this.a.e();
    }
    
    public String getAdUnitId() {
        return this.a.m();
    }
    
    public OnPaidEventListener getOnPaidEventListener() {
        return this.a.f();
    }
    
    public ResponseInfo getResponseInfo() {
        return this.a.g();
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
        if (adListener == null) {
            this.a.s(null);
            return;
        }
        if (adListener instanceof zza) {
            this.a.s((zza)adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.a.x((AppEventListener)adListener);
        }
    }
    
    public void setAdSize(final AdSize adSize) {
        this.a.u(adSize);
    }
    
    public void setAdUnitId(final String s) {
        this.a.w(s);
    }
    
    public void setOnPaidEventListener(final OnPaidEventListener onPaidEventListener) {
        this.a.z(onPaidEventListener);
    }
}
