// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ya.f;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.c;
import kotlin.jvm.internal.i;
import ka.r;
import java.util.LinkedHashMap;
import sa.l;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.g;
import java.util.ArrayList;
import java.util.Map;
import kotlinx.coroutines.channels.d;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0007J\u0014\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014J\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J%\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R,\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010+R$\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010/R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010/R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00108R&\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>R$\u0010D\u001a\u00020@2\u0006\u0010-\u001a\u00020@8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b0\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u00101R$\u0010K\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00068@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bH\u00101\"\u0004\bI\u0010JR$\u0010N\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00068@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bL\u00101\"\u0004\bM\u0010J¨\u0006Q" }, d2 = { "Landroidx/paging/PageFetcherSnapshotState;", "", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "", "j", "(Landroidx/paging/LoadType;)I", "Lkotlinx/coroutines/flow/c;", "f", "e", "Landroidx/paging/PagingSource$b$c;", "Landroidx/paging/u;", "u", "(Landroidx/paging/PagingSource$b$c;Landroidx/paging/LoadType;)Landroidx/paging/u;", "loadId", "page", "", "r", "Landroidx/paging/u$a;", "event", "Lka/r;", "h", "Landroidx/paging/g0;", "hint", "i", "Landroidx/paging/g0$a;", "viewportHint", "Landroidx/paging/z;", "g", "(Landroidx/paging/g0$a;)Landroidx/paging/z;", "Landroidx/paging/x;", "a", "Landroidx/paging/x;", "config", "", "b", "Ljava/util/List;", "_pages", "", "c", "m", "()Ljava/util/List;", "pages", "<set-?>", "d", "I", "l", "()I", "initialPageIndex", "_placeholdersBefore", "_placeholdersAfter", "prependGenerationId", "appendGenerationId", "Lkotlinx/coroutines/channels/d;", "Lkotlinx/coroutines/channels/d;", "prependGenerationIdCh", "appendGenerationIdCh", "", "k", "Ljava/util/Map;", "()Ljava/util/Map;", "failedHintsByLoadType", "Landroidx/paging/p;", "Landroidx/paging/p;", "p", "()Landroidx/paging/p;", "sourceLoadStates", "q", "storageCount", "value", "o", "t", "(I)V", "placeholdersBefore", "n", "s", "placeholdersAfter", "<init>", "(Landroidx/paging/x;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class PageFetcherSnapshotState<Key, Value>
{
    private final x a;
    private final List<PagingSource.b.c<Key, Value>> b;
    private final List<PagingSource.b.c<Key, Value>> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final d<Integer> i;
    private final d<Integer> j;
    private final Map<LoadType, g0> k;
    private p l;
    
    private PageFetcherSnapshotState(final x a) {
        this.a = a;
        final ArrayList list = new ArrayList();
        this.b = list;
        this.c = list;
        this.i = (d<Integer>)kotlinx.coroutines.channels.g.b(-1, (BufferOverflow)null, (l)null, 6, (Object)null);
        this.j = (d<Integer>)kotlinx.coroutines.channels.g.b(-1, (BufferOverflow)null, (l)null, 6, (Object)null);
        this.k = new LinkedHashMap<LoadType, g0>();
        final p l = new p();
        l.c(LoadType.REFRESH, androidx.paging.l.b.b);
        final r a2 = r.a;
        this.l = l;
    }
    
    public PageFetcherSnapshotState(final x x, final i i) {
        this(x);
    }
    
    public static final int a(final PageFetcherSnapshotState pageFetcherSnapshotState) {
        return pageFetcherSnapshotState.h;
    }
    
    public static final d b(final PageFetcherSnapshotState pageFetcherSnapshotState) {
        return pageFetcherSnapshotState.j;
    }
    
    public static final int c(final PageFetcherSnapshotState pageFetcherSnapshotState) {
        return pageFetcherSnapshotState.g;
    }
    
    public static final d d(final PageFetcherSnapshotState pageFetcherSnapshotState) {
        return pageFetcherSnapshotState.i;
    }
    
    public final c<Integer> e() {
        return (c<Integer>)kotlinx.coroutines.flow.e.A(kotlinx.coroutines.flow.e.k((q)this.j), (sa.p)new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this, (kotlin.coroutines.c)null));
    }
    
    public final c<Integer> f() {
        return (c<Integer>)kotlinx.coroutines.flow.e.A(kotlinx.coroutines.flow.e.k((q)this.i), (sa.p)new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this, (kotlin.coroutines.c)null));
    }
    
    public final z<Key, Value> g(final g0.a a) {
        final List n0 = o.N0((Iterable)this.c);
        Integer value;
        if (a == null) {
            value = null;
        }
        else {
            int o = this.o();
            final int n2 = -this.l();
            final int l = kotlin.collections.o.l((List)this.m());
            final int i = this.l();
            final int g = a.g();
            int n3 = o;
            if (n2 < g) {
                int n4 = n2;
                while (true) {
                    final int n5 = n4 + 1;
                    int n6;
                    if (n4 > l - i) {
                        n6 = this.a.a;
                    }
                    else {
                        n6 = this.m().get(n4 + this.l()).a().size();
                    }
                    o += n6;
                    if (n5 >= g) {
                        break;
                    }
                    n4 = n5;
                }
                n3 = o;
            }
            int n7 = n3 + a.f();
            if (a.g() < n2) {
                n7 -= this.a.a;
            }
            value = n7;
        }
        return new z<Key, Value>(n0, value, this.a, this.o());
    }
    
    public final void h(final u.a<Value> a) {
        kotlin.jvm.internal.o.g((Object)a, "event");
        final int d = a.d();
        final int size = this.c.size();
        final int n = 0;
        if (d <= size) {
            this.k.remove(a.a());
            this.l.c(a.a(), androidx.paging.l.c.b.b());
            final int n2 = PageFetcherSnapshotState.b.a[a.a().ordinal()];
            if (n2 != 2) {
                if (n2 != 3) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.o.n("cannot drop ", (Object)a.a()));
                }
                for (int d2 = a.d(), i = n; i < d2; ++i) {
                    this.b.remove(this.m().size() - 1);
                }
                this.s(a.e());
                final int h = this.h + 1;
                this.h = h;
                ((kotlinx.coroutines.channels.u)this.j).n((Object)h);
            }
            else {
                for (int d3 = a.d(), j = 0; j < d3; ++j) {
                    this.b.remove(0);
                }
                this.d -= a.d();
                this.t(a.e());
                final int g = this.g + 1;
                this.g = g;
                ((kotlinx.coroutines.channels.u)this.i).n((Object)g);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("invalid drop count. have ");
        sb.append(this.m().size());
        sb.append(" but wanted to drop ");
        sb.append(a.d());
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public final u.a<Value> i(final LoadType loadType, final g0 g0) {
        kotlin.jvm.internal.o.g((Object)loadType, "loadType");
        kotlin.jvm.internal.o.g((Object)g0, "hint");
        final int e = this.a.e;
        final u.a<Value> a = null;
        if (e == Integer.MAX_VALUE) {
            return null;
        }
        if (this.c.size() <= 2) {
            return null;
        }
        if (this.q() <= this.a.e) {
            return null;
        }
        final LoadType refresh = LoadType.REFRESH;
        final int n = 0;
        if (loadType != refresh) {
            int n2;
            int n3;
            int n4;
            for (n2 = 0, n3 = 0; n2 < this.c.size() && this.q() - n3 > this.a.e; n3 += n4, ++n2) {
                final int[] a2 = PageFetcherSnapshotState.b.a;
                if (a2[loadType.ordinal()] == 2) {
                    n4 = this.c.get(n2).a().size();
                }
                else {
                    final List<PagingSource.b.c<Key, Value>> c = this.c;
                    n4 = ((PagingSource.b.c)c.get(o.l((List)c) - n2)).a().size();
                }
                int n5;
                if (a2[loadType.ordinal()] == 2) {
                    n5 = g0.d();
                }
                else {
                    n5 = g0.c();
                }
                if (n5 - n3 - n4 < this.a.b) {
                    break;
                }
            }
            u<T> u;
            if (n2 == 0) {
                u = (u<T>)a;
            }
            else {
                final int[] a3 = PageFetcherSnapshotState.b.a;
                int n6;
                if (a3[loadType.ordinal()] == 2) {
                    n6 = -this.d;
                }
                else {
                    n6 = o.l((List)this.c) - this.d - (n2 - 1);
                }
                int n7;
                if (a3[loadType.ordinal()] == 2) {
                    n7 = n2 - 1 - this.d;
                }
                else {
                    n7 = o.l((List)this.c) - this.d;
                }
                int n8;
                if (!this.a.c) {
                    n8 = n;
                }
                else {
                    int n9;
                    if (loadType == LoadType.PREPEND) {
                        n9 = this.o();
                    }
                    else {
                        n9 = this.n();
                    }
                    n8 = n9 + n3;
                }
                u = new u.a(loadType, n6, n7, n8);
            }
            return (u.a<Value>)u;
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.o.n("Drop LoadType must be PREPEND or APPEND, but got ", (Object)loadType).toString());
    }
    
    public final int j(final LoadType loadType) {
        kotlin.jvm.internal.o.g((Object)loadType, "loadType");
        final int n = PageFetcherSnapshotState.b.a[loadType.ordinal()];
        if (n != 1) {
            int n2;
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                n2 = this.h;
            }
            else {
                n2 = this.g;
            }
            return n2;
        }
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }
    
    public final Map<LoadType, g0> k() {
        return this.k;
    }
    
    public final int l() {
        return this.d;
    }
    
    public final List<PagingSource.b.c<Key, Value>> m() {
        return this.c;
    }
    
    public final int n() {
        int f;
        if (this.a.c) {
            f = this.f;
        }
        else {
            f = 0;
        }
        return f;
    }
    
    public final int o() {
        int e;
        if (this.a.c) {
            e = this.e;
        }
        else {
            e = 0;
        }
        return e;
    }
    
    public final p p() {
        return this.l;
    }
    
    public final int q() {
        final Iterator<Object> iterator = this.c.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().a().size();
        }
        return n;
    }
    
    public final boolean r(int n, final LoadType loadType, final PagingSource.b.c<Key, Value> c) {
        kotlin.jvm.internal.o.g((Object)loadType, "loadType");
        kotlin.jvm.internal.o.g((Object)c, "page");
        final int n2 = PageFetcherSnapshotState.b.a[loadType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    if (!(this.c.isEmpty() ^ true)) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    }
                    if (n != this.h) {
                        return false;
                    }
                    this.b.add(c);
                    if (c.b() == Integer.MIN_VALUE) {
                        n = ya.f.c(this.n() - c.a().size(), 0);
                    }
                    else {
                        n = c.b();
                    }
                    this.s(n);
                    this.k.remove(LoadType.APPEND);
                }
            }
            else {
                if (!(this.c.isEmpty() ^ true)) {
                    throw new IllegalStateException("should've received an init before prepend".toString());
                }
                if (n != this.g) {
                    return false;
                }
                this.b.add(0, c);
                ++this.d;
                if (c.c() == Integer.MIN_VALUE) {
                    n = ya.f.c(this.o() - c.a().size(), 0);
                }
                else {
                    n = c.c();
                }
                this.t(n);
                this.k.remove(LoadType.PREPEND);
            }
        }
        else {
            if (!this.c.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls".toString());
            }
            if (n == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (n == 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
            this.b.add(c);
            this.d = 0;
            this.s(c.b());
            this.t(c.c());
        }
        return true;
    }
    
    public final void s(final int n) {
        int f = n;
        if (n == Integer.MIN_VALUE) {
            f = 0;
        }
        this.f = f;
    }
    
    public final void t(final int n) {
        int e = n;
        if (n == Integer.MIN_VALUE) {
            e = 0;
        }
        this.e = e;
    }
    
    public final u<Value> u(final PagingSource.b.c<Key, Value> c, final LoadType loadType) {
        kotlin.jvm.internal.o.g((Object)c, "<this>");
        kotlin.jvm.internal.o.g((Object)loadType, "loadType");
        final int[] a = PageFetcherSnapshotState.b.a;
        final int n = a[loadType.ordinal()];
        int n2 = 0;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                n2 = this.c.size() - this.d - 1;
            }
            else {
                n2 = 0 - this.d;
            }
        }
        final List e = o.e((Object)new e0(n2, c.a()));
        final int n3 = a[loadType.ordinal()];
        u.b<Object> b;
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                b = u.b.g.a((List<e0<Object>>)e, this.n(), this.l.d(), null);
            }
            else {
                b = u.b.g.b((List<e0<Object>>)e, this.o(), this.l.d(), null);
            }
        }
        else {
            b = u.b.g.c((List<e0<Object>>)e, this.o(), this.n(), this.l.d(), null);
        }
        return (u<Value>)b;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012" }, d2 = { "Landroidx/paging/PageFetcherSnapshotState$a;", "", "Key", "Value", "Landroidx/paging/x;", "a", "Landroidx/paging/x;", "config", "Lkotlinx/coroutines/sync/c;", "b", "Lkotlinx/coroutines/sync/c;", "lock", "Landroidx/paging/PageFetcherSnapshotState;", "c", "Landroidx/paging/PageFetcherSnapshotState;", "state", "<init>", "(Landroidx/paging/x;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a<Key, Value>
    {
        private final x a;
        private final kotlinx.coroutines.sync.c b;
        private final PageFetcherSnapshotState<Key, Value> c;
        
        public a(final x a) {
            kotlin.jvm.internal.o.g((Object)a, "config");
            this.a = a;
            this.b = kotlinx.coroutines.sync.d.b(false, 1, (Object)null);
            this.c = new PageFetcherSnapshotState<Key, Value>(a, null);
        }
        
        public static final kotlinx.coroutines.sync.c a(final a a) {
            return a.b;
        }
        
        public static final PageFetcherSnapshotState b(final a a) {
            return a.c;
        }
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class b
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.REFRESH.ordinal()] = 1;
            a2[LoadType.PREPEND.ordinal()] = 2;
            a2[LoadType.APPEND.ordinal()] = 3;
            a = a2;
        }
    }
}
