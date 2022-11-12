// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import java.util.Objects;

final class b extends BackendResponse
{
    private final Status a;
    private final long b;
    
    b(final Status a, final long b) {
        Objects.requireNonNull(a, "Null status");
        this.a = a;
        this.b = b;
    }
    
    @Override
    public long b() {
        return this.b;
    }
    
    @Override
    public Status c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof BackendResponse) {
            final BackendResponse backendResponse = (BackendResponse)o;
            if (!this.a.equals(backendResponse.c()) || this.b != backendResponse.b()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final long b = this.b;
        return (hashCode ^ 0xF4243) * 1000003 ^ (int)(b ^ b >>> 32);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BackendResponse{status=");
        sb.append(this.a);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
