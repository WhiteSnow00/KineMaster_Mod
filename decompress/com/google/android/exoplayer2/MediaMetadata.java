// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.List;
import com.google.android.exoplayer2.metadata.Metadata;
import android.os.Parcelable;
import com.google.common.base.Objects;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import android.os.Bundle;

public final class MediaMetadata implements Bundleable
{
    public static final MediaMetadata R;
    public static final Creator<MediaMetadata> S;
    public final Boolean A;
    @Deprecated
    public final Integer B;
    public final Integer C;
    public final Integer D;
    public final Integer E;
    public final Integer F;
    public final Integer G;
    public final Integer H;
    public final CharSequence I;
    public final CharSequence J;
    public final CharSequence K;
    public final Integer L;
    public final Integer M;
    public final CharSequence N;
    public final CharSequence O;
    public final CharSequence P;
    public final Bundle Q;
    public final CharSequence a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final CharSequence g;
    public final Rating h;
    public final Rating i;
    public final byte[] j;
    public final Integer p;
    public final Uri w;
    public final Integer x;
    public final Integer y;
    public final Integer z;
    
    static {
        R = new Builder().F();
        S = d1.a;
    }
    
    private MediaMetadata(final Builder builder) {
        this.a = Builder.a(builder);
        this.b = Builder.l(builder);
        this.c = Builder.w(builder);
        this.d = Builder.z(builder);
        this.e = Builder.A(builder);
        this.f = Builder.B(builder);
        this.g = Builder.C(builder);
        this.h = Builder.D(builder);
        this.i = Builder.E(builder);
        this.j = Builder.b(builder);
        this.p = Builder.c(builder);
        this.w = Builder.d(builder);
        this.x = Builder.e(builder);
        this.y = Builder.f(builder);
        this.z = Builder.g(builder);
        this.A = Builder.h(builder);
        this.B = Builder.i(builder);
        this.C = Builder.i(builder);
        this.D = Builder.j(builder);
        this.E = Builder.k(builder);
        this.F = Builder.m(builder);
        this.G = Builder.n(builder);
        this.H = Builder.o(builder);
        this.I = Builder.p(builder);
        this.J = Builder.q(builder);
        this.K = Builder.r(builder);
        this.L = Builder.s(builder);
        this.M = Builder.t(builder);
        this.N = Builder.u(builder);
        this.O = Builder.v(builder);
        this.P = Builder.x(builder);
        this.Q = Builder.y(builder);
    }
    
    MediaMetadata(final Builder builder, final MediaMetadata$a object) {
        this(builder);
    }
    
