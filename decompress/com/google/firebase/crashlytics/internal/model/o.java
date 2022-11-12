// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class o extends Signal
{
    private final String a;
    private final String b;
    private final long c;
    
    private o(final String a, final String b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    o(final String s, final String s2, final long n, final o$a object) {
        this(s, s2, n);
    }
    
    @Override
    public long b() {
        return this.c;
    }
    
    @Override
    public String c() {
        return this.b;
    }
    
    @Override
    public String d() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Signal) {
            final Signal signal = (Signal)o;
            if (!this.a.equals(signal.d()) || !this.b.equals(signal.c()) || this.c != signal.b()) {
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
        final long c = this.c;
        return ((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ (int)(c ^ c >>> 32);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Signal{name=");
        sb.append(this.a);
        sb.append(", code=");
        sb.append(this.b);
        sb.append(", address=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        private Long c;
        
        @Override
        public Signal a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" name");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" code");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" address");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new o(this.a, this.b, this.c, null);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Missing required properties:");
            sb4.append(string3);
            throw new IllegalStateException(sb4.toString());
        }
        
        @Override
        public Builder b(final long n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder c(final String b) {
            Objects.requireNonNull(b, "Null code");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder d(final String a) {
            Objects.requireNonNull(a, "Null name");
            this.a = a;
            return this;
        }
    }
}
