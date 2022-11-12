// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Callable;
import com.google.android.gms.internal.play_billing.zzd;
import android.os.IBinder;
import android.content.ComponentName;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzb;
import android.os.Bundle;
import android.text.TextUtils;
import android.content.ServiceConnection;

final class f0 implements ServiceConnection
{
    private final Object a;
    private boolean b;
    private e c;
    final d d;
    
    f0(final d d, final e c, final e0 e0) {
        this.d = d;
        this.a = new Object();
        this.b = false;
        this.c = c;
    }
    
    private final void d(final g g) {
        synchronized (this.a) {
            final e c = this.c;
            if (c != null) {
                c.a(g);
            }
        }
    }
    
    final Object a() throws Exception {
        Object o = this.a;
        synchronized (o) {
            if (this.b) {
                return null;
            }
            monitorexit(o);
            Bundle bundle;
            if (!TextUtils.isEmpty((CharSequence)null)) {
                bundle = new Bundle();
                bundle.putString("accountName", (String)null);
            }
            else {
                bundle = null;
            }
            int n = 3;
            int n5 = 0;
            Label_0744: {
                try {
                    o = com.android.billingclient.api.d.z(this.d).getPackageName();
                    n = 3;
                    int n2 = 17;
                Label_0143_Outer:
                    while (true) {
                        Label_0139: {
                            if (n2 < 3) {
                                break Label_0139;
                            }
                            Label_0104: {
                                if (bundle != null) {
                                    break Label_0104;
                                }
                                try {
                                    int n3 = com.android.billingclient.api.d.G(this.d).zzr(n2, (String)o, "subs");
                                    if (n3 != 0) {
                                        --n2;
                                        n = n3;
                                        continue Label_0143_Outer;
                                    }
                                    while (true) {
                                        n = n3;
                                        final d d = this.d;
                                        final boolean b = true;
                                        final boolean b2 = n2 >= 5;
                                        n = n3;
                                        com.android.billingclient.api.d.o(d, b2);
                                        n = n3;
                                        final d d2 = this.d;
                                        final boolean b3 = n2 >= 3;
                                        n = n3;
                                        com.android.billingclient.api.d.p(d2, b3);
                                        if (n2 < 3) {
                                            n = n3;
                                            zzb.zzn("BillingClient", "In-app billing API does not support subscription on this device.");
                                        }
                                        int n4 = 17;
                                        n = n3;
                                        while (true) {
                                            n5 = n;
                                            if (n4 < 3) {
                                                break;
                                            }
                                            if (bundle == null) {
                                                n5 = com.android.billingclient.api.d.G(this.d).zzr(n4, (String)o, "inapp");
                                            }
                                            else {
                                                n5 = com.android.billingclient.api.d.G(this.d).zzc(n4, (String)o, "inapp", bundle);
                                            }
                                            if (n5 == 0) {
                                                n = n5;
                                                com.android.billingclient.api.d.M(this.d, n4);
                                                break;
                                            }
                                            --n4;
                                            n = n5;
                                        }
                                        n = n5;
                                        final d d3 = this.d;
                                        n = n5;
                                        final boolean b4 = com.android.billingclient.api.d.y(d3) >= 17;
                                        n = n5;
                                        com.android.billingclient.api.d.S(d3, b4);
                                        n = n5;
                                        final d d4 = this.d;
                                        n = n5;
                                        final boolean b5 = com.android.billingclient.api.d.y(d4) >= 16;
                                        n = n5;
                                        com.android.billingclient.api.d.R(d4, b5);
                                        n = n5;
                                        final d d5 = this.d;
                                        n = n5;
                                        final boolean b6 = com.android.billingclient.api.d.y(d5) >= 15;
                                        n = n5;
                                        com.android.billingclient.api.d.Q(d5, b6);
                                        n = n5;
                                        final d d6 = this.d;
                                        n = n5;
                                        final boolean b7 = com.android.billingclient.api.d.y(d6) >= 14;
                                        n = n5;
                                        com.android.billingclient.api.d.P(d6, b7);
                                        n = n5;
                                        final d d7 = this.d;
                                        n = n5;
                                        final boolean b8 = com.android.billingclient.api.d.y(d7) >= 12;
                                        n = n5;
                                        com.android.billingclient.api.d.O(d7, b8);
                                        n = n5;
                                        final d d8 = this.d;
                                        n = n5;
                                        final boolean b9 = com.android.billingclient.api.d.y(d8) >= 10;
                                        n = n5;
                                        com.android.billingclient.api.d.N(d8, b9);
                                        n = n5;
                                        final d d9 = this.d;
                                        n = n5;
                                        final boolean b10 = com.android.billingclient.api.d.y(d9) >= 9;
                                        n = n5;
                                        com.android.billingclient.api.d.m(d9, b10);
                                        n = n5;
                                        final d d10 = this.d;
                                        n = n5;
                                        final boolean b11 = com.android.billingclient.api.d.y(d10) >= 8;
                                        n = n5;
                                        com.android.billingclient.api.d.U(d10, b11);
                                        n = n5;
                                        final d d11 = this.d;
                                        n = n5;
                                        final boolean b12 = com.android.billingclient.api.d.y(d11) >= 6 && b;
                                        n = n5;
                                        com.android.billingclient.api.d.T(d11, b12);
                                        n = n5;
                                        if (com.android.billingclient.api.d.y(this.d) < 3) {
                                            n = n5;
                                            zzb.zzo("BillingClient", "In-app billing API version 3 is not supported on this device.");
                                        }
                                        if (n5 == 0) {
                                            n = n5;
                                            com.android.billingclient.api.d.L(this.d, 2);
                                            break Label_0744;
                                        }
                                        n = n5;
                                        com.android.billingclient.api.d.L(this.d, 0);
                                        n = n5;
                                        com.android.billingclient.api.d.n(this.d, (zze)null);
                                        break Label_0744;
                                        n2 = 0;
                                        n3 = n;
                                        continue;
                                    }
                                    n3 = com.android.billingclient.api.d.G(this.d).zzc(n2, (String)o, "subs", bundle);
                                }
                                catch (final Exception bundle) {}
                            }
                        }
                    }
                }
                catch (final Exception ex) {}
                zzb.zzp("BillingClient", "Exception while checking if billing is supported; try to reconnect", (Throwable)bundle);
                com.android.billingclient.api.d.L(this.d, 0);
                com.android.billingclient.api.d.n(this.d, (zze)null);
                n5 = n;
            }
            if (n5 == 0) {
                this.d(p0.l);
            }
            else {
                this.d(p0.a);
            }
            return null;
        }
    }
    
    final void b() {
        com.android.billingclient.api.d.L(this.d, 0);
        com.android.billingclient.api.d.n(this.d, (zze)null);
        this.d(p0.n);
    }
    
    final void c() {
        synchronized (this.a) {
            this.c = null;
            this.b = true;
        }
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        zzb.zzn("BillingClient", "Billing service connected.");
        com.android.billingclient.api.d.n(this.d, zzd.zzo(binder));
        final d d = this.d;
        if (com.android.billingclient.api.d.K(d, (Callable)new c0(this), 30000L, (Runnable)new d0(this), com.android.billingclient.api.d.C(d)) == null) {
            this.d(com.android.billingclient.api.d.E(this.d));
        }
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        zzb.zzo("BillingClient", "Billing service disconnected.");
        com.android.billingclient.api.d.n(this.d, (zze)null);
        com.android.billingclient.api.d.L(this.d, 0);
        synchronized (this.a) {
            final e c = this.c;
            if (c != null) {
                c.b();
            }
        }
    }
}
