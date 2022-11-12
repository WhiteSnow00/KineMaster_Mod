// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.o;
import kotlin.coroutines.c;
import kotlin.jvm.internal.i;
import sa.l;
import ka.r;
import sa.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J-\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦@\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010!\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b \u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&" }, d2 = { "Landroidx/paging/PagingSource;", "", "Key", "Value", "Lka/r;", "invalidate", "Lkotlin/Function0;", "onInvalidatedCallback", "registerInvalidatedCallback", "unregisterInvalidatedCallback", "Landroidx/paging/PagingSource$a;", "params", "Landroidx/paging/PagingSource$b;", "load", "(Landroidx/paging/PagingSource$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/z;", "state", "getRefreshKey", "(Landroidx/paging/z;)Ljava/lang/Object;", "Landroidx/paging/j;", "invalidateCallbackTracker", "Landroidx/paging/j;", "", "getInvalidateCallbackCount$paging_common", "()I", "invalidateCallbackCount", "", "getJumpingSupported", "()Z", "jumpingSupported", "getKeyReuseSupported", "keyReuseSupported", "getInvalid", "invalid", "<init>", "()V", "a", "b", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class PagingSource<Key, Value>
{
    private final j<sa.a<r>> invalidateCallbackTracker;
    
    public PagingSource() {
        this.invalidateCallbackTracker = new j<sa.a<r>>((l)PagingSource$invalidateCallbackTracker.PagingSource$invalidateCallbackTracker$1.INSTANCE, null, 2, null);
    }
    
    public final boolean getInvalid() {
        return this.invalidateCallbackTracker.b();
    }
    
    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.a();
    }
    
    public boolean getJumpingSupported() {
        return false;
    }
    
    public boolean getKeyReuseSupported() {
        return false;
    }
    
    public abstract Key getRefreshKey(final z<Key, Value> p0);
    
    public final void invalidate() {
        this.invalidateCallbackTracker.c();
    }
    
    public abstract Object load(final a<Key> p0, final c<? super b<Key, Value>> p1);
    
    public final void registerInvalidatedCallback(final sa.a<r> a) {
        o.g((Object)a, "onInvalidatedCallback");
        this.invalidateCallbackTracker.d(a);
    }
    
    public final void unregisterInvalidatedCallback(final sa.a<r> a) {
        o.g((Object)a, "onInvalidatedCallback");
        this.invalidateCallbackTracker.e(a);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u0004\u0006\u000b\u0012B\u0019\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00018\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000e\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016" }, d2 = { "Landroidx/paging/PagingSource$a;", "", "Key", "", "a", "I", "b", "()I", "loadSize", "", "Z", "c", "()Z", "placeholdersEnabled", "()Ljava/lang/Object;", "key", "<init>", "(IZ)V", "d", "Landroidx/paging/PagingSource$a$d;", "Landroidx/paging/PagingSource$a$a;", "Landroidx/paging/PagingSource$a$c;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public abstract static class a<Key>
    {
        public static final b c;
        private final int a;
        private final boolean b;
        
        static {
            c = new b(null);
        }
        
        private a(final int a, final boolean b) {
            this.a = a;
            this.b = b;
        }
        
        public a(final int n, final boolean b, final i i) {
            this(n, b);
        }
        
        public abstract Key a();
        
        public final int b() {
            return this.a;
        }
        
        public final boolean c() {
            return this.b;
        }
        
        @Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\b\u001a\u00028\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f" }, d2 = { "Landroidx/paging/PagingSource$a$a;", "", "Key", "Landroidx/paging/PagingSource$a;", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a<Key> extends PagingSource.a<Key>
        {
            private final Key d;
            
            public a(final Key d, final int n, final boolean b) {
                o.g((Object)d, "key");
                super(n, b, null);
                this.d = d;
            }
            
            @Override
            public Key a() {
                return this.d;
            }
        }
        
        @Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00030\n\"\b\b\u0003\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f" }, d2 = { "Landroidx/paging/PagingSource$a$b;", "", "Key", "Landroidx/paging/LoadType;", "loadType", "key", "", "loadSize", "", "placeholdersEnabled", "Landroidx/paging/PagingSource$a;", "a", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$a;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class b
        {
            private b() {
            }
            
            public b(final i i) {
                this();
            }
            
            public final <Key> PagingSource.a<Key> a(final LoadType loadType, final Key key, final int n, final boolean b) {
                o.g((Object)loadType, "loadType");
                final int n2 = a.a[loadType.ordinal()];
                Object o;
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (key == null) {
                            throw new IllegalArgumentException("key cannot be null for append".toString());
                        }
                        o = new PagingSource.a.a(key, n, b);
                    }
                    else {
                        if (key == null) {
                            throw new IllegalArgumentException("key cannot be null for prepend".toString());
                        }
                        o = new c(key, n, b);
                    }
                }
                else {
                    o = new d(key, n, b);
                }
                return (PagingSource.a<Key>)o;
            }
            
            @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
            public final class a
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
        
        @Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\b\u001a\u00028\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f" }, d2 = { "Landroidx/paging/PagingSource$a$c;", "", "Key", "Landroidx/paging/PagingSource$a;", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class c<Key> extends PagingSource.a<Key>
        {
            private final Key d;
            
            public c(final Key d, final int n, final boolean b) {
                o.g((Object)d, "key");
                super(n, b, null);
                this.d = d;
            }
            
            @Override
            public Key a() {
                return this.d;
            }
        }
        
        @Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B!\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00018\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f" }, d2 = { "Landroidx/paging/PagingSource$a$d;", "", "Key", "Landroidx/paging/PagingSource$a;", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class d<Key> extends PagingSource.a<Key>
        {
            private final Key d;
            
            public d(final Key d, final int n, final boolean b) {
                super(n, b, null);
                this.d = d;
            }
            
            @Override
            public Key a() {
                return this.d;
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f" }, d2 = { "Landroidx/paging/PagingSource$b;", "", "Key", "Value", "<init>", "()V", "a", "b", "c", "Landroidx/paging/PagingSource$b$a;", "Landroidx/paging/PagingSource$b$b;", "Landroidx/paging/PagingSource$b$c;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public abstract static class b<Key, Value>
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
        
        @Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0013" }, d2 = { "Landroidx/paging/PagingSource$b$a;", "", "Key", "Value", "Landroidx/paging/PagingSource$b;", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a<Key, Value> extends PagingSource.b<Key, Value>
        {
            private final Throwable a;
            
            public a(final Throwable a) {
                o.g((Object)a, "throwable");
                super(null);
                this.a = a;
            }
            
            public final Throwable a() {
                return this.a;
            }
            
            @Override
            public boolean equals(final Object o) {
                return this == o || (o instanceof a && o.b((Object)this.a, (Object)((a)o).a));
            }
            
            @Override
            public int hashCode() {
                return this.a.hashCode();
            }
            
            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder();
                sb.append("Error(throwable=");
                sb.append(this.a);
                sb.append(')');
                return sb.toString();
            }
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Landroidx/paging/PagingSource$b$b;", "", "Key", "Value", "Landroidx/paging/PagingSource$b;", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class b<Key, Value> extends PagingSource.b<Key, Value>
        {
            public b() {
                super(null);
            }
        }
        
        @Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0015\b\u0086\b\u0018\u0000  *\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004:\u0001\rB=\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00050\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00050\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0004¢\u0006\u0004\b\u001d\u0010\u001fJ\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00050\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u0016\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a¨\u0006!" }, d2 = { "Landroidx/paging/PagingSource$b$c;", "", "Key", "Value", "Landroidx/paging/PagingSource$b;", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "b", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "prevKey", "c", "d", "nextKey", "I", "()I", "itemsBefore", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "f", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class c<Key, Value> extends PagingSource.b<Key, Value>
        {
            public static final a f;
            private static final c g;
            private final List<Value> a;
            private final Key b;
            private final Key c;
            private final int d;
            private final int e;
            
            static {
                f = new a(null);
                g = new c(kotlin.collections.o.j(), null, null, 0, 0);
            }
            
            public c(final List<? extends Value> list, final Key key, final Key key2) {
                o.g((Object)list, "data");
                this(list, key, key2, Integer.MIN_VALUE, Integer.MIN_VALUE);
            }
            
            public c(final List<? extends Value> a, final Key b, final Key c, int d, final int e) {
                o.g((Object)a, "data");
                super(null);
                this.a = (List<Value>)a;
                this.b = b;
                this.c = c;
                this.d = d;
                this.e = e;
                final int n = 0;
                if (d != Integer.MIN_VALUE && d < 0) {
                    d = 0;
                }
                else {
                    d = 1;
                }
                if (d == 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
                }
                Label_0089: {
                    if (e != Integer.MIN_VALUE) {
                        d = n;
                        if (e < 0) {
                            break Label_0089;
                        }
                    }
                    d = 1;
                }
                if (d != 0) {
                    return;
                }
                throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
            }
            
            public final List<Value> a() {
                return this.a;
            }
            
            public final int b() {
                return this.e;
            }
            
            public final int c() {
                return this.d;
            }
            
            public final Key d() {
                return this.c;
            }
            
            public final Key e() {
                return this.b;
            }
            
            @Override
            public boolean equals(final Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof c)) {
                    return false;
                }
                final c c = (c)o;
                return o.b((Object)this.a, (Object)c.a) && o.b((Object)this.b, (Object)c.b) && o.b((Object)this.c, (Object)c.c) && this.d == c.d && this.e == c.e;
            }
            
            @Override
            public int hashCode() {
                final int hashCode = this.a.hashCode();
                final Key b = this.b;
                int hashCode2 = 0;
                int hashCode3;
                if (b == null) {
                    hashCode3 = 0;
                }
                else {
                    hashCode3 = b.hashCode();
                }
                final Key c = this.c;
                if (c != null) {
                    hashCode2 = c.hashCode();
                }
                return (((hashCode * 31 + hashCode3) * 31 + hashCode2) * 31 + Integer.hashCode(this.d)) * 31 + Integer.hashCode(this.e);
            }
            
            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder();
                sb.append("Page(data=");
                sb.append(this.a);
                sb.append(", prevKey=");
                sb.append(this.b);
                sb.append(", nextKey=");
                sb.append(this.c);
                sb.append(", itemsBefore=");
                sb.append(this.d);
                sb.append(", itemsAfter=");
                sb.append(this.e);
                sb.append(')');
                return sb.toString();
            }
            
            @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Landroidx/paging/PagingSource$b$c$a;", "", "", "COUNT_UNDEFINED", "I", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
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
}
