// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;

public class SampleQueue implements TrackOutput
{
    private Format A;
    private Format B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;
    private final w a;
    private final b b;
    private final z<c> c;
    private final DrmSessionManager d;
    private final DrmSessionEventListener.EventDispatcher e;
    private UpstreamFormatChangedListener f;
    private Format g;
    private DrmSession h;
    private int i;
    private int[] j;
    private long[] k;
    private int[] l;
    private int[] m;
    private long[] n;
    private CryptoData[] o;
    private int p;
    private int q;
    private int r;
    private int s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    protected SampleQueue(final Allocator allocator, final DrmSessionManager d, final DrmSessionEventListener.EventDispatcher e) {
        this.d = d;
        this.e = e;
        this.a = new w(allocator);
        this.b = new b();
        this.i = 1000;
        this.j = new int[1000];
        this.k = new long[1000];
        this.n = new long[1000];
        this.m = new int[1000];
        this.l = new int[1000];
        this.o = new CryptoData[1000];
        this.c = new z<c>(com.google.android.exoplayer2.source.x.a);
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.y = true;
        this.x = true;
    }
    
    private long B(final int n) {
        long max = Long.MIN_VALUE;
        if (n == 0) {
            return Long.MIN_VALUE;
        }
        int d = this.D(n - 1);
        int n2 = 0;
        long n3;
        while (true) {
            n3 = max;
            if (n2 >= n) {
                break;
            }
            max = Math.max(max, this.n[d]);
            if ((this.m[d] & 0x1) != 0x0) {
                n3 = max;
                break;
            }
            if (--d == -1) {
                d = this.i - 1;
            }
            ++n2;
        }
        return n3;
    }
    
    private int D(int n) {
        n += this.r;
        final int i = this.i;
        if (n >= i) {
            n -= i;
        }
        return n;
    }
    
    private boolean H() {
        return this.s != this.p;
    }
    
    private static void L(final c c) {
        c.b.release();
    }
    
    private boolean M(final int n) {
        final DrmSession h = this.h;
        return h == null || h.getState() == 4 || ((this.m[n] & 0x40000000) == 0x0 && this.h.e());
    }
    
    private void O(final Format g, final FormatHolder formatHolder) {
        final Format g2 = this.g;
        final boolean b = g2 == null;
        Object z;
        if (b) {
            z = null;
        }
        else {
            z = g2.z;
        }
        this.g = g;
        final DrmInitData z2 = g.z;
        final DrmSessionManager d = this.d;
        Format c;
        if (d != null) {
            c = g.c(d.a(g));
        }
        else {
            c = g;
        }
        formatHolder.b = c;
        formatHolder.a = this.h;
        if (this.d == null) {
            return;
        }
        if (!b && Util.c(z, z2)) {
            return;
        }
        final DrmSession h = this.h;
        final DrmSession c2 = this.d.c(this.e, g);
        this.h = c2;
        formatHolder.a = c2;
        if (h != null) {
            h.c(this.e);
        }
    }
    
    private int P(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final boolean b, final boolean b2, final b b3) {
        synchronized (this) {
            decoderInputBuffer.e = false;
            if (!this.H()) {
                if (b2 || this.w) {
                    decoderInputBuffer.q(4);
                    return -4;
                }
                final Format b4 = this.B;
                if (b4 != null && (b || b4 != this.g)) {
                    this.O(Assertions.e(b4), formatHolder);
                    return -5;
                }
                return -3;
            }
            else {
                final Format a = this.c.e(this.C()).a;
                if (b || a != this.g) {
                    this.O(a, formatHolder);
                    return -5;
                }
                final int d = this.D(this.s);
                if (!this.M(d)) {
                    decoderInputBuffer.e = true;
                    return -3;
                }
                decoderInputBuffer.q(this.m[d]);
                final long f = this.n[d];
                decoderInputBuffer.f = f;
                if (f < this.t) {
                    decoderInputBuffer.g(Integer.MIN_VALUE);
                }
                b3.a = this.l[d];
                b3.b = this.k[d];
                b3.c = this.o[d];
                return -4;
            }
        }
    }
    
    private void U() {
        final DrmSession h = this.h;
        if (h != null) {
            h.c(this.e);
            this.h = null;
            this.g = null;
        }
    }
    
    private void X() {
        synchronized (this) {
            this.s = 0;
            this.a.o();
        }
    }
    
    private boolean c0(Format b) {
        synchronized (this) {
            this.y = false;
            if (Util.c(b, this.B)) {
                return false;
            }
            if (!this.c.g() && this.c.f().a.equals(b)) {
                this.B = this.c.f().a;
            }
            else {
                this.B = b;
            }
            b = this.B;
            this.D = MimeTypes.a(b.w, b.i);
            this.E = false;
            return true;
        }
    }
    
