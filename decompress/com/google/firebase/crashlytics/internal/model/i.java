// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class i extends Device
{
    private final int a;
    private final String b;
    private final int c;
    private final long d;
    private final long e;
    private final boolean f;
    private final int g;
    private final String h;
    private final String i;
    
    private i(final int a, final String b, final int c, final long d, final long e, final boolean f, final int g, final String h, final String i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    i(final int n, final String s, final int n2, final long n3, final long n4, final boolean b, final int n5, final String s2, final String s3, final i$a object) {
        this(n, s, n2, n3, n4, b, n5, s2, s3);
    }
    
    @Override
    public int b() {
        return this.a;
    }
    
    @Override
    public int c() {
        return this.c;
    }
    
    @Override
    public long d() {
        return this.e;
    }
    
    @Override
    public String e() {
        return this.h;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Device) {
            final Device device = (Device)o;
            if (this.a != device.b() || !this.b.equals(device.f()) || this.c != device.c() || this.d != device.h() || this.e != device.d() || this.f != device.j() || this.g != device.i() || !this.h.equals(device.e()) || !this.i.equals(device.g())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.b;
    }
    
    @Override
    public String g() {
        return this.i;
    }
    
    @Override
    public long h() {
        return this.d;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        final int hashCode = this.b.hashCode();
        final int c = this.c;
        final long d = this.d;
        final int n = (int)(d ^ d >>> 32);
        final long e = this.e;
        final int n2 = (int)(e ^ e >>> 32);
        int n3;
        if (this.f) {
            n3 = 1231;
        }
        else {
            n3 = 1237;
        }
        return ((((((((a ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ c) * 1000003 ^ n) * 1000003 ^ n2) * 1000003 ^ n3) * 1000003 ^ this.g) * 1000003 ^ this.h.hashCode()) * 1000003 ^ this.i.hashCode();
    }
    
    @Override
    public int i() {
        return this.g;
    }
    
    @Override
    public boolean j() {
        return this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Device{arch=");
        sb.append(this.a);
        sb.append(", model=");
        sb.append(this.b);
        sb.append(", cores=");
        sb.append(this.c);
        sb.append(", ram=");
        sb.append(this.d);
        sb.append(", diskSpace=");
        sb.append(this.e);
        sb.append(", simulator=");
        sb.append(this.f);
        sb.append(", state=");
        sb.append(this.g);
        sb.append(", manufacturer=");
        sb.append(this.h);
        sb.append(", modelClass=");
        sb.append(this.i);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Integer a;
        private String b;
        private Integer c;
        private Long d;
        private Long e;
        private Boolean f;
        private Integer g;
        private String h;
        private String i;
        
        @Override
        public Device a() {
            final Integer a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" arch");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" model");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" cores");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" ram");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.e == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" diskSpace");
                string5 = sb5.toString();
            }
            String string6 = string5;
            if (this.f == null) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(string5);
                sb6.append(" simulator");
                string6 = sb6.toString();
            }
            String string7 = string6;
            if (this.g == null) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append(string6);
                sb7.append(" state");
                string7 = sb7.toString();
            }
            String string8 = string7;
            if (this.h == null) {
                final StringBuilder sb8 = new StringBuilder();
                sb8.append(string7);
                sb8.append(" manufacturer");
                string8 = sb8.toString();
            }
            String string9 = string8;
            if (this.i == null) {
                final StringBuilder sb9 = new StringBuilder();
                sb9.append(string8);
                sb9.append(" modelClass");
                string9 = sb9.toString();
            }
            if (string9.isEmpty()) {
                return new i(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
            }
            final StringBuilder sb10 = new StringBuilder();
            sb10.append("Missing required properties:");
            sb10.append(string9);
            throw new IllegalStateException(sb10.toString());
        }
        
        @Override
        public Builder b(final int n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder c(final int n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder d(final long n) {
            this.e = n;
            return this;
        }
        
        @Override
        public Builder e(final String h) {
            Objects.requireNonNull(h, "Null manufacturer");
            this.h = h;
            return this;
        }
        
        @Override
        public Builder f(final String b) {
            Objects.requireNonNull(b, "Null model");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder g(final String i) {
            Objects.requireNonNull(i, "Null modelClass");
            this.i = i;
            return this;
        }
        
        @Override
        public Builder h(final long n) {
            this.d = n;
            return this;
        }
        
        @Override
        public Builder i(final boolean b) {
            this.f = b;
            return this;
        }
        
        @Override
        public Builder j(final int n) {
            this.g = n;
            return this;
        }
    }
}
