// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;
import com.google.android.gms.common.api.Status;

public final class zadc
{
    public static final Status c;
    @VisibleForTesting
    final Set a;
    private final l0 b;
    
    static {
        c = new Status(8, "The connection to Google Play services was lost");
    }
    
    public zadc() {
        this.a = Collections.synchronizedSet((Set<Object>)Collections.newSetFromMap((Map<T, Boolean>)new WeakHashMap<Object, Boolean>()));
        this.b = new l0(this);
    }
    
    final void a(final BasePendingResult basePendingResult) {
        this.a.add(basePendingResult);
        basePendingResult.p(this.b);
    }
    
    public final void b() {
        final Set a = this.a;
        int i = 0;
        for (BasePendingResult[] array = a.toArray(new BasePendingResult[0]); i < array.length; ++i) {
            final BasePendingResult basePendingResult = array[i];
            basePendingResult.p(null);
            if (basePendingResult.o()) {
                this.a.remove(basePendingResult);
            }
        }
    }
}
