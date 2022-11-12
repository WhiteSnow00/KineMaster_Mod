// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

public final class zzg implements Runnable
{
    public final c a;
    
    public zzg(final c a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.a(2, "Service disconnected");
    }
}
