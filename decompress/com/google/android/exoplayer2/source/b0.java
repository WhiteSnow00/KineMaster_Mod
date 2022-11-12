// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class b0 implements Creator
{
    public static final b0 a;
    
    static {
        a = new b0();
    }
    
    private b0() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return TrackGroupArray.a(bundle);
    }
}
