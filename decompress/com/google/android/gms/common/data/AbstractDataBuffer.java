// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.util.Iterator;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T>
{
    @KeepForSdk
    protected final DataHolder a;
    
    @Override
    public final void close() {
        this.release();
    }
    
    @Override
    public abstract T get(final int p0);
    
    @Override
    public int getCount() {
        final DataHolder a = this.a;
        if (a == null) {
            return 0;
        }
        return a.getCount();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new DataBufferIterator<T>(this);
    }
    
    @Override
    public void release() {
        try (final DataHolder a = this.a) {}
    }
}
