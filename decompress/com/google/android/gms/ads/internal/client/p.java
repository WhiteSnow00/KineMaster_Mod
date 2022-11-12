// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.ArrayList;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.List;
import com.google.android.gms.internal.ads.zzbql;

final class p extends zzbql
{
    final zzee a;
    
    p(final zzee a, final zzec zzec) {
        this.a = a;
    }
    
    public final void zzb(final List list) throws RemoteException {
        final zzee a = this.a;
        int i = 0;
        zzee.j(a, false);
        zzee.i(this.a, true);
        final InitializationStatus d = zzee.d(this.a, list);
        for (ArrayList h = zzee.h(zzee.f()); i < h.size(); ++i) {
            ((OnInitializationCompleteListener)h.get(i)).a(d);
        }
        zzee.h(zzee.f()).clear();
    }
}
