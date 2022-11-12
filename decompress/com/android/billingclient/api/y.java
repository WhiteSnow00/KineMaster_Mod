// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

public final class y implements Runnable
{
    public final d a;
    public final g b;
    
    public y(final d a, final g b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.q(this.b);
    }
}
