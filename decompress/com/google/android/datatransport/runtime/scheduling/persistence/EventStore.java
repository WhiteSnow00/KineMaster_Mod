// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

public interface EventStore extends Closeable
{
    void H(final TransportContext p0, final long p1);
    
    Iterable<PersistedEvent> I0(final TransportContext p0);
    
    Iterable<TransportContext> N();
    
    int cleanUp();
    
    long n0(final TransportContext p0);
    
    boolean q0(final TransportContext p0);
    
    void s0(final Iterable<PersistedEvent> p0);
    
    PersistedEvent t1(final TransportContext p0, final EventInternal p1);
    
    void w(final Iterable<PersistedEvent> p0);
}
