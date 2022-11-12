// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import k0.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import androidx.lifecycle.q0;
import java.util.Map;
import androidx.lifecycle.o0;
import kotlin.Metadata;
import androidx.lifecycle.l0;

@Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012" }, d2 = { "Landroidx/navigation/j;", "Landroidx/lifecycle/l0;", "Landroidx/navigation/u;", "", "backStackEntryId", "Lka/r;", "j", "onCleared", "Landroidx/lifecycle/q0;", "g", "toString", "", "a", "Ljava/util/Map;", "viewModelStores", "<init>", "()V", "b", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public final class j extends l0 implements u
{
    public static final b b;
    private static final o0.b c;
    private final Map<String, q0> a;
    
    static {
        b = new b(null);
        c = new o0.b() {
            @Override
            public <T extends l0> T a(final Class<T> clazz) {
                o.g((Object)clazz, "modelClass");
                return (T)new j();
            }
        };
    }
    
    public j() {
        this.a = new LinkedHashMap<String, q0>();
    }
    
    public static final o0.b h() {
        return j.c;
    }
    
    @Override
    public q0 g(final String s) {
        o.g((Object)s, "backStackEntryId");
        q0 q0;
        if ((q0 = this.a.get(s)) == null) {
            q0 = new q0();
            this.a.put(s, q0);
        }
        return q0;
    }
    
    public final void j(final String s) {
        o.g((Object)s, "backStackEntryId");
        final q0 q0 = this.a.remove(s);
        if (q0 != null) {
            q0.a();
        }
    }
    
    @Override
    protected void onCleared() {
        final Iterator<q0> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
        this.a.clear();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        final Iterator<String> iterator = this.a.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        final String string = sb.toString();
        o.f((Object)string, "sb.toString()");
        return string;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b" }, d2 = { "Landroidx/navigation/j$b;", "", "Landroidx/lifecycle/q0;", "viewModelStore", "Landroidx/navigation/j;", "a", "Landroidx/lifecycle/o0$b;", "FACTORY", "Landroidx/lifecycle/o0$b;", "<init>", "()V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class b
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
        
        public final j a(final q0 q0) {
            o.g((Object)q0, "viewModelStore");
            return new o0(q0, j.h(), null, 4, null).a(j.class);
        }
    }
}
