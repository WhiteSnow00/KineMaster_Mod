// 
// Decompiled by Procyon v0.6.0
// 

package k0;

import kotlin.jvm.internal.o;
import sa.l;
import kotlin.Metadata;
import androidx.lifecycle.l0;

@Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011" }, d2 = { "Lk0/f;", "Landroidx/lifecycle/l0;", "T", "", "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "Lkotlin/Function1;", "Lk0/a;", "initializer", "Lsa/l;", "b", "()Lsa/l;", "<init>", "(Ljava/lang/Class;Lsa/l;)V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public final class f<T extends l0>
{
    private final Class<T> a;
    private final l<a, T> b;
    
    public f(final Class<T> a, final l<? super a, ? extends T> b) {
        o.g((Object)a, "clazz");
        o.g((Object)b, "initializer");
        this.a = a;
        this.b = (l<a, T>)b;
    }
    
    public final Class<T> a() {
        return this.a;
    }
    
    public final l<a, T> b() {
        return this.b;
    }
}
