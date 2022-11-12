// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.Iterator;
import java.util.Collection;
import kotlin.jvm.internal.o;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B=\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\fH\u0016R)\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001c¨\u0006 " }, d2 = { "Landroidx/paging/z;", "", "Key", "Value", "other", "", "equals", "", "hashCode", "anchorPosition", "Landroidx/paging/PagingSource$b$c;", "b", "", "toString", "", "a", "Ljava/util/List;", "e", "()Ljava/util/List;", "pages", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Landroidx/paging/x;", "Landroidx/paging/x;", "d", "()Landroidx/paging/x;", "config", "I", "leadingPlaceholderCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/x;I)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class z<Key, Value>
{
    private final List<PagingSource.b.c<Key, Value>> a;
    private final Integer b;
    private final x c;
    private final int d;
    
    public z(final List<PagingSource.b.c<Key, Value>> a, final Integer b, final x c, final int d) {
        o.g((Object)a, "pages");
        o.g((Object)c, "config");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static final int a(final z z) {
        return z.d;
    }
    
    public final PagingSource.b.c<Key, Value> b(int n) {
        final List<PagingSource.b.c<Key, Value>> a = this.a;
        final boolean b = a instanceof Collection;
        final int n2 = 0;
        final boolean b2 = true;
        int n3 = 0;
        Label_0084: {
            if (b && a.isEmpty()) {
                n3 = (b2 ? 1 : 0);
            }
            else {
                final Iterator iterator = a.iterator();
                do {
                    n3 = (b2 ? 1 : 0);
                    if (iterator.hasNext()) {
                        continue;
                    }
                    break Label_0084;
                } while (((PagingSource.b.c)iterator.next()).a().isEmpty());
                n3 = 0;
            }
        }
        if (n3 != 0) {
            return null;
        }
        int n4;
        for (n -= a(this), n4 = n2; n4 < kotlin.collections.o.l((List)this.e()) && n > kotlin.collections.o.l((List)this.e().get(n4).a()); n -= this.e().get(n4).a().size(), ++n4) {}
        PagingSource.b.c c;
        if (n < 0) {
            c = (PagingSource.b.c)kotlin.collections.o.b0((List)this.e());
        }
        else {
            c = this.e().get(n4);
        }
        return c;
    }
    
    public final Integer c() {
        return this.b;
    }
    
    public final x d() {
        return this.c;
    }
    
    public final List<PagingSource.b.c<Key, Value>> e() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof z) {
            final List<PagingSource.b.c<Key, Value>> a = this.a;
            final z z = (z)o;
            if (o.b((Object)a, (Object)z.a) && o.b((Object)this.b, (Object)z.b) && o.b((Object)this.c, (Object)z.c) && this.d == z.d) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final Integer b = this.b;
        int hashCode2;
        if (b != null) {
            hashCode2 = b.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        return hashCode + hashCode2 + this.c.hashCode() + Integer.hashCode(this.d);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PagingState(pages=");
        sb.append(this.a);
        sb.append(", anchorPosition=");
        sb.append(this.b);
        sb.append(", config=");
        sb.append(this.c);
        sb.append(", leadingPlaceholderCount=");
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
