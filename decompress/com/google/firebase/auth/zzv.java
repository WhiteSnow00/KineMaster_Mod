// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzv implements ComponentFactory
{
    public static final zzv a;
    
    static {
        a = new zzv();
    }
    
    private zzv() {
    }
    
    @Override
    public final Object a(final ComponentContainer componentContainer) {
        return FirebaseAuthRegistrar.lambda$getComponents$0(componentContainer);
    }
}
