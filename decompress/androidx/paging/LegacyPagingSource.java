// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import sa.p;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0014J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0007J-\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 " }, d2 = { "Landroidx/paging/LegacyPagingSource;", "", "Key", "Value", "Landroidx/paging/PagingSource;", "Landroidx/paging/PagingSource$a;", "params", "", "b", "pageSize", "Lka/r;", "c", "Landroidx/paging/PagingSource$b;", "load", "(Landroidx/paging/PagingSource$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/z;", "state", "getRefreshKey", "(Landroidx/paging/z;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "I", "Landroidx/paging/d;", "dataSource", "Landroidx/paging/d;", "()Landroidx/paging/d;", "", "getJumpingSupported", "()Z", "jumpingSupported", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value>
{
    private static final a c;
    private final CoroutineDispatcher a;
    private int b;
    
    static {
        c = new a(null);
    }
    
    private final int b(final PagingSource.a<Key> a) {
        if (a instanceof PagingSource.a.d && a.b() % 3 == 0) {
            return a.b() / 3;
        }
        return a.b();
    }
    
    public final d<Key, Value> a() {
        return null;
    }
    
    public final void c(final int b) {
        final int b2 = this.b;
        if (b2 == Integer.MIN_VALUE || b == b2) {
            this.b = b;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Page size is already set to ");
        sb.append(this.b);
        sb.append('.');
        throw new IllegalStateException(sb.toString().toString());
    }
    
    @Override
    public boolean getJumpingSupported() {
        throw null;
    }
    
    @Override
    public Key getRefreshKey(final z<Key, Value> z) {
        o.g((Object)z, "state");
        throw null;
    }
    
    @Override
    public Object load(final PagingSource.a<Key> a, final c<? super b<Key, Value>> c) {
        LoadType loadType;
        if (a instanceof PagingSource.a.d) {
            loadType = LoadType.REFRESH;
        }
        else if (a instanceof PagingSource.a.a) {
            loadType = LoadType.APPEND;
        }
        else {
            if (!(a instanceof PagingSource.a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            loadType = LoadType.PREPEND;
        }
        if (this.b == Integer.MIN_VALUE) {
            System.out.println((Object)"WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.b = this.b(a);
        }
        return h.e((CoroutineContext)this.a, (p)new LegacyPagingSource$load.LegacyPagingSource$load$2(this, new d.b(loadType, a.a(), a.b(), a.c(), this.b), (PagingSource.a)a, (c)null), (c)c);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Landroidx/paging/LegacyPagingSource$a;", "", "", "PAGE_SIZE_NOT_SET", "I", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    private static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
}
