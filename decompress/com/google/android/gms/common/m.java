// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class m extends n
{
    private final Callable f;
    
    m(final Callable f, final zzu zzu) {
        super(false, 1, 5, null, null, null);
        this.f = f;
    }
    
    @Override
    final String a() {
        try {
            return this.f.call();
        }
        catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
