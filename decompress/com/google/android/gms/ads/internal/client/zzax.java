// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.AdListener;

public class zzax extends AdListener
{
    private final Object a;
    private AdListener b;
    
    public zzax() {
        this.a = new Object();
    }
    
    public final void e(final AdListener b) {
        synchronized (this.a) {
            this.b = b;
        }
    }
    
    @Override
    public final void onAdClicked() {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdClicked();
            }
        }
    }
    
    @Override
    public final void onAdClosed() {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdClosed();
            }
        }
    }
    
    @Override
    public void onAdFailedToLoad(final LoadAdError loadAdError) {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdFailedToLoad(loadAdError);
            }
        }
    }
    
    @Override
    public final void onAdImpression() {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdImpression();
            }
        }
    }
    
    @Override
    public void onAdLoaded() {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdLoaded();
            }
        }
    }
    
    @Override
    public final void onAdOpened() {
        synchronized (this.a) {
            final AdListener b = this.b;
            if (b != null) {
                b.onAdOpened();
            }
        }
    }
}
