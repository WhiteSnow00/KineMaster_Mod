// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzb implements ComponentFactory
{
    public static final zzb a;
    
    static {
        a = new zzb();
    }
    
    private zzb() {
    }
    
    @Override
    public final Object a(final ComponentContainer componentContainer) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(componentContainer);
    }
}
