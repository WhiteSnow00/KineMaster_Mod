// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzcfk;

public final class zzan implements zzcfk
{
    public static final zzan a;
    
    static {
        a = new zzan();
    }
    
    private zzan() {
    }
    
    public final Object zza(final Object o) {
        Object o2;
        if (o == null) {
            o2 = null;
        }
        else {
            final IInterface queryLocalInterface = ((IBinder)o).queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            if (queryLocalInterface instanceof zzcn) {
                o2 = queryLocalInterface;
            }
            else {
                o2 = new zzcn((IBinder)o);
            }
        }
        return o2;
    }
}
