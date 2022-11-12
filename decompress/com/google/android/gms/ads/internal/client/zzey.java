// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

public final class zzey extends zzda
{
    private final OnAdMetadataChangedListener a;
    
    public zzey(final OnAdMetadataChangedListener a) {
        this.a = a;
    }
    
    public final void zze() throws RemoteException {
        final OnAdMetadataChangedListener a = this.a;
        if (a != null) {
            a.a();
        }
    }
}
