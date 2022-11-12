// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.AdapterStatus;

final class o implements AdapterStatus
{
    o(final zzee zzee) {
    }
    
    @Override
    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }
    
    @Override
    public final int getLatency() {
        return 0;
    }
}
