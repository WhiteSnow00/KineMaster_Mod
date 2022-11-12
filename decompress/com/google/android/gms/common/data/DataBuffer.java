// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.io.Closeable;
import com.google.android.gms.common.api.Releasable;

public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable
{
    T get(final int p0);
    
    int getCount();
}
