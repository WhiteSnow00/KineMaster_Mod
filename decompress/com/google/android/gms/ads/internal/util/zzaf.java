// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

public final class zzaf implements Runnable
{
    public final zzas a;
    
    public zzaf(final zzas a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.b();
    }
}
