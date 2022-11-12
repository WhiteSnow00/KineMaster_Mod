// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbv extends zzaqw implements zzbw
{
    public static zzbw M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        if (queryLocalInterface instanceof zzbw) {
            return (zzbw)queryLocalInterface;
        }
        return new zzbu(binder);
    }
}
