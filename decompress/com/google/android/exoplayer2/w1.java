// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class w1 implements Creator
{
    public static final w1 a;
    
    static {
        a = new w1();
    }
    
    private w1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Timeline.Period.a(bundle);
    }
}
