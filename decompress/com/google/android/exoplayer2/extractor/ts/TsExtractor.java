// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.Collections;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import android.util.SparseBooleanArray;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class TsExtractor implements Extractor
{
    public static final ExtractorsFactory t;
    private final int a;
    private final int b;
    private final List<TimestampAdjuster> c;
    private final ParsableByteArray d;
    private final SparseIntArray e;
    private final TsPayloadReader.Factory f;
    private final SparseArray<TsPayloadReader> g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final e j;
    private d k;
    private ExtractorOutput l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private TsPayloadReader q;
    private int r;
    private int s;
    
    static {
        t = (ExtractorsFactory)r3.e.b;
    }
    
    public TsExtractor() {
        this(0);
    }
    
    public TsExtractor(final int n) {
        this(1, n, 112800);
    }
    
    public TsExtractor(final int n, final int n2, final int n3) {
        this(n, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(n2), n3);
    }
    
    public TsExtractor(final int n, final TimestampAdjuster timestampAdjuster, final TsPayloadReader.Factory factory) {
        this(n, timestampAdjuster, factory, 112800);
    }
    
    public TsExtractor(final int a, final TimestampAdjuster timestampAdjuster, final TsPayloadReader.Factory factory, final int b) {
        this.f = Assertions.e(factory);
        this.b = b;
        this.a = a;
        if (a != 1 && a != 2) {
            (this.c = new ArrayList<TimestampAdjuster>()).add(timestampAdjuster);
        }
        else {
            this.c = Collections.singletonList(timestampAdjuster);
        }
        this.d = new ParsableByteArray(new byte[9400], 0);
        this.h = new SparseBooleanArray();
        this.i = new SparseBooleanArray();
        this.g = (SparseArray<TsPayloadReader>)new SparseArray();
        this.e = new SparseIntArray();
        this.j = new e(b);
        this.l = ExtractorOutput.n;
        this.s = -1;
        this.y();
    }
    
    public static Extractor[] c() {
        return w();
    }
    
    static SparseArray f(final TsExtractor tsExtractor) {
        return tsExtractor.g;
    }
    
    static int g(final TsExtractor tsExtractor) {
        return tsExtractor.m;
    }
    
    static boolean h(final TsExtractor tsExtractor) {
        return tsExtractor.n;
    }
    
    static boolean i(final TsExtractor tsExtractor, final boolean n) {
        return tsExtractor.n = n;
    }
    
    static int j(final TsExtractor tsExtractor, final int m) {
        return tsExtractor.m = m;
    }
    
    static int k(final TsExtractor tsExtractor) {
        return tsExtractor.m++;
    }
    
    static int l(final TsExtractor tsExtractor) {
        return tsExtractor.a;
    }
    
    static List m(final TsExtractor tsExtractor) {
        return tsExtractor.c;
    }
    
    static int n(final TsExtractor tsExtractor, final int s) {
        return tsExtractor.s = s;
    }
    
    static TsPayloadReader o(final TsExtractor tsExtractor) {
        return tsExtractor.q;
    }
    
    static TsPayloadReader p(final TsExtractor tsExtractor, final TsPayloadReader q) {
        return tsExtractor.q = q;
    }
    
    static TsPayloadReader.Factory q(final TsExtractor tsExtractor) {
        return tsExtractor.f;
    }
    
    static ExtractorOutput r(final TsExtractor tsExtractor) {
        return tsExtractor.l;
    }
    
    static SparseBooleanArray s(final TsExtractor tsExtractor) {
        return tsExtractor.h;
    }
    
    static SparseBooleanArray t(final TsExtractor tsExtractor) {
        return tsExtractor.i;
    }
    
    private boolean u(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.d.d();
        if (9400 - this.d.e() < 188) {
            final int a = this.d.a();
            if (a > 0) {
                System.arraycopy(d, this.d.e(), d, 0, a);
            }
            this.d.N(d, a);
        }
        while (this.d.a() < 188) {
            final int f = this.d.f();
            final int read = extractorInput.read(d, f, 9400 - f);
            if (read == -1) {
                return false;
            }
            this.d.O(f + read);
        }
        return true;
    }
    
    private int v() throws ParserException {
        final int e = this.d.e();
        final int f = this.d.f();
        final int a = TsUtil.a(this.d.d(), e, f);
        this.d.P(a);
        final int n = a + 188;
        if (n > f) {
            final int r = this.r + (a - e);
            this.r = r;
            if (this.a == 2) {
                if (r > 376) {
                    throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
                }
            }
        }
        else {
            this.r = 0;
        }
        return n;
    }
    
    private static Extractor[] w() {
        return new Extractor[] { new TsExtractor() };
    }
    
    private void x(final long n) {
        if (!this.o) {
            this.o = true;
            if (this.j.b() != -9223372036854775807L) {
                final d k = new d(this.j.c(), this.j.b(), n, this.s, this.b);
                this.k = k;
                this.l.l(k.b());
            }
            else {
                this.l.l(new SeekMap.Unseekable(this.j.b()));
            }
        }
    }
    
    private void y() {
        this.h.clear();
        this.g.clear();
        final SparseArray<TsPayloadReader> a = this.f.a();
        for (int size = a.size(), i = 0; i < size; ++i) {
            this.g.put(a.keyAt(i), (Object)a.valueAt(i));
        }
        this.g.put(0, (Object)new SectionReader(new a()));
        this.q = null;
    }
    
    private boolean z(final int n) {
        final int a = this.a;
        boolean b = false;
        if (a == 2 || this.n || !this.i.get(n, false)) {
            b = true;
        }
        return b;
    }
    
    @Override
    public void a(long c, final long n) {
        Assertions.g(this.a != 2);
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            final TimestampAdjuster timestampAdjuster = this.c.get(i);
            boolean b;
            if (!(b = (timestampAdjuster.e() == -9223372036854775807L))) {
                c = timestampAdjuster.c();
                b = (c != -9223372036854775807L && c != 0L && c != n);
            }
            if (b) {
                timestampAdjuster.g(n);
            }
        }
        if (n != 0L) {
            final d k = this.k;
            if (k != null) {
                k.h(n);
            }
        }
        this.d.L(0);
        this.e.clear();
        for (int j = 0; j < this.g.size(); ++j) {
            ((TsPayloadReader)this.g.valueAt(j)).c();
        }
        this.r = 0;
    }
    
    @Override
    public void b(final ExtractorOutput l) {
        this.l = l;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.d.d();
        extractorInput.r(d, 0, 940);
        int i = 0;
    Label_0023:
        while (i < 188) {
            int j = 0;
            while (true) {
                while (j < 5) {
                    if (d[j * 188 + i] != 71) {
                        final boolean b = false;
                        if (b) {
                            extractorInput.o(i);
                            return true;
                        }
                        ++i;
                        continue Label_0023;
                    }
                    else {
                        ++j;
                    }
                }
                final boolean b = true;
                continue;
            }
        }
        return false;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long length = extractorInput.getLength();
        if (this.n) {
            if (length != -1L && this.a != 2 && !this.j.d()) {
                return this.j.e(extractorInput, positionHolder, this.s);
            }
            this.x(length);
            if (this.p) {
                this.p = false;
                this.a(0L, 0L);
                if (extractorInput.getPosition() != 0L) {
                    positionHolder.a = 0L;
                    return 1;
                }
            }
            final d k = this.k;
            if (k != null && k.d()) {
                return this.k.c(extractorInput, positionHolder);
            }
        }
        if (!this.u(extractorInput)) {
            return -1;
        }
        final int v = this.v();
        final int f = this.d.f();
        if (v > f) {
            return 0;
        }
        final int n = this.d.n();
        if ((0x800000 & n) != 0x0) {
            this.d.P(v);
            return 0;
        }
        final int n2 = ((0x400000 & n) != 0x0 | false) ? 1 : 0;
        final int n3 = (0x1FFF00 & n) >> 8;
        final boolean b = (n & 0x20) != 0x0;
        TsPayloadReader tsPayloadReader;
        if ((n & 0x10) != 0x0) {
            tsPayloadReader = (TsPayloadReader)this.g.get(n3);
        }
        else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.d.P(v);
            return 0;
        }
        if (this.a != 2) {
            final int n4 = n & 0xF;
            final int value = this.e.get(n3, n4 - 1);
            this.e.put(n3, n4);
            if (value == n4) {
                this.d.P(v);
                return 0;
            }
            if (n4 != (value + 1 & 0xF)) {
                tsPayloadReader.c();
            }
        }
        int n5 = n2;
        if (b) {
            final int d = this.d.D();
            int n6;
            if ((this.d.D() & 0x40) != 0x0) {
                n6 = 2;
            }
            else {
                n6 = 0;
            }
            n5 = (n2 | n6);
            this.d.Q(d - 1);
        }
        final boolean n7 = this.n;
        if (this.z(n3)) {
            this.d.O(v);
            tsPayloadReader.b(this.d, n5);
            this.d.O(f);
        }
        if (this.a != 2 && !n7 && this.n && length != -1L) {
            this.p = true;
        }
        this.d.P(v);
        return 0;
    }
    
    @Override
    public void release() {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Mode {
    }
    
    private class a implements SectionPayloadReader
    {
        private final ParsableBitArray a;
        final TsExtractor b;
        
        public a(final TsExtractor b) {
            this.b = b;
            this.a = new ParsableBitArray(new byte[4]);
        }
        
        @Override
        public void a(final TimestampAdjuster timestampAdjuster, final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
        
        @Override
        public void b(final ParsableByteArray parsableByteArray) {
            if (parsableByteArray.D() != 0) {
                return;
            }
            if ((parsableByteArray.D() & 0x80) == 0x0) {
                return;
            }
            parsableByteArray.Q(6);
            for (int n = parsableByteArray.a() / 4, i = 0; i < n; ++i) {
                parsableByteArray.i(this.a, 4);
                final int h = this.a.h(16);
                this.a.r(3);
                if (h == 0) {
                    this.a.r(13);
                }
                else {
                    final int h2 = this.a.h(13);
                    if (TsExtractor.f(this.b).get(h2) == null) {
                        TsExtractor.f(this.b).put(h2, (Object)new SectionReader(this.b.new b(h2)));
                        TsExtractor.k(this.b);
                    }
                }
            }
            if (TsExtractor.l(this.b) != 2) {
                TsExtractor.f(this.b).remove(0);
            }
        }
    }
    
    private class b implements SectionPayloadReader
    {
        private final ParsableBitArray a;
        private final SparseArray<TsPayloadReader> b;
        private final SparseIntArray c;
        private final int d;
        final TsExtractor e;
        
        public b(final TsExtractor e, final int d) {
            this.e = e;
            this.a = new ParsableBitArray(new byte[5]);
            this.b = (SparseArray<TsPayloadReader>)new SparseArray();
            this.c = new SparseIntArray();
            this.d = d;
        }
        
        private TsPayloadReader.EsInfo c(final ParsableByteArray parsableByteArray, int d) {
            final int e = parsableByteArray.e();
            final int n = d + e;
            String s = null;
            d = -1;
            List<TsPayloadReader.DvbSubtitleInfo> list = null;
            while (parsableByteArray.e() < n) {
                final int d2 = parsableByteArray.D();
                final int n2 = parsableByteArray.e() + parsableByteArray.D();
                if (n2 > n) {
                    break;
                }
                String trim = null;
                List<TsPayloadReader.DvbSubtitleInfo> list2 = null;
                Label_0379: {
                    Label_0178: {
                        Label_0156: {
                            if (d2 == 5) {
                                final long f = parsableByteArray.F();
                                if (f == 1094921523L) {
                                    break Label_0156;
                                }
                                if (f == 1161904947L) {
                                    break Label_0178;
                                }
                                if (f != 1094921524L) {
                                    trim = s;
                                    list2 = list;
                                    if (f == 1212503619L) {
                                        d = 36;
                                        trim = s;
                                        list2 = list;
                                    }
                                    break Label_0379;
                                }
                            }
                            else {
                                if (d2 == 106) {
                                    break Label_0156;
                                }
                                if (d2 == 122) {
                                    break Label_0178;
                                }
                                if (d2 == 127) {
                                    trim = s;
                                    list2 = list;
                                    if (parsableByteArray.D() != 21) {
                                        break Label_0379;
                                    }
                                }
                                else {
                                    if (d2 == 123) {
                                        d = 138;
                                        trim = s;
                                        list2 = list;
                                        break Label_0379;
                                    }
                                    if (d2 == 10) {
                                        trim = parsableByteArray.A(3).trim();
                                        list2 = list;
                                        break Label_0379;
                                    }
                                    if (d2 == 89) {
                                        list2 = new ArrayList<TsPayloadReader.DvbSubtitleInfo>();
                                        while (parsableByteArray.e() < n2) {
                                            final String trim2 = parsableByteArray.A(3).trim();
                                            d = parsableByteArray.D();
                                            final byte[] array = new byte[4];
                                            parsableByteArray.j(array, 0, 4);
                                            list2.add(new TsPayloadReader.DvbSubtitleInfo(trim2, d, array));
                                        }
                                        d = 89;
                                        trim = s;
                                        break Label_0379;
                                    }
                                    trim = s;
                                    list2 = list;
                                    if (d2 == 111) {
                                        d = 257;
                                        list2 = list;
                                        trim = s;
                                    }
                                    break Label_0379;
                                }
                            }
                            d = 172;
                            trim = s;
                            list2 = list;
                            break Label_0379;
                        }
                        d = 129;
                        trim = s;
                        list2 = list;
                        break Label_0379;
                    }
                    d = 135;
                    trim = s;
                    list2 = list;
                }
                parsableByteArray.Q(n2 - parsableByteArray.e());
                s = trim;
                list = list2;
            }
            parsableByteArray.P(n);
            return new TsPayloadReader.EsInfo(d, s, list, Arrays.copyOfRange(parsableByteArray.d(), e, n));
        }
        
        @Override
        public void a(final TimestampAdjuster timestampAdjuster, final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
        
        @Override
        public void b(final ParsableByteArray parsableByteArray) {
            if (parsableByteArray.D() != 2) {
                return;
            }
            TimestampAdjuster timestampAdjuster;
            if (TsExtractor.l(this.e) != 1 && TsExtractor.l(this.e) != 2 && TsExtractor.g(this.e) != 1) {
                timestampAdjuster = new TimestampAdjuster(TsExtractor.m(this.e).get(0).c());
                TsExtractor.m(this.e).add(timestampAdjuster);
            }
            else {
                timestampAdjuster = TsExtractor.m(this.e).get(0);
            }
            if ((parsableByteArray.D() & 0x80) == 0x0) {
                return;
            }
            parsableByteArray.Q(1);
            final int j = parsableByteArray.J();
            parsableByteArray.Q(3);
            parsableByteArray.i(this.a, 2);
            this.a.r(3);
            TsExtractor.n(this.e, this.a.h(13));
            parsableByteArray.i(this.a, 2);
            this.a.r(4);
            parsableByteArray.Q(this.a.h(12));
            if (TsExtractor.l(this.e) == 2 && TsExtractor.o(this.e) == null) {
                final TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, null, Util.f);
                final TsExtractor e = this.e;
                TsExtractor.p(e, TsExtractor.q(e).b(21, esInfo));
                if (TsExtractor.o(this.e) != null) {
                    TsExtractor.o(this.e).a(timestampAdjuster, TsExtractor.r(this.e), new TsPayloadReader.TrackIdGenerator(j, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int n;
            for (int i = parsableByteArray.a(); i > 0; i = n) {
                parsableByteArray.i(this.a, 5);
                final int h = this.a.h(8);
                this.a.r(3);
                final int h2 = this.a.h(13);
                this.a.r(4);
                final int h3 = this.a.h(12);
                final TsPayloadReader.EsInfo c = this.c(parsableByteArray, h3);
                int a;
                if (h == 6 || (a = h) == 5) {
                    a = c.a;
                }
                n = i - (h3 + 5);
                int n2;
                if (TsExtractor.l(this.e) == 2) {
                    n2 = a;
                }
                else {
                    n2 = h2;
                }
                if (!TsExtractor.s(this.e).get(n2)) {
                    TsPayloadReader tsPayloadReader;
                    if (TsExtractor.l(this.e) == 2 && a == 21) {
                        tsPayloadReader = TsExtractor.o(this.e);
                    }
                    else {
                        tsPayloadReader = TsExtractor.q(this.e).b(a, c);
                    }
                    if (TsExtractor.l(this.e) != 2 || h2 < this.c.get(n2, 8192)) {
                        this.c.put(n2, h2);
                        this.b.put(n2, (Object)tsPayloadReader);
                    }
                }
            }
            for (int size = this.c.size(), k = 0; k < size; ++k) {
                final int key = this.c.keyAt(k);
                final int value = this.c.valueAt(k);
                TsExtractor.s(this.e).put(key, true);
                TsExtractor.t(this.e).put(value, true);
                final TsPayloadReader tsPayloadReader2 = (TsPayloadReader)this.b.valueAt(k);
                if (tsPayloadReader2 != null) {
                    if (tsPayloadReader2 != TsExtractor.o(this.e)) {
                        tsPayloadReader2.a(timestampAdjuster, TsExtractor.r(this.e), new TsPayloadReader.TrackIdGenerator(j, key, 8192));
                    }
                    TsExtractor.f(this.e).put(value, (Object)tsPayloadReader2);
                }
            }
            if (TsExtractor.l(this.e) == 2) {
                if (!TsExtractor.h(this.e)) {
                    TsExtractor.r(this.e).o();
                    TsExtractor.j(this.e, 0);
                    TsExtractor.i(this.e, true);
                }
            }
            else {
                TsExtractor.f(this.e).remove(this.d);
                final TsExtractor e2 = this.e;
                int n3;
                if (TsExtractor.l(e2) == 1) {
                    n3 = 0;
                }
                else {
                    n3 = TsExtractor.g(this.e) - 1;
                }
                TsExtractor.j(e2, n3);
                if (TsExtractor.g(this.e) == 0) {
                    TsExtractor.r(this.e).o();
                    TsExtractor.i(this.e, true);
                }
            }
        }
    }
}
