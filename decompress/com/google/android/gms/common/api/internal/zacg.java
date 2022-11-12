// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.IBinder;

public final class zacg implements Runnable
{
    public final NonGmsServiceBrokerClient a;
    public final IBinder b;
    
    public zacg(final NonGmsServiceBrokerClient a, final IBinder b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.e(this.b);
    }
}
