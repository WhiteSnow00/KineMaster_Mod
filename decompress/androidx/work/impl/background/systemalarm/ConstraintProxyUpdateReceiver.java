// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import n1.d;
import android.content.BroadcastReceiver$PendingResult;
import f1.i;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import e1.h;
import android.content.BroadcastReceiver;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver
{
    static final String a;
    
    static {
        a = h.f("ConstrntProxyUpdtRecvr");
    }
    
    public static Intent a(final Context context, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, (Class)ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", b).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", b2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", b3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", b4);
        return intent;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        String action;
        if (intent != null) {
            action = intent.getAction();
        }
        else {
            action = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            h.c().a(ConstraintProxyUpdateReceiver.a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
        }
        else {
            i.k(context).p().b(new Runnable(this, intent, context, this.goAsync()) {
                final Intent a;
                final Context b;
                final BroadcastReceiver$PendingResult c;
                final ConstraintProxyUpdateReceiver d;
                
                @Override
                public void run() {
                    try {
                        final boolean booleanExtra = this.a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        final boolean booleanExtra2 = this.a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        final boolean booleanExtra3 = this.a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        final boolean booleanExtra4 = this.a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        h.c().a(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", booleanExtra, booleanExtra2, booleanExtra3, booleanExtra4), new Throwable[0]);
                        n1.d.a(this.b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        n1.d.a(this.b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        n1.d.a(this.b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        n1.d.a(this.b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    }
                    finally {
                        this.c.finish();
                    }
                }
            });
        }
    }
}
