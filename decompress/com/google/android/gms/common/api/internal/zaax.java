// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.Collections;
import com.google.android.gms.common.api.Api;
import android.os.Bundle;

public final class zaax implements zabf
{
    private final zabi a;
    
    public zaax(final zabi a) {
        this.a = a;
    }
    
    @Override
    public final void a(final Bundle bundle) {
    }
    
    @Override
    public final void b() {
        final Iterator iterator = this.a.f.values().iterator();
        while (iterator.hasNext()) {
            ((Api.Client)iterator.next()).disconnect();
        }
        this.a.y.p = Collections.emptySet();
    }
    
    @Override
    public final void c() {
        this.a.n();
    }
    
    @Override
    public final void d(final ConnectionResult connectionResult, final Api api, final boolean b) {
    }
    
    @Override
    public final void e(final int n) {
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl f(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.a.y.h.add(apiMethodImpl);
        return apiMethodImpl;
    }
    
    @Override
    public final boolean g() {
        return true;
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
