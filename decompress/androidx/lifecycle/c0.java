// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlinx.coroutines.v0;
import kotlin.jvm.internal.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011" }, d2 = { "Landroidx/lifecycle/c0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "c0", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lka/r;", "Z", "Landroidx/lifecycle/g;", "b", "Landroidx/lifecycle/g;", "dispatchQueue", "<init>", "()V", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class c0 extends CoroutineDispatcher
{
    public final g b;
    
    public c0() {
        this.b = new g();
    }
    
    public void Z(final CoroutineContext coroutineContext, final Runnable runnable) {
        o.g((Object)coroutineContext, "context");
        o.g((Object)runnable, "block");
        this.b.c(coroutineContext, runnable);
    }
    
    public boolean c0(final CoroutineContext coroutineContext) {
        o.g((Object)coroutineContext, "context");
        return ((CoroutineDispatcher)v0.c().f0()).c0(coroutineContext) || (this.b.b() ^ true);
    }
}
