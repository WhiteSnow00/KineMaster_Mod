// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.android.gms.tasks.TaskCompletionSource;
import ba.e;

public final class q implements e
{
    public final TaskCompletionSource a;
    
    public q(final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        this.a.c(o);
    }
}
