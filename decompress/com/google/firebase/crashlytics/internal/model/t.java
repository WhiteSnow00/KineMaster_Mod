// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class t extends OperatingSystem
{
    private final int a;
    private final String b;
    private final String c;
    private final boolean d;
    
    private t(final int a, final String b, final String c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    t(final int n, final String s, final String s2, final boolean b, final t$a object) {
        this(n, s, s2, b);
    }
    
    @Override
    public String b() {
        return this.c;
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
    public boolean e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof OperatingSystem) {
            final OperatingSystem operatingSystem = (OperatingSystem)o;
            if (this.a != operatingSystem.c() || !this.b.equals(operatingSystem.d()) || !this.c.equals(operatingSystem.b()) || this.d != operatingSystem.e()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        final int hashCode = this.b.hashCode();
        final int hashCode2 = this.c.hashCode();
        int n;
        if (this.d) {
            n = 1231;
        }
        else {
            n = 1237;
        }
        return (((a ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ hashCode2) * 1000003 ^ n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OperatingSystem{platform=");
        sb.append(this.a);
        sb.append(", version=");
        sb.append(this.b);
        sb.append(", buildVersion=");
        sb.append(this.c);
        sb.append(", jailbroken=");
        sb.append(this.d);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Integer a;
        private String b;
        private String c;
        private Boolean d;
        
        @Override
        public OperatingSystem a() {
            final Integer a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" platform");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" version");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" buildVersion");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" jailbroken");
                string4 = sb4.toString();
            }
            if (string4.isEmpty()) {
                return new t(this.a, this.b, this.c, this.d, null);
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("Missing required properties:");
            sb5.append(string4);
            throw new IllegalStateException(sb5.toString());
        }
        
        @Override
        public Builder b(final String c) {
            Objects.requireNonNull(c, "Null buildVersion");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final boolean b) {
            this.d = b;
            return this;
        }
        
        @Override
        public Builder d(final int n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder e(final String b) {
            Objects.requireNonNull(b, "Null version");
            this.b = b;
            return this;
        }
    }
}
