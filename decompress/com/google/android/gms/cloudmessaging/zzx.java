// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.SuccessContinuation;

public final class zzx implements SuccessContinuation
{
    public static final zzx a;
    
    static {
        a = new zzx();
    }
    
    private zzx() {
    }
    
    public final Task a(final Object o) {
        return Rpc.b((Bundle)o);
    }
}
