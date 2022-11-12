// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

public final class zzg implements Runnable
{
    public final zzi a;
    public final boolean b;
    
    public zzg(final zzi a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.b(this.b);
    }
}
