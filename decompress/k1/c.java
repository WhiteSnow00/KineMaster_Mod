// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.content.IntentFilter;
import android.content.Intent;
import o1.a;
import android.content.Context;
import e1.h;
import android.content.BroadcastReceiver;

public abstract class c<T> extends d<T>
{
    private static final String h;
    private final BroadcastReceiver g;
    
    static {
        h = e1.h.f("BrdcstRcvrCnstrntTrckr");
    }
    
    public c(final Context context, final a a) {
        super(context, a);
        this.g = new BroadcastReceiver() {
            final c a;
            
            public void onReceive(final Context context, final Intent intent) {
                if (intent != null) {
                    this.a.h(context, intent);
                }
            }
        };
    }
    
    @Override
    public void e() {
        e1.h.c().a(c.h, String.format("%s: registering receiver", this.getClass().getSimpleName()), new Throwable[0]);
        super.b.registerReceiver(this.g, this.g());
    }
    
    @Override
    public void f() {
        e1.h.c().a(c.h, String.format("%s: unregistering receiver", this.getClass().getSimpleName()), new Throwable[0]);
        super.b.unregisterReceiver(this.g);
    }
    
    public abstract IntentFilter g();
    
    public abstract void h(final Context p0, final Intent p1);
}
