// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class b implements Creator
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return DeviceInfo.a(bundle);
    }
}
