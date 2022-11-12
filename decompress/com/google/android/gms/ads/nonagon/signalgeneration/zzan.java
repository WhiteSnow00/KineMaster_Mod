// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

public final class zzan implements Callable
{
    public final a a;
    public final String b;
    
    public zzan(final a a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        return this.a.getClickSignals(this.b);
    }
}
