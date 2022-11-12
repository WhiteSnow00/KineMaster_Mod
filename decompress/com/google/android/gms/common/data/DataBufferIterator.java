// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T>
{
    protected final DataBuffer a;
    protected int b;
    
    public DataBufferIterator(final DataBuffer dataBuffer) {
        this.a = Preconditions.k(dataBuffer);
        this.b = -1;
    }
    
    @Override
    public final boolean hasNext() {
        return this.b < this.a.getCount() - 1;
    }
    
    @Override
    public Object next() {
        if (this.hasNext()) {
            final DataBuffer a = this.a;
            final int b = this.b + 1;
            this.b = b;
            return a.get(b);
        }
        final int b2 = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot advance the iterator beyond ");
        sb.append(b2);
        throw new NoSuchElementException(sb.toString());
    }
    
    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
