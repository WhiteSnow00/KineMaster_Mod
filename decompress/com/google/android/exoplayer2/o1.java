// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public final class o1 implements Creator
{
    public static final o1 a;
    
    static {
        a = new o1();
    }
    
    private o1() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return Player.Commands.a(bundle);
    }
}
