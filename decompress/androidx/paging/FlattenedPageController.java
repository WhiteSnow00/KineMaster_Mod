// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ka.r;
import java.util.Iterator;
import java.util.ArrayList;
import kotlin.collections.o;
import ka.k;
import kotlin.coroutines.intrinsics.a;
import kotlin.collections.z;
import java.util.List;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.sync.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\tH\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018" }, d2 = { "Landroidx/paging/FlattenedPageController;", "", "T", "Lkotlin/collections/z;", "Landroidx/paging/u;", "event", "Lka/r;", "b", "(Lkotlin/collections/z;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/g;", "Landroidx/paging/g;", "list", "Lkotlinx/coroutines/sync/c;", "Lkotlinx/coroutines/sync/c;", "lock", "", "c", "I", "maxEventIndex", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
final class FlattenedPageController<T>
{
    private final g<T> a;
    private final c b;
    private int c;
    
    public FlattenedPageController() {
        this.a = new g<T>();
        this.b = d.b(false, 1, (Object)null);
        this.c = -1;
    }
    
    public final Object a(kotlin.coroutines.c<? super List<? extends z<? extends u<T>>>> c) {
        FlattenedPageController$getStateAsEvents.FlattenedPageController$getStateAsEvents$1 flattenedPageController$getStateAsEvents$2 = null;
        Label_0051: {
            if (c instanceof FlattenedPageController$getStateAsEvents.FlattenedPageController$getStateAsEvents$1) {
                final FlattenedPageController$getStateAsEvents.FlattenedPageController$getStateAsEvents$1 flattenedPageController$getStateAsEvents$1 = (FlattenedPageController$getStateAsEvents.FlattenedPageController$getStateAsEvents$1)c;
                final int label = flattenedPageController$getStateAsEvents$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    flattenedPageController$getStateAsEvents$1.label = label + Integer.MIN_VALUE;
                    flattenedPageController$getStateAsEvents$2 = flattenedPageController$getStateAsEvents$1;
                    break Label_0051;
                }
            }
            flattenedPageController$getStateAsEvents$2 = new FlattenedPageController$getStateAsEvents.FlattenedPageController$getStateAsEvents$1(this, c);
        }
        final Object result = flattenedPageController$getStateAsEvents$2.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = flattenedPageController$getStateAsEvents$2.label;
        FlattenedPageController flattenedPageController;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final c c2 = (c)flattenedPageController$getStateAsEvents$2.L$1;
            flattenedPageController = (FlattenedPageController)flattenedPageController$getStateAsEvents$2.L$0;
            k.b(result);
            c = (kotlin.coroutines.c)c2;
        }
        else {
            k.b(result);
            final c b = this.b;
            flattenedPageController$getStateAsEvents$2.L$0 = this;
            flattenedPageController$getStateAsEvents$2.L$1 = b;
            flattenedPageController$getStateAsEvents$2.label = 1;
            if (b.a((Object)null, (kotlin.coroutines.c)flattenedPageController$getStateAsEvents$2) == d) {
                return d;
            }
            flattenedPageController = this;
            c = (kotlin.coroutines.c)b;
        }
        try {
            final List<u<T>> b2 = flattenedPageController.a.b();
            final int c3 = flattenedPageController.c;
            final int size = b2.size();
            final ArrayList list = new ArrayList(o.u((Iterable)b2, 10));
            int n = 0;
            for (final Object next : b2) {
                if (n < 0) {
                    o.t();
                }
                list.add((Object)new z(n + (c3 - size + 1), (Object)next));
                ++n;
            }
            return list;
        }
        finally {
            ((c)c).b((Object)null);
        }
    }
    
    public final Object b(final z<? extends u<T>> l$1, kotlin.coroutines.c<? super r> c) {
        FlattenedPageController$record.FlattenedPageController$record$1 flattenedPageController$record$2 = null;
        Label_0051: {
            if (c instanceof FlattenedPageController$record.FlattenedPageController$record$1) {
                final FlattenedPageController$record.FlattenedPageController$record$1 flattenedPageController$record$1 = (FlattenedPageController$record.FlattenedPageController$record$1)c;
                final int label = flattenedPageController$record$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    flattenedPageController$record$1.label = label + Integer.MIN_VALUE;
                    flattenedPageController$record$2 = flattenedPageController$record$1;
                    break Label_0051;
                }
            }
            flattenedPageController$record$2 = new FlattenedPageController$record.FlattenedPageController$record$1(this, c);
        }
        final Object result = flattenedPageController$record$2.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = flattenedPageController$record$2.label;
        z z;
        FlattenedPageController flattenedPageController;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final c c2 = (c)flattenedPageController$record$2.L$2;
            z = (z)flattenedPageController$record$2.L$1;
            flattenedPageController = (FlattenedPageController)flattenedPageController$record$2.L$0;
            k.b(result);
            c = (kotlin.coroutines.c)c2;
        }
        else {
            k.b(result);
            final c b = this.b;
            flattenedPageController$record$2.L$0 = this;
            flattenedPageController$record$2.L$1 = l$1;
            flattenedPageController$record$2.L$2 = b;
            flattenedPageController$record$2.label = 1;
            if (b.a((Object)null, (kotlin.coroutines.c)flattenedPageController$record$2) == d) {
                return d;
            }
            c = (kotlin.coroutines.c)b;
            z = l$1;
            flattenedPageController = this;
        }
        try {
            flattenedPageController.c = z.c();
            flattenedPageController.a.a((u<T>)z.d());
            return r.a;
        }
        finally {
            ((c)c).b((Object)null);
        }
    }
}