    public static void g(final c c) {
        L(c);
    }
    
    private boolean h(final long n) {
        synchronized (this) {
            final int p = this.p;
            boolean b = true;
            if (p == 0) {
                if (n <= this.u) {
                    b = false;
                }
                return b;
            }
            if (this.A() >= n) {
                return false;
            }
            this.t(this.q + this.j(n));
            return true;
        }
    }
    
    private void i(final long n, int g, final long n2, int i, final CryptoData cryptoData) {
        synchronized (this) {
            final int p5 = this.p;
            if (p5 > 0) {
                final int d = this.D(p5 - 1);
                Assertions.a(this.k[d] + this.l[d] <= n2);
            }
            this.w = ((0x20000000 & g) != 0x0);
            this.v = Math.max(this.v, n);
            final int d2 = this.D(this.p);
            this.n[d2] = n;
            this.k[d2] = n2;
            this.l[d2] = i;
            this.m[d2] = g;
            this.o[d2] = cryptoData;
            this.j[d2] = this.C;
            if (this.c.g() || !this.c.f().a.equals(this.B)) {
                final DrmSessionManager d3 = this.d;
                DrmSessionManager.DrmSessionReference drmSessionReference;
                if (d3 != null) {
                    drmSessionReference = d3.d(this.e, this.B);
                }
                else {
                    drmSessionReference = DrmSessionManager.DrmSessionReference.a;
                }
                final z<c> c = this.c;
                g = this.G();
                c.a(g, new c(Assertions.e(this.B), drmSessionReference, null));
            }
            g = this.p + 1;
            this.p = g;
            i = this.i;
            if (g == i) {
                g = i + 1000;
                final int[] j = new int[g];
                final long[] k = new long[g];
                final long[] n3 = new long[g];
                final int[] m = new int[g];
                final int[] l = new int[g];
                final CryptoData[] o = new CryptoData[g];
                final int r = this.r;
                i -= r;
                System.arraycopy(this.k, r, k, 0, i);
                System.arraycopy(this.n, this.r, n3, 0, i);
                System.arraycopy(this.m, this.r, m, 0, i);
                System.arraycopy(this.l, this.r, l, 0, i);
                System.arraycopy(this.o, this.r, o, 0, i);
                System.arraycopy(this.j, this.r, j, 0, i);
                final int r2 = this.r;
                System.arraycopy(this.k, 0, k, i, r2);
                System.arraycopy(this.n, 0, n3, i, r2);
                System.arraycopy(this.m, 0, m, i, r2);
                System.arraycopy(this.l, 0, l, i, r2);
                System.arraycopy(this.o, 0, o, i, r2);
                System.arraycopy(this.j, 0, j, i, r2);
                this.k = k;
                this.n = n3;
                this.m = m;
                this.l = l;
                this.o = o;
                this.j = j;
                this.r = 0;
                this.i = g;
            }
        }
    }
    
    private int j(final long n) {
        int p = this.p;
        int n2;
        for (int d = this.D(p - 1); p > this.s && this.n[d] >= n; d = this.i - 1, p = n2) {
            n2 = p - 1;
            final int n3 = d - 1;
            p = n2;
            if ((d = n3) == -1) {}
        }
        return p;
    }
    
