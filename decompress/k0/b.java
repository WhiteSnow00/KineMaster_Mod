// 
// Decompiled by Procyon v0.6.0
// 

package k0;

import androidx.lifecycle.l0;
import kotlin.jvm.internal.o;
import kotlin.Metadata;
import androidx.lifecycle.o0;

@Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u000f" }, d2 = { "Lk0/b;", "Landroidx/lifecycle/o0$b;", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "Lk0/a;", "extras", "b", "(Ljava/lang/Class;Lk0/a;)Landroidx/lifecycle/l0;", "", "Lk0/f;", "initializers", "<init>", "([Lk0/f;)V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public final class b implements o0.b
{
    private final f<?>[] b;
    
    public b(final f<?>... b) {
        o.g((Object)b, "initializers");
        this.b = b;
    }
    
    @Override
    public <T extends l0> T b(final Class<T> clazz, final k0.a a) {
        o.g((Object)clazz, "modelClass");
        o.g((Object)a, "extras");
        final f<?>[] b = this.b;
        final int length = b.length;
        int i = 0;
        l0 l0 = null;
        while (i < length) {
            final f<?> f = b[i];
            if (o.b((Object)f.a(), (Object)clazz)) {
                final Object invoke = f.b().invoke((Object)a);
                if (invoke instanceof l0) {
                    l0 = (T)invoke;
                }
                else {
                    l0 = null;
                }
            }
            ++i;
        }
        if (l0 != null) {
            return (T)l0;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No initializer set for given class ");
        sb.append(clazz.getName());
        throw new IllegalArgumentException(sb.toString());
    }
}
