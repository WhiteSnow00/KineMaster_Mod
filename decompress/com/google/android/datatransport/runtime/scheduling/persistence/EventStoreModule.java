// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Named;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.dagger.Module;

@Module
public abstract class EventStoreModule
{
    @Provides
    @Named
    static String a() {
        return "com.google.android.datatransport.events";
    }
    
    @Provides
    @Named
    static String b(final Context context) {
        return context.getPackageName();
    }
    
    @Provides
    @Named
    static int c() {
        return SchemaManager.d;
    }
    
    @Provides
    static c d() {
        return c.a;
    }
}
