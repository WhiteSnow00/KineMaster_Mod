// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B)\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u0019" }, d2 = { "Landroidx/paging/k;", "T", "Lkotlin/collections/b;", "", "index", "get", "(I)Ljava/lang/Object;", "b", "I", "getPlaceholdersBefore", "()I", "placeholdersBefore", "c", "getPlaceholdersAfter", "placeholdersAfter", "", "d", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "a", "size", "<init>", "(IILjava/util/List;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class k<T> extends b<T>
{
    private final int b;
    private final int c;
    private final List<T> d;
    
    public k(final int b, final int c, final List<? extends T> d) {
        o.g((Object)d, "items");
        this.b = b;
        this.c = c;
        this.d = (List<T>)d;
    }
    
    public int a() {
        return this.b + this.d.size() + this.c;
    }
    
    public T get(final int n) {
        final int n2 = 1;
        final boolean b = n >= 0 && n < this.b;
        T value = null;
        if (!b) {
            final int b2 = this.b;
            if (n < this.d.size() + b2 && b2 <= n) {
                value = this.d.get(n - this.b);
            }
            else {
                final int b3 = this.b;
                final int size = this.d.size();
                int n3;
                if (n < ((AbstractCollection)this).size() && b3 + size <= n) {
                    n3 = n2;
                }
                else {
                    n3 = 0;
                }
                if (n3 == 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Illegal attempt to access index ");
                    sb.append(n);
                    sb.append(" in ItemSnapshotList of size ");
                    sb.append(((AbstractCollection)this).size());
                    throw new IndexOutOfBoundsException(sb.toString());
                }
            }
        }
        return value;
    }
}
