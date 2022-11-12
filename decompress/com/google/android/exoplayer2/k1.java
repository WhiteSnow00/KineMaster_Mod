// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class k1 implements Creator
{
    public static final k1 a;
    
    static {
        a = new k1();
    }
    
    private k1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return PercentageRating.d(bundle);
    }
}
