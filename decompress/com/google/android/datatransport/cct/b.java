// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.retries.RetryStrategy;

public final class b implements RetryStrategy
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    @Override
    public final Object a(final Object o, final Object o2) {
        return c.c((c.a)o, (c.b)o2);
    }
}
