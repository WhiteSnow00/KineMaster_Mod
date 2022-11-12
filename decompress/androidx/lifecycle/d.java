// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.t1;
import kotlin.jvm.internal.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.Metadata;
import kotlinx.coroutines.j0;
import java.io.Closeable;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e" }, d2 = { "Landroidx/lifecycle/d;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/j0;", "Lka/r;", "close", "Lkotlin/coroutines/CoroutineContext;", "a", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-viewmodel-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class d implements Closeable, j0
{
    private final CoroutineContext a;
    
    public d(final CoroutineContext a) {
        o.g((Object)a, "context");
        this.a = a;
    }
    
    @Override
    public void close() {
        t1.d(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
    }
    
    public CoroutineContext getCoroutineContext() {
        return this.a;
    }
}
