// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import com.google.firebase.inject.Deferred$DeferredHandler;

public final class o implements Deferred$DeferredHandler
{
    public static final o a;
    
    static {
        a = new o();
    }
    
    private o() {
    }
    
    public final void a(final Provider provider) {
        q.c(provider);
    }
}
