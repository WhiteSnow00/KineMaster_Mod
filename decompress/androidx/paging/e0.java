// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.Arrays;
import java.util.Objects;
import ya.e;
import java.util.Collection;
import kotlin.collections.o;
import kotlin.jvm.internal.i;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\b\u0080\b\u0018\u0000 \n*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0012B5\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017¢\u0006\u0004\b\"\u0010#B\u001f\b\u0016\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\"\u0010%J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010 \u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001c\u0010\u001a¨\u0006&" }, d2 = { "Landroidx/paging/e0;", "", "T", "", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Landroidx/paging/g0$a;", "e", "other", "", "equals", "hashCode", "", "toString", "", "a", "[I", "d", "()[I", "originalPageOffsets", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "data", "c", "I", "getHintOriginalPageOffset", "()I", "hintOriginalPageOffset", "hintOriginalIndices", "<init>", "([ILjava/util/List;ILjava/util/List;)V", "originalPageOffset", "(ILjava/util/List;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class e0<T>
{
    public static final a e;
    private static final e0<Object> f;
    private final int[] a;
    private final List<T> b;
    private final int c;
    private final List<Integer> d;
    
    static {
        e = new a(null);
        f = new e0<Object>(0, o.j());
    }
    
    public e0(final int n, final List<? extends T> list) {
        kotlin.jvm.internal.o.g((Object)list, "data");
        this(new int[] { n }, list, n, null);
    }
    
    public e0(final int[] a, final List<? extends T> b, int length, final List<Integer> d) {
        kotlin.jvm.internal.o.g((Object)a, "originalPageOffsets");
        kotlin.jvm.internal.o.g((Object)b, "data");
        this.a = a;
        this.b = (List<T>)b;
        this.c = length;
        this.d = d;
        length = a.length;
        final int n = 0;
        if (length == 0) {
            length = 1;
        }
        else {
            length = 0;
        }
        if ((length ^ 0x1) == 0x0) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
        }
        Label_0086: {
            if (d != null) {
                length = n;
                if (d.size() != b.size()) {
                    break Label_0086;
                }
            }
            length = 1;
        }
        if (length != 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("If originalIndices (size = ");
        final List<Integer> c = this.c();
        kotlin.jvm.internal.o.d((Object)c);
        sb.append(c.size());
        sb.append(") is provided, it must be same length as data (size = ");
        sb.append(this.b().size());
        sb.append(')');
        throw new IllegalArgumentException(sb.toString().toString());
    }
    
    public static final e0 a() {
        return e0.f;
    }
    
    public final List<T> b() {
        return this.b;
    }
    
    public final List<Integer> c() {
        return this.d;
    }
    
    public final int[] d() {
        return this.a;
    }
    
    public final g0.a e(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int c = this.c;
        final List<Integer> d = this.d;
        boolean b = true;
        Label_0051: {
            if (d != null) {
                final e k = o.k((Collection)d);
                if (k != null) {
                    if (k.o(n)) {
                        break Label_0051;
                    }
                }
            }
            b = false;
        }
        int intValue = n;
        if (b) {
            intValue = this.d.get(n).intValue();
        }
        return new g0.a(c, intValue, n2, n3, n4, n5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        Object class1;
        if (o == null) {
            class1 = null;
        }
        else {
            class1 = o.getClass();
        }
        if (!kotlin.jvm.internal.o.b((Object)e0.class, class1)) {
            return false;
        }
        Objects.requireNonNull(o, "null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
        final e0 e0 = (e0)o;
        return Arrays.equals(this.a, e0.a) && kotlin.jvm.internal.o.b((Object)this.b, (Object)e0.b) && this.c == e0.c && kotlin.jvm.internal.o.b((Object)this.d, (Object)e0.d);
    }
    
    @Override
    public int hashCode() {
        final int hashCode = Arrays.hashCode(this.a);
        final int hashCode2 = this.b.hashCode();
        final int c = this.c;
        final List<Integer> d = this.d;
        int hashCode3;
        if (d == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = d.hashCode();
        }
        return ((hashCode * 31 + hashCode2) * 31 + c) * 31 + hashCode3;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TransformablePage(originalPageOffsets=");
        sb.append(Arrays.toString(this.a));
        sb.append(", data=");
        sb.append(this.b);
        sb.append(", hintOriginalPageOffset=");
        sb.append(this.c);
        sb.append(", hintOriginalIndices=");
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Landroidx/paging/e0$a;", "", "Landroidx/paging/e0;", "EMPTY_INITIAL_PAGE", "Landroidx/paging/e0;", "a", "()Landroidx/paging/e0;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final e0<Object> a() {
            return e0.a();
        }
    }
}
