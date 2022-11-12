// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.Iterator;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.t;
import kotlinx.coroutines.flow.i;
import ka.r;
import sa.l;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001a\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0017J\u001a\u0010\u001a\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0017R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00170\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R$\u0010*\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R(\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b$\u0010)R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010-R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b\"\u00101¨\u00065" }, d2 = { "Landroidx/paging/o;", "", "Landroidx/paging/c;", "j", "Lka/r;", "k", "Landroidx/paging/l;", "previousState", "sourceRefreshState", "sourceState", "remoteState", "b", "Landroidx/paging/n;", "sourceLoadStates", "remoteLoadStates", "h", "Landroidx/paging/LoadType;", "type", "", "remote", "state", "i", "c", "Lkotlin/Function1;", "listener", "a", "g", "Z", "isInitialized", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Landroidx/paging/l;", "refresh", "d", "prepend", "e", "append", "<set-?>", "f", "Landroidx/paging/n;", "()Landroidx/paging/n;", "source", "mediator", "Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/i;", "_stateFlow", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/c;", "()Lkotlinx/coroutines/flow/c;", "flow", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class o
{
    private boolean a;
    private final CopyOnWriteArrayList<l<c, r>> b;
    private androidx.paging.l c;
    private androidx.paging.l d;
    private androidx.paging.l e;
    private n f;
    private n g;
    private final i<c> h;
    private final kotlinx.coroutines.flow.c<c> i;
    
    public o() {
        this.b = new CopyOnWriteArrayList<l<c, r>>();
        final androidx.paging.l.c.a b = androidx.paging.l.c.b;
        this.c = b.b();
        this.d = b.b();
        this.e = b.b();
        this.f = n.d.a();
        final i a = t.a((Object)null);
        this.h = (i<c>)a;
        this.i = (kotlinx.coroutines.flow.c<c>)kotlinx.coroutines.flow.e.r((kotlinx.coroutines.flow.c)a);
    }
    
    private final androidx.paging.l b(androidx.paging.l l, final androidx.paging.l i, final androidx.paging.l j, final androidx.paging.l k) {
        if (k == null) {
            return j;
        }
        if (l instanceof androidx.paging.l.b) {
            if (!(i instanceof androidx.paging.l.c) || !(k instanceof androidx.paging.l.c)) {
                if (!(k instanceof androidx.paging.l.a)) {
                    return l;
                }
            }
        }
        l = k;
        return l;
    }
    
    private final c j() {
        c c;
        if (!this.a) {
            c = null;
        }
        else {
            c = new c(this.c, this.d, this.e, this.f, this.g);
        }
        return c;
    }
    
    private final void k() {
        final androidx.paging.l c = this.c;
        final androidx.paging.l g = this.f.g();
        final androidx.paging.l g2 = this.f.g();
        final n g3 = this.g;
        final androidx.paging.l l = null;
        androidx.paging.l g4;
        if (g3 == null) {
            g4 = null;
        }
        else {
            g4 = g3.g();
        }
        this.c = this.b(c, g, g2, g4);
        final androidx.paging.l d = this.d;
        final androidx.paging.l g5 = this.f.g();
        final androidx.paging.l f = this.f.f();
        final n g6 = this.g;
        androidx.paging.l f2;
        if (g6 == null) {
            f2 = null;
        }
        else {
            f2 = g6.f();
        }
        this.d = this.b(d, g5, f, f2);
        final androidx.paging.l e = this.e;
        final androidx.paging.l g7 = this.f.g();
        final androidx.paging.l e2 = this.f.e();
        final n g8 = this.g;
        androidx.paging.l e3;
        if (g8 == null) {
            e3 = l;
        }
        else {
            e3 = g8.e();
        }
        this.e = this.b(e, g7, e2, e3);
        final c j = this.j();
        if (j != null) {
            this.h.setValue((Object)j);
            final Iterator<Object> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                iterator.next().invoke((Object)j);
            }
        }
    }
    
    public final void a(final l<? super c, r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.b.add((l<c, r>)l);
        final c j = this.j();
        if (j != null) {
            l.invoke((Object)j);
        }
    }
    
    public final androidx.paging.l c(final LoadType loadType, final boolean b) {
        kotlin.jvm.internal.o.g((Object)loadType, "type");
        n n;
        if (b) {
            n = this.g;
        }
        else {
            n = this.f;
        }
        androidx.paging.l d;
        if (n == null) {
            d = null;
        }
        else {
            d = n.d(loadType);
        }
        return d;
    }
    
    public final kotlinx.coroutines.flow.c<c> d() {
        return this.i;
    }
    
    public final n e() {
        return this.g;
    }
    
    public final n f() {
        return this.f;
    }
    
    public final void g(final l<? super c, r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.b.remove(l);
    }
    
    public final void h(final n f, final n g) {
        kotlin.jvm.internal.o.g((Object)f, "sourceLoadStates");
        this.a = true;
        this.f = f;
        this.g = g;
        this.k();
    }
    
    public final boolean i(final LoadType loadType, final boolean b, final androidx.paging.l l) {
        kotlin.jvm.internal.o.g((Object)loadType, "type");
        kotlin.jvm.internal.o.g((Object)l, "state");
        final boolean b2 = true;
        this.a = true;
        boolean b3 = false;
        Label_0114: {
            if (b) {
                final n g = this.g;
                n a;
                if (g == null) {
                    a = n.d.a();
                }
                else {
                    a = g;
                }
                final n h = a.h(loadType, l);
                this.g = h;
                if (!kotlin.jvm.internal.o.b((Object)h, (Object)g)) {
                    b3 = b2;
                    break Label_0114;
                }
            }
            else {
                final n f = this.f;
                final n h2 = f.h(loadType, l);
                this.f = h2;
                if (!kotlin.jvm.internal.o.b((Object)h2, (Object)f)) {
                    b3 = b2;
                    break Label_0114;
                }
            }
            b3 = false;
        }
        this.k();
        return b3;
    }
}
