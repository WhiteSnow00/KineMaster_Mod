// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.ParserException;
import java.util.Map;
import java.util.HashMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;

final class MediaDescription
{
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final ImmutableMap<String, String> i;
    public final RtpMapAttribute j;
    
    private MediaDescription(final Builder builder, final ImmutableMap<String, String> i, final RtpMapAttribute j) {
        this.a = Builder.a(builder);
        this.b = Builder.b(builder);
        this.c = Builder.c(builder);
        this.d = Builder.d(builder);
        this.f = Builder.e(builder);
        this.g = Builder.f(builder);
        this.e = Builder.g(builder);
        this.h = Builder.h(builder);
        this.i = i;
        this.j = j;
    }
    
    MediaDescription(final Builder builder, final ImmutableMap immutableMap, final RtpMapAttribute rtpMapAttribute, final MediaDescription$a object) {
        this(builder, (ImmutableMap<String, String>)immutableMap, rtpMapAttribute);
    }
    
    public ImmutableMap<String, String> a() {
        final String s = (String)this.i.get((Object)"fmtp");
        if (s == null) {
            return (ImmutableMap<String, String>)ImmutableMap.of();
        }
        final String[] u0 = Util.U0(s, " ");
        Assertions.b(u0.length == 2, s);
        final String[] split = u0[1].split(";\\s?", 0);
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder();
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] u2 = Util.U0(split[i], "=");
            immutableMap$Builder.d((Object)u2[0], (Object)u2[1]);
        }
        return (ImmutableMap<String, String>)immutableMap$Builder.b();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && MediaDescription.class == o.getClass()) {
            final MediaDescription mediaDescription = (MediaDescription)o;
            if (!this.a.equals(mediaDescription.a) || this.b != mediaDescription.b || !this.c.equals(mediaDescription.c) || this.d != mediaDescription.d || this.e != mediaDescription.e || !this.i.equals((Object)mediaDescription.i) || !this.j.equals(mediaDescription.j) || !Util.c(this.f, mediaDescription.f) || !Util.c(this.g, mediaDescription.g) || !Util.c(this.h, mediaDescription.h)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int b = this.b;
        final int hashCode2 = this.c.hashCode();
        final int d = this.d;
        final int e = this.e;
        final int hashCode3 = this.i.hashCode();
        final int hashCode4 = this.j.hashCode();
        final String f = this.f;
        int hashCode5 = 0;
        int hashCode6;
        if (f == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = f.hashCode();
        }
        final String g = this.g;
        int hashCode7;
        if (g == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = g.hashCode();
        }
        final String h = this.h;
        if (h != null) {
            hashCode5 = h.hashCode();
        }
        return (((((((((217 + hashCode) * 31 + b) * 31 + hashCode2) * 31 + d) * 31 + e) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode5;
    }
    
    public static final class Builder
    {
        private final String a;
        private final int b;
        private final String c;
        private final int d;
        private final HashMap<String, String> e;
        private int f;
        private String g;
        private String h;
        private String i;
        
        public Builder(final String a, final int b, final String c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = new HashMap<String, String>();
            this.f = -1;
        }
        
        static String a(final Builder builder) {
            return builder.a;
        }
        
        static int b(final Builder builder) {
            return builder.b;
        }
        
        static String c(final Builder builder) {
            return builder.c;
        }
        
        static int d(final Builder builder) {
            return builder.d;
        }
        
        static String e(final Builder builder) {
            return builder.g;
        }
        
        static String f(final Builder builder) {
            return builder.h;
        }
        
        static int g(final Builder builder) {
            return builder.f;
        }
        
        static String h(final Builder builder) {
            return builder.i;
        }
        
        private static String k(final int n, final String s, final int n2, final int n3) {
            return Util.C("%d %s/%d/%d", n, s, n2, n3);
        }
        
        private static String l(final int n) {
            Assertions.a(n < 96);
            if (n == 0) {
                return k(0, "PCMU", 8000, 1);
            }
            if (n == 8) {
                return k(8, "PCMA", 8000, 1);
            }
            if (n == 10) {
                return k(10, "L16", 44100, 2);
            }
            if (n == 11) {
                return k(11, "L16", 44100, 1);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Unsupported static paylod type ");
            sb.append(n);
            throw new IllegalStateException(sb.toString());
        }
        
        public Builder i(final String s, final String s2) {
            this.e.put(s, s2);
            return this;
        }
        
        public MediaDescription j() {
            try {
                RtpMapAttribute rtpMapAttribute;
                if (this.e.containsKey("rtpmap")) {
                    rtpMapAttribute = RtpMapAttribute.a(Util.j(this.e.get("rtpmap")));
                }
                else {
                    rtpMapAttribute = RtpMapAttribute.a(l(this.d));
                }
                return new MediaDescription(this, ImmutableMap.copyOf((Map)this.e), rtpMapAttribute, null);
            }
            catch (final ParserException ex) {
                throw new IllegalStateException(ex);
            }
        }
        
        public Builder m(final int f) {
            this.f = f;
            return this;
        }
        
        public Builder n(final String h) {
            this.h = h;
            return this;
        }
        
        public Builder o(final String i) {
            this.i = i;
            return this;
        }
        
        public Builder p(final String g) {
            this.g = g;
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }
    
    public static final class RtpMapAttribute
    {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        
        private RtpMapAttribute(final int a, final String b, final int c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public static RtpMapAttribute a(final String s) throws ParserException {
            final String[] u0 = Util.U0(s, " ");
            Assertions.a(u0.length == 2);
            final int h = RtspMessageUtil.h(u0[0]);
            final String[] t0 = Util.T0(u0[1].trim(), "/");
            Assertions.a(t0.length >= 2);
            final int h2 = RtspMessageUtil.h(t0[1]);
            int h3 = -1;
            if (t0.length == 3) {
                h3 = RtspMessageUtil.h(t0[2]);
            }
            return new RtpMapAttribute(h, t0[0], h2, h3);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && RtpMapAttribute.class == o.getClass()) {
                final RtpMapAttribute rtpMapAttribute = (RtpMapAttribute)o;
                if (this.a != rtpMapAttribute.a || !this.b.equals(rtpMapAttribute.b) || this.c != rtpMapAttribute.c || this.d != rtpMapAttribute.d) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return (((217 + this.a) * 31 + this.b.hashCode()) * 31 + this.c) * 31 + this.d;
        }
    }
}
