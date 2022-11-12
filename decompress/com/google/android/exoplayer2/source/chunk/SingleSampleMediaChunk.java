// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.Format;

public final class SingleSampleMediaChunk extends BaseMediaChunk
{
    private final int o;
    private final Format p;
    private long q;
    private boolean r;
    
    public SingleSampleMediaChunk(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final long n2, final long n3, final long n4, final int o2, final Format p10) {
        super(dataSource, dataSpec, format, n, o, n2, n3, -9223372036854775807L, -9223372036854775807L, n4);
        this.o = o2;
        this.p = p10;
    }
    
    @Override
    public void a() throws IOException {
        final BaseMediaChunkOutput j = this.j();
        j.b(0L);
        final int o = this.o;
        int i = 0;
        final TrackOutput e = j.e(0, o);
        e.d(this.p);
        try {
            long b;
            final long n = b = super.i.b(super.b.e(this.q));
            if (n != -1L) {
                b = n + this.q;
            }
            for (DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(super.i, this.q, b); i != -1; i = e.b(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.q += i;
            }
            e.e(super.g, 1, (int)this.q, 0, null);
            DataSourceUtil.a(super.i);
            this.r = true;
        }
        finally {
            DataSourceUtil.a(super.i);
        }
    }
    
    @Override
    public void c() {
    }
    
    @Override
    public boolean h() {
        return this.r;
    }
}
