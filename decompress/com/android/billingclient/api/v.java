// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class v implements Callable
{
    public final d a;
    public final String b;
    public final String c;
    
    public v(final d a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        return this.a.B(this.b, this.c);
    }
}
