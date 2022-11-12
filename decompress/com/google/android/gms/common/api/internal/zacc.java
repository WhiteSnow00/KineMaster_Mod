// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.Task;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.CancellationException;
import android.app.Activity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zacc extends zap
{
    private TaskCompletionSource f;
    
    private zacc(final LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.q());
        this.f = new TaskCompletionSource();
        super.a.J("GmsAvailabilityHelper", this);
    }
    
    public static zacc t(final Activity activity) {
        final LifecycleFragment c = LifecycleCallback.c(activity);
        final zacc zacc = c.u0("GmsAvailabilityHelper", zacc.class);
        if (zacc != null) {
            if (zacc.f.a().s()) {
                zacc.f = new TaskCompletionSource();
            }
            return zacc;
        }
        return new zacc(c);
    }
    
    @Override
    public final void g() {
        super.g();
        this.f.d((Exception)new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }
    
    @Override
    protected final void m(final ConnectionResult connectionResult, final int n) {
        String l1;
        if ((l1 = connectionResult.L1()) == null) {
            l1 = "Error connecting to Google Play services";
        }
        this.f.b((Exception)new ApiException(new Status(connectionResult, l1, connectionResult.K1())));
    }
    
    @Override
    protected final void n() {
        final Activity t2 = super.a.T2();
        if (t2 == null) {
            this.f.d((Exception)new ApiException(new Status(8)));
            return;
        }
        final int i = super.e.i((Context)t2);
        if (i == 0) {
            this.f.e((Object)null);
            return;
        }
        if (!this.f.a().s()) {
            this.s(new ConnectionResult(i, null), 0);
        }
    }
    
    public final Task u() {
        return this.f.a();
    }
}
