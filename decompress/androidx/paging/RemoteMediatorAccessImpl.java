// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.flow.s;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import sa.l;
import ka.k;
import sa.p;
import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlin.coroutines.c;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.j0;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 %*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u000fB#\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b#\u0010$J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J$\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0016J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0016J\u0013\u0010\u000f\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&" }, d2 = { "Landroidx/paging/RemoteMediatorAccessImpl;", "", "Key", "Value", "Landroidx/paging/a0;", "Lka/r;", "i", "h", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/z;", "pagingState", "c", "b", "Landroidx/paging/RemoteMediator$InitializeAction;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/j0;", "Lkotlinx/coroutines/j0;", "scope", "Landroidx/paging/RemoteMediator;", "Landroidx/paging/RemoteMediator;", "remoteMediator", "Landroidx/paging/a;", "Landroidx/paging/a;", "accessorState", "Landroidx/paging/SingleRunner;", "d", "Landroidx/paging/SingleRunner;", "isolationRunner", "Lkotlinx/coroutines/flow/s;", "Landroidx/paging/n;", "getState", "()Lkotlinx/coroutines/flow/s;", "state", "<init>", "(Lkotlinx/coroutines/j0;Landroidx/paging/RemoteMediator;)V", "e", "paging-common" }, k = 1, mv = { 1, 5, 1 })
final class RemoteMediatorAccessImpl<Key, Value> implements a0<Key, Value>
{
    public static final a e;
    private final j0 a;
    private final RemoteMediator<Key, Value> b;
    private final androidx.paging.a<Key, Value> c;
    private final SingleRunner d;
    
    static {
        e = new a(null);
    }
    
    public RemoteMediatorAccessImpl(final j0 a, final RemoteMediator<Key, Value> b) {
        o.g((Object)a, "scope");
        o.g((Object)b, "remoteMediator");
        this.a = a;
        this.b = b;
        this.c = new androidx.paging.a<Key, Value>();
        this.d = new SingleRunner(false);
    }
    
    public static final androidx.paging.a d(final RemoteMediatorAccessImpl remoteMediatorAccessImpl) {
        return remoteMediatorAccessImpl.c;
    }
    
    public static final SingleRunner e(final RemoteMediatorAccessImpl remoteMediatorAccessImpl) {
        return remoteMediatorAccessImpl.d;
    }
    
    public static final RemoteMediator f(final RemoteMediatorAccessImpl remoteMediatorAccessImpl) {
        return remoteMediatorAccessImpl.b;
    }
    
    public static final void g(final RemoteMediatorAccessImpl remoteMediatorAccessImpl) {
        remoteMediatorAccessImpl.h();
    }
    
    private final void h() {
        h.b(this.a, (CoroutineContext)null, (CoroutineStart)null, (p)new RemoteMediatorAccessImpl$launchBoundary.RemoteMediatorAccessImpl$launchBoundary$1(this, (c)null), 3, (Object)null);
    }
    
    private final void i() {
        h.b(this.a, (CoroutineContext)null, (CoroutineStart)null, (p)new RemoteMediatorAccessImpl$launchRefresh.RemoteMediatorAccessImpl$launchRefresh$1(this, (c)null), 3, (Object)null);
    }
    
    @Override
    public Object a(final c<? super RemoteMediator.InitializeAction> c) {
        Object o = null;
        Label_0047: {
            if (c instanceof RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1) {
                final RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1 remoteMediatorAccessImpl$initialize$1 = (RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)c;
                final int label = remoteMediatorAccessImpl$initialize$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    remoteMediatorAccessImpl$initialize$1.label = label + Integer.MIN_VALUE;
                    o = remoteMediatorAccessImpl$initialize$1;
                    break Label_0047;
                }
            }
            o = new RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1(this, (c)c);
        }
        final Object result = ((RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)o).result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = ((RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)o).label;
        RemoteMediatorAccessImpl remoteMediatorAccessImpl;
        Object initialize;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            remoteMediatorAccessImpl = (RemoteMediatorAccessImpl)((RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)o).L$0;
            k.b(result);
            initialize = result;
        }
        else {
            k.b(result);
            final RemoteMediator<Key, Value> b = this.b;
            ((RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)o).L$0 = this;
            ((RemoteMediatorAccessImpl$initialize.RemoteMediatorAccessImpl$initialize$1)o).label = 1;
            initialize = b.initialize((c)o);
            if (initialize == d) {
                return d;
            }
            remoteMediatorAccessImpl = this;
        }
        if (initialize == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
            remoteMediatorAccessImpl.c.b((sa.l<? super AccessorState<Key, Value>, ?>)RemoteMediatorAccessImpl$initialize$2.RemoteMediatorAccessImpl$initialize$2$1.INSTANCE);
        }
        return initialize;
    }
    
    @Override
    public void b(final z<Key, Value> z) {
        o.g((Object)z, "pagingState");
        final ArrayList list = new ArrayList();
        this.c.b((sa.l<? super AccessorState<Key, Value>, ?>)new RemoteMediatorAccessImpl$retryFailed.RemoteMediatorAccessImpl$retryFailed$1((List)list));
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.c((LoadType)iterator.next(), z);
        }
    }
    
    @Override
    public void c(final LoadType loadType, final z<Key, Value> z) {
        o.g((Object)loadType, "loadType");
        o.g((Object)z, "pagingState");
        if (this.c.b((sa.l<? super AccessorState<Key, Value>, ? extends Boolean>)new RemoteMediatorAccessImpl$requestLoad$newRequest.RemoteMediatorAccessImpl$requestLoad$newRequest$1(loadType, (z)z))) {
            if (RemoteMediatorAccessImpl.b.a[loadType.ordinal()] == 1) {
                this.i();
            }
            else {
                this.h();
            }
        }
    }
    
    @Override
    public s<n> getState() {
        return this.c.a();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b" }, d2 = { "Landroidx/paging/RemoteMediatorAccessImpl$a;", "", "", "PRIORITY_APPEND_PREPEND", "I", "PRIORITY_REFRESH", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class b
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.REFRESH.ordinal()] = 1;
            a = a2;
        }
    }
}
