// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Log;
import android.content.Context;
import android.os.PowerManager$WakeLock;
import android.os.PowerManager;

final class a2
{
    private final PowerManager a;
    private PowerManager$WakeLock b;
    private boolean c;
    private boolean d;
    
    public a2(final Context context) {
        this.a = (PowerManager)context.getApplicationContext().getSystemService("power");
    }
    
    private void c() {
        final PowerManager$WakeLock b = this.b;
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
            final PowerManager a = this.a;
            if (a == null) {
                Log.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            (this.b = a.newWakeLock(1, "ExoPlayer:WakeLockManager")).setReferenceCounted(false);
        }
        this.c = c;
        this.c();
    }
    
    public void b(final boolean d) {
        this.d = d;
        this.c();
    }
}
