// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;

public final class h implements Runnable
{
    public final DefaultDrmSessionManager.d a;
    public final Format b;
    
    public h(final DefaultDrmSessionManager.d a, final Format b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        DefaultDrmSessionManager.d.d(this.a, this.b);
    }
}
