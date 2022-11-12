// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.ArrayList;
import kotlin.collections.h;
import java.util.Iterator;
import ya.e;
import java.util.Collection;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0015\b\u0000\u0018\u0000 \u001d*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002&*B\u0015\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b8\u00109J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u001c\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020!J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0004R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R$\u0010/\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b.\u0010,R$\u00101\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b0\u0010,R\u0014\u00103\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010,R\u0014\u00105\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010,R\u0014\u00106\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010,¨\u0006:" }, d2 = { "Landroidx/paging/w;", "", "T", "Landroidx/paging/r;", "", "index", "Lka/r;", "h", "", "Landroidx/paging/e0;", "k", "Landroidx/paging/u$b;", "insert", "Landroidx/paging/w$b;", "callback", "p", "Lya/e;", "pageOffsetsToDrop", "j", "Landroidx/paging/u$a;", "drop", "i", "", "toString", "l", "(I)Ljava/lang/Object;", "Landroidx/paging/k;", "r", "localIndex", "e", "Landroidx/paging/u;", "pageEvent", "q", "Landroidx/paging/g0$b;", "o", "Landroidx/paging/g0$a;", "g", "", "a", "Ljava/util/List;", "pages", "<set-?>", "b", "I", "()I", "storageCount", "c", "placeholdersBefore", "d", "placeholdersAfter", "m", "originalPageOffsetFirst", "n", "originalPageOffsetLast", "size", "insertEvent", "<init>", "(Landroidx/paging/u$b;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class w<T> implements r<T>
{
    public static final a e;
    private static final w<Object> f;
    private final List<e0<T>> a;
    private int b;
    private int c;
    private int d;
    
    static {
        e = new a(null);
        f = new w<Object>(u.b.g.e());
    }
    
    public w(final u.b<T> b) {
        o.g((Object)b, "insertEvent");
        this.a = kotlin.collections.o.P0((Collection)b.f());
        this.b = this.k((List<e0<T>>)b.f());
        this.c = b.h();
        this.d = b.g();
    }
    
    public static final w f() {
        return w.f;
    }
    
    private final void h(final int n) {
        if (n >= 0 && n < this.a()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Index: ");
        sb.append(n);
        sb.append(", Size: ");
        sb.append(this.a());
        throw new IndexOutOfBoundsException(sb.toString());
    }
    
    private final void i(final u.a<T> a, final b b) {
        final int a2 = this.a();
        final LoadType a3 = a.a();
        final LoadType prepend = LoadType.PREPEND;
        if (a3 == prepend) {
            final int c = this.c();
            this.b = this.b() - this.j(new e(a.c(), a.b()));
            this.c = a.e();
            final int n = this.a() - a2;
            if (n > 0) {
                b.a(0, n);
            }
            else if (n < 0) {
                b.b(0, -n);
            }
            final int max = Math.max(0, c + n);
            final int n2 = a.e() - max;
            if (n2 > 0) {
                b.c(max, n2);
            }
            b.d(prepend, false, l.c.b.b());
        }
        else {
            final int d = this.d();
            this.b = this.b() - this.j(new e(a.c(), a.b()));
            this.d = a.e();
            final int n3 = this.a() - a2;
            if (n3 > 0) {
                b.a(a2, n3);
            }
            else if (n3 < 0) {
                b.b(a2 + n3, -n3);
            }
            int min;
            if (n3 < 0) {
                min = Math.min(d, -n3);
            }
            else {
                min = 0;
            }
            final int n4 = a.e() - (d - min);
            if (n4 > 0) {
                b.c(this.a() - a.e(), n4);
            }
            b.d(LoadType.APPEND, false, l.c.b.b());
        }
    }
    
    private final int j(final e e) {
        final Iterator<e0<T>> iterator = this.a.iterator();
        int n = 0;
    Label_0013:
        while (iterator.hasNext()) {
            final e0 e2 = iterator.next();
            final int[] d = e2.d();
            final int length = d.length;
            int i = 0;
            while (true) {
                while (i < length) {
                    if (e.o(d[i])) {
                        final boolean b = true;
                        if (b) {
                            n += e2.b().size();
                            iterator.remove();
                            continue Label_0013;
                        }
                        continue Label_0013;
                    }
                    else {
                        ++i;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
        return n;
    }
    
    private final int k(final List<e0<T>> list) {
        final Iterator<Object> iterator = (Iterator<Object>)list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().b().size();
        }
        return n;
    }
    
    private final int m() {
        final Integer n = h.N(((e0)kotlin.collections.o.b0((List)this.a)).d());
        o.d((Object)n);
        return n;
    }
    
    private final int n() {
        final Integer m = h.M(((e0)kotlin.collections.o.n0((List)this.a)).d());
        o.d((Object)m);
        return m;
    }
    
    private final void p(final u.b<T> b, final b b2) {
        final int k = this.k((List<e0<T>>)b.f());
        final int a = this.a();
        final int n = w.c.a[b.d().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    final int min = Math.min(this.d(), k);
                    final int n2 = this.c() + this.b();
                    final int n3 = k - min;
                    final List<e0<T>> a2 = this.a;
                    a2.addAll(a2.size(), b.f());
                    this.b = this.b() + k;
                    this.d = b.g();
                    b2.c(n2, min);
                    b2.a(n2 + min, n3);
                    final int n4 = this.a() - a - n3;
                    if (n4 > 0) {
                        b2.a(this.a() - n4, n4);
                    }
                    else if (n4 < 0) {
                        b2.b(this.a(), -n4);
                    }
                }
            }
            else {
                final int min2 = Math.min(this.c(), k);
                final int c = this.c();
                final int n5 = k - min2;
                this.a.addAll(0, b.f());
                this.b = this.b() + k;
                this.c = b.h();
                b2.c(c - min2, min2);
                b2.a(0, n5);
                final int n6 = this.a() - a - n5;
                if (n6 > 0) {
                    b2.a(0, n6);
                }
                else if (n6 < 0) {
                    b2.b(0, -n6);
                }
            }
            b2.e(b.i(), b.e());
            return;
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public int a() {
        return this.c() + this.b() + this.d();
    }
    
    @Override
    public int b() {
        return this.b;
    }
    
    @Override
    public int c() {
        return this.c;
    }
    
    @Override
    public int d() {
        return this.d;
    }
    
    @Override
    public T e(int n) {
        int size;
        int i;
        for (size = this.a.size(), i = 0; i < size; ++i) {
            final int size2 = this.a.get(i).b().size();
            if (size2 > n) {
                break;
            }
            n -= size2;
        }
        return this.a.get(i).b().get(n);
    }
    
    public final g0.a g(final int n) {
        final int c = this.c();
        int n2;
        int n3;
        for (n2 = 0, n3 = n - c; n3 >= this.a.get(n2).b().size() && n2 < kotlin.collections.o.l((List)this.a); n3 -= this.a.get(n2).b().size(), ++n2) {}
        return this.a.get(n2).e(n3, n - this.c(), this.a() - n - this.d() - 1, this.m(), this.n());
    }
    
    public final T l(int n) {
        this.h(n);
        n -= this.c();
        if (n >= 0 && n < this.b()) {
            return this.e(n);
        }
        return null;
    }
    
    public final g0.b o() {
        final int n = this.b() / 2;
        return new g0.b(n, n, this.m(), this.n());
    }
    
    public final void q(final u<T> u, final b b) {
        o.g((Object)u, "pageEvent");
        o.g((Object)b, "callback");
        if (u instanceof u.b) {
            this.p((u.b)u, b);
        }
        else if (u instanceof u.a) {
            this.i((u.a)u, b);
        }
        else if (u instanceof u.c) {
            final u.c c = (u.c)u;
            b.e(c.b(), c.a());
        }
    }
    
    public final k<T> r() {
        final int c = this.c();
        final int d = this.d();
        final List<e0<T>> a = this.a;
        final ArrayList list = new ArrayList();
        final Iterator<Object> iterator = (Iterator<Object>)a.iterator();
        while (iterator.hasNext()) {
            kotlin.collections.o.z((Collection)list, (Iterable)iterator.next().b());
        }
        return new k<T>(c, d, list);
    }
    
    @Override
    public String toString() {
        final int b = this.b();
        final ArrayList list = new ArrayList<Object>(b);
        for (int i = 0; i < b; ++i) {
            list.add(this.e(i));
        }
        final String l0 = kotlin.collections.o.l0((Iterable)list, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (sa.l)null, 63, (Object)null);
        final StringBuilder sb = new StringBuilder();
        sb.append("[(");
        sb.append(this.c());
        sb.append(" placeholders), ");
        sb.append(l0);
        sb.append(", (");
        sb.append(this.d());
        sb.append(" placeholders)]");
        return sb.toString();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n" }, d2 = { "Landroidx/paging/w$a;", "", "T", "Landroidx/paging/w;", "a", "()Landroidx/paging/w;", "INITIAL", "Landroidx/paging/w;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final <T> w<T> a() {
            return (w<T>)w.f();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0014" }, d2 = { "Landroidx/paging/w$b;", "", "", "position", "count", "Lka/r;", "c", "a", "b", "Landroidx/paging/LoadType;", "loadType", "", "fromMediator", "Landroidx/paging/l;", "loadState", "d", "Landroidx/paging/n;", "source", "mediator", "e", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public interface b
    {
        void a(final int p0, final int p1);
        
        void b(final int p0, final int p1);
        
        void c(final int p0, final int p1);
        
        void d(final LoadType p0, final boolean p1, final l p2);
        
        void e(final n p0, final n p1);
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class c
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
