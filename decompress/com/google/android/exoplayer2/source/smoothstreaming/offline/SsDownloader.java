// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming.offline;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.util.concurrent.Executor;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader;

public final class SsDownloader extends SegmentDownloader<SsManifest>
{
    public SsDownloader(final MediaItem mediaItem, final ParsingLoadable.Parser<SsManifest> parser, final CacheDataSource.Factory factory, final Executor executor) {
        super(mediaItem, parser, factory, executor);
    }
    
    public SsDownloader(final MediaItem mediaItem, final CacheDataSource.Factory factory, final Executor executor) {
        this(mediaItem.b().i(Util.B(Assertions.e(mediaItem.b).a)).a(), new SsManifestParser(), factory, executor);
    }
}
