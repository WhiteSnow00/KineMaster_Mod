// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003BC\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0015" }, d2 = { "Landroidx/paging/x;", "", "", "a", "I", "pageSize", "b", "prefetchDistance", "", "c", "Z", "enablePlaceholders", "d", "initialLoadSize", "e", "maxSize", "f", "jumpThreshold", "<init>", "(IIZIII)V", "g", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class x
{
    public static final a g;
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    
    static {
        g = new a(null);
    }
    
    public x(int a, final int b, final boolean c, final int d, final int e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        if (!c && b == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        if (e != Integer.MAX_VALUE && e < b * 2 + a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=");
            sb.append(a);
            sb.append(", prefetchDist=");
            sb.append(b);
            sb.append(", maxSize=");
            sb.append(e);
            throw new IllegalArgumentException(sb.toString());
        }
        if (f != Integer.MIN_VALUE && f <= 0) {
            a = 0;
        }
        else {
            a = 1;
        }
        if (a != 0) {
            return;
        }
        throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
    }
    
    public x(final int n, int n2, boolean b, int n3, int n4, int n5, final int n6, final i i) {
        if ((n6 & 0x2) != 0x0) {
            n2 = n;
        }
        if ((n6 & 0x4) != 0x0) {
            b = true;
        }
        if ((n6 & 0x8) != 0x0) {
            n3 = n * 3;
        }
        if ((n6 & 0x10) != 0x0) {
            n4 = Integer.MAX_VALUE;
        }
        if ((n6 & 0x20) != 0x0) {
            n5 = Integer.MIN_VALUE;
        }
        this(n, n2, b, n3, n4, n5);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007¨\u0006\t" }, d2 = { "Landroidx/paging/x$a;", "", "", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "I", "MAX_SIZE_UNBOUNDED", "getMAX_SIZE_UNBOUNDED$annotations", "()V", "<init>", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
}
