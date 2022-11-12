// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Map;

public final class zaad
{
    private final Map a;
    private final Map b;
    
    public zaad() {
        this.a = Collections.synchronizedMap(new WeakHashMap<Object, Object>());
        this.b = Collections.synchronizedMap(new WeakHashMap<Object, Object>());
    }
    
    static /* bridge */ Map a(final zaad zaad) {
        return zaad.a;
    }
    
    static /* bridge */ Map b(final zaad zaad) {
        return zaad.b;
    }
    
    private final void h(final boolean b, final Status status) {
        Object o = this.a;
        synchronized (o) {
            final HashMap hashMap = new HashMap(this.a);
            monitorexit(o);
            Object b2 = this.b;
            synchronized (b2) {
                o = new HashMap<Object, Object>(this.b);
                monitorexit(b2);
                final Iterator iterator = hashMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    b2 = iterator.next();
                    if (b || ((Map.Entry<K, Boolean>)b2).getValue()) {
                        ((BasePendingResult)((Map.Entry)b2).getKey()).f(status);
                    }
                }
                o = ((Map<Object, Object>)o).entrySet().iterator();
                while (((Iterator)o).hasNext()) {
                    b2 = ((Iterator<Map.Entry<BasePendingResult, V>>)o).next();
                    if (b || ((Map.Entry<K, Boolean>)b2).getValue()) {
                        ((TaskCompletionSource)((Map.Entry)b2).getKey()).d((Exception)new ApiException(status));
                    }
                }
            }
        }
    }
    
    final void c(final BasePendingResult basePendingResult, final boolean b) {
        this.a.put(basePendingResult, b);
        basePendingResult.b((PendingResult.StatusListener)new b(this, basePendingResult));
    }
    
    final void d(final TaskCompletionSource taskCompletionSource, final boolean b) {
        this.b.put(taskCompletionSource, b);
        taskCompletionSource.a().c((OnCompleteListener)new c(this, taskCompletionSource));
    }
    
    final void e(final int n, final String s) {
        final StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (n == 1) {
            sb.append(" due to service disconnection.");
        }
        else if (n == 3) {
            sb.append(" due to dead object exception.");
        }
        if (s != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(s);
        }
        this.h(true, new Status(20, sb.toString()));
    }
    
    public final void f() {
        this.h(false, GoogleApiManager.C);
    }
    
    final boolean g() {
        return !this.a.isEmpty() || !this.b.isEmpty();
    }
}
