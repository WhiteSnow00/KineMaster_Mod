// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.ads.zzdjf;
import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.content.Intent;
import android.os.RemoteException;
import android.app.Activity;
import com.google.android.gms.internal.ads.zzbxt;

public final class zzv extends zzbxt
{
    private final AdOverlayInfoParcel a;
    private final Activity b;
    private boolean c;
    private boolean d;
    
    public zzv(final Activity b, final AdOverlayInfoParcel a) {
        this.c = false;
        this.d = false;
        this.a = a;
        this.b = b;
    }
    
    private final void zzb() {
        synchronized (this) {
            if (!this.d) {
                final zzo c = this.a.c;
                if (c != null) {
                    c.zzf(4);
                }
                this.d = true;
            }
        }
    }
    
    public final boolean zzE() throws RemoteException {
        return false;
    }
    
    public final void zzg(final int n, final int n2, final Intent intent) throws RemoteException {
    }
    
    public final void zzh() throws RemoteException {
    }
    
    public final void zzj(final IObjectWrapper objectWrapper) throws RemoteException {
    }
    
    public final void zzk(final Bundle bundle) {
        if (zzay.c().zzb(zzbhy.zzhp)) {
            this.b.requestWindowFeature(1);
        }
        int n = 0;
        if (bundle != null) {
            n = n;
            if (bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
                n = 1;
            }
        }
        final AdOverlayInfoParcel a = this.a;
        if (a == null) {
            this.b.finish();
            return;
        }
        if (n != 0) {
            this.b.finish();
            return;
        }
        if (bundle == null) {
            final com.google.android.gms.ads.internal.client.zza b = a.b;
            if (b != null) {
                b.onAdClicked();
            }
            final zzdjf j = this.a.J;
            if (j != null) {
                j.zzq();
            }
            if (this.b.getIntent() != null && this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true)) {
                final zzo c = this.a.c;
                if (c != null) {
                    c.zzb();
                }
            }
        }
        zzt.j();
        final Activity b2 = this.b;
        final AdOverlayInfoParcel a2 = this.a;
        final zzc a3 = a2.a;
        if (!zza.b((Context)b2, a3, a2.i, a3.i)) {
            this.b.finish();
        }
    }
    
    public final void zzl() throws RemoteException {
        if (this.b.isFinishing()) {
            this.zzb();
        }
    }
    
    public final void zzn() throws RemoteException {
        final zzo c = this.a.c;
        if (c != null) {
            c.zzbr();
        }
        if (this.b.isFinishing()) {
            this.zzb();
        }
    }
    
    public final void zzo() throws RemoteException {
    }
    
    public final void zzp() throws RemoteException {
        if (this.c) {
            this.b.finish();
            return;
        }
        this.c = true;
        final zzo c = this.a.c;
        if (c != null) {
            c.zzbK();
        }
    }
    
    public final void zzq(final Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }
    
    public final void zzr() throws RemoteException {
    }
    
    public final void zzs() throws RemoteException {
        if (this.b.isFinishing()) {
            this.zzb();
        }
    }
    
    public final void zzt() throws RemoteException {
        final zzo c = this.a.c;
        if (c != null) {
            c.zze();
        }
    }
    
    public final void zzv() throws RemoteException {
    }
}
