// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

final class f extends LogResponse
{
    private final long a;
    
    f(final long a) {
        this.a = a;
    }
    
    @Override
    public long c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof LogResponse) {
            if (this.a != ((LogResponse)o).c()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        return (int)(a ^ a >>> 32) ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LogResponse{nextRequestWaitMillis=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
