// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase-auth-api.zzwq;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import android.app.Application;
import com.google.firebase.FirebaseApp;

public final class zzbi
{
    private volatile int a;
    private final zzam b;
    private volatile boolean c;
    
    public zzbi(final FirebaseApp firebaseApp) {
        final Context l = firebaseApp.l();
        final zzam b = new zzam(firebaseApp);
        this.c = false;
        this.a = 0;
        this.b = b;
        BackgroundDetector.c((Application)l.getApplicationContext());
        BackgroundDetector.b().a((BackgroundDetector.BackgroundStateChangeListener)new n(this));
    }
    
    static /* bridge */ zzam a(final zzbi zzbi) {
        return zzbi.b;
    }
    
    static /* bridge */ void b(final zzbi zzbi, final boolean c) {
        zzbi.c = c;
    }
    
    static /* bridge */ boolean f(final zzbi zzbi) {
        return zzbi.g();
    }
    
    private final boolean g() {
        return this.a > 0 && !this.c;
    }
    
    public final void c() {
        this.b.b();
    }
    
    public final void d(final int n) {
        if (n > 0 && this.a == 0) {
            this.a = n;
            if (this.g()) {
                this.b.c();
            }
        }
        else if (n == 0 && this.a != 0) {
            this.b.b();
        }
        this.a = n;
    }
    
    public final void e(final zzwq zzwq) {
        if (zzwq == null) {
            return;
        }
        long zzb;
        if ((zzb = ((com.google.android.gms.internal.firebase_auth_api.zzwq)zzwq).zzb()) <= 0L) {
            zzb = 3600L;
        }
        final long zzc = ((com.google.android.gms.internal.firebase_auth_api.zzwq)zzwq).zzc();
        final zzam b = this.b;
        b.b = zzc + zzb * 1000L;
        b.c = -1L;
        if (this.g()) {
            this.b.c();
        }
    }
}
