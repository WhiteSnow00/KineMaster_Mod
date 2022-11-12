// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

public final class zzb implements EventHandler
{
    public static final zzb a;
    
    static {
        a = new zzb();
    }
    
    private zzb() {
    }
    
    public final void a(final Event event) {
        AnalyticsConnectorImpl.i(event);
    }
}
