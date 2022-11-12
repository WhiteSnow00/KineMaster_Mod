// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

final class n extends zzax
{
    final zzdu c;
    
    n(final zzdu c) {
        this.c = c;
    }
    
    @Override
    public final void onAdFailedToLoad(final LoadAdError loadAdError) {
        final zzdu c = this.c;
        zzdu.h(c).e(c.l());
        super.onAdFailedToLoad(loadAdError);
    }
    
    @Override
    public final void onAdLoaded() {
        final zzdu c = this.c;
        zzdu.h(c).e(c.l());
        super.onAdLoaded();
    }
}
