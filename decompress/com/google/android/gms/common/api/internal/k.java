// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import javax.annotation.concurrent.GuardedBy;
import java.util.Iterator;
import com.google.android.gms.common.internal.BaseGmsClient;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zal;
import java.util.Map;

final class k extends p
{
    private final Map b;
    final zaaw c;
    
    public k(final zaaw c, final Map b) {
        super(this.c = c, null);
        this.b = b;
    }
    
    @GuardedBy
    public final void a() {
        final zal zal = new zal(zaaw.t(this.c));
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (final Api.Client client : this.b.keySet()) {
            if (client.requiresGooglePlayServices() && !h.b((h)this.b.get(client))) {
                list.add(client);
            }
            else {
                list2.add(client);
            }
        }
        final boolean empty = list.isEmpty();
        int n = -1;
        final int n2 = 0;
        int i = 0;
        if (empty) {
            while (i < list2.size()) {
                final int b = zal.b(zaaw.s(this.c), (Api.Client)list2.get(i));
                ++i;
                if ((n = b) == 0) {
                    n = b;
                    break;
                }
            }
        }
        else {
            final int size = list.size();
            int j = n2;
            while (j < size) {
                final int b2 = zal.b(zaaw.s(this.c), (Api.Client)list.get(j));
                ++j;
                if ((n = b2) != 0) {
                    n = b2;
                    break;
                }
            }
        }
        if (n != 0) {
            final ConnectionResult connectionResult = new ConnectionResult(n, null);
            final zaaw c = this.c;
            zaaw.u(c).p(new i(this, c, connectionResult));
            return;
        }
        final zaaw c2 = this.c;
        if (zaaw.F(c2) && zaaw.x(c2) != null) {
            zaaw.x(c2).b();
        }
        for (final Api.Client client2 : this.b.keySet()) {
            final BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.b.get(client2);
            if (client2.requiresGooglePlayServices() && zal.b(zaaw.s(this.c), client2) != 0) {
                final zaaw c3 = this.c;
                zaaw.u(c3).p(new j(this, c3, connectionProgressReportCallbacks));
            }
            else {
                client2.connect(connectionProgressReportCallbacks);
            }
        }
    }
}
