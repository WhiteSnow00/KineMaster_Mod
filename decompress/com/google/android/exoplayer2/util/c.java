// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

public final class c implements Runnable
{
    public final NetworkTypeObserver a;
    public final NetworkTypeObserver.Listener b;
    
    public c(final NetworkTypeObserver a, final NetworkTypeObserver.Listener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        NetworkTypeObserver.a(this.a, this.b);
    }
}
