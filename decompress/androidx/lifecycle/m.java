// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.q1$a;
import kotlinx.coroutines.q1;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017" }, d2 = { "Landroidx/lifecycle/m;", "", "Lka/r;", "b", "Landroidx/lifecycle/Lifecycle;", "a", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/g;", "c", "Landroidx/lifecycle/g;", "dispatchQueue", "Landroidx/lifecycle/o;", "d", "Landroidx/lifecycle/o;", "observer", "Lkotlinx/coroutines/q1;", "parentJob", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/g;Lkotlinx/coroutines/q1;)V", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class m
{
    private final Lifecycle a;
    private final Lifecycle.State b;
    private final g c;
    private final o d;
    
    public m(final Lifecycle a, final Lifecycle.State b, final g c, final q1 q1) {
        kotlin.jvm.internal.o.g((Object)a, "lifecycle");
        kotlin.jvm.internal.o.g((Object)b, "minState");
        kotlin.jvm.internal.o.g((Object)c, "dispatchQueue");
        kotlin.jvm.internal.o.g((Object)q1, "parentJob");
        this.a = a;
        this.b = b;
        this.c = c;
        final l d = new l(this, q1);
        this.d = d;
        if (a.b() == Lifecycle.State.DESTROYED) {
            q1$a.a(q1, (CancellationException)null, 1, (Object)null);
            this.b();
        }
        else {
            a.a(d);
        }
    }
    
    public static void a(final m m, final q1 q1, final r r, final Lifecycle.Event event) {
        c(m, q1, r, event);
    }
    
    private static final void c(final m m, final q1 q1, final r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)m, "this$0");
        kotlin.jvm.internal.o.g((Object)q1, "$parentJob");
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)event, "<anonymous parameter 1>");
        if (r.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            q1$a.a(q1, (CancellationException)null, 1, (Object)null);
            m.b();
        }
        else if (r.getLifecycle().b().compareTo(m.b) < 0) {
            m.c.h();
        }
        else {
            m.c.i();
        }
    }
    
    public final void b() {
        this.a.c(this.d);
        this.c.g();
    }
}
