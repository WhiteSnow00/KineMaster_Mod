// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;

public final class HlsManifest
{
    @Deprecated
    public final HlsMasterPlaylist a;
    public final HlsMultivariantPlaylist b;
    public final HlsMediaPlaylist c;
    
    HlsManifest(final HlsMultivariantPlaylist b, final HlsMediaPlaylist c) {
        this.b = b;
        this.c = c;
        this.a = new HlsMasterPlaylist(b.a, b.b, b.e, b.f, b.g, b.h, b.i, b.j, b.k, b.c, b.l, b.m);
    }
}
