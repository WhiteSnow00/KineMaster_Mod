// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import java.util.Iterator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.AbstractDataBuffer;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T>
{
    @KeepForSdk
    public DataBufferResponse() {
    }
    
    @Override
    public final void close() {
        this.a().close();
    }
    
    @Override
    public final T get(final int n) {
        return this.a().get(n);
    }
    
    @Override
    public final int getCount() {
        return this.a().getCount();
    }
    
    @Override
    public final Iterator<T> iterator() {
        return this.a().iterator();
    }
    
    @Override
    public final void release() {
        this.a().release();
    }
}
