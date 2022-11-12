// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PersistedEvent
{
    public static PersistedEvent a(final long n, final TransportContext transportContext, final EventInternal eventInternal) {
        return new b(n, transportContext, eventInternal);
    }
    
    public abstract EventInternal b();
    
    public abstract long c();
    
    public abstract TransportContext d();
}
