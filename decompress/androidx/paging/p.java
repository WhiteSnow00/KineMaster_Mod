// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001c" }, d2 = { "Landroidx/paging/p;", "", "Landroidx/paging/n;", "d", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/l;", "a", "type", "state", "Lka/r;", "c", "states", "b", "Landroidx/paging/l;", "getRefresh", "()Landroidx/paging/l;", "setRefresh", "(Landroidx/paging/l;)V", "refresh", "getPrepend", "setPrepend", "prepend", "getAppend", "setAppend", "append", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class p
{
    private l a;
    private l b;
    private l c;
    
    public p() {
        final l.c.a b = l.c.b;
        this.a = b.b();
        this.b = b.b();
        this.c = b.b();
    }
    
    public final l a(final LoadType loadType) {
        o.g((Object)loadType, "loadType");
        final int n = p.a.a[loadType.ordinal()];
        l l;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                l = this.b;
            }
            else {
                l = this.c;
            }
        }
        else {
            l = this.a;
        }
        return l;
    }
    
    public final void b(final n n) {
        o.g((Object)n, "states");
        this.a = n.g();
        this.c = n.e();
        this.b = n.f();
    }
    
    public final void c(final LoadType loadType, final l a) {
        o.g((Object)loadType, "type");
        o.g((Object)a, "state");
        final int n = p.a.a[loadType.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.b = a;
            }
            else {
                this.c = a;
            }
        }
        else {
            this.a = a;
        }
    }
    
    public final n d() {
        return new n(this.a, this.b, this.c);
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class a
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.REFRESH.ordinal()] = 1;
            a2[LoadType.APPEND.ordinal()] = 2;
            a2[LoadType.PREPEND.ordinal()] = 3;
            a = a2;
        }
    }
}
