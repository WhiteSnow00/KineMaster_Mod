// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

public final class zzam implements Callable
{
    public final a a;
    
    public zzam(final a a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        return this.a.getViewSignals();
    }
}
