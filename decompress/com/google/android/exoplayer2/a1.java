// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class a1 implements Creator
{
    public static final a1 a;
    
    static {
        a = new a1();
    }
    
    private a1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return MediaItem.ClippingConfiguration.a(bundle);
    }
}
