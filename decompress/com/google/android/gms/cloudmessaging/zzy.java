// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.util.Log;
import java.io.IOException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzy implements Runnable
{
    public final TaskCompletionSource a;
    
    public zzy(final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.d((Exception)new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
