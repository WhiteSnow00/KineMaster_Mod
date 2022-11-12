// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.customtabs;

import android.os.IInterface;
import android.os.IBinder;
import android.app.PendingIntent;
import android.content.ComponentName;
import a.a;
import a.b;

public final class f
{
    private final Object a;
    private final b b;
    private final a c;
    private final ComponentName d;
    private final PendingIntent e;
    
    f(final b b, final a c, final ComponentName d, final PendingIntent e) {
        this.a = new Object();
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    IBinder a() {
        return ((IInterface)this.c).asBinder();
    }
    
    ComponentName b() {
        return this.d;
    }
    
    PendingIntent c() {
        return this.e;
    }
}
