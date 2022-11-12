// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.coroutines.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H¦@\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012" }, d2 = { "Landroidx/paging/RemoteMediator;", "", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/z;", "state", "Landroidx/paging/RemoteMediator$a;", "load", "(Landroidx/paging/LoadType;Landroidx/paging/z;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/RemoteMediator$InitializeAction;", "initialize", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "InitializeAction", "a", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class RemoteMediator<Key, Value>
{
    static Object initialize$suspendImpl(final RemoteMediator remoteMediator, final c c) {
        return InitializeAction.LAUNCH_INITIAL_REFRESH;
    }
    
    public Object initialize(final c<? super InitializeAction> c) {
        return initialize$suspendImpl(this, c);
    }
    
    public abstract Object load(final LoadType p0, final z<Key, Value> p1, final c<? super a> p2);
    
    @Metadata(d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005" }, d2 = { "Landroidx/paging/RemoteMediator$InitializeAction;", "", "(Ljava/lang/String;I)V", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH", "paging-common" }, k = 1, mv = { 1, 5, 1 }, xi = 48)
    public enum InitializeAction
    {
        private static final InitializeAction[] $VALUES;
        
        LAUNCH_INITIAL_REFRESH, 
        SKIP_INITIAL_REFRESH;
        
        static {
            $VALUES = a();
        }
        
        private static final InitializeAction[] a() {
            return new InitializeAction[] { InitializeAction.LAUNCH_INITIAL_REFRESH, InitializeAction.SKIP_INITIAL_REFRESH };
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b" }, d2 = { "Landroidx/paging/RemoteMediator$a;", "", "<init>", "()V", "a", "b", "Landroidx/paging/RemoteMediator$a$a;", "Landroidx/paging/RemoteMediator$a$b;", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public abstract static class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t" }, d2 = { "Landroidx/paging/RemoteMediator$a$a;", "Landroidx/paging/RemoteMediator$a;", "", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class a extends RemoteMediator.a
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
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t" }, d2 = { "Landroidx/paging/RemoteMediator$a$b;", "Landroidx/paging/RemoteMediator$a;", "", "a", "Z", "()Z", "endOfPaginationReached", "<init>", "(Z)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
        public static final class b extends RemoteMediator.a
        {
            private final boolean a;
            
            public b(final boolean a) {
                super(null);
                this.a = a;
            }
            
            public final boolean a() {
                return this.a;
            }
        }
    }
}
