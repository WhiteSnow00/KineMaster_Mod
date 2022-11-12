// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class a implements Creator
{
    public static final a a;
    
    static {
        a = new a();
    }
    
    private a() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return AudioAttributes.a(bundle);
    }
}
