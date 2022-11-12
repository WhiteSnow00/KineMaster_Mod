// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import javax.annotation.concurrent.GuardedBy;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class j extends t
{
    final BaseGmsClient.ConnectionProgressReportCallbacks b;
    
    j(final k k, final zabf zabf, final BaseGmsClient.ConnectionProgressReportCallbacks b) {
        this.b = b;
        super(zabf);
    }
    
    @GuardedBy
    public final void a() {
        this.b.a(new ConnectionResult(16, null));
    }
}
