// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable$Field;
import java.util.List;

final class e extends LogRequest
{
    private final long a;
    private final long b;
    private final ClientInfo c;
    private final Integer d;
    private final String e;
    private final List<LogEvent> f;
    private final QosTier g;
    
    private e(final long a, final long b, final ClientInfo c, final Integer d, final String e, final List<LogEvent> f, final QosTier g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    e(final long n, final long n2, final ClientInfo clientInfo, final Integer n3, final String s, final List list, final QosTier qosTier, final e$a object) {
        this(n, n2, clientInfo, n3, s, list, qosTier);
    }
    
    @Override
    public ClientInfo b() {
        return this.c;
    }
    
    @Encodable$Field
    @Override
    public List<LogEvent> c() {
        return this.f;
    }
    
    @Override
    public Integer d() {
        return this.d;
    }
    
    @Override
    public String e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof LogRequest) {
            final LogRequest logRequest = (LogRequest)o;
            if (this.a == logRequest.g() && this.b == logRequest.h()) {
                final ClientInfo c = this.c;
                if (c == null) {
                    if (logRequest.b() != null) {
                        return false;
                    }
                }
                else if (!c.equals(logRequest.b())) {
                    return false;
                }
                final Integer d = this.d;
                if (d == null) {
                    if (logRequest.d() != null) {
                        return false;
                    }
                }
                else if (!d.equals(logRequest.d())) {
                    return false;
                }
                final String e = this.e;
                if (e == null) {
                    if (logRequest.e() != null) {
                        return false;
                    }
                }
                else if (!e.equals(logRequest.e())) {
                    return false;
                }
                final List<LogEvent> f = this.f;
                if (f == null) {
                    if (logRequest.c() != null) {
                        return false;
                    }
                }
                else if (!f.equals(logRequest.c())) {
                    return false;
                }
                final QosTier g = this.g;
                if (g == null) {
                    if (logRequest.f() == null) {
                        return b;
                    }
                }
                else if (g.equals(logRequest.f())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public QosTier f() {
        return this.g;
    }
    
    @Override
    public long g() {
        return this.a;
    }
    
    @Override
    public long h() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final long b = this.b;
        final int n2 = (int)(b >>> 32 ^ b);
        final ClientInfo c = this.c;
        int hashCode = 0;
        int hashCode2;
        if (c == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = c.hashCode();
        }
        final Integer d = this.d;
        int hashCode3;
        if (d == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = d.hashCode();
        }
        final String e = this.e;
        int hashCode4;
        if (e == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = e.hashCode();
        }
        final List<LogEvent> f = this.f;
        int hashCode5;
        if (f == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = f.hashCode();
        }
        final QosTier g = this.g;
        if (g != null) {
            hashCode = g.hashCode();
        }
        return ((((((n ^ 0xF4243) * 1000003 ^ n2) * 1000003 ^ hashCode2) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4) * 1000003 ^ hashCode5) * 1000003 ^ hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LogRequest{requestTimeMs=");
        sb.append(this.a);
        sb.append(", requestUptimeMs=");
        sb.append(this.b);
        sb.append(", clientInfo=");
        sb.append(this.c);
        sb.append(", logSource=");
        sb.append(this.d);
        sb.append(", logSourceName=");
        sb.append(this.e);
        sb.append(", logEvents=");
        sb.append(this.f);
        sb.append(", qosTier=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private Long b;
        private ClientInfo c;
        private Integer d;
        private String e;
        private List<LogEvent> f;
        private QosTier g;
        
        @Override
        public LogRequest a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" requestTimeMs");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" requestUptimeMs");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final ClientInfo c) {
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final List<LogEvent> f) {
            this.f = f;
            return this;
        }
        
        @Override
        Builder d(final Integer d) {
            this.d = d;
            return this;
        }
        
        @Override
        Builder e(final String e) {
            this.e = e;
            return this;
        }
        
        @Override
        public Builder f(final QosTier g) {
            this.g = g;
            return this;
        }
        
        @Override
        public Builder g(final long n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder h(final long n) {
            this.b = n;
            return this;
        }
    }
}
