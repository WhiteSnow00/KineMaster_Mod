// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class a implements CustomEventBannerListener
{
    private final CustomEventAdapter a;
    private final MediationBannerListener b;
    
    public a(final CustomEventAdapter a, final MediationBannerListener b) {
        this.a = a;
        this.b = b;
    }
}
