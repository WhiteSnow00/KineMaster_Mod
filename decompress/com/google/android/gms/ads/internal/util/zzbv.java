// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzfnu;
import android.os.Looper;
import android.os.Handler;
import android.os.HandlerThread;

public final class zzbv
{
    private HandlerThread a;
    private Handler b;
    private int c;
    private final Object d;
    
    public zzbv() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = new Object();
    }
    
    public final Handler a() {
        return this.b;
    }
    
    public final Looper b() {
        synchronized (this.d) {
            if (this.c == 0) {
                if (this.a == null) {
                    zze.a("Starting the looper thread.");
                    (this.a = new HandlerThread("LooperProvider")).start();
                    this.b = (Handler)new zzfnu(this.a.getLooper());
                    zze.a("Looper thread started.");
                }
                else {
                    zze.a("Resuming the looper thread");
                    this.d.notifyAll();
                }
            }
            else {
                Preconditions.l(this.a, "Invalid state: mHandlerThread should already been initialized.");
            }
            ++this.c;
            return this.a.getLooper();
        }
    }
}
