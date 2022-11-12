// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzq implements Callable
{
    public final zzz a;
    public final List b;
    public final IObjectWrapper c;
    
    public zzq(final zzz a, final List b, final IObjectWrapper c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        return this.a.p1(this.b, this.c);
    }
}
