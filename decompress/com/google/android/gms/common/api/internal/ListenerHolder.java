// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import android.os.Looper;
import java.util.concurrent.Executor;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ListenerHolder<L>
{
    private final Executor a;
    private volatile Object b;
    private volatile ListenerKey c;
    
    @KeepForSdk
    ListenerHolder(final Looper looper, final L l, final String s) {
        this.a = new HandlerExecutor(looper);
        this.b = Preconditions.l(l, "Listener must not be null");
        this.c = new ListenerKey((L)l, Preconditions.g(s));
    }
    
    @KeepForSdk
    public void a() {
        this.b = null;
        this.c = null;
    }
    
    @KeepForSdk
    public ListenerKey<L> b() {
        return this.c;
    }
    
    final void c(final Notifier notifier) {
        final Object b = this.b;
        if (b == null) {
            notifier.b();
            return;
        }
        try {
            notifier.a(b);
        }
        catch (final RuntimeException ex) {
            notifier.b();
            throw ex;
        }
    }
    
    @KeepForSdk
    public static final class ListenerKey<L>
    {
        private final Object a;
        private final String b;
        
        @KeepForSdk
        ListenerKey(final L a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        @KeepForSdk
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ListenerKey)) {
                return false;
            }
            final ListenerKey listenerKey = (ListenerKey)o;
            return this.a == listenerKey.a && this.b.equals(listenerKey.b);
        }
        
        @KeepForSdk
        @Override
        public int hashCode() {
            return System.identityHashCode(this.a) * 31 + this.b.hashCode();
        }
    }
    
    @KeepForSdk
    public interface Notifier<L>
    {
        @KeepForSdk
        void a(final L p0);
        
        @KeepForSdk
        void b();
    }
}
