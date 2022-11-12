// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.text.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000b\u0010B)\b\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019" }, d2 = { "Landroidx/paging/g0;", "", "other", "", "equals", "Landroidx/paging/LoadType;", "loadType", "", "e", "(Landroidx/paging/LoadType;)I", "hashCode", "a", "I", "d", "()I", "presentedItemsBefore", "b", "c", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "<init>", "(IIII)V", "Landroidx/paging/g0$b;", "Landroidx/paging/g0$a;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class g0
{
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    
    private g0(final int a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public g0(final int n, final int n2, final int n3, final int n4, final i i) {
        this(n, n2, n3, n4);
    }
    
    public final int a() {
        return this.c;
    }
    
    public final int b() {
        return this.d;
    }
    
    public final int c() {
        return this.b;
    }
    
    public final int d() {
        return this.a;
    }
    
    public final int e(final LoadType loadType) {
        o.g((Object)loadType, "loadType");
        final int n = g0.c.a[loadType.ordinal()];
        if (n != 1) {
            int n2;
            if (n != 2) {
                if (n != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                n2 = this.b;
            }
            else {
                n2 = this.a;
            }
            return n2;
        }
        throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof g0)) {
            return false;
        }
        final int a = this.a;
        final g0 g0 = (g0)o;
        if (a != g0.a || this.b != g0.b || this.c != g0.c || this.d != g0.d) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(this.a) + Integer.hashCode(this.b) + Integer.hashCode(this.c) + Integer.hashCode(this.d);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0017" }, d2 = { "Landroidx/paging/g0$a;", "Landroidx/paging/g0;", "", "other", "", "equals", "", "hashCode", "", "toString", "e", "I", "g", "()I", "pageOffset", "f", "indexInPage", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "<init>", "(IIIIII)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a extends g0
    {
        private final int e;
        private final int f;
        
        public a(final int e, final int f, final int n, final int n2, final int n3, final int n4) {
            super(n, n2, n3, n4, null);
            this.e = e;
            this.f = f;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            final int e = this.e;
            final a a = (a)o;
            if (e != a.e || this.f != a.f || this.d() != a.d() || this.c() != a.c() || this.a() != a.a() || this.b() != a.b()) {
                b = false;
            }
            return b;
        }
        
        public final int f() {
            return this.f;
        }
        
        public final int g() {
            return this.e;
        }
        
        @Override
        public int hashCode() {
            return super.hashCode() + Integer.hashCode(this.e) + Integer.hashCode(this.f);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewportHint.Access(\n            |    pageOffset=");
            sb.append(this.e);
            sb.append(",\n            |    indexInPage=");
            sb.append(this.f);
            sb.append(",\n            |    presentedItemsBefore=");
            sb.append(this.d());
            sb.append(",\n            |    presentedItemsAfter=");
            sb.append(this.c());
            sb.append(",\n            |    originalPageOffsetFirst=");
            sb.append(this.a());
            sb.append(",\n            |    originalPageOffsetLast=");
            sb.append(this.b());
            sb.append(",\n            |)");
            return l.i(sb.toString(), (String)null, 1, (Object)null);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b" }, d2 = { "Landroidx/paging/g0$b;", "Landroidx/paging/g0;", "", "toString", "", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "<init>", "(IIII)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class b extends g0
    {
        public b(final int n, final int n2, final int n3, final int n4) {
            super(n, n2, n3, n4, null);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewportHint.Initial(\n            |    presentedItemsBefore=");
            sb.append(this.d());
            sb.append(",\n            |    presentedItemsAfter=");
            sb.append(this.c());
            sb.append(",\n            |    originalPageOffsetFirst=");
            sb.append(this.a());
            sb.append(",\n            |    originalPageOffsetLast=");
            sb.append(this.b());
            sb.append(",\n            |)");
            return l.i(sb.toString(), (String)null, 1, (Object)null);
        }
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
