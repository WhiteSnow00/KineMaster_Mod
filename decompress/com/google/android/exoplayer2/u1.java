// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class u1 implements Creator
{
    public static final u1 a;
    
    static {
        a = new u1();
    }
    
    private u1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return ThumbRating.d(bundle);
    }
}
