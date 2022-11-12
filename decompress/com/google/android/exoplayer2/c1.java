// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class c1 implements Creator
{
    public static final c1 a;
    
    static {
        a = new c1();
    }
    
    private c1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return MediaItem.RequestMetadata.a(bundle);
    }
}