    public static SampleQueue k(final Allocator allocator, final DrmSessionManager drmSessionManager, final DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, Assertions.e(drmSessionManager), Assertions.e(eventDispatcher));
    }
    
    public static SampleQueue l(final Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }
    
    private long m(long p3, final boolean b, final boolean b2) {
        synchronized (this) {
            final int p4 = this.p;
            if (p4 != 0) {
                final long[] n = this.n;
                final int r = this.r;
                if (p3 >= n[r]) {
                    int n2 = p4;
                    if (b2) {
                        final int s = this.s;
                        if (s != (n2 = p4)) {
                            n2 = s + 1;
                        }
                    }
                    final int v = this.v(r, n2, p3, b);
                    if (v == -1) {
                        return -1L;
                    }
                    p3 = this.p(v);
                    return p3;
                }
            }
            return -1L;
        }
    }
    
    private long n() {
        synchronized (this) {
            final int p = this.p;
            if (p == 0) {
                return -1L;
            }
            return this.p(p);
        }
    }
    
    private long p(int s) {
        this.u = Math.max(this.u, this.B(s));
        this.p -= s;
        final int q = this.q + s;
        this.q = q;
        final int r = this.r + s;
        this.r = r;
        final int i = this.i;
        if (r >= i) {
            this.r = r - i;
        }
        s = this.s - s;
        if ((this.s = s) < 0) {
            this.s = 0;
        }
        this.c.d(q);
        if (this.p == 0) {
            if ((s = this.r) == 0) {
                s = this.i;
            }
            --s;
            return this.k[s] + this.l[s];
        }
        return this.k[this.r];
    }
    
    private long t(int n) {
        final int n2 = this.G() - n;
        final boolean b = false;
        Assertions.a(n2 >= 0 && n2 <= this.p - this.s);
        final int p = this.p - n2;
        this.p = p;
        this.v = Math.max(this.u, this.B(p));
        boolean w = b;
        if (n2 == 0) {
            w = b;
            if (this.w) {
                w = true;
            }
        }
        this.w = w;
        this.c.c(n);
        n = this.p;
        if (n != 0) {
            n = this.D(n - 1);
            return this.k[n] + this.l[n];
        }
        return 0L;
    }
    
    private int v(int n, final int n2, final long n3, final boolean b) {
        int n4 = -1;
        final int n5 = 0;
        int n6 = n;
        n = n5;
        int n7;
        while (true) {
            n7 = n4;
            if (n >= n2) {
                break;
            }
            final long[] n8 = this.n;
            n7 = n4;
            if (n8[n6] > n3) {
                break;
            }
            if (!b || (this.m[n6] & 0x1) != 0x0) {
                if (n8[n6] == n3) {
                    n7 = n;
                    break;
                }
                n4 = n;
            }
            if (++n6 == this.i) {
                n6 = 0;
            }
            ++n;
        }
        return n7;
    }
    
    public final long A() {
        synchronized (this) {
            return Math.max(this.u, this.B(this.s));
        }
    }
    
    public final int C() {
        return this.q + this.s;
    }
    
    public final int E(final long n, final boolean b) {
        synchronized (this) {
            final int d = this.D(this.s);
            if (!this.H() || n < this.n[d]) {
                return 0;
            }
            if (n > this.v && b) {
                final int p2 = this.p;
                final int s = this.s;
                monitorexit(this);
                return p2 - s;
            }
            final int v = this.v(d, this.p - this.s, n, true);
            if (v == -1) {
                return 0;
            }
            return v;
        }
    }
    
    public final Format F() {
        synchronized (this) {
            Format b;
            if (this.y) {
                b = null;
            }
            else {
                b = this.B;
            }
            return b;
        }
    }
    
    public final int G() {
        return this.q + this.p;
    }
    
    protected final void I() {
        this.z = true;
    }
    
    public final boolean J() {
        synchronized (this) {
            return this.w;
        }
    }
    
    public boolean K(final boolean b) {
        synchronized (this) {
            final boolean h = this.H();
            final boolean b2 = true;
            if (!h) {
                boolean b3 = b2;
                if (!b) {
                    b3 = b2;
                    if (!this.w) {
                        final Format b4 = this.B;
                        b3 = (b4 != null && b4 != this.g && b2);
                    }
                }
                return b3;
            }
            return this.c.e(this.C()).a != this.g || this.M(this.D(this.s));
        }
    }
    
    public void N() throws IOException {
        final DrmSession h = this.h;
        if (h != null && h.getState() == 1) {
            throw (DrmSession.DrmSessionException)Assertions.e(this.h.a());
        }
    }
    
    public final int Q() {
        synchronized (this) {
            final int d = this.D(this.s);
            int c;
            if (this.H()) {
                c = this.j[d];
            }
            else {
                c = this.C;
            }
            return c;
        }
    }
    
    public void R() {
        this.r();
        this.U();
    }
    
    public int S(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n, final boolean b) {
        boolean b2 = false;
        final int p4 = this.P(formatHolder, decoderInputBuffer, (n & 0x2) != 0x0, b, this.b);
        if (p4 == -4 && !decoderInputBuffer.n()) {
            if ((n & 0x1) != 0x0) {
                b2 = true;
            }
            if ((n & 0x4) == 0x0) {
                if (b2) {
                    this.a.f(decoderInputBuffer, this.b);
                }
                else {
                    this.a.m(decoderInputBuffer, this.b);
                }
            }
            if (!b2) {
                ++this.s;
            }
        }
        return p4;
    }
    
    public void T() {
        this.W(true);
        this.U();
    }
    
    public final void V() {
        this.W(false);
    }
    
    public void W(final boolean b) {
        this.a.n();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.c.b();
        if (b) {
            this.A = null;
            this.B = null;
            this.y = true;
        }
    }
    
    public final boolean Y(final int n) {
        synchronized (this) {
            this.X();
            final int q = this.q;
            if (n >= q && n <= this.p + q) {
                this.t = Long.MIN_VALUE;
                this.s = n - q;
                return true;
            }
            return false;
        }
    }
    
    public final boolean Z(final long t, final boolean b) {
        synchronized (this) {
            this.X();
            final int d = this.D(this.s);
            if (!this.H() || t < this.n[d] || (t > this.v && !b)) {
                return false;
            }
            final int v = this.v(d, this.p - this.s, t, true);
            if (v == -1) {
                return false;
            }
            this.t = t;
            this.s += v;
            return true;
        }
    }
    
    @Override
    public final int a(final DataReader dataReader, final int n, final boolean b, final int n2) throws IOException {
        return this.a.p(dataReader, n, b);
    }
    
    public final void a0(final long f) {
        if (this.F != f) {
            this.F = f;
            this.I();
        }
    }
    
    public final void b0(final long t) {
        this.t = t;
    }
    
    @Override
    public final void d(final Format a) {
        final Format w = this.w(a);
        this.z = false;
        this.A = a;
        final boolean c0 = this.c0(w);
        final UpstreamFormatChangedListener f = this.f;
        if (f != null && c0) {
            f.a(w);
        }
    }
    
    public final void d0(final UpstreamFormatChangedListener f) {
        this.f = f;
    }
    
    @Override
    public void e(long n, int n2, final int n3, final int n4, final CryptoData cryptoData) {
        if (this.z) {
            this.d(Assertions.i(this.A));
        }
        final int n5 = n2 & 0x1;
        final boolean b = n5 != 0;
        if (this.x) {
            if (!b) {
                return;
            }
            this.x = false;
        }
        n += this.F;
        if (this.D) {
            if (n < this.t) {
                return;
            }
            if (n5 == 0) {
                if (!this.E) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Overriding unexpected non-sync sample for format: ");
                    sb.append(this.B);
                    Log.i("SampleQueue", sb.toString());
                    this.E = true;
                }
                n2 |= 0x1;
            }
        }
        if (this.G) {
            if (!b || !this.h(n)) {
                return;
            }
            this.G = false;
        }
        this.i(n, n2, this.a.e() - n3 - n4, n3, cryptoData);
    }
    
    public final void e0(final int n) {
        monitorenter(this);
        boolean b = false;
        Label_0030: {
            Label_0028: {
                if (n >= 0) {
                    Label_0047: {
                        try {
                            if (this.s + n <= this.p) {
                                b = true;
                                break Label_0030;
                            }
                        }
                        finally {
                            break Label_0047;
                        }
                        break Label_0028;
                    }
                    monitorexit(this);
                }
            }
            b = false;
        }
        Assertions.a(b);
        this.s += n;
        monitorexit(this);
    }
    
    @Override
    public final void f(final ParsableByteArray parsableByteArray, final int n, final int n2) {
        this.a.q(parsableByteArray, n);
    }
    
    public final void f0(final int c) {
        this.C = c;
    }
    
    public final void g0() {
        this.G = true;
    }
    
    public long o() {
        synchronized (this) {
            final int s = this.s;
            if (s == 0) {
                return -1L;
            }
            return this.p(s);
        }
    }
    
    public final void q(final long n, final boolean b, final boolean b2) {
        this.a.b(this.m(n, b, b2));
    }
    
    public final void r() {
        this.a.b(this.n());
    }
    
    public final void s() {
        this.a.b(this.o());
    }
    
    public final void u(final int n) {
        this.a.c(this.t(n));
    }
    
    protected Format w(final Format format) {
        Format e = format;
        if (this.F != 0L) {
            e = format;
            if (format.A != Long.MAX_VALUE) {
                e = format.b().i0(format.A + this.F).E();
            }
        }
        return e;
    }
    
    public final int x() {
        return this.q;
    }
    
    public final long y() {
        synchronized (this) {
            long n;
            if (this.p == 0) {
                n = Long.MIN_VALUE;
            }
            else {
                n = this.n[this.r];
            }
            return n;
        }
    }
    
    public final long z() {
        synchronized (this) {
            return this.v;
        }
    }
    
    public interface UpstreamFormatChangedListener
    {
        void a(final Format p0);
    }
    
    static final class b
    {
        public int a;
        public long b;
        public CryptoData c;
    }
    
    private static final class c
    {
        public final Format a;
        public final DrmSessionManager.DrmSessionReference b;
        
        private c(final Format a, final DrmSessionManager.DrmSessionReference b) {
            this.a = a;
            this.b = b;
        }
        
        c(final Format format, final DrmSessionManager.DrmSessionReference drmSessionReference, final SampleQueue$a object) {
            this(format, drmSessionReference);
        }
    }
}
