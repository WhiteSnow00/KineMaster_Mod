// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;

public final class InitializationChunk extends Chunk
{
    private final ChunkExtractor j;
    private ChunkExtractor.TrackOutputProvider k;
    private long l;
    private volatile boolean m;
    
    public InitializationChunk(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final ChunkExtractor j) {
        super(dataSource, dataSpec, 2, format, n, o, -9223372036854775807L, -9223372036854775807L);
        this.j = j;
    }
    
    @Override
    public void a() throws IOException {
        if (this.l == 0L) {
            this.j.b(this.k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            final DataSpec e = super.b.e(this.l);
            final StatsDataSource i = super.i;
            final DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(i, e.g, i.b(e));
            try {
                while (!this.m && this.j.a(defaultExtractorInput)) {}
            }
            finally {
                this.l = defaultExtractorInput.getPosition() - super.b.g;
            }
        }
        finally {
            DataSourceUtil.a(super.i);
        }
    }
    
    @Override
    public void c() {
        this.m = true;
    }
    
    public void g(final ChunkExtractor.TrackOutputProvider k) {
        this.k = k;
    }
}
