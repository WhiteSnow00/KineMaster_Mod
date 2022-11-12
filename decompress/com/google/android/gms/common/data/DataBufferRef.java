// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class DataBufferRef
{
    @KeepForSdk
    protected final DataHolder a;
    @KeepForSdk
    protected int b;
    private int c;
    
    protected final void a(final int b) {
        boolean b2 = false;
        if (b >= 0) {
            b2 = b2;
            if (b < this.a.getCount()) {
                b2 = true;
            }
        }
        Preconditions.o(b2);
        this.b = b;
        this.c = this.a.O1(b);
    }
    
    @KeepForSdk
    @Override
    public boolean equals(final Object o) {
        if (o instanceof DataBufferRef) {
            final DataBufferRef dataBufferRef = (DataBufferRef)o;
            if (Objects.b(dataBufferRef.b, this.b) && Objects.b(dataBufferRef.c, this.c) && dataBufferRef.a == this.a) {
                return true;
            }
        }
        return false;
    }
    
    @KeepForSdk
    @Override
    public int hashCode() {
        return Objects.c(this.b, this.c, this.a);
    }
}
