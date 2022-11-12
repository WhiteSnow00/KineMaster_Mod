// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

public final class c implements ComponentFactory
{
    public final Object a;
    
    public c(final Object a) {
        this.a = a;
    }
    
    @Override
    public final Object a(final ComponentContainer componentContainer) {
        return Component.b(this.a, componentContainer);
    }
}
