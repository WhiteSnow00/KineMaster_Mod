// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final class zze implements Callable
{
    public final boolean a;
    public final String b;
    public final h c;
    
    public zze(final boolean a, final String b, final h c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        return l.c(this.a, this.b, this.c);
    }
}
