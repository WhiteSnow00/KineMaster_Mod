// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.EOFException;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import o3.b;
import o3.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class Mp3Extractor implements Extractor
{
    public static final ExtractorsFactory u;
    private static final Id3Decoder.FramePredicate v;
    private final int a;
    private final long b;
    private final ParsableByteArray c;
    private final MpegAudioUtil.Header d;
    private final GaplessInfoHolder e;
    private final Id3Peeker f;
    private final TrackOutput g;
    private ExtractorOutput h;
    private TrackOutput i;
    private TrackOutput j;
    private int k;
    private Metadata l;
    private long m;
    private long n;
    private long o;
    private int p;
    private Seeker q;
    private boolean r;
    private boolean s;
    private long t;
    
    static {
        u = (ExtractorsFactory)a.b;
        v = (Id3Decoder.FramePredicate)b.a;
    }
    
    public Mp3Extractor() {
        this(0);
    }
    
    public Mp3Extractor(final int n) {
        this(n, -9223372036854775807L);
    }
    
    public Mp3Extractor(final int n, final long b) {
        int a = n;
        if ((n & 0x2) != 0x0) {
            a = (n | 0x1);
        }
        this.a = a;
        this.b = b;
        this.c = new ParsableByteArray(10);
        this.d = new MpegAudioUtil.Header();
        this.e = new GaplessInfoHolder();
        this.m = -9223372036854775807L;
        this.f = new Id3Peeker();
        final DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.g = dummyTrackOutput;
        this.j = dummyTrackOutput;
    }
    
    public static Extractor[] c() {
        return o();
    }
    
    public static boolean f(final int n, final int n2, final int n3, final int n4, final int n5) {
        return p(n, n2, n3, n4, n5);
    }
    
    private void g() {
        Assertions.i(this.i);
        Util.j(this.h);
    }
    
    private Seeker h(final ExtractorInput extractorInput) throws IOException {
        final Seeker r = this.r(extractorInput);
        Seeker q = q(this.l, extractorInput.getPosition());
        if (this.r) {
            return new Seeker.UnseekableSeeker();
        }
        if ((this.a & 0x4) != 0x0) {
            long n;
            long n2;
            if (q != null) {
                n = q.i();
                n2 = q.g();
            }
            else if (r != null) {
                n = r.i();
                n2 = r.g();
            }
            else {
                n = l(this.l);
                n2 = -1L;
            }
            q = new com.google.android.exoplayer2.extractor.mp3.b(n, extractorInput.getPosition(), n2);
        }
        else if (q == null) {
            if (r != null) {
                q = r;
            }
            else {
                q = null;
            }
        }
        boolean b = true;
        if (q != null) {
            Seeker k = q;
            if (q.h()) {
                return k;
            }
            k = q;
            if ((this.a & 0x1) == 0x0) {
                return k;
            }
        }
        if ((this.a & 0x2) == 0x0) {
            b = false;
        }
        return this.k(extractorInput, b);
    }
    
    private long i(final long n) {
        return this.m + n * 1000000L / this.d.d;
    }
    
    private Seeker k(final ExtractorInput extractorInput, final boolean b) throws IOException {
        extractorInput.r(this.c.d(), 0, 4);
        this.c.P(0);
        this.d.a(this.c.n());
        return new com.google.android.exoplayer2.extractor.mp3.a(extractorInput.getLength(), extractorInput.getPosition(), this.d, b);
    }
    
    private static long l(final Metadata metadata) {
        if (metadata != null) {
            for (int d = metadata.d(), i = 0; i < d; ++i) {
                final Metadata.Entry c = metadata.c(i);
                if (c instanceof TextInformationFrame) {
                    final TextInformationFrame textInformationFrame = (TextInformationFrame)c;
                    if (textInformationFrame.a.equals("TLEN")) {
                        return Util.C0(Long.parseLong(textInformationFrame.c));
                    }
                }
            }
        }
        return -9223372036854775807L;
    }
    
    private static int m(final ParsableByteArray parsableByteArray, int n) {
        if (parsableByteArray.f() >= n + 4) {
            parsableByteArray.P(n);
            n = parsableByteArray.n();
            if (n == 1483304551 || n == 1231971951) {
                return n;
            }
        }
        if (parsableByteArray.f() >= 40) {
            parsableByteArray.P(36);
            if (parsableByteArray.n() == 1447187017) {
                return 1447187017;
            }
        }
        return 0;
    }
    
    private static boolean n(final int n, final long n2) {
        return (n & 0xFFFE0C00) == (n2 & 0xFFFFFFFFFFFE0C00L);
    }
    
    private static Extractor[] o() {
        return new Extractor[] { new Mp3Extractor() };
    }
    
    private static boolean p(final int n, final int n2, final int n3, final int n4, final int n5) {
        return (n2 == 67 && n3 == 79 && n4 == 77 && (n5 == 77 || n == 2)) || (n2 == 77 && n3 == 76 && n4 == 76 && (n5 == 84 || n == 2));
    }
    
    private static c q(final Metadata metadata, final long n) {
        if (metadata != null) {
            for (int d = metadata.d(), i = 0; i < d; ++i) {
                final Metadata.Entry c = metadata.c(i);
                if (c instanceof MlltFrame) {
                    return com.google.android.exoplayer2.extractor.mp3.c.a(n, (MlltFrame)c, l(metadata));
                }
            }
        }
        return null;
    }
    
    private Seeker r(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(this.d.c);
        extractorInput.r(parsableByteArray.d(), 0, this.d.c);
        final MpegAudioUtil.Header d = this.d;
        final int a = d.a;
        int n = 21;
        if ((a & 0x1) != 0x0) {
            if (d.e != 1) {
                n = 36;
            }
        }
        else if (d.e == 1) {
            n = 13;
        }
        final int m = m(parsableByteArray, n);
        d a2;
        if (m != 1483304551 && m != 1231971951) {
            if (m == 1447187017) {
                a2 = com.google.android.exoplayer2.extractor.mp3.d.a(extractorInput.getLength(), extractorInput.getPosition(), this.d, parsableByteArray);
                extractorInput.o(this.d.c);
            }
            else {
                a2 = null;
                extractorInput.h();
            }
        }
        else {
            final e a3 = com.google.android.exoplayer2.extractor.mp3.e.a(extractorInput.getLength(), extractorInput.getPosition(), this.d, parsableByteArray);
            if (a3 != null && !this.e.a()) {
                extractorInput.h();
                extractorInput.m(n + 141);
                extractorInput.r(this.c.d(), 0, 3);
                this.c.P(0);
                this.e.d(this.c.G());
            }
            extractorInput.o(this.d.c);
            if ((a2 = (d)a3) != null) {
                a2 = (d)a3;
                if (!a3.h()) {
                    a2 = (d)a3;
                    if (m == 1231971951) {
                        return this.k(extractorInput, false);
                    }
                }
            }
        }
        return a2;
    }
    
    private boolean s(final ExtractorInput extractorInput) throws IOException {
        final Seeker q = this.q;
        if (q != null) {
            final long g = q.g();
            if (g != -1L && extractorInput.k() > g - 4L) {
                return true;
            }
        }
        try {
            return extractorInput.f(this.c.d(), 0, 4, true) ^ true;
        }
        catch (final EOFException ex) {
            return true;
        }
    }
    
    private int t(final ExtractorInput extractorInput) throws IOException {
        if (this.k == 0) {
            try {
                this.v(extractorInput, false);
            }
            catch (final EOFException ex) {
                return -1;
            }
        }
        if (this.q == null) {
            final Seeker h = this.h(extractorInput);
            this.q = h;
            this.h.l(h);
            final TrackOutput j = this.j;
            final Format.Builder o = new Format.Builder().e0(this.d.b).W(4096).H(this.d.e).f0(this.d.d).N(this.e.a).O(this.e.b);
            Metadata l;
            if ((this.a & 0x8) != 0x0) {
                l = null;
            }
            else {
                l = this.l;
            }
            j.d(o.X(l).E());
            this.o = extractorInput.getPosition();
        }
        else if (this.o != 0L) {
            final long position = extractorInput.getPosition();
            final long o2 = this.o;
            if (position < o2) {
                extractorInput.o((int)(o2 - position));
            }
        }
        return this.u(extractorInput);
    }
    
    private int u(final ExtractorInput extractorInput) throws IOException {
        if (this.p == 0) {
            extractorInput.h();
            if (this.s(extractorInput)) {
                return -1;
            }
            this.c.P(0);
            final int n = this.c.n();
            if (!n(n, this.k) || MpegAudioUtil.j(n) == -1) {
                extractorInput.o(1);
                return this.k = 0;
            }
            this.d.a(n);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.c(extractorInput.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.c(0L);
                }
            }
            final MpegAudioUtil.Header d = this.d;
            this.p = d.c;
            final Seeker q = this.q;
            if (q instanceof com.google.android.exoplayer2.extractor.mp3.b) {
                final com.google.android.exoplayer2.extractor.mp3.b b = (com.google.android.exoplayer2.extractor.mp3.b)q;
                b.b(this.i(this.n + d.g), extractorInput.getPosition() + this.d.c);
                if (this.s && b.a(this.t)) {
                    this.s = false;
                    this.j = this.i;
                }
            }
        }
        final int b2 = this.j.b(extractorInput, this.p, true);
        if (b2 == -1) {
            return -1;
        }
        if ((this.p -= b2) > 0) {
            return 0;
        }
        this.j.e(this.i(this.n), 1, this.d.c, 0, null);
        this.n += this.d.g;
        return this.p = 0;
    }
    
    private boolean v(final ExtractorInput extractorInput, final boolean b) throws IOException {
        int n;
        if (b) {
            n = 32768;
        }
        else {
            n = 131072;
        }
        extractorInput.h();
        int n2;
        if (extractorInput.getPosition() == 0L) {
            Id3Decoder.FramePredicate v;
            if ((this.a & 0x8) == 0x0) {
                v = null;
            }
            else {
                v = Mp3Extractor.v;
            }
            final Metadata a = this.f.a(extractorInput, v);
            this.l = a;
            if (a != null) {
                this.e.c(a);
            }
            n2 = (int)extractorInput.k();
            if (!b) {
                extractorInput.o(n2);
            }
        }
        else {
            n2 = 0;
        }
        int k = 0;
        int n3 = 0;
        int n4 = 0;
        while (true) {
            while (!this.s(extractorInput)) {
                this.c.P(0);
                final int n5 = this.c.n();
                if (k == 0 || n(n5, k)) {
                    final int j = MpegAudioUtil.j(n5);
                    if (j != -1) {
                        final int n6 = n3 + 1;
                        int n7;
                        if (n6 == 1) {
                            this.d.a(n5);
                            n7 = n5;
                        }
                        else {
                            n7 = k;
                            if (n6 == 4) {
                                if (b) {
                                    extractorInput.o(n2 + n4);
                                }
                                else {
                                    extractorInput.h();
                                }
                                this.k = k;
                                return true;
                            }
                        }
                        extractorInput.m(j - 4);
                        k = n7;
                        n3 = n6;
                        continue;
                    }
                }
                final int n8 = n4 + 1;
                if (n4 == n) {
                    if (b) {
                        return false;
                    }
                    throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                }
                else {
                    if (b) {
                        extractorInput.h();
                        extractorInput.m(n2 + n8);
                    }
                    else {
                        extractorInput.o(1);
                    }
                    n3 = 0;
                    n4 = n8;
                    k = 0;
                }
            }
            if (n3 > 0) {
                continue;
            }
            break;
        }
        throw new EOFException();
    }
    
    @Override
    public void a(final long n, final long t) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = t;
        final Seeker q = this.q;
        if (q instanceof com.google.android.exoplayer2.extractor.mp3.b && !((com.google.android.exoplayer2.extractor.mp3.b)q).a(t)) {
            this.s = true;
            this.j = this.g;
        }
    }
    
    @Override
    public void b(final ExtractorOutput h) {
        this.h = h;
        final TrackOutput e = h.e(0, 1);
        this.i = e;
        this.j = e;
        this.h.o();
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return this.v(extractorInput, true);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        this.g();
        final int t = this.t(extractorInput);
        if (t == -1 && this.q instanceof com.google.android.exoplayer2.extractor.mp3.b) {
            final long i = this.i(this.n);
            if (this.q.i() != i) {
                ((com.google.android.exoplayer2.extractor.mp3.b)this.q).d(i);
                this.h.l(this.q);
            }
        }
        return t;
    }
    
    public void j() {
        this.r = true;
    }
    
    @Override
    public void release() {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
}
