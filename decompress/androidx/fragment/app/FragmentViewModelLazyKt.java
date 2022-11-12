// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.lifecycle.n0;
import kotlin.jvm.internal.o;
import androidx.lifecycle.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import sa.a;
import kotlin.reflect.d;
import androidx.lifecycle.r0;
import ka.j;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aZ\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0007¨\u0006\u0010²\u0006\u0018\u0010\u000f\u001a\u00020\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u000f\u001a\u00020\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002" }, d2 = { "Landroidx/lifecycle/l0;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/reflect/d;", "viewModelClass", "Lkotlin/Function0;", "Landroidx/lifecycle/q0;", "storeProducer", "Lk0/a;", "extrasProducer", "Landroidx/lifecycle/o0$b;", "factoryProducer", "Lka/j;", "b", "Landroidx/lifecycle/r0;", "owner", "fragment-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class FragmentViewModelLazyKt
{
    public static final r0 a(final j j) {
        return c((j<? extends r0>)j);
    }
    
    public static final <VM extends l0> j<VM> b(final Fragment fragment, final d<VM> d, final a<? extends q0> a, final a<? extends k0.a> a2, final a<? extends o0.b> a3) {
        o.g((Object)fragment, "<this>");
        o.g((Object)d, "viewModelClass");
        o.g((Object)a, "storeProducer");
        o.g((Object)a2, "extrasProducer");
        Object o = a3;
        if (a3 == null) {
            o = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return (j<VM>)new n0((kotlin.reflect.d<l0>)d, a, (a<? extends o0.b>)o, a2);
    }
    
    private static final r0 c(final j<? extends r0> j) {
        return (r0)j.getValue();
    }
}
