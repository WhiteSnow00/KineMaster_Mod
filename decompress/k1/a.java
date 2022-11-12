// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.Context;
import e1.h;

public class a extends c<Boolean>
{
    private static final String i;
    
    static {
        i = e1.h.f("BatteryChrgTracker");
    }
    
    public a(final Context context, final o1.a a) {
        super(context, a);
    }
    
    private boolean j(final Intent intent) {
        final int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
    
    @Override
    public /* bridge */ Object b() {
        return this.i();
    }
    
    @Override
    public IntentFilter g() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }
    
    @Override
    public void h(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        final h c = e1.h.c();
        final String i = a.i;
        int n = 1;
        c.a(i, String.format("Received %s", action), new Throwable[0]);
        Label_0157: {
            switch (action) {
                case "android.intent.action.ACTION_POWER_CONNECTED": {
                    n = 3;
                    break Label_0157;
                }
                case "android.os.action.CHARGING": {
                    n = 2;
                    break Label_0157;
                }
                case "android.os.action.DISCHARGING": {
                    break Label_0157;
                }
                case "android.intent.action.ACTION_POWER_DISCONNECTED": {
                    n = 0;
                    break Label_0157;
                }
                default:
                    break;
            }
            n = -1;
        }
        switch (n) {
            case 3: {
                this.d(Boolean.TRUE);
                break;
            }
            case 2: {
                this.d(Boolean.TRUE);
                break;
            }
            case 1: {
                this.d(Boolean.FALSE);
                break;
            }
            case 0: {
                this.d(Boolean.FALSE);
                break;
            }
        }
    }
    
    public Boolean i() {
        final Intent registerReceiver = super.b.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            e1.h.c().b(a.i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return this.j(registerReceiver);
    }
}
