// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.os.IBinder;
import android.content.Intent;
import android.app.Service;

public class v extends Service implements r
{
    private final k0 a;
    
    public v() {
        this.a = new k0(this);
    }
    
    public Lifecycle getLifecycle() {
        return this.a.a();
    }
    
    public IBinder onBind(final Intent intent) {
        this.a.b();
        return null;
    }
    
    public void onCreate() {
        this.a.c();
        super.onCreate();
    }
    
    public void onDestroy() {
        this.a.d();
        super.onDestroy();
    }
    
    public void onStart(final Intent intent, final int n) {
        this.a.e();
        super.onStart(intent, n);
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        return super.onStartCommand(intent, n, n2);
    }
}
