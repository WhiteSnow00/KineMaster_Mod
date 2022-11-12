// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.signin.zae;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.Set;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.signin.internal.zac;

public final class zact extends zac implements ConnectionCallbacks, OnConnectionFailedListener
{
    private static final Api.AbstractClientBuilder h;
    private final Context a;
    private final Handler b;
    private final Api.AbstractClientBuilder c;
    private final Set d;
    private final ClientSettings e;
    private zae f;
    private zacs g;
    
    static {
        h = zad.c;
    }
    
    public zact(final Context a, final Handler b, final ClientSettings clientSettings) {
        final Api.AbstractClientBuilder h = zact.h;
        this.a = a;
        this.b = b;
        this.e = Preconditions.l(clientSettings, "ClientSettings must not be null");
        this.d = clientSettings.g();
        this.c = h;
    }
    
    static /* bridge */ zacs p1(final zact zact) {
        return zact.g;
    }
    
    static /* bridge */ void q1(final zact zact, final zak zak) {
        final ConnectionResult k1 = zak.K1();
        if (k1.O1()) {
            final zav zav = Preconditions.k(zak.L1());
            final ConnectionResult k2 = zav.K1();
            if (!k2.O1()) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(k2)), (Throwable)new Exception());
                zact.g.c(k2);
                ((Api.Client)zact.f).disconnect();
                return;
            }
            zact.g.b(zav.L1(), zact.d);
        }
        else {
            zact.g.c(k1);
        }
        ((Api.Client)zact.f).disconnect();
    }
    
    public final void onConnected(final Bundle bundle) {
        this.f.c((com.google.android.gms.signin.internal.zae)this);
    }
    
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        this.g.c(connectionResult);
    }
    
    public final void onConnectionSuspended(final int n) {
        ((Api.Client)this.f).disconnect();
    }
    
    public final void r1(final zacs g) {
        final zae f = this.f;
        if (f != null) {
            ((Api.Client)f).disconnect();
        }
        this.e.l(System.identityHashCode(this));
        final Api.AbstractClientBuilder c = this.c;
        final Context a = this.a;
        final Looper looper = this.b.getLooper();
        final ClientSettings e = this.e;
        this.f = c.c(a, looper, e, e.h(), this, this);
        this.g = g;
        final Set d = this.d;
        if (d != null && !d.isEmpty()) {
            this.f.b();
            return;
        }
        this.b.post((Runnable)new f0(this));
    }
    
    public final void s(final zak zak) {
        this.b.post((Runnable)new g0(this, zak));
    }
    
    public final void s1() {
        final zae f = this.f;
        if (f != null) {
            ((Api.Client)f).disconnect();
        }
    }
}
