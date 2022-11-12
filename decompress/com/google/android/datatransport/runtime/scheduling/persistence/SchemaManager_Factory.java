// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class SchemaManager_Factory implements Factory<SchemaManager>
{
    private final Provider<Context> a;
    private final Provider<String> b;
    private final Provider<Integer> c;
    
    public SchemaManager_Factory(final Provider<Context> a, final Provider<String> b, final Provider<Integer> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static SchemaManager_Factory a(final Provider<Context> provider, final Provider<String> provider2, final Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }
    
    public static SchemaManager c(final Context context, final String s, final int n) {
        return new SchemaManager(context, s, n);
    }
    
    public SchemaManager b() {
        return c((Context)this.a.get(), (String)this.b.get(), (int)this.c.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
