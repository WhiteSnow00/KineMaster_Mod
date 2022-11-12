// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import java.util.Objects;
import java.util.Arrays;
import com.google.android.datatransport.runtime.EventInternal;

final class a extends BackendRequest
{
    private final Iterable<EventInternal> a;
    private final byte[] b;
    
    private a(final Iterable<EventInternal> a, final byte[] b) {
        this.a = a;
        this.b = b;
    }
    
    a(final Iterable iterable, final byte[] array, final a$a object) {
        this(iterable, array);
    }
    
    @Override
    public Iterable<EventInternal> b() {
        return this.a;
    }
    
    @Override
    public byte[] c() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof BackendRequest) {
            final BackendRequest backendRequest = (BackendRequest)o;
            if (this.a.equals(backendRequest.b())) {
                final byte[] b2 = this.b;
                byte[] array;
                if (backendRequest instanceof a) {
                    array = ((a)backendRequest).b;
                }
                else {
                    array = backendRequest.c();
                }
                if (Arrays.equals(b2, array)) {
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
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BackendRequest{events=");
        sb.append(this.a);
        sb.append(", extras=");
        sb.append(Arrays.toString(this.b));
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Iterable<EventInternal> a;
        private byte[] b;
        
        @Override
        public BackendRequest a() {
            final Iterable<EventInternal> a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" events");
                string = sb.toString();
            }
            if (string.isEmpty()) {
                return new a(this.a, this.b, null);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Missing required properties:");
            sb2.append(string);
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public Builder b(final Iterable<EventInternal> a) {
            Objects.requireNonNull(a, "Null events");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder c(final byte[] b) {
            this.b = b;
            return this;
        }
    }
}
