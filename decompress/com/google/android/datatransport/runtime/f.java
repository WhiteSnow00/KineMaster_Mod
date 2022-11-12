// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

class f implements Executor
{
    private final Executor a;
    
    f(final Executor a) {
        this.a = a;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.a.execute(new a(runnable));
    }
    
    static class a implements Runnable
    {
        private final Runnable a;
        
        a(final Runnable a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            try {
                this.a.run();
            }
            catch (final Exception ex) {
                Logging.c("Executor", "Background execution failure.", ex);
            }
        }
    }
}
