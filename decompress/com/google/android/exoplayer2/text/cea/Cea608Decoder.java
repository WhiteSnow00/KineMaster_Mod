// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.cea;

import android.text.Layout$Alignment;
import com.google.android.exoplayer2.util.Util;
import android.text.style.UnderlineSpan;
import android.text.style.StyleSpan;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableStringBuilder;
import android.text.SpannableString;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Cea608Decoder extends c
{
    private static final int[] A;
    private static final int[] B;
    private static final int[] C;
    private static final int[] D;
    private static final int[] E;
    private static final boolean[] F;
    private static final int[] y;
    private static final int[] z;
    private final ParsableByteArray g;
    private final int h;
    private final int i;
    private final int j;
    private final long k;
    private final ArrayList<a> l;
    private a m;
    private List<Cue> n;
    private List<Cue> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private byte t;
    private byte u;
    private int v;
    private boolean w;
    private long x;
    
    static {
        y = new int[] { 11, 1, 3, 12, 14, 5, 7, 9 };
        z = new int[] { 0, 4, 8, 12, 16, 20, 24, 28 };
        A = new int[] { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
        B = new int[] { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
        C = new int[] { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
        D = new int[] { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
        E = new int[] { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
        F = new boolean[] { false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false };
    }
    
    public Cea608Decoder(final String s, final int n, long k) {
        this.g = new ParsableByteArray();
        this.l = new ArrayList<a>();
        this.m = new a(0, 4);
        this.v = 0;
        if (k > 0L) {
            k *= 1000L;
        }
        else {
            k = -9223372036854775807L;
        }
        this.k = k;
        int h;
        if ("application/x-mp4-cea-608".equals(s)) {
            h = 2;
        }
        else {
            h = 3;
        }
        this.h = h;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        Log.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                        this.j = 0;
                        this.i = 0;
                    }
                    else {
                        this.j = 1;
                        this.i = 1;
                    }
                }
                else {
                    this.j = 0;
                    this.i = 1;
                }
            }
            else {
                this.j = 1;
                this.i = 0;
            }
        }
        else {
            this.j = 0;
            this.i = 0;
        }
        this.M(0);
        this.L();
        this.w = true;
        this.x = -9223372036854775807L;
    }
    
    private static boolean A(final byte b, final byte b2) {
        return (b & 0xF6) == 0x12 && (b2 & 0xE0) == 0x20;
    }
    
    private static boolean B(final byte b, final byte b2) {
        return (b & 0xF7) == 0x11 && (b2 & 0xF0) == 0x20;
    }
    
    private static boolean C(final byte b, final byte b2) {
        return (b & 0xF6) == 0x14 && (b2 & 0xF0) == 0x20;
    }
    
    private static boolean D(final byte b, final byte b2) {
        return (b & 0xF0) == 0x10 && (b2 & 0xC0) == 0x40;
    }
    
    private static boolean E(final byte b) {
        return (b & 0xF0) == 0x10;
    }
    
    private boolean F(final boolean b, final byte t, final byte u) {
        if (b && E(t)) {
            if (this.s && this.t == t && this.u == u) {
                this.s = false;
                return true;
            }
            this.s = true;
            this.t = t;
            this.u = u;
        }
        else {
            this.s = false;
        }
        return false;
    }
    
    private static boolean G(final byte b) {
        return (b & 0xF7) == 0x14;
    }
    
    private static boolean H(final byte b, final byte b2) {
        return (b & 0xF7) == 0x11 && (b2 & 0xF0) == 0x30;
    }
    
    private static boolean I(final byte b, final byte b2) {
        return (b & 0xF7) == 0x17 && b2 >= 33 && b2 <= 35;
    }
    
    private static boolean J(final byte b) {
        boolean b2 = true;
        if (1 > b || b > 15) {
            b2 = false;
        }
        return b2;
    }
    
    private void K(final byte b, final byte b2) {
        if (J(b)) {
            this.w = false;
        }
        else if (G(b)) {
            Label_0099: {
                if (b2 != 32 && b2 != 47) {
                    switch (b2) {
                        default: {
                            switch (b2) {
                                default: {
                                    return;
                                }
                                case 42:
                                case 43: {
                                    this.w = false;
                                    return;
                                }
                                case 41: {
                                    break Label_0099;
                                }
                            }
                            break;
                        }
                        case 37:
                        case 38:
                        case 39: {
                            break;
                        }
                    }
                }
            }
            this.w = true;
        }
    }
    
    private void L() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }
    
    private void M(final int p) {
        final int p2 = this.p;
        if (p2 == p) {
            return;
        }
        if ((this.p = p) == 3) {
            for (int i = 0; i < this.l.size(); ++i) {
                this.l.get(i).l(p);
            }
            return;
        }
        this.L();
        if (p2 == 3 || p == 1 || p == 0) {
            this.n = Collections.emptyList();
        }
    }
    
    private void N(final int q) {
        this.q = q;
        this.m.m(q);
    }
    
    private boolean O() {
        final long k = this.k;
        boolean b2;
        final boolean b = b2 = false;
        if (k != -9223372036854775807L) {
            if (this.x == -9223372036854775807L) {
                b2 = b;
            }
            else {
                b2 = b;
                if (this.j() - this.x >= this.k) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    private boolean P(final byte b) {
        if (z(b)) {
            this.v = q(b);
        }
        return this.v == this.j;
    }
    
    static int[] o() {
        return Cea608Decoder.A;
    }
    
    private static char p(final byte b) {
        return (char)Cea608Decoder.B[(b & 0x7F) - 32];
    }
    
    private static int q(final byte b) {
        return b >> 3 & 0x1;
    }
    
    private List<Cue> r() {
        final int size = this.l.size();
        final ArrayList list = new ArrayList(size);
        final int n = 0;
        int n2 = 2;
        int min;
        for (int i = 0; i < size; ++i, n2 = min) {
            final Cue g = this.l.get(i).g(Integer.MIN_VALUE);
            list.add((Object)g);
            min = n2;
            if (g != null) {
                min = Math.min(n2, g.i);
            }
        }
        final ArrayList list2 = new ArrayList(size);
        for (int j = n; j < size; ++j) {
            final Cue cue = (Cue)list.get(j);
            if (cue != null) {
                Cue cue2 = cue;
                if (cue.i != n2) {
                    cue2 = Assertions.e(this.l.get(j).g(n2));
                }
                list2.add((Object)cue2);
            }
        }
        return (List<Cue>)list2;
    }
    
    private static char s(final byte b) {
        return (char)Cea608Decoder.D[b & 0x1F];
    }
    
    private static char t(final byte b) {
        return (char)Cea608Decoder.E[b & 0x1F];
    }
    
    private static char u(final byte b, final byte b2) {
        if ((b & 0x1) == 0x0) {
            return s(b2);
        }
        return t(b2);
    }
    
    private static char v(final byte b) {
        return (char)Cea608Decoder.C[b & 0xF];
    }
    
    private void w(final byte b) {
        this.m.e(' ');
        this.m.p(b >> 1 & 0x7, (b & 0x1) == 0x1);
    }
    
    private void x(final byte b) {
        if (b == 32) {
            this.M(2);
            return;
        }
        if (b == 41) {
            this.M(3);
            return;
        }
        switch (b) {
            default: {
                final int p = this.p;
                if (p == 0) {
                    return;
                }
                if (b != 33) {
                    switch (b) {
                        case 47: {
                            this.n = this.r();
                            this.L();
                            break;
                        }
                        case 46: {
                            this.L();
                            break;
                        }
                        case 45: {
                            if (p == 1 && !this.m.i()) {
                                this.m.k();
                                break;
                            }
                            break;
                        }
                        case 44: {
                            this.n = Collections.emptyList();
                            final int p2 = this.p;
                            if (p2 == 1 || p2 == 3) {
                                this.L();
                                break;
                            }
                            break;
                        }
                    }
                }
                else {
                    this.m.f();
                }
                return;
            }
            case 39: {
                this.M(1);
                this.N(4);
                return;
            }
            case 38: {
                this.M(1);
                this.N(3);
                return;
            }
            case 37: {
                this.M(1);
                this.N(2);
            }
        }
    }
    
    private void y(final byte b, final byte b2) {
        final int n = Cea608Decoder.y[b & 0x7];
        boolean b3 = false;
        final boolean b4 = (b2 & 0x20) != 0x0;
        int n2 = n;
        if (b4) {
            n2 = n + 1;
        }
        if (n2 != a.b(this.m)) {
            if (this.p != 1 && !this.m.i()) {
                final a m = new a(this.p, this.q);
                this.m = m;
                this.l.add(m);
            }
            a.c(this.m, n2);
        }
        final boolean b5 = (b2 & 0x10) == 0x10;
        if ((b2 & 0x1) == 0x1) {
            b3 = true;
        }
        final int n3 = b2 >> 1 & 0x7;
        final a i = this.m;
        int n4;
        if (b5) {
            n4 = 8;
        }
        else {
            n4 = n3;
        }
        i.p(n4, b3);
        if (b5) {
            a.d(this.m, Cea608Decoder.z[n3]);
        }
    }
    
    private static boolean z(final byte b) {
        return (b & 0xE0) == 0x0;
    }
    
    @Override
    public /* bridge */ void a(final long n) {
        super.a(n);
    }
    
    @Override
    public /* bridge */ Object b() throws DecoderException {
        return this.h();
    }
    
    @Override
    protected Subtitle e() {
        final List<Cue> n = this.n;
        this.o = n;
        return new d(Assertions.e(n));
    }
    
    @Override
    protected void f(final SubtitleInputBuffer subtitleInputBuffer) {
        final ByteBuffer byteBuffer = Assertions.e(subtitleInputBuffer.d);
        this.g.N(byteBuffer.array(), byteBuffer.limit());
        boolean b = false;
        while (true) {
            final int a = this.g.a();
            final int h = this.h;
            if (a < h) {
                break;
            }
            int n;
            if (h == 2) {
                n = -4;
            }
            else {
                n = (byte)this.g.D();
            }
            final int d = this.g.D();
            final int d2 = this.g.D();
            if ((n & 0x2) != 0x0) {
                continue;
            }
            if ((n & 0x1) != this.i) {
                continue;
            }
            final byte b2 = (byte)(d & 0x7F);
            final byte b3 = (byte)(d2 & 0x7F);
            if (b2 == 0 && b3 == 0) {
                continue;
            }
            final boolean r = this.r;
            boolean r2 = false;
            Label_0182: {
                if ((n & 0x4) == 0x4) {
                    final boolean[] f = Cea608Decoder.F;
                    if (f[d] && f[d2]) {
                        r2 = true;
                        break Label_0182;
                    }
                }
                r2 = false;
            }
            this.r = r2;
            if (this.F(r2, b2, b3)) {
                continue;
            }
            if (!this.r) {
                if (!r) {
                    continue;
                }
                this.L();
            }
            else {
                this.K(b2, b3);
                if (!this.w) {
                    continue;
                }
                if (!this.P(b2)) {
                    continue;
                }
                if (z(b2)) {
                    if (H(b2, b3)) {
                        this.m.e(v(b3));
                    }
                    else if (A(b2, b3)) {
                        this.m.f();
                        this.m.e(u(b2, b3));
                    }
                    else if (B(b2, b3)) {
                        this.w(b3);
                    }
                    else if (D(b2, b3)) {
                        this.y(b2, b3);
                    }
                    else if (I(b2, b3)) {
                        Cea608Decoder.a.a(this.m, b3 - 32);
                    }
                    else if (C(b2, b3)) {
                        this.x(b3);
                    }
                }
                else {
                    this.m.e(p(b2));
                    if ((b3 & 0xE0) != 0x0) {
                        this.m.e(p(b3));
                    }
                }
            }
            b = true;
        }
        if (b) {
            final int p = this.p;
            if (p == 1 || p == 3) {
                this.n = this.r();
                this.x = this.j();
            }
        }
    }
    
    @Override
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        this.M(0);
        this.N(4);
        this.L();
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }
    
    @Override
    public /* bridge */ SubtitleInputBuffer g() throws SubtitleDecoderException {
        return super.g();
    }
    
    @Override
    public String getName() {
        return "Cea608Decoder";
    }
    
    @Override
    public SubtitleOutputBuffer h() throws SubtitleDecoderException {
        final SubtitleOutputBuffer h = super.h();
        if (h != null) {
            return h;
        }
        if (this.O()) {
            final SubtitleOutputBuffer i = this.i();
            if (i != null) {
                this.n = Collections.emptyList();
                this.x = -9223372036854775807L;
                i.s(this.j(), this.e(), Long.MAX_VALUE);
                return i;
            }
        }
        return null;
    }
    
    @Override
    protected boolean k() {
        return this.n != this.o;
    }
    
    @Override
    public /* bridge */ void l(final SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.l(subtitleInputBuffer);
    }
    
    @Override
    public void release() {
    }
    
    private static final class a
    {
        private final List<Cea608Decoder.a.a> a;
        private final List<SpannableString> b;
        private final StringBuilder c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        
        public a(final int n, final int h) {
            this.a = new ArrayList<Cea608Decoder.a.a>();
            this.b = new ArrayList<SpannableString>();
            this.c = new StringBuilder();
            this.j(n);
            this.h = h;
        }
        
        static int a(final Cea608Decoder.a a, final int f) {
            return a.f = f;
        }
        
        static int b(final Cea608Decoder.a a) {
            return a.d;
        }
        
        static int c(final Cea608Decoder.a a, final int d) {
            return a.d = d;
        }
        
        static int d(final Cea608Decoder.a a, final int e) {
            return a.e = e;
        }
        
        private SpannableString h() {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)this.c);
            final int length = spannableStringBuilder.length();
            int i = 0;
            int n2;
            int n = n2 = 0;
            int n3 = -1;
            int n4 = -1;
            int n6;
            int n5 = n6 = n4;
            while (i < this.a.size()) {
                final Cea608Decoder.a.a a = this.a.get(i);
                final boolean b = a.b;
                final int a2 = a.a;
                int n7 = n5;
                int n8 = n2;
                if (a2 != 8) {
                    int n9;
                    if (a2 == 7) {
                        n9 = 1;
                    }
                    else {
                        n9 = 0;
                    }
                    if (a2 != 7) {
                        n5 = Cea608Decoder.o()[a2];
                    }
                    n8 = n9;
                    n7 = n5;
                }
                final int c = a.c;
                final int n10 = i + 1;
                int c2;
                if (n10 < this.a.size()) {
                    c2 = this.a.get(n10).c;
                }
                else {
                    c2 = length;
                }
                if (c == c2) {
                    i = n10;
                    n5 = n7;
                    n2 = n8;
                }
                else {
                    int n11;
                    if (n3 != -1 && !b) {
                        q(spannableStringBuilder, n3, c);
                        n11 = -1;
                    }
                    else if ((n11 = n3) == -1) {
                        n11 = n3;
                        if (b) {
                            n11 = c;
                        }
                    }
                    int n12;
                    if (n4 != -1 && n8 == 0) {
                        o(spannableStringBuilder, n4, c);
                        n12 = -1;
                    }
                    else if ((n12 = n4) == -1) {
                        n12 = n4;
                        if (n8 != 0) {
                            n12 = c;
                        }
                    }
                    i = n10;
                    n3 = n11;
                    n4 = n12;
                    n5 = n7;
                    n2 = n8;
                    if (n7 == n6) {
                        continue;
                    }
                    n(spannableStringBuilder, n, c, n6);
                    n6 = n7;
                    i = n10;
                    n3 = n11;
                    n4 = n12;
                    n = c;
                    n5 = n7;
                    n2 = n8;
                }
            }
            if (n3 != -1 && n3 != length) {
                q(spannableStringBuilder, n3, length);
            }
            if (n4 != -1 && n4 != length) {
                o(spannableStringBuilder, n4, length);
            }
            if (n != length) {
                n(spannableStringBuilder, n, length, n6);
            }
            return new SpannableString((CharSequence)spannableStringBuilder);
        }
        
        private static void n(final SpannableStringBuilder spannableStringBuilder, final int n, final int n2, final int n3) {
            if (n3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan((Object)new ForegroundColorSpan(n3), n, n2, 33);
        }
        
        private static void o(final SpannableStringBuilder spannableStringBuilder, final int n, final int n2) {
            spannableStringBuilder.setSpan((Object)new StyleSpan(2), n, n2, 33);
        }
        
        private static void q(final SpannableStringBuilder spannableStringBuilder, final int n, final int n2) {
            spannableStringBuilder.setSpan((Object)new UnderlineSpan(), n, n2, 33);
        }
        
        public void e(final char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }
        
        public void f() {
            final int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int i = this.a.size() - 1; i >= 0; --i) {
                    final Cea608Decoder.a.a a = this.a.get(i);
                    final int c = a.c;
                    if (c != length) {
                        break;
                    }
                    a.c = c - 1;
                }
            }
        }
        
        public Cue g(int n) {
            final int n2 = this.e + this.f;
            final int n3 = 32 - n2;
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.b.size(); ++i) {
                spannableStringBuilder.append(Util.d1((CharSequence)this.b.get(i), n3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(Util.d1((CharSequence)this.h(), n3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            final int n4 = n3 - spannableStringBuilder.length();
            final int n5 = n2 - n4;
            if (n == Integer.MIN_VALUE) {
                if (this.g == 2 && (Math.abs(n5) < 3 || n4 < 0)) {
                    n = 1;
                }
                else if (this.g == 2 && n5 > 0) {
                    n = 2;
                }
                else {
                    n = 0;
                }
            }
            float n7;
            if (n != 1) {
                int n6;
                if (n != 2) {
                    n6 = n2;
                }
                else {
                    n6 = 32 - n4;
                }
                n7 = n6 / 32.0f * 0.8f + 0.1f;
            }
            else {
                n7 = 0.5f;
            }
            final int d = this.d;
            int n8;
            if (d > 7) {
                n8 = d - 15 - 2;
            }
            else {
                n8 = d;
                if (this.g == 1) {
                    n8 = d - (this.h - 1);
                }
            }
            return new Cue.Builder().o((CharSequence)spannableStringBuilder).p(Layout$Alignment.ALIGN_NORMAL).h((float)n8, 1).k(n7).l(n).a();
        }
        
        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }
        
        public void j(final int g) {
            this.g = g;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }
        
        public void k() {
            this.b.add(this.h());
            this.c.setLength(0);
            this.a.clear();
            while (this.b.size() >= Math.min(this.h, this.d)) {
                this.b.remove(0);
            }
        }
        
        public void l(final int g) {
            this.g = g;
        }
        
        public void m(final int h) {
            this.h = h;
        }
        
        public void p(final int n, final boolean b) {
            this.a.add(new Cea608Decoder.a.a(n, b, this.c.length()));
        }
        
        private static class a
        {
            public final int a;
            public final boolean b;
            public int c;
            
            public a(final int a, final boolean b, final int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }
    }
}
