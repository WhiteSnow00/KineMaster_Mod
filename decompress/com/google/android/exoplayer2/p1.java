// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class p1 implements Creator
{
    public static final p1 a;
    
    static {
        a = new p1();
    }
    
    private p1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Player.PositionInfo.a(bundle);
    }
}
