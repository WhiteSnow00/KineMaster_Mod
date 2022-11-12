// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import o1.a;
import android.content.Context;
import e1.h;

public class b extends c<Boolean>
{
    private static final String i;
    
    static {
        i = e1.h.f("BatteryNotLowTracker");
    }
    
    public b(final Context context, final a a) {
        super(context, a);
    }
    
    @Override
    public /* bridge */ Object b() {
        return this.i();
    }
    
    @Override
    public IntentFilter g() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }
    
    @Override
    public void h(final Context context, final Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        e1.h.c().a(b.i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        final String action = intent.getAction();
        action.hashCode();
        if (!action.equals("android.intent.action.BATTERY_OKAY")) {
            if (action.equals("android.intent.action.BATTERY_LOW")) {
                this.d(Boolean.FALSE);
            }
        }
        else {
            this.d(Boolean.TRUE);
        }
    }
    
    public Boolean i() {
        final Intent registerReceiver = super.b.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean b = false;
        if (registerReceiver == null) {
            e1.h.c().b(k1.b.i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        final int intExtra = registerReceiver.getIntExtra("status", -1);
        final float n = registerReceiver.getIntExtra("level", -1) / (float)registerReceiver.getIntExtra("scale", -1);
        if (intExtra == 1 || n > 0.15f) {
            b = true;
        }
        return b;
    }
}
