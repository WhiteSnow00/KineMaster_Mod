// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.Map;
import com.google.common.base.Predicate;

public final class c implements Predicate
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    public final boolean apply(final Object o) {
        return DefaultHttpDataSource.b.b((Map.Entry)o);
    }
}
