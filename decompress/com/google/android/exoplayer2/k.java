// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Supplier;

public final class k implements Supplier
{
    public static final k a;
    
    static {
        a = new k();
    }
    
    private k() {
    }
    
    public final Object get() {
        return new DefaultLoadControl();
    }
}
