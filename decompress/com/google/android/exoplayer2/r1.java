// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class r1 implements Creator
{
    public static final r1 a;
    
    static {
        a = new r1();
    }
    
    private r1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Rating.a(bundle);
    }
}
