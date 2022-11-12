// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzcec;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;

final class b extends m
{
    final Context b;
    final zzbtz c;
    
    b(final zzau zzau, final Context b, final zzbtz c) {
        this.b = b;
        this.c = c;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        return null;
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.o(ObjectWrapper.q1(this.b), this.c, 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        final IObjectWrapper q1 = ObjectWrapper.q1(this.b);
        zzcdz zze;
        try {
            zze = ((zzcec)zzcfm.zzb(this.b, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", (zzcfk)zzab.a)).zze(q1, this.c, 221310000);
        }
        catch (final zzcfl | RemoteException | NullPointerException ex) {
            zze = null;
        }
        return zze;
    }
}
