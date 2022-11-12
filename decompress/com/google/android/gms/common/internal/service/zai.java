// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.common.internal.TelemetryData;
import android.os.IBinder;
import com.google.android.gms.internal.base.zaa;

public final class zai extends zaa
{
    zai(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }
    
    public final void M0(final TelemetryData telemetryData) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zad(zaa, (Parcelable)telemetryData);
        this.zad(1, zaa);
    }
}
