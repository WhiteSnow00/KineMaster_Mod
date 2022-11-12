// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzcfb;
import android.content.Context;
import android.os.RemoteException;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzcfi;
import android.os.IBinder;

abstract class m
{
    private static final zzcc a;
    
    static {
        zzcc a2 = null;
        try {
            final Object instance = zzau.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            if (!(instance instanceof IBinder)) {
                zzcfi.zzj("ClientApi class is not an instance of IBinder.");
            }
            else {
                final IBinder binder = (IBinder)instance;
                if (binder != null) {
                    final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    if (queryLocalInterface instanceof zzcc) {
                        a2 = (zzcc)queryLocalInterface;
                    }
                    else {
                        a2 = new zzca(binder);
                    }
                }
            }
        }
        catch (final Exception ex) {
            zzcfi.zzj("Failed to instantiate ClientApi class.");
        }
        a = a2;
    }
    
    private final Object e() {
        final zzcc a = m.a;
        if (a != null) {
            try {
                return this.b(a);
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Cannot invoke local loader using ClientApi class.", (Throwable)ex);
                return null;
            }
        }
        zzcfi.zzj("ClientApi class cannot be loaded.");
        return null;
    }
    
    private final Object f() {
        try {
            return this.c();
        }
        catch (final RemoteException ex) {
            zzcfi.zzk("Cannot invoke remote loader.", (Throwable)ex);
            return null;
        }
    }
    
    protected abstract Object a();
    
    protected abstract Object b(final zzcc p0) throws RemoteException;
    
    protected abstract Object c() throws RemoteException;
    
    public final Object d(final Context context, final boolean b) {
        boolean b2 = b;
        if (!b) {
            zzaw.b();
            b2 = b;
            if (!zzcfb.zzq(context, 12451000)) {
                zzcfi.zze("Google Play Services is not available.");
                b2 = true;
            }
        }
        final int a = DynamiteModule.a(context, "com.google.android.gms.ads.dynamite");
        final int c = DynamiteModule.c(context, "com.google.android.gms.ads.dynamite");
        final int n = 0;
        final boolean b3 = a <= c;
        zzbhy.zzc(context);
        int n3;
        int n4;
        if (zzbjj.zza.zze()) {
            final int n2 = 0;
            n3 = n;
            n4 = n2;
        }
        else if (zzbjj.zzb.zze()) {
            n4 = 1;
            n3 = 1;
        }
        else {
            n3 = ((b2 | (b3 ^ true)) ? 1 : 0);
            n4 = 0;
        }
        Object o;
        if (n3 != 0) {
            final Object e = this.e();
            if ((o = e) == null) {
                o = e;
                if (n4 == 0) {
                    o = this.f();
                }
            }
        }
        else {
            final Object f = this.f();
            if (f == null && zzaw.e().nextInt(((Long)zzbjw.zza.zze()).intValue()) == 0) {
                final Bundle bundle = new Bundle();
                bundle.putString("action", "dynamite_load");
                bundle.putInt("is_missing", 1);
                zzaw.b().zzl(context, zzaw.c().zza, "gmob-apps", bundle, true);
            }
            if (f == null) {
                o = this.e();
            }
            else {
                o = f;
            }
        }
        Object a2;
        if ((a2 = o) == null) {
            a2 = this.a();
        }
        return a2;
    }
}
