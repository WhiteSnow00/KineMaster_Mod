// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

public final class zacb implements Runnable
{
    public final ListenerHolder a;
    public final ListenerHolder.Notifier b;
    
    @Override
    public final void run() {
        this.a.c(this.b);
    }
}
