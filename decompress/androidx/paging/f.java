// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import androidx.recyclerview.widget.p;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0002J4\u0010\u0010\u001a\u00020\n\"\b\b\u0000\u0010\f*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¨\u0006\u0013" }, d2 = { "Landroidx/paging/f;", "", "Landroidx/recyclerview/widget/p;", "callback", "", "startBoundary", "endBoundary", "start", "end", "payload", "Lka/r;", "a", "T", "Landroidx/paging/r;", "oldList", "newList", "b", "<init>", "()V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public final class f
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    private final void a(final p p6, int n, final int n2, final int n3, final int n4, final Object o) {
        n -= n3;
        if (n > 0) {
            p6.c(n3, n, o);
        }
        n = n4 - n2;
        if (n > 0) {
            p6.c(n2, n, o);
        }
    }
    
    public final <T> void b(final p p3, final r<T> r, final r<T> r2) {
        o.g((Object)p3, "callback");
        o.g((Object)r, "oldList");
        o.g((Object)r2, "newList");
        final int max = Math.max(r.c(), r2.c());
        final int min = Math.min(r.c() + r.b(), r2.c() + r2.b());
        final int n = min - max;
        if (n > 0) {
            p3.b(max, n);
            p3.a(max, n);
        }
        final int min2 = Math.min(max, min);
        final int max2 = Math.max(max, min);
        this.a(p3, min2, max2, ya.f.f(r.c(), r2.a()), ya.f.f(r.c() + r.b(), r2.a()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        this.a(p3, min2, max2, ya.f.f(r2.c(), r.a()), ya.f.f(r2.c() + r2.b(), r.a()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        final int n2 = r2.a() - r.a();
        if (n2 > 0) {
            p3.a(r.a(), n2);
        }
        else if (n2 < 0) {
            p3.b(r.a() + n2, -n2);
        }
    }
}
