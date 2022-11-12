// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import java.util.concurrent.RejectedExecutionException;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import android.os.Handler;

public final class g
{
    public static Executor a(final Handler handler) {
        return new a(handler);
    }
    
    private static class a implements Executor
    {
        private final Handler a;
        
        a(final Handler handler) {
            this.a = h.g(handler);
        }
        
        @Override
        public void execute(final Runnable runnable) {
            if (this.a.post((Runnable)h.g(runnable))) {
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" is shutting down");
            throw new RejectedExecutionException(sb.toString());
        }
    }
}
