// 
// Decompiled by Procyon v0.6.0
// 

package k0;

import java.util.Arrays;
import java.util.Objects;
import androidx.lifecycle.o0;
import kotlin.jvm.internal.o;
import androidx.lifecycle.l0;
import sa.l;
import kotlin.reflect.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006J\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u000f" }, d2 = { "Lk0/c;", "", "Landroidx/lifecycle/l0;", "T", "Lkotlin/reflect/d;", "clazz", "Lkotlin/Function1;", "Lk0/a;", "initializer", "Lka/r;", "a", "Landroidx/lifecycle/o0$b;", "b", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public final class c
{
    private final List<f<?>> a;
    
    public c() {
        this.a = new ArrayList<f<?>>();
    }
    
    public final <T extends l0> void a(final d<T> d, final l<? super a, ? extends T> l) {
        o.g((Object)d, "clazz");
        o.g((Object)l, "initializer");
        this.a.add(new f<Object>(ra.a.b((d)d), l));
    }
    
    public final o0.b b() {
        final f[] array = this.a.toArray(new f[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final f[] array2 = array;
        return new b((f<?>[])Arrays.copyOf(array2, array2.length));
    }
}
