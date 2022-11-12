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

public class ContainerMediaChunk extends BaseMediaChunk
{
    private final int o;
    private final long p;
    private final ChunkExtractor q;
    private long r;
    private volatile boolean s;
    private boolean t;
    
    public ContainerMediaChunk(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final long n2, final long n3, final long n4, final long n5, final long n6, final int o2, final long p13, final ChunkExtractor q) {
        super(dataSource, dataSpec, format, n, o, n2, n3, n4, n5, n6);
        this.o = o2;
        this.p = p13;
        this.q = q;
    }
    
    @Override
    public final void a() throws IOException {
        if (this.r == 0L) {
            final BaseMediaChunkOutput j = this.j();
            j.b(this.p);
            final ChunkExtractor q = this.q;
            final ChunkExtractor.TrackOutputProvider l = this.l(j);
            final long k = super.k;
            long n;
            if (k == -9223372036854775807L) {
                n = -9223372036854775807L;
            }
            else {
                n = k - this.p;
            }
            final long i = super.l;
            long n2;
            if (i == -9223372036854775807L) {
                n2 = -9223372036854775807L;
            }
            else {
                n2 = i - this.p;
            }
            q.b(l, n, n2);
        }
        try {
            final DataSpec e = super.b.e(this.r);
            final StatsDataSource m = super.i;
            final DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(m, e.g, m.b(e));
            try {
                while (!this.s && this.q.a(defaultExtractorInput)) {}
                this.r = defaultExtractorInput.getPosition() - super.b.g;
                DataSourceUtil.a(super.i);
                this.t = (this.s ^ true);
            }
            finally {
                this.r = defaultExtractorInput.getPosition() - super.b.g;
            }
        }
        finally {
            DataSourceUtil.a(super.i);
        }
    }
    
    @Override
    public final void c() {
        this.s = true;
    }
    
    @Override
    public long g() {
        return super.j + this.o;
    }
    
    @Override
    public boolean h() {
        return this.t;
    }
    
    protected ChunkExtractor.TrackOutputProvider l(final BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
