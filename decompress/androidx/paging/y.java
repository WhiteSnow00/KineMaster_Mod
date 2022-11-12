// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.List;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.flow.e;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0007B%\b\u0000\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011" }, d2 = { "Landroidx/paging/y;", "", "T", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/u;", "a", "Lkotlinx/coroutines/flow/c;", "b", "()Lkotlinx/coroutines/flow/c;", "flow", "Landroidx/paging/f0;", "Landroidx/paging/f0;", "c", "()Landroidx/paging/f0;", "receiver", "<init>", "(Lkotlinx/coroutines/flow/c;Landroidx/paging/f0;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class y<T>
{
    public static final b c;
    private static final f0 d;
    private static final y<Object> e;
    private final c<u<T>> a;
    private final f0 b;
    
    static {
        c = new b(null);
        e = new y<Object>((kotlinx.coroutines.flow.c<? extends u<Object>>)kotlinx.coroutines.flow.e.v((Object)u.b.g.e()), d = new f0() {
            @Override
            public void a(final g0 g0) {
                o.g((Object)g0, "viewportHint");
            }
            
            @Override
            public void b() {
            }
            
            @Override
            public void refresh() {
            }
        });
    }
    
    public y(final c<? extends u<T>> a, final f0 b) {
        o.g((Object)a, "flow");
        o.g((Object)b, "receiver");
        this.a = (c<u<T>>)a;
        this.b = b;
    }
    
    public static final f0 a() {
        return y.d;
    }
    
    public final c<u<T>> b() {
        return this.a;
    }
    
    public final f0 c() {
        return this.b;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0001\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0007R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e" }, d2 = { "Landroidx/paging/y$b;", "", "T", "", "data", "Landroidx/paging/y;", "a", "Landroidx/paging/f0;", "NOOP_RECEIVER", "Landroidx/paging/f0;", "b", "()Landroidx/paging/f0;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class b
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
        
        public final <T> y<T> a(final List<? extends T> list) {
            o.g((Object)list, "data");
            final u.b.a g = u.b.g;
            final List e = kotlin.collections.o.e((Object)new e0(0, list));
            final l.c.a b = l.c.b;
            return new y<T>((kotlinx.coroutines.flow.c<? extends u<Object>>)kotlinx.coroutines.flow.e.v((Object)u.b.a.d(g, e, 0, 0, new n(b.b(), b.a(), b.a()), null, 16, null)), this.b());
        }
        
        public final f0 b() {
            return y.a();
        }
    }
}
