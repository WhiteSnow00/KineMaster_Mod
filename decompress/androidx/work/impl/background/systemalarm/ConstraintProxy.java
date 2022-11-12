// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import e1.a;
import java.util.Iterator;
import androidx.work.NetworkType;
import m1.p;
import java.util.List;
import android.content.Context;
import e1.h;
import android.content.BroadcastReceiver;

abstract class ConstraintProxy extends BroadcastReceiver
{
    private static final String a;
    
    static {
        a = h.f("ConstraintProxy");
    }
    
    static void a(final Context context, final List<p> list) {
        final Iterator<p> iterator = list.iterator();
        int n = 0;
        int n2 = 0;
        int n4;
        int n3 = n4 = n2;
        int n5;
        int n6;
        int n7;
        int n8;
        while (true) {
            n5 = n;
            n6 = n2;
            n7 = n3;
            n8 = n4;
            if (!iterator.hasNext()) {
                break;
            }
            final a j = iterator.next().j;
            n5 = (n | (j.f() ? 1 : 0));
            n6 = (n2 | (j.g() ? 1 : 0));
            n7 = (n3 | (j.i() ? 1 : 0));
            n8 = (n4 | ((j.b() != NetworkType.NOT_REQUIRED) ? 1 : 0));
            n = n5;
            n2 = n6;
            n3 = n7;
            n4 = n8;
            if (n5 == 0) {
                continue;
            }
            n = n5;
            n2 = n6;
            n3 = n7;
            n4 = n8;
            if (n6 == 0) {
                continue;
            }
            n = n5;
            n2 = n6;
            n3 = n7;
            n4 = n8;
            if (n7 == 0) {
                continue;
            }
            n = n5;
            n2 = n6;
            n3 = n7;
            if ((n4 = n8) != 0) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, (boolean)(n5 != 0), (boolean)(n6 != 0), (boolean)(n7 != 0), (boolean)(n8 != 0)));
    }
    
    public void onReceive(final Context context, final Intent intent) {
        h.c().a(ConstraintProxy.a, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(b.a(context));
    }
    
    public static class BatteryChargingProxy extends ConstraintProxy
    {
        @Override
        public /* bridge */ void onReceive(final Context context, final Intent intent) {
            super.onReceive(context, intent);
        }
    }
    
    public static class BatteryNotLowProxy extends ConstraintProxy
    {
        @Override
        public /* bridge */ void onReceive(final Context context, final Intent intent) {
            super.onReceive(context, intent);
        }
    }
    
    public static class NetworkStateProxy extends ConstraintProxy
    {
        @Override
        public /* bridge */ void onReceive(final Context context, final Intent intent) {
            super.onReceive(context, intent);
        }
    }
    
    public static class StorageNotLowProxy extends ConstraintProxy
    {
        @Override
        public /* bridge */ void onReceive(final Context context, final Intent intent) {
            super.onReceive(context, intent);
        }
    }
}
