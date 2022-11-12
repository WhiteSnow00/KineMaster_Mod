// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u0004\u0005¨\u0006\u0006" }, d2 = { "Landroidx/paging/d;", "", "Key", "Value", "a", "b", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class d<Key, Value>
{
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0017*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0007J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0007\u0010\u0013¨\u0006\u0018" }, d2 = { "Landroidx/paging/d$a;", "", "Value", "other", "", "equals", "", "a", "Ljava/util/List;", "data", "b", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "prevKey", "c", "nextKey", "", "I", "()I", "itemsBefore", "e", "itemsAfter", "f", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a<Value>
    {
        public static final d.a.a f;
        public final List<Value> a;
        private final Object b;
        private final Object c;
        private final int d;
        private final int e;
        
        static {
            f = new d.a.a(null);
        }
        
        public final int a() {
            return this.e;
        }
        
        public final int b() {
            return this.d;
        }
        
        public final Object c() {
            return this.c;
        }
        
        public final Object d() {
            return this.b;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof d.a;
            boolean b3;
            final boolean b2 = b3 = false;
            if (b) {
                final List<Value> a = this.a;
                final d.a a2 = (d.a)o;
                b3 = b2;
                if (o.b((Object)a, (Object)a2.a)) {
                    b3 = b2;
                    if (o.b(this.b, a2.b)) {
                        b3 = b2;
                        if (o.b(this.c, a2.c)) {
                            b3 = b2;
                            if (this.d == a2.d) {
                                b3 = b2;
                                if (this.e == a2.e) {
                                    b3 = true;
                                }
                            }
                        }
                    }
                }
            }
            return b3;
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004" }, d2 = { "Landroidx/paging/d$a$a;", "", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00018\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001f" }, d2 = { "Landroidx/paging/d$b;", "", "K", "Landroidx/paging/LoadType;", "a", "Landroidx/paging/LoadType;", "getType$paging_common", "()Landroidx/paging/LoadType;", "type", "b", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", "", "c", "I", "getInitialLoadSize", "()I", "initialLoadSize", "", "d", "Z", "getPlaceholdersEnabled", "()Z", "placeholdersEnabled", "e", "getPageSize", "pageSize", "<init>", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class b<K>
    {
        private final LoadType a;
        private final K b;
        private final int c;
        private final boolean d;
        private final int e;
        
        public b(final LoadType a, final K b, final int c, final boolean d, final int e) {
            o.g((Object)a, "type");
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            if (a != LoadType.REFRESH && b == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }
    }
}
