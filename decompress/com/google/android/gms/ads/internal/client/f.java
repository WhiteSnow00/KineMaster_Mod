// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;

final class f extends m
{
    final Context b;
    final zzq c;
    final String d;
    final zzbtz e;
    final zzau f;
    
    f(final zzau f, final Context b, final zzq c, final String d, final zzbtz e) {
        this.f = f;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final /* bridge */ Object a() {
        zzau.q(this.b, "app_open");
        return new zzer();
    }
    
    public final /* bridge */ Object b(final zzcc zzcc) throws RemoteException {
        return zzcc.f(ObjectWrapper.q1(this.b), this.c, this.d, this.e, 221310000);
    }
    
    public final /* bridge */ Object c() throws RemoteException {
        return zzau.b(this.f).a(this.b, this.c, this.d, this.e, 4);
    }
}
