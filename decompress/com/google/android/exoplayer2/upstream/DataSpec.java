// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.Collections;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.util.Map;
import android.net.Uri;

public final class DataSpec
{
    public final Uri a;
    public final long b;
    public final int c;
    public final byte[] d;
    public final Map<String, String> e;
    @Deprecated
    public final long f;
    public final long g;
    public final long h;
    public final String i;
    public final int j;
    public final Object k;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.datasource");
    }
    
    public DataSpec(final Uri uri) {
        this(uri, 0L, -1L);
    }
    
    private DataSpec(final Uri a, final long b, final int c, byte[] d, final Map<String, String> map, final long g, final long h, final String i, final int j, final Object k) {
        final long f = b + g;
        final boolean b2 = true;
        Assertions.a(f >= 0L);
        Assertions.a(g >= 0L);
        boolean b3 = b2;
        if (h <= 0L) {
            b3 = (h == -1L && b2);
        }
        Assertions.a(b3);
        this.a = a;
        this.b = b;
        this.c = c;
        if (d == null || d.length == 0) {
            d = null;
        }
        this.d = d;
        this.e = Collections.unmodifiableMap((Map<? extends String, ? extends String>)new HashMap<String, String>(map));
        this.g = g;
        this.f = f;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
    }
    
    DataSpec(final Uri uri, final long n, final int n2, final byte[] array, final Map map, final long n3, final long n4, final String s, final int n5, final Object o, final DataSpec$a object) {
        this(uri, n, n2, array, map, n3, n4, s, n5, o);
    }
    
    public DataSpec(final Uri uri, final long n, final long n2) {
        this(uri, 0L, 1, null, Collections.emptyMap(), n, n2, null, 0, null);
    }
    
    public static String c(final int n) {
        if (n == 1) {
            return "GET";
        }
        if (n == 2) {
            return "POST";
        }
        if (n == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }
    
    public Builder a() {
        return new Builder(this, null);
    }
    
    public final String b() {
        return c(this.c);
    }
    
    public boolean d(final int n) {
        return (this.j & n) == n;
    }
    
    public DataSpec e(final long n) {
        final long h = this.h;
        long n2 = -1L;
        if (h != -1L) {
            n2 = h - n;
        }
        return this.f(n, n2);
    }
    
    public DataSpec f(final long n, final long n2) {
        if (n == 0L && this.h == n2) {
            return this;
        }
        return new DataSpec(this.a, this.b, this.c, this.d, this.e, this.g + n, n2, this.i, this.j, this.k);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DataSpec[");
        sb.append(this.b());
        sb.append(" ");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.g);
        sb.append(", ");
        sb.append(this.h);
        sb.append(", ");
        sb.append(this.i);
        sb.append(", ");
        sb.append(this.j);
        sb.append("]");
        return sb.toString();
    }
    
    public static final class Builder
    {
        private Uri a;
        private long b;
        private int c;
        private byte[] d;
        private Map<String, String> e;
        private long f;
        private long g;
        private String h;
        private int i;
        private Object j;
        
        public Builder() {
            this.c = 1;
            this.e = Collections.emptyMap();
            this.g = -1L;
        }
        
        private Builder(final DataSpec dataSpec) {
            this.a = dataSpec.a;
            this.b = dataSpec.b;
            this.c = dataSpec.c;
            this.d = dataSpec.d;
            this.e = dataSpec.e;
            this.f = dataSpec.g;
            this.g = dataSpec.h;
            this.h = dataSpec.i;
            this.i = dataSpec.j;
            this.j = dataSpec.k;
        }
        
        Builder(final DataSpec dataSpec, final DataSpec$a object) {
            this(dataSpec);
        }
        
        public DataSpec a() {
            Assertions.j(this.a, "The uri must be set.");
            return new DataSpec(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }
        
        public Builder b(final int i) {
            this.i = i;
            return this;
        }
        
        public Builder c(final byte[] d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final int c) {
            this.c = c;
            return this;
        }
        
        public Builder e(final Map<String, String> e) {
            this.e = e;
            return this;
        }
        
        public Builder f(final String h) {
            this.h = h;
            return this;
        }
        
        public Builder g(final long g) {
            this.g = g;
            return this;
        }
        
        public Builder h(final long f) {
            this.f = f;
            return this;
        }
        
        public Builder i(final Uri a) {
            this.a = a;
            return this;
        }
        
        public Builder j(final String s) {
            this.a = Uri.parse(s);
            return this;
        }
        
        public Builder k(final long b) {
            this.b = b;
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface HttpMethod {
    }
}
