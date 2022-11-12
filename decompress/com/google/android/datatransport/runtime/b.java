// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import java.util.Objects;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Event;

final class b extends SendRequest
{
    private final TransportContext a;
    private final String b;
    private final Event<?> c;
    private final Transformer<?, byte[]> d;
    private final Encoding e;
    
    private b(final TransportContext a, final String b, final Event<?> c, final Transformer<?, byte[]> d, final Encoding e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    b(final TransportContext transportContext, final String s, final Event event, final Transformer transformer, final Encoding encoding, final b$a object) {
        this(transportContext, s, event, transformer, encoding);
    }
    
    @Override
    public Encoding b() {
        return this.e;
    }
    
    @Override
    Event<?> c() {
        return this.c;
    }
    
    @Override
    Transformer<?, byte[]> e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof SendRequest) {
            final SendRequest sendRequest = (SendRequest)o;
            if (!this.a.equals(sendRequest.f()) || !this.b.equals(sendRequest.g()) || !this.c.equals(sendRequest.c()) || !this.d.equals(sendRequest.e()) || !this.e.equals(sendRequest.b())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public TransportContext f() {
        return this.a;
    }
    
    @Override
    public String g() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        return ((((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SendRequest{transportContext=");
        sb.append(this.a);
        sb.append(", transportName=");
        sb.append(this.b);
        sb.append(", event=");
        sb.append(this.c);
        sb.append(", transformer=");
        sb.append(this.d);
        sb.append(", encoding=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private TransportContext a;
        private String b;
        private Event<?> c;
        private Transformer<?, byte[]> d;
        private Encoding e;
        
        @Override
        public SendRequest a() {
            final TransportContext a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" transportContext");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" transportName");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" event");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" transformer");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.e == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" encoding");
                string5 = sb5.toString();
            }
            if (string5.isEmpty()) {
                return new com.google.android.datatransport.runtime.b(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("Missing required properties:");
            sb6.append(string5);
            throw new IllegalStateException(sb6.toString());
        }
        
        @Override
        Builder b(final Encoding e) {
            Objects.requireNonNull(e, "Null encoding");
            this.e = e;
            return this;
        }
        
        @Override
        Builder c(final Event<?> c) {
            Objects.requireNonNull(c, "Null event");
            this.c = c;
            return this;
        }
        
        @Override
        Builder d(final Transformer<?, byte[]> d) {
            Objects.requireNonNull(d, "Null transformer");
            this.d = d;
            return this;
        }
        
        @Override
        public Builder e(final TransportContext a) {
            Objects.requireNonNull(a, "Null transportContext");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder f(final String b) {
            Objects.requireNonNull(b, "Null transportName");
            this.b = b;
            return this;
        }
    }
}
