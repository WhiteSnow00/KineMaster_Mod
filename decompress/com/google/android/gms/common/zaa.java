// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.SuccessContinuation;

public final class zaa implements SuccessContinuation
{
    public static final zaa a;
    
    static {
        a = new zaa();
    }
    
    private zaa() {
    }
    
    public final Task a(final Object o) {
        final Map map = (Map)o;
        final int d = GoogleApiAvailability.d;
        return Tasks.e((Object)null);
    }
}
