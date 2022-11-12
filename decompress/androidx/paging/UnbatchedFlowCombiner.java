// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.o0;
import ka.k;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.y;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.w;
import kotlin.coroutines.c;
import sa.r;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B:\u0012.\u0010\u001c\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f" }, d2 = { "Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "", "index", "value", "Lka/r;", "a", "(ILjava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/w;", "b", "Lkotlinx/coroutines/w;", "initialDispatched", "Lkotlinx/coroutines/sync/c;", "c", "Lkotlinx/coroutines/sync/c;", "lock", "", "d", "[Lkotlinx/coroutines/w;", "valueReceived", "e", "[Ljava/lang/Object;", "values", "Lkotlin/Function4;", "Landroidx/paging/CombineSource;", "Lkotlin/coroutines/c;", "send", "<init>", "(Lsa/r;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class UnbatchedFlowCombiner<T1, T2>
{
    private final r<T1, T2, CombineSource, c<? super ka.r>, Object> a;
    private final w<ka.r> b;
    private final kotlinx.coroutines.sync.c c;
    private final w<ka.r>[] d;
    private final Object[] e;
    
    public UnbatchedFlowCombiner(final r<? super T1, ? super T2, ? super CombineSource, ? super c<? super ka.r>, ?> a) {
        o.g((Object)a, "send");
        this.a = (r<T1, T2, CombineSource, c<? super ka.r>, Object>)a;
        this.b = (w<ka.r>)y.b((q1)null, 1, (Object)null);
        final int n = 0;
        this.c = kotlinx.coroutines.sync.d.b(false, 1, (Object)null);
        final w[] d = new w[2];
        for (int i = 0; i < 2; ++i) {
            d[i] = y.b((q1)null, 1, (Object)null);
        }
        this.d = (w<ka.r>[])d;
        final Object[] e = new Object[2];
        for (int j = n; j < 2; ++j) {
            e[j] = FlowExtKt.a();
        }
        this.e = e;
    }
    
    public final Object a(int n, Object l$1, final c<? super ka.r> c) {
        UnbatchedFlowCombiner$onNext.UnbatchedFlowCombiner$onNext$1 unbatchedFlowCombiner$onNext$1 = null;
        Label_0052: {
            if (c instanceof UnbatchedFlowCombiner$onNext.UnbatchedFlowCombiner$onNext$1) {
                unbatchedFlowCombiner$onNext$1 = (UnbatchedFlowCombiner$onNext.UnbatchedFlowCombiner$onNext$1)c;
                final int label = unbatchedFlowCombiner$onNext$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    unbatchedFlowCombiner$onNext$1.label = label + Integer.MIN_VALUE;
                    break Label_0052;
                }
            }
            unbatchedFlowCombiner$onNext$1 = new UnbatchedFlowCombiner$onNext.UnbatchedFlowCombiner$onNext$1(this, (c)c);
        }
        final Object result = unbatchedFlowCombiner$onNext$1.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = unbatchedFlowCombiner$onNext$1.label;
        Object o3 = null;
        Label_0353: {
            UnbatchedFlowCombiner l$3;
            Object l$4;
            while (true) {
                UnbatchedFlowCombiner l$2 = null;
                Label_0289: {
                    if (label2 == 0) {
                        k.b(result);
                        if (((q1)this.d[n]).L()) {
                            final w<ka.r> b = this.b;
                            unbatchedFlowCombiner$onNext$1.L$0 = this;
                            unbatchedFlowCombiner$onNext$1.L$1 = l$1;
                            unbatchedFlowCombiner$onNext$1.I$0 = n;
                            unbatchedFlowCombiner$onNext$1.label = 1;
                            if (((o0)b).l((c)unbatchedFlowCombiner$onNext$1) == d) {
                                return d;
                            }
                        }
                        else {
                            this.d[n].E((Object)ka.r.a);
                        }
                        l$2 = this;
                        break Label_0289;
                    }
                    if (label2 == 1) {
                        n = unbatchedFlowCombiner$onNext$1.I$0;
                        l$1 = unbatchedFlowCombiner$onNext$1.L$1;
                        l$2 = (UnbatchedFlowCombiner)unbatchedFlowCombiner$onNext$1.L$0;
                        k.b(result);
                        break Label_0289;
                    }
                    if (label2 != 2) {
                        if (label2 == 3) {
                            final kotlinx.coroutines.sync.c c2 = (kotlinx.coroutines.sync.c)unbatchedFlowCombiner$onNext$1.L$1;
                            l$3 = (UnbatchedFlowCombiner)unbatchedFlowCombiner$onNext$1.L$0;
                            l$1 = c2;
                            try {
                                k.b(result);
                                break Label_0353;
                            }
                            finally {
                                break Label_0353;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n = unbatchedFlowCombiner$onNext$1.I$0;
                    l$1 = unbatchedFlowCombiner$onNext$1.L$2;
                    l$4 = unbatchedFlowCombiner$onNext$1.L$1;
                    l$2 = (UnbatchedFlowCombiner)unbatchedFlowCombiner$onNext$1.L$0;
                    k.b(result);
                    l$3 = l$2;
                    break Label_0353;
                }
                final kotlinx.coroutines.sync.c c3 = l$2.c;
                unbatchedFlowCombiner$onNext$1.L$0 = l$2;
                unbatchedFlowCombiner$onNext$1.L$1 = l$1;
                unbatchedFlowCombiner$onNext$1.L$2 = c3;
                unbatchedFlowCombiner$onNext$1.I$0 = n;
                unbatchedFlowCombiner$onNext$1.label = 2;
                if (c3.a((Object)null, (c)unbatchedFlowCombiner$onNext$1) == d) {
                    return d;
                }
                l$4 = l$1;
                l$1 = c3;
                continue;
            }
            try {
                final Object[] e = l$3.e;
                while (true) {
                    for (int length = e.length, i = 0; i < length; ++i) {
                        if (e[i] == FlowExtKt.a()) {
                            final boolean b2 = true;
                            final Object[] e2 = l$3.e;
                            e2[n] = l$4;
                            while (true) {
                                for (int length2 = e2.length, j = 0; j < length2; ++j) {
                                    if (e2[j] == FlowExtKt.a()) {
                                        final boolean b3 = false;
                                        if (b3) {
                                            CombineSource combineSource;
                                            if (b2) {
                                                combineSource = CombineSource.INITIAL;
                                            }
                                            else if (n == 0) {
                                                combineSource = CombineSource.RECEIVER;
                                            }
                                            else {
                                                combineSource = CombineSource.OTHER;
                                            }
                                            final r<T1, T2, CombineSource, c<? super ka.r>, Object> a = l$3.a;
                                            final Object[] e3 = l$3.e;
                                            final Object o = e3[0];
                                            final Object o2 = e3[1];
                                            unbatchedFlowCombiner$onNext$1.L$0 = l$3;
                                            unbatchedFlowCombiner$onNext$1.L$1 = l$1;
                                            unbatchedFlowCombiner$onNext$1.L$2 = null;
                                            unbatchedFlowCombiner$onNext$1.label = 3;
                                            if (a.invoke(o, o2, (Object)combineSource, (Object)unbatchedFlowCombiner$onNext$1) == d) {
                                                return d;
                                            }
                                            o3 = l$1;
                                            l$1 = o3;
                                            l$3.b.E((Object)ka.r.a);
                                        }
                                        else {
                                            o3 = l$1;
                                        }
                                        l$1 = o3;
                                        final ka.r a2 = ka.r.a;
                                        ((kotlinx.coroutines.sync.c)o3).b((Object)null);
                                        return a2;
                                    }
                                }
                                final boolean b3 = true;
                                continue;
                            }
                        }
                    }
                    final boolean b2 = false;
                    continue;
                }
            }
            finally {}
        }
        ((kotlinx.coroutines.sync.c)l$1).b((Object)null);
        throw o3;
    }
}
