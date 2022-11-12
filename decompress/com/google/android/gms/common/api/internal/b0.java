// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.ConnectionResult;

final class b0 implements Runnable
{
    final ConnectionResult a;
    final c0 b;
    
    b0(final c0 b, final ConnectionResult a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        final c0 b = this.b;
        final zabq zabq = GoogleApiManager.E(b.f).get(c0.e(b));
        if (zabq == null) {
            return;
        }
        if (this.a.O1()) {
            c0.f(this.b, true);
            if (c0.d(this.b).requiresSignIn()) {
                c0.g(this.b);
                return;
            }
            try {
                final c0 b2 = this.b;
                c0.d(b2).getRemoteService(null, c0.d(b2).getScopesForConnectionlessNonSignIn());
                return;
            }
            catch (final SecurityException ex) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", (Throwable)ex);
                c0.d(this.b).disconnect("Failed to get service from broker.");
                zabq.E(new ConnectionResult(10), null);
                return;
            }
        }
        zabq.E(this.a, null);
    }
}
