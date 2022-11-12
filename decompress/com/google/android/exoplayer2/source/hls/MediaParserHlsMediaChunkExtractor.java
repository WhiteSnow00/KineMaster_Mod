// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.util.Assertions;
import android.media.MediaParser$SeekPoint;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;
import com.google.common.collect.ImmutableList$Builder;
import android.media.MediaParser$SeekableInputReader;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.MimeTypes;
import android.text.TextUtils;
import android.media.MediaParser$OutputConsumer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.Map;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import android.net.Uri;
import com.google.android.exoplayer2.analytics.PlayerId;
import android.media.MediaFormat;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Format;
import android.media.MediaParser;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;

public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor
{
    public static final HlsExtractorFactory i;
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b;
    private final MediaParser c;
    private final Format d;
    private final boolean e;
    private final ImmutableList<MediaFormat> f;
    private final PlayerId g;
    private int h;
    
    static {
        i = g.b;
    }
    
    public MediaParserHlsMediaChunkExtractor(final MediaParser c, final OutputConsumerAdapterV30 a, final Format d, final boolean e, final ImmutableList<MediaFormat> f, final int h, final PlayerId g) {
        this.c = c;
        this.a = a;
        this.e = e;
        this.f = f;
        this.d = d;
        this.g = g;
        this.h = h;
        this.b = new InputReaderAdapterV30();
    }
    
    public static HlsMediaChunkExtractor g(final Uri uri, final Format format, final List list, final TimestampAdjuster timestampAdjuster, final Map map, final ExtractorInput extractorInput, final PlayerId playerId) {
        return i(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }
    
    private static MediaParser h(final MediaParser$OutputConsumer mediaParser$OutputConsumer, final Format format, final boolean b, final ImmutableList<MediaFormat> list, final PlayerId playerId, final String... array) {
        MediaParser mediaParser;
        if (array.length == 1) {
            mediaParser = MediaParser.createByName(array[0], mediaParser$OutputConsumer);
        }
        else {
            mediaParser = MediaParser.create(mediaParser$OutputConsumer, array);
        }
        mediaParser.setParameter("android.media.mediaParser.exposeCaptionFormats", (Object)list);
        mediaParser.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", (Object)b);
        final Boolean true = Boolean.TRUE;
        mediaParser.setParameter("android.media.mediaparser.inBandCryptoInfo", (Object)true);
        mediaParser.setParameter("android.media.mediaparser.eagerlyExposeTrackType", (Object)true);
        mediaParser.setParameter("android.media.mediaparser.ignoreTimestampOffset", (Object)true);
        mediaParser.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", (Object)true);
        mediaParser.setParameter("android.media.mediaparser.ts.mode", (Object)"hls");
        final String i = format.i;
        if (!TextUtils.isEmpty((CharSequence)i)) {
            if (!"audio/mp4a-latm".equals(MimeTypes.c(i))) {
                mediaParser.setParameter("android.media.mediaparser.ts.ignoreAacStream", (Object)true);
            }
            if (!"video/avc".equals(MimeTypes.n(i))) {
                mediaParser.setParameter("android.media.mediaparser.ts.ignoreAvcStream", (Object)true);
            }
        }
        if (Util.a >= 31) {
            MediaParserUtil.a(mediaParser, playerId);
        }
        return mediaParser;
    }
    
    private static HlsMediaChunkExtractor i(final Uri uri, final Format format, List of, final TimestampAdjuster timestampAdjuster, final Map map, final ExtractorInput extractorInput, final PlayerId playerId) throws IOException {
        if (FileTypes.a(format.w) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(format.c, timestampAdjuster), format, timestampAdjuster);
        }
        int i = 0;
        boolean b;
        if (of != null) {
            b = true;
        }
        else {
            b = false;
        }
        final ImmutableList$Builder builder = ImmutableList.builder();
        if (of != null) {
            while (i < ((List)of).size()) {
                builder.i((Object)MediaParserUtil.b(((List<Format>)of).get(i)));
                ++i;
            }
        }
        else {
            builder.i((Object)MediaParserUtil.b(new Format.Builder().e0("application/cea-608").E()));
        }
        final ImmutableList l = builder.l();
        final OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (of == null) {
            of = ImmutableList.of();
        }
        outputConsumerAdapterV30.p((List<Format>)of);
        outputConsumerAdapterV30.s(timestampAdjuster);
        final MediaParser h = h((MediaParser$OutputConsumer)outputConsumerAdapterV30, format, b, (ImmutableList<MediaFormat>)l, playerId, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        final b b2 = new b(extractorInput, null);
        h.advance((MediaParser$SeekableInputReader)b2);
        outputConsumerAdapterV30.r(h.getParserName());
        return new MediaParserHlsMediaChunkExtractor(h, outputConsumerAdapterV30, format, b, (ImmutableList<MediaFormat>)l, MediaParserHlsMediaChunkExtractor.b.a(b2), playerId);
    }
    
    @Override
    public boolean a(final ExtractorInput extractorInput) throws IOException {
        extractorInput.o(this.h);
        this.h = 0;
        this.b.c(extractorInput, extractorInput.getLength());
        return this.c.advance((MediaParser$SeekableInputReader)this.b);
    }
    
    @Override
    public void b(final ExtractorOutput extractorOutput) {
        this.a.o(extractorOutput);
    }
    
    @Override
    public void c() {
        this.c.seek(MediaParser$SeekPoint.START);
    }
    
    @Override
    public boolean d() {
        final String parserName = this.c.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }
    
    @Override
    public boolean e() {
        final String parserName = this.c.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }
    
    @Override
    public HlsMediaChunkExtractor f() {
        Assertions.g(this.d() ^ true);
        return new MediaParserHlsMediaChunkExtractor(h((MediaParser$OutputConsumer)this.a, this.d, this.e, this.f, this.g, this.c.getParserName()), this.a, this.d, this.e, this.f, 0, this.g);
    }
    
    private static final class b implements MediaParser$SeekableInputReader
    {
        private final ExtractorInput a;
        private int b;
        
        private b(final ExtractorInput a) {
            this.a = a;
        }
        
        b(final ExtractorInput extractorInput, final MediaParserHlsMediaChunkExtractor$a object) {
            this(extractorInput);
        }
        
        static int a(final b b) {
            return b.b;
        }
        
        public long getLength() {
            return this.a.getLength();
        }
        
        public long getPosition() {
            return this.a.k();
        }
        
        public int read(final byte[] array, int n, final int n2) throws IOException {
            n = this.a.n(array, n, n2);
            this.b += n;
            return n;
        }
        
        public void seekToPosition(final long n) {
            throw new UnsupportedOperationException();
        }
    }
}
