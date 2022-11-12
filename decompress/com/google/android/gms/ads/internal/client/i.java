// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhy;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;

final class i extends m
{
    final Context b;
    final String c;
    final zzbtz d;
    final zzau e;
    
    i(final zzau e, final Context b, final String c, final zzbtz d) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        zzau.q(this.b, "native_ad");
        return new zzep();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.c0(ObjectWrapper.q1(this.b), this.c, this.d, 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        zzbhy.zzc(this.b);
        Object o = zzbhy.zzib;
        final boolean booleanValue = (boolean)zzay.c().zzb((zzbhq)o);
        final Throwable t = null;
        if (booleanValue) {
            try {
                o = ObjectWrapper.q1(this.b);
                final IBinder zze = ((zzbp)zzcfm.zzb(this.b, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", (zzcfk)zzal.a)).zze((IObjectWrapper)o, this.c, this.d, 221310000);
                if (zze == null) {
                    o = t;
                    return o;
                }
                o = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                if (o instanceof zzbo) {
                    o = o;
                }
                else {
                    o = new zzbm(zze);
                }
                return o;
            }
            catch (final NullPointerException o) {}
            catch (final RemoteException o) {}
            catch (final zzcfl zzcfl) {}
            zzau.p(this.e, zzbyx.zza(this.b));
            zzau.m(this.e).zzd((Throwable)o, "ClientApiBroker.createAdLoaderBuilder");
            o = t;
        }
        else {
            o = zzau.a(this.e).a(this.b, this.c, this.d);
        }
        return o;
    }
}
