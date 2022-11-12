// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class y1 implements Creator
{
    public static final y1 a;
    
    static {
        a = new y1();
    }
    
    private y1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Tracks.a(bundle);
    }
}
