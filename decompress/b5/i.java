// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import ba.f;

public final class i implements f
{
    public final TaskCompletionSource a;
    
    public i(final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return DisplayCallbacksImpl.g(this.a, (Throwable)o);
    }
}
