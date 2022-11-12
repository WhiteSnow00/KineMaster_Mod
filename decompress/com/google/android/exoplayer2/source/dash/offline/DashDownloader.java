// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.offline;

import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import java.util.concurrent.Executor;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.dash.BaseUrlExclusionList;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader;

public final class DashDownloader extends SegmentDownloader<DashManifest>
{
    private final BaseUrlExclusionList j;
    
    public DashDownloader(final MediaItem mediaItem, final ParsingLoadable.Parser<DashManifest> parser, final CacheDataSource.Factory factory, final Executor executor) {
        super(mediaItem, parser, factory, executor);
        this.j = new BaseUrlExclusionList();
    }
    
    public DashDownloader(final MediaItem mediaItem, final CacheDataSource.Factory factory, final Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor);
    }
}
