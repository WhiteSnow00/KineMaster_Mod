// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import java.util.Objects;
import java.util.Arrays;
import com.google.android.datatransport.Priority;

final class c extends TransportContext
{
    private final String a;
    private final byte[] b;
    private final Priority c;
    
    private c(final String a, final byte[] b, final Priority c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    c(final String s, final byte[] array, final Priority priority, final c$a object) {
        this(s, array, priority);
    }
    
    @Override
    public String b() {
        return this.a;
    }
    
    @Override
    public byte[] c() {
        return this.b;
    }
    
    @Override
    public Priority d() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof TransportContext) {
            final TransportContext transportContext = (TransportContext)o;
            if (this.a.equals(transportContext.b())) {
                final byte[] b2 = this.b;
                byte[] array;
                if (transportContext instanceof c) {
                    array = ((c)transportContext).b;
                }
                else {
                    array = transportContext.c();
                }
                if (Arrays.equals(b2, array) && this.c.equals(transportContext.d())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b)) * 1000003 ^ this.c.hashCode();
    }
    
    static final class b extends Builder
    {
        private String a;
        private byte[] b;
        private Priority c;
        
        @Override
        public TransportContext a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" backendName");
                string = sb.toString();
            }
            String string2 = string;
            if (this.c == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" priority");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new c(this.a, this.b, this.c, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final String a) {
            Objects.requireNonNull(a, "Null backendName");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder c(final byte[] b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder d(final Priority c) {
            Objects.requireNonNull(c, "Null priority");
            this.c = c;
            return this;
        }
    }
}
