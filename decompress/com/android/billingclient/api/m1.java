// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class m1 implements Callable
{
    public final d a;
    public final h b;
    public final i c;
    
    public m1(final d a, final h b, final i c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        this.a.I(this.b, this.c);
        return null;
    }
}
