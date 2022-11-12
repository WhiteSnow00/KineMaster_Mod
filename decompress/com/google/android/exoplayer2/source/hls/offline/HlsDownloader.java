// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.offline;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.concurrent.Executor;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.offline.SegmentDownloader;

public final class HlsDownloader extends SegmentDownloader<HlsPlaylist>
{
    public HlsDownloader(final MediaItem mediaItem, final ParsingLoadable.Parser<HlsPlaylist> parser, final CacheDataSource.Factory factory, final Executor executor) {
        super(mediaItem, parser, factory, executor);
    }
    
    public HlsDownloader(final MediaItem mediaItem, final CacheDataSource.Factory factory, final Executor executor) {
        this(mediaItem, new HlsPlaylistParser(), factory, executor);
    }
}
