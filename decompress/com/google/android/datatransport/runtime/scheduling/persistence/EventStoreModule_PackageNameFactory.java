// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_PackageNameFactory implements Factory<String>
{
    private final Provider<Context> a;
    
    public EventStoreModule_PackageNameFactory(final Provider<Context> a) {
        this.a = a;
    }
    
    public static EventStoreModule_PackageNameFactory a(final Provider<Context> provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }
    
    public static String c(final Context context) {
        return Preconditions.c(EventStoreModule.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public String b() {
        return c((Context)this.a.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
