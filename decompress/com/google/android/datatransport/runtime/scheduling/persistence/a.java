// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

final class a extends c
{
    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;
    
    private a(final long b, final int c, final int d, final long e, final int f) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    a(final long n, final int n2, final int n3, final long n4, final int n5, final a$a object) {
        this(n, n2, n3, n4, n5);
    }
    
    @Override
    int b() {
        return this.d;
    }
    
    @Override
    long c() {
        return this.e;
    }
    
    @Override
    int d() {
        return this.c;
    }
    
    @Override
    int e() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof c) {
            final c c = (c)o;
            if (this.b != c.f() || this.c != c.d() || this.d != c.b() || this.e != c.c() || this.f != c.e()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    long f() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        final long b = this.b;
        final int n = (int)(b ^ b >>> 32);
        final int c = this.c;
        final int d = this.d;
        final long e = this.e;
        return ((((n ^ 0xF4243) * 1000003 ^ c) * 1000003 ^ d) * 1000003 ^ (int)(e >>> 32 ^ e)) * 1000003 ^ this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.b);
        sb.append(", loadBatchSize=");
        sb.append(this.c);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.d);
        sb.append(", eventCleanUpAge=");
        sb.append(this.e);
        sb.append(", maxBlobByteSizePerRow=");
        sb.append(this.f);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends c.a
    {
        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;
        
        @Override
        c a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" maxStorageSizeInBytes");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" loadBatchSize");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" criticalSectionEnterTimeoutMs");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" eventCleanUpAge");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.e == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" maxBlobByteSizePerRow");
                string5 = sb5.toString();
            }
            if (string5.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("Missing required properties:");
            sb6.append(string5);
            throw new IllegalStateException(sb6.toString());
        }
        
        @Override
        c.a b(final int n) {
            this.c = n;
            return this;
        }
        
        @Override
        c.a c(final long n) {
            this.d = n;
            return this;
        }
        
        @Override
        c.a d(final int n) {
            this.b = n;
            return this;
        }
        
        @Override
        c.a e(final int n) {
            this.e = n;
            return this;
        }
        
        @Override
        c.a f(final long n) {
            this.a = n;
            return this;
        }
    }
}
