// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbtz;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;

final class g extends m
{
    final Context b;
    final zzq c;
    final String d;
    final zzau e;
    
    g(final zzau e, final Context b, final zzq c, final String d) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final /* bridge */ Object a() {
        zzau.q(this.b, "search");
        return new zzer();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.S0(ObjectWrapper.q1(this.b), this.c, this.d, 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        return zzau.b(this.e).a(this.b, this.c, this.d, null, 3);
    }
}
