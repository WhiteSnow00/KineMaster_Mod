// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ya.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import androidx.recyclerview.widget.p;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ8\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u000e" }, d2 = { "Landroidx/paging/t;", "", "T", "Landroidx/paging/r;", "oldList", "newList", "Landroidx/recyclerview/widget/p;", "callback", "Landroidx/paging/q;", "diffResult", "Lka/r;", "a", "<init>", "()V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public final class t
{
    public static final t a;
    
    static {
        a = new t();
    }
    
    private t() {
    }
    
    public final <T> void a(final r<T> r, final r<T> r2, final p p4, final q q) {
        o.g((Object)r, "oldList");
        o.g((Object)r2, "newList");
        o.g((Object)p4, "callback");
        o.g((Object)q, "diffResult");
        final a a = new a((r<T>)r, (r<T>)r2, p4);
        q.a().c(a);
        a.k();
    }
    
    @Metadata(bv = {}, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000fB+\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\u0003J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\"\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001d¨\u0006&" }, d2 = { "Landroidx/paging/t$a;", "T", "Landroidx/recyclerview/widget/p;", "Lka/r;", "l", "j", "", "position", "count", "", "g", "f", "i", "h", "k", "a", "b", "fromPosition", "toPosition", "d", "", "payload", "c", "Landroidx/paging/r;", "Landroidx/paging/r;", "oldList", "newList", "Landroidx/recyclerview/widget/p;", "callback", "I", "placeholdersBefore", "e", "placeholdersAfter", "storageCount", "placeholdersBeforeState", "placeholdersAfterState", "<init>", "(Landroidx/paging/r;Landroidx/paging/r;Landroidx/recyclerview/widget/p;)V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
    private static final class a<T> implements p
    {
        public static final t.a.a i;
        private final r<T> a;
        private final r<T> b;
        private final p c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        
        static {
            i = new t.a.a(null);
        }
        
        public a(final r<T> a, final r<T> b, final p c) {
            o.g((Object)a, "oldList");
            o.g((Object)b, "newList");
            o.g((Object)c, "callback");
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = a.c();
            this.e = a.d();
            this.f = a.b();
            this.g = 1;
            this.h = 1;
        }
        
        public static final int e(final t.a a) {
            return a.d;
        }
        
        private final boolean f(final int n, int n2) {
            if (n < this.f) {
                return false;
            }
            if (this.h == 2) {
                return false;
            }
            final int min = Math.min(n2, this.e);
            if (min > 0) {
                this.h = 3;
                this.c.c(e(this) + n, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.e -= min;
            }
            n2 -= min;
            if (n2 > 0) {
                this.c.a(n + min + e(this), n2);
            }
            return true;
        }
        
        private final boolean g(int min, final int n) {
            if (min > 0) {
                return false;
            }
            if (this.g == 2) {
                return false;
            }
            min = Math.min(n, this.d);
            if (min > 0) {
                this.g = 3;
                this.c.c(0 - min + e(this), min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.d -= min;
            }
            min = n - min;
            if (min > 0) {
                this.c.a(e(this) + 0, min);
            }
            return true;
        }
        
        private final boolean h(final int n, int n2) {
            if (n + n2 < this.f) {
                return false;
            }
            if (this.h == 3) {
                return false;
            }
            final int c = ya.f.c(Math.min(this.b.d() - this.e, n2), 0);
            n2 -= c;
            if (c > 0) {
                this.h = 2;
                this.c.c(e(this) + n, c, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.e += c;
            }
            if (n2 > 0) {
                this.c.b(n + c + e(this), n2);
            }
            return true;
        }
        
        private final boolean i(int c, int n) {
            if (c > 0) {
                return false;
            }
            if (this.g == 3) {
                return false;
            }
            c = ya.f.c(Math.min(this.b.c() - this.d, n), 0);
            n -= c;
            if (n > 0) {
                this.c.b(e(this) + 0, n);
            }
            if (c > 0) {
                this.g = 2;
                this.c.c(e(this) + 0, c, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.d += c;
            }
            return true;
        }
        
        private final void j() {
            final int min = Math.min(this.a.c(), this.d);
            final int n = this.b.c() - this.d;
            if (n > 0) {
                if (min > 0) {
                    this.c.c(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.c.a(0, n);
            }
            else if (n < 0) {
                this.c.b(0, -n);
                final int n2 = min + n;
                if (n2 > 0) {
                    this.c.c(0, n2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.d = this.b.c();
        }
        
        private final void l() {
            final int min = Math.min(this.a.d(), this.e);
            final int d = this.b.d();
            final int e = this.e;
            final int n = d - e;
            final int n2 = this.d + this.f + e;
            final int n3 = n2 - min;
            final boolean b = n3 != this.a.a() - min;
            int n4;
            if (n > 0) {
                this.c.a(n2, n);
                n4 = min;
            }
            else {
                n4 = min;
                if (n < 0) {
                    this.c.b(n2 + n, -n);
                    n4 = min + n;
                }
            }
            if (n4 > 0 && b) {
                this.c.c(n3, n4, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.e = this.b.d();
        }
        
        @Override
        public void a(final int n, final int n2) {
            if (!this.f(n, n2)) {
                if (!this.g(n, n2)) {
                    this.c.a(n + e(this), n2);
                }
            }
            this.f += n2;
        }
        
        @Override
        public void b(final int n, final int n2) {
            if (!this.h(n, n2)) {
                if (!this.i(n, n2)) {
                    this.c.b(n + e(this), n2);
                }
            }
            this.f -= n2;
        }
        
        @Override
        public void c(final int n, final int n2, final Object o) {
            this.c.c(n + e(this), n2, o);
        }
        
        @Override
        public void d(final int n, final int n2) {
            this.c.d(n + e(this), n2 + e(this));
        }
        
        public final void k() {
            this.j();
            this.l();
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t" }, d2 = { "Landroidx/paging/t$a$a;", "", "", "UNUSED", "I", "USED_FOR_ADDITION", "USED_FOR_REMOVAL", "<init>", "()V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
        }
    }
}
