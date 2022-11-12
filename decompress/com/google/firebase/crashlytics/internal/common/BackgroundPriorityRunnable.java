// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

public abstract class BackgroundPriorityRunnable implements Runnable
{
    protected abstract void a();
    
    @Override
    public final void run() {
        Process.setThreadPriority(10);
        this.a();
    }
}
