// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.time.Clock;
import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class CreationContextFactory_Factory implements Factory<d>
{
    private final Provider<Context> a;
    private final Provider<Clock> b;
    private final Provider<Clock> c;
    
    public CreationContextFactory_Factory(final Provider<Context> a, final Provider<Clock> b, final Provider<Clock> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static CreationContextFactory_Factory a(final Provider<Context> provider, final Provider<Clock> provider2, final Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }
    
    public static d c(final Context context, final Clock clock, final Clock clock2) {
        return new d(context, clock, clock2);
    }
    
    public d b() {
        return c((Context)this.a.get(), (Clock)this.b.get(), (Clock)this.c.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
