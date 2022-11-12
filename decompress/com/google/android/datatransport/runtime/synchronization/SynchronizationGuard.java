// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.synchronization;

public interface SynchronizationGuard
{
     <T> T c(final CriticalSection<T> p0);
    
    public interface CriticalSection<T>
    {
        T execute();
    }
}
