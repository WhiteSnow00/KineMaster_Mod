// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport;

public interface Transport<T>
{
    void a(final Event<T> p0, final TransportScheduleCallback p1);
    
    void b(final Event<T> p0);
}
