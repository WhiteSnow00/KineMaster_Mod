// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;

public final class d implements SurfaceTexture$OnFrameAvailableListener
{
    public final e a;
    
    public d(final e a) {
        this.a = a;
    }
    
    public final void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        e.c(this.a, surfaceTexture);
    }
}
