// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final class i implements Provider
{
    public final ComponentRegistrar a;
    
    public i(final ComponentRegistrar a) {
        this.a = a;
    }
    
    public final Object get() {
        return ComponentRuntime.Builder.a(this.a);
    }
}
