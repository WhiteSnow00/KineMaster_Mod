// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import java.util.Objects;
import java.util.Map;

final class a extends EventInternal
{
    private final String a;
    private final Integer b;
    private final EncodedPayload c;
    private final long d;
    private final long e;
    private final Map<String, String> f;
    
    private a(final String a, final Integer b, final EncodedPayload c, final long d, final long e, final Map<String, String> f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    a(final String s, final Integer n, final EncodedPayload encodedPayload, final long n2, final long n3, final Map map, final a$a object) {
        this(s, n, encodedPayload, n2, n3, map);
    }
    
    @Override
    protected Map<String, String> c() {
        return this.f;
    }
    
    @Override
    public Integer d() {
        return this.b;
    }
    
    @Override
    public EncodedPayload e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof EventInternal) {
            final EventInternal eventInternal = (EventInternal)o;
            if (this.a.equals(eventInternal.j())) {
                final Integer b2 = this.b;
                if (b2 == null) {
                    if (eventInternal.d() != null) {
                        return false;
                    }
                }
                else if (!b2.equals(eventInternal.d())) {
                    return false;
                }
                if (this.c.equals(eventInternal.e()) && this.d == eventInternal.f() && this.e == eventInternal.k() && this.f.equals(eventInternal.c())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public long f() {
        return this.d;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final Integer b = this.b;
        int hashCode2;
        if (b == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = b.hashCode();
        }
        final int hashCode3 = this.c.hashCode();
        final long d = this.d;
        final int n = (int)(d ^ d >>> 32);
        final long e = this.e;
        return (((((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ hashCode3) * 1000003 ^ n) * 1000003 ^ (int)(e ^ e >>> 32)) * 1000003 ^ this.f.hashCode();
    }
    
    @Override
    public String j() {
        return this.a;
    }
    
    @Override
    public long k() {
        return this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EventInternal{transportName=");
        sb.append(this.a);
        sb.append(", code=");
        sb.append(this.b);
        sb.append(", encodedPayload=");
        sb.append(this.c);
        sb.append(", eventMillis=");
        sb.append(this.d);
        sb.append(", uptimeMillis=");
        sb.append(this.e);
        sb.append(", autoMetadata=");
        sb.append(this.f);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private Integer b;
        private EncodedPayload c;
        private Long d;
        private Long e;
        private Map<String, String> f;
        
        @Override
        public EventInternal d() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" transportName");
                string = sb.toString();
            }
            String string2 = string;
            if (this.c == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" encodedPayload");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.d == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" eventMillis");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.e == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" uptimeMillis");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.f == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" autoMetadata");
                string5 = sb5.toString();
            }
            if (string5.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e, this.f, null);
            }
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("Missing required properties:");
            sb6.append(string5);
            throw new IllegalStateException(sb6.toString());
        }
        
        @Override
        protected Map<String, String> e() {
            final Map<String, String> f = this.f;
            if (f != null) {
                return f;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        
        @Override
        protected Builder f(final Map<String, String> f) {
            Objects.requireNonNull(f, "Null autoMetadata");
            this.f = f;
            return this;
        }
        
        @Override
        public Builder g(final Integer b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder h(final EncodedPayload c) {
            Objects.requireNonNull(c, "Null encodedPayload");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder i(final long n) {
            this.d = n;
            return this;
        }
        
        @Override
        public Builder j(final String a) {
            Objects.requireNonNull(a, "Null transportName");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder k(final long n) {
            this.e = n;
            return this;
        }
    }
}
