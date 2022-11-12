// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbpn;

public final class H5AdsRequestHandler
{
    private final zzbpn a;
    
    public H5AdsRequestHandler(final Context context, final OnH5AdsEventListener onH5AdsEventListener) {
        this.a = new zzbpn(context, onH5AdsEventListener);
    }
    
    public void a() {
        this.a.zza();
    }
    
    public boolean b(final String s) {
        return this.a.zzb(s);
    }
}
