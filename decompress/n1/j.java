// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import java.util.Iterator;
import android.os.PowerManager;
import android.content.Context;
import java.util.Map;
import java.util.HashMap;
import e1.h;
import android.os.PowerManager$WakeLock;
import java.util.WeakHashMap;

public class j
{
    private static final String a;
    private static final WeakHashMap<PowerManager$WakeLock, String> b;
    
    static {
        a = h.f("WakeLocks");
        b = new WeakHashMap<PowerManager$WakeLock, String>();
    }
    
    public static void a() {
        final HashMap hashMap = new HashMap();
        Object o = j.b;
        synchronized (o) {
            hashMap.putAll((Map)o);
            monitorexit(o);
            o = hashMap.keySet().iterator();
            while (((Iterator)o).hasNext()) {
                final PowerManager$WakeLock powerManager$WakeLock = (PowerManager$WakeLock)((Iterator)o).next();
                if (powerManager$WakeLock != null && powerManager$WakeLock.isHeld()) {
                    h.c().h(j.a, String.format("WakeLock held for %s", hashMap.get(powerManager$WakeLock)), new Throwable[0]);
                }
            }
        }
    }
    
    public static PowerManager$WakeLock b(final Context context, String b) {
        final PowerManager powerManager = (PowerManager)context.getApplicationContext().getSystemService("power");
        final StringBuilder sb = new StringBuilder();
        sb.append("WorkManager: ");
        sb.append(b);
        final String string = sb.toString();
        final PowerManager$WakeLock wakeLock = powerManager.newWakeLock(1, string);
        b = (String)j.b;
        synchronized (b) {
            ((WeakHashMap<PowerManager$WakeLock, String>)b).put(wakeLock, string);
            return wakeLock;
        }
    }
}
