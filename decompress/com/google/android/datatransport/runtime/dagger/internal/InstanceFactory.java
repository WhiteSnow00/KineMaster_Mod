// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T>
{
    private static final InstanceFactory<Object> b;
    private final T a;
    
    static {
        b = new InstanceFactory<Object>(null);
    }
    
    private InstanceFactory(final T a) {
        this.a = a;
    }
    
    public static <T> Factory<T> a(final T t) {
        return new InstanceFactory<T>(Preconditions.c(t, "instance cannot be null"));
    }
    
    @Override
    public T get() {
        return this.a;
    }
}
