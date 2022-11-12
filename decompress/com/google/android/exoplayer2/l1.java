// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class l1 implements Creator
{
    public static final l1 a;
    
    static {
        a = new l1();
    }
    
    private l1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return new PlaybackException(bundle);
    }
}
