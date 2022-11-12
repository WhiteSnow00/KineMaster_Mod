// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.concurrent.locks.Lock;
import java.util.Iterator;
import kotlin.jvm.internal.i;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import sa.a;
import ka.r;
import sa.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0019\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f" }, d2 = { "Landroidx/paging/j;", "T", "", "", "a", "()I", "callback", "Lka/r;", "d", "(Ljava/lang/Object;)V", "e", "c", "()V", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "Ljava/util/List;", "callbacks", "", "<set-?>", "Z", "b", "()Z", "invalid", "Lkotlin/Function1;", "callbackInvoker", "Lkotlin/Function0;", "invalidGetter", "<init>", "(Lsa/l;Lsa/a;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class j<T>
{
    private final l<T, r> a;
    private final a<Boolean> b;
    private final ReentrantLock c;
    private final List<T> d;
    private boolean e;
    
    public j(final l<? super T, r> a, final a<Boolean> b) {
        o.g((Object)a, "callbackInvoker");
        this.a = (l<T, r>)a;
        this.b = b;
        this.c = new ReentrantLock();
        this.d = new ArrayList<T>();
    }
    
    public j(final l l, a a, final int n, final i i) {
        if ((n & 0x2) != 0x0) {
            a = null;
        }
        this(l, a);
    }
    
    public final int a() {
        return this.d.size();
    }
    
    public final boolean b() {
        return this.e;
    }
    
    public final void c() {
        if (this.e) {
            return;
        }
        Object o = this.c;
        ((Lock)o).lock();
        try {
            if (this.b()) {
                return;
            }
            this.e = true;
            final List n0 = kotlin.collections.o.N0((Iterable)this.d);
            this.d.clear();
            final r a = r.a;
            ((Lock)o).unlock();
            if (n0 != null) {
                o = this.a;
                final Iterator iterator = n0.iterator();
                while (iterator.hasNext()) {
                    ((l)o).invoke(iterator.next());
                }
            }
        }
        finally {
            ((Lock)o).unlock();
        }
    }
    
    public final void d(final T t) {
        final a<Boolean> b = this.b;
        final int n = 0;
        if (b != null && (boolean)b.invoke()) {
            this.c();
        }
        if (this.e) {
            this.a.invoke((Object)t);
            return;
        }
        final ReentrantLock c = this.c;
        c.lock();
        try {
            int n2;
            if (this.b()) {
                final r a = r.a;
                n2 = 1;
            }
            else {
                this.d.add(t);
                n2 = n;
            }
            c.unlock();
            if (n2 != 0) {
                this.a.invoke((Object)t);
            }
        }
        finally {
            c.unlock();
        }
    }
    
    public final void e(final T t) {
        final ReentrantLock c = this.c;
        c.lock();
        try {
            this.d.remove(t);
        }
        finally {
            c.unlock();
        }
    }
}
