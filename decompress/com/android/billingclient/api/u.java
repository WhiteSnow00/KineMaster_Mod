// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final class u implements Callable
{
    public final d a;
    public final int b;
    public final String c;
    public final String d;
    public final f e;
    public final Bundle f;
    
    public u(final d a, final int b, final String c, final String d, final f e, final Bundle f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public final Object call() {
        return this.a.A(this.b, this.c, this.d, this.e, this.f);
    }
}
