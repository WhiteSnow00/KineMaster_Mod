// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.util.Objects;
import java.util.Arrays;
import java.lang.reflect.Method;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import sa.a;
import kotlin.reflect.d;
import kotlin.Metadata;
import ka.j;

@Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0012" }, d2 = { "Landroidx/navigation/f;", "Landroidx/navigation/e;", "Args", "Lka/j;", "Lkotlin/reflect/d;", "a", "Lkotlin/reflect/d;", "navArgsClass", "c", "Landroidx/navigation/e;", "cached", "()Landroidx/navigation/e;", "value", "Lkotlin/Function0;", "Landroid/os/Bundle;", "argumentProducer", "<init>", "(Lkotlin/reflect/d;Lsa/a;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class f<Args extends e> implements j<Args>
{
    private final d<Args> a;
    private final a<Bundle> b;
    private Args c;
    
    public f(final d<Args> a, final a<Bundle> b) {
        o.g((Object)a, "navArgsClass");
        o.g((Object)b, "argumentProducer");
        this.a = a;
        this.b = b;
    }
    
    public Args a() {
        e c;
        if ((c = this.c) == null) {
            final Bundle bundle = (Bundle)this.b.invoke();
            Method method;
            if ((method = g.a().get(this.a)) == null) {
                final Class b = ra.a.b((d)this.a);
                final Class<Bundle>[] b2 = g.b();
                method = b.getMethod("fromBundle", (Class[])Arrays.copyOf(b2, b2.length));
                g.a().put(this.a, method);
                o.f((Object)method, "navArgsClass.java.getMet\u2026hod\n                    }");
            }
            final Object invoke = method.invoke(null, bundle);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
            c = (Args)invoke;
            this.c = (Args)c;
        }
        return (Args)c;
    }
    
    public /* bridge */ Object getValue() {
        return this.a();
    }
}
