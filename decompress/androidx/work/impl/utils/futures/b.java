// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

public final class b<V> extends AbstractFuture<V>
{
    private b() {
    }
    
    public static <V> b<V> t() {
        return new b<V>();
    }
    
    public boolean p(final V v) {
        return super.p(v);
    }
    
    public boolean q(final Throwable t) {
        return super.q(t);
    }
    
    public boolean r(final ListenableFuture<? extends V> listenableFuture) {
        return super.r(listenableFuture);
    }
}
