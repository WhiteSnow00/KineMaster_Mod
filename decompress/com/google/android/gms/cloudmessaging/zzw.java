// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;
import com.google.android.gms.tasks.OnCompleteListener;

public final class zzw implements OnCompleteListener
{
    public final Rpc a;
    public final String b;
    public final ScheduledFuture c;
    
    public zzw(final Rpc a, final String b, final ScheduledFuture c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void onComplete(final Task task) {
        this.a.e(this.b, this.c, task);
    }
}
