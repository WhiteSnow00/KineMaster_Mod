// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class b extends ApplicationExitInfo
{
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final long e;
    private final long f;
    private final long g;
    private final String h;
    
    private b(final int a, final String b, final int c, final int d, final long e, final long f, final long g, final String h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    b(final int n, final String s, final int n2, final int n3, final long n4, final long n5, final long n6, final String s2, final b$a object) {
        this(n, s, n2, n3, n4, n5, n6, s2);
    }
    
    @Override
    public int b() {
        return this.d;
    }
    
    @Override
    public int c() {
        return this.a;
    }
    
    @Override
    public String d() {
        return this.b;
    }
    
    @Override
    public long e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof ApplicationExitInfo) {
            final ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo)o;
            if (this.a == applicationExitInfo.c() && this.b.equals(applicationExitInfo.d()) && this.c == applicationExitInfo.f() && this.d == applicationExitInfo.b() && this.e == applicationExitInfo.e() && this.f == applicationExitInfo.g() && this.g == applicationExitInfo.h()) {
                final String h = this.h;
                if (h == null) {
                    if (applicationExitInfo.i() == null) {
                        return b;
                    }
                }
                else if (h.equals(applicationExitInfo.i())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int f() {
        return this.c;
    }
    
    @Override
    public long g() {
        return this.f;
    }
    
    @Override
    public long h() {
        return this.g;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        final int hashCode = this.b.hashCode();
        final int c = this.c;
        final int d = this.d;
        final long e = this.e;
        final int n = (int)(e ^ e >>> 32);
        final long f = this.f;
        final int n2 = (int)(f ^ f >>> 32);
        final long g = this.g;
        final int n3 = (int)(g ^ g >>> 32);
        final String h = this.h;
        int hashCode2;
        if (h == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = h.hashCode();
        }
        return (((((((a ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ c) * 1000003 ^ d) * 1000003 ^ n) * 1000003 ^ n2) * 1000003 ^ n3) * 1000003 ^ hashCode2;
    }
    
    @Override
    public String i() {
        return this.h;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ApplicationExitInfo{pid=");
        sb.append(this.a);
        sb.append(", processName=");
        sb.append(this.b);
        sb.append(", reasonCode=");
        sb.append(this.c);
        sb.append(", importance=");
        sb.append(this.d);
        sb.append(", pss=");
        sb.append(this.e);
        sb.append(", rss=");
        sb.append(this.f);
        sb.append(", timestamp=");
        sb.append(this.g);
        sb.append(", traceFile=");
        sb.append(this.h);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Integer a;
        private String b;
        private Integer c;
        private Integer d;
        private Long e;
        private Long f;
        private Long g;
        private String h;
        
        @Override
        public ApplicationExitInfo a() {
            final Integer a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" pid");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" processName");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" reasonCode");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" importance");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.e == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" pss");
                string5 = sb5.toString();
            }
            String string6 = string5;
            if (this.f == null) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(string5);
                sb6.append(" rss");
                string6 = sb6.toString();
            }
            String string7 = string6;
            if (this.g == null) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append(string6);
                sb7.append(" timestamp");
                string7 = sb7.toString();
            }
            if (string7.isEmpty()) {
                return new com.google.firebase.crashlytics.internal.model.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
            }
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("Missing required properties:");
            sb8.append(string7);
            throw new IllegalStateException(sb8.toString());
        }
        
        @Override
        public Builder b(final int n) {
            this.d = n;
            return this;
        }
        
        @Override
        public Builder c(final int n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder d(final String b) {
            Objects.requireNonNull(b, "Null processName");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder e(final long n) {
            this.e = n;
            return this;
        }
        
        @Override
        public Builder f(final int n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder g(final long n) {
            this.f = n;
            return this;
        }
        
        @Override
        public Builder h(final long n) {
            this.g = n;
            return this;
        }
        
        @Override
        public Builder i(final String h) {
            this.h = h;
            return this;
        }
    }
}
