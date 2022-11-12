// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class ExecutionModule_ExecutorFactory implements Factory<Executor>
{
    public static ExecutionModule_ExecutorFactory a() {
        return a.a();
    }
    
    public static Executor b() {
        return Preconditions.c(e.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public Executor c() {
        return b();
    }
    
    public /* bridge */ Object get() {
        return this.c();
    }
    
    private static final class a
    {
        private static final ExecutionModule_ExecutorFactory a;
        
        static {
            a = new ExecutionModule_ExecutorFactory();
        }
        
        static ExecutionModule_ExecutorFactory a() {
            return ExecutionModule_ExecutorFactory.a.a;
        }
    }
}
