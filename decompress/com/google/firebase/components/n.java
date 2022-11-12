// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import com.google.firebase.inject.Deferred$DeferredHandler;

public final class n implements Deferred$DeferredHandler
{
    public final Deferred$DeferredHandler a;
    public final Deferred$DeferredHandler b;
    
    public n(final Deferred$DeferredHandler a, final Deferred$DeferredHandler b) {
        this.a = a;
        this.b = b;
    }
    
    public final void a(final Provider provider) {
        q.d(this.a, this.b, provider);
    }
}
