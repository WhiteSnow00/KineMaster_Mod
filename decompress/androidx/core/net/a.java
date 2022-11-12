// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.net;

import android.net.ConnectivityManager;

public final class a
{
    public static boolean a(final ConnectivityManager connectivityManager) {
        return a.a(connectivityManager);
    }
    
    static class a
    {
        static boolean a(final ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }
}
