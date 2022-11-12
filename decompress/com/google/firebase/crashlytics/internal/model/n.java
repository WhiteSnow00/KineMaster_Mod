// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class n extends Exception
{
    private final String a;
    private final String b;
    private final ImmutableList<Thread.Frame> c;
    private final Exception d;
    private final int e;
    
    private n(final String a, final String b, final ImmutableList<Thread.Frame> c, final Exception d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    n(final String s, final String s2, final ImmutableList list, final Exception ex, final int n, final n$a object) {
        this(s, s2, list, ex, n);
    }
    
    @Override
    public Exception b() {
        return this.d;
    }
    
    @Override
    public ImmutableList<Thread.Frame> c() {
        return this.c;
    }
    
    @Override
    public int d() {
        return this.e;
    }
    
    @Override
    public String e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Exception) {
            final Exception ex = (Exception)o;
            if (this.a.equals(ex.f())) {
                final String b2 = this.b;
                if (b2 == null) {
                    if (ex.e() != null) {
                        return false;
                    }
                }
                else if (!b2.equals(ex.e())) {
                    return false;
                }
                if (this.c.equals(ex.c())) {
                    final Exception d = this.d;
                    if (d == null) {
                        if (ex.b() != null) {
                            return false;
                        }
                    }
                    else if (!d.equals(ex.b())) {
                        return false;
                    }
                    if (this.e == ex.d()) {
                        return b;
                    }
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.a;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final String b = this.b;
        int hashCode2 = 0;
        int hashCode3;
        if (b == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = b.hashCode();
        }
        final int hashCode4 = this.c.hashCode();
        final Exception d = this.d;
        if (d != null) {
            hashCode2 = d.hashCode();
        }
        return ((((hashCode ^ 0xF4243) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4) * 1000003 ^ hashCode2) * 1000003 ^ this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Exception{type=");
        sb.append(this.a);
        sb.append(", reason=");
        sb.append(this.b);
        sb.append(", frames=");
        sb.append(this.c);
        sb.append(", causedBy=");
        sb.append(this.d);
        sb.append(", overflowCount=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        private ImmutableList<Thread.Frame> c;
        private Exception d;
        private Integer e;
        
        @Override
        public Exception a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" type");
                string = sb.toString();
            }
            String string2 = string;
            if (this.c == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" frames");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.e == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" overflowCount");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new n(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Missing required properties:");
            sb4.append(string3);
            throw new IllegalStateException(sb4.toString());
        }
        
        @Override
        public Builder b(final Exception d) {
            this.d = d;
            return this;
        }
        
        @Override
        public Builder c(final ImmutableList<Thread.Frame> c) {
            Objects.requireNonNull(c, "Null frames");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder d(final int n) {
            this.e = n;
            return this;
        }
        
        @Override
        public Builder e(final String b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder f(final String a) {
            Objects.requireNonNull(a, "Null type");
            this.a = a;
            return this;
        }
    }
}
