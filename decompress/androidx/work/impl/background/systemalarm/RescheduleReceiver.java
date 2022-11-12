// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import f1.i;
import android.content.Intent;
import android.content.Context;
import e1.h;
import android.content.BroadcastReceiver;

public class RescheduleReceiver extends BroadcastReceiver
{
    private static final String a;
    
    static {
        a = h.f("RescheduleReceiver");
    }
    
    public void onReceive(final Context context, final Intent intent) {
        h.c().a(RescheduleReceiver.a, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            i.k(context).t(this.goAsync());
        }
        catch (final IllegalStateException ex) {
            h.c().b(RescheduleReceiver.a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", ex);
        }
    }
}
