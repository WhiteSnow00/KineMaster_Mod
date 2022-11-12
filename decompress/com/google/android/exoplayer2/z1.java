// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class z1 implements Creator
{
    public static final z1 a;
    
    static {
        a = new z1();
    }
    
    private z1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Tracks.Group.a(bundle);
    }
}
