// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.util.Log;
import androidx.core.content.a;
import android.content.Context;

public class f implements d
{
    @Override
    public c a(final Context context, final c.a a) {
        final boolean b = a.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            String s;
            if (b) {
                s = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            }
            else {
                s = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d("ConnectivityMonitor", s);
        }
        c c;
        if (b) {
            c = new e(context, a);
        }
        else {
            c = new n();
        }
        return c;
    }
}
