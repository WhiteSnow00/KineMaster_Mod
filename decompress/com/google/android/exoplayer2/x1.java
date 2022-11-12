// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class x1 implements Creator
{
    public static final x1 a;
    
    static {
        a = new x1();
    }
    
    private x1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Timeline.Window.a(bundle);
    }
}
