// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfl;
import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhy;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;

final class j extends m
{
    final Context b;
    final zzau c;
    
    j(final zzau c, final Context b) {
        this.c = c;
        this.b = b;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        zzau.q(this.b, "mobile_ads_settings");
        return new zzet();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.zzg(ObjectWrapper.q1(this.b), 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        zzbhy.zzc(this.b);
        Object o = zzbhy.zzib;
        final boolean booleanValue = (boolean)zzay.c().zzb((zzbhq)o);
        final Throwable t = null;
        if (booleanValue) {
            try {
                o = ObjectWrapper.q1(this.b);
                o = ((zzcn)zzcfm.zzb(this.b, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", (zzcfk)zzan.a)).M0((IObjectWrapper)o, 221310000);
                if (o == null) {
                    o = t;
                    return o;
                }
                final IInterface queryLocalInterface = ((IBinder)o).queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                if (queryLocalInterface instanceof zzcm) {
                    o = queryLocalInterface;
                }
                else {
                    o = new zzck((IBinder)o);
                }
                return o;
            }
            catch (final NullPointerException o) {}
            catch (final RemoteException o) {}
            catch (final zzcfl zzcfl) {}
            zzau.p(this.c, zzbyx.zza(this.b));
            zzau.m(this.c).zzd((Throwable)o, "ClientApiBroker.getMobileAdsSettingsManager");
            o = t;
        }
        else {
            o = zzau.f(this.c).a(this.b);
        }
        return o;
    }
}
