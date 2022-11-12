// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class a implements Runnable
{
    private final Runnable a;
    
    public a(final Runnable a, final int n) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        Process.setThreadPriority(0);
        this.a.run();
    }
}
