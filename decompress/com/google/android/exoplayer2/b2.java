// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Log;
import android.content.Context;
import android.net.wifi.WifiManager$WifiLock;
import android.net.wifi.WifiManager;

final class b2
{
    private final WifiManager a;
    private WifiManager$WifiLock b;
    private boolean c;
    private boolean d;
    
    public b2(final Context context) {
        this.a = (WifiManager)context.getApplicationContext().getSystemService("wifi");
    }
    
    private void c() {
        final WifiManager$WifiLock b = this.b;
        if (b == null) {
            return;
        }
        if (this.c && this.d) {
            b.acquire();
        }
        else {
            b.release();
        }
    }
    
    public void a(final boolean c) {
        if (c && this.b == null) {
            final WifiManager a = this.a;
            if (a == null) {
                Log.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            (this.b = a.createWifiLock(3, "ExoPlayer:WifiLockManager")).setReferenceCounted(false);
        }
        this.c = c;
        this.c();
    }
    
    public void b(final boolean d) {
        this.d = d;
        this.c();
    }
}
