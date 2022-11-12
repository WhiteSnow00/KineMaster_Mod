// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.Pair;
import java.util.List;
import kotlin.jvm.internal.o;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import java.util.Collection;
import kotlin.collections.g;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002&\rB\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nJ \u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\"¨\u0006'" }, d2 = { "Landroidx/paging/AccessorState;", "", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/l;", "f", "Landroidx/paging/n;", "e", "Landroidx/paging/z;", "pagingState", "", "a", "Landroidx/paging/AccessorState$BlockState;", "state", "Lka/r;", "i", "h", "Lkotlin/Pair;", "g", "d", "c", "b", "Landroidx/paging/l$a;", "errorState", "j", "", "[Landroidx/paging/AccessorState$BlockState;", "blockStates", "[Landroidx/paging/l$a;", "errors", "Lkotlin/collections/g;", "Landroidx/paging/AccessorState$a;", "Lkotlin/collections/g;", "pendingRequests", "<init>", "()V", "BlockState", "paging-common" }, k = 1, mv = { 1, 5, 1 })
final class AccessorState<Key, Value>
{
    private final BlockState[] a;
    private final l.a[] b;
    private final g<a<Key, Value>> c;
    
    public AccessorState() {
        final int length = LoadType.values().length;
        final BlockState[] a = new BlockState[length];
        final int n = 0;
        for (int i = 0; i < length; ++i) {
            a[i] = BlockState.UNBLOCKED;
        }
        this.a = a;
        final int length2 = LoadType.values().length;
        final l.a[] b = new l.a[length2];
        for (int j = n; j < length2; ++j) {
            b[j] = null;
        }
        this.b = b;
        this.c = (g<a<Key, Value>>)new g();
    }
    
    private final l f(final LoadType loadType) {
        final BlockState blockState = this.a[loadType.ordinal()];
        final g<a<Key, Value>> c = this.c;
        final boolean b = c instanceof Collection;
        final int n = 0;
        int n2 = 0;
        Label_0097: {
            if (b && ((Collection)c).isEmpty()) {
                n2 = n;
            }
            else {
                final Iterator<a> iterator = ((Iterable<a>)c).iterator();
                do {
                    n2 = n;
                    if (iterator.hasNext()) {
                        continue;
                    }
                    break Label_0097;
                } while (((a)iterator.next()).a() != loadType);
                n2 = 1;
            }
        }
        if (n2 != 0 && blockState != BlockState.REQUIRES_REFRESH) {
            return l.b.b;
        }
        final l.a a = this.b[loadType.ordinal()];
        if (a == null) {
            final int n3 = AccessorState.b.a[blockState.ordinal()];
            l.c c2;
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    c2 = l.c.b.b();
                }
                else {
                    c2 = l.c.b.b();
                }
            }
            else if (AccessorState.b.b[loadType.ordinal()] == 1) {
                c2 = l.c.b.b();
            }
            else {
                c2 = l.c.b.a();
            }
            return c2;
        }
        return a;
    }
    
    public final boolean a(final LoadType loadType, final z<Key, Value> z) {
        o.g((Object)loadType, "loadType");
        o.g((Object)z, "pagingState");
        final Iterator<a<Key, Value>> iterator = ((Iterable<a<Key, Value>>)this.c).iterator();
        while (true) {
            a next;
            do {
                final boolean hasNext = iterator.hasNext();
                boolean add = false;
                if (hasNext) {
                    next = iterator.next();
                }
                else {
                    next = null;
                    final a a = next;
                    if (a != null) {
                        a.c(z);
                        return false;
                    }
                    final BlockState blockState = this.a[loadType.ordinal()];
                    if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
                        this.c.add((Object)new a(loadType, (z<Object, Object>)z));
                        return false;
                    }
                    if (blockState != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
                        return false;
                    }
                    final LoadType refresh = LoadType.REFRESH;
                    if (loadType == refresh) {
                        this.j(refresh, null);
                    }
                    if (this.b[loadType.ordinal()] == null) {
                        add = this.c.add((Object)new a(loadType, (z<Object, Object>)z));
                    }
                    return add;
                }
            } while (next.a() != loadType);
            continue;
        }
    }
    
    public final void b() {
        final int n = this.b.length - 1;
        if (n >= 0) {
            int n2 = 0;
            while (true) {
                final int n3 = n2 + 1;
                this.b[n2] = null;
                if (n3 > n) {
                    break;
                }
                n2 = n3;
            }
        }
    }
    
    public final void c(final LoadType loadType) {
        o.g((Object)loadType, "loadType");
        kotlin.collections.o.E((List)this.c, (sa.l)new AccessorState$clearPendingRequest.AccessorState$clearPendingRequest$1(loadType));
    }
    
    public final void d() {
        this.c.clear();
    }
    
    public final n e() {
        return new n(this.f(LoadType.REFRESH), this.f(LoadType.PREPEND), this.f(LoadType.APPEND));
    }
    
    public final Pair<LoadType, z<Key, Value>> g() {
        final Iterator<a<Key, Value>> iterator = ((Iterable<a<Key, Value>>)this.c).iterator();
        while (true) {
            a a;
            do {
                final boolean hasNext = iterator.hasNext();
                final Pair<LoadType, z<Key, Value>> pair = null;
                if (!hasNext) {
                    final a next = null;
                    final a a2 = next;
                    Pair a3;
                    if (a2 == null) {
                        a3 = pair;
                    }
                    else {
                        a3 = ka.l.a((Object)a2.a(), (Object)a2.b());
                    }
                    return (Pair<LoadType, z<Key, Value>>)a3;
                }
                final a next = iterator.next();
                a = next;
            } while (a.a() == LoadType.REFRESH || this.a[a.a().ordinal()] != BlockState.UNBLOCKED);
            continue;
        }
    }
    
    public final z<Key, Value> h() {
        final Iterator<a<Key, Value>> iterator = ((Iterable<a<Key, Value>>)this.c).iterator();
        while (true) {
            a next;
            do {
                final boolean hasNext = iterator.hasNext();
                final z<Key, Value> z = null;
                if (!hasNext) {
                    next = null;
                    final a a = next;
                    z<Key, Value> b;
                    if (a == null) {
                        b = z;
                    }
                    else {
                        b = a.b();
                    }
                    return b;
                }
                next = iterator.next();
            } while (next.a() != LoadType.REFRESH);
            continue;
        }
    }
    
    public final void i(final LoadType loadType, final BlockState blockState) {
        o.g((Object)loadType, "loadType");
        o.g((Object)blockState, "state");
        this.a[loadType.ordinal()] = blockState;
    }
    
    public final void j(final LoadType loadType, final l.a a) {
        o.g((Object)loadType, "loadType");
        this.b[loadType.ordinal()] = a;
    }
    
    @Metadata(d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common" }, k = 1, mv = { 1, 5, 1 }, xi = 48)
    public enum BlockState
    {
        private static final BlockState[] $VALUES;
        
        COMPLETED, 
        REQUIRES_REFRESH, 
        UNBLOCKED;
        
        static {
            $VALUES = a();
        }
        
        private static final BlockState[] a() {
            return new BlockState[] { BlockState.UNBLOCKED, BlockState.COMPLETED, BlockState.REQUIRES_REFRESH };
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012" }, d2 = { "Landroidx/paging/AccessorState$a;", "", "Key", "Value", "Landroidx/paging/LoadType;", "a", "Landroidx/paging/LoadType;", "()Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/z;", "b", "Landroidx/paging/z;", "()Landroidx/paging/z;", "c", "(Landroidx/paging/z;)V", "pagingState", "<init>", "(Landroidx/paging/LoadType;Landroidx/paging/z;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a<Key, Value>
    {
        private final LoadType a;
        private z<Key, Value> b;
        
        public a(final LoadType a, final z<Key, Value> b) {
            o.g((Object)a, "loadType");
            o.g((Object)b, "pagingState");
            this.a = a;
            this.b = b;
        }
        
        public final LoadType a() {
            return this.a;
        }
        
        public final z<Key, Value> b() {
            return this.b;
        }
        
        public final void c(final z<Key, Value> b) {
            o.g((Object)b, "<set-?>");
            this.b = b;
        }
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class b
    {
        public static final int[] a;
        public static final int[] b;
        
        static {
            final int[] a2 = new int[BlockState.values().length];
            a2[BlockState.COMPLETED.ordinal()] = 1;
            a2[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            a2[BlockState.UNBLOCKED.ordinal()] = 3;
            a = a2;
            final int[] b2 = new int[LoadType.values().length];
            b2[LoadType.REFRESH.ordinal()] = 1;
            b = b2;
        }
    }
}
