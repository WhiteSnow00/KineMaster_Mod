// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

class n
{
    private static AtomicBoolean a;
    
    static {
        n.a = new AtomicBoolean(false);
    }
    
    static void a(final Context context) {
        if (n.a.getAndSet(true)) {
            return;
        }
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)new a());
    }
    
    static class a extends h
    {
        @Override
        public void onActivityCreated(final Activity activity, final Bundle bundle) {
            e0.g(activity);
        }
        
        @Override
        public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        }
        
        @Override
        public void onActivityStopped(final Activity activity) {
        }
    }
}
