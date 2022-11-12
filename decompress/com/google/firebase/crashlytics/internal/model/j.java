// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class j extends Event
{
    private final long a;
    private final String b;
    private final Application c;
    private final Device d;
    private final Log e;
    
    private j(final long a, final String b, final Application c, final Device d, final Log e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    j(final long n, final String s, final Application application, final Device device, final Log log, final j$a object) {
        this(n, s, application, device, log);
    }
    
    @Override
    public Application b() {
        return this.c;
    }
    
    @Override
    public Device c() {
        return this.d;
    }
    
    @Override
    public Log d() {
        return this.e;
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
        if (o instanceof Event) {
            final Event event = (Event)o;
            if (this.a == event.e() && this.b.equals(event.f()) && this.c.equals(event.b()) && this.d.equals(event.c())) {
                final Log e = this.e;
                if (e == null) {
                    if (event.d() == null) {
                        return b;
                    }
                }
                else if (e.equals(event.d())) {
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
    public Builder g() {
        return new b(this, null);
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final int hashCode = this.b.hashCode();
        final int hashCode2 = this.c.hashCode();
        final int hashCode3 = this.d.hashCode();
        final Log e = this.e;
        int hashCode4;
        if (e == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = e.hashCode();
        }
        return ((((n ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ hashCode2) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Event{timestamp=");
        sb.append(this.a);
        sb.append(", type=");
        sb.append(this.b);
        sb.append(", app=");
        sb.append(this.c);
        sb.append(", device=");
        sb.append(this.d);
        sb.append(", log=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private String b;
        private Application c;
        private Device d;
        private Log e;
        
        b() {
        }
        
        private b(final Event event) {
            this.a = event.e();
            this.b = event.f();
            this.c = event.b();
            this.d = event.c();
            this.e = event.d();
        }
        
        b(final Event event, final j$a object) {
            this(event);
        }
        
        @Override
        public Event a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" timestamp");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" type");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" app");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" device");
                string4 = sb4.toString();
            }
            if (string4.isEmpty()) {
                return new j(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("Missing required properties:");
            sb5.append(string4);
            throw new IllegalStateException(sb5.toString());
        }
        
        @Override
        public Builder b(final Application c) {
            Objects.requireNonNull(c, "Null app");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final Device d) {
            Objects.requireNonNull(d, "Null device");
            this.d = d;
            return this;
        }
        
        @Override
        public Builder d(final Log e) {
            this.e = e;
            return this;
        }
        
        @Override
        public Builder e(final long n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder f(final String b) {
            Objects.requireNonNull(b, "Null type");
            this.b = b;
            return this;
        }
    }
}
