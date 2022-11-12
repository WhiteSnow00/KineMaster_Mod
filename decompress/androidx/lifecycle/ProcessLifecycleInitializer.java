// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import x0.a;

public final class ProcessLifecycleInitializer implements a<r>
{
    @Override
    public List<Class<? extends a<?>>> a() {
        return Collections.emptyList();
    }
    
    @Override
    public /* bridge */ Object b(final Context context) {
        return this.c(context);
    }
    
    public r c(final Context context) {
        if (androidx.startup.a.e(context).g(ProcessLifecycleInitializer.class)) {
            n.a(context);
            d0.i(context);
            return d0.h();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
    }
}
