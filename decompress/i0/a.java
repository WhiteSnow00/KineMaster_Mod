// 
// Decompiled by Procyon v0.6.0
// 

package i0;

import android.os.PowerManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.content.Intent;
import android.os.PowerManager$WakeLock;
import android.util.SparseArray;
import android.content.BroadcastReceiver;

@Deprecated
public abstract class a extends BroadcastReceiver
{
    private static final SparseArray<PowerManager$WakeLock> a;
    private static int b;
    
    static {
        a = new SparseArray();
        i0.a.b = 1;
    }
    
    public static boolean b(Intent a) {
        final int intExtra = a.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        a = (Intent)a.a;
        synchronized (a) {
            final PowerManager$WakeLock powerManager$WakeLock = (PowerManager$WakeLock)((SparseArray)a).get(intExtra);
            if (powerManager$WakeLock != null) {
                powerManager$WakeLock.release();
                ((SparseArray)a).remove(intExtra);
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No active wake lock id #");
            sb.append(intExtra);
            Log.w("WakefulBroadcastReceiv.", sb.toString());
            return true;
        }
    }
    
    public static ComponentName c(final Context context, final Intent intent) {
        final SparseArray<PowerManager$WakeLock> a = i0.a.a;
        synchronized (a) {
            final int b = i0.a.b;
            if ((i0.a.b = b + 1) <= 0) {
                i0.a.b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", b);
            final ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            final PowerManager powerManager = (PowerManager)context.getSystemService("power");
            final StringBuilder sb = new StringBuilder();
            sb.append("androidx.core:wake:");
            sb.append(startService.flattenToShortString());
            final PowerManager$WakeLock wakeLock = powerManager.newWakeLock(1, sb.toString());
            wakeLock.setReferenceCounted(false);
            wakeLock.acquire(60000L);
            a.put(b, (Object)wakeLock);
            return startService;
        }
    }
}
