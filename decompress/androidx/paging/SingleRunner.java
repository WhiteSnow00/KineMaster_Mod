// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.q1;
import kotlin.jvm.internal.o;
import java.util.concurrent.CancellationException;
import sa.p;
import kotlinx.coroutines.k0;
import ka.k;
import kotlin.coroutines.intrinsics.a;
import ka.r;
import kotlin.coroutines.c;
import sa.l;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0003\u0012\u000b\u0013B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014" }, d2 = { "Landroidx/paging/SingleRunner;", "", "", "priority", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "Lka/r;", "block", "b", "(ILsa/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/SingleRunner$Holder;", "a", "Landroidx/paging/SingleRunner$Holder;", "holder", "", "cancelPreviousInEqualPriority", "<init>", "(Z)V", "CancelIsolatedRunnerException", "Holder", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class SingleRunner
{
    public static final a b;
    private final Holder a;
    
    static {
        b = new a(null);
    }
    
    public SingleRunner() {
        this(false, 1, null);
    }
    
    public SingleRunner(final boolean b) {
        this.a = new Holder(this, b);
    }
    
    public SingleRunner(boolean b, final int n, final i i) {
        if ((n & 0x1) != 0x0) {
            b = true;
        }
        this(b);
    }
    
    public static final Holder a(final SingleRunner singleRunner) {
        return singleRunner.a;
    }
    
    public static Object c(final SingleRunner singleRunner, int n, final l l, final c c, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 0;
        }
        return singleRunner.b(n, (l<? super c<? super r>, ?>)l, (c<? super r>)c);
    }
    
    public final Object b(final int n, l<? super c<? super r>, ?> o, final c<? super r> c) {
        SingleRunner$runInIsolation.SingleRunner$runInIsolation$1 singleRunner$runInIsolation$2 = null;
        Label_0054: {
            if (c instanceof SingleRunner$runInIsolation.SingleRunner$runInIsolation$1) {
                final SingleRunner$runInIsolation.SingleRunner$runInIsolation$1 singleRunner$runInIsolation$1 = (SingleRunner$runInIsolation.SingleRunner$runInIsolation$1)c;
                final int label = singleRunner$runInIsolation$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    singleRunner$runInIsolation$1.label = label + Integer.MIN_VALUE;
                    singleRunner$runInIsolation$2 = singleRunner$runInIsolation$1;
                    break Label_0054;
                }
            }
            singleRunner$runInIsolation$2 = new SingleRunner$runInIsolation.SingleRunner$runInIsolation$1(this, (c)c);
        }
        final Object result = singleRunner$runInIsolation$2.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = singleRunner$runInIsolation$2.label;
        Label_0160: {
            if (label2 != 0) {
                if (label2 == 1) {
                    o = singleRunner$runInIsolation$2.L$0;
                    try {
                        k.b(result);
                        return r.a;
                    }
                    catch (final CancelIsolatedRunnerException ex) {
                        break Label_0160;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b(result);
            try {
                final SingleRunner$runInIsolation.SingleRunner$runInIsolation$2 singleRunner$runInIsolation$3 = new SingleRunner$runInIsolation.SingleRunner$runInIsolation$2(this, n, (l)o, (c)null);
                singleRunner$runInIsolation$2.L$0 = this;
                singleRunner$runInIsolation$2.label = 1;
                if (k0.c((p)singleRunner$runInIsolation$3, (c)singleRunner$runInIsolation$2) == d) {
                    return d;
                }
                return r.a;
            }
            catch (final CancelIsolatedRunnerException ex) {
                o = this;
            }
        }
        final CancelIsolatedRunnerException ex;
        if (ex.getRunner() != o) {
            throw ex;
        }
        return r.a;
    }
    
    @Metadata(d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b" }, d2 = { "Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common" }, k = 1, mv = { 1, 5, 1 }, xi = 48)
    private static final class CancelIsolatedRunnerException extends CancellationException
    {
        private final SingleRunner runner;
        
        public CancelIsolatedRunnerException(final SingleRunner runner) {
            o.g((Object)runner, "runner");
            this.runner = runner;
        }
        
        public final SingleRunner getRunner() {
            return this.runner;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d" }, d2 = { "Landroidx/paging/SingleRunner$Holder;", "", "", "priority", "Lkotlinx/coroutines/q1;", "job", "", "b", "(ILkotlinx/coroutines/q1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lka/r;", "a", "(Lkotlinx/coroutines/q1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/SingleRunner;", "Landroidx/paging/SingleRunner;", "singleRunner", "Z", "cancelPreviousInEqualPriority", "Lkotlinx/coroutines/sync/c;", "c", "Lkotlinx/coroutines/sync/c;", "mutex", "d", "Lkotlinx/coroutines/q1;", "previous", "e", "I", "previousPriority", "<init>", "(Landroidx/paging/SingleRunner;Z)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    private static final class Holder
    {
        private final SingleRunner a;
        private final boolean b;
        private final kotlinx.coroutines.sync.c c;
        private q1 d;
        private int e;
        
        public Holder(final SingleRunner a, final boolean b) {
            o.g((Object)a, "singleRunner");
            this.a = a;
            this.b = b;
            this.c = d.b(false, 1, (Object)null);
        }
        
        public final Object a(final q1 l$1, c<? super r> c) {
            Object o = null;
            Label_0051: {
                if (c instanceof SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1) {
                    final SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1 singleRunner$Holder$onFinish$1 = (SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)c;
                    final int label = singleRunner$Holder$onFinish$1.label;
                    if ((label & Integer.MIN_VALUE) != 0x0) {
                        singleRunner$Holder$onFinish$1.label = label + Integer.MIN_VALUE;
                        o = singleRunner$Holder$onFinish$1;
                        break Label_0051;
                    }
                }
                o = new SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1(this, (c)c);
            }
            final Object result = ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).result;
            final Object d = kotlin.coroutines.intrinsics.a.d();
            final int label2 = ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).label;
            q1 q1;
            Holder holder;
            if (label2 != 0) {
                if (label2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                final kotlinx.coroutines.sync.c c2 = (kotlinx.coroutines.sync.c)((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$2;
                q1 = (q1)((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$1;
                holder = (Holder)((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$0;
                k.b(result);
                c = c2;
            }
            else {
                k.b(result);
                final kotlinx.coroutines.sync.c c3 = this.c;
                ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$0 = this;
                ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$1 = l$1;
                ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).L$2 = c3;
                ((SingleRunner$Holder$onFinish.SingleRunner$Holder$onFinish$1)o).label = 1;
                if (c3.a((Object)null, (c)o) == d) {
                    return d;
                }
                c = c3;
                q1 = l$1;
                holder = this;
            }
            try {
                if (q1 == holder.d) {
                    holder.d = null;
                }
                return r.a;
            }
            finally {
                c.b((Object)null);
            }
        }
        
        public final Object b(int e, final q1 l$1, c<? super Boolean> o) {
            SingleRunner$Holder$tryEnqueue.SingleRunner$Holder$tryEnqueue$1 singleRunner$Holder$tryEnqueue$1 = null;
            Label_0052: {
                if (o instanceof SingleRunner$Holder$tryEnqueue.SingleRunner$Holder$tryEnqueue$1) {
                    singleRunner$Holder$tryEnqueue$1 = (SingleRunner$Holder$tryEnqueue.SingleRunner$Holder$tryEnqueue$1)o;
                    final int label = singleRunner$Holder$tryEnqueue$1.label;
                    if ((label & Integer.MIN_VALUE) != 0x0) {
                        singleRunner$Holder$tryEnqueue$1.label = label + Integer.MIN_VALUE;
                        break Label_0052;
                    }
                }
                singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue.SingleRunner$Holder$tryEnqueue$1(this, (c)o);
            }
            final Object result = singleRunner$Holder$tryEnqueue$1.result;
            final Object d = kotlin.coroutines.intrinsics.a.d();
            final int label2 = singleRunner$Holder$tryEnqueue$1.label;
            boolean b = true;
            Object l$3 = null;
            Label_0457: {
                Holder l$2 = null;
                Object o2 = null;
                Label_0440: {
                    Label_0437: {
                        if (label2 != 0) {
                            if (label2 != 1) {
                                if (label2 == 2) {
                                    e = singleRunner$Holder$tryEnqueue$1.I$0;
                                    final kotlinx.coroutines.sync.c c = (kotlinx.coroutines.sync.c)singleRunner$Holder$tryEnqueue$1.L$2;
                                    final q1 q1 = (q1)singleRunner$Holder$tryEnqueue$1.L$1;
                                    l$2 = (Holder)singleRunner$Holder$tryEnqueue$1.L$0;
                                    o = c;
                                    Label_0476: {
                                        try {
                                            k.b(result);
                                            o = q1;
                                            break Label_0437;
                                        }
                                        finally {
                                            break Label_0476;
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ((kotlinx.coroutines.sync.c)o).b((Object)null);
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            e = singleRunner$Holder$tryEnqueue$1.I$0;
                            l$3 = singleRunner$Holder$tryEnqueue$1.L$2;
                            o2 = singleRunner$Holder$tryEnqueue$1.L$1;
                            l$2 = (Holder)singleRunner$Holder$tryEnqueue$1.L$0;
                            k.b(result);
                        }
                        else {
                            k.b(result);
                            final kotlinx.coroutines.sync.c c2 = this.c;
                            singleRunner$Holder$tryEnqueue$1.L$0 = this;
                            singleRunner$Holder$tryEnqueue$1.L$1 = l$1;
                            singleRunner$Holder$tryEnqueue$1.L$2 = c2;
                            singleRunner$Holder$tryEnqueue$1.I$0 = e;
                            singleRunner$Holder$tryEnqueue$1.label = 1;
                            if (c2.a((Object)null, (c)singleRunner$Holder$tryEnqueue$1) == d) {
                                return d;
                            }
                            l$2 = this;
                            o2 = l$1;
                            l$3 = c2;
                        }
                        final q1 d2 = l$2.d;
                        if (d2 != null && d2.isActive()) {
                            final int e2 = l$2.e;
                            if (e2 >= e) {
                                if (e2 != e || !l$2.b) {
                                    b = false;
                                    break Label_0457;
                                }
                            }
                        }
                        if (d2 != null) {
                            d2.a((CancellationException)new CancelIsolatedRunnerException(l$2.a));
                        }
                        if (d2 == null) {
                            break Label_0440;
                        }
                        singleRunner$Holder$tryEnqueue$1.L$0 = l$2;
                        singleRunner$Holder$tryEnqueue$1.L$1 = o2;
                        singleRunner$Holder$tryEnqueue$1.L$2 = l$3;
                        singleRunner$Holder$tryEnqueue$1.I$0 = e;
                        singleRunner$Holder$tryEnqueue$1.label = 2;
                        if (d2.M((c)singleRunner$Holder$tryEnqueue$1) == d) {
                            return d;
                        }
                        o = o2;
                    }
                    o2 = o;
                }
                l$2.d = (q1)o2;
                l$2.e = e;
            }
            final Boolean a = kotlin.coroutines.jvm.internal.a.a(b);
            ((kotlinx.coroutines.sync.c)l$3).b((Object)null);
            return a;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Landroidx/paging/SingleRunner$a;", "", "", "DEFAULT_PRIORITY", "I", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
}
