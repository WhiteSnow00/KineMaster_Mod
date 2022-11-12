// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory
{
    @Override
    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new HlsPlaylistParser();
    }
    
    @Override
    public ParsingLoadable.Parser<HlsPlaylist> b(final HlsMultivariantPlaylist hlsMultivariantPlaylist, final HlsMediaPlaylist hlsMediaPlaylist) {
        return new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist);
    }
}
