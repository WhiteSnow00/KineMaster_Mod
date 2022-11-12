// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.content.res.Configuration;
import android.app.Activity;
import android.content.ComponentCallbacks2;

final class i implements k, ComponentCallbacks2
{
    @Override
    public void a(final Activity activity) {
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
    }
    
    public void onLowMemory() {
        this.onTrimMemory(20);
    }
    
    public void onTrimMemory(final int n) {
    }
}
