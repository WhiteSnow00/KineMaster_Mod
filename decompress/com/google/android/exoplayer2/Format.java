// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Parcelable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.UUID;
import com.google.common.base.Joiner;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.BundleableUtil;
import android.os.Bundle;
import java.util.Collections;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.List;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;

public final class Format implements Bundleable
{
    private static final Format R;
    public static final Creator<Format> S;
    public final long A;
    public final int B;
    public final int C;
    public final float D;
    public final int E;
    public final float F;
    public final byte[] G;
    public final int H;
    public final ColorInfo I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    private int Q;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final Metadata j;
    public final String p;
    public final String w;
    public final int x;
    public final List<byte[]> y;
    public final DrmInitData z;
    
    static {
        R = new Builder().E();
        S = x0.a;
    }
    
    private Format(final Builder builder) {
        this.a = Builder.a(builder);
        this.b = Builder.l(builder);
        this.c = Util.E0(Builder.w(builder));
        this.d = Builder.y(builder);
        this.e = Builder.z(builder);
        int a = Builder.A(builder);
        this.f = a;
        final int b = Builder.B(builder);
        this.g = b;
        if (b != -1) {
            a = b;
        }
        this.h = a;
        this.i = Builder.C(builder);
        this.j = Builder.D(builder);
        this.p = Builder.b(builder);
        this.w = Builder.c(builder);
        this.x = Builder.d(builder);
        List<Object> y;
        if (Builder.e(builder) == null) {
            y = (List<Object>)Collections.emptyList();
        }
        else {
            y = Builder.e(builder);
        }
        this.y = (List<byte[]>)y;
        final DrmInitData f = Builder.f(builder);
        this.z = f;
        this.A = Builder.g(builder);
        this.B = Builder.h(builder);
        this.C = Builder.i(builder);
        this.D = Builder.j(builder);
        final int k = Builder.k(builder);
        final int n = 0;
        int i;
        if (k == -1) {
            i = 0;
        }
        else {
            i = Builder.k(builder);
        }
        this.E = i;
        float m;
        if (Builder.m(builder) == -1.0f) {
            m = 1.0f;
        }
        else {
            m = Builder.m(builder);
        }
        this.F = m;
        this.G = Builder.n(builder);
        this.H = Builder.o(builder);
        this.I = Builder.p(builder);
        this.J = Builder.q(builder);
        this.K = Builder.r(builder);
        this.L = Builder.s(builder);
        int t;
        if (Builder.t(builder) == -1) {
            t = 0;
        }
        else {
            t = Builder.t(builder);
        }
        this.M = t;
        int u;
        if (Builder.u(builder) == -1) {
            u = n;
        }
        else {
            u = Builder.u(builder);
        }
        this.N = u;
        this.O = Builder.v(builder);
        if (Builder.x(builder) == 0 && f != null) {
            this.P = 1;
        }
        else {
            this.P = Builder.x(builder);
        }
    }
    
    Format(final Builder builder, final Format$a object) {
        this(builder);
    }
    
    public static Format a(final Bundle bundle) {
        return e(bundle);
    }
    
    private static <T> T d(T t, final T t2) {
        if (t == null) {
            t = t2;
        }
        return t;
    }
    
    private static Format e(final Bundle bundle) {
        final Builder builder = new Builder();
        BundleableUtil.a(bundle);
        int n = 0;
        final String string = bundle.getString(h(0));
        final Format r = Format.R;
        builder.S(d(string, r.a)).U(d(bundle.getString(h(1)), r.b)).V(d(bundle.getString(h(2)), r.c)).g0(bundle.getInt(h(3), r.d)).c0(bundle.getInt(h(4), r.e)).G(bundle.getInt(h(5), r.f)).Z(bundle.getInt(h(6), r.g)).I(d(bundle.getString(h(7)), r.i)).X(d(bundle.getParcelable(h(8)), r.j)).K(d(bundle.getString(h(9)), r.p)).e0(d(bundle.getString(h(10)), r.w)).W(bundle.getInt(h(11), r.x));
        final ArrayList list = new ArrayList();
        while (true) {
            final byte[] byteArray = bundle.getByteArray(i(n));
            if (byteArray == null) {
                break;
            }
            list.add(byteArray);
            ++n;
        }
        final Builder m = builder.T(list).M((DrmInitData)bundle.getParcelable(h(13)));
        final String h = h(14);
        final Format r2 = Format.R;
        m.i0(bundle.getLong(h, r2.A)).j0(bundle.getInt(h(15), r2.B)).Q(bundle.getInt(h(16), r2.C)).P(bundle.getFloat(h(17), r2.D)).d0(bundle.getInt(h(18), r2.E)).a0(bundle.getFloat(h(19), r2.F)).b0(bundle.getByteArray(h(20))).h0(bundle.getInt(h(21), r2.H));
        final Bundle bundle2 = bundle.getBundle(h(22));
        if (bundle2 != null) {
            builder.J(ColorInfo.f.a(bundle2));
        }
        builder.H(bundle.getInt(h(23), r2.J)).f0(bundle.getInt(h(24), r2.K)).Y(bundle.getInt(h(25), r2.L)).N(bundle.getInt(h(26), r2.M)).O(bundle.getInt(h(27), r2.N)).F(bundle.getInt(h(28), r2.O)).L(bundle.getInt(h(29), r2.P));
        return builder.E();
    }
    
