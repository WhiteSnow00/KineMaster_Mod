// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

public final class j implements Callable
{
    public final TaskCompletionSource a;
    
    public j(final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        return DisplayCallbacksImpl.e(this.a);
    }
}
