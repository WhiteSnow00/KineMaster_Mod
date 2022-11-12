// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableList$Builder;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Util;
import java.util.Map;
import android.net.Uri;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

final class SessionDescription
{
    public final ImmutableMap<String, String> a;
    public final ImmutableList<MediaDescription> b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final Uri g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    
    private SessionDescription(final Builder builder) {
        this.a = (ImmutableMap<String, String>)ImmutableMap.copyOf((Map)Builder.a(builder));
        this.b = (ImmutableList<MediaDescription>)Builder.e(builder).l();
        this.c = Util.j(Builder.f(builder));
        this.d = Util.j(Builder.g(builder));
        this.e = Util.j(Builder.h(builder));
        this.g = Builder.i(builder);
        this.h = Builder.j(builder);
        this.f = Builder.k(builder);
        this.i = Builder.l(builder);
        this.j = Builder.b(builder);
        this.k = Builder.c(builder);
        this.l = Builder.d(builder);
    }
    
    SessionDescription(final Builder builder, final SessionDescription$a object) {
        this(builder);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && SessionDescription.class == o.getClass()) {
            final SessionDescription sessionDescription = (SessionDescription)o;
            if (this.f != sessionDescription.f || !this.a.equals((Object)sessionDescription.a) || !this.b.equals((Object)sessionDescription.b) || !Util.c(this.d, sessionDescription.d) || !Util.c(this.c, sessionDescription.c) || !Util.c(this.e, sessionDescription.e) || !Util.c(this.l, sessionDescription.l) || !Util.c(this.g, sessionDescription.g) || !Util.c(this.j, sessionDescription.j) || !Util.c(this.k, sessionDescription.k) || !Util.c(this.h, sessionDescription.h) || !Util.c(this.i, sessionDescription.i)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final String d = this.d;
        int hashCode3 = 0;
        int hashCode4;
        if (d == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = d.hashCode();
        }
        final String c = this.c;
        int hashCode5;
        if (c == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = c.hashCode();
        }
        final String e = this.e;
        int hashCode6;
        if (e == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = e.hashCode();
        }
        final int f = this.f;
        final String l = this.l;
        int hashCode7;
        if (l == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = l.hashCode();
        }
        final Uri g = this.g;
        int hashCode8;
        if (g == null) {
            hashCode8 = 0;
        }
        else {
            hashCode8 = g.hashCode();
        }
        final String j = this.j;
        int hashCode9;
        if (j == null) {
            hashCode9 = 0;
        }
        else {
            hashCode9 = j.hashCode();
        }
        final String k = this.k;
        int hashCode10;
        if (k == null) {
            hashCode10 = 0;
        }
        else {
            hashCode10 = k.hashCode();
        }
        final String h = this.h;
        int hashCode11;
        if (h == null) {
            hashCode11 = 0;
        }
        else {
            hashCode11 = h.hashCode();
        }
        final String i = this.i;
        if (i != null) {
            hashCode3 = i.hashCode();
        }
        return (((((((((((217 + hashCode) * 31 + hashCode2) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + f) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode10) * 31 + hashCode11) * 31 + hashCode3;
    }
    
    public static final class Builder
    {
        private final HashMap<String, String> a;
        private final ImmutableList$Builder<MediaDescription> b;
        private int c;
        private String d;
        private String e;
        private String f;
        private Uri g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        
        public Builder() {
            this.a = new HashMap<String, String>();
            this.b = (ImmutableList$Builder<MediaDescription>)new ImmutableList$Builder();
            this.c = -1;
        }
        
        static HashMap a(final Builder builder) {
            return builder.a;
        }
        
        static String b(final Builder builder) {
            return builder.k;
        }
        
        static String c(final Builder builder) {
            return builder.l;
        }
        
        static String d(final Builder builder) {
            return builder.j;
        }
        
        static ImmutableList$Builder e(final Builder builder) {
            return builder.b;
        }
        
        static String f(final Builder builder) {
            return builder.d;
        }
        
        static String g(final Builder builder) {
            return builder.e;
        }
        
        static String h(final Builder builder) {
            return builder.f;
        }
        
        static Uri i(final Builder builder) {
            return builder.g;
        }
        
        static String j(final Builder builder) {
            return builder.h;
        }
        
        static int k(final Builder builder) {
            return builder.c;
        }
        
        static String l(final Builder builder) {
            return builder.i;
        }
        
        public Builder m(final String s, final String s2) {
            this.a.put(s, s2);
            return this;
        }
        
        public Builder n(final MediaDescription mediaDescription) {
            this.b.i((Object)mediaDescription);
            return this;
        }
        
        public SessionDescription o() {
            return new SessionDescription(this, null);
        }
        
        public Builder p(final int c) {
            this.c = c;
            return this;
        }
        
        public Builder q(final String h) {
            this.h = h;
            return this;
        }
        
        public Builder r(final String k) {
            this.k = k;
            return this;
        }
        
        public Builder s(final String i) {
            this.i = i;
            return this;
        }
        
        public Builder t(final String e) {
            this.e = e;
            return this;
        }
        
        public Builder u(final String l) {
            this.l = l;
            return this;
        }
        
        public Builder v(final String j) {
            this.j = j;
            return this;
        }
        
        public Builder w(final String d) {
            this.d = d;
            return this;
        }
        
        public Builder x(final String f) {
            this.f = f;
            return this;
        }
        
        public Builder y(final Uri g) {
            this.g = g;
            return this;
        }
    }
}