    private static String h(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static String i(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(h(12));
        sb.append("_");
        sb.append(Integer.toString(n, 36));
        return sb.toString();
    }
    
    public static String j(final Format format) {
        if (format == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.a);
        sb.append(", mimeType=");
        sb.append(format.w);
        if (format.h != -1) {
            sb.append(", bitrate=");
            sb.append(format.h);
        }
        if (format.i != null) {
            sb.append(", codecs=");
            sb.append(format.i);
        }
        if (format.z != null) {
            final LinkedHashSet set = new LinkedHashSet();
            int n = 0;
            while (true) {
                final DrmInitData z = format.z;
                if (n >= z.d) {
                    break;
                }
                final UUID b = z.e(n).b;
                if (b.equals(C.b)) {
                    set.add("cenc");
                }
                else if (b.equals(C.c)) {
                    set.add("clearkey");
                }
                else if (b.equals(C.e)) {
                    set.add("playready");
                }
                else if (b.equals(C.d)) {
                    set.add("widevine");
                }
                else if (b.equals(C.a)) {
                    set.add("universal");
                }
                else {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("unknown (");
                    sb2.append(b);
                    sb2.append(")");
                    set.add(sb2.toString());
                }
                ++n;
            }
            sb.append(", drm=[");
            Joiner.h(',').c(sb, (Iterable)set);
            sb.append(']');
        }
        if (format.B != -1 && format.C != -1) {
            sb.append(", res=");
            sb.append(format.B);
            sb.append("x");
            sb.append(format.C);
        }
        if (format.D != -1.0f) {
            sb.append(", fps=");
            sb.append(format.D);
        }
        if (format.J != -1) {
            sb.append(", channels=");
            sb.append(format.J);
        }
        if (format.K != -1) {
            sb.append(", sample_rate=");
            sb.append(format.K);
        }
        if (format.c != null) {
            sb.append(", language=");
            sb.append(format.c);
        }
        if (format.b != null) {
            sb.append(", label=");
            sb.append(format.b);
        }
        if (format.d != 0) {
            final ArrayList list = new ArrayList();
            if ((format.d & 0x4) != 0x0) {
                list.add("auto");
            }
            if ((format.d & 0x1) != 0x0) {
                list.add("default");
            }
            if ((format.d & 0x2) != 0x0) {
                list.add("forced");
            }
            sb.append(", selectionFlags=[");
            Joiner.h(',').c(sb, (Iterable)list);
            sb.append("]");
        }
        if (format.e != 0) {
            final ArrayList list2 = new ArrayList();
            if ((format.e & 0x1) != 0x0) {
                list2.add("main");
            }
            if ((format.e & 0x2) != 0x0) {
                list2.add("alt");
            }
            if ((format.e & 0x4) != 0x0) {
                list2.add("supplementary");
            }
            if ((format.e & 0x8) != 0x0) {
                list2.add("commentary");
            }
            if ((format.e & 0x10) != 0x0) {
                list2.add("dub");
            }
            if ((format.e & 0x20) != 0x0) {
                list2.add("emergency");
            }
            if ((format.e & 0x40) != 0x0) {
                list2.add("caption");
            }
            if ((format.e & 0x80) != 0x0) {
                list2.add("subtitle");
            }
            if ((format.e & 0x100) != 0x0) {
                list2.add("sign");
            }
            if ((format.e & 0x200) != 0x0) {
                list2.add("describes-video");
            }
            if ((format.e & 0x400) != 0x0) {
                list2.add("describes-music");
            }
            if ((format.e & 0x800) != 0x0) {
                list2.add("enhanced-intelligibility");
            }
            if ((format.e & 0x1000) != 0x0) {
                list2.add("transcribes-dialog");
            }
            if ((format.e & 0x2000) != 0x0) {
                list2.add("easy-read");
            }
            if ((format.e & 0x4000) != 0x0) {
                list2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            Joiner.h(',').c(sb, (Iterable)list2);
            sb.append("]");
        }
        return sb.toString();
    }
    
    public Builder b() {
        return new Builder(this, null);
    }
    
    public Format c(final int n) {
        return this.b().L(n).E();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && Format.class == o.getClass()) {
            final Format format = (Format)o;
            final int q = this.Q;
            if (q != 0) {
                final int q2 = format.Q;
                if (q2 != 0 && q != q2) {
                    return false;
                }
            }
            if (this.d != format.d || this.e != format.e || this.f != format.f || this.g != format.g || this.x != format.x || this.A != format.A || this.B != format.B || this.C != format.C || this.E != format.E || this.H != format.H || this.J != format.J || this.K != format.K || this.L != format.L || this.M != format.M || this.N != format.N || this.O != format.O || this.P != format.P || Float.compare(this.D, format.D) != 0 || Float.compare(this.F, format.F) != 0 || !Util.c(this.a, format.a) || !Util.c(this.b, format.b) || !Util.c(this.i, format.i) || !Util.c(this.p, format.p) || !Util.c(this.w, format.w) || !Util.c(this.c, format.c) || !Arrays.equals(this.G, format.G) || !Util.c(this.j, format.j) || !Util.c(this.I, format.I) || !Util.c(this.z, format.z) || !this.g(format)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public int f() {
        final int b = this.B;
        int n = -1;
        if (b != -1) {
            final int c = this.C;
            if (c == -1) {
                n = n;
            }
            else {
                n = b * c;
            }
        }
        return n;
    }
    
    public boolean g(final Format format) {
        if (this.y.size() != format.y.size()) {
            return false;
        }
        for (int i = 0; i < this.y.size(); ++i) {
            if (!Arrays.equals(this.y.get(i), format.y.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        if (this.Q == 0) {
            final String a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = a.hashCode();
            }
            final String b = this.b;
            int hashCode3;
            if (b != null) {
                hashCode3 = b.hashCode();
            }
            else {
                hashCode3 = 0;
            }
            final String c = this.c;
            int hashCode4;
            if (c == null) {
                hashCode4 = 0;
            }
            else {
                hashCode4 = c.hashCode();
            }
            final int d = this.d;
            final int e = this.e;
            final int f = this.f;
            final int g = this.g;
            final String i = this.i;
            int hashCode5;
            if (i == null) {
                hashCode5 = 0;
            }
            else {
                hashCode5 = i.hashCode();
            }
            final Metadata j = this.j;
            int hashCode6;
            if (j == null) {
                hashCode6 = 0;
            }
            else {
                hashCode6 = j.hashCode();
            }
            final String p = this.p;
            int hashCode7;
            if (p == null) {
                hashCode7 = 0;
            }
            else {
                hashCode7 = p.hashCode();
            }
            final String w = this.w;
            if (w != null) {
                hashCode = w.hashCode();
            }
            this.Q = (((((((((((((((((((((((((527 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + d) * 31 + e) * 31 + f) * 31 + g) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode) * 31 + this.x) * 31 + (int)this.A) * 31 + this.B) * 31 + this.C) * 31 + Float.floatToIntBits(this.D)) * 31 + this.E) * 31 + Float.floatToIntBits(this.F)) * 31 + this.H) * 31 + this.J) * 31 + this.K) * 31 + this.L) * 31 + this.M) * 31 + this.N) * 31 + this.O) * 31 + this.P;
        }
        return this.Q;
    }
    
    public Format k(final Format format) {
        if (this == format) {
            return this;
        }
        final int k = MimeTypes.k(this.w);
        final String a = format.a;
        String s = format.b;
        if (s == null) {
            s = this.b;
        }
        final String c = this.c;
        String s2 = null;
        Label_0083: {
            if (k != 3) {
                s2 = c;
                if (k != 1) {
                    break Label_0083;
                }
            }
            final String c2 = format.c;
            s2 = c;
            if (c2 != null) {
                s2 = c2;
            }
        }
        int n;
        if ((n = this.f) == -1) {
            n = format.f;
        }
        int n2;
        if ((n2 = this.g) == -1) {
            n2 = format.g;
        }
        final String i = this.i;
        String s3;
        if ((s3 = i) == null) {
            final String l = Util.L(format.i, k);
            s3 = i;
            if (Util.V0(l).length == 1) {
                s3 = l;
            }
        }
        final Metadata j = this.j;
        Metadata metadata;
        if (j == null) {
            metadata = format.j;
        }
        else {
            metadata = j.b(format.j);
        }
        float n4;
        final float n3 = n4 = this.D;
        if (n3 == -1.0f) {
            n4 = n3;
            if (k == 2) {
                n4 = format.D;
            }
        }
        return this.b().S(a).U(s).V(s2).g0(this.d | format.d).c0(this.e | format.e).G(n).Z(n2).I(s3).X(metadata).M(DrmInitData.d(format.z, this.z)).P(n4).E();
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        int i = 0;
        bundle.putString(h(0), this.a);
        bundle.putString(h(1), this.b);
        bundle.putString(h(2), this.c);
        bundle.putInt(h(3), this.d);
        bundle.putInt(h(4), this.e);
        bundle.putInt(h(5), this.f);
        bundle.putInt(h(6), this.g);
        bundle.putString(h(7), this.i);
        bundle.putParcelable(h(8), (Parcelable)this.j);
        bundle.putString(h(9), this.p);
        bundle.putString(h(10), this.w);
        bundle.putInt(h(11), this.x);
        while (i < this.y.size()) {
            bundle.putByteArray(i(i), (byte[])this.y.get(i));
            ++i;
        }
        bundle.putParcelable(h(13), (Parcelable)this.z);
        bundle.putLong(h(14), this.A);
        bundle.putInt(h(15), this.B);
        bundle.putInt(h(16), this.C);
        bundle.putFloat(h(17), this.D);
        bundle.putInt(h(18), this.E);
        bundle.putFloat(h(19), this.F);
        bundle.putByteArray(h(20), this.G);
        bundle.putInt(h(21), this.H);
        if (this.I != null) {
            bundle.putBundle(h(22), this.I.toBundle());
        }
        bundle.putInt(h(23), this.J);
        bundle.putInt(h(24), this.K);
        bundle.putInt(h(25), this.L);
        bundle.putInt(h(26), this.M);
        bundle.putInt(h(27), this.N);
        bundle.putInt(h(28), this.O);
        bundle.putInt(h(29), this.P);
        return bundle;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Format(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.p);
        sb.append(", ");
        sb.append(this.w);
        sb.append(", ");
        sb.append(this.i);
        sb.append(", ");
        sb.append(this.h);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", [");
        sb.append(this.B);
        sb.append(", ");
        sb.append(this.C);
        sb.append(", ");
        sb.append(this.D);
        sb.append("], [");
        sb.append(this.J);
        sb.append(", ");
        sb.append(this.K);
        sb.append("])");
        return sb.toString();
    }
    
    public static final class Builder
    {
        private int A;
        private int B;
        private int C;
        private int D;
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private String h;
        private Metadata i;
        private String j;
        private String k;
        private int l;
        private List<byte[]> m;
        private DrmInitData n;
        private long o;
        private int p;
        private int q;
        private float r;
        private int s;
        private float t;
        private byte[] u;
        private int v;
        private ColorInfo w;
        private int x;
        private int y;
        private int z;
        
        public Builder() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
            this.D = 0;
        }
        
        private Builder(final Format format) {
            this.a = format.a;
            this.b = format.b;
            this.c = format.c;
            this.d = format.d;
            this.e = format.e;
            this.f = format.f;
            this.g = format.g;
            this.h = format.i;
            this.i = format.j;
            this.j = format.p;
            this.k = format.w;
            this.l = format.x;
            this.m = format.y;
            this.n = format.z;
            this.o = format.A;
            this.p = format.B;
            this.q = format.C;
            this.r = format.D;
            this.s = format.E;
            this.t = format.F;
            this.u = format.G;
            this.v = format.H;
            this.w = format.I;
            this.x = format.J;
            this.y = format.K;
            this.z = format.L;
            this.A = format.M;
            this.B = format.N;
            this.C = format.O;
            this.D = format.P;
        }
        
        Builder(final Format format, final Format$a object) {
            this(format);
        }
        
        static int A(final Builder builder) {
            return builder.f;
        }
        
        static int B(final Builder builder) {
            return builder.g;
        }
        
        static String C(final Builder builder) {
            return builder.h;
        }
        
        static Metadata D(final Builder builder) {
            return builder.i;
        }
        
        static String a(final Builder builder) {
            return builder.a;
        }
        
        static String b(final Builder builder) {
            return builder.j;
        }
        
        static String c(final Builder builder) {
            return builder.k;
        }
        
        static int d(final Builder builder) {
            return builder.l;
        }
        
        static List e(final Builder builder) {
            return builder.m;
        }
        
        static DrmInitData f(final Builder builder) {
            return builder.n;
        }
        
        static long g(final Builder builder) {
            return builder.o;
        }
        
        static int h(final Builder builder) {
            return builder.p;
        }
        
        static int i(final Builder builder) {
            return builder.q;
        }
        
        static float j(final Builder builder) {
            return builder.r;
        }
        
        static int k(final Builder builder) {
            return builder.s;
        }
        
        static String l(final Builder builder) {
            return builder.b;
        }
        
        static float m(final Builder builder) {
            return builder.t;
        }
        
        static byte[] n(final Builder builder) {
            return builder.u;
        }
        
        static int o(final Builder builder) {
            return builder.v;
        }
        
        static ColorInfo p(final Builder builder) {
            return builder.w;
        }
        
        static int q(final Builder builder) {
            return builder.x;
        }
        
        static int r(final Builder builder) {
            return builder.y;
        }
        
        static int s(final Builder builder) {
            return builder.z;
        }
        
        static int t(final Builder builder) {
            return builder.A;
        }
        
        static int u(final Builder builder) {
            return builder.B;
        }
        
        static int v(final Builder builder) {
            return builder.C;
        }
        
        static String w(final Builder builder) {
            return builder.c;
        }
        
        static int x(final Builder builder) {
            return builder.D;
        }
        
        static int y(final Builder builder) {
            return builder.d;
        }
        
        static int z(final Builder builder) {
            return builder.e;
        }
        
        public Format E() {
            return new Format(this, null);
        }
        
        public Builder F(final int c) {
            this.C = c;
            return this;
        }
        
        public Builder G(final int f) {
            this.f = f;
            return this;
        }
        
        public Builder H(final int x) {
            this.x = x;
            return this;
        }
        
        public Builder I(final String h) {
            this.h = h;
            return this;
        }
        
        public Builder J(final ColorInfo w) {
            this.w = w;
            return this;
        }
        
        public Builder K(final String j) {
            this.j = j;
            return this;
        }
        
        public Builder L(final int d) {
            this.D = d;
            return this;
        }
        
        public Builder M(final DrmInitData n) {
            this.n = n;
            return this;
        }
        
        public Builder N(final int a) {
            this.A = a;
            return this;
        }
        
        public Builder O(final int b) {
            this.B = b;
            return this;
        }
        
        public Builder P(final float r) {
            this.r = r;
            return this;
        }
        
        public Builder Q(final int q) {
            this.q = q;
            return this;
        }
        
        public Builder R(final int n) {
            this.a = Integer.toString(n);
            return this;
        }
        
        public Builder S(final String a) {
            this.a = a;
            return this;
        }
        
        public Builder T(final List<byte[]> m) {
            this.m = m;
            return this;
        }
        
        public Builder U(final String b) {
            this.b = b;
            return this;
        }
        
        public Builder V(final String c) {
            this.c = c;
            return this;
        }
        
        public Builder W(final int l) {
            this.l = l;
            return this;
        }
        
        public Builder X(final Metadata i) {
            this.i = i;
            return this;
        }
        
        public Builder Y(final int z) {
            this.z = z;
            return this;
        }
        
        public Builder Z(final int g) {
            this.g = g;
            return this;
        }
        
        public Builder a0(final float t) {
            this.t = t;
            return this;
        }
        
        public Builder b0(final byte[] u) {
            this.u = u;
            return this;
        }
        
        public Builder c0(final int e) {
            this.e = e;
            return this;
        }
        
        public Builder d0(final int s) {
            this.s = s;
            return this;
        }
        
        public Builder e0(final String k) {
            this.k = k;
            return this;
        }
        
        public Builder f0(final int y) {
            this.y = y;
            return this;
        }
        
        public Builder g0(final int d) {
            this.d = d;
            return this;
        }
        
        public Builder h0(final int v) {
            this.v = v;
            return this;
        }
        
        public Builder i0(final long o) {
            this.o = o;
            return this;
        }
        
        public Builder j0(final int p) {
            this.p = p;
            return this;
        }
    }
}
