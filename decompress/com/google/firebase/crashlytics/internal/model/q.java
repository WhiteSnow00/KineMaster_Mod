// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class q extends Frame
{
    private final long a;
    private final String b;
    private final String c;
    private final long d;
    private final int e;
    
    private q(final long a, final String b, final String c, final long d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    q(final long n, final String s, final String s2, final long n2, final int n3, final q$a object) {
        this(n, s, s2, n2, n3);
    }
    
    @Override
    public String b() {
        return this.c;
    }
    
    @Override
    public int c() {
        return this.e;
    }
    
    @Override
    public long d() {
        return this.d;
    }
    
    @Override
    public long e() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Frame) {
            final Frame frame = (Frame)o;
            if (this.a == frame.e() && this.b.equals(frame.f())) {
                final String c = this.c;
                if (c == null) {
                    if (frame.b() != null) {
                        return false;
                    }
                }
                else if (!c.equals(frame.b())) {
                    return false;
                }
                if (this.d == frame.d() && this.e == frame.c()) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final int hashCode = this.b.hashCode();
        final String c = this.c;
        int hashCode2;
        if (c == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = c.hashCode();
        }
        final long d = this.d;
        return ((((n ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ hashCode2) * 1000003 ^ (int)(d >>> 32 ^ d)) * 1000003 ^ this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Frame{pc=");
        sb.append(this.a);
        sb.append(", symbol=");
        sb.append(this.b);
        sb.append(", file=");
        sb.append(this.c);
        sb.append(", offset=");
        sb.append(this.d);
        sb.append(", importance=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private String b;
        private String c;
        private Long d;
        private Integer e;
        
        @Override
        public Frame a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" pc");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" symbol");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.d == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" offset");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.e == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" importance");
                string4 = sb4.toString();
            }
            if (string4.isEmpty()) {
                return new q(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("Missing required properties:");
            sb5.append(string4);
            throw new IllegalStateException(sb5.toString());
        }
        
        @Override
        public Builder b(final String c) {
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final int n) {
            this.e = n;
            return this;
        }
        
        @Override
        public Builder d(final long n) {
            this.d = n;
            return this;
        }
        
        @Override
        public Builder e(final long n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder f(final String b) {
            Objects.requireNonNull(b, "Null symbol");
            this.b = b;
            return this;
        }
    }
}
