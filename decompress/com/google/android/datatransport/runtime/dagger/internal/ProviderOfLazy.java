// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class ProviderOfLazy<T> implements Provider<Lazy<T>>
{
    private final Provider<T> a;
    
    public Lazy<T> a() {
        return DoubleCheck.a(this.a);
    }
    
    public /* bridge */ Object get() {
        return this.a();
    }
}
