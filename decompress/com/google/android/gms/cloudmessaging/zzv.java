// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import java.io.IOException;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Continuation;

public final class zzv implements Continuation
{
    public static final zzv a;
    
    static {
        a = new zzv();
    }
    
    private zzv() {
    }
    
    public final Object then(final Task task) {
        if (task.t()) {
            return task.p();
        }
        if (Log.isLoggable("Rpc", 3)) {
            final String value = String.valueOf(task.o());
            final StringBuilder sb = new StringBuilder(value.length() + 22);
            sb.append("Error making request: ");
            sb.append(value);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.o());
    }
}
