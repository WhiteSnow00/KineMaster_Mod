// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class p1 implements Callable
{
    public final d a;
    public final a b;
    public final b c;
    
    public p1(final d a, final a b, final b c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        this.a.H(this.b, this.c);
        return null;
    }
}
