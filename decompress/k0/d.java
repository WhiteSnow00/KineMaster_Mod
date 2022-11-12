// 
// Decompiled by Procyon v0.6.0
// 

package k0;

import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e" }, d2 = { "Lk0/d;", "Lk0/a;", "T", "Lk0/a$b;", "key", "t", "Lka/r;", "c", "(Lk0/a$b;Ljava/lang/Object;)V", "a", "(Lk0/a$b;)Ljava/lang/Object;", "initialExtras", "<init>", "(Lk0/a;)V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public final class d extends a
{
    public d() {
        this(null, 1, null);
    }
    
    public d(final a a) {
        o.g((Object)a, "initialExtras");
        this.b().putAll(a.b());
    }
    
    public d(a b, final int n, final i i) {
        if ((n & 0x1) != 0x0) {
            b = k0.a.a.b;
        }
        this(b);
    }
    
    @Override
    public <T> T a(final b<T> b) {
        o.g((Object)b, "key");
        return (T)this.b().get(b);
    }
    
    public final <T> void c(final b<T> b, final T t) {
        o.g((Object)b, "key");
        this.b().put((b<?>)b, t);
    }
}
