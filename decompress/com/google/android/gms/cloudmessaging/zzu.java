// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.Task;
import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;

public final class zzu implements Continuation
{
    public final Rpc a;
    public final Bundle b;
    
    public zzu(final Rpc a, final Bundle b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object then(final Task task) {
        return this.a.c(this.b, task);
    }
}
