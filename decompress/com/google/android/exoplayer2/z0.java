// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class z0 implements Creator
{
    public static final z0 a;
    
    static {
        a = new z0();
    }
    
    private z0() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return MediaItem.a(bundle);
    }
}
