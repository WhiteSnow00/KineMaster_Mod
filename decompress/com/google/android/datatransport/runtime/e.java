// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import javax.inject.Singleton;
import com.google.android.datatransport.runtime.dagger.Provides;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import com.google.android.datatransport.runtime.dagger.Module;

@Module
abstract class e
{
    @Provides
    @Singleton
    static Executor a() {
        return new f(Executors.newSingleThreadExecutor());
    }
}
