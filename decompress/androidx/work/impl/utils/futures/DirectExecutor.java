// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor
{
    private static final DirectExecutor[] $VALUES;
    
    INSTANCE;
    
    @Override
    public void execute(final Runnable runnable) {
        runnable.run();
    }
    
    @Override
    public String toString() {
        return "DirectExecutor";
    }
}
