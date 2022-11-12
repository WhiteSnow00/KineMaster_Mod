// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.Arrays;

final class i extends h
{
    private final byte[] b;
    
    i(final byte[] b) {
        super(Arrays.copyOfRange(b, 0, 25));
        this.b = b;
    }
    
    @Override
    final byte[] q1() {
        return this.b;
    }
}
