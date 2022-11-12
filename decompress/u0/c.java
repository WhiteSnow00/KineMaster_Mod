// 
// Decompiled by Procyon v0.6.0
// 

package u0;

import androidx.lifecycle.q;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import kotlin.jvm.internal.i;
import androidx.savedstate.Recreator;
import android.os.Bundle;
import j.b;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001a\u0005\nB\t\b\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007¨\u0006\u001b" }, d2 = { "Lu0/c;", "", "", "key", "Landroid/os/Bundle;", "b", "Lu0/c$c;", "provider", "Lka/r;", "h", "c", "Ljava/lang/Class;", "Lu0/c$a;", "clazz", "i", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "e", "(Landroidx/lifecycle/Lifecycle;)V", "savedState", "f", "(Landroid/os/Bundle;)V", "outBundle", "g", "<init>", "()V", "a", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class c
{
    private static final b g;
    private final j.b<String, c> a;
    private boolean b;
    private Bundle c;
    private boolean d;
    private Recreator.b e;
    private boolean f;
    
    static {
        g = new b(null);
    }
    
    public c() {
        this.a = new j.b<String, c>();
        this.f = true;
    }
    
    public static void a(final c c, final r r, final Lifecycle.Event event) {
        d(c, r, event);
    }
    
    private static final void d(final c c, final r r, final Lifecycle.Event event) {
        o.g((Object)c, "this$0");
        o.g((Object)r, "<anonymous parameter 0>");
        o.g((Object)event, "event");
        if (event == Lifecycle.Event.ON_START) {
            c.f = true;
        }
        else if (event == Lifecycle.Event.ON_STOP) {
            c.f = false;
        }
    }
    
    public final Bundle b(final String s) {
        o.g((Object)s, "key");
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        final Bundle c = this.c;
        if (c != null) {
            Bundle bundle;
            if (c != null) {
                bundle = c.getBundle(s);
            }
            else {
                bundle = null;
            }
            final Bundle c2 = this.c;
            if (c2 != null) {
                c2.remove(s);
            }
            final Bundle c3 = this.c;
            int n = 0;
            if (c3 != null) {
                n = n;
                if (!c3.isEmpty()) {
                    n = 1;
                }
            }
            if (n == 0) {
                this.c = null;
            }
            return bundle;
        }
        return null;
    }
    
    public final c c(final String s) {
        o.g((Object)s, "key");
        for (final Map.Entry<String, V> entry : this.a) {
            o.f((Object)entry, "components");
            final String s2 = entry.getKey();
            final c c = (c)entry.getValue();
            if (o.b((Object)s2, (Object)s)) {
                return c;
            }
        }
        return null;
    }
    
    public final void e(final Lifecycle lifecycle) {
        o.g((Object)lifecycle, "lifecycle");
        if (this.b ^ true) {
            lifecycle.a((q)new u0.b(this));
            this.b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }
    
    public final void f(Bundle bundle) {
        if (!this.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (this.d ^ true) {
            if (bundle != null) {
                bundle = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            else {
                bundle = null;
            }
            this.c = bundle;
            this.d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    }
    
    public final void g(final Bundle bundle) {
        o.g((Object)bundle, "outBundle");
        final Bundle bundle2 = new Bundle();
        final Bundle c = this.c;
        if (c != null) {
            bundle2.putAll(c);
        }
        final j.b.d e = this.a.e();
        o.f((Object)e, "this.components.iteratorWithAdditions()");
        while (e.hasNext()) {
            final Map.Entry<String, V> entry = ((Iterator<Map.Entry<String, V>>)e).next();
            bundle2.putBundle((String)entry.getKey(), ((c)entry.getValue()).saveState());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
    
    public final void h(final String s, final c c) {
        o.g((Object)s, "key");
        o.g((Object)c, "provider");
        if (this.a.k(s, c) == null) {
            return;
        }
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    }
    
    public final void i(Class<? extends a> name) {
        o.g((Object)name, "clazz");
        if (this.f) {
            Recreator.b e;
            if ((e = this.e) == null) {
                e = new Recreator.b(this);
            }
            this.e = e;
            try {
                ((Class)name).getDeclaredConstructor((Class[])new Class[0]);
                final Recreator.b e2 = this.e;
                if (e2 != null) {
                    name = ((Class)name).getName();
                    o.f((Object)name, "clazz.name");
                    e2.a(name);
                }
                return;
            }
            catch (final NoSuchMethodException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Class ");
                sb.append(((Class)name).getSimpleName());
                sb.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(sb.toString(), ex);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006" }, d2 = { "Lu0/c$a;", "", "Lu0/e;", "owner", "Lka/r;", "a", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public interface a
    {
        void a(final e p0);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Lu0/c$b;", "", "", "SAVED_COMPONENTS_KEY", "Ljava/lang/String;", "<init>", "()V", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class b
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004" }, d2 = { "Lu0/c$c;", "", "Landroid/os/Bundle;", "saveState", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public interface c
    {
        Bundle saveState();
    }
}
