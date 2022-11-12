// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final class g implements Runnable
{
    public final m a;
    public final Provider b;
    
    public g(final m a, final Provider b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        ComponentRuntime.g(this.a, this.b);
    }
}
