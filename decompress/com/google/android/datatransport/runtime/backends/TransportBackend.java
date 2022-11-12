// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;

public interface TransportBackend
{
    EventInternal a(final EventInternal p0);
    
    BackendResponse b(final BackendRequest p0);
}
