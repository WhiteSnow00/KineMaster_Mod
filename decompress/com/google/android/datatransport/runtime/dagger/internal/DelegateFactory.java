// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

public final class DelegateFactory<T> implements Factory<T>
{
    private Provider<T> a;
    
    public T get() {
        final Provider<T> a = this.a;
        if (a != null) {
            return (T)a.get();
        }
        throw new IllegalStateException();
    }
}
