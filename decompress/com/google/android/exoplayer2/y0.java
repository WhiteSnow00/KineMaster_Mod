// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class y0 implements Creator
{
    public static final y0 a;
    
    static {
        a = new y0();
    }
    
    private y0() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return HeartRating.d(bundle);
    }
}
