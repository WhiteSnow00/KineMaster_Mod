// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class MetadataBackendRegistry_Factory implements Factory<e>
{
    private final Provider<Context> a;
    private final Provider<d> b;
    
    public MetadataBackendRegistry_Factory(final Provider<Context> a, final Provider<d> b) {
        this.a = a;
        this.b = b;
    }
    
    public static MetadataBackendRegistry_Factory a(final Provider<Context> provider, final Provider<d> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }
    
    public static e c(final Context context, final Object o) {
        return new e(context, (d)o);
    }
    
    public e b() {
        return c((Context)this.a.get(), this.b.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
