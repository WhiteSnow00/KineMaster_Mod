// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.diagnostics;

import androidx.work.d;
import androidx.work.ListenableWorker;
import androidx.work.c;
import androidx.work.impl.workers.DiagnosticsWorker;
import e1.n;
import android.content.Intent;
import android.content.Context;
import e1.h;
import android.content.BroadcastReceiver;

public class DiagnosticsReceiver extends BroadcastReceiver
{
    private static final String a;
    
    static {
        a = h.f("DiagnosticsRcvr");
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        h.c().a(DiagnosticsReceiver.a, "Requesting diagnostics", new Throwable[0]);
        try {
            n.d(context).b(c.d(DiagnosticsWorker.class));
        }
        catch (final IllegalStateException ex) {
            h.c().b(DiagnosticsReceiver.a, "WorkManager is not initialized", ex);
        }
    }
}
