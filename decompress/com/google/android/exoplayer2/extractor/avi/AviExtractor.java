// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import java.util.Iterator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.Extractor;

public final class AviExtractor implements Extractor
{
    private final ParsableByteArray a;
    private final c b;
    private int c;
    private ExtractorOutput d;
    private com.google.android.exoplayer2.extractor.avi.b e;
    private long f;
    private d[] g;
    private long h;
    private d i;
    private int j;
    private long k;
    private long l;
    private int m;
    private boolean n;
    
    public AviExtractor() {
        this.a = new ParsableByteArray(12);
        this.b = new c(null);
        this.d = new DummyExtractorOutput();
        this.g = new d[0];
        this.k = -1L;
        this.l = -1L;
        this.j = -1;
        this.f = -9223372036854775807L;
    }
    
    static d[] c(final AviExtractor aviExtractor) {
        return aviExtractor.g;
    }
    
    private static void f(final ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 0x1L) == 0x1L) {
            extractorInput.o(1);
        }
    }
    
    private d g(final int n) {
        for (final d d : this.g) {
            if (d.j(n)) {
                return d;
            }
        }
        return null;
    }
    
    private void h(final ParsableByteArray parsableByteArray) throws IOException {
        final e c = com.google.android.exoplayer2.extractor.avi.e.c(1819436136, parsableByteArray);
        if (c.getType() != 1819436136) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected header list type ");
            sb.append(c.getType());
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        final com.google.android.exoplayer2.extractor.avi.b e = c.b(com.google.android.exoplayer2.extractor.avi.b.class);
        if (e != null) {
            this.e = e;
            this.f = e.c * (long)e.a;
            final ArrayList list = new ArrayList();
            final UnmodifiableIterator iterator = c.a.iterator();
            int n = 0;
            while (((Iterator)iterator).hasNext()) {
                final a a = (a)((Iterator)iterator).next();
                if (a.getType() == 1819440243) {
                    final d k = this.k((e)a, n);
                    if (k != null) {
                        list.add(k);
                    }
                    ++n;
                }
            }
            this.g = list.toArray(new d[0]);
            this.d.o();
            return;
        }
        throw ParserException.createForMalformedContainer("AviHeader not found", null);
    }
    
    private void i(final ParsableByteArray parsableByteArray) {
        final long j = this.j(parsableByteArray);
        while (parsableByteArray.a() >= 16) {
            final int q = parsableByteArray.q();
            final int q2 = parsableByteArray.q();
            final long n = parsableByteArray.q();
            parsableByteArray.q();
            final d g = this.g(q);
            if (g == null) {
                continue;
            }
            if ((q2 & 0x10) == 0x10) {
                g.b(n + j);
            }
            g.k();
        }
        final d[] g2 = this.g;
        for (int length = g2.length, i = 0; i < length; ++i) {
            g2[i].c();
        }
        this.n = true;
        this.d.l(new b(this.f));
    }
    
    private long j(final ParsableByteArray parsableByteArray) {
        final int a = parsableByteArray.a();
        long n = 0L;
        if (a < 16) {
            return 0L;
        }
        final int e = parsableByteArray.e();
        parsableByteArray.Q(8);
        final long n2 = parsableByteArray.q();
        final long k = this.k;
        if (n2 <= k) {
            n = 8L + k;
        }
        parsableByteArray.P(e);
        return n;
    }
    
    private d k(final e e, final int n) {
        final com.google.android.exoplayer2.extractor.avi.c c = e.b(com.google.android.exoplayer2.extractor.avi.c.class);
        final f f = e.b(f.class);
        if (c == null) {
            Log.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (f == null) {
            Log.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        final long a = c.a();
        final Format a2 = f.a;
        final Format.Builder b = a2.b();
        b.R(n);
        final int f2 = c.f;
        if (f2 != 0) {
            b.W(f2);
        }
        final g g = e.b(g.class);
        if (g != null) {
            b.U(g.a);
        }
        final int k = MimeTypes.k(a2.w);
        if (k != 1 && k != 2) {
            return null;
        }
        final TrackOutput e2 = this.d.e(n, k);
        e2.d(b.E());
        final d d = new d(n, k, a, c.e, e2);
        this.f = a;
        return d;
    }
    
    private int l(final ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.l) {
            return -1;
        }
        final d i = this.i;
        if (i != null) {
            if (i.m(extractorInput)) {
                this.i = null;
            }
        }
        else {
            f(extractorInput);
            final byte[] d = this.a.d();
            int n = 12;
            extractorInput.r(d, 0, 12);
            this.a.P(0);
            final int q = this.a.q();
            if (q == 1414744396) {
                this.a.P(8);
                if (this.a.q() != 1769369453) {
                    n = 8;
                }
                extractorInput.o(n);
                extractorInput.h();
                return 0;
            }
            final int q2 = this.a.q();
            if (q == 1263424842) {
                this.h = extractorInput.getPosition() + q2 + 8L;
                return 0;
            }
            extractorInput.o(8);
            extractorInput.h();
            final d g = this.g(q);
            if (g == null) {
                this.h = extractorInput.getPosition() + q2;
                return 0;
            }
            g.n(q2);
            this.i = g;
        }
        return 0;
    }
    
    private boolean m(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        boolean b = false;
        Label_0073: {
            if (this.h != -1L) {
                final long position = extractorInput.getPosition();
                final long h = this.h;
                if (h < position || h > 262144L + position) {
                    positionHolder.a = h;
                    b = true;
                    break Label_0073;
                }
                extractorInput.o((int)(h - position));
            }
            b = false;
        }
        this.h = -1L;
        return b;
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.h = -1L;
        this.i = null;
        final d[] g = this.g;
        for (int length = g.length, i = 0; i < length; ++i) {
            g[i].o(n);
        }
        if (n == 0L) {
            if (this.g.length == 0) {
                this.c = 0;
            }
            else {
                this.c = 3;
            }
            return;
        }
        this.c = 6;
    }
    
    @Override
    public void b(final ExtractorOutput d) {
        this.c = 0;
        this.d = d;
        this.h = -1L;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.a.d();
        boolean b = false;
        extractorInput.r(d, 0, 12);
        this.a.P(0);
        if (this.a.q() != 1179011410) {
            return false;
        }
        this.a.Q(4);
        if (this.a.q() == 541677121) {
            b = true;
        }
        return b;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        if (this.m(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.c) {
            default: {
                throw new AssertionError();
            }
            case 6: {
                return this.l(extractorInput);
            }
            case 5: {
                final ParsableByteArray parsableByteArray = new ParsableByteArray(this.m);
                extractorInput.readFully(parsableByteArray.d(), 0, this.m);
                this.i(parsableByteArray);
                this.c = 6;
                this.h = this.k;
                return 0;
            }
            case 4: {
                extractorInput.readFully(this.a.d(), 0, 8);
                this.a.P(0);
                final int q = this.a.q();
                final int q2 = this.a.q();
                if (q == 829973609) {
                    this.c = 5;
                    this.m = q2;
                }
                else {
                    this.h = extractorInput.getPosition() + q2;
                }
                return 0;
            }
            case 3: {
                if (this.k != -1L) {
                    final long position = extractorInput.getPosition();
                    final long k = this.k;
                    if (position != k) {
                        this.h = k;
                        return 0;
                    }
                }
                extractorInput.r(this.a.d(), 0, 12);
                extractorInput.h();
                this.a.P(0);
                this.b.a(this.a);
                final int q3 = this.a.q();
                final int a = this.b.a;
                if (a == 1179011410) {
                    extractorInput.o(12);
                    return 0;
                }
                if (a == 1414744396 && q3 == 1769369453) {
                    final long position2 = extractorInput.getPosition();
                    this.k = position2;
                    this.l = position2 + this.b.b + 8L;
                    if (!this.n) {
                        if (Assertions.e(this.e).a()) {
                            this.c = 4;
                            this.h = this.l;
                            return 0;
                        }
                        this.d.l(new SeekMap.Unseekable(this.f));
                        this.n = true;
                    }
                    this.h = extractorInput.getPosition() + 12L;
                    this.c = 6;
                    return 0;
                }
                this.h = extractorInput.getPosition() + this.b.b + 8L;
                return 0;
            }
            case 2: {
                final int n = this.j - 4;
                final ParsableByteArray parsableByteArray2 = new ParsableByteArray(n);
                extractorInput.readFully(parsableByteArray2.d(), 0, n);
                this.h(parsableByteArray2);
                this.c = 3;
                return 0;
            }
            case 1: {
                extractorInput.readFully(this.a.d(), 0, 12);
                this.a.P(0);
                this.b.b(this.a);
                final c b = this.b;
                if (b.c == 1819436136) {
                    this.j = b.b;
                    this.c = 2;
                    return 0;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("hdrl expected, found: ");
                sb.append(this.b.c);
                throw ParserException.createForMalformedContainer(sb.toString(), null);
            }
            case 0: {
                if (this.d(extractorInput)) {
                    extractorInput.o(12);
                    this.c = 1;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("AVI Header List not found", null);
            }
        }
    }
    
    @Override
    public void release() {
    }
    
    private class b implements SeekMap
    {
        private final long a;
        final AviExtractor b;
        
        public b(final AviExtractor b, final long a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public SeekPoints f(final long n) {
            SeekPoints i = AviExtractor.c(this.b)[0].i(n);
            SeekPoints seekPoints;
            for (int j = 1; j < AviExtractor.c(this.b).length; ++j, i = seekPoints) {
                final SeekPoints k = AviExtractor.c(this.b)[j].i(n);
                seekPoints = i;
                if (k.a.b < i.a.b) {
                    seekPoints = k;
                }
            }
            return i;
        }
        
        @Override
        public boolean h() {
            return true;
        }
        
        @Override
        public long i() {
            return this.a;
        }
    }
    
    private static class c
    {
        public int a;
        public int b;
        public int c;
        
        private c() {
        }
        
        c(final AviExtractor$a object) {
            this();
        }
        
        public void a(final ParsableByteArray parsableByteArray) {
            this.a = parsableByteArray.q();
            this.b = parsableByteArray.q();
            this.c = 0;
        }
        
        public void b(final ParsableByteArray parsableByteArray) throws ParserException {
            this.a(parsableByteArray);
            if (this.a == 1414744396) {
                this.c = parsableByteArray.q();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("LIST expected, found: ");
            sb.append(this.a);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
    }
}
