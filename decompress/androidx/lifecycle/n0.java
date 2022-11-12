// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.jvm.internal.o;
import sa.a;
import kotlin.reflect.d;
import kotlin.Metadata;
import ka.j;

@Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BC\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\r¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0016" }, d2 = { "Landroidx/lifecycle/n0;", "Landroidx/lifecycle/l0;", "VM", "Lka/j;", "Lkotlin/reflect/d;", "a", "Lkotlin/reflect/d;", "viewModelClass", "e", "Landroidx/lifecycle/l0;", "cached", "()Landroidx/lifecycle/l0;", "value", "Lkotlin/Function0;", "Landroidx/lifecycle/q0;", "storeProducer", "Landroidx/lifecycle/o0$b;", "factoryProducer", "Lk0/a;", "extrasProducer", "<init>", "(Lkotlin/reflect/d;Lsa/a;Lsa/a;Lsa/a;)V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public final class n0<VM extends l0> implements j<VM>
{
    private final d<VM> a;
    private final a<q0> b;
    private final a<o0.b> c;
    private final a<k0.a> d;
    private VM e;
    
    public n0(final d<VM> a, final a<? extends q0> b, final a<? extends o0.b> c, final a<? extends k0.a> d) {
        o.g((Object)a, "viewModelClass");
        o.g((Object)b, "storeProducer");
        o.g((Object)c, "factoryProducer");
        o.g((Object)d, "extrasProducer");
        this.a = a;
        this.b = (a<q0>)b;
        this.c = (a<o0.b>)c;
        this.d = (a<k0.a>)d;
    }
    
    public VM a() {
        l0 e;
        if ((e = this.e) == null) {
            e = new o0((q0)this.b.invoke(), (o0.b)this.c.invoke(), (k0.a)this.d.invoke()).a((Class<VM>)ra.a.b((d)this.a));
            this.e = (VM)e;
        }
        return (VM)e;
    }
    
    public /* bridge */ Object getValue() {
        return this.a();
    }
}
