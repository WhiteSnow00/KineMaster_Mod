// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class a0 implements Creator
{
    public static final a0 a;
    
    static {
        a = new a0();
    }
    
    private a0() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return TrackGroup.a(bundle);
    }
}
