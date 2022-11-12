// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class b implements CustomEventInterstitialListener
{
    private final CustomEventAdapter a;
    private final MediationInterstitialListener b;
    final CustomEventAdapter c;
    
    public b(final CustomEventAdapter c, final CustomEventAdapter a, final MediationInterstitialListener b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
}
