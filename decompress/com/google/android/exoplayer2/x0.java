// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class x0 implements Creator
{
    public static final x0 a;
    
    static {
        a = new x0();
    }
    
    private x0() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Format.a(bundle);
    }
}
