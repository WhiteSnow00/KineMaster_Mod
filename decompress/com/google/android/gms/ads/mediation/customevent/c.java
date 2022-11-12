// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class c implements CustomEventNativeListener
{
    private final CustomEventAdapter a;
    private final MediationNativeListener b;
    
    public c(final CustomEventAdapter a, final MediationNativeListener b) {
        this.a = a;
        this.b = b;
    }
}
