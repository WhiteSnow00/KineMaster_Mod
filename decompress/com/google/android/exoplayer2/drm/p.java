// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class p implements DrmSessionReference
{
    public static final p b;
    
    static {
        b = new p();
    }
    
    private p() {
    }
    
    @Override
    public final void release() {
        DrmSessionReference.b();
    }
}
