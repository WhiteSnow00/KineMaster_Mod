// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.ads.initialization.InitializationStatus;

public final class zzdw implements InitializationStatus
{
    public final zzee a;
    
    public zzdw(final zzee a) {
        this.a = a;
    }
    
    @Override
    public final Map getAdapterStatusMap() {
        final zzee a = this.a;
        final HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new o(a));
        return hashMap;
    }
}
