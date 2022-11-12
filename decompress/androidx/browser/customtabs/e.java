// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.customtabs;

import a.b;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class e implements ServiceConnection
{
    private Context mApplicationContext;
    
    Context getApplicationContext() {
        return this.mApplicationContext;
    }
    
    public abstract void onCustomTabsServiceConnected(final ComponentName p0, final c p1);
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        if (this.mApplicationContext != null) {
            this.onCustomTabsServiceConnected(componentName, new c(this, b.a.M0(binder), componentName, this.mApplicationContext) {
                final e d;
            });
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }
    
    void setApplicationContext(final Context mApplicationContext) {
        this.mApplicationContext = mApplicationContext;
    }
}
