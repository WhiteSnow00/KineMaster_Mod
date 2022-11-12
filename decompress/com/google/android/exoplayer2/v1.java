// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class v1 implements Creator
{
    public static final v1 a;
    
    static {
        a = new v1();
    }
    
    private v1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Timeline.a(bundle);
    }
}
