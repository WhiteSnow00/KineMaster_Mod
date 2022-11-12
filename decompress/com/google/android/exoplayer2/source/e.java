// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.common.base.Supplier;

public final class e implements Supplier
{
    public final Class a;
    
    public e(final Class a) {
        this.a = a;
    }
    
    public final Object get() {
        return DefaultMediaSourceFactory.a.a(this.a);
    }
}
