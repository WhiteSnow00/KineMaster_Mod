// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final class h implements Runnable
{
    public final q a;
    public final Provider b;
    
    public h(final q a, final Provider b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        ComponentRuntime.h(this.a, this.b);
    }
}
