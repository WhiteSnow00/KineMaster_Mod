// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.BindsInstance;
import android.content.Context;
import java.io.IOException;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import javax.inject.Singleton;
import com.google.android.datatransport.runtime.dagger.Component;
import java.io.Closeable;

@Component
@Singleton
abstract class k implements Closeable
{
    abstract EventStore a();
    
    abstract TransportRuntime c();
    
    @Override
    public void close() throws IOException {
        this.a().close();
    }
    
    @Component.Builder
    interface a
    {
        @BindsInstance
        a a(final Context p0);
        
        k build();
    }
}
