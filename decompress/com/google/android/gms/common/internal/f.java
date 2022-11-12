// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.PendingResult;

final class f implements StatusListener
{
    final PendingResult a;
    final TaskCompletionSource b;
    final PendingResultUtil.ResultConverter c;
    final zas d;
    
    f(final PendingResult a, final TaskCompletionSource b, final PendingResultUtil.ResultConverter c, final zas d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void a(final Status status) {
        if (status.P1()) {
            this.b.c(this.c.a(this.a.c(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.b.b((Exception)ApiExceptionUtil.a(status));
    }
}
