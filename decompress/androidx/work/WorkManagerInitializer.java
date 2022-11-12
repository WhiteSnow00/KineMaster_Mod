// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import e1.h;
import e1.n;
import x0.a;

public final class WorkManagerInitializer implements a<n>
{
    private static final String a;
    
    static {
        a = h.f("WrkMgrInitializer");
    }
    
    @Override
    public List<Class<? extends a<?>>> a() {
        return Collections.emptyList();
    }
    
    @Override
    public /* bridge */ Object b(final Context context) {
        return this.c(context);
    }
    
    public n c(final Context context) {
        h.c().a(WorkManagerInitializer.a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        n.e(context, new androidx.work.a.b().a());
        return n.d(context);
    }
}
