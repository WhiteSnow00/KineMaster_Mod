// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.util.Arrays;
import com.google.android.exoplayer2.extractor.PositionHolder;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.extractor.Extractor;

public final class WebvttExtractor implements Extractor
{
    private static final Pattern g;
    private static final Pattern h;
    private final String a;
    private final TimestampAdjuster b;
    private final ParsableByteArray c;
    private ExtractorOutput d;
    private byte[] e;
    private int f;
    
    static {
        g = Pattern.compile("LOCAL:([^,]+)");
        h = Pattern.compile("MPEGTS:(-?\\d+)");
    }
    
    public WebvttExtractor(final String a, final TimestampAdjuster b) {
        this.a = a;
        this.b = b;
        this.c = new ParsableByteArray();
        this.e = new byte[1024];
    }
    
    private TrackOutput c(final long n) {
        final TrackOutput e = this.d.e(0, 3);
        e.d(new Format.Builder().e0("text/vtt").V(this.a).i0(n).E());
        this.d.o();
        return e;
    }
    
    private void f() throws ParserException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(this.e);
        WebvttParserUtil.e(parsableByteArray);
        String s = parsableByteArray.p();
        long f = 0L;
        long d = 0L;
        while (!TextUtils.isEmpty((CharSequence)s)) {
            if (s.startsWith("X-TIMESTAMP-MAP")) {
                final Matcher matcher = WebvttExtractor.g.matcher(s);
                if (!matcher.find()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
                    sb.append(s);
                    throw ParserException.createForMalformedContainer(sb.toString(), null);
                }
                final Matcher matcher2 = WebvttExtractor.h.matcher(s);
                if (!matcher2.find()) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
                    sb2.append(s);
                    throw ParserException.createForMalformedContainer(sb2.toString(), null);
                }
                d = WebvttParserUtil.d(Assertions.e(matcher.group(1)));
                f = TimestampAdjuster.f(Long.parseLong(Assertions.e(matcher2.group(1))));
            }
            s = parsableByteArray.p();
        }
        final Matcher a = WebvttParserUtil.a(parsableByteArray);
        if (a == null) {
            this.c(0L);
            return;
        }
        final long d2 = WebvttParserUtil.d(Assertions.e(a.group(1)));
        final long b = this.b.b(TimestampAdjuster.j(f + d2 - d));
        final TrackOutput c = this.c(b - d2);
        this.c.N(this.e, this.f);
        c.c(this.c, this.f);
        c.e(b, 1, this.f, 0, null);
    }
    
    @Override
    public void a(final long n, final long n2) {
        throw new IllegalStateException();
    }
    
    @Override
    public void b(final ExtractorOutput d) {
        (this.d = d).l(new SeekMap.Unseekable(-9223372036854775807L));
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        extractorInput.f(this.e, 0, 6, false);
        this.c.N(this.e, 6);
        if (WebvttParserUtil.b(this.c)) {
            return true;
        }
        extractorInput.f(this.e, 6, 3, false);
        this.c.N(this.e, 9);
        return WebvttParserUtil.b(this.c);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.e(this.d);
        final int n = (int)extractorInput.getLength();
        final int f = this.f;
        final byte[] e = this.e;
        if (f == e.length) {
            int length;
            if (n != -1) {
                length = n;
            }
            else {
                length = e.length;
            }
            this.e = Arrays.copyOf(e, length * 3 / 2);
        }
        final byte[] e2 = this.e;
        final int f2 = this.f;
        final int read = extractorInput.read(e2, f2, e2.length - f2);
        if (read != -1) {
            final int f3 = this.f + read;
            this.f = f3;
            if (n == -1 || f3 != n) {
                return 0;
            }
        }
        this.f();
        return -1;
    }
    
    @Override
    public void release() {
    }
}
