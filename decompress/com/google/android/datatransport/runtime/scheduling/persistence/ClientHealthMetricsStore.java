// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;

public interface ClientHealthMetricsStore
{
    void a();
    
    ClientMetrics d();
    
    void e(final long p0, final LogEventDropped.Reason p1, final String p2);
}
