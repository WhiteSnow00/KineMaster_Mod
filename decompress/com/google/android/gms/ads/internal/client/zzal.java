// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzcfk;

public final class zzal implements zzcfk
{
    public static final zzal a;
    
    static {
        a = new zzal();
    }
    
    private zzal() {
    }
    
    public final Object zza(final Object o) {
        Object o2;
        if (o == null) {
            o2 = null;
        }
        else {
            final IInterface queryLocalInterface = ((IBinder)o).queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            if (queryLocalInterface instanceof zzbp) {
                o2 = queryLocalInterface;
            }
            else {
                o2 = new zzbp((IBinder)o);
            }
        }
        return o2;
    }
}
