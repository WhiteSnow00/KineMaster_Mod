// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class d1 implements Creator
{
    public static final d1 a;
    
    static {
        a = new d1();
    }
    
    private d1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return MediaMetadata.a(bundle);
    }
}
