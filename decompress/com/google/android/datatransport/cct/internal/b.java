// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable$Field;
import java.util.Objects;
import java.util.List;

final class b extends BatchedLogRequest
{
    private final List<LogRequest> a;
    
    b(final List<LogRequest> a) {
        Objects.requireNonNull(a, "Null logRequests");
        this.a = a;
    }
    
    @Encodable$Field
    @Override
    public List<LogRequest> c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof BatchedLogRequest && this.a.equals(((BatchedLogRequest)o).c()));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BatchedLogRequest{logRequests=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
