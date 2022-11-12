// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final class d implements Provider
{
    public final String a;
    
    public d(final String a) {
        this.a = a;
    }
    
    public final Object get() {
        return ComponentDiscovery.a(this.a);
    }
}
