// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import android.os.SystemClock;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;

final class d0 implements OnCompleteListener
{
    private final GoogleApiManager a;
    private final int b;
    private final ApiKey c;
    private final long d;
    private final long e;
    
    @VisibleForTesting
    d0(final GoogleApiManager a, final int b, final ApiKey c, final long d, final long e, final String s, final String s2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    static d0 a(final GoogleApiManager googleApiManager, final int n, final ApiKey apiKey) {
        if (!googleApiManager.g()) {
            return null;
        }
        final RootTelemetryConfiguration a = RootTelemetryConfigManager.b().a();
        boolean o1;
        if (a != null) {
            if (!a.M1()) {
                return null;
            }
            final boolean n2 = a.N1();
            final zabq x = googleApiManager.x(apiKey);
            o1 = n2;
            if (x != null) {
                if (!(x.s() instanceof BaseGmsClient)) {
                    return null;
                }
                final BaseGmsClient baseGmsClient = (BaseGmsClient)x.s();
                o1 = n2;
                if (baseGmsClient.hasConnectionInfo()) {
                    o1 = n2;
                    if (!baseGmsClient.isConnecting()) {
                        final ConnectionTelemetryConfiguration b = b(x, baseGmsClient, n);
                        if (b == null) {
                            return null;
                        }
                        x.D();
                        o1 = b.O1();
                    }
                }
            }
        }
        else {
            o1 = true;
        }
        long currentTimeMillis;
        if (o1) {
            currentTimeMillis = System.currentTimeMillis();
        }
        else {
            currentTimeMillis = 0L;
        }
        long elapsedRealtime;
        if (o1) {
            elapsedRealtime = SystemClock.elapsedRealtime();
        }
        else {
            elapsedRealtime = 0L;
        }
        return new d0(googleApiManager, n, apiKey, currentTimeMillis, elapsedRealtime, null, null);
    }
    
    private static ConnectionTelemetryConfiguration b(final zabq zabq, final BaseGmsClient baseGmsClient, final int n) {
        final ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration != null && telemetryConfiguration.N1()) {
            final int[] l1 = telemetryConfiguration.L1();
            if (l1 == null) {
                final int[] m1 = telemetryConfiguration.M1();
                if (m1 != null) {
                    if (ArrayUtils.b(m1, n)) {
                        return null;
                    }
                }
            }
            else if (!ArrayUtils.b(l1, n)) {
                return null;
            }
            if (zabq.p() < telemetryConfiguration.K1()) {
                return telemetryConfiguration;
            }
        }
        return null;
    }
    
    public final void onComplete(final Task task) {
        if (!this.a.g()) {
            return;
        }
        final RootTelemetryConfiguration a = RootTelemetryConfigManager.b().a();
        if (a != null && !a.M1()) {
            return;
        }
        final zabq x = this.a.x(this.c);
        if (x != null) {
            if (x.s() instanceof BaseGmsClient) {
                final BaseGmsClient baseGmsClient = (BaseGmsClient)x.s();
                final long d = this.d;
                final int n = 1;
                final int n2 = 0;
                int n3;
                if (d > 0L) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
                final int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int k1;
                int o1;
                int n5;
                int n6;
                if (a != null) {
                    final boolean b = (n3 & (a.N1() ? 1 : 0)) != 0x0;
                    k1 = a.K1();
                    final int l1 = a.L1();
                    o1 = a.O1();
                    int n4 = b ? 1 : 0;
                    int k2 = l1;
                    if (baseGmsClient.hasConnectionInfo()) {
                        n4 = (b ? 1 : 0);
                        k2 = l1;
                        if (!baseGmsClient.isConnecting()) {
                            final ConnectionTelemetryConfiguration b2 = b(x, baseGmsClient, this.b);
                            if (b2 == null) {
                                return;
                            }
                            if (b2.O1() && this.d > 0L) {
                                n4 = n;
                            }
                            else {
                                n4 = 0;
                            }
                            k2 = b2.K1();
                        }
                    }
                    n5 = k2;
                    n6 = n4;
                }
                else {
                    o1 = 0;
                    n5 = 100;
                    k1 = 5000;
                    n6 = n3;
                }
                final GoogleApiManager a2 = this.a;
                int n7 = 0;
                int n8 = 0;
                Label_0343: {
                    if (task.t()) {
                        n7 = 0;
                        n8 = n2;
                    }
                    else {
                        if (task.r()) {
                            n8 = 100;
                        }
                        else {
                            final Exception o2 = task.o();
                            if (o2 instanceof ApiException) {
                                final Status status = ((ApiException)o2).getStatus();
                                final int m1 = status.M1();
                                final ConnectionResult k3 = status.K1();
                                int k4;
                                if (k3 == null) {
                                    k4 = -1;
                                }
                                else {
                                    k4 = k3.K1();
                                }
                                n7 = k4;
                                n8 = m1;
                                break Label_0343;
                            }
                            n8 = 101;
                        }
                        n7 = -1;
                    }
                }
                long d2;
                long currentTimeMillis;
                int n9;
                if (n6 != 0) {
                    d2 = this.d;
                    currentTimeMillis = System.currentTimeMillis();
                    n9 = (int)(SystemClock.elapsedRealtime() - this.e);
                }
                else {
                    d2 = 0L;
                    currentTimeMillis = 0L;
                    n9 = -1;
                }
                a2.J(new MethodInvocation(this.b, n8, n7, d2, currentTimeMillis, null, null, gCoreServiceId, n9), o1, k1, n5);
            }
        }
    }
}
