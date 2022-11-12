// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.util.HashSet;

public final class DataBufferObserverSet implements DataBufferObserver, Observable
{
    private HashSet a;
    
    public DataBufferObserverSet() {
        this.a = new HashSet();
    }
}
