// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class s1 implements Creator
{
    public static final s1 a;
    
    static {
        a = new s1();
    }
    
    private s1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return StarRating.d(bundle);
    }
}
