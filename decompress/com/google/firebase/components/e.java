// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final class e implements Provider
{
    public final ComponentRuntime a;
    public final Component b;
    
    public e(final ComponentRuntime a, final Component b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object get() {
        return ComponentRuntime.f(this.a, this.b);
    }
}
