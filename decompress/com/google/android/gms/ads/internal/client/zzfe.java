// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.internal.ads.zzbmq;

public final class zzfe extends zzbmq
{
    private final ShouldDelayBannerRenderingListener a;
    
    public final boolean zzb(final IObjectWrapper objectWrapper) throws RemoteException {
        return this.a.shouldDelayBannerRendering(ObjectWrapper.p1(objectWrapper));
    }
}
