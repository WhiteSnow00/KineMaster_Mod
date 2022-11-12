// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;

public final class zaaj implements zabf
{
    private final zabi a;
    private boolean b;
    
    public zaaj(final zabi a) {
        this.b = false;
        this.a = a;
    }
    
    static /* bridge */ zabi i(final zaaj zaaj) {
        return zaaj.a;
    }
    
    @Override
    public final void a(final Bundle bundle) {
    }
    
    @Override
    public final void b() {
    }
    
    @Override
    public final void c() {
        if (this.b) {
            this.b = false;
            this.a.p(new f(this, this));
        }
    }
    
    @Override
    public final void d(final ConnectionResult connectionResult, final Api api, final boolean b) {
    }
    
    @Override
    public final void e(final int n) {
        this.a.o(null);
        this.a.z.b(n, this.b);
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl f(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.h(apiMethodImpl);
        return apiMethodImpl;
    }
    
    @Override
    public final boolean g() {
        if (this.b) {
            return false;
        }
        final Set w = this.a.y.w;
        if (w != null && !w.isEmpty()) {
            this.b = true;
            final Iterator iterator = w.iterator();
            while (iterator.hasNext()) {
                ((zada)iterator.next()).f();
            }
            return false;
        }
        this.a.o(null);
        return true;
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.a.y.x.a(apiMethodImpl);
            final Api.Client client = this.a.y.o.get(apiMethodImpl.s());
            Preconditions.l(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.a.g.containsKey(apiMethodImpl.s())) {
                apiMethodImpl.w(new Status(17));
            }
            else {
                apiMethodImpl.u(client);
            }
        }
        catch (final DeadObjectException ex) {
            this.a.p(new e(this, this));
        }
        return apiMethodImpl;
    }
    
    final void j() {
        if (this.b) {
            this.b = false;
            this.a.y.x.b();
            this.g();
        }
    }
}
