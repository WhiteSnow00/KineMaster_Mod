// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

public final class zzk implements Runnable
{
    public final c a;
    public final f b;
    
    public zzk(final c a, final f b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.e(this.b.a);
    }
}
