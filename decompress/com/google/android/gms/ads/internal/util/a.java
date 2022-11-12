// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

final class a implements Runnable
{
    final zzb a;
    
    a(final zzb a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        zzb.zzc(this.a, Thread.currentThread());
        this.a.zza();
    }
}
