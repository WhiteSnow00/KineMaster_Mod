// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.cea;

import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.text.style.StyleSpan;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannableString;
import android.text.Layout$Alignment;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Cea708Decoder extends com.google.android.exoplayer2.text.cea.c
{
    private final ParsableByteArray g;
    private final ParsableBitArray h;
    private int i;
    private final boolean j;
    private final int k;
    private final b[] l;
    private b m;
    private List<Cue> n;
    private List<Cue> o;
    private c p;
    private int q;
    
    public Cea708Decoder(int i, final List<byte[]> list) {
        this.g = new ParsableByteArray();
        this.h = new ParsableBitArray();
        this.i = -1;
        boolean j = true;
        int k = i;
        if (i == -1) {
            k = 1;
        }
        this.k = k;
        if (list == null || !CodecSpecificDataUtil.i(list)) {
            j = false;
        }
        this.j = j;
        this.l = new b[8];
        for (i = 0; i < 8; ++i) {
            this.l[i] = new b();
        }
        this.m = this.l[0];
    }
    
    private void A() {
        final int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        final int h2 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        this.h.r(2);
        this.m.n(h, h2, b.g(this.h.h(2), this.h.h(2), this.h.h(2)));
    }
    
    private void B() {
        this.h.r(4);
        final int h = this.h.h(4);
        this.h.r(2);
        this.m.o(h, this.h.h(6));
    }
    
    private void C() {
        final int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        final int h2 = this.h.h(2);
        final int g = b.g(this.h.h(2), this.h.h(2), this.h.h(2));
        int n = h2;
        if (this.h.g()) {
            n = (h2 | 0x4);
        }
        final boolean g2 = this.h.g();
        final int h3 = this.h.h(2);
        final int h4 = this.h.h(2);
        final int h5 = this.h.h(2);
        this.h.r(8);
        this.m.q(h, g, g2, n, h3, h4, h5);
    }
    
    private void D() {
        final c p = this.p;
        if (p.d != p.b * 2 - 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("DtvCcPacket ended prematurely; size is ");
            sb.append(this.p.b * 2 - 1);
            sb.append(", but current index is ");
            sb.append(this.p.d);
            sb.append(" (sequence number ");
            sb.append(this.p.a);
            sb.append(");");
            Log.b("Cea708Decoder", sb.toString());
        }
        int n = 0;
        final ParsableBitArray h = this.h;
        final c p2 = this.p;
        h.o(p2.c, p2.d);
        while (this.h.b() > 0) {
            final int h2 = this.h.h(3);
            final int h3 = this.h.h(5);
            int n2;
            if ((n2 = h2) == 7) {
                this.h.r(2);
                final int h4 = this.h.h(6);
                if ((n2 = h4) < 7) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid extended service number: ");
                    sb2.append(h4);
                    Log.i("Cea708Decoder", sb2.toString());
                    n2 = h4;
                }
            }
            if (h3 == 0) {
                if (n2 != 0) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("serviceNumber is non-zero (");
                    sb3.append(n2);
                    sb3.append(") when blockSize is 0");
                    Log.i("Cea708Decoder", sb3.toString());
                    break;
                }
                break;
            }
            else if (n2 != this.k) {
                this.h.s(h3);
            }
            else {
                final int e = this.h.e();
                int n3 = n;
                while (true) {
                    n = n3;
                    if (this.h.e() >= e + h3 * 8) {
                        break;
                    }
                    final int h5 = this.h.h(8);
                    if (h5 != 16) {
                        if (h5 <= 31) {
                            this.q(h5);
                            continue;
                        }
                        if (h5 <= 127) {
                            this.v(h5);
                        }
                        else if (h5 <= 159) {
                            this.r(h5);
                        }
                        else {
                            if (h5 > 255) {
                                final StringBuilder sb4 = new StringBuilder();
                                sb4.append("Invalid base command: ");
                                sb4.append(h5);
                                Log.i("Cea708Decoder", sb4.toString());
                                continue;
                            }
                            this.w(h5);
                        }
                    }
                    else {
                        final int h6 = this.h.h(8);
                        if (h6 <= 31) {
                            this.s(h6);
                            continue;
                        }
                        if (h6 <= 127) {
                            this.x(h6);
                        }
                        else {
                            if (h6 <= 159) {
                                this.t(h6);
                                continue;
                            }
                            if (h6 > 255) {
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("Invalid extended command: ");
                                sb5.append(h6);
                                Log.i("Cea708Decoder", sb5.toString());
                                continue;
                            }
                            this.y(h6);
                        }
                    }
                    n3 = 1;
                }
            }
        }
        if (n != 0) {
            this.n = this.p();
        }
    }
    
    private void E() {
        for (int i = 0; i < 8; ++i) {
            this.l[i].l();
        }
    }
    
    private void o() {
        if (this.p == null) {
            return;
        }
        this.D();
        this.p = null;
    }
    
    private List<Cue> p() {
        final ArrayList list = new ArrayList();
        final int n = 0;
        for (int i = 0; i < 8; ++i) {
            if (!this.l[i].j() && this.l[i].k()) {
                final a c = this.l[i].c();
                if (c != null) {
                    list.add(c);
                }
            }
        }
        Collections.sort((List<Object>)list, a.b());
        final ArrayList list2 = new ArrayList(list.size());
        for (int j = n; j < list.size(); ++j) {
            list2.add((Object)((a)list.get(j)).a);
        }
        return Collections.unmodifiableList((List<? extends Cue>)list2);
    }
    
    private void q(final int n) {
        if (n != 0) {
            if (n != 3) {
                if (n != 8) {
                    switch (n) {
                        default: {
                            if (n >= 17 && n <= 23) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Currently unsupported COMMAND_EXT1 Command: ");
                                sb.append(n);
                                Log.i("Cea708Decoder", sb.toString());
                                this.h.r(8);
                                break;
                            }
                            if (n >= 24 && n <= 31) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("Currently unsupported COMMAND_P16 Command: ");
                                sb2.append(n);
                                Log.i("Cea708Decoder", sb2.toString());
                                this.h.r(16);
                                break;
                            }
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Invalid C0 command: ");
                            sb3.append(n);
                            Log.i("Cea708Decoder", sb3.toString());
                            break;
                        }
                        case 14: {
                            break;
                        }
                        case 13: {
                            this.m.a('\n');
                            break;
                        }
                        case 12: {
                            this.E();
                            break;
                        }
                    }
                }
                else {
                    this.m.b();
                }
            }
            else {
                this.n = this.p();
            }
        }
    }
    
    private void r(int i) {
        int j = 1;
        int k = 1;
        int l = 1;
        switch (i) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid C1 command: ");
                sb.append(i);
                Log.i("Cea708Decoder", sb.toString());
                return;
            }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159: {
                i -= 152;
                this.u(i);
                if (this.q != i) {
                    this.q = i;
                    this.m = this.l[i];
                }
                return;
            }
            case 151: {
                if (!this.m.i()) {
                    this.h.r(32);
                    return;
                }
                this.C();
                return;
            }
            case 146: {
                if (!this.m.i()) {
                    this.h.r(16);
                    return;
                }
                this.B();
                return;
            }
            case 145: {
                if (!this.m.i()) {
                    this.h.r(24);
                    return;
                }
                this.A();
                return;
            }
            case 144: {
                if (!this.m.i()) {
                    this.h.r(16);
                    return;
                }
                this.z();
                return;
            }
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135: {
                i -= 128;
                if (this.q != i) {
                    this.q = i;
                    this.m = this.l[i];
                }
                return;
            }
            case 142: {
                return;
            }
            case 143: {
                this.E();
                return;
            }
            case 141: {
                this.h.r(8);
                return;
            }
            case 140: {
                while (l <= 8) {
                    if (this.h.g()) {
                        this.l[8 - l].l();
                    }
                    ++l;
                }
                return;
            }
            case 139: {
                b b;
                for (i = 1; i <= 8; ++i) {
                    if (this.h.g()) {
                        b = this.l[8 - i];
                        b.p(b.k() ^ true);
                    }
                }
                return;
            }
            case 138: {
                while (j <= 8) {
                    if (this.h.g()) {
                        this.l[8 - j].p(false);
                    }
                    ++j;
                }
                return;
            }
            case 137: {
                for (i = 1; i <= 8; ++i) {
                    if (this.h.g()) {
                        this.l[8 - i].p(true);
                    }
                }
                return;
            }
            case 136: {
                while (k <= 8) {
                    if (this.h.g()) {
                        this.l[8 - k].e();
                    }
                    ++k;
                }
            }
        }
    }
    
    private void s(final int n) {
        if (n > 7) {
            if (n <= 15) {
                this.h.r(8);
            }
            else if (n <= 23) {
                this.h.r(16);
            }
            else if (n <= 31) {
                this.h.r(24);
            }
        }
    }
    
    private void t(int h) {
        if (h <= 135) {
            this.h.r(32);
        }
        else if (h <= 143) {
            this.h.r(40);
        }
        else if (h <= 159) {
            this.h.r(2);
            h = this.h.h(6);
            this.h.r(h * 8);
        }
    }
    
    private void u(int h) {
        final b b = this.l[h];
        this.h.r(2);
        final boolean g = this.h.g();
        final boolean g2 = this.h.g();
        final boolean g3 = this.h.g();
        final int h2 = this.h.h(3);
        final boolean g4 = this.h.g();
        final int h3 = this.h.h(7);
        final int h4 = this.h.h(8);
        h = this.h.h(4);
        final int h5 = this.h.h(4);
        this.h.r(2);
        final int h6 = this.h.h(6);
        this.h.r(2);
        b.f(g, g2, g3, h2, g4, h3, h4, h5, h6, h, this.h.h(3), this.h.h(3));
    }
    
    private void v(final int n) {
        if (n == 127) {
            this.m.a('\u266b');
        }
        else {
            this.m.a((char)(n & 0xFF));
        }
    }
    
    private void w(final int n) {
        this.m.a((char)(n & 0xFF));
    }
    
    private void x(final int n) {
        Label_0524: {
            if (n != 32) {
                if (n != 33) {
                    if (n != 37) {
                        if (n != 42) {
                            if (n != 44) {
                                if (n != 63) {
                                    if (n != 57) {
                                        if (n != 58) {
                                            if (n != 60) {
                                                if (n != 61) {
                                                    switch (n) {
                                                        default: {
                                                            switch (n) {
                                                                default: {
                                                                    final StringBuilder sb = new StringBuilder();
                                                                    sb.append("Invalid G2 character: ");
                                                                    sb.append(n);
                                                                    Log.i("Cea708Decoder", sb.toString());
                                                                    break Label_0524;
                                                                }
                                                                case 127: {
                                                                    this.m.a('\u250c');
                                                                    break Label_0524;
                                                                }
                                                                case 126: {
                                                                    this.m.a('\u2518');
                                                                    break Label_0524;
                                                                }
                                                                case 125: {
                                                                    this.m.a('\u2500');
                                                                    break Label_0524;
                                                                }
                                                                case 124: {
                                                                    this.m.a('\u2514');
                                                                    break Label_0524;
                                                                }
                                                                case 123: {
                                                                    this.m.a('\u2510');
                                                                    break Label_0524;
                                                                }
                                                                case 122: {
                                                                    this.m.a('\u2502');
                                                                    break Label_0524;
                                                                }
                                                                case 121: {
                                                                    this.m.a('\u215e');
                                                                    break Label_0524;
                                                                }
                                                                case 120: {
                                                                    this.m.a('\u215d');
                                                                    break Label_0524;
                                                                }
                                                                case 119: {
                                                                    this.m.a('\u215c');
                                                                    break Label_0524;
                                                                }
                                                                case 118: {
                                                                    this.m.a('\u215b');
                                                                    break Label_0524;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        case 53: {
                                                            this.m.a('\u2022');
                                                            break;
                                                        }
                                                        case 52: {
                                                            this.m.a('\u201d');
                                                            break;
                                                        }
                                                        case 51: {
                                                            this.m.a('\u201c');
                                                            break;
                                                        }
                                                        case 50: {
                                                            this.m.a('\u2019');
                                                            break;
                                                        }
                                                        case 49: {
                                                            this.m.a('\u2018');
                                                            break;
                                                        }
                                                        case 48: {
                                                            this.m.a('\u2588');
                                                            break;
                                                        }
                                                    }
                                                }
                                                else {
                                                    this.m.a('\u2120');
                                                }
                                            }
                                            else {
                                                this.m.a('\u0153');
                                            }
                                        }
                                        else {
                                            this.m.a('\u0161');
                                        }
                                    }
                                    else {
                                        this.m.a('\u2122');
                                    }
                                }
                                else {
                                    this.m.a('\u0178');
                                }
                            }
                            else {
                                this.m.a('\u0152');
                            }
                        }
                        else {
                            this.m.a('\u0160');
                        }
                    }
                    else {
                        this.m.a('\u2026');
                    }
                }
                else {
                    this.m.a(' ');
                }
            }
            else {
                this.m.a(' ');
            }
        }
    }
    
    private void y(final int n) {
        if (n == 160) {
            this.m.a('\u33c4');
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid G3 character: ");
            sb.append(n);
            Log.i("Cea708Decoder", sb.toString());
            this.m.a('_');
        }
    }
    
    private void z() {
        this.m.m(this.h.h(4), this.h.h(2), this.h.h(2), this.h.g(), this.h.g(), this.h.h(3), this.h.h(3));
    }
    
    @Override
    public /* bridge */ void a(final long n) {
        super.a(n);
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
        while (this.g.a() >= 3) {
            final int n = this.g.D() & 0x7;
            final int n2 = n & 0x3;
            boolean b = false;
            final boolean b2 = (n & 0x4) == 0x4;
            final byte b3 = (byte)this.g.D();
            final byte b4 = (byte)this.g.D();
            if (n2 != 2 && n2 != 3) {
                continue;
            }
            if (!b2) {
                continue;
            }
            if (n2 == 3) {
                this.o();
                final int i = (b3 & 0xC0) >> 6;
                final int j = this.i;
                if (j != -1 && i != (j + 1) % 4) {
                    this.E();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Sequence number discontinuity. previous=");
                    sb.append(this.i);
                    sb.append(" current=");
                    sb.append(i);
                    Log.i("Cea708Decoder", sb.toString());
                }
                this.i = i;
                int n3;
                if ((n3 = (b3 & 0x3F)) == 0) {
                    n3 = 64;
                }
                final c p = new c(i, n3);
                this.p = p;
                p.c[p.d++] = b4;
            }
            else {
                if (n2 == 2) {
                    b = true;
                }
                Assertions.a(b);
                final c p2 = this.p;
                if (p2 == null) {
                    Log.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    continue;
                }
                final byte[] c = p2.c;
                final int d = p2.d;
                final int d2 = d + 1;
                p2.d = d2;
                c[d] = b3;
                p2.d = d2 + 1;
                c[d2] = b4;
            }
            final c p3 = this.p;
            if (p3.d != p3.b * 2 - 1) {
                continue;
            }
            this.o();
        }
    }
    
    @Override
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        this.q = 0;
        this.m = this.l[0];
        this.E();
        this.p = null;
    }
    
    @Override
    public /* bridge */ SubtitleInputBuffer g() throws SubtitleDecoderException {
        return super.g();
    }
    
    @Override
    public String getName() {
        return "Cea708Decoder";
    }
    
    @Override
    public /* bridge */ SubtitleOutputBuffer h() throws SubtitleDecoderException {
        return super.h();
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
    public /* bridge */ void release() {
        super.release();
    }
    
    private static final class a
    {
        private static final Comparator<a> c;
        public final Cue a;
        public final int b;
        
        static {
            c = com.google.android.exoplayer2.text.cea.a.a;
        }
        
        public a(final CharSequence charSequence, final Layout$Alignment layout$Alignment, final float n, final int n2, final int n3, final float n4, final int n5, final float n6, final boolean b, final int n7, final int b2) {
            final Cue.Builder n8 = new Cue.Builder().o(charSequence).p(layout$Alignment).h(n, n2).i(n3).k(n4).l(n5).n(n6);
            if (b) {
                n8.s(n7);
            }
            this.a = n8.a();
            this.b = b2;
        }
        
        public static int a(final a a, final a a2) {
            return c(a, a2);
        }
        
        static Comparator b() {
            return a.c;
        }
        
        private static int c(final a a, final a a2) {
            return Integer.compare(a2.b, a.b);
        }
    }
    
    private static final class b
    {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;
        public static final int w;
        public static final int x;
        public static final int y;
        private static final int[] z;
        private final List<SpannableString> a;
        private final SpannableStringBuilder b;
        private boolean c;
        private boolean d;
        private int e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;
        
        static {
            w = h(2, 2, 2, 0);
            final int n = x = h(0, 0, 0, 0);
            final int n2 = y = h(0, 0, 0, 3);
            z = new int[] { 0, 0, 0, 0, 0, 2, 0 };
            A = new int[] { 0, 0, 0, 0, 0, 0, 2 };
            B = new int[] { 3, 3, 3, 3, 3, 3, 1 };
            C = new boolean[] { false, false, false, true, true, true, false };
            D = new int[] { n, n2, n, n, n2, n, n };
            E = new int[] { 0, 1, 2, 3, 4, 3, 4 };
            F = new int[] { 0, 0, 0, 0, 0, 3, 3 };
            G = new int[] { n, n, n, n, n, n2, n2 };
        }
        
        public b() {
            this.a = new ArrayList<SpannableString>();
            this.b = new SpannableStringBuilder();
            this.l();
        }
        
        public static int g(final int n, final int n2, final int n3) {
            return h(n, n2, n3, 0);
        }
        
        public static int h(int n, int n2, final int n3, int n4) {
            int n5 = 0;
            Assertions.c(n, 0, 4);
            Assertions.c(n2, 0, 4);
            Assertions.c(n3, 0, 4);
            Assertions.c(n4, 0, 4);
            Label_0068: {
                if (n4 != 0 && n4 != 1) {
                    if (n4 == 2) {
                        n4 = 127;
                        break Label_0068;
                    }
                    if (n4 == 3) {
                        n4 = 0;
                        break Label_0068;
                    }
                }
                n4 = 255;
            }
            if (n > 1) {
                n = 255;
            }
            else {
                n = 0;
            }
            if (n2 > 1) {
                n2 = 255;
            }
            else {
                n2 = 0;
            }
            if (n3 > 1) {
                n5 = 255;
            }
            return Color.argb(n4, n, n2, n5);
        }
        
        public void a(final char c) {
            if (c == '\n') {
                this.a.add(this.d());
                this.b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while ((this.k && this.a.size() >= this.j) || this.a.size() >= 15) {
                    this.a.remove(0);
                }
            }
            else {
                this.b.append(c);
            }
        }
        
        public void b() {
            final int length = this.b.length();
            if (length > 0) {
                this.b.delete(length - 1, length);
            }
        }
        
        public a c() {
            if (this.j()) {
                return null;
            }
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean b = false;
            for (int i = 0; i < this.a.size(); ++i) {
                spannableStringBuilder.append((CharSequence)this.a.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence)this.d());
            final int l = this.l;
            Layout$Alignment layout$Alignment = null;
            Label_0167: {
                if (l != 0) {
                    if (l == 1) {
                        layout$Alignment = Layout$Alignment.ALIGN_OPPOSITE;
                        break Label_0167;
                    }
                    if (l == 2) {
                        layout$Alignment = Layout$Alignment.ALIGN_CENTER;
                        break Label_0167;
                    }
                    if (l != 3) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected justification value: ");
                        sb.append(this.l);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
            }
            float n;
            float n2;
            if (this.f) {
                n = this.h / 99.0f;
                n2 = this.g / 99.0f;
            }
            else {
                n = this.h / 209.0f;
                n2 = this.g / 74.0f;
            }
            final int j = this.i;
            int n3;
            if (j / 3 == 0) {
                n3 = 0;
            }
            else if (j / 3 == 1) {
                n3 = 1;
            }
            else {
                n3 = 2;
            }
            int n4;
            if (j % 3 == 0) {
                n4 = 0;
            }
            else if (j % 3 == 1) {
                n4 = 1;
            }
            else {
                n4 = 2;
            }
            if (this.o != Cea708Decoder.b.x) {
                b = true;
            }
            return new a((CharSequence)spannableStringBuilder, layout$Alignment, n2 * 0.9f + 0.05f, 0, n3, n * 0.9f + 0.05f, n4, -3.4028235E38f, b, this.o, this.e);
        }
        
        public SpannableString d() {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)this.b);
            final int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan((Object)new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan((Object)new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan((Object)new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan((Object)new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString((CharSequence)spannableStringBuilder);
        }
        
        public void e() {
            this.a.clear();
            this.b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }
        
        public void f(final boolean d, final boolean k, final boolean b, int j, final boolean f, int n, final int h, final int n2, final int n3, final int i, final int m, final int n4) {
            this.c = true;
            this.d = d;
            this.k = k;
            this.e = j;
            this.f = f;
            this.g = n;
            this.h = h;
            this.i = i;
            j = this.j;
            n = n2 + 1;
            if (j != n) {
                this.j = n;
                while ((k && this.a.size() >= this.j) || this.a.size() >= 15) {
                    this.a.remove(0);
                }
            }
            if (m != 0 && this.m != m) {
                this.m = m;
                j = m - 1;
                this.q(Cea708Decoder.b.D[j], Cea708Decoder.b.y, Cea708Decoder.b.C[j], 0, Cea708Decoder.b.A[j], Cea708Decoder.b.B[j], Cea708Decoder.b.z[j]);
            }
            if (n4 != 0 && this.n != n4) {
                this.n = n4;
                j = n4 - 1;
                this.m(0, 1, 1, false, false, Cea708Decoder.b.F[j], Cea708Decoder.b.E[j]);
                this.n(Cea708Decoder.b.w, Cea708Decoder.b.G[j], Cea708Decoder.b.x);
            }
        }
        
        public boolean i() {
            return this.c;
        }
        
        public boolean j() {
            return !this.i() || (this.a.isEmpty() && this.b.length() == 0);
        }
        
        public boolean k() {
            return this.d;
        }
        
        public void l() {
            this.e();
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            final int x = Cea708Decoder.b.x;
            this.o = x;
            this.s = Cea708Decoder.b.w;
            this.u = x;
        }
        
        public void m(final int n, final int n2, final int n3, final boolean b, final boolean b2, final int n4, final int n5) {
            if (this.p != -1) {
                if (!b) {
                    this.b.setSpan((Object)new StyleSpan(2), this.p, this.b.length(), 33);
                    this.p = -1;
                }
            }
            else if (b) {
                this.p = this.b.length();
            }
            if (this.q != -1) {
                if (!b2) {
                    this.b.setSpan((Object)new UnderlineSpan(), this.q, this.b.length(), 33);
                    this.q = -1;
                }
            }
            else if (b2) {
                this.q = this.b.length();
            }
        }
        
        public void n(final int s, final int u, final int n) {
            if (this.r != -1 && this.s != s) {
                this.b.setSpan((Object)new ForegroundColorSpan(this.s), this.r, this.b.length(), 33);
            }
            if (s != Cea708Decoder.b.w) {
                this.r = this.b.length();
                this.s = s;
            }
            if (this.t != -1 && this.u != u) {
                this.b.setSpan((Object)new BackgroundColorSpan(this.u), this.t, this.b.length(), 33);
            }
            if (u != Cea708Decoder.b.x) {
                this.t = this.b.length();
                this.u = u;
            }
        }
        
        public void o(final int v, final int n) {
            if (this.v != v) {
                this.a('\n');
            }
            this.v = v;
        }
        
        public void p(final boolean d) {
            this.d = d;
        }
        
        public void q(final int o, final int n, final boolean b, final int n2, final int n3, final int n4, final int l) {
            this.o = o;
            this.l = l;
        }
    }
    
    private static final class c
    {
        public final int a;
        public final int b;
        public final byte[] c;
        int d;
        
        public c(final int a, final int b) {
            this.a = a;
            this.b = b;
            this.c = new byte[b * 2 - 1];
            this.d = 0;
        }
    }
}
