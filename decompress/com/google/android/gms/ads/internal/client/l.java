// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcbp;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;

final class l extends m
{
    final Context b;
    final String c;
    final zzbtz d;
    final zzau e;
    
    l(final zzau e, final Context b, final String c, final zzbtz d) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    protected final /* bridge */ Object a() {
        zzau.q(this.b, "rewarded");
        return new zzex();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.Q0(ObjectWrapper.q1(this.b), this.c, this.d, 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        return zzcbp.zza(this.b, this.c, this.d);
    }
}
