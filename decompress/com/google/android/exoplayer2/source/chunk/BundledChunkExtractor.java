// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.util.List;
import x3.a;
import com.google.android.exoplayer2.extractor.SeekMap;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor
{
    public static final Factory j;
    private static final PositionHolder p;
    private final Extractor a;
    private final int b;
    private final Format c;
    private final SparseArray<a> d;
    private boolean e;
    private TrackOutputProvider f;
    private long g;
    private SeekMap h;
    private Format[] i;
    
    static {
        j = (Factory)x3.a.a;
        p = new PositionHolder();
    }
    
    public BundledChunkExtractor(final Extractor a, final int b, final Format c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = (SparseArray<a>)new SparseArray();
    }
    
    public static ChunkExtractor f(final int n, final Format format, final boolean b, final List list, final TrackOutput trackOutput, final PlayerId playerId) {
        return g(n, format, b, list, trackOutput, playerId);
    }
    
    private static ChunkExtractor g(final int n, final Format format, final boolean b, final List list, final TrackOutput trackOutput, final PlayerId playerId) {
        final String p6 = format.p;
        if (MimeTypes.r(p6)) {
            return null;
        }
        Extractor extractor;
        if (MimeTypes.q(p6)) {
            extractor = new MatroskaExtractor(1);
        }
        else {
            int n2 = 0;
            if (b) {
                n2 = 4;
            }
            extractor = new FragmentedMp4Extractor(n2, null, null, list, trackOutput);
        }
        return new BundledChunkExtractor(extractor, n, format);
    }
    
    @Override
    public boolean a(final ExtractorInput extractorInput) throws IOException {
        final int e = this.a.e(extractorInput, BundledChunkExtractor.p);
        final boolean b = false;
        Assertions.g(e != 1);
        boolean b2 = b;
        if (e == 0) {
            b2 = true;
        }
        return b2;
    }
    
    @Override
    public void b(final TrackOutputProvider f, final long n, final long g) {
        this.f = f;
        this.g = g;
        if (!this.e) {
            this.a.b(this);
            if (n != -9223372036854775807L) {
                this.a.a(0L, n);
            }
            this.e = true;
        }
        else {
            final Extractor a = this.a;
            long n2 = n;
            if (n == -9223372036854775807L) {
                n2 = 0L;
            }
            a.a(0L, n2);
            for (int i = 0; i < this.d.size(); ++i) {
                ((a)this.d.valueAt(i)).g(f, g);
            }
        }
    }
    
    @Override
    public ChunkIndex c() {
        final SeekMap h = this.h;
        ChunkIndex chunkIndex;
        if (h instanceof ChunkIndex) {
            chunkIndex = (ChunkIndex)h;
        }
        else {
            chunkIndex = null;
        }
        return chunkIndex;
    }
    
    @Override
    public Format[] d() {
        return this.i;
    }
    
    @Override
    public TrackOutput e(final int n, final int n2) {
        a a;
        if ((a = (a)this.d.get(n)) == null) {
            Assertions.g(this.i == null);
            Format c;
            if (n2 == this.b) {
                c = this.c;
            }
            else {
                c = null;
            }
            a = new a(n, n2, c);
            a.g(this.f, this.g);
            this.d.put(n, (Object)a);
        }
        return a;
    }
    
    @Override
    public void l(final SeekMap h) {
        this.h = h;
    }
    
    @Override
    public void o() {
        final Format[] i = new Format[this.d.size()];
        for (int j = 0; j < this.d.size(); ++j) {
            i[j] = Assertions.i(((a)this.d.valueAt(j)).e);
        }
        this.i = i;
    }
    
    @Override
    public void release() {
        this.a.release();
    }
    
    private static final class a implements TrackOutput
    {
        private final int a;
        private final int b;
        private final Format c;
        private final DummyTrackOutput d;
        public Format e;
        private TrackOutput f;
        private long g;
        
        public a(final int a, final int b, final Format c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = new DummyTrackOutput();
        }
        
        @Override
        public int a(final DataReader dataReader, final int n, final boolean b, final int n2) throws IOException {
            return Util.j(this.f).b(dataReader, n, b);
        }
        
        @Override
        public void d(final Format format) {
            final Format c = this.c;
            Format k = format;
            if (c != null) {
                k = format.k(c);
            }
            this.e = k;
            Util.j(this.f).d(this.e);
        }
        
        @Override
        public void e(final long n, final int n2, final int n3, final int n4, final CryptoData cryptoData) {
            final long g = this.g;
            if (g != -9223372036854775807L && n >= g) {
                this.f = this.d;
            }
            Util.j(this.f).e(n, n2, n3, n4, cryptoData);
        }
        
        @Override
        public void f(final ParsableByteArray parsableByteArray, final int n, final int n2) {
            Util.j(this.f).c(parsableByteArray, n);
        }
        
        public void g(final TrackOutputProvider trackOutputProvider, final long g) {
            if (trackOutputProvider == null) {
                this.f = this.d;
                return;
            }
            this.g = g;
            final TrackOutput e = trackOutputProvider.e(this.a, this.b);
            this.f = e;
            final Format e2 = this.e;
            if (e2 != null) {
                e.d(e2);
            }
        }
    }
}
