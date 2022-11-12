// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

public final class b implements ComponentFactory
{
    public final Object a;
    
    public b(final Object a) {
        this.a = a;
    }
    
    @Override
    public final Object a(final ComponentContainer componentContainer) {
        return Component.a(this.a, componentContainer);
    }
}
