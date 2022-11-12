// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhy;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;
import android.widget.FrameLayout;

final class k extends m
{
    final FrameLayout b;
    final FrameLayout c;
    final Context d;
    final zzau e;
    
    k(final zzau e, final FrameLayout b, final FrameLayout c, final Context d) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        zzau.q(this.d, "native_ad_view_delegate");
        return new zzeu();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.P(ObjectWrapper.q1(this.b), ObjectWrapper.q1(this.c));
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        zzbhy.zzc(this.d);
        Object o = zzbhy.zzib;
        if (zzay.c().zzb((zzbhq)o)) {
            try {
                final IObjectWrapper q1 = ObjectWrapper.q1(this.d);
                final IObjectWrapper q2 = ObjectWrapper.q1(this.b);
                o = ObjectWrapper.q1(this.c);
                o = zzbld.zzbB(((zzblh)zzcfm.zzb(this.d, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", (zzcfk)zzap.a)).zze(q1, q2, (IObjectWrapper)o, 221310000));
                return o;
            }
            catch (final NullPointerException o) {}
            catch (final RemoteException o) {}
            catch (final zzcfl zzcfl) {}
            zzau.p(this.e, zzbyx.zza(this.d));
            zzau.m(this.e).zzd((Throwable)o, "ClientApiBroker.createNativeAdViewDelegate");
            o = null;
        }
        else {
            o = zzau.h(this.e).zza(this.d, this.b, this.c);
        }
        return o;
    }
}
