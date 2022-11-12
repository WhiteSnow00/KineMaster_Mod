// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;

public final class a implements Runnable
{
    public final DefaultHlsPlaylistTracker.c a;
    public final Uri b;
    
    public a(final DefaultHlsPlaylistTracker.c a, final Uri b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        DefaultHlsPlaylistTracker.c.a(this.a, this.b);
    }
}
