// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.retries.Function;

public final class a implements Function
{
    public final c a;
    
    public a(final c a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return c.d(this.a, (c.a)o);
    }
}
