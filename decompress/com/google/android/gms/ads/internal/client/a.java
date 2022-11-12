// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzbxx;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhy;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;
import android.app.Activity;

final class a extends m
{
    final Activity b;
    final zzau c;
    
    a(final zzau c, final Activity b) {
        this.c = c;
        this.b = b;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        zzau.q((Context)this.b, "ad_overlay");
        return null;
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.zzl(ObjectWrapper.q1(this.b));
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        zzbhy.zzc((Context)this.b);
        Object o = zzbhy.zzib;
        if (zzay.c().zzb((zzbhq)o)) {
            try {
                o = ObjectWrapper.q1(this.b);
                o = zzbxt.zzF(((zzbxx)zzcfm.zzb((Context)this.b, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", (zzcfk)zzz.a)).zze((IObjectWrapper)o));
                return o;
            }
            catch (final NullPointerException o) {}
            catch (final RemoteException o) {}
            catch (final zzcfl zzcfl) {}
            zzau.p(this.c, zzbyx.zza(this.b.getApplicationContext()));
            zzau.m(this.c).zzd((Throwable)o, "ClientApiBroker.createAdOverlay");
            o = null;
        }
        else {
            o = zzau.k(this.c).zza(this.b);
        }
        return o;
    }
}
