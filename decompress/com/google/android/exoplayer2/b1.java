// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class b1 implements Creator
{
    public static final b1 a;
    
    static {
        a = new b1();
    }
    
    private b1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return MediaItem.LiveConfiguration.a(bundle);
    }
}
