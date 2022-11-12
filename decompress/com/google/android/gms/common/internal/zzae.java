// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.common.zzb;

public abstract class zzae extends zzb implements zzaf
{
    public static zzaf M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof zzaf) {
            return (zzaf)queryLocalInterface;
        }
        return new zzad(binder);
    }
}
