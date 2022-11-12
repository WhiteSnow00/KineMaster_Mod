// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzbpm;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;

final class d extends m
{
    final Context b;
    final zzbtz c;
    final OnH5AdsEventListener d;
    
    d(final zzau zzau, final Context b, final zzbtz c, final OnH5AdsEventListener d) {
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    protected final Object a() {
        return new zzbpq();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.I0(ObjectWrapper.q1(this.b), this.c, 221310000, (zzbpg)new zzbpd(this.d));
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        final IObjectWrapper q1 = ObjectWrapper.q1(this.b);
        zzbpj zze;
        try {
            zze = ((zzbpm)zzcfm.zzb(this.b, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", (zzcfk)zzaf.a)).zze(q1, this.c, 221310000, (zzbpg)new zzbpd(this.d));
        }
        catch (final zzcfl | RemoteException | NullPointerException ex) {
            zze = null;
        }
        return zze;
    }
}
