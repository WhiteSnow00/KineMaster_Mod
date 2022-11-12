// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.Iterator;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Looper;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ListenerHolders
{
    private final Set a;
    
    public ListenerHolders() {
        this.a = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
    }
    
    @KeepForSdk
    public static <L> ListenerHolder<L> a(final L l, final Looper looper, final String s) {
        Preconditions.l(l, "Listener must not be null");
        Preconditions.l(looper, "Looper must not be null");
        Preconditions.l(s, "Listener type must not be null");
        return new ListenerHolder<L>(looper, l, s);
    }
    
    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> b(final L l, final String s) {
        Preconditions.l(l, "Listener must not be null");
        Preconditions.l(s, "Listener type must not be null");
        Preconditions.h(s, "Listener type must not be empty");
        return (ListenerHolder.ListenerKey<L>)new ListenerHolder.ListenerKey(l, s);
    }
    
    public final void c() {
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((ListenerHolder)iterator.next()).a();
        }
        this.a.clear();
    }
}
