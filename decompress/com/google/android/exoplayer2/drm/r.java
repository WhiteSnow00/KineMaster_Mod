// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.UUID;

public final class r implements Provider
{
    public static final r a;
    
    static {
        a = new r();
    }
    
    private r() {
    }
    
    @Override
    public final ExoMediaDrm a(final UUID uuid) {
        return FrameworkMediaDrm.o(uuid);
    }
}
