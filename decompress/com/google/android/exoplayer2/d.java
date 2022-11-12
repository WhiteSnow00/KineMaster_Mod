// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class d implements Creator
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return ExoPlaybackException.d(bundle);
    }
}
