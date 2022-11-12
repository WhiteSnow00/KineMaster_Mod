// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.List;
import java.util.Map;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;
import android.media.MediaParser$SeekableInputReader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import android.util.Pair;
import android.media.MediaParser$SeekPoint;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.util.Util;
import android.media.MediaParser$OutputConsumer;
import com.google.android.exoplayer2.analytics.PlayerId;
import android.media.MediaParser;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;

public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor
{
    public static final Factory e;
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b;
    private final MediaParser c;
    private String d;
    
    static {
        e = i.a;
    }
    
    public MediaParserExtractorAdapter(final PlayerId playerId) {
        final OutputConsumerAdapterV30 a = new OutputConsumerAdapterV30();
        this.a = a;
        this.b = new InputReaderAdapterV30();
        final MediaParser create = MediaParser.create((MediaParser$OutputConsumer)a, new String[0]);
        this.c = create;
        final Boolean true = Boolean.TRUE;
        create.setParameter("android.media.mediaparser.eagerlyExposeTrackType", (Object)true);
        create.setParameter("android.media.mediaparser.inBandCryptoInfo", (Object)true);
        create.setParameter("android.media.mediaparser.includeSupplementalData", (Object)true);
        this.d = "android.media.mediaparser.UNKNOWN";
        if (Util.a >= 31) {
            MediaParserUtil.a(create, playerId);
        }
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.b.b(n);
        final Pair<MediaParser$SeekPoint, MediaParser$SeekPoint> k = this.a.k(n2);
        final MediaParser c = this.c;
        final Object second = k.second;
        MediaParser$SeekPoint mediaParser$SeekPoint;
        if (((MediaParser$SeekPoint)second).position == n) {
            mediaParser$SeekPoint = (MediaParser$SeekPoint)second;
        }
        else {
            mediaParser$SeekPoint = (MediaParser$SeekPoint)k.first;
        }
        c.seek(mediaParser$SeekPoint);
    }
    
    @Override
    public int b(final PositionHolder positionHolder) throws IOException {
        final boolean advance = this.c.advance((MediaParser$SeekableInputReader)this.b);
        final long a = this.b.a();
        positionHolder.a = a;
        int n;
        if (!advance) {
            n = -1;
        }
        else if (a != -1L) {
            n = 1;
        }
        else {
            n = 0;
        }
        return n;
    }
    
    @Override
    public void c() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.d)) {
            this.a.a();
        }
    }
    
    @Override
    public void d(final DataReader dataReader, final Uri uri, final Map<String, List<String>> map, final long n, final long n2, final ExtractorOutput extractorOutput) throws IOException {
        this.a.o(extractorOutput);
        this.b.c(dataReader, n2);
        this.b.b(n);
        final String parserName = this.c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.c.advance((MediaParser$SeekableInputReader)this.b);
            final String parserName2 = this.c.getParserName();
            this.d = parserName2;
            this.a.r(parserName2);
        }
        else if (!parserName.equals(this.d)) {
            final String parserName3 = this.c.getParserName();
            this.d = parserName3;
            this.a.r(parserName3);
        }
    }
    
    @Override
    public long e() {
        return this.b.getPosition();
    }
    
    @Override
    public void release() {
        this.c.release();
    }
}
