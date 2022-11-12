// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.os.Process;

final class a extends Thread
{
    a(final ThreadGroup threadGroup, final String s) {
        super(threadGroup, "GmsDynamite");
    }
    
    @Override
    public final void run() {
        Process.setThreadPriority(19);
        monitorenter(this);
        try {
            try {
                while (true) {
                    this.wait();
                }
            }
            finally {
                monitorexit(this);
            }
        }
        catch (final InterruptedException ex) {}
    }
}
