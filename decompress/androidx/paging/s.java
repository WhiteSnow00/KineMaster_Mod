// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ya.b;
import androidx.recyclerview.widget.p;
import java.util.Iterator;
import ya.e;
import kotlin.collections.c0;
import java.util.Collection;
import ya.f;
import kotlin.jvm.internal.o;
import androidx.recyclerview.widget.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a:\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a,\u0010\u000f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0000¨\u0006\u0010" }, d2 = { "", "T", "Landroidx/paging/r;", "newList", "Landroidx/recyclerview/widget/i$f;", "diffCallback", "Landroidx/paging/q;", "a", "Landroidx/recyclerview/widget/p;", "callback", "diffResult", "Lka/r;", "b", "", "oldPosition", "c", "paging-runtime_release" }, k = 2, mv = { 1, 5, 1 })
public final class s
{
    public static final <T> q a(final r<T> r, final r<T> r2, final i.f<T> f) {
        o.g((Object)r, "<this>");
        o.g((Object)r2, "newList");
        o.g((Object)f, "diffCallback");
        final i.b b = new i.b(r, r2, f, r.b(), r2.b()) {
            final r<T> a;
            final r<T> b;
            final f<T> c;
            final int d;
            final int e;
            
            @Override
            public boolean a(final int n, final int n2) {
                final T e = this.a.e(n);
                final T e2 = this.b.e(n2);
                return e == e2 || this.c.areContentsTheSame(e, e2);
            }
            
            @Override
            public boolean b(final int n, final int n2) {
                final T e = this.a.e(n);
                final T e2 = this.b.e(n2);
                return e == e2 || this.c.areItemsTheSame(e, e2);
            }
            
            @Override
            public Object c(final int n, final int n2) {
                final T e = this.a.e(n);
                final T e2 = this.b.e(n2);
                Object o;
                if (e == e2) {
                    o = Boolean.TRUE;
                }
                else {
                    o = this.c.getChangePayload(e, e2);
                }
                return o;
            }
            
            @Override
            public int d() {
                return this.e;
            }
            
            @Override
            public int e() {
                return this.d;
            }
        };
        boolean b2 = true;
        final i.e c = i.c((i.b)b, true);
        o.f((Object)c, "NullPaddedList<T>.comput\u2026    },\n        true\n    )");
        final e m = f.m(0, r.b());
        if (!(m instanceof Collection) || !((Collection)m).isEmpty()) {
            final Iterator iterator = ((Iterable)m).iterator();
            while (iterator.hasNext()) {
                if (c.b(((c0)iterator).b()) != -1) {
                    return new q(c, b2);
                }
            }
        }
        b2 = false;
        return new q(c, b2);
    }
    
    public static final <T> void b(final r<T> r, final p p4, final r<T> r2, final q q) {
        o.g((Object)r, "<this>");
        o.g((Object)p4, "callback");
        o.g((Object)r2, "newList");
        o.g((Object)q, "diffResult");
        if (q.b()) {
            t.a.a(r, r2, p4, q);
        }
        else {
            androidx.paging.f.a.b(p4, r, r2);
        }
    }
    
    public static final int c(final r<?> r, final q q, final r<?> r2, final int n) {
        o.g((Object)r, "<this>");
        o.g((Object)q, "diffResult");
        o.g((Object)r2, "newList");
        if (!q.b()) {
            return f.i(n, (b)f.m(0, r2.a()));
        }
        final int n2 = n - r.c();
        final int b = r.b();
        if (n2 >= 0 && n2 < b) {
            int n3 = 0;
            while (true) {
                final int n4 = n3 + 1;
                final int n5 = n3 / 2;
                int n6;
                if (n3 % 2 == 1) {
                    n6 = -1;
                }
                else {
                    n6 = 1;
                }
                final int n7 = n5 * n6 + n2;
                if (n7 >= 0) {
                    if (n7 < r.b()) {
                        final int b2 = q.a().b(n7);
                        if (b2 != -1) {
                            return b2 + r2.c();
                        }
                    }
                }
                if (n4 > 29) {
                    break;
                }
                n3 = n4;
            }
        }
        return f.i(n, (b)f.m(0, r2.a()));
    }
}
