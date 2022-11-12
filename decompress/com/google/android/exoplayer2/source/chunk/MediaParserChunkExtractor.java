// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.io.IOException;
import android.media.MediaParser$SeekableInputReader;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import android.media.MediaParser$SeekMap;
import android.media.MediaParser$SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import java.util.ArrayList;
import android.media.MediaParser$OutputConsumer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.List;
import x3.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import android.media.MediaParser;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;

public final class MediaParserChunkExtractor implements ChunkExtractor
{
    public static final Factory i;
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b;
    private final MediaParser c;
    private final b d;
    private final DummyTrackOutput e;
    private long f;
    private TrackOutputProvider g;
    private Format[] h;
    
    static {
        i = (Factory)x3.b.a;
    }
    
    public MediaParserChunkExtractor(int i, final Format format, final List<Format> list, final PlayerId playerId) {
        final OutputConsumerAdapterV30 a = new OutputConsumerAdapterV30(format, i, true);
        this.a = a;
        this.b = new InputReaderAdapterV30();
        String s;
        if (MimeTypes.q(Assertions.e(format.p))) {
            s = "android.media.mediaparser.MatroskaParser";
        }
        else {
            s = "android.media.mediaparser.FragmentedMp4Parser";
        }
        a.r(s);
        final MediaParser byName = MediaParser.createByName(s, (MediaParser$OutputConsumer)a);
        this.c = byName;
        final Boolean true = Boolean.TRUE;
        byName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", (Object)true);
        byName.setParameter("android.media.mediaparser.inBandCryptoInfo", (Object)true);
        byName.setParameter("android.media.mediaparser.includeSupplementalData", (Object)true);
        byName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", (Object)true);
        byName.setParameter("android.media.mediaparser.exposeDummySeekMap", (Object)true);
        byName.setParameter("android.media.mediaParser.exposeChunkIndexAsMediaFormat", (Object)true);
        byName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", (Object)true);
        final ArrayList list2 = new ArrayList();
        for (i = 0; i < list.size(); ++i) {
            list2.add(MediaParserUtil.b(list.get(i)));
        }
        this.c.setParameter("android.media.mediaParser.exposeCaptionFormats", (Object)list2);
        if (Util.a >= 31) {
            MediaParserUtil.a(this.c, playerId);
        }
        this.a.p(list);
        this.d = new b(null);
        this.e = new DummyTrackOutput();
        this.f = -9223372036854775807L;
    }
    
    public static ChunkExtractor e(final int n, final Format format, final boolean b, final List list, final TrackOutput trackOutput, final PlayerId playerId) {
        return j(n, format, b, list, trackOutput, playerId);
    }
    
    static TrackOutputProvider f(final MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.g;
    }
    
    static DummyTrackOutput g(final MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.e;
    }
    
    static Format[] h(final MediaParserChunkExtractor mediaParserChunkExtractor, final Format[] h) {
        return mediaParserChunkExtractor.h = h;
    }
    
    static OutputConsumerAdapterV30 i(final MediaParserChunkExtractor mediaParserChunkExtractor) {
        return mediaParserChunkExtractor.a;
    }
    
    private static ChunkExtractor j(final int n, final Format format, final boolean b, final List list, final TrackOutput trackOutput, final PlayerId playerId) {
        if (!MimeTypes.r(format.p)) {
            return new MediaParserChunkExtractor(n, format, list, playerId);
        }
        Log.i("MediaPrsrChunkExtractor", "Ignoring an unsupported text track.");
        return null;
    }
    
    private void k() {
        final MediaParser$SeekMap f = this.a.f();
        final long f2 = this.f;
        if (f2 != -9223372036854775807L && f != null) {
            this.c.seek((MediaParser$SeekPoint)f.getSeekPoints(f2).first);
            this.f = -9223372036854775807L;
        }
    }
    
    @Override
    public boolean a(final ExtractorInput extractorInput) throws IOException {
        this.k();
        this.b.c(extractorInput, extractorInput.getLength());
        return this.c.advance((MediaParser$SeekableInputReader)this.b);
    }
    
    @Override
    public void b(final TrackOutputProvider g, final long f, final long n) {
        this.g = g;
        this.a.q(n);
        this.a.o(this.d);
        this.f = f;
    }
    
    @Override
    public ChunkIndex c() {
        return this.a.d();
    }
    
    @Override
    public Format[] d() {
        return this.h;
    }
    
    @Override
    public void release() {
        this.c.release();
    }
    
    private class b implements ExtractorOutput
    {
        final MediaParserChunkExtractor a;
        
        private b(final MediaParserChunkExtractor a) {
            this.a = a;
        }
        
        b(final MediaParserChunkExtractor mediaParserChunkExtractor, final MediaParserChunkExtractor$a object) {
            this(mediaParserChunkExtractor);
        }
        
        @Override
        public TrackOutput e(final int n, final int n2) {
            TrackOutput trackOutput;
            if (MediaParserChunkExtractor.f(this.a) != null) {
                trackOutput = MediaParserChunkExtractor.f(this.a).e(n, n2);
            }
            else {
                trackOutput = MediaParserChunkExtractor.g(this.a);
            }
            return trackOutput;
        }
        
        @Override
        public void l(final SeekMap seekMap) {
        }
        
        @Override
        public void o() {
            final MediaParserChunkExtractor a = this.a;
            MediaParserChunkExtractor.h(a, MediaParserChunkExtractor.i(a).j());
        }
    }
}
