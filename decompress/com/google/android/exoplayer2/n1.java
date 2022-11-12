// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class n1 implements Creator
{
    public static final n1 a;
    
    static {
        a = new n1();
    }
    
    private n1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return PlaybackParameters.a(bundle);
    }
}
