// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

public final class n1 implements Runnable
{
    public final i a;
    public final h b;
    
    public n1(final i a, final h b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.a(p0.n, this.b.a());
    }
}
