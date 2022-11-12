// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class c0 implements Callable
{
    public final f0 a;
    
    public c0(final f0 a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        this.a.a();
        return null;
    }
}
