// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o;
import java.util.Iterator;
import kotlin.collections.c0;
import ya.f;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#" }, d2 = { "Landroidx/paging/g;", "", "T", "Landroidx/paging/u$a;", "event", "Lka/r;", "e", "Landroidx/paging/u$b;", "c", "Landroidx/paging/u$c;", "d", "Landroidx/paging/u;", "a", "", "b", "", "I", "placeholdersBefore", "placeholdersAfter", "Lkotlin/collections/g;", "Landroidx/paging/e0;", "Lkotlin/collections/g;", "pages", "Landroidx/paging/p;", "Landroidx/paging/p;", "sourceStates", "Landroidx/paging/n;", "Landroidx/paging/n;", "mediatorStates", "", "f", "Z", "receivedFirstEvent", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class g<T>
{
    private int a;
    private int b;
    private final kotlin.collections.g<e0<T>> c;
    private final p d;
    private n e;
    private boolean f;
    
    public g() {
        this.c = (kotlin.collections.g<e0<T>>)new kotlin.collections.g();
        this.d = new p();
    }
    
    private final void c(final u.b<T> b) {
        this.d.b(b.i());
        this.e = b.e();
        final int n = g.a.a[b.d().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    this.c.clear();
                    this.b = b.g();
                    this.a = b.h();
                    this.c.addAll((Collection)b.f());
                }
            }
            else {
                this.b = b.g();
                this.c.addAll((Collection)b.f());
            }
        }
        else {
            this.a = b.h();
            final Iterator<Object> iterator = ((Iterable<Object>)ya.f.k(b.f().size() - 1, 0)).iterator();
            while (iterator.hasNext()) {
                this.c.addFirst(b.f().get(((c0)iterator).b()));
            }
        }
    }
    
    private final void d(final u.c<T> c) {
        this.d.b(c.b());
        this.e = c.a();
    }
    
    private final void e(final u.a<T> a) {
        this.d.c(a.a(), l.c.b.b());
        final int n = g.a.a[a.a().ordinal()];
        int i = 0;
        final int n2 = 0;
        if (n != 1) {
            if (n != 2) {
                throw new IllegalArgumentException("Page drop type must be prepend or append");
            }
            this.b = a.e();
            for (int d = a.d(), j = n2; j < d; ++j) {
                this.c.removeLast();
            }
        }
        else {
            this.a = a.e();
            while (i < a.d()) {
                this.c.removeFirst();
                ++i;
            }
        }
    }
    
    public final void a(final u<T> u) {
        o.g((Object)u, "event");
        this.f = true;
        if (u instanceof u.b) {
            this.c((u.b)u);
        }
        else if (u instanceof u.a) {
            this.e((u.a)u);
        }
        else if (u instanceof u.c) {
            this.d((u.c)u);
        }
    }
    
    public final List<u<T>> b() {
        if (!this.f) {
            return kotlin.collections.o.j();
        }
        final ArrayList list = new ArrayList();
        final n d = this.d.d();
        if (((Collection)this.c).isEmpty() ^ true) {
            list.add(u.b.g.c((List<e0<Object>>)kotlin.collections.o.N0((Iterable)this.c), this.a, this.b, d, this.e));
        }
        else {
            list.add(new u.c(d, this.e));
        }
        return list;
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class a
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.PREPEND.ordinal()] = 1;
            a2[LoadType.APPEND.ordinal()] = 2;
            a2[LoadType.REFRESH.ordinal()] = 3;
            a = a2;
        }
    }
}