    public static MediaMetadata a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static MediaMetadata c(final Bundle bundle) {
        final Builder builder = new Builder();
        final Builder s = builder.i0(bundle.getCharSequence(d(0))).M(bundle.getCharSequence(d(1))).L(bundle.getCharSequence(d(2))).K(bundle.getCharSequence(d(3))).U(bundle.getCharSequence(d(4))).h0(bundle.getCharSequence(d(5))).S(bundle.getCharSequence(d(6)));
        final byte[] byteArray = bundle.getByteArray(d(10));
        Integer value;
        if (bundle.containsKey(d(29))) {
            value = bundle.getInt(d(29));
        }
        else {
            value = null;
        }
        s.N(byteArray, value).O((Uri)bundle.getParcelable(d(11))).n0(bundle.getCharSequence(d(22))).Q(bundle.getCharSequence(d(23))).R(bundle.getCharSequence(d(24))).X(bundle.getCharSequence(d(27))).P(bundle.getCharSequence(d(28))).g0(bundle.getCharSequence(d(30))).V(bundle.getBundle(d(1000)));
        if (bundle.containsKey(d(8))) {
            final Bundle bundle2 = bundle.getBundle(d(8));
            if (bundle2 != null) {
                builder.m0(Rating.a.a(bundle2));
            }
        }
        if (bundle.containsKey(d(9))) {
            final Bundle bundle3 = bundle.getBundle(d(9));
            if (bundle3 != null) {
                builder.Z(Rating.a.a(bundle3));
            }
        }
        if (bundle.containsKey(d(12))) {
            builder.l0(bundle.getInt(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            builder.k0(bundle.getInt(d(13)));
        }
        if (bundle.containsKey(d(14))) {
            builder.W(bundle.getInt(d(14)));
        }
        if (bundle.containsKey(d(15))) {
            builder.Y(bundle.getBoolean(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            builder.c0(bundle.getInt(d(16)));
        }
        if (bundle.containsKey(d(17))) {
            builder.b0(bundle.getInt(d(17)));
        }
        if (bundle.containsKey(d(18))) {
            builder.a0(bundle.getInt(d(18)));
        }
        if (bundle.containsKey(d(19))) {
            builder.f0(bundle.getInt(d(19)));
        }
        if (bundle.containsKey(d(20))) {
            builder.e0(bundle.getInt(d(20)));
        }
        if (bundle.containsKey(d(21))) {
            builder.d0(bundle.getInt(d(21)));
        }
        if (bundle.containsKey(d(25))) {
            builder.T(bundle.getInt(d(25)));
        }
        if (bundle.containsKey(d(26))) {
            builder.j0(bundle.getInt(d(26)));
        }
        return builder.F();
    }
    
    private static String d(final int n) {
        return Integer.toString(n, 36);
    }
    
    public Builder b() {
        return new Builder(this, null);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && MediaMetadata.class == o.getClass()) {
            final MediaMetadata mediaMetadata = (MediaMetadata)o;
            if (!Util.c(this.a, mediaMetadata.a) || !Util.c(this.b, mediaMetadata.b) || !Util.c(this.c, mediaMetadata.c) || !Util.c(this.d, mediaMetadata.d) || !Util.c(this.e, mediaMetadata.e) || !Util.c(this.f, mediaMetadata.f) || !Util.c(this.g, mediaMetadata.g) || !Util.c(this.h, mediaMetadata.h) || !Util.c(this.i, mediaMetadata.i) || !Arrays.equals(this.j, mediaMetadata.j) || !Util.c(this.p, mediaMetadata.p) || !Util.c(this.w, mediaMetadata.w) || !Util.c(this.x, mediaMetadata.x) || !Util.c(this.y, mediaMetadata.y) || !Util.c(this.z, mediaMetadata.z) || !Util.c(this.A, mediaMetadata.A) || !Util.c(this.C, mediaMetadata.C) || !Util.c(this.D, mediaMetadata.D) || !Util.c(this.E, mediaMetadata.E) || !Util.c(this.F, mediaMetadata.F) || !Util.c(this.G, mediaMetadata.G) || !Util.c(this.H, mediaMetadata.H) || !Util.c(this.I, mediaMetadata.I) || !Util.c(this.J, mediaMetadata.J) || !Util.c(this.K, mediaMetadata.K) || !Util.c(this.L, mediaMetadata.L) || !Util.c(this.M, mediaMetadata.M) || !Util.c(this.N, mediaMetadata.N) || !Util.c(this.O, mediaMetadata.O) || !Util.c(this.P, mediaMetadata.P)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.b(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, Arrays.hashCode(this.j), this.p, this.w, this.x, this.y, this.z, this.A, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P });
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.a);
        bundle.putCharSequence(d(1), this.b);
        bundle.putCharSequence(d(2), this.c);
        bundle.putCharSequence(d(3), this.d);
        bundle.putCharSequence(d(4), this.e);
        bundle.putCharSequence(d(5), this.f);
        bundle.putCharSequence(d(6), this.g);
        bundle.putByteArray(d(10), this.j);
        bundle.putParcelable(d(11), (Parcelable)this.w);
        bundle.putCharSequence(d(22), this.I);
        bundle.putCharSequence(d(23), this.J);
        bundle.putCharSequence(d(24), this.K);
        bundle.putCharSequence(d(27), this.N);
        bundle.putCharSequence(d(28), this.O);
        bundle.putCharSequence(d(30), this.P);
        if (this.h != null) {
            bundle.putBundle(d(8), this.h.toBundle());
        }
        if (this.i != null) {
            bundle.putBundle(d(9), this.i.toBundle());
        }
        if (this.x != null) {
            bundle.putInt(d(12), (int)this.x);
        }
        if (this.y != null) {
            bundle.putInt(d(13), (int)this.y);
        }
        if (this.z != null) {
            bundle.putInt(d(14), (int)this.z);
        }
        if (this.A != null) {
            bundle.putBoolean(d(15), (boolean)this.A);
        }
        if (this.C != null) {
            bundle.putInt(d(16), (int)this.C);
        }
        if (this.D != null) {
            bundle.putInt(d(17), (int)this.D);
        }
        if (this.E != null) {
            bundle.putInt(d(18), (int)this.E);
        }
        if (this.F != null) {
            bundle.putInt(d(19), (int)this.F);
        }
        if (this.G != null) {
            bundle.putInt(d(20), (int)this.G);
        }
        if (this.H != null) {
            bundle.putInt(d(21), (int)this.H);
        }
        if (this.L != null) {
            bundle.putInt(d(25), (int)this.L);
        }
        if (this.M != null) {
            bundle.putInt(d(26), (int)this.M);
        }
        if (this.p != null) {
            bundle.putInt(d(29), (int)this.p);
        }
        if (this.Q != null) {
            bundle.putBundle(d(1000), this.Q);
        }
        return bundle;
    }
    
    public static final class Builder
    {
        private Integer A;
        private CharSequence B;
        private CharSequence C;
        private CharSequence D;
        private Bundle E;
        private CharSequence a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private CharSequence e;
        private CharSequence f;
        private CharSequence g;
        private Rating h;
        private Rating i;
        private byte[] j;
        private Integer k;
        private Uri l;
        private Integer m;
        private Integer n;
        private Integer o;
        private Boolean p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Integer u;
        private Integer v;
        private CharSequence w;
        private CharSequence x;
        private CharSequence y;
        private Integer z;
        
        public Builder() {
        }
        
        private Builder(final MediaMetadata mediaMetadata) {
            this.a = mediaMetadata.a;
            this.b = mediaMetadata.b;
            this.c = mediaMetadata.c;
            this.d = mediaMetadata.d;
            this.e = mediaMetadata.e;
            this.f = mediaMetadata.f;
            this.g = mediaMetadata.g;
            this.h = mediaMetadata.h;
            this.i = mediaMetadata.i;
            this.j = mediaMetadata.j;
            this.k = mediaMetadata.p;
            this.l = mediaMetadata.w;
            this.m = mediaMetadata.x;
            this.n = mediaMetadata.y;
            this.o = mediaMetadata.z;
            this.p = mediaMetadata.A;
            this.q = mediaMetadata.C;
            this.r = mediaMetadata.D;
            this.s = mediaMetadata.E;
            this.t = mediaMetadata.F;
            this.u = mediaMetadata.G;
            this.v = mediaMetadata.H;
            this.w = mediaMetadata.I;
            this.x = mediaMetadata.J;
            this.y = mediaMetadata.K;
            this.z = mediaMetadata.L;
            this.A = mediaMetadata.M;
            this.B = mediaMetadata.N;
            this.C = mediaMetadata.O;
            this.D = mediaMetadata.P;
            this.E = mediaMetadata.Q;
        }
        
        Builder(final MediaMetadata mediaMetadata, final MediaMetadata$a object) {
            this(mediaMetadata);
        }
        
        static CharSequence A(final Builder builder) {
            return builder.e;
        }
        
        static CharSequence B(final Builder builder) {
            return builder.f;
        }
        
        static CharSequence C(final Builder builder) {
            return builder.g;
        }
        
        static Rating D(final Builder builder) {
            return builder.h;
        }
        
        static Rating E(final Builder builder) {
            return builder.i;
        }
        
        static CharSequence a(final Builder builder) {
            return builder.a;
        }
        
        static byte[] b(final Builder builder) {
            return builder.j;
        }
        
        static Integer c(final Builder builder) {
            return builder.k;
        }
        
        static Uri d(final Builder builder) {
            return builder.l;
        }
        
        static Integer e(final Builder builder) {
            return builder.m;
        }
        
        static Integer f(final Builder builder) {
            return builder.n;
        }
        
        static Integer g(final Builder builder) {
            return builder.o;
        }
        
        static Boolean h(final Builder builder) {
            return builder.p;
        }
        
        static Integer i(final Builder builder) {
            return builder.q;
        }
        
        static Integer j(final Builder builder) {
            return builder.r;
        }
        
        static Integer k(final Builder builder) {
            return builder.s;
        }
        
        static CharSequence l(final Builder builder) {
            return builder.b;
        }
        
        static Integer m(final Builder builder) {
            return builder.t;
        }
        
        static Integer n(final Builder builder) {
            return builder.u;
        }
        
        static Integer o(final Builder builder) {
            return builder.v;
        }
        
        static CharSequence p(final Builder builder) {
            return builder.w;
        }
        
        static CharSequence q(final Builder builder) {
            return builder.x;
        }
        
        static CharSequence r(final Builder builder) {
            return builder.y;
        }
        
        static Integer s(final Builder builder) {
            return builder.z;
        }
        
        static Integer t(final Builder builder) {
            return builder.A;
        }
        
        static CharSequence u(final Builder builder) {
            return builder.B;
        }
        
        static CharSequence v(final Builder builder) {
            return builder.C;
        }
        
        static CharSequence w(final Builder builder) {
            return builder.c;
        }
        
        static CharSequence x(final Builder builder) {
            return builder.D;
        }
        
        static Bundle y(final Builder builder) {
            return builder.E;
        }
        
        static CharSequence z(final Builder builder) {
            return builder.d;
        }
        
        public MediaMetadata F() {
            return new MediaMetadata(this, null);
        }
        
        public Builder G(final byte[] array, final int n) {
            if (this.j == null || Util.c(n, 3) || !Util.c(this.k, 3)) {
                this.j = array.clone();
                this.k = n;
            }
            return this;
        }
        
        public Builder H(final MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            final CharSequence a = mediaMetadata.a;
            if (a != null) {
                this.i0(a);
            }
            final CharSequence b = mediaMetadata.b;
            if (b != null) {
                this.M(b);
            }
            final CharSequence c = mediaMetadata.c;
            if (c != null) {
                this.L(c);
            }
            final CharSequence d = mediaMetadata.d;
            if (d != null) {
                this.K(d);
            }
            final CharSequence e = mediaMetadata.e;
            if (e != null) {
                this.U(e);
            }
            final CharSequence f = mediaMetadata.f;
            if (f != null) {
                this.h0(f);
            }
            final CharSequence g = mediaMetadata.g;
            if (g != null) {
                this.S(g);
            }
            final Rating h = mediaMetadata.h;
            if (h != null) {
                this.m0(h);
            }
            final Rating i = mediaMetadata.i;
            if (i != null) {
                this.Z(i);
            }
            final byte[] j = mediaMetadata.j;
            if (j != null) {
                this.N(j, mediaMetadata.p);
            }
            final Uri w = mediaMetadata.w;
            if (w != null) {
                this.O(w);
            }
            final Integer x = mediaMetadata.x;
            if (x != null) {
                this.l0(x);
            }
            final Integer y = mediaMetadata.y;
            if (y != null) {
                this.k0(y);
            }
            final Integer z = mediaMetadata.z;
            if (z != null) {
                this.W(z);
            }
            final Boolean a2 = mediaMetadata.A;
            if (a2 != null) {
                this.Y(a2);
            }
            final Integer b2 = mediaMetadata.B;
            if (b2 != null) {
                this.c0(b2);
            }
            final Integer c2 = mediaMetadata.C;
            if (c2 != null) {
                this.c0(c2);
            }
            final Integer d2 = mediaMetadata.D;
            if (d2 != null) {
                this.b0(d2);
            }
            final Integer e2 = mediaMetadata.E;
            if (e2 != null) {
                this.a0(e2);
            }
            final Integer f2 = mediaMetadata.F;
            if (f2 != null) {
                this.f0(f2);
            }
            final Integer g2 = mediaMetadata.G;
            if (g2 != null) {
                this.e0(g2);
            }
            final Integer h2 = mediaMetadata.H;
            if (h2 != null) {
                this.d0(h2);
            }
            final CharSequence k = mediaMetadata.I;
            if (k != null) {
                this.n0(k);
            }
            final CharSequence l = mediaMetadata.J;
            if (l != null) {
                this.Q(l);
            }
            final CharSequence m = mediaMetadata.K;
            if (m != null) {
                this.R(m);
            }
            final Integer l2 = mediaMetadata.L;
            if (l2 != null) {
                this.T(l2);
            }
            final Integer m2 = mediaMetadata.M;
            if (m2 != null) {
                this.j0(m2);
            }
            final CharSequence n = mediaMetadata.N;
            if (n != null) {
                this.X(n);
            }
            final CharSequence o = mediaMetadata.O;
            if (o != null) {
                this.P(o);
            }
            final CharSequence p = mediaMetadata.P;
            if (p != null) {
                this.g0(p);
            }
            final Bundle q = mediaMetadata.Q;
            if (q != null) {
                this.V(q);
            }
            return this;
        }
        
        public Builder I(final Metadata metadata) {
            for (int i = 0; i < metadata.d(); ++i) {
                metadata.c(i).B0(this);
            }
            return this;
        }
        
        public Builder J(final List<Metadata> list) {
            for (int i = 0; i < list.size(); ++i) {
                final Metadata metadata = list.get(i);
                for (int j = 0; j < metadata.d(); ++j) {
                    metadata.c(j).B0(this);
                }
            }
            return this;
        }
        
        public Builder K(final CharSequence d) {
            this.d = d;
            return this;
        }
        
        public Builder L(final CharSequence c) {
            this.c = c;
            return this;
        }
        
        public Builder M(final CharSequence b) {
            this.b = b;
            return this;
        }
        
        public Builder N(byte[] j, final Integer k) {
            if (j == null) {
                j = null;
            }
            else {
                j = j.clone();
            }
            this.j = j;
            this.k = k;
            return this;
        }
        
        public Builder O(final Uri l) {
            this.l = l;
            return this;
        }
        
        public Builder P(final CharSequence c) {
            this.C = c;
            return this;
        }
        
        public Builder Q(final CharSequence x) {
            this.x = x;
            return this;
        }
        
        public Builder R(final CharSequence y) {
            this.y = y;
            return this;
        }
        
        public Builder S(final CharSequence g) {
            this.g = g;
            return this;
        }
        
        public Builder T(final Integer z) {
            this.z = z;
            return this;
        }
        
        public Builder U(final CharSequence e) {
            this.e = e;
            return this;
        }
        
        public Builder V(final Bundle e) {
            this.E = e;
            return this;
        }
        
        public Builder W(final Integer o) {
            this.o = o;
            return this;
        }
        
        public Builder X(final CharSequence b) {
            this.B = b;
            return this;
        }
        
        public Builder Y(final Boolean p) {
            this.p = p;
            return this;
        }
        
        public Builder Z(final Rating i) {
            this.i = i;
            return this;
        }
        
        public Builder a0(final Integer s) {
            this.s = s;
            return this;
        }
        
        public Builder b0(final Integer r) {
            this.r = r;
            return this;
        }
        
        public Builder c0(final Integer q) {
            this.q = q;
            return this;
        }
        
        public Builder d0(final Integer v) {
            this.v = v;
            return this;
        }
        
        public Builder e0(final Integer u) {
            this.u = u;
            return this;
        }
        
        public Builder f0(final Integer t) {
            this.t = t;
            return this;
        }
        
        public Builder g0(final CharSequence d) {
            this.D = d;
            return this;
        }
        
        public Builder h0(final CharSequence f) {
            this.f = f;
            return this;
        }
        
        public Builder i0(final CharSequence a) {
            this.a = a;
            return this;
        }
        
        public Builder j0(final Integer a) {
            this.A = a;
            return this;
        }
        
        public Builder k0(final Integer n) {
            this.n = n;
            return this;
        }
        
        public Builder l0(final Integer m) {
            this.m = m;
            return this;
        }
        
        public Builder m0(final Rating h) {
            this.h = h;
            return this;
        }
        
        public Builder n0(final CharSequence w) {
            this.w = w;
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface FolderType {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface PictureType {
    }
}
