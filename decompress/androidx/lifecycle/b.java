// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.app.Application;

public class b extends l0
{
    private Application mApplication;
    
    public b(final Application mApplication) {
        this.mApplication = mApplication;
    }
    
    public <T extends Application> T getApplication() {
        return (T)this.mApplication;
    }
}
