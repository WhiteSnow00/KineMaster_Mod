// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.common.base.Predicate;

public final class b implements Predicate
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    public final boolean apply(final Object o) {
        return DefaultHttpDataSource.b.e((String)o);
    }
}
