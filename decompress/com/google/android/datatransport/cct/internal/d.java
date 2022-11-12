// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import java.util.Arrays;

final class d extends LogEvent
{
    private final long a;
    private final Integer b;
    private final long c;
    private final byte[] d;
    private final String e;
    private final long f;
    private final NetworkConnectionInfo g;
    
    private d(final long a, final Integer b, final long c, final byte[] d, final String e, final long f, final NetworkConnectionInfo g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    d(final long n, final Integer n2, final long n3, final byte[] array, final String s, final long n4, final NetworkConnectionInfo networkConnectionInfo, final d$a object) {
        this(n, n2, n3, array, s, n4, networkConnectionInfo);
    }
    
    @Override
    public Integer b() {
        return this.b;
    }
    
    @Override
    public long c() {
        return this.a;
    }
    
    @Override
    public long d() {
        return this.c;
    }
    
    @Override
    public NetworkConnectionInfo e() {
        return this.g;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof LogEvent) {
            final LogEvent logEvent = (LogEvent)o;
            if (this.a == logEvent.c()) {
                final Integer b2 = this.b;
                if (b2 == null) {
                    if (logEvent.b() != null) {
                        return false;
                    }
                }
                else if (!b2.equals(logEvent.b())) {
                    return false;
                }
                if (this.c == logEvent.d()) {
                    final byte[] d = this.d;
                    byte[] array;
                    if (logEvent instanceof d) {
                        array = ((d)logEvent).d;
                    }
                    else {
                        array = logEvent.f();
                    }
                    if (Arrays.equals(d, array)) {
                        final String e = this.e;
                        if (e == null) {
                            if (logEvent.g() != null) {
                                return false;
                            }
                        }
                        else if (!e.equals(logEvent.g())) {
                            return false;
                        }
                        if (this.f == logEvent.h()) {
                            final NetworkConnectionInfo g = this.g;
                            if (g == null) {
                                if (logEvent.e() == null) {
                                    return b;
                                }
                            }
                            else if (g.equals(logEvent.e())) {
                                return b;
                            }
                        }
                    }
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public byte[] f() {
        return this.d;
    }
    
    @Override
    public String g() {
        return this.e;
    }
    
    @Override
    public long h() {
        return this.f;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final Integer b = this.b;
        int hashCode = 0;
        int hashCode2;
        if (b == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = b.hashCode();
        }
        final long c = this.c;
        final int n2 = (int)(c ^ c >>> 32);
        final int hashCode3 = Arrays.hashCode(this.d);
        final String e = this.e;
        int hashCode4;
        if (e == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = e.hashCode();
        }
        final long f = this.f;
        final int n3 = (int)(f >>> 32 ^ f);
        final NetworkConnectionInfo g = this.g;
        if (g != null) {
            hashCode = g.hashCode();
        }
        return ((((((n ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ n2) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4) * 1000003 ^ n3) * 1000003 ^ hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LogEvent{eventTimeMs=");
        sb.append(this.a);
        sb.append(", eventCode=");
        sb.append(this.b);
        sb.append(", eventUptimeMs=");
        sb.append(this.c);
        sb.append(", sourceExtension=");
        sb.append(Arrays.toString(this.d));
        sb.append(", sourceExtensionJsonProto3=");
        sb.append(this.e);
        sb.append(", timezoneOffsetSeconds=");
        sb.append(this.f);
        sb.append(", networkConnectionInfo=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private Integer b;
        private Long c;
        private byte[] d;
        private String e;
        private Long f;
        private NetworkConnectionInfo g;
        
        @Override
        public LogEvent a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" eventTimeMs");
                string = sb.toString();
            }
            String string2 = string;
            if (this.c == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" eventUptimeMs");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.f == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" timezoneOffsetSeconds");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Missing required properties:");
            sb4.append(string3);
            throw new IllegalStateException(sb4.toString());
        }
        
        @Override
        public Builder b(final Integer b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder c(final long n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder d(final long n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder e(final NetworkConnectionInfo g) {
            this.g = g;
            return this;
        }
        
        @Override
        Builder f(final byte[] d) {
            this.d = d;
            return this;
        }
        
        @Override
        Builder g(final String e) {
            this.e = e;
            return this;
        }
        
        @Override
        public Builder h(final long n) {
            this.f = n;
            return this;
        }
    }
}
