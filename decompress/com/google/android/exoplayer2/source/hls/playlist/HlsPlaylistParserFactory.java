// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable;

public interface HlsPlaylistParserFactory
{
    ParsingLoadable.Parser<HlsPlaylist> a();
    
    ParsingLoadable.Parser<HlsPlaylist> b(final HlsMultivariantPlaylist p0, final HlsMediaPlaylist p1);
}
