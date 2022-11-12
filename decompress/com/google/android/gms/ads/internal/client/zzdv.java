// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public final class zzdv implements Runnable
{
    public final zzee a;
    public final OnInitializationCompleteListener b;
    
    public zzdv(final zzee a, final OnInitializationCompleteListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.l(this.b);
    }
}
