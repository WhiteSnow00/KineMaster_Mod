// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T>
{
    private Object c;
    
    @Override
    public final Object next() {
        if (this.hasNext()) {
            if (++super.b == 0) {
                final Object k = Preconditions.k(super.a.get(0));
                this.c = k;
                if (!(k instanceof DataBufferRef)) {
                    final String value = String.valueOf(k.getClass());
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DataBuffer reference of type ");
                    sb.append(value);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            }
            else {
                Preconditions.k(this.c).a(super.b);
            }
            return this.c;
        }
        final int b = super.b;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(b);
        throw new NoSuchElementException(sb2.toString());
    }
}
