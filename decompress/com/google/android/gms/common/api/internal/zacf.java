// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

public final class zacf implements Runnable
{
    public final NonGmsServiceBrokerClient a;
    
    public zacf(final NonGmsServiceBrokerClient a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.b();
    }
}
