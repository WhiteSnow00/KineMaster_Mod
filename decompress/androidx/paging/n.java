// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \b2\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001e" }, d2 = { "Landroidx/paging/n;", "", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/l;", "newState", "h", "(Landroidx/paging/LoadType;Landroidx/paging/l;)Landroidx/paging/n;", "d", "(Landroidx/paging/LoadType;)Landroidx/paging/l;", "refresh", "prepend", "append", "b", "", "toString", "", "hashCode", "other", "", "equals", "a", "Landroidx/paging/l;", "g", "()Landroidx/paging/l;", "f", "c", "e", "<init>", "(Landroidx/paging/l;Landroidx/paging/l;Landroidx/paging/l;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class n
{
    public static final a d;
    private static final n e;
    private final l a;
    private final l b;
    private final l c;
    
    static {
        d = new a(null);
        final l.c.a b = l.c.b;
        e = new n(b.b(), b.b(), b.b());
    }
    
    public n(final l a, final l b, final l c) {
        o.g((Object)a, "refresh");
        o.g((Object)b, "prepend");
        o.g((Object)c, "append");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static final n a() {
        return n.e;
    }
    
    public static n c(final n n, l a, l b, l c, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            a = n.a;
        }
        if ((n2 & 0x2) != 0x0) {
            b = n.b;
        }
        if ((n2 & 0x4) != 0x0) {
            c = n.c;
        }
        return n.b(a, b, c);
    }
    
    public final n b(final l l, final l i, final l j) {
        o.g((Object)l, "refresh");
        o.g((Object)i, "prepend");
        o.g((Object)j, "append");
        return new n(l, i, j);
    }
    
    public final l d(final LoadType loadType) {
        o.g((Object)loadType, "loadType");
        final int n = androidx.paging.n.b.a[loadType.ordinal()];
        l l;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                l = this.a;
            }
            else {
                l = this.b;
            }
        }
        else {
            l = this.c;
        }
        return l;
    }
    
    public final l e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof n)) {
            return false;
        }
        final n n = (n)o;
        return o.b((Object)this.a, (Object)n.a) && o.b((Object)this.b, (Object)n.b) && o.b((Object)this.c, (Object)n.c);
    }
    
    public final l f() {
        return this.b;
    }
    
    public final l g() {
        return this.a;
    }
    
    public final n h(final LoadType loadType, final l l) {
        o.g((Object)loadType, "loadType");
        o.g((Object)l, "newState");
        final int n = androidx.paging.n.b.a[loadType.ordinal()];
        n n2;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                n2 = c(this, l, null, null, 6, null);
            }
            else {
                n2 = c(this, null, l, null, 5, null);
            }
        }
        else {
            n2 = c(this, null, null, l, 3, null);
        }
        return n2;
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LoadStates(refresh=");
        sb.append(this.a);
        sb.append(", prepend=");
        sb.append(this.b);
        sb.append(", append=");
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Landroidx/paging/n$a;", "", "Landroidx/paging/n;", "IDLE", "Landroidx/paging/n;", "a", "()Landroidx/paging/n;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final n a() {
            return n.a();
        }
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class b
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.APPEND.ordinal()] = 1;
            a2[LoadType.PREPEND.ordinal()] = 2;
            a2[LoadType.REFRESH.ordinal()] = 3;
            a = a2;
        }
    }
}
