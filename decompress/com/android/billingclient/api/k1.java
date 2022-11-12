// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class k1 implements Callable
{
    public final d a;
    public final r b;
    public final n c;
    
    public k1(final d a, final r b, final n c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        this.a.J(this.b, this.c);
        return null;
    }
}
