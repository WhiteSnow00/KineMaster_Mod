// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import java.util.Arrays;
import java.util.Objects;
import com.google.android.datatransport.Encoding;

public final class EncodedPayload
{
    private final Encoding a;
    private final byte[] b;
    
    public EncodedPayload(final Encoding a, final byte[] b) {
        Objects.requireNonNull(a, "encoding is null");
        Objects.requireNonNull(b, "bytes is null");
        this.a = a;
        this.b = b;
    }
    
    public byte[] a() {
        return this.b;
    }
    
    public Encoding b() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EncodedPayload)) {
            return false;
        }
        final EncodedPayload encodedPayload = (EncodedPayload)o;
        return this.a.equals(encodedPayload.a) && Arrays.equals(this.b, encodedPayload.b);
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EncodedPayload{encoding=");
        sb.append(this.a);
        sb.append(", bytes=[...]}");
        return sb.toString();
    }
}
