// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory
{
    private final HlsPlaylistParserFactory a;
    private final List<StreamKey> b;
    
    public FilteringHlsPlaylistParserFactory(final HlsPlaylistParserFactory a, final List<StreamKey> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new FilteringManifestParser<HlsPlaylist>(this.a.a(), this.b);
    }
    
    @Override
    public ParsingLoadable.Parser<HlsPlaylist> b(final HlsMultivariantPlaylist hlsMultivariantPlaylist, final HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser<HlsPlaylist>(this.a.b(hlsMultivariantPlaylist, hlsMediaPlaylist), this.b);
    }
}
