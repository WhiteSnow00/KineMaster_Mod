// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.Result$a;
import kotlin.Result;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.q1$a;
import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import ka.k;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import sa.p;
import kotlinx.coroutines.sync.c;
import ka.r;
import kotlinx.coroutines.n;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.q1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006" }, d2 = { "Landroidx/lifecycle/r;", "<anonymous parameter 0>", "Landroidx/lifecycle/Lifecycle$Event;", "event", "Lka/r;", "f", "(Landroidx/lifecycle/r;Landroidx/lifecycle/Lifecycle$Event;)V" }, k = 3, mv = { 1, 6, 0 })
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements o
{
    final Lifecycle.Event a;
    final Ref$ObjectRef<q1> b;
    final j0 c;
    final Lifecycle.Event d;
    final n<r> e;
    final c f;
    final p<j0, kotlin.coroutines.c<? super r>, Object> g;
    
    @Override
    public final void f(final androidx.lifecycle.r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)r, "<anonymous parameter 0>");
        kotlin.jvm.internal.o.g((Object)event, "event");
        if (event == this.a) {
            this.b.element = h.b(this.c, (CoroutineContext)null, (CoroutineStart)null, (p)new p<j0, kotlin.coroutines.c<? super r>, Object>(this.f, this.g, null) {
                final p<j0, kotlin.coroutines.c<? super r>, Object> $block;
                final c $mutex;
                Object L$0;
                Object L$1;
                int label;
                
                public final kotlin.coroutines.c<r> create(final Object o, final kotlin.coroutines.c<?> c) {
                    return (kotlin.coroutines.c<r>)new p<j0, kotlin.coroutines.c<? super r>, Object>(this.$mutex, this.$block, c) {
                        final p<j0, kotlin.coroutines.c<? super r>, Object> $block;
                        final c $mutex;
                        Object L$0;
                        Object L$1;
                        int label;
                    };
                }
                
                public /* bridge */ Object invoke(final Object o, final Object o2) {
                    return this.invoke((j0)o, (kotlin.coroutines.c<? super r>)o2);
                }
                
                public final Object invoke(final j0 j0, final kotlin.coroutines.c<? super r> c) {
                    return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1)this.create(j0, c)).invokeSuspend(r.a);
                }
                
                public final Object invokeSuspend(Object l$0) {
                    final Object d = kotlin.coroutines.intrinsics.a.d();
                    final int label = this.label;
                    Throwable t = null;
                    Label_0187: {
                        p $block;
                        if (label != 0) {
                            if (label != 1) {
                                if (label == 2) {
                                    final c c = (c)this.L$0;
                                    try {
                                        k.b(l$0);
                                        break Label_0187;
                                    }
                                    finally {
                                        l$0 = c;
                                        final Throwable t2;
                                        t = t2;
                                        break Label_0187;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            $block = (p)this.L$1;
                            final c c2 = (c)this.L$0;
                            k.b(l$0);
                            l$0 = c2;
                        }
                        else {
                            k.b(l$0);
                            final c $mutex = this.$mutex;
                            $block = this.$block;
                            this.L$0 = $mutex;
                            this.L$1 = $block;
                            this.label = 1;
                            l$0 = $mutex;
                            if ($mutex.a((Object)null, (kotlin.coroutines.c)this) == d) {
                                return d;
                            }
                        }
                        try {
                            final RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1($block, (kotlin.coroutines.c)null);
                            this.L$0 = l$0;
                            this.L$1 = null;
                            this.label = 2;
                            if (k0.c((p)repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, (kotlin.coroutines.c)this) == d) {
                                return d;
                            }
                            final r a = r.a;
                            ((c)l$0).b((Object)null);
                            return a;
                        }
                        finally {}
                    }
                    ((c)l$0).b((Object)null);
                    throw t;
                }
            }, 3, (Object)null);
            return;
        }
        if (event == this.d) {
            final q1 q1 = (q1)this.b.element;
            if (q1 != null) {
                q1$a.a(q1, (CancellationException)null, 1, (Object)null);
            }
            this.b.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            final n<r> e = this.e;
            final Result$a companion = Result.Companion;
            ((kotlin.coroutines.c)e).resumeWith(Result.constructor-impl((Object)r.a));
        }
    }
}
