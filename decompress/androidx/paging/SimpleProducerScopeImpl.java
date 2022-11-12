// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.jvm.internal.f;
import sa.l;
import kotlinx.coroutines.n;
import ka.k;
import kotlinx.coroutines.q1;
import kotlin.coroutines.c;
import ka.r;
import sa.a;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlin.Metadata;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.j0;

@Metadata(bv = {}, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b!\u0010\"J\u001f\u0010\t\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0097\u0001J\u0015\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001b\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#" }, d2 = { "Landroidx/paging/SimpleProducerScopeImpl;", "T", "Landroidx/paging/d0;", "Lkotlinx/coroutines/j0;", "Lkotlinx/coroutines/channels/u;", "Lkotlin/Function1;", "", "Lka/r;", "handler", "y", "cause", "", "x", "element", "z", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "block", "h", "(Lsa/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/channels/u;", "getChannel", "()Lkotlinx/coroutines/channels/u;", "channel", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "A", "()Z", "isClosedForSend", "scope", "<init>", "(Lkotlinx/coroutines/j0;Lkotlinx/coroutines/channels/u;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class SimpleProducerScopeImpl<T> implements d0<T>, j0, u<T>
{
    private final u<T> a;
    private final j0 b;
    
    public SimpleProducerScopeImpl(final j0 b, final u<? super T> a) {
        o.g((Object)b, "scope");
        o.g((Object)a, "channel");
        this.a = (u<T>)a;
        this.b = b;
    }
    
    public boolean A() {
        return this.a.A();
    }
    
    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }
    
    @Override
    public Object h(a<r> l$0, c<? super r> a) {
        SimpleProducerScopeImpl$awaitClose.SimpleProducerScopeImpl$awaitClose$1 simpleProducerScopeImpl$awaitClose$1 = null;
        Label_0049: {
            if (a instanceof SimpleProducerScopeImpl$awaitClose.SimpleProducerScopeImpl$awaitClose$1) {
                simpleProducerScopeImpl$awaitClose$1 = (SimpleProducerScopeImpl$awaitClose.SimpleProducerScopeImpl$awaitClose$1)a;
                final int label = simpleProducerScopeImpl$awaitClose$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    simpleProducerScopeImpl$awaitClose$1.label = label + Integer.MIN_VALUE;
                    break Label_0049;
                }
            }
            simpleProducerScopeImpl$awaitClose$1 = new SimpleProducerScopeImpl$awaitClose.SimpleProducerScopeImpl$awaitClose$1(this, (c)a);
        }
        final Object result = simpleProducerScopeImpl$awaitClose$1.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = simpleProducerScopeImpl$awaitClose$1.label;
        Label_0114: {
            if (label2 == 0) {
                break Label_0114;
            }
            Label_0104: {
                if (label2 != 1) {
                    break Label_0104;
                }
                final q1 q1 = (q1)simpleProducerScopeImpl$awaitClose$1.L$1;
                l$0 = (a = (a)simpleProducerScopeImpl$awaitClose$1.L$0);
                try {
                    k.b(result);
                    Label_0265: {
                        return r.a;
                    }
                    Label_0276:
                    a = l$0;
                    a = l$0;
                    final IllegalStateException ex = new IllegalStateException("Internal error, context should have a job.".toString());
                    a = l$0;
                    throw ex;
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    Object v = null;
                Label_0255:
                    while (true) {
                        a = l$0;
                        final CoroutineContext$a value;
                        final q1 l$2 = (q1)value;
                        a = l$0;
                        simpleProducerScopeImpl$awaitClose$1.L$0 = l$0;
                        a = l$0;
                        simpleProducerScopeImpl$awaitClose$1.L$1 = l$2;
                        a = l$0;
                        simpleProducerScopeImpl$awaitClose$1.label = 1;
                        a = l$0;
                        a = l$0;
                        final kotlinx.coroutines.o o = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.a.c((c)simpleProducerScopeImpl$awaitClose$1), 1);
                        a = l$0;
                        o.z();
                        a = l$0;
                        a = l$0;
                        final SimpleProducerScopeImpl$awaitClose$2.SimpleProducerScopeImpl$awaitClose$2$1 simpleProducerScopeImpl$awaitClose$2$1 = new SimpleProducerScopeImpl$awaitClose$2.SimpleProducerScopeImpl$awaitClose$2$1((n)o);
                        a = l$0;
                        l$2.i((l)simpleProducerScopeImpl$awaitClose$2$1);
                        a = l$0;
                        v = o.v();
                        a = l$0;
                        iftrue(Label_0255:)(v != kotlin.coroutines.intrinsics.a.d());
                        a = l$0;
                        f.c((c)simpleProducerScopeImpl$awaitClose$1);
                        break Label_0255;
                        k.b(result);
                        a = l$0;
                        value = this.getCoroutineContext().get((CoroutineContext$b)kotlinx.coroutines.q1.u);
                        iftrue(Label_0276:)(value == null);
                        continue;
                    }
                    iftrue(Label_0265:)(v != d);
                    return d;
                }
                finally {
                    a.invoke();
                }
            }
        }
    }
    
    public boolean x(final Throwable t) {
        return this.a.x(t);
    }
    
    public void y(final l<? super Throwable, r> l) {
        o.g((Object)l, "handler");
        this.a.y((l)l);
    }
    
    public Object z(final T t, final c<? super r> c) {
        return this.a.z((Object)t, (c)c);
    }
}
