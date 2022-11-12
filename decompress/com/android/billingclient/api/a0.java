// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

final class a0 implements Callable
{
    final String a;
    final o b;
    final d c;
    
    a0(final d c, final String a, final o b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final /* bridge */ Object call() throws Exception {
        final g0 d = com.android.billingclient.api.d.D(this.c, this.a);
        this.b.a(d.a(), d.b());
        return null;
    }
}
