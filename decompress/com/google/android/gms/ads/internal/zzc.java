// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.BaseGmsClient;

public abstract class zzc extends BaseGmsClient
{
    protected zzc(final Context context, final Looper looper, final int n, final BaseConnectionCallbacks baseConnectionCallbacks, final BaseOnConnectionFailedListener baseOnConnectionFailedListener, final String s) {
        super(context, looper, n, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }
}
